// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************Frankie Mission 2*************************************
// **********************************"Cuttin' The Grass"************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M14_CUTTINGTHEGRASS

gosub @MISSION_START_FRANK2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_FRANK2
end

:MISSION_END_FRANK2
gosub @MISSION_CLEANUP_FRANK2
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_FRANK2
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_FRANK = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
0004: $HOURS_FM2 = 0 
0004: $MINUTES_FM2 = 0 
0004: $HOURS_STUFF_HAPPEN_FM2 = 0 
0004: $MINUTES_STUFF_HAPPEN_FM2 = 0 
0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_FM2 = 0 
0004: $FLAG_PLAYER_GOT_COPS_MESSAGE_FM2 = 0 
0004: $TIME_CAR_STOPPED_FM2 = 0 
0004: $FLAG_CAR_HAS_JUST_STOPPED = 0 
0004: $TIMER_DIFFERENCE = 0 
0004: $FLAG_TAXI1_EXIT_CAR_FM2 = 0 
0004: $FLAG_TAXI2_EXIT_CAR_FM2 = 0 
0004: $FLAG_CAR_FM2_CREATED = 0 
0004: $FLAG_MISSION_TAXI_FM2_CREATED = 0 
0004: $FLAG_CURLEY_AT_POINT1_FM2 = 0 
0004: $FLAG_CURLEY_AT_POINT2_FM2 = 0 
0004: $FLAG_CURLEY_BOB_FM2_DEAD = 0 
0004: $FLAG_BOB_IN_POSITION_ONE = 0 
0004: $FLAG_BOB_IN_POSITION_TWO = 0 
0004: $FLAG_BOB_IN_POSITION_THREE = 0 
0004: $FLAG_CURLEY_BOB_DEAD_FM2 = 0 
0004: $CAR_HEALTH_FM2 = 0 
0004: $BLOB_FLAG = 1 
0004: $FLAG_CAR_FM2_DEAD = 0 
0005: $CAR_FM2_X = 0.0 
0005: $CAR_FM2_Y = 0.0 
0005: $CAR_FM2_Z = 0.0 
0004: $FLAG_CURLY_MAD_FM2 = 0 
0004: $SPOOKED_COUNTER = 0 
0004: $SPOOKED_CHECK = 0 
0004: $FLAG_PLAYER_HAD_WARNING1_FM2 = 0 
0004: $FLAG_PLAYER_HAD_WARNING2_FM2 = 0 
0004: $FLAG_CURLY_MOVED_FM2 = 0 
023C: load_special_actor 'FRANKIE' as 1 
0247: request_model #GANG02 
02F3: load_object #CUTOBJ01 'FRANKH' 
0247: request_model #FRANKSCLB02 
0247: request_model #SALVSDETAIL 
0247: request_model #SWANK_INSIDE 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #GANG02 available 
		8248:   not model #CUTOBJ01 available
		8248:   not model #FRANKSCLB02 available 
		8248:   not model #SALVSDETAIL available 
		8248:   not model #SWANK_INSIDE available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'S2_CTG' 
0244: set_cutscene_pos 1457.75 -185.3125 54.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_SALVATORE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_SALVATORE 'FRANKIE' 
02F4: create_cutscene_actor $SALVATORE_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_SALVATORE 
02F5: set_head_anim $SALVATORE_CSHEAD 'FRANK' 
02E5: $CUTSCENE_MAFIA = create_cutscene_object #GANG02 
02E6: set_cutscene_anim $CUTSCENE_MAFIA 'GANG02' 
0395: clear_area 1 at 1455.063 -187.75 range -100.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1455.063 -187.75 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   1726 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_J' duration 10000 ms flag 1  // Leave us alone for a minute.
while 001A:   2910 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'FM2_J'  // Leave us alone for a minute.
while 001A:   4558 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_A' duration 10000 ms flag 1  // The Colombian Cartel is making SPANK somewhere in Liberty.
while 001A:   7896 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_K' duration 10000 ms flag 1  // but we don't know where, and they seem to know everything we're doin' before we do.
while 001A:   13257 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_B' duration 10000 ms flag 1  // We got us a rat!
while 001A:   15103 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_L' duration 10000 ms flag 1  // There is a guy named Curly Bob works the bar at Luigi's.
while 001A:   18415 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_M' duration 10000 ms flag 1  // He's been throwing more money around than he's earning.
while 001A:   21238 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_C' duration 10000 ms flag 1  // He ain't pimpin' or pushin' so he must be talking.
while 001A:   25040 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_N' duration 10000 ms flag 1  // He usually gets a taxi home after work. So follow him.
while 001A:   28251 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM2_O' duration 10000 ms flag 1  // And if he's rattin' us out... kill him.
while 001A:   30960 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'FM2_O'  // And if he's rattin' us out... kill him.
while 001A:   38333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1500 ms

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

