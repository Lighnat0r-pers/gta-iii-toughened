// Put all initialization code related to objects here
:SETUP_DYNAMIC_OBJECTS
029B: $PORTLAND_HIDEOUT_DOOR = init_object #PLAYERSDOOR at 890.875 -307.6875 8.75 
01C7: remove_object_from_mission_cleanup_list $PORTLAND_HIDEOUT_DOOR 
029B: $FAKETARGET1 = init_object #FAKETARGET at 1078.688 -384.75 15.375 
01C7: remove_object_from_mission_cleanup_list $FAKETARGET1 
029B: $FAKETARGET2 = init_object #FAKETARGET at 1080.5 -384.75 15.375 
01C7: remove_object_from_mission_cleanup_list $FAKETARGET2 
029B: $FAKETARGET3 = init_object #FAKETARGET at 1082.25 -384.75 15.375 
01C7: remove_object_from_mission_cleanup_list $FAKETARGET3 
029B: $MISTY_DOOR1 = init_object #MISTYDOOR at 945.625 -272.25 4.8125 
01C7: remove_object_from_mission_cleanup_list $MISTY_DOOR1 
029B: $MISTY_DOOR2 = init_object #MISTYDOOR at 942.6875 -273.6875 4.8125 
01C7: remove_object_from_mission_cleanup_list $MISTY_DOOR2 
0177: set_object $MISTY_DOOR2 z_angle_to 180.0 
029B: $LAUNDRY_DOOR1 = init_object #LAUNDRTDOOR1 at 845.75 -662.75 15.0625 
01C7: remove_object_from_mission_cleanup_list $LAUNDRY_DOOR1 
029B: $LAUNDRY_DOOR2 = init_object #LAUNDRTDOOR1 at 845.75 -664.8125 15.0625 
01C7: remove_object_from_mission_cleanup_list $LAUNDRY_DOOR2 
0177: set_object $LAUNDRY_DOOR2 z_angle_to 180.0 
029B: $JOEY_DOOR1 = init_object #JOEY_DOOR1 at 1192.188 -867.25 14.0625 
01C7: remove_object_from_mission_cleanup_list $JOEY_DOOR1 
0177: set_object $JOEY_DOOR1 z_angle_to 45.0 
029B: $JOEY_DOOR2 = init_object #JOEY_DOOR2 at 1190.063 -869.3125 14.1875 
01C7: remove_object_from_mission_cleanup_list $JOEY_DOOR2 
0177: set_object $JOEY_DOOR2 z_angle_to 45.0 
029B: $DOGFOOD_FACTORY_GATE = init_object #ELECTRICGATE at 1250.375 -812.0 13.9375 
01C7: remove_object_from_mission_cleanup_list $DOGFOOD_FACTORY_GATE 
0177: set_object $DOGFOOD_FACTORY_GATE z_angle_to 225.0 
029B: $DOGFOOD_DOOR = init_object #DOGFOODOOR01 at 1205.25 -802.875 15.0 
01C7: remove_object_from_mission_cleanup_list $DOGFOOD_DOOR 
0177: set_object $DOGFOOD_DOOR z_angle_to 45.0 
029B: $FISH_FACTORY_GATE = init_object #ELECTRICGATE at 1016.0 -1107.938 12.25 
01C7: remove_object_from_mission_cleanup_list $FISH_FACTORY_GATE 
0177: set_object $FISH_FACTORY_GATE z_angle_to 90.0 
029B: $BANKJOB_DOOR = init_object #BANKJOBDOOR at 1087.5 -233.75 11.0 
01C7: remove_object_from_mission_cleanup_list $BANKJOB_DOOR 
029B: $CHINABANK_DOOR1 = init_object #CHNABANKDOOR at 1035.563 -700.75 15.3125 
01C7: remove_object_from_mission_cleanup_list $CHINABANK_DOOR1 
029B: $CHINABANK_DOOR2 = init_object #CHNABANKDOOR at 1035.563 -699.375 15.3125 
01C7: remove_object_from_mission_cleanup_list $CHINABANK_DOOR2 
029B: $LUIGI_BACKDOOR = init_object #BACKDOOR at 891.0 -416.375 14.9375 
01C7: remove_object_from_mission_cleanup_list $LUIGI_BACKDOOR 
029B: $FUZZBALL_DOOR1 = init_object #FUZBALLDOOR at 1001.625 -887.8125 15.75 
0177: set_object $FUZZBALL_DOOR1 z_angle_to 180.0 
01C7: remove_object_from_mission_cleanup_list $FUZZBALL_DOOR1 
029B: $FUZZBALL_DOOR2 = init_object #FUZBALLDOOR at 998.3125 -887.9375 15.75 
0177: set_object $FUZZBALL_DOOR2 z_angle_to 0.0 
01C7: remove_object_from_mission_cleanup_list $FUZZBALL_DOOR2 
029B: $STAUNTON_HIDEOUT_DOOR1 = init_object #PLYSAV_LFTDR_LFT at 103.8125 -482.75 16.25 
01C7: remove_object_from_mission_cleanup_list $STAUNTON_HIDEOUT_DOOR1 
029B: $STAUNTON_HIDEOUT_DOOR2 = init_object #PLYSAV_LFTDR_RGHT at 102.1875 -482.75 16.25 
01C7: remove_object_from_mission_cleanup_list $STAUNTON_HIDEOUT_DOOR2 
0177: set_object $STAUNTON_HIDEOUT_DOOR2 z_angle_to 180.0 
029B: $STAUNTON_POLICE_GATE1 = init_object #ELECTRICGATE at 366.125 -1128.5 21.9375 
01C7: remove_object_from_mission_cleanup_list $STAUNTON_POLICE_GATE1 
0177: set_object $STAUNTON_POLICE_GATE1 z_angle_to 180.0 
029B: $STAUNTON_POLICE_GATE2 = init_object #ELECTRICGATE at 326.25 -1128.5 21.9375 
01C7: remove_object_from_mission_cleanup_list $STAUNTON_POLICE_GATE2 
0177: set_object $STAUNTON_POLICE_GATE2 z_angle_to 180.0 
029B: $STAUNTON_CARTEL_GATE = init_object #ELECTRICGATE at 91.5625 -318.5625 15.25 
01C7: remove_object_from_mission_cleanup_list $STAUNTON_CARTEL_GATE 
0177: set_object $STAUNTON_CARTEL_GATE z_angle_to 270.0 
029B: $PHILS_COMPOUND_GATE = init_object #ELECTRICGATE at 147.1875 207.3125 10.5625 
01C7: remove_object_from_mission_cleanup_list $PHILS_COMPOUND_GATE 
0177: set_object $PHILS_COMPOUND_GATE z_angle_to 270.0 
029B: $SSV_HIDEOUT_DOOR = init_object #NEWTOWERDOOR1 at -664.3125 2.875 19.5 
01C7: remove_object_from_mission_cleanup_list $SSV_HIDEOUT_DOOR 
0177: set_object $SSV_HIDEOUT_DOOR z_angle_to 180.0 
029B: $CARTEL_MANSION_GATE = init_object #COLUMBIANGATE at -363.0 250.4375 61.3125 
01C7: remove_object_from_mission_cleanup_list $CARTEL_MANSION_GATE 
0177: set_object $CARTEL_MANSION_GATE z_angle_to 180.0 
029B: $AIRPORT_DOOR1 = init_object #AIRPORTDOOR1 at -770.375 -599.25 11.8125 
01C7: remove_object_from_mission_cleanup_list $AIRPORT_DOOR1 
029B: $AIRPORT_DOOR2 = init_object #AIRPORTDOOR2 at -770.375 -601.3125 11.8125 
01C7: remove_object_from_mission_cleanup_list $AIRPORT_DOOR2 
if
	0038:   $DEBUGUNLOCKISLANDS == 0  
