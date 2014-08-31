:USJ
0004: $FLAG_USJ1_PASSED = 0  
0004: $FLAG_USJ2_PASSED = 0  
0004: $FLAG_USJ3_PASSED = 0  
0004: $FLAG_USJ4_PASSED = 0  
0004: $FLAG_USJ5_PASSED = 0  
0004: $FLAG_USJ6_PASSED = 0  
0004: $FLAG_USJ7_PASSED = 0  
0004: $FLAG_USJ8_PASSED = 0  
0004: $FLAG_USJ9_PASSED = 0  
0004: $FLAG_USJ10_PASSED = 0  
0004: $FLAG_USJ11_PASSED = 0  
0004: $FLAG_USJ12_PASSED = 0  
0004: $FLAG_USJ13_PASSED = 0  
0004: $FLAG_USJ14_PASSED = 0  
0004: $FLAG_USJ15_PASSED = 0  
0004: $FLAG_USJ16_PASSED = 0  
0004: $FLAG_USJ17_PASSED = 0  
0004: $FLAG_USJ18_PASSED = 0  
0004: $FLAG_USJ19_PASSED = 0  
0004: $FLAG_USJ20_PASSED = 0  
0004: $CASH_REWARD_USJ = 5000  
0004: $USJ_NUMBER = 0  
0004: $TOTAL_COMPLETED_USJ = 0  
0111: set_wasted_busted_check_to 0 
0314: set_total_unique_jumps_to 20
03A4: name_thread 'USJ'

:MISSION_START_USJ
wait 0 ms
if
	8256:   not is_player $PLAYER_CHAR defined 
then
	goto @MISSION_START_USJ
end
if
	80E0:   not is_player_in_any_car $PLAYER_CHAR 
then
	goto @MISSION_START_USJ
end
03C1: $PLAYERS_CAR_USJ = player $PLAYER_CHAR car_no_save 
if
	029C:   is_boat $PLAYERS_CAR_USJ
then
	goto @MISSION_START_USJ
end
02E3: $CAR_SPEED_USJ = car $PLAYERS_CAR_USJ speed
if or
	8020:   not  $CAR_SPEED_USJ > 25.0 
	81F3:   not car $PLAYERS_CAR_USJ airborne
then
	goto @MISSION_START_USJ
end
if
	03C6:   current_island == LEVEL_INDUSTRIAL
then
	if
		0121:   player $PLAYER_CHAR in_zone 'ROADBR1'  // Callahan Bridge
	then
		if
			00E5:   player $PLAYER_CHAR 0 940.375 -933.6875 radius 4.0 4.0 // BETWEEN CALLAHAN BRIDGE
		then
			$USJ_NUMBER = 1
			$CAMERA_X = 998.0
			$CAMERA_Y = -938.5
			$CAMERA_Z = 19.25
			goto @THE_JUMP
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 793.125 -929.9375 42.125 radius 4.0 2.0 3.0 // OVER CALLAHAN BRIDGE
		then
			$USJ_NUMBER = 11
			$CAMERA_X = 841.8125
			$CAMERA_Y = -930.125
			$CAMERA_Z = 34.3125
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'PORT_S'  // Atlantic Quays
	then
		if
			00E5:   player $PLAYER_CHAR 0 1168.938 -1156.875 radius 10.0 7.0 // OVER DOCKS
		then
			$USJ_NUMBER = 2
			$CAMERA_X = 1217.188
			$CAMERA_Y = -1162.375
			$CAMERA_Z = 15.0
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 1231.813 -1129.813 radius 4.0 2.5 // OVER WAREHOUSE NEAR RAVE
		then
			$USJ_NUMBER = 5
			$CAMERA_X = 1201.375
			$CAMERA_Y = -1135.625
			$CAMERA_Z = 19.625
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'CHINA'  // Chinatown
	then
		if
			00E5:   player $PLAYER_CHAR 0 789.6875 -572.25 radius 2.6875 5.0 // OVER FOOTBRIDGE
		then
			$USJ_NUMBER = 3
			$CAMERA_X = 779.9375
			$CAMERA_Y = -561.125
			$CAMERA_Z = 25.125
			goto @THE_JUMP
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 991.6875 -470.375 19.75 radius 2.0 4.0 3.0 // ONTO LTRAIN TRACKS BY SUBWAY
		then
			$USJ_NUMBER = 10
			$CAMERA_X = 987.5
			$CAMERA_Y = -462.5625
			$CAMERA_Z = 21.8125
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'PORT_I'  // Trenton
	then
		if
			00E5:   player $PLAYER_CHAR 0 1136.563 -976.8125 radius 4.0 2.5 // OVER FREIGHT BACKS
		then
			$USJ_NUMBER = 6
			$CAMERA_X = 1107.063
			$CAMERA_Y = -964.0
			$CAMERA_Z = 22.9375
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'PORT_E'  // Portland Harbor
	then
		if
			00E5:   player $PLAYER_CHAR 0 1375.75 -952.125 radius 5.0 5.0 // OVER WAREHOUSE BY SAWMILLS
		then
			$USJ_NUMBER = 7
			$CAMERA_X = 1369.25
			$CAMERA_Y = -981.5625
			$CAMERA_Z = 18.6875
			goto @THE_JUMP
		end
	end
	goto @MISSION_START_USJ