00BE: clear_prints 

while fading
	wait 0 ms
end

02EA: end_cutscene 
03AD: set_rubbish 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #GANG02 
0249: release_model #FRANKSCLB02 
0249: release_model #SALVSDETAIL 
0249: release_model #SWANK_INSIDE 

// *******************************************END OF CUTSCENE*******************************

023C: load_special_actor 'CURLY' as 2 
0247: request_model #TAXI 
0247: request_model #TAXI_D

while true
	if or
		823D:   not special_actor 2 loaded 
		8248:   not model #TAXI available 
		8248:   not model #TAXI_D available
	jf break
	wait 0 ms
end //while

while fading
	wait 0 ms
end

015C: set_zone_gang_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

// CREATES THE TAXI FOR THE BLOKE TO GET INTO

00BC: print_now 'FM2_11' duration 5000 ms flag 1  // ~g~Park out the front of Luigi's Club, Curly Bob will be leaving shortly.
018A: $FRANK2_CHECKPOINT1 = create_checkpoint_at 907.0 -424.6875 13.75 
00A5: $CAR_FM2 = create_car #TAXI at 906.875 -433.6875 -100.0
02AA: set_car $CAR_FM2 immune_to_nonplayer 1 
0004: $FLAG_CAR_FM2_CREATED = 1 
0175: set_car $CAR_FM2 z_angle_to 180.0 
0135: set_car $CAR_FM2 door_lock CARLOCK_LOCKOUT_PLAYER_ONLY
0129: $VAN_DRIVER_FM2 = create_actor PEDTYPE_CIVMALE #TAXI_D in_car $CAR_FM2 driverseat
039E: set_char_cant_be_dragged_out $VAN_DRIVER_FM2 to 1 
01ED: clear_actor $VAN_DRIVER_FM2 threat_search 
00A9: car_set_idle $CAR_FM2 
02A3: toggle_widescreen 0 
015A: restore_camera 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
0006: 17@ = 0

while 001B:   55000 > 17@
	wait 0 ms
end

// checks to see where curly will be created

if or
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 901.1875 -427.75 12.0 to 878.0625 -422.375 27.0 sphere 0 
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 878.0625 -422.375 12.0 to 900.375 -404.1875 27.0 sphere 0
then
	// creates curley bob infront of the club
	0395: clear_area 1 at 902.875 -398.75 range 14.0 1.0 
	009A: $CURLY_BOB_FM2 = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 902.875 -398.75 14.0
	0187: $RADAR_BLIP_PED1_FM2 = create_marker_above_actor $CURLY_BOB_FM2 
	018B: show_on_radar $RADAR_BLIP_PED1_FM2 MARKER_ONLY
	01ED: clear_actor $CURLY_BOB_FM2 threat_search 
	0211: actor $CURLY_BOB_FM2 walk_to 902.6875 -430.375 
	0006: 17@ = 0
	while 80ED:   not actor $CURLY_BOB_FM2 #NULL 902.6875 -430.375 radius 1.0 1.0 
		wait 0 ms
		gosub @CHECK_CURLY_STATUS_FRANK2
		if and
			0038:   $FLAG_CURLY_MOVED_FM2 == 0 
			0029:   17@ >= 15000 
			80ED:   not actor $CURLY_BOB_FM2 #NULL 902.6875 -430.375 radius 1.0 1.0
		then
			00A1: set_char_coordinates $CURLY_BOB_FM2 to 902.6875 -430.375 13.6875 
			0004: $FLAG_CURLY_MOVED_FM2 = 1
		end
	end //while
	009F: char_set_idle $CURLY_BOB_FM2 