then
	0177: set_object $CHINABANK_DOOR2 z_angle_to 180.0 
	029B: $CHINA_SUBWAY_GATE = init_object #SUBWAYGATE at 988.9375 -471.75 5.1875 
	01C7: remove_object_from_mission_cleanup_list $CHINA_SUBWAY_GATE 
	0177: set_object $CHINA_SUBWAY_GATE z_angle_to 90.0 
	029B: $TUNNEL_PORTLAND_BLOCK = init_object #TUNNELENTRANCE at 730.3125 172.4375 -21.0625 
	01C7: remove_object_from_mission_cleanup_list $TUNNEL_PORTLAND_BLOCK 
	029B: $LIFT_BRIDGE_BLOCK = init_object #HELIX_BARRIER at -73.125 -630.3125 25.875 
	01C7: remove_object_from_mission_cleanup_list $LIFT_BRIDGE_BLOCK 
	029B: $FIXED_INSIDE = init_object #FIXED_INSIDE at 362.8125 -341.875 17.125 
	01C7: remove_object_from_mission_cleanup_list $FIXED_INSIDE 
	029B: $FIXED_OUTSIDE = init_object #FIXED_OUTSIDE at 360.8125 -391.375 22.5625 
	01C7: remove_object_from_mission_cleanup_list $FIXED_OUTSIDE 
	0363: toggle_model_render_at 1027.25 -933.75 15.0 radius 50.0 object #INDHELIX_BARRIER 0 
	03B6: replace_model_at 1027.25 -933.75 15.0 radius 50.0 from #INDHELIX_BARRIER to #LOD_LAND014 
end
return

:INIT_SPECIAL_OBJECTS
02FB: create_crusher_crane 1119.75 51.75 1135.75 56.0625 1149.75 46.25 1143.0 59.875 5.0 180.0
return

// This sub initializes garages
:GARAGES_INIT
// PORTLAND
0219: $PORTLAND_HIDEOUT_GARAGE = create_garage GARAGE_SAVEONE from 891.25 -311.0625 7.6875 to 898.375 -315.5 12.6875
0219: $PORTLAND_IE_GARAGE = create_garage GARAGE_IMPORT_PORTLAND from 1496.75 -686.1875 11.0 to 1523.25 -666.75 17.0
03DA: set_garage $PORTLAND_IE_GARAGE camera_follows_player 
0219: $PORTLAND_BOMBSHOP_GARAGE = create_garage GARAGE_BOMBSHOP_ONIGNITION from 1284.563 -100.5 13.5625 to 1278.0 -111.0 18.5625
0219: $PORTLAND_PAYNSPRAY_GARAGE = create_garage GARAGE_PAYNSPRAY from 921.0 -367.5 9.75 to 928.6875 -355.0625 14.75
0219: $SALVATORES_GARAGE = create_garage GARAGE_MISSION_KEEPCAR_REMAINCLOSED from 1428.75 -187.0 49.6875 to 1442.5 -179.875 54.6875
03BB: set_garage $SALVATORES_GARAGE door_type_to_swing_open 
0219: $SECURICAR_GARAGE = create_garage GARAGE_MISSION from 1440.688 -805.5625 10.875 to 1449.75 -782.0625 15.875
0219: $LUIGIS_LOCKUP_GARAGE = create_garage GARAGE_MISSION from 1074.0 -578.0 13.0 to 1085.0 -568.0 17.0
// STAUNTON
0219: $STAUNTON_HIDEOUT_GARAGE = create_garage GARAGE_SAVETWO from 115.0625 -475.25 15.0 to 106.875 -487.0625 19.0
0219: $STAUNTON_BOMSHOP_GARAGE = create_garage GARAGE_BOMBSHOP_TIMED from 386.0 -573.0 25.1875 to 376.5625 -580.0625 30.1875
0219: $STAUNTON_PAYNSPRAY_GARAGE = create_garage GARAGE_PAYNSPRAY from 386.0 -490.0 25.1875 to 376.5625 -497.0 30.1875
0219: $RAY_LOCKUP_GARAGE = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 245.375 -992.1875 20.0 to 234.375 -1000.5 24.0
03BB: set_garage $RAY_LOCKUP_GARAGE door_type_to_swing_open 
0219: $WITSEC_HOUSE_GARAGE = create_garage GARAGE_MISSION_REJECTCAR from 375.0 -441.5 20.0625 to 386.0 -434.0 25.0625
0219: $KENJI_LOCKUP_GARAGE = create_garage GARAGE_MISSION from 377.25 -511.375 25.0625 to 383.6875 -502.0 30.0
0219: $COLUMBIAN_GARAGE1 = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 63.75 -307.875 15.1875 to 70.0 -316.6875 19.1875
0219: $COLUMBIAN_GARAGE2 = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 53.0 -308.0 15.1875 to 60.0 -316.6875 19.1875
0219: $COLUMBIAN_GARAGE3 = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 24.875 -344.0 15.1875 to 30.5625 -337.0625 19.1875
0219: $COLUMBIAN_GARAGE4 = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 24.5 -355.0 15.1875 to 30.5625 -346.0 19.1875
0219: $COLUMBIAN_GARAGE5 = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from 52.5 -388.0 15.1875 to 42.0 -374.0625 19.1875
0219: $YARDIE_LOCKUP_GARAGE = create_garage GARAGE_MISSION from 257.0 -803.0 26.75 263.0 -795.5 31.75
// SHORESIDE VALE
0219: $SSV_HIDEOUT_GARAGE = create_garage GARAGE_SAVETHREE from -662.5 -47.375 17.0 to -670.6875 -30.0 22.0
03BB: set_garage $SSV_HIDEOUT_GARAGE door_type_to_swing_open 
03DA: set_garage $SSV_HIDEOUT_GARAGE camera_follows_player 
0219: $SSV_PAYNSPRAY_GARAGE = create_garage GARAGE_PAYNSPRAY from -1139.0 37.75 55.0 to -1148.5 32.0625 65.0
0219: $SSV_BOMBSHOP_GARAGE = create_garage GARAGE_BOMBSHOP_REMOTE from -1078.875 58.0 56.0 to -1086.0 49.0 65.0
0219: $SSV_IE_GARAGE = create_garage GARAGE_IMPORT_SHORESIDE from -1117.5 150.875 55.0 to -1097.688 121.1875 65.0
03DA: set_garage $SSV_IE_GARAGE camera_follows_player 
0219: $HOODS_DEFUSAL_GARAGE = create_garage GARAGE_MISSION_KEEPCAR from 1346.875 -315.5 49.0 to 1352.5 -310.6875 53.0
0219: $PLATINUM_DROPOFF_GARAGE = create_garage GARAGE_MISSION_REJECTCAR_STAYOPEN from -824.6875 -165.5 32.75 to -843.5 -171.6875 37.0
0219: $DONALD_LOVES_STASH_GARAGE = create_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE from -1049.125 -77.4375 37.75 to -1037.188 -69.125 42.75
03BB: set_garage $DONALD_LOVES_STASH_GARAGE door_type_to_swing_open 
return

