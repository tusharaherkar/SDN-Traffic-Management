# SDN_traffic_management
The project consists of OpenDayLight (Carbon/Nitrogen Distribution) RESTful api calls for managing traffic using Software Defined Networks.

The project demonstraited detailed steps to follow for **_traffic management between three hosts_** 

## Files
#### MidsemDemoReport: 
It includes detailed report of progress of project upto mid semester which includes installation of required softwares, setting up topology using mininet and OpenDaylight Controller and testing the topology.

#### Final_Project_Report: 
It contains the detailed project report starting from building and testing network topology to traffic shaping using mainly two methods- manual commands on Open Vswitch and RESTconf API provided by OpenDayLight Controller.

#### SDN_JAVA
JAVA project used to call RESTConf API call to automate process of traffic shaping without use of POSTMAN

##### hints_raw_steps
This file consists of raw steps explored while developing the project.
 
## Dependencies
#### Install following packages on ubuntu
1) karaf-0.6.1-Carbon.tar OR karaf 0.7.0
2) jdk-8u144-linux-x64.tar
3) mininet-2.2.2-170321-ubuntu-14.04.4-server-amd64
4) openvswitch-2.8.1.tar
5) postman.tar

## Conclusion

1) Experimented and built various network topologies using mininet emulator to generate traffic and understand its behaviour.
2) Successfully  shaped  traffic according to network requirements using mainly two methods- manual commands on Open Vswitch and RESTConf API provided by OpenDayLight Controller
3) Automated process of calling the RESTConf API calls using java program to shape the traffic flow between the hosts for given requirements of network.
Technologies Used: OpenDaylight Controller, mininet, Postman, JAVA

## References 

#### Setting up mininet
1) http://www.brianlinkletter.com/using-the-opendaylight-sdn-controller-with-the-mininet-network-emulator/
2) http://www.brianlinkletter.com/set-up-mininet/
3) http://www.brianlinkletter.com/how-to-use-miniedit-mininets-graphical-user-interface/

#### Open V switch Commands
1) http://openvswitch.org/support/dist-docs/ovs-ofctl.8.txt
2) https://github.com/opendaylight/ovsdb/blob/stable/boron/resources/commons/Qos-and-Queue-Collection.json.postman_collection