else
	// creates curley bob down the alleyway
	0395: clear_area 1 at 886.25 -422.1875 range 13.75 1.0 
	009A: $CURLY_BOB_FM2 = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 886.25 -422.1875 13.75
	0187: $RADAR_BLIP_PED1_FM2 = create_marker_above_actor $CURLY_BOB_FM2 
	018B: show_on_radar $RADAR_BLIP_PED1_FM2 MARKER_ONLY
	01ED: clear_actor $CURLY_BOB_FM2 threat_search 
	0211: actor $CURLY_BOB_FM2 walk_to 888.0 -425.0 
	0395: clear_area 0 at 887.375 -417.25 range 13.875 10.0 // This should get rid of anything is his way
	0395: clear_area 0 at 892.75 -425.5 range 13.875 3.0 
	0395: clear_area 0 at 896.25 -425.5625 range 13.75 3.0 
	0395: clear_area 0 at 899.0625 -424.5625 range 14.0 3.0 
	0395: clear_area 0 at 903.375 -425.5625 range 13.875 2.0 
	//waiting for curly bob to get to the pavement
	0006: 17@ = 0 

	while 80ED:   not actor $CURLY_BOB_FM2 #NULL 904.0 -427.25 radius 1.0 1.0 
		wait 0 ms
		gosub @CHECK_CURLY_STATUS_FRANK2
		if
			00ED:   actor $CURLY_BOB_FM2 #NULL 888.0 -425.0 radius 1.0 1.0
		then
			0239: actor $CURLY_BOB_FM2 run_to 892.0625 -425.25
		end
		if
			00ED:   actor $CURLY_BOB_FM2 #NULL 892.0625 -425.25 radius 1.0 1.0 
		then
			0211: actor $CURLY_BOB_FM2 walk_to 904.0 -427.25
		end
		if and
			0038:   $FLAG_CURLY_MOVED_FM2 == 0 
			0029:   17@ >= 25000 
			80ED:   not actor $CURLY_BOB_FM2 #NULL 904.0 -427.25 radius 1.0 1.0
		then
			00A1: set_char_coordinates $CURLY_BOB_FM2 to 904.0 -427.25 13.875 
			0004: $FLAG_CURLY_MOVED_FM2 = 1
		end
	end //while
	009F: char_set_idle $CURLY_BOB_FM2 
end

0164: disable_marker $FRANK2_CHECKPOINT1 

// Checks to see which part of the mission the player will get

if
	819B:   not player $PLAYER_CHAR stopped 0 905.0 -432.0 910.0 -419.0 
then
	goto @MISSION_JUMP3
end

// Checks to see if the player is in the area in a taxi

if or
	00DE:   is_player_in_model $PLAYER_CHAR model #TAXI 
	00DE:   is_player_in_model $PLAYER_CHAR model #CABBIE 
	00DE:   is_player_in_model $PLAYER_CHAR model #BORGNINE 
then
	00DA: $MISSION_TAXI_FM2 = store_car_player_is_in $PLAYER_CHAR
	0004: $FLAG_MISSION_TAXI_FM2_CREATED = 1
else
	goto @MISSION_JUMP3
end

// *********************If player is in a taxi launches part one of the mission************* 

if and
	00E8:   player $PLAYER_CHAR stopped 0 906.0 -425.0 radius 4.0 4.0 
	00DC:   is_player_in_car $PLAYER_CHAR car $MISSION_TAXI_FM2 