// All code related to traffic: forbidden paths, gang cars, gang zones, car class zones
:TRAFFIC_INFO
// Portland Zones
015C: set_zone_gang_info 'CITYZON' DAY 12 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'CITYZON' NIGHT 8 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'CITYZON' DAY 10 0 0 0 0 0 0 0 20 240 240 240 240 0 0 
0152: set_zone_car_info 'CITYZON' NIGHT 8 0 0 0 0 0 0 0 10 240 240 240 240 0 0 
0324: set_zone_pedgroup_info 'CITYZON' DAY 0  // Liberty City
0324: set_zone_pedgroup_info 'CITYZON' NIGHT 0  // Liberty City
015C: set_zone_gang_info 'IND_ZON' DAY 12 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'IND_ZON' NIGHT 8 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'IND_ZON' DAY 10 0 0 0 0 0 0 0 20 500 0 0 450 0 0 
0152: set_zone_car_info 'IND_ZON' NIGHT 8 0 0 0 0 0 0 0 10 500 0 0 450 0 0 
0324: set_zone_pedgroup_info 'IND_ZON' DAY 11  // Portland
0324: set_zone_pedgroup_info 'IND_ZON' NIGHT 12  // Portland
015C: set_zone_gang_info 'COM_ZON' DAY 12 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'COM_ZON' NIGHT 8 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'COM_ZON' DAY 10 0 0 0 0 0 0 0 20 0 300 450 150 0 0 
0152: set_zone_car_info 'COM_ZON' NIGHT 8 0 0 0 0 0 0 0 10 0 300 450 150 0 0 
0324: set_zone_pedgroup_info 'COM_ZON' DAY 0  // Staunton Island
0324: set_zone_pedgroup_info 'COM_ZON' NIGHT 0  // Staunton Island
015C: set_zone_gang_info 'SUB_ZON' DAY 12 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'SUB_ZON' NIGHT 8 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'SUB_ZON' DAY 10 0 0 0 0 0 0 0 20 0 500 450 0 0 0 
0152: set_zone_car_info 'SUB_ZON' NIGHT 8 0 0 0 0 0 0 0 10 0 500 450 0 0 0 
0324: set_zone_pedgroup_info 'SUB_ZON' DAY 0  // Shoreside Vale
0324: set_zone_pedgroup_info 'SUB_ZON' NIGHT 0  // Shoreside Vale
015C: set_zone_gang_info 'LITTLEI' DAY 17 300 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'LITTLEI' NIGHT 11 400 0 0 0 0 0 0 10 
0152: set_zone_car_info 'LITTLEI' DAY 10 100 0 0 0 0 0 0 20 400 0 0 350 20 0 
0152: set_zone_car_info 'LITTLEI' NIGHT 8 150 0 0 0 0 0 0 10 550 0 0 150 0 0 
0324: set_zone_pedgroup_info 'LITTLEI' DAY 3  // Saint Mark's
0324: set_zone_pedgroup_info 'LITTLEI' NIGHT 4  // Saint Mark's
015C: set_zone_gang_info 'CHINA' DAY 20 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'CHINA' NIGHT 12 0 400 0 0 0 0 0 10 
0152: set_zone_car_info 'CHINA' DAY 10 0 100 0 0 0 0 0 10 400 0 0 350 0 0 
0152: set_zone_car_info 'CHINA' NIGHT 8 0 150 0 0 0 0 0 20 550 0 0 200 0 0 
0324: set_zone_pedgroup_info 'CHINA' DAY 5  // Chinatown
0324: set_zone_pedgroup_info 'CHINA' NIGHT 6  // Chinatown
015C: set_zone_gang_info 'TOWERS' DAY 15 0 0 300 0 0 0 0 0 
015C: set_zone_gang_info 'TOWERS' NIGHT 10 0 0 400 0 0 0 0 0 
0152: set_zone_car_info 'TOWERS' DAY 8 0 0 100 0 0 0 0 20 400 0 0 350 0 0 
0152: set_zone_car_info 'TOWERS' NIGHT 6 0 0 150 0 0 0 0 10 550 0 0 200 0 0 
0324: set_zone_pedgroup_info 'TOWERS' DAY 9  // Hepburn Heights
0324: set_zone_pedgroup_info 'TOWERS' NIGHT 10  // Hepburn Heights
015C: set_zone_gang_info 'REDLIGH' DAY 6 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'REDLIGH' NIGHT 13 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'REDLIGH' DAY 5 0 0 0 0 0 0 0 10 550 0 0 350 0 0 
0152: set_zone_car_info 'REDLIGH' NIGHT 7 0 0 0 0 0 0 0 20 600 0 0 200 0 0 
0324: set_zone_pedgroup_info 'REDLIGH' DAY 1  // Red Light District
0324: set_zone_pedgroup_info 'REDLIGH' NIGHT 2  // Red Light District
015C: set_zone_gang_info 'PORT_I' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_I' NIGHT 7 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_I' DAY 8 0 0 0 0 0 0 0 20 300 0 0 400 20 0 
0152: set_zone_car_info 'PORT_I' NIGHT 6 0 0 0 0 0 0 0 10 500 0 0 400 0 0 
0324: set_zone_pedgroup_info 'PORT_I' DAY 11  // Trenton
0324: set_zone_pedgroup_info 'PORT_I' NIGHT 12  // Trenton
015C: set_zone_gang_info 'PORT_E' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_E' NIGHT 8 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' DAY 8 0 0 0 0 0 0 0 20 300 0 0 400 20 0 
0152: set_zone_car_info 'PORT_E' NIGHT 6 0 0 0 0 0 0 0 10 500 0 0 400 0 0 
0324: set_zone_pedgroup_info 'PORT_E' DAY 7  // Portland Harbor
0324: set_zone_pedgroup_info 'PORT_E' NIGHT 8  // Portland Harbor
015C: set_zone_gang_info 'PORT_S' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_S' NIGHT 8 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_S' DAY 8 0 0 0 0 0 0 0 20 300 0 0 500 20 0 
0152: set_zone_car_info 'PORT_S' NIGHT 6 0 0 0 0 0 0 0 10 500 0 0 400 0 0 
0324: set_zone_pedgroup_info 'PORT_S' DAY 11  // Atlantic Quays
0324: set_zone_pedgroup_info 'PORT_S' NIGHT 12  // Atlantic Quays
015C: set_zone_gang_info 'PORT_W' DAY 10 0 10 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_W' NIGHT 5 0 10 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_W' DAY 8 0 0 0 0 0 0 0 20 300 0 0 400 0 0 
0152: set_zone_car_info 'PORT_W' NIGHT 6 0 0 0 0 0 0 0 10 500 0 0 400 0 0 
0324: set_zone_pedgroup_info 'PORT_W' DAY 11  // Callahan Point
0324: set_zone_pedgroup_info 'PORT_W' NIGHT 12  // Callahan Point
015C: set_zone_gang_info 'HARWOOD' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'HARWOOD' NIGHT 8 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'HARWOOD' DAY 8 0 0 0 0 0 0 0 20 400 0 0 300 0 0 
0152: set_zone_car_info 'HARWOOD' NIGHT 6 0 0 0 0 0 0 0 10 600 0 0 200 0 0 
0324: set_zone_pedgroup_info 'HARWOOD' DAY 11  // Harwood
0324: set_zone_pedgroup_info 'HARWOOD' NIGHT 12  // Harwood
015C: set_zone_gang_info 'EASTBAY' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'EASTBAY' NIGHT 5 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'EASTBAY' DAY 5 0 0 0 0 0 0 0 20 500 0 0 480 0 0 
0152: set_zone_car_info 'EASTBAY' NIGHT 4 0 0 0 0 0 0 0 10 500 0 0 490 0 0 
0324: set_zone_pedgroup_info 'EASTBAY' DAY 11  // Portland Beach
0324: set_zone_pedgroup_info 'EASTBAY' NIGHT 12  // Portland Beach
015C: set_zone_gang_info 'S_VIEW' DAY 10 0 0 0 0 0 0 0 30 
015C: set_zone_gang_info 'S_VIEW' NIGHT 8 0 0 0 0 0 0 0 20 
0152: set_zone_car_info 'S_VIEW' DAY 10 0 0 0 0 0 0 0 30 400 0 0 300 100 0 
0152: set_zone_car_info 'S_VIEW' NIGHT 8 0 0 0 0 0 0 0 20 500 0 0 200 100 0 
0324: set_zone_pedgroup_info 'S_VIEW' DAY 11  // Portland View
0324: set_zone_pedgroup_info 'S_VIEW' NIGHT 12  // Portland View
015C: set_zone_gang_info 'COPS_1' DAY 10 0 0 0 0 0 0 0 60 
015C: set_zone_gang_info 'COPS_1' NIGHT 8 0 0 0 0 0 0 0 60 
0152: set_zone_car_info 'COPS_1' DAY 10 0 0 0 0 0 0 0 90 400 0 0 400 0 0 
0152: set_zone_car_info 'COPS_1' NIGHT 8 0 0 0 0 0 0 0 90 400 0 0 400 0 0 
0324: set_zone_pedgroup_info 'COPS_1' DAY 11 
0324: set_zone_pedgroup_info 'COPS_1' NIGHT 12 
015C: set_zone_gang_info 'HOSPI_1' DAY 10 0 0 0 0 0 0 0 60 
015C: set_zone_gang_info 'HOSPI_1' NIGHT 8 0 0 0 0 0 0 0 60 
0152: set_zone_car_info 'HOSPI_1' DAY 10 0 0 0 0 0 0 0 90 400 0 0 400 0 0 
0152: set_zone_car_info 'HOSPI_1' NIGHT 8 0 0 0 0 0 0 0 90 400 0 0 400 0 0 
0324: set_zone_pedgroup_info 'HOSPI_1' DAY 17 
0324: set_zone_pedgroup_info 'HOSPI_1' NIGHT 18 
015C: set_zone_gang_info 'ROADBR1' DAY 30 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'ROADBR1' NIGHT 20 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'ROADBR1' DAY 12 0 0 0 0 0 0 0 20 400 0 0 400 0 100 
0152: set_zone_car_info 'ROADBR1' NIGHT 10 0 0 0 0 0 0 0 10 400 0 0 400 0 100 
0324: set_zone_pedgroup_info 'ROADBR1' DAY 11  // Callahan Bridge
0324: set_zone_pedgroup_info 'ROADBR1' NIGHT 12  // Callahan Bridge
015C: set_zone_gang_info 'FISHFAC' DAY 2 0 1000 0 0 0 0 0 0 
015C: set_zone_gang_info 'FISHFAC' NIGHT 2 0 1000 0 0 0 0 0 0 
0152: set_zone_car_info 'FISHFAC' DAY 6 0 0 0 0 0 0 0 20 200 0 0 600 0 0 
0152: set_zone_car_info 'FISHFAC' NIGHT 4 0 0 0 0 0 0 0 10 200 0 0 600 0 0 
0324: set_zone_pedgroup_info 'FISHFAC' DAY 11 
0324: set_zone_pedgroup_info 'FISHFAC' NIGHT 12 
015C: set_zone_gang_info 'FILLIN1' DAY 10 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'FILLIN1' NIGHT 8 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'FILLIN1' DAY 8 0 0 0 0 0 0 0 20 500 0 0 400 0 0 
0152: set_zone_car_info 'FILLIN1' NIGHT 6 0 0 0 0 0 0 0 10 400 0 0 400 0 0 
0324: set_zone_pedgroup_info 'FILLIN1' DAY 11 
0324: set_zone_pedgroup_info 'FILLIN1' NIGHT 12 
015C: set_zone_gang_info 'MAIN_D1' DAY 15 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D1' NIGHT 10 0 500 0 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D1' DAY 24 0 100 0 0 0 0 0 20 300 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D1' NIGHT 18 0 150 0 0 0 0 0 10 300 0 0 300 20 100 
0324: set_zone_pedgroup_info 'MAIN_D1' DAY 5 
0324: set_zone_pedgroup_info 'MAIN_D1' NIGHT 6 
015C: set_zone_gang_info 'MAIN_D2' DAY 15 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D2' NIGHT 10 0 400 0 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D2' DAY 24 0 100 0 0 0 0 0 20 300 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D2' NIGHT 18 0 150 0 0 0 0 0 10 300 0 0 300 20 100 
0324: set_zone_pedgroup_info 'MAIN_D2' DAY 5 
0324: set_zone_pedgroup_info 'MAIN_D2' NIGHT 6 
015C: set_zone_gang_info 'MAIN_D3' DAY 15 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D3' NIGHT 10 0 400 0 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D3' DAY 24 0 100 0 0 0 0 0 20 300 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D3' NIGHT 18 0 150 0 0 0 0 0 10 300 0 0 300 20 100 
0324: set_zone_pedgroup_info 'MAIN_D3' DAY 5 
0324: set_zone_pedgroup_info 'MAIN_D3' NIGHT 6 
015C: set_zone_gang_info 'MAIN_D4' DAY 15 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D4' NIGHT 10 0 400 0 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D4' DAY 24 0 100 0 0 0 0 0 20 300 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D4' NIGHT 18 0 150 0 0 0 0 0 10 300 0 0 300 20 100 
0324: set_zone_pedgroup_info 'MAIN_D4' DAY 5 
0324: set_zone_pedgroup_info 'MAIN_D4' NIGHT 6 
015C: set_zone_gang_info 'MAIN_D5' DAY 15 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D5' NIGHT 10 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D5' DAY 24 0 0 0 0 0 0 0 20 400 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D5' NIGHT 18 0 0 0 0 0 0 0 10 300 0 0 400 20 100 
0324: set_zone_pedgroup_info 'MAIN_D5' DAY 1 
0324: set_zone_pedgroup_info 'MAIN_D5' NIGHT 2 
015C: set_zone_gang_info 'MAIN_D6' DAY 15 0 0 300 0 0 0 0 20 
015C: set_zone_gang_info 'MAIN_D6' NIGHT 10 0 0 400 0 0 0 0 10 
0152: set_zone_car_info 'MAIN_D6' DAY 24 0 0 100 0 0 0 0 20 300 0 0 300 20 100 
0152: set_zone_car_info 'MAIN_D6' NIGHT 18 0 0 150 0 0 0 0 10 300 0 0 300 20 100 
0324: set_zone_pedgroup_info 'MAIN_D6' DAY 9 
0324: set_zone_pedgroup_info 'MAIN_D6' NIGHT 10 
// Staunton Zones
015C: set_zone_gang_info 'STADIUM' DAY 30 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'STADIUM' NIGHT 16 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'STADIUM' DAY 20 0 0 0 0 0 0 0 20 300 150 0 250 0 200 
0152: set_zone_car_info 'STADIUM' NIGHT 17 0 0 0 0 0 0 0 10 300 150 0 250 0 200 
0324: set_zone_pedgroup_info 'STADIUM' DAY 15  // Aspatria
0324: set_zone_pedgroup_info 'STADIUM' NIGHT 16  // Aspatria
015C: set_zone_gang_info 'HOSPI_2' DAY 30 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'HOSPI_2' NIGHT 16 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'HOSPI_2' DAY 20 0 0 0 0 0 0 0 20 300 150 0 250 0 200 
0152: set_zone_car_info 'HOSPI_2' NIGHT 17 0 0 0 0 0 0 0 10 300 150 0 250 0 200 
0324: set_zone_pedgroup_info 'HOSPI_2' DAY 17  // Rockford
0324: set_zone_pedgroup_info 'HOSPI_2' NIGHT 18  // Rockford
015C: set_zone_gang_info 'UNIVERS' DAY 30 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'UNIVERS' NIGHT 16 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'UNIVERS' DAY 20 0 0 0 0 0 0 0 20 300 300 300 0 20 0 
0152: set_zone_car_info 'UNIVERS' NIGHT 17 0 0 0 0 0 0 0 10 300 300 300 0 20 0 
0324: set_zone_pedgroup_info 'UNIVERS' DAY 23  // Liberty Campus
0324: set_zone_pedgroup_info 'UNIVERS' NIGHT 24  // Liberty Campus
015C: set_zone_gang_info 'CONSTRU' DAY 30 0 0 0 0 0 300 0 20 
015C: set_zone_gang_info 'CONSTRU' NIGHT 16 0 0 0 0 0 400 0 10 
0152: set_zone_car_info 'CONSTRU' DAY 20 0 0 0 0 0 100 0 20 300 100 0 250 0 150 
0152: set_zone_car_info 'CONSTRU' NIGHT 17 0 0 0 0 0 150 0 10 300 100 0 250 0 150 
0324: set_zone_pedgroup_info 'CONSTRU' DAY 19  // Fort Staunton
0324: set_zone_pedgroup_info 'CONSTRU' NIGHT 20  // Fort Staunton
015C: set_zone_gang_info 'PARK' DAY 30 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'PARK' NIGHT 16 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'PARK' DAY 20 0 0 0 0 0 0 0 20 300 300 300 0 0 0 
0152: set_zone_car_info 'PARK' NIGHT 17 0 0 0 0 0 0 0 10 300 300 300 0 0 0 
0324: set_zone_pedgroup_info 'PARK' DAY 25  // Belleville Park
0324: set_zone_pedgroup_info 'PARK' NIGHT 26  // Belleville Park
015C: set_zone_gang_info 'COM_EAS' DAY 30 0 0 0 0 300 0 0 20 
015C: set_zone_gang_info 'COM_EAS' NIGHT 16 0 0 0 0 400 0 0 10 
0152: set_zone_car_info 'COM_EAS' DAY 20 0 0 0 0 100 0 0 20 400 250 0 0 0 150 
0152: set_zone_car_info 'COM_EAS' NIGHT 17 0 0 0 0 150 0 0 10 400 250 0 0 0 100 
0324: set_zone_pedgroup_info 'COM_EAS' DAY 21  // Newport
0324: set_zone_pedgroup_info 'COM_EAS' NIGHT 22  // Newport
015C: set_zone_gang_info 'SHOPING' DAY 30 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'SHOPING' NIGHT 16 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'SHOPING' DAY 20 0 0 0 0 0 0 0 30 300 250 250 0 0 100 
0152: set_zone_car_info 'SHOPING' NIGHT 17 0 0 0 0 0 0 0 20 300 250 250 0 0 100 
0324: set_zone_pedgroup_info 'SHOPING' DAY 21  // Bedford Point
0324: set_zone_pedgroup_info 'SHOPING' NIGHT 22  // Bedford Point
015C: set_zone_gang_info 'YAKUSA' DAY 30 0 0 0 300 0 0 0 20 
015C: set_zone_gang_info 'YAKUSA' NIGHT 16 0 0 0 400 0 0 0 10 
0152: set_zone_car_info 'YAKUSA' DAY 20 0 0 0 100 0 0 0 40 350 200 250 0 0 0 
0152: set_zone_car_info 'YAKUSA' NIGHT 17 0 0 0 150 0 0 0 20 350 200 200 0 0 0 
0324: set_zone_pedgroup_info 'YAKUSA' DAY 21  // Torrington
0324: set_zone_pedgroup_info 'YAKUSA' NIGHT 22  // Torrington
015C: set_zone_gang_info 'ROADBR2' DAY 30 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'ROADBR2' NIGHT 20 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'ROADBR2' DAY 20 0 0 0 0 0 0 0 30 300 250 250 0 0 100 
0152: set_zone_car_info 'ROADBR2' NIGHT 17 0 0 0 0 0 0 0 20 300 250 250 0 0 100 
0324: set_zone_pedgroup_info 'ROADBR2' DAY 21  // Callahan Bridge
0324: set_zone_pedgroup_info 'ROADBR2' NIGHT 22  // Callahan Bridge
// Shoreside Vale Zones
015C: set_zone_gang_info 'AIRPORT' DAY 20 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'AIRPORT' NIGHT 10 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'AIRPORT' DAY 15 0 0 0 0 0 0 0 40 300 300 300 0 0 0 
0152: set_zone_car_info 'AIRPORT' NIGHT 13 0 0 0 0 0 0 0 20 300 300 300 0 0 0 
0324: set_zone_pedgroup_info 'AIRPORT' DAY 27  // Francis Intl. Airport
0324: set_zone_pedgroup_info 'AIRPORT' NIGHT 28  // Francis Intl. Airport
015C: set_zone_gang_info 'PROJECT' DAY 20 0 0 0 0 0 0 300 0 
015C: set_zone_gang_info 'PROJECT' NIGHT 10 0 0 0 0 0 0 400 0 
0152: set_zone_car_info 'PROJECT' DAY 15 0 0 0 0 0 0 100 20 500 150 0 150 0 0 
0152: set_zone_car_info 'PROJECT' NIGHT 13 0 0 0 0 0 0 150 10 500 100 0 150 0 0 
0324: set_zone_pedgroup_info 'PROJECT' DAY 9  // Wichita Gardens
0324: set_zone_pedgroup_info 'PROJECT' NIGHT 10  // Wichita Gardens
015C: set_zone_gang_info 'SUB_IND' DAY 20 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'SUB_IND' NIGHT 10 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'SUB_IND' DAY 15 0 0 0 0 0 0 0 20 300 300 300 0 0 0 
0152: set_zone_car_info 'SUB_IND' NIGHT 13 0 0 0 0 0 0 0 10 300 300 300 0 0 0 
0324: set_zone_pedgroup_info 'SUB_IND' DAY 7  // Pike Creek
0324: set_zone_pedgroup_info 'SUB_IND' NIGHT 8  // Pike Creek
015C: set_zone_gang_info 'SWANKS' DAY 20 0 0 0 0 0 70 0 30 
015C: set_zone_gang_info 'SWANKS' NIGHT 10 0 0 0 0 0 90 0 20 
0152: set_zone_car_info 'SWANKS' DAY 15 0 0 0 0 0 70 0 30 0 400 400 0 20 0 
0152: set_zone_car_info 'SWANKS' NIGHT 13 0 0 0 0 0 90 0 20 0 400 400 0 20 0 
0324: set_zone_pedgroup_info 'SWANKS' DAY 29  // Cedar Grove
0324: set_zone_pedgroup_info 'SWANKS' NIGHT 30  // Cedar Grove
015C: set_zone_gang_info 'BIG_DAM' DAY 8 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'BIG_DAM' NIGHT 6 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'BIG_DAM' DAY 8 0 0 0 0 0 0 0 20 300 300 0 300 0 0 
0152: set_zone_car_info 'BIG_DAM' NIGHT 6 0 0 0 0 0 0 0 10 300 300 0 300 0 0 
0324: set_zone_pedgroup_info 'BIG_DAM' DAY 11  // Cochrane Dam
0324: set_zone_pedgroup_info 'BIG_DAM' NIGHT 12  // Cochrane Dam
015C: set_zone_gang_info 'SUB_ZO2' DAY 20 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'SUB_ZO2' NIGHT 10 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'SUB_ZO2' DAY 15 0 0 0 0 0 0 0 20 0 500 450 0 0 0 
0152: set_zone_car_info 'SUB_ZO2' NIGHT 13 0 0 0 0 0 0 0 10 0 500 450 0 0 0 
0324: set_zone_pedgroup_info 'SUB_ZO2' DAY 0  // Shoreside Vale
0324: set_zone_pedgroup_info 'SUB_ZO2' NIGHT 0  // Shoreside Vale
015C: set_zone_gang_info 'SUB_ZO3' DAY 20 0 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'SUB_ZO3' NIGHT 10 0 0 0 0 0 0 0 10 
0152: set_zone_car_info 'SUB_ZO3' DAY 15 0 0 0 0 0 0 0 20 0 500 450 0 0 0 
0152: set_zone_car_info 'SUB_ZO3' NIGHT 13 0 0 0 0 0 0 0 10 0 500 450 0 0 0 
0324: set_zone_pedgroup_info 'SUB_ZO3' DAY 0  // Shoreside Vale
0324: set_zone_pedgroup_info 'SUB_ZO3' NIGHT 0  // Shoreside Vale
015C: set_zone_gang_info 'WEE_DAM' DAY 8 0 0 0 0 0 100 0 0 
015C: set_zone_gang_info 'WEE_DAM' NIGHT 5 0 0 0 0 0 100 0 0 
0152: set_zone_car_info 'WEE_DAM' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'WEE_DAM' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0324: set_zone_pedgroup_info 'WEE_DAM' DAY 7 
0324: set_zone_pedgroup_info 'WEE_DAM' NIGHT 8 
if
    0038:   $DEBUGUNLOCKISLANDS == 0  