end
if
	03C6:   current_island == LEVEL_COMMERCIAL
then
	if
		0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 470.6875 -918.375 19.8125 radius 6.0 3.0 3.0 // UNDER CALLAHAN BRIDGE
		then
			$USJ_NUMBER = 4
			$CAMERA_X = 460.9375
			$CAMERA_Y = -947.8125
			$CAMERA_Z = 17.875
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 271.125 -607.0 radius 4.0 5.0 // OUT OF CARPARK
		then
			$USJ_NUMBER = 13
			$CAMERA_X = 281.8125
			$CAMERA_Y = -626.5
			$CAMERA_Z = 26.9375
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 320.1875 -896.3125 radius 6.0 5.0 // ONTO CALLAHAN BRIDGE
		then
			$USJ_NUMBER = 14
			$CAMERA_X = 332.8125
			$CAMERA_Y = -906.3125
			$CAMERA_Z = 39.75
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'PARK'  // Belleville Park
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 157.5625 -998.1875 30.375 radius 2.5 2.75 2.0 // TW@T CAFE
		then
			$USJ_NUMBER = 12
			$CAMERA_X = 141.5
			$CAMERA_Y = -1006.813
			$CAMERA_Z = 26.125
			goto @THE_JUMP
		end
	end
	goto @MISSION_START_USJ
end
if
	03C6:   current_island == LEVEL_SUBURBAN
then
	if
		0121:   player $PLAYER_CHAR in_zone 'SUB_IND'  // Pike Creek
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1182.438 22.1875 74.0 radius 3.0 4.0 3.0 // BAIT WAREHOUSE GOING EAST
		then
			$USJ_NUMBER = 8
			$CAMERA_X = -1204.438
			$CAMERA_Y = -14.6875
			$CAMERA_Z = 62.125
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'BIG_DAM'  // Cochrane Dam
	then
		if
		00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1160.563 105.9375 73.5 radius 4.0 3.5 3.0 // BAIT WAREHOUSE GOING SOUTH
		then
			$USJ_NUMBER = 9
			$CAMERA_X = -1137.688
			$CAMERA_Y = 115.125
			$CAMERA_Z = 64.375
			goto @THE_JUMP
		end
		if
		00E5:   player $PLAYER_CHAR 0 -994.75 253.5625 radius 10.0 15.0 // BY COCHRANE BRIDGE
		then
			$USJ_NUMBER = 15
			$CAMERA_X = -1014.438
			$CAMERA_Y = 268.125
			$CAMERA_Z = 38.875
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'PROJECT'  // Wichita Gardens
	then
		if
		00E5:   player $PLAYER_CHAR 0 -699.0 -172.25 radius 6.0 7.0 // JAMES BOND BRIDGE
		then
			$USJ_NUMBER = 16
			$CAMERA_X = -738.0
			$CAMERA_Y = -132.5625
			$CAMERA_Z = 12.5
			goto @THE_JUMP
		end
	end
	if
		0121:   player $PLAYER_CHAR in_zone 'AIRPORT'  // Francis Intl. Airport
	then
		if
			00E5:   player $PLAYER_CHAR 0 -1100.5 -847.4375 radius 4.0 12.0 // AIRPORT HANGAR SE
		then
			$USJ_NUMBER = 17
			$CAMERA_X = -1068.0
			$CAMERA_Y = -863.0
			$CAMERA_Z = 18.375
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 -1375.75 -848.625 radius 4.0 12.0 // AIRPORT HANGAR SW
		then
			$USJ_NUMBER = 18
			$CAMERA_X = -1337.688
			$CAMERA_Y = -862.9375
			$CAMERA_Z = 18.0
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 -1379.813 -625.0625 radius 12.0 4.0 // AIRPORT HANGAR NW
		then
			$USJ_NUMBER = 19
			$CAMERA_X = -1397.5
			$CAMERA_Y = -572.0
			$CAMERA_Z = 18.875
			goto @THE_JUMP
		end
		if
			00E5:   player $PLAYER_CHAR 0 -1177.375 -569.875 radius 3.25 2.0 // AIRPORT PLANE
		then
			$USJ_NUMBER = 20
			$CAMERA_X = -1195.125
			$CAMERA_Y = -560.6875
			$CAMERA_Z = 18.875
			goto @THE_JUMP
		end
	end
	goto @MISSION_START_USJ