then
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
	if or
		00DE:   is_player_in_model $PLAYER_CHAR model #TAXI 
		00DE:   is_player_in_model $PLAYER_CHAR model #CABBIE
	then
		00DA: $MISSION_TAXI_FM2 = store_car_player_is_in $PLAYER_CHAR
	end
	gosub @CHECK_PLAYER_VEHICLE_STATUS_FRANK2
	if
		8185:   not car $MISSION_TAXI_FM2 health >= 950 
	then
		00BC: print_now 'FM2_6' duration 5000 ms flag 1  // ~r~Curly won't get into a smashed-up taxi!
		goto @MISSION_FAILED_FRANK2
	end
	01D4: actor $CURLY_BOB_FM2 go_to_car $MISSION_TAXI_FM2 and_enter_it_as_a_passenger 
	while 80DB:   not is_char_in_car $CURLY_BOB_FM2 car $MISSION_TAXI_FM2 
		wait 0 ms
		gosub @CHECK_PLAYER_VEHICLE_STATUS_FRANK2
		gosub @CHECK_CURLY_STATUS_FRANK2
		if
			80EB:   not player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 5.0 5.0 
		then
			00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
			goto @MISSION_FAILED_FRANK2
		end
	end //while
	0164: disable_marker $RADAR_BLIP_PED1_FM2 
	00BC: print_now 'FM2_5' duration 7000 ms flag 1  // ~g~Take him to Portland Harbor.
	018A: $RADAR_BLIP_COORD2_FM2 = create_checkpoint_at 1529.0 -827.0 -100.0 
	0004: $BLOB_FLAG = 1
	while true
		if or
			80E8:   not player $PLAYER_CHAR stopped $BLOB_FLAG 1529.0 -827.0 radius 3.0 4.0 
			80DB:   not is_char_in_car $CURLY_BOB_FM2 car $MISSION_TAXI_FM2 
			80DC:   not is_player_in_car $PLAYER_CHAR car $MISSION_TAXI_FM2 
		jf break
		wait 0 ms
		gosub @CHECK_PLAYER_VEHICLE_STATUS_FRANK2
		gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
		if
			80DB:   not is_char_in_car $CURLY_BOB_FM2 car $MISSION_TAXI_FM2
		then
			00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
			goto @MISSION_FAILED_FRANK2
		end
		gosub @CHECK_IN_VEHICLE_STATUS_FRANK2
		if
			01C1:   car $MISSION_TAXI_FM2 stopped
		then
			if
				0038:   $FLAG_CAR_HAS_JUST_STOPPED == 0 
			then
				0006: 17@ = 0 
				0004: $FLAG_CAR_HAS_JUST_STOPPED = 1 
			end
			if
				0019:   17@ > 10000 
			then
				00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
				goto @MISSION_FAILED_FRANK2
			end
		else
			0004: $FLAG_CAR_HAS_JUST_STOPPED = 0
		end
	end //while
	0164: disable_marker $RADAR_BLIP_COORD2_FM2
	goto @MISSION_JUMP2
end

// *********If player does not have a taxi creates taxi for Curley Bob to get into**********

:MISSION_JUMP3
gosub @CHECK_AI_VEHICLE_STATUS_FRANK2
if and
	01AE:   car $CAR_FM2 stopped 0 906.875 -433.0 6.0 6.0 
	81F4:   not car $CAR_FM2 flipped 
then
	01D4: actor $CURLY_BOB_FM2 go_to_car $CAR_FM2 and_enter_it_as_a_passenger 
else
	00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
	goto @MISSION_FAILED_FRANK2
end

//waiting for the character to get into the car
while 80DB:   not is_char_in_car $CURLY_BOB_FM2 car $CAR_FM2 
	wait 0 ms
	gosub @CHECK_CURLY_STATUS_FRANK2
	gosub @CHECK_AI_VEHICLE_STATUS_FRANK2
end //while

0164: disable_marker $RADAR_BLIP_PED1_FM2 
00BC: print_now 'FM2_2' duration 7000 ms flag 1  // ~g~Curly's left the club, tail him!
02A3: toggle_widescreen 0 
015A: restore_camera 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
0186: $RADAR_BLIP_CAR2_FM2 = create_marker_above_car $CAR_FM2 
018B: show_on_radar $RADAR_BLIP_CAR2_FM2 MARKER_ONLY
02C2: car $CAR_FM2 drive_to_point 1529.0 -827.0 -100.0 
00AE: set_car_driving_style $CAR_FM2 to DRIVINGMODE_AVOIDCARS
00AD: set_car_cruise_speed $CAR_FM2 to 25.0 
03CC: car $CAR_FM2 add_to_stuck_car_check 5.0 = 30000 
03C4: set_status_text_to $SPOOKED_COUNTER COUNTER_DISPLAY_BAR 'FM2_16'  // SPOOKOMETER:
0006: 17@ = 0 
0006: 16@ = 0 