then
	// Portland Forbidden Cubes
	01E8: switch_roads_off 619.5625 -911.5 45.0 to 834.25 -954.5 32.0 
	0426: create_save_cars_between_levels_cube 619.5625 -911.5 45.0 to 834.25 -954.5 32.0 
	01E8: switch_roads_off 1381.0 -293.6875 48.0 to 1435.75 -140.0625 58.0 
	01E8: switch_roads_off 1358.875 -901.875 10.0 to 1609.563 -615.0625 16.0 
	01E8: switch_roads_off 659.5625 200.0 -20.0 to 945.75 147.5 5.0 
	0426: create_save_cars_between_levels_cube 659.5625 200.0 -20.0 to 945.75 147.5 5.0 
	022B: switch_ped_roads_off 659.5625 200.0 -25.0 to 945.75 147.5 5.0 
	0426: create_save_cars_between_levels_cube 659.5625 200.0 -25.0 to 945.75 147.5 5.0 
	022B: switch_ped_roads_off 773.5625 191.75 -25.0 to 819.6875 182.75 5.0 
	0426: create_save_cars_between_levels_cube 773.5625 191.75 -25.0 to 819.6875 182.75 5.0 
	022B: switch_ped_roads_off 1609.0 -896.0 8.0 to 1393.688 -967.375 30.0 
	022B: switch_ped_roads_off 1048.25 -1103.375 5.0 to 1040.0 -1074.375 30.0 
	022B: switch_ped_roads_off 900.0625 -297.0 6.0 to 842.8125 -325.5625 15.0 
	022B: switch_ped_roads_off 900.5 -427.0625 14.0 to 879.0625 -404.1875 17.0 
	022B: switch_ped_roads_off 847.875 -640.5625 10.0 to 887.875 -685.75 20.0 
	0399: create_forbidden_for_peds_angled_cube 1222.875 -838.375 13.5 to 1256.25 -804.875 16.0 angle 58.0 
	022B: switch_ped_roads_off 1005.563 -880.9375 12.0 to 995.875 -893.3125 20.0 
	022B: switch_ped_roads_off 1070.563 -401.5625 10.0 to 1067.75 -397.1875 25.0 
	// Staunton Island Forbidden Cubes
	022B: switch_ped_roads_off 106.0625 -1278.25 24.0 to 96.25 -1273.5 27.0 
	022B: switch_ped_roads_off 120.0 170.0 10.0 to 190.0 246.0 25.0 
	022B: switch_ped_roads_off 31.0 -317.0 14.0 to 91.0 -394.0 25.0 
	01E8: switch_roads_off 120.0 170.0 10.0 to 190.0 246.0 25.0 
	01E8: switch_roads_off 121.8125 -46.375 14.0 to 363.8125 54.25 20.0 
	022B: switch_ped_roads_off 121.8125 -46.375 14.0 to 363.8125 54.25 20.0 
	01E8: switch_roads_off 353.5 -459.0 18.0 to 397.5 -431.5625 30.0 
	01E8: switch_roads_off 465.6875 -634.25 10.0 to 429.875 -610.0625 25.0 
	01E8: switch_roads_off -46.75 -648.0 39.0 to -69.0625 -614.0 50.0 
	0426: create_save_cars_between_levels_cube -46.75 -648.0 39.0 to -69.0625 -614.0 50.0 
	022B: switch_ped_roads_off 56.5 -1544.188 10.0 to 87.875 -1556.0 30.0 
	022B: switch_ped_roads_off 413.5 -480.1875 20.0 to 420.875 -499.0 36.0 
	022B: switch_ped_roads_off 419.5 -708.0625 20.0 to 412.5 -717.875 36.0 
	022B: switch_ped_roads_off -76.875 -985.375 20.0 to -68.75 -992.5625 36.0 
	022B: switch_ped_roads_off -76.5 -934.375 20.0 to -70.375 -928.375 36.0 
	022B: switch_ped_roads_off -55.875 -934.5625 20.0 to -46.375 -927.1875 36.0 
	022B: switch_ped_roads_off -76.375 -999.5625 20.0 to -68.75 -628.5 36.0 
	022B: switch_ped_roads_off 199.25 -935.875 20.0 to 134.75 -927.375 40.0 
	01E8: switch_roads_off 529.5625 106.5 -30.0 to 581.375 65.6875 0.0 
	// Shoreside Vale Forbidden Cubes
	01E8: switch_roads_off -1052.625 -78.0 50.0 to -988.0 -67.125 30.0 
	022B: switch_ped_roads_off -1052.625 -78.0 50.0 to -988.0 -67.125 30.0 
	01E8: switch_roads_off -952.5 361.375 10.0 to -939.25 374.0 30.0 
	01E8: switch_roads_off -241.6875 251.75 0.0 to -256.1875 241.375 20.0 
	01E8: switch_roads_off -1367.75 -731.4375 20.0 to -743.1875 -410.1875 5.0 
	01E8: switch_roads_off -1591.375 -931.5 10.0 to -1572.875 -914.5625 25.0 
	022B: switch_ped_roads_off -1310.75 -568.75 5.0 to -1224.875 -483.4375 20.0 
	01E8: switch_roads_off 496.6875 75.5 -30.0 to 484.0 44.1875 0.0 
	0426: create_save_cars_between_levels_cube 496.6875 75.5 -30.0 to 484.0 44.1875 0.0 
	01E8: switch_roads_off -287.75 396.5 70.0 to -269.0 418.0 100.0 
	01E8: switch_roads_off -877.0625 545.875 60.0 to -901.25 575.0 100.0 
	01E8: switch_roads_off -690.375 101.1875 10.0 to -704.375 78.875 30.0 
	01E8: switch_roads_off -1194.063 98.5625 50.0 to -1234.0 119.1875 80.0 
