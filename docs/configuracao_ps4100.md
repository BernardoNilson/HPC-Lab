# Instalação e configuração do Storage Equal Logic PS4100 da Dell ao ProxMox

> Manual do EqualLogic PS4100: [https://dl.dell.com/manuals/all-products/esuprt_ser_stor_net/esuprt_equallogic/equallogic-ps4100x_setup-guide_en-us.pdf](https://dl.dell.com/manuals/all-products/esuprt_ser_stor_net/esuprt_equallogic/equallogic-ps4100x_setup-guide_en-us.pdf)

Estamos configurando em uma máquina qualquer com o "Try Ubuntu 22.04"

Precisamos ativar as bibliotecas no app "Software and Update"



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
            
Usamos as seguintes configurações:

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

Acesso padrão ao Storage, segundo o manual:
- login: grpadmin
- password: grpadmin

Nas configurações de rede do LAD: configuramos dois IPs estáticos para o storage:
- ps4100mgt: 192.168.1.82 - Gerência do Storage 
- ps4100data: 172.17.1.82 - RAID de dados
    
~~~
           Welcome to Group Manager

        Copyright 2001-2014 Dell Inc.


netmgtd:1700722419.77:rcc_util.c:1024:INFO:25.2.9:CLI: Login to account grpadmin succeeded, using lo.
netmgtd:1700722419.77:rcc_util.c:1032:AUDIT:25.7.0:CLI: Login to account grpadmin succeeded, using l.

It appears that the storage array has not been configured. 
Would you like to configure the array now ? (y/n) [n]y


                Group Manager Setup Utility


 The setup utility establishes the initial network and storage
 configuration for a storage array and then configures the array
 as a member of a new or existing group of arrays.

    For help, enter a question mark (?) at a prompt.



   The battery is not completely charged. It is recommended that
   you wait until the battery is completely charged before running setup.

   Do you want to proceed (yes | no ) [no]: yes

 Initializing.  This may take several minutes to complete.

 Enter the network configuration for the array.

   Member name []: ps4100mgt
   Network interface [eth0]: 
   IP address for network interface []: 192.168.1.82
   Netmask [255.255.255.0]: 255.255.255.0
   Default gateway [192.168.1.1]: 192.168.1.254

 Initializing interface eth0.  This may take a minute.....

 Enter the IP address and name of the group that the array will join.

   Group name []: ProxGroup
   Group IP address []: 192.168.1.83

 Searching to see if the group exists.  This may take a few minutes.

 The group does not exist or currently cannot be reached. Make sure
 you have entered the correct group IP address and group name.

   Do you want to create a new group (yes | no) [yes]: yes

       Group Configuration

  Group Name:                     ProxGroup
  Group IP address:               192.168.1.83

   Do you want to use the group settings shown above (yes | no) [yes]: y

   Do you want to use the group settings shown above (yes | no) [yes]: y
   Password for managing group membership:
   Retype password for verification:

   Password for the default group administration(grpadmin) account:
   Retype password for verification:


 Saving the configuration...

Waiting for configuration to become active......Done

 Group ProxGroup has been created with one member.
 Use the Group Manager GUI or CLI to set the RAID policy
 for the member.  You can then create a volume which
 a host can connect to using an iSCSI initiator.


 To access the Group Manager GUI, specify http://group_ip_address in
 a Web browser window.  To access the CLI, use telnet or SSH to
 connect to the group IP address from a remote terminal, or attach a
 console terminal directly to a serial port on a group member's
 active control module.  Log in to the default group administration
 account (grpadmin) using the password you specified when creating
 this group. See the Group Administration manual for more
 information.

ProxGroup> 
~~~

## Instalando Java JRE SE 8
[https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
[https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jre-8u241-linux-x64.tar.gz](https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jre-8u241-linux-x64.tar.gz)


Change to the directory in which you want to install. Type:

cd directory_path_name
    
For example, to install the software in the /usr/java/ directory, Type:

cd /usr/java/
    
Move the .tar.gz archive binary to the current directory. Unpack the tarball and install Java

sudo tar zxvf jre-8u241-linux-x64.tar.gz

The Java files are installed in a directory called jre1.8.0_241 in the current directory. In this example, it is installed in the /usr/java/jre1.8.0_241 directory. When the installation has completed, you will see the word Done.
    Delete the .tar.gz file if you want to save disk space.

Set environment variables

ubuntu@ubuntu:/usr/bin/java/jre1.8.0_241$ export JAVA_HOME=/usr/bin/java/jre1.8.0_241
ubuntu@ubuntu:/usr/bin/java/jre1.8.0_241$ export PATH=$JAVA_HOME/bin/:$PATH

ubuntu@ubuntu:/usr/bin/java/jre1.8.0_241$ java -version

    java version "1.8.0_241"
    Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
    Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
    ubuntu@ubuntu:/usr/bin/java/jre1.8.0_241$ 

Os comandos foram adicionamos manualmente de forma temporária, para adicionar ao iniciar o shell adcionei direto no .bashrc

Ao acessar o endereço web http://192.168.2.83/ e cancelar a operação. Podemos lançar como uma aplicação Java, ele baixa um arquivo groupmgr.jnlp

Antes, precisamos adicionar os sites na nossa lista de site sem restrição do Java. Para isso:

/usr/bin/java/jre1.8.0_241$ ./bin/ControlPanel 

Vamos em Security > Edit Site List > Add e colocamos o nosso endereço.

Com o Java SE 8 instalado no compuatador, executamos o seguinte comando javaws `javaws http://192.168.1.83/groupmgr.jnlp`.

## Interface Web - Group Manager

Finalizamos a criação do membro criado com as seguintes opções:

    RAID configuration	[IMG=/images/yellowled16.png] initializing
    RAID policy	RAID 6
    Estimated member capacity	7.82 TB
    Expand group capacity	immediate

ALguns pontos interessantes:
- https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwi28_j41tiCAxWmqZUCHUZrCHEQtwJ6BAgPEAI&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DPBl2N5_QQkM&usg=AOvVaw03Ecxm85O18-pN_tWyy5vL&opi=89978449
- https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwi28_j41tiCAxWmqZUCHUZrCHEQFnoECAwQAQ&url=https%3A%2F%2Fforum.proxmox.com%2Fthreads%2Fproxmox-ve-and-dell-equallogic-storage-iscsi.90872%2F&usg=AOvVaw1dQ3vz-HUyYw5E5CrcMcjp&opi=89978449
- https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjqp_3E19iCAxXxs5UCHatrA5QQFnoECAsQAQ&url=https%3A%2F%2Fcommunity.spiceworks.com%2Ftopic%2F322351-how-to-configure-a-dell-equalogic-ps4100-san&usg=AOvVaw1fc47ai8_4Db6pF63EcTKx&opi=89978449
- https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjqp_3E19iCAxXxs5UCHatrA5QQtwJ6BAgNEAI&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DwY66t_Ut3gU&usg=AOvVaw2g0gBl5IDMknd0TT5WYEFL&opi=89978449

## Executando no meu PC

Assim como os passos anteriores, eu fiz a instalação do pacote jre1.8.0_241 no diretório /usr/java. E descompactei do arquivo.

Sendo assim, para executar a aplicação:
`/usr/java/jre1.8.0_241/bin/javaws http://192.168.1.83/groupmgr.jnlp`

Para me facilitar, coloquei o comando em um arquivo bash oculto.