// Waiting for the car to get to the bottom of the dock area

while 81AD:   not car $CAR_FM2 sphere 0 near_point 1529.0 -827.0 radius 3.0 3.0 
	wait 0 ms
	if and
		0038:   $SPOOKED_CHECK == 0 
		0019:   17@ > 1500 
	then
		0004: $SPOOKED_CHECK = 1 
	end
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
	gosub @CHECK_AI_VEHICLE_STATUS_FRANK2
	if
		03CE:   car $CAR_FM2 stuck
	then
		00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
		goto @MISSION_FAILED_FRANK2
	end
	0395: clear_area 0 at 1529.0 -827.0 range -100.0 4.0 // This should clear the area at the bottom of the docks
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
	if
		0038:   $SPOOKED_CHECK == 1 
	then
		if
			00FB:   player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 40.0 40.0 40.0 
		then
			if
				00FB:   player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 30.0 30.0 30.0 
			then		
				if
					00FB:   player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 20.0 20.0 20.0 
				then
					if
						00DE:   is_player_in_model $PLAYER_CHAR model #MAFIA
					then
						if
							0019:   16@ > 8
						then
							0008: $SPOOKED_COUNTER += 1 
							0006: 16@ = 0
						end
					else
						if
							0019:   16@ > 16
						then
							0008: $SPOOKED_COUNTER += 1 
							0006: 16@ = 0
						end
					end
				else
					if
						00DE:   is_player_in_model $PLAYER_CHAR model #MAFIA
					then
						if
							0019:   16@ > 16
						then
							0008: $SPOOKED_COUNTER += 1 
							0006: 16@ = 0
						end
					else
						if
							0019:   16@ > 32
						then
							0008: $SPOOKED_COUNTER += 1 
							0006: 16@ = 0
						end
					end
				end
			else
				if
					00DE:   is_player_in_model $PLAYER_CHAR model #MAFIA
				then
					if
						0019:   16@ > 32
					then
						0008: $SPOOKED_COUNTER += 1 
						0006: 16@ = 0
					end
				else
					if
						0019:   16@ > 64
					then
						0008: $SPOOKED_COUNTER += 1 
						0006: 16@ = 0
					end
				end
			end
		else
			if
				00DE:   is_player_in_model $PLAYER_CHAR model #MAFIA
			then
				if
					0019:   16@ > 500
				then
					if
						0018:   $SPOOKED_COUNTER > 0 
					then
						000C: $SPOOKED_COUNTER -= 1 
					end
					0006: 16@ = 0
				end
			else
				if
					0019:   16@ > 250
				then
					if
						0018:   $SPOOKED_COUNTER > 0 
					then
						000C: $SPOOKED_COUNTER -= 1 
					end
					0006: 16@ = 0
				end
			end
		end
	end
	if and
		0018:   $SPOOKED_COUNTER > 10 
		0038:   $FLAG_PLAYER_HAD_WARNING1_FM2 == 0
	then
		00BC: print_now 'FM2_15' duration 5000 ms flag 1  // ~g~Don't get too close or Curly will suspect something!
		0004: $FLAG_PLAYER_HAD_WARNING1_FM2 = 1
	end
	if
		0038:   $SPOOKED_COUNTER == 100
	then
		00BC: print_now 'FM2_14' duration 5000 ms flag 1  // ~r~You got too close and spooked Curly!
		goto @MISSION_FAILED_FRANK2
	end
	if
		80DB:   not is_char_in_car $CURLY_BOB_FM2 car $CAR_FM2 
	then
		0004: $SPOOKED_COUNTER = 100 
		00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
		goto @MISSION_FAILED_FRANK2
	end
	if
		03C9:   car $CAR_FM2 damaged
	then
		gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
		0004: $SPOOKED_COUNTER = 100 
		00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
		goto @MISSION_FAILED_FRANK2
	end
	if
		01C1:   car $CAR_FM2 stopped
	then
		if
			0038:   $FLAG_CAR_HAS_JUST_STOPPED == 0
		then
			01BD: $TIME_CAR_STOPPED_FM2 = current_time_in_ms 
			0004: $FLAG_CAR_HAS_JUST_STOPPED = 1 
		end
		01BD: $CURRENT_TIME_FM2 = current_time_in_ms 
		0084: $TIMER_DIFFERENCE = $CURRENT_TIME_FM2 
		0060: $TIMER_DIFFERENCE -= $TIME_CAR_STOPPED_FM2
		if
			0018:   $TIMER_DIFFERENCE > 15000
		then
			0004: $FLAG_TAXI2_EXIT_CAR_FM2 = 1 
			0004: $SPOOKED_COUNTER = 100 
			00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
			goto @MISSION_FAILED_FRANK2
		end
	else
		0004: $FLAG_CAR_HAS_JUST_STOPPED = 0
	end