end
// Gang cars and weapons
0236: set_gang GANG_MAFIA car_to #MAFIA // Mafia Sentinel
0237: set_gang GANG_MAFIA primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_PISTOL 
0236: set_gang GANG_TRIAD car_to #BELLYUP // Triad Fish Van
0237: set_gang GANG_TRIAD primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_BASEBALLBAT 
0236: set_gang GANG_DIABLO car_to #DIABLOS // Diablo Stallion
0237: set_gang GANG_DIABLO primary_weapon_to WEAPONTYPE_BASEBALLBAT secondary_weapon_to WEAPONTYPE_UNARMED 
0236: set_gang GANG_YAKUZA car_to #YAKUZA // Yakuza Stinger
0237: set_gang GANG_YAKUZA primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_UZI 
0236: set_gang GANG_YARDIE car_to #YARDIE // Yardie Lobo
0237: set_gang GANG_YARDIE primary_weapon_to WEAPONTYPE_BASEBALLBAT secondary_weapon_to WEAPONTYPE_PISTOL
0236: set_gang GANG_COLOMBIAN car_to #COLUMB // Cartel Cruiser
0237: set_gang GANG_COLOMBIAN primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_UZI  
0236: set_gang GANG_HOOD car_to #HOODS // Rumpo XL
0237: set_gang GANG_HOOD primary_weapon_to WEAPONTYPE_UZI secondary_weapon_to WEAPONTYPE_PISTOL 
if
    0038:   $MASTERDEBUG == 0  
