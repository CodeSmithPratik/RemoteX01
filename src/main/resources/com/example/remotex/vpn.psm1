function connect-vpn{
    param(
      [Parameter(Mandatory)] [string]$vpnName,
      [Parameter(Mandatory)] [string]$vpnUserName,
      [Parameter(Mandatory)] [string]$vpnPassword,
      [Parameter(Mandatory)] [string]$vpnServerAddress,
      [Parameter(Mandatory)] [string]$vpnprotocol,
      [Parameter(Mandatory=$false)] [string]$shared_secret
    )
    if ($vpnprotocol -eq 'pptp'){
        Add-VpnConnection -Name $vpnName -ServerAddress $vpnServerAddress -TunnelType Pptp `
                   -EncryptionLevel Required -PassThru
    }
    else {
        Add-VpnConnection -Name $vpnName -ServerAddress $vpnServerAddress -TunnelType L2tp `
                   -EncryptionLevel Required -PassThru -L2tpPsk $shared_secret -Confirm:$false -Force
    }

    $cmd = $env:WINDIR + "\System32\rasdial.exe"
    $expression = "$cmd ""$vpnName"" $vpnUserName $vpnPassword"
    Invoke-Expression -Command $expression

}

function disconnect-vpn{
    param(
      [Parameter(Mandatory)] [string]$vpnName
    )
    $vpn = Get-VpnConnection -Name $vpnName

    if($vpn.ConnectionStatus -eq "Connected"){
      rasdial $vpnName /DISCONNECT;
    }
    $vpn | Remove-VpnConnection -Force -Confirm:$false
}