end //while

0164: disable_marker $RADAR_BLIP_CAR2_FM2 
03CD: car $CAR_FM2 remove_from_stuck_car_check 

// ********************Curley Bob gets out of the script controlled taxi********************

if and
	0038:   $FLAG_CAR_FM2_CREATED == 1 
	00DB:   is_char_in_car $CURLY_BOB_FM2 car $CAR_FM2
then
	0004: $FLAG_TAXI2_EXIT_CAR_FM2 = 1 
end

if
	0038:   $FLAG_TAXI2_EXIT_CAR_FM2 == 1
then
	01D3: actor $CURLY_BOB_FM2 leave_car $CAR_FM2 
	while 00DB:   is_char_in_car $CURLY_BOB_FM2 car $CAR_FM2
		wait 0 ms
		gosub @CHECK_CURLY_STATUS_FRANK2
		gosub @CHECK_AI_VEHICLE_STATUS_FRANK2
	end //while
	0151: remove_status_text $SPOOKED_COUNTER
	if
		80FB:   not player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 160.0 160.0 160.0 
	then
		00BC: print_now 'FM2_12' duration 5000 ms flag 1  // ~r~He gave you the slip!
		goto @MISSION_FAILED_FRANK2
	end

	// Checks to see if the player is around the ramp and will fail the mission
	if
		0057:   is_player_in_area_3d $PLAYER_CHAR coords 1573.688 -876.4375 5.0 to 1404.063 -1034.25 30.0 sphere 0
	then
		0004: $SPOOKED_COUNTER = 100 
		00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
		goto @MISSION_FAILED_FRANK2
	end
	goto @MISSION_JUMP4
end

// *****************Orders Curley Bob out of the taxi if the player is driving**************

:MISSION_JUMP2

if and
	0038:   $FLAG_MISSION_TAXI_FM2_CREATED == 1 
	00DB:   is_char_in_car $CURLY_BOB_FM2 car $MISSION_TAXI_FM2
then
	0004: $FLAG_TAXI1_EXIT_CAR_FM2 = 1 
end

if
	0038:   $FLAG_TAXI1_EXIT_CAR_FM2 == 1
then
	01D3: actor $CURLY_BOB_FM2 leave_car $MISSION_TAXI_FM2 
	while 00DB:   is_char_in_car $CURLY_BOB_FM2 car $MISSION_TAXI_FM2
		wait 0 ms
		gosub @CHECK_CURLY_STATUS_FRANK2
		gosub @CHECK_PLAYER_VEHICLE_STATUS_FRANK2
	end //while
	if
		80FB:   not player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 160.0 160.0 160.0 
	then
		00BC: print_now 'FM2_12' duration 5000 ms flag 1  // ~r~He gave you the slip!
		goto @MISSION_FAILED_FRANK2
	end
end

// ***********************Curley Bob has finally got to the docks***************************