then
    03F1: pedtype PEDTYPE_GANG_COLOMBIAN add_threat THREAT_PLAYER1
end
return

:VARIABLE_INIT
0004: $WAIT_TIME = 250  
0004: $ONMISSION = 0  

0004: $FLAG_STAUNTON_OPEN = 0
0004: $FLAG_SHORESIDE_OPEN = 0

0004: $FLAG_PORTLAND_SAVE_ON_RADAR = 0
0004: $FLAG_STAUNTON_SAVE_ON_RADAR = 0
0004: $FLAG_SHORESIDE_SAVE_ON_RADAR = 0 

0004: $ON_MISSION_FOR_8BALL = 0
0004: $FLAG_REACHED_HIDEOUT = 0
0004: $PRE_CUTSCENE_CURRENT_TIME  = 0
0004: $PRE_CUTSCENE_START_TIME  = 0
0004: $PRE_CUTSCENE_ELAPSED_TIME  = 0

0004: $ON_MISSION_FOR_LUIGI = 0
0004: $LUIGIS_GIRLS_COMPLETED = 0
0004: $FLAG_EIGHTBALL_MISSION_LAUNCHED = 0
0004: $FLAG_LUIGI_MISSION1_PASSED = 0
0004: $DONT_SPANK_MA_BITCH_UP_COMPLETED = 0
0004: $DRIVE_MISTY_FOR_ME_COMPLETED = 0