end
goto @MISSION_START_USJ

:THE_JUMP
0004: $FLAG_1ST_LOCATE_USJ = 0  
0004: $FLAG_2ND_LOCATE_USJ = 0  
0004: $COLLISION_COUNTER_USJ = 0
015D: set_time_scale 0.25
015F: set_camera_position $CAMERA_X $CAMERA_Y $CAMERA_Z rotation 0.0 0.0 0.0
0158: camera_on_vehicle $PLAYERS_CAR_USJ mode FIXED switchstyle JUMP_CUT
while true
	if or
		81F3:   car $PLAYERS_CAR_USJ airborne
		001A:   10 > $COLLISION_COUNTER_USJ
	jf break
	0008: $COLLISION_COUNTER_USJ += 1
	wait 0 ms
	if or
		0119:   car $PLAYERS_CAR_USJ wrecked
		8256:   not is_player $PLAYER_CHAR defined
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
	if or
		02BF:   car $PLAYERS_CAR_USJ sunk
		80E0:   not is_player_in_any_car $PLAYER_CHAR 
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
	if
		0038: $USJ_NUMBER == 1
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 946.5 -934.0625 26.75 radius 1.0 4.0 6.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 993.5 -933.75 21.75 radius 1.0 4.0 6.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 2
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1190.0 -1154.0 25.0 radius 1.0 10.0 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1243.563 -1154.0 13.5 radius 20.0 15.0 3.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 3
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 789.3125 -563.25 29.1875 radius 10.0 0.5 5.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 789.3125 -558.875 29.1875 radius 10.0 0.5 5.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 4
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 470.6875 -931.6875 24.8125 radius 9.0 0.5 8.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 470.5 -962.8125 16.5625 radius 6.5 14.5 2.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 5
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1205.563 -1124.813 25.8125 radius 1.0 15.0 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1182.75 -1124.813 25.8125 radius 1.0 15.0 10.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 6
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1127.438 -978.875 29.125 radius 1.0 15.0 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
		end
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1104.75 -978.875 29.125 radius 1.0 15.0 10.0 
		then
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 7
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1376.938 -984.625 23.5 radius 8.0 0.5 7.5 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 8
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1197.688 -41.8125 63.6875 radius 30.0 5.5 8.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 9
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1095.625 116.75 60.25 radius 16.5 4.0 2.5 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 10
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 995.1875 -440.1875 26.4375 radius 4.25 0.5 5.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 11
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 879.6875 -933.75 26.8125 radius 30.0 5.5 0.5 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 12
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 130.25 -999.8125 32.375 radius 0.5 6.0 7.5 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 13
	then
		if
			00E5:   player $PLAYER_CHAR 0 271.8125 -656.375 radius 5.0 5.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 14
	then
		if
			00E5:   player $PLAYER_CHAR 0 308.1875 -942.1875 radius 23.0 5.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 15
	then
		if
			00E5:   player $PLAYER_CHAR 0 -1073.688 246.75 radius 38.0 22.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 16
	then
		if
			00E5:   player $PLAYER_CHAR 0 -706.3125 -91.0625 radius 18.0 30.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 17
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1067.938 -847.6875 27.5 radius 0.5 14.5 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 18
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1342.625 -847.8125 26.875 radius 0.5 14.5 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 19
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1380.25 -573.4375 22.625 radius 14.25 0.5 10.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if
		0038: $USJ_NUMBER == 20
	then
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car -1184.0 -569.875 24.25 radius 0.5 6.0 8.0 
		then
			0004: $FLAG_1ST_LOCATE_USJ = 1
			0004: $FLAG_2ND_LOCATE_USJ = 1
		end
	end
	if and
		0038:   $FLAG_1ST_LOCATE_USJ == 1
		0038:   $FLAG_2ND_LOCATE_USJ == 1
	then
		goto @MISSION_USJ_PASSED
	end