:MISSION_JUMP4

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
0395: clear_area 1 at 1546.5 -834.75 range 12.6875 1.0 
015F: set_camera_position 1546.5 -834.75 12.6875 0.0 rotation 0.0 0.0 
0160: point_camera 1545.5 -834.5625 12.75 switchstyle JUMP_CUT
0239: actor $CURLY_BOB_FM2 run_to 1532.0 -889.0 
0006: 17@ = 0

while 001B:   1500 > 17@
	wait 0 ms
	0395: clear_area 0 at 1532.0 -889.0 range -100.0 3.0 // Clears area curly is running to.
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
end //while

gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2

// ************************************START OF CUTSCENE TWO********************************

0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 

while fading
	wait 0 ms
end

if
	8118:   not actor $CURLY_BOB_FM2 dead
then
	009F: char_set_idle $CURLY_BOB_FM2 
end

0395: clear_area 1 at 898.5625 -425.5625 range 13.875 1.0 
015F: set_camera_position 1546.5 -834.75 12.6875 rotation 0.0 0.0 0.0 
0159: camera_on_ped $CURLY_BOB_FM2 mode FIXED switchstyle JUMP_CUT

016A: fade 1 for 1500 ms

0006: 17@ = 0

while true
	if and
		001B:   7500 > 17@
		80E1:   not is_button_pressed PAD1 button CROSS
	jf break 
	wait 0 ms
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
	if and
		0019:   17@ > 4500
		0038:   $FM2_MESSAGE_FLAG_EXTRA == 0
	then
		00BC: print_now 'FM2EX1' duration 3500 ms flag 1  // ~w~Seems like Curly Bob is not the rat..
		0004: $FM2_MESSAGE_FLAG_EXTRA = 1
	end
end //while


016A: fade 0 for 1500 ms 

while fading
	wait 0 ms
end

009B: delete_char $CURLY_BOB_FM2 


if and
	0038:   $FLAG_CAR_FM2_DEAD == 0
	8119:   not car $CAR_FM2 wrecked
then
	009B: delete_char $VAN_DRIVER_FM2 
	00A6: delete_car $CAR_FM2
end


01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
015A: restore_camera 

wait 500 ms

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0  


02A3: toggle_widescreen 0
01B4: set_player $PLAYER_CHAR controllable 1 
016A: fade 1 for 1500 ms 

// ******************************************END OF CUTSCENE TWO****************************


// ********************************Don't kill Curley Bob Stuff************************************

015A: restore_camera 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
009A: $CURLY_BOB_FM2 = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 1493.688 -886.5625 -100.0
0173: set_actor $CURLY_BOB_FM2 z_angle_to 270.0 
01B2: give_actor $CURLY_BOB_FM2 weapon WEAPONTYPE_SHOTGUN ammo 30000 
01D0: actor $CURLY_BOB_FM2 avoid_player $PLAYER_CHAR 
0187: $RADAR_BLIP_PED2_FM2 = create_marker_above_actor $CURLY_BOB_FM2 

while true
	if or
		02CB:   is_actor_on_screen $CURLY_BOB_FM2 
		00FB:   player $PLAYER_CHAR 0 $CURLY_BOB_FM2 radius 160.0 160.0 80.0 
	jf break
	wait 0 ms
	gosub @CHECK_CURLY_STATUS_SIMPLE_FRANK2
end //while

goto @MISSION_PASSED_FRANK2

/////////////////////////////////////////

:CHECK_CURLY_STATUS_FRANK2
if
	0118:   actor $CURLY_BOB_FM2 dead 
then
	00BC: print_now 'FM2_9' duration 5000 ms flag 1  // ~r~Curly Bob's dead!
	goto @MISSION_FAILED_FRANK2
else
	if
		8184:   not actor $CURLY_BOB_FM2 health >= 99 
	then
		00BC: print_now 'FM2_7' duration 7000 ms flag 1  // ~r~Curly's spooked! The meeting's off!
		goto @MISSION_FAILED_FRANK2
	end
end
return

/////////////////////////////////////////

:CHECK_CURLY_STATUS_SIMPLE_FRANK2
if
	0118:   actor $CURLY_BOB_FM2 dead 
then
	00BC: print_now 'FM2_9' duration 5000 ms flag 1  // ~r~Curly Bob's dead!
	goto @MISSION_FAILED_FRANK2