0004: $ON_MISSION_FOR_JOEY = 0
0004: $MIKE_LIPS_LAST_LUNCH_COMPLETED = 0
0004: $FAREWELL_CHUNKY_COMPLETED = 0
0004: $VAN_HEIST_COMPLETED = 0
0004: $CIPRIANIS_CHAUFFEUR_COMPLETED = 0

0004: $ON_MISSION_FOR_TONI = 0
0004: $TAKING_OUT_THE_LAUNDRY_COMPLETED = 0
0004: $THE_PICKUP_COMPLETED = 0
0004: $SALVATORES_CALLED_A_MEETING_COMPLETED = 0
0004: $TRIADS_AND_TRIBULATIONS_COMPLETED = 0
0004: $BLOW_FISH_COMPLETED = 0

0004: $ON_MISSION_FOR_FRANK = 0
0004: $CHAPERONE_COMPLETED = 0
0004: $CUTTING_THE_GRASS_COMPLETED = 0
0004: $BOMB_DA_BASE_ACT_I_COMPLETED = 0
0004: $BOMB_DA_BASE_ACT_II_COMPLETED = 0
0004: $LAST_REQUESTS_COMPLETED = 0
0004: $FLAG_FRANKIE_SWITCHED_OFF = 0
0004: $FLAG_PLAYER_HAD_CUTSCENE1_FRANKIE3 = 0

0004: $ON_MISSION_FOR_ASUKA1 = 0
0004: $SAYONARA_SALVATORE_COMPLETED = 0
0004: $UNDER_SURVEILLANCE_COMPLETED = 0
0004: $PAPARAZZI_PURGE_COMPLETED = 0
0004: $PAYDAY_FOR_RAY_COMPLETED = 0

0004: $ON_MISSION_FOR_LOVE = 0
0004: $LIBERATOR_COMPLETED = 0
0004: $WAKAGASHIRA_WIPEOUT_COMPLETED = 0
0004: $A_DROP_IN_THE_OCEAN_COMPLETED = 0
0004: $GRAND_THEFT_AERO_COMPLETED = 0

0004: $ON_MISSION_FOR_RAY = 0
0004: $SILENCE_THE_SNEAK_COMPLETED = 0
0004: $ARMS_SHORTAGE_COMPLETED = 0
0004: $EVIDENCE_DASH_COMPLETED = 0

0004: $ON_MISSION_FOR_ASUKA2 = 0
0004: $BAIT_COMPLETED = 0
0004: $ESPRESSO_2_GO_COMPLETED = 0
0004: $SAM_COMPLETED = 0