end //while
while 01F3:   car $PLAYERS_CAR_USJ airborne
	wait 0 ms
	if or
		0119:   car $PLAYERS_CAR_USJ wrecked
		8256:   not is_player $PLAYER_CHAR defined
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
	if or
		02BF:   car $PLAYERS_CAR_USJ sunk
		80E0:   not is_player_in_any_car $PLAYER_CHAR 
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
end //while
wait 600 ms

:CAMERA_RESTORE_IF_FAIL
015D: set_time_scale 1.0 
02EB: restore_camera_jumpcut
goto @MISSION_START_USJ

:MISSION_USJ_PASSED
while 01F3:   car $PLAYERS_CAR_USJ airborne
	wait 0 ms
	if or
		0119:   car $PLAYERS_CAR_USJ wrecked
		8256:   not is_player $PLAYER_CHAR defined
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
	if or
		02BF:   car $PLAYERS_CAR_USJ sunk
		80E0:   not is_player_in_any_car $PLAYER_CHAR 
	then
		goto @CAMERA_RESTORE_IF_FAIL
	end
end //while
wait 600 ms
015D: set_time_scale 1.0 
02EB: restore_camera_jumpcut
if and
	0038:   $USJ_NUMBER == 1
	0038:   $FLAG_USJ1_PASSED == 0
then
	0004: $FLAG_USJ1_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 2
	0038:   $FLAG_USJ2_PASSED == 0
then
	0004: $FLAG_USJ2_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 3
	0038:   $FLAG_USJ3_PASSED == 0
then
	0004: $FLAG_USJ3_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 4
	0038:   $FLAG_USJ4_PASSED == 0
then
	0004: $FLAG_USJ4_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 5
	0038:   $FLAG_USJ5_PASSED == 0
then
	0004: $FLAG_USJ5_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 6
	0038:   $FLAG_USJ6_PASSED == 0
then
	0004: $FLAG_USJ6_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 7
	0038:   $FLAG_USJ7_PASSED == 0
then
	0004: $FLAG_USJ7_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 8
	0038:   $FLAG_USJ8_PASSED == 0
then
	0004: $FLAG_USJ8_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 9
	0038:   $FLAG_USJ9_PASSED == 0
then
	0004: $FLAG_USJ9_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 10
	0038:   $FLAG_USJ10_PASSED == 0
then
	0004: $FLAG_USJ10_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 11
	0038:   $FLAG_USJ11_PASSED == 0
then
	0004: $FLAG_USJ11_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 12
	0038:   $FLAG_USJ12_PASSED == 0
then
	0004: $FLAG_USJ12_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 13
	0038:   $FLAG_USJ13_PASSED == 0
then
	0004: $FLAG_USJ13_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 14
	0038:   $FLAG_USJ14_PASSED == 0
then
	0004: $FLAG_USJ14_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 15
	0038:   $FLAG_USJ15_PASSED == 0
then
	0004: $FLAG_USJ15_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 16
	0038:   $FLAG_USJ16_PASSED == 0
then
	0004: $FLAG_USJ16_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 17
	0038:   $FLAG_USJ17_PASSED == 0
then
	0004: $FLAG_USJ17_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 18
	0038:   $FLAG_USJ18_PASSED == 0
then
	0004: $FLAG_USJ18_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 19
	0038:   $FLAG_USJ19_PASSED == 0
then
	0004: $FLAG_USJ19_PASSED = 1
	goto @REWARD_USJ
end
if and
	0038:   $USJ_NUMBER == 20
	0038:   $FLAG_USJ20_PASSED == 0
then
	0004: $FLAG_USJ20_PASSED = 1
	goto @REWARD_USJ
end
goto @MISSION_START_USJ

:REWARD_USJ
0008: $TOTAL_COMPLETED_USJ += 1
030C: set_mission_points += 1
if
	001A:   20 > $TOTAL_COMPLETED_USJ
then
	0217: text_big_styled 'USJ' duration 5000 ms style 5  // UNIQUE STUNT BONUS!
	01E3: text_1number_styled 'REWARD' number $CASH_REWARD_USJ duration 6000 ms style 6  // REWARD $~1~
	0109: player $PLAYER_CHAR money += $CASH_REWARD_USJ
else
	0217: text_big_styled 'USJ_ALL' duration 5000 ms style 5  // ALL UNIQUE STUNTS COMPLETED!
	01E3: text_1number_styled 'REWARD' number 1000000 duration 6000 ms style 6  // REWARD $~1~
	0109: player $PLAYER_CHAR money += 1000000
end
018C: play_sound SOUND_PART_MISSION_COMPLETE at 0.0 0.0 0.0
0313: increment_unique_jumps_found
0008: $CASH_REWARD_USJ += 5000
goto @MISSION_START_USJ
