Boot de um PenDrive com Ubuntu 22.04

inicia a máquina
ativa as bibliotecas no app software and Update

sudo apt update
sudo apt install minicom

sudo minicom -s -c on
            +-----[configuration]------+
            | Filenames and paths      |
            | File transfer protocols  |
            | Serial port setup        |
            | Modem and dialing        |
            | Screen and keyboard      |
            | Save setup as dfl        |
            | Save setup as..          |
            | Exit                     |
            | Exit from Minicom        |
            +--------------------------+
configurações usadas
+-----------------------------------------------------------------------+
    | A -    Serial Device      : /dev/ttyS0                                |
    | B - Lockfile Location     : /var/lock                                 |
    | C -   Callin Program      :                                           |
    | D -  Callout Program      :                                           |
    | E -    Bps/Par/Bits       : 9600 8N1                                  |
    | F - Hardware Flow Control : No                                        |
    | G - Software Flow Control : No                                        |
    | H -     RS485 Enable      : No                                        |
    | I -   RS485 Rts On Send   : No                                        |
    | J -  RS485 Rts After Send : No                                        |
    | K -  RS485 Rx During Tx   : No                                        |
    | L -  RS485 Terminate Bus  : No                                        |
    | M - RS485 Delay Rts Before: 0                                         |
    | N - RS485 Delay Rts After : 0                                         |
    |                                                                       |
    |    Change which setting?                                              |
    +-----------------------------------------------------------------------+

login grpadmin
password grpadmin

configuramos ip estático para o storage, tanto interface de gerência quanto interface de dados

ps4100mng
192.168.1.82
ps4100data
172.17.1.82


           Welcome to Group Manager

        Copyright 2001-2014 Dell Inc.



563:2:netmgtd:21-Nov-2023 01:55:08.490002:rcc_util.c:1024:INFO::25.2.9:CLI: Log.
It appears that the storage array has not been configured. 
Would you like to configure the array now ? (y/n) [n]

y

                Group Manager Setup Utility


 The setup utility establishes the initial network and storage
 configuration for a storage array and then configures the array
 as a member of a new or existing group of arrays.

    For help, enter a question mark (?) at a prompt.



   The battery is not completely charged. It is recommended that
   you wait until the battery is completely charged before running setup.