0004: $ON_MISSION_FOR_CATALINA = 0
0004: $THE_EXCHANGE_COMPLETED = 0
0004: $NICKED_HALF_A_MIL_BEFORE = 0

0004: $FLAG_DONE_RADIO_8BALL = 0

0004: $GOT_SIREN_HELP_BEFORE = 0
0004: $ON_TAXI_MISSION = 0
0004: $TAXI_HELP_DISPLAYED = 0
0004: $CURRENT_TAXI_MISSION = 0
0004: $TAXI_MISSION_DELIVERIES = 0
0004: $DISPLAYED_TAXI_HELP_MESSAGE = 0
0004: $NEW_TAXI_CREATED_BEFORE = 0

0004: $AMMU2_BLIP_ADDED = 0
0004: $TIMER_HELP_MESSAGE_DISPLAYED = 0
0004: $FLAG_JOEY_MISSION5_TERMINATED = 0
0004: $FLAG_JOEY_MISSION6_TERMINATED = 0
0004: $FLAG_LUIGI_MISSION4_TERMINATED = 0
0004: $FLAG_LUIGI_MISSION5_TERMINATED = 0
0004: $JOEY_VISITING_MISTY = 0
0004: $MARIA_EXISTS = 0
0004: $DOOR_CRASH_FLAG = 0
0004: $DOOR_POSITION_A1 = 0.0
0004: $BARRIERS_BEEN_ADDED = 0

// No idea what these are good for but they're in the original code.
0180: set_on_mission_flag_to $ONMISSION 
0181: on_mission_for 12 flag = $ON_MISSION_FOR_8BALL 
0181: on_mission_for 0 flag = $ON_MISSION_FOR_LUIGI 
0181: on_mission_for 1 flag = $ON_MISSION_FOR_JOEY 
0181: on_mission_for 2 flag = $ON_MISSION_FOR_TONI 
0181: on_mission_for 3 flag = $ON_MISSION_FOR_FRANK 
0181: on_mission_for 4 flag = $ON_MISSION_FOR_ASUKA1 
0181: on_mission_for 7 flag = $ON_MISSION_FOR_LOVE 
0181: on_mission_for 6 flag = $ON_MISSION_FOR_RAY 
0181: on_mission_for 10 flag = $ON_MISSION_FOR_ASUKA2 
0182: contact 12 base_brief = 1000 
0182: contact 0 base_brief = 1000 
0182: contact 1 base_brief = 1000 
0182: contact 2 base_brief = 1000 
0182: contact 3 base_brief = 1000 
0182: contact 4 base_brief = 1000 
0182: contact 7 base_brief = 1000 
0182: contact 6 base_brief = 1000 
0182: contact 10 base_brief = 1000 
0182: contact 9 base_brief = 1000 
return

// This sub creates mission markers and pay phones
:INIT_MISSION_LOCATIONS
024A: $PHONE_RAY1 = create_phone_at 229.0625 -1537.563 
024A: $PHONE_RAY2 = create_phone_at -53.5 -699.0 
024A: $PHONE_RAY3 = create_phone_at 204.6875 -135.0625 
024A: $PHONE_RAY4 = create_phone_at 60.1875 -964.75 

02A7: $LUIGI_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_LUIGI at 892.75 -425.75 13.875
0164: disable_marker $LUIGI_MISSION_MARKER 
02A7: $JOEY_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_JOEY at 1191.688 -870.0 -100.0
0164: disable_marker $JOEY_MISSION_MARKER 
02A7: $TONI_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_TONY at 1219.563 -321.0 -100.0
0164: disable_marker $TONI_MISSION_MARKER 
02A7: $SALVATORE_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAL at 1455.688 -187.25 -100.0
0164: disable_marker $SALVATORE_MISSION_MARKER 
02A7: $8BALL_CONTACT_POINT = create_icon_marker_and_sphere RADAR_SPRITE_EIGHT at 1272.188 -92.875 -100.0
0164: disable_marker $8BALL_CONTACT_POINT 
02A7: $ASUKA1_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_ASUKA at 523.5625 -639.375 16.5625
0164: disable_marker $ASUKA1_MISSION_MARKER 
02A7: $RAY_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_RAY at 38.75 -725.375 -100.0
0164: disable_marker $RAY_MISSION_MARKER 
02A7: $DONALD_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_DON at 86.0625 -1548.688 28.25
0164: disable_marker $DONALD_MISSION_MARKER 
02A7: $COLUMBIAN_MANSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_CAT at -363.6875 246.0625 60.0
0164: disable_marker $COLUMBIAN_MANSION_MARKER 
02A7: $PORTLAND_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at 893.5 -306.0625 -100.0
0164: disable_marker $PORTLAND_SAVE_MARKER 
02A7: $STAUNTON_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at 103.0 -484.1875 -100.0
0164: disable_marker $STAUNTON_SAVE_MARKER 
02A7: $SHORESIDE_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at -665.0 -6.5 -100.0
0164: disable_marker $SHORESIDE_SAVE_MARKER 
02A8: $SPRAY_TAXI = create_marker RADAR_SPRITE_SPRAY at 925.0 -359.5 -100.0
0164: disable_marker $SPRAY_TAXI 
return

:INIT_THREADS  
// Debug threads
00D7: create_thread_without_extra_params @STARTER
// GTA 3 normal threads
00D7: create_thread_without_extra_params @INSANE_STUNT
00D7: create_thread_without_extra_params @USJ
00D7: create_thread_without_extra_params @GENSTUFF
00D7: create_thread_without_extra_params @KILL_FRENZY
00D7: create_thread_without_extra_params @ALL_REWARDS
00D7: create_thread_without_extra_params @CAMERA
00D7: create_thread_without_extra_params @GATES
return

// This sub creates sound loops
:INIT_SOUND_LOOPS
018D: $SOUND41 = create_sound 41 at 850.75 -663.6875 15.0			// Wong's
018D: $SOUND42 = create_sound 42 at 913.5625 -805.5 15.0  			// Punk Noodles
018D: $SOUND53_1 = create_sound 53 at 970.0 -674.75 15.0 			// 
018D: $SOUND53_2 = create_sound 53 at 975.0625 -724.0 15.0 			//
018D: $SOUND44 = create_sound 44 at 1220.0 -310.0 32.0 				// Toni's
018D: $SOUND48 = create_sound 48 at 1318.375 -463.5625 57.0 			//
018D: $SOUND57_1 = create_sound 57 at 1579.75 -655.1875 13.0 			//
018D: $SOUND57_2 = create_sound 57 at 1504.75 -873.1875 19.0 			//
018D: $SOUND59 = create_sound 59 at 962.25 -259.6875 10.0		 	// Man complaining by Misty's Apt.
018D: $SOUND7 = create_sound 7 at 952.5 -148.1875 8.0 				// Apt north of Misty's
018D: $SOUND5 = create_sound 5 at 861.5 -247.1875 8.0 				// Apt north of safehouse
018D: $SOUND60 = create_sound 60 at 1469.0 -181.0 56.0 				// Salvatore's
018D: $SOUND37 = create_sound SOUND_SAWMILL_LOOP_L at 1120.688 -1023.25 23.0 	// Sawmill
018D: $SOUND51 = create_sound 51 at -744.6875 -604.0625 10.0 			// Airport
return