end
return

/////////////////////////////////////////

:CHECK_PLAYER_VEHICLE_STATUS_FRANK2
if
	0119:   car $MISSION_TAXI_FM2 wrecked 
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_FRANK2
else
	if and
		01F4:   car $MISSION_TAXI_FM2 flipped 
		01C1:   car $MISSION_TAXI_FM2 stopped
	then
		00BC: print_now 'UPSIDE' duration 5000 ms flag 1  // ~r~You flipped your wheels!
		goto @MISSION_FAILED_FRANK2
	end
end
return

/////////////////////////////////////////

:CHECK_AI_VEHICLE_STATUS_FRANK2
if
	0119:   car $CAR_FM2 wrecked 
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	0004: $FLAG_CAR_FM2_DEAD = 0 
	goto @MISSION_FAILED_FRANK2
else
	if and
		01F4:   car $CAR_FM2 flipped 
		01C1:   car $CAR_FM2 stopped
	then
		00BC: print_now 'UPSIDE' duration 5000 ms flag 1  // ~r~You flipped your wheels!
		goto @MISSION_FAILED_FRANK2
	end
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_FRANK2
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $MISSION_TAXI_FM2 
	0038:   $FLAG_PLAYER_GOT_CAR_MESSAGE_FM2 == 0 
then
	00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	0186: $RADAR_BLIP_CAR1_FM2 = create_marker_above_car $MISSION_TAXI_FM2 
	0164: disable_marker $RADAR_BLIP_COORD2_FM2 
	0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_FM2 = 1 
	0004: $BLOB_FLAG = 0 
end
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $MISSION_TAXI_FM2 
	0038:   $FLAG_PLAYER_GOT_CAR_MESSAGE_FM2 == 1 
then
	018A: $RADAR_BLIP_COORD2_FM2 = create_checkpoint_at 1529.0 -827.0 -100.0 
	018B: show_on_radar $RADAR_BLIP_COORD2_FM2 BLIP_ONLY 
	0164: disable_marker $RADAR_BLIP_CAR1_FM2 
	0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_FM2 = 0 
	0004: $BLOB_FLAG = 1
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_FRANK2
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
034F: destroy_actor_with_fade $CURLY_BOB_FM2 
goto @MISSION_END_FRANK2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_FRANK2
0004: $CUTTING_THE_GRASS_COMPLETED = 1 
0318: set_latest_mission_passed 'FM2'  // 'CUTTING THE GRASS'
030C: set_mission_points += 1 
01E3: text_1number_styled 'M_PASS' number 15000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 15000 
0110: clear_player $PLAYER_CHAR wanted_level 
004F: create_thread @FRANKIE_MISSION21_LOOP 
004F: create_thread @TONI4_PAGER_LOOP 
if 
	0038:   $BLOW_FISH_COMPLETED == 0 
then
	0004: $FLAG_FRANKIE_SWITCHED_OFF = 1 
	0164: disable_marker $SALVATORE_MISSION_MARKER
end
goto @MISSION_END_FRANK2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_FRANK2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_FRANK = 0 
if and
	0038:   $FLAG_CAR_FM2_DEAD == 0 
	8119:   not car $CAR_FM2 wrecked 
then
	0135: set_car $CAR_FM2 door_lock CARLOCK_UNLOCKED
	02AA: set_car $CAR_FM2 immune_to_nonplayer 0 
end
0249: release_model #TAXI 
0249: release_model #COLUMB 
0249: release_model #TAXI_D 
0164: disable_marker $FRANK2_CHECKPOINT1 
0164: disable_marker $RADAR_BLIP_PED1_FM2 
0164: disable_marker $RADAR_BLIP_COORD2_FM2 
0164: disable_marker $RADAR_BLIP_CAR1_FM2 
0164: disable_marker $RADAR_BLIP_CAR2_FM2 
0164: disable_marker $RADAR_BLIP_PED2_FM2 
015C: set_zone_gang_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0151: remove_status_text $SPOOKED_COUNTER 
00D8: mission_has_finished 
return
