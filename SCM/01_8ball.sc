// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **************************************8Ball Mission**************************************
// **************************************Luigi's Girls**************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

:M01_GIVEMELIBERTY
03A4: name_thread 'EIGHT' 

// Mission start stuff

gosub @MISSION_START_EIGHTBALL 
if 
	wasted_or_busted 
then
	gosub @MISSION_FAILED_EIGHTBALL 
end

:MISSION_END_EIGHTBALL
gosub @MISSION_CLEANUP_EIGHTBALL 
end_thread 

// ***************************************Mission Start*************************************

:MISSION_START_EIGHTBALL
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_8BALL = 1 
0317: increment_mission_attempts 
01B6: set_weather WEATHER_CLOUDY
00C0: set_current_time 4 0 
0001: wait 0 ms 
0004: $FLAG_BLIP_ON_EIGHTBALL = 0 
0004: $RADAR_BLIP_PED1_EIGHTBALL = 0 
0004: $FLAG_PLAYER_GOT_CAR_MESSAGE1_EIGHTBALL = 0 
0004: $FLAG_PLAYER_IN_AREA = 0 
0004: $FLAG_EIGHTBALL_IN_AREA = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0

0004: $BRIBE_SECRET_TRIGGERED = 0
0086: $BRIBE_AREA_X1 = $IND_PICKUP_BRIBE6_X
000D: $BRIBE_AREA_X1 -= 1.0
0086: $BRIBE_AREA_X2 = $IND_PICKUP_BRIBE6_X
0009: $BRIBE_AREA_X2 += 1.0
0086: $BRIBE_AREA_Y1 = $IND_PICKUP_BRIBE6_Y
000D: $BRIBE_AREA_Y1 -= 1.0
0086: $BRIBE_AREA_Y2 = $IND_PICKUP_BRIBE6_Y
0009: $BRIBE_AREA_Y2 += 1.0

// luigi variables
0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM1 = 0 
0004: $FLAG_PLAYER_NOT_IN_CAR_MESSAGE_LM1 = 0 
0004: $NO_OF_PASSENGERS_CAR_LM1 = 0 
0004: $FLAG_GIRL1_IN_CAR_LM1 = 0 
0004: $PASSENGER_COUNT_LM1 = 0 
0004: $TOTAL_SPACE_IN_CAR_LM1 = 0 
0004: $FLAG_BLIP_ON_GIRL1_LM1 = 0 
0004: $FLAG_COORD_BLIP_ON = 0 
0004: $BLOB_FLAG = 1 

// luigi blip stuff
0004: $FLAG_LUIGI_COORD1_BLIP_CREATED = 0 
0004: $FLAG_LUIGI_PED1_BLIP_CREATED = 0 
0004: $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 = 0 
0004: $FLAG_PLAYER_IN_AREA_LM1 = 0 
0004: $FLAG_EIGHTBALL_IN_AREA_LM1 = 0 
0004: $FLAG_CAR_MESSAGE_8BALL = 0 
0004: $FLAG_MISTY_STOP = 0 
0004: $FLAG_GIRL_IN_GROUP_LM1 = 0 
if
	0038:   $FLAG_REACHED_HIDEOUT == 0 
then 
	03CB: load_scene 507.0 -937.0 36.5625 
	0247: request_model #BANSHEE 
	023C: load_special_actor 'EIGHT' as 1 
	038B: load_all_models_now 
	0005: $CAR_8BALL_X = 0.0 
	0005: $CAR_8BALL_Y = 0.0 
	0005: $CAR_8BALL_Z = 0.0 
	0005: $CAR_8BALL_HEADING = 0.0 
	0004: $CAR_COLOUR1_8BALL = 0 
	0004: $CAR_COLOUR2_8BALL = 0 
	if
		0038:   $BRIBE_SECRET_TRIGGERED == 1
	then
		0213: $IND_PICKUP_BRIBE6 = create_pickup #BRIBE type PICKUP_ONCE at $IND_PICKUP_BRIBE6_X $IND_PICKUP_BRIBE6_Y 16.5625 // Alleyway between Redlight and Chinatown -- SPECIAL USE IN 8BALL
		0004: $BRIBE_SECRET_TRIGGERED = 1 
	end
else
	goto @HIDEOUT_REACHED
end
if and
	0038:   $BROKEN_BRIDGE_OBJECTS_INITIALIZED == 0 
	8038:   not $DEBUGUNLOCKISLANDS == 1
then
	029B: $BROKEN_BRIDGE_REMAINS = init_object #BRIDGEFUKA at 715.6875 -937.875 40.1875 
	01C7: remove_object_from_mission_cleanup_list $BROKEN_BRIDGE_REMAINS 
	029B: $BROKEN_BRIDGE_POLICE_CARS = init_object #BRIDGEFUKB at 787.8125 -939.1875 38.9375 
	01C7: remove_object_from_mission_cleanup_list $BROKEN_BRIDGE_POLICE_CARS 
	0004: $BROKEN_BRIDGE_OBJECTS_INITIALIZED = 1 
end


// RAMP STUFF


0107: $RAMP_EIGHT1 = create_object #ELECTRICGATE at 582.5 -930.0 37.6
0453: object $RAMP_EIGHT1 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT1 collision_detection 1
0392: object $RAMP_EIGHT1 toggle_in_moving_list 0 



0107: $RAMP_EIGHT2 = create_object #ELECTRICGATE at 593.5 -930.0 37.6
0453: object $RAMP_EIGHT2 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT2 collision_detection 1
0392: object $RAMP_EIGHT2 toggle_in_moving_list 0 

0107: $RAMP_EIGHT3 = create_object #ELECTRICGATE at 604.5 -930.0 37.6
0453: object $RAMP_EIGHT3 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT3 collision_detection 1
0392: object $RAMP_EIGHT3 toggle_in_moving_list 0 

0107: $RAMP_EIGHT4 = create_object #ELECTRICGATE at 615.5 -930.0 37.6
0453: object $RAMP_EIGHT4 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT4 collision_detection 1
0392: object $RAMP_EIGHT4 toggle_in_moving_list 0 

0107: $RAMP_EIGHT5 = create_object #ELECTRICGATE at 626.5 -930.0 37.6
0453: object $RAMP_EIGHT5 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT5 collision_detection 1
0392: object $RAMP_EIGHT5 toggle_in_moving_list 0 

0107: $RAMP_EIGHT_SECRET1 = create_object #COLUMBIANGATE at 594.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET1 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET1 collision_detection 1
0392: object $RAMP_EIGHT_SECRET1 toggle_in_moving_list 0 
0363: toggle_model_render_at 594.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 

0107: $RAMP_EIGHT_SECRET2 = create_object #COLUMBIANGATE at 603.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET2 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET2 collision_detection 1
0392: object $RAMP_EIGHT_SECRET2 toggle_in_moving_list 0 
0363: toggle_model_render_at 603.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 

0107: $RAMP_EIGHT_SECRET3 = create_object #COLUMBIANGATE at 612.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET3 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET3 collision_detection 1
0392: object $RAMP_EIGHT_SECRET3 toggle_in_moving_list 0 
0363: toggle_model_render_at 612.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 

0107: $RAMP_EIGHT_SECRET4 = create_object #COLUMBIANGATE at 621.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET4 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET4 collision_detection 1
0392: object $RAMP_EIGHT_SECRET4 toggle_in_moving_list 0 
0363: toggle_model_render_at 621.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 

0107: $RAMP_EIGHT_SECRET5 = create_object #COLUMBIANGATE at 630.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET5 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET5 collision_detection 1
0392: object $RAMP_EIGHT_SECRET5 toggle_in_moving_list 0 
0363: toggle_model_render_at 630.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 

0107: $RAMP_EIGHT_SECRET6 = create_object #COLUMBIANGATE at 639.0 -945.0 33.0
0453: object $RAMP_EIGHT_SECRET6 set_rotation 90.0 0.0 0.0
0382: set_object $RAMP_EIGHT_SECRET6 collision_detection 1
0392: object $RAMP_EIGHT_SECRET6 toggle_in_moving_list 0 
0363: toggle_model_render_at 639.0 -945.0 35.0 radius 6.0 object #COLUMBIANGATE 0 



02CE: get_ground_z_for_3d_coord 540.0 -938.0 100.0 store_to $GROUND_EIGHT
00A5: $CAR_EIGHTBALL = create_car #BANSHEE at 540.0 -938.0 $GROUND_EIGHT
0229: set_car $CAR_EIGHTBALL color_to 58 1 
0175: set_car $CAR_EIGHTBALL z_angle_to 270.0
0224: set_car $CAR_EIGHTBALL health_to 750

0055: set_player_coordinates $PLAYER_CHAR to 540.0 -937.6 -100.0
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
009A: $EIGHTBALL = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 540.0 -937.6 -100.0
0245: set_actor $EIGHTBALL walk_style_to ANIM_GANG2_PED
01ED: clear_actor $EIGHTBALL threat_search 
022D: set_actor $EIGHTBALL to_look_at_player $PLAYER_CHAR 

016E: override_next_restart at 540.0 -937.6 $GROUND_EIGHT heading 180.0 //Restarts at the bridge
0177: set_object $PORTLAND_HIDEOUT_DOOR z_angle_to 0.0 
02A3: toggle_widescreen 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 791.625 -936.875 38.3125 //SMOKE ON CARS
02A2: create_particle POBJECT_DARK_SMOKE 0 at 788.3125 -938.4375 38.0625 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 786.4375 -942.375 39.75 
02A2: create_particle 10 0 at 783.5625 -938.5 38.4375 //FIRE ON CARS
02A2: create_particle 10 0 at 790.5 -935.625 38.0 
02A2: create_particle 10 0 at 789.25 -938.875 38.125 
018E: stop_sound $FIRE_SOUND_8BALL 
018D: $FIRE_SOUND_8BALL = create_sound SOUND_PRETEND_FIRE_LOOP at 790.5 -935.625 38.0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
015F: set_camera_position 520.0 -930.75 45.75 rotation 0.0 0.0 0.0 
0159: camera_on_ped $EIGHTBALL mode FIXED switchstyle JUMP_CUT
03CF: load_wav 'LIB_A1' 
0169: set_fade_color 0 0 0 
016A: fade 1 for 1000 ms 
while fading
    wait 0 ms
end 
0169: set_fade_color 0 0 0 
while 83D0:   not wav_loaded 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

015F: set_camera_position 540.5625 -923.0 45.0 0.0 rotation 0.0 0.0 
0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle JUMP_CUT
00BA: print_big 'EBAL' duration 15000 ms style 2  // 'GIVE ME LIBERTY'
03D1: play_wav 
00BC: print_now 'EBAL_A' duration 5000 ms flag 1  // I know a place on the edge of the Red Light District where we can lay low,

while 83D2:   not wav_ended 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

03CF: load_wav 'LIB_A2' 

while 83D0:   not wav_loaded 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

03D1: play_wav 
00BC: print_now 'EBAL_A1' duration 5000 ms flag 1  // but my hands are all messed up so you better drive, brother.

022F: set_actor $EIGHTBALL stop_looking 
01D4: actor $EIGHTBALL go_to_car $CAR_EIGHTBALL and_enter_it_as_a_passenger 
while 80DB:   not is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL 
	wait 0 ms
	if
		03D2:   wav_ended 
	then
		03D5: remove_text 'EBAL_A1'  // but my hands are all messed up so you better drive, brother.
	end
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

if
    0038:   $FLAG_DONE_RADIO_8BALL == 0  
then
    041E: set_radio_station BANG_RADIO 0
    0004: $FLAG_DONE_RADIO_8BALL = 1  
else
    041E: set_radio_station BANG_RADIO -1
end

039E: set_char_cant_be_dragged_out $EIGHTBALL to 1 
02A3: toggle_widescreen 0 
015A: restore_camera 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
0186: $RADAR_BLIP_CAR1_EIGHTBALL = create_marker_above_car $CAR_EIGHTBALL
gosub @SWITCH_CAR_GENERATOR  
wait 500 ms

gosub @CHECK_EIGHT_STATUS_EIGHTBALL
gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL

// Waiting for the player to get into the car
while true
	if or
		80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_EIGHTBALL 
		80DB:   not is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL 
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	gosub @CHECK_PLAYER_IN_RESTRICTED_AREA
end 

// creates two cops cars that drive onto the bridge
00A5: $COP_CAR1_8BALL = create_car #POLICE at 1083.188 -945.0 13.75
0129: $COP1_8BALL = create_actor PEDTYPE_CIVMALE #COP in_car $COP_CAR1_8BALL driverseat
01ED: clear_actor $COP1_8BALL threat_search 
0175: set_car $COP_CAR1_8BALL z_angle_to 90.0 
0397: car $COP_CAR1_8BALL siren = 1 
00AE: set_car_driving_style $COP_CAR1_8BALL to DRIVINGMODE_AVOIDCARS
00AD: set_car_cruise_speed $COP_CAR1_8BALL to 20.0 
00A7: car_goto_coordinates $COP_CAR1_8BALL coords 713.875 -916.6875 42.0 
00A5: $COP_CAR2_8BALL = create_car #POLICE at 1074.063 -946.6875 13.75
0129: $COP2_8BALL = create_actor PEDTYPE_CIVMALE #COP in_car $COP_CAR2_8BALL driverseat
01ED: clear_actor $COP2_8BALL threat_search 
0175: set_car $COP_CAR2_8BALL z_angle_to 90.0 
0397: car $COP_CAR2_8BALL siren = 1 
00AE: set_car_driving_style $COP_CAR2_8BALL to DRIVINGMODE_AVOIDCARS
00AD: set_car_cruise_speed $COP_CAR2_8BALL to 20.0 
00A7: car_goto_coordinates $COP_CAR2_8BALL coords 718.6875 -922.1875 42.0 
0164: disable_marker $RADAR_BLIP_CAR1_EIGHTBALL  

02CE: get_ground_z_for_3d_coord 875.0 -309.0 -100.0 store_to $GROUND_SAFEHOUSE_EIGHT
018A: $RADAR_BLIP_COORD1_EIGHTBALL = create_checkpoint_at 875.0 -309.0 $GROUND_SAFEHOUSE_EIGHT
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1 
0004: $BLOB_FLAG = 1 
03CF: load_wav 'LIB_A' 

// waiting for the player to get to the hideout
while true
	if or
		81A0:   not player $PLAYER_CHAR stopped $BLOB_FLAG 879.375 -303.375 7.25 870.0625 -311.6875 10.0 
		81AA:   not actor $EIGHTBALL stopped 0 879.375 -303.375 7.25 870.0625 -311.6875 10.0 
		8442:   not player $PLAYER_CHAR in_car $CAR_EIGHTBALL 
		8448:   not actor $EIGHTBALL in_car $CAR_EIGHTBALL 
		83D0:   not wav_loaded 
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	gosub @CHECK_IN_VEHICLE_STATUS_EIGHTBALL
	gosub @CHECK_PLAYER_IN_RESTRICTED_AREA
	gosub @CHECK_PLAYER_IN_PORTLAND_FOR_MARKER
	gosub @CHECK_BRIBE_SECRET
end

0164: disable_marker $RADAR_BLIP_COORD1_EIGHTBALL 

// ******************************Player and 8ball are at base scripted cutscene*************

02A3: toggle_widescreen 1 
//0110: clear_player $PLAYER_CHAR wanted_level 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0
if 
	8119:   not car $COP_CAR1_8BALL wrecked 
then
	00A6: delete_car $COP_CAR1_8BALL 
end

if 
	8119:   not car $COP_CAR2_8BALL wrecked 
then
	00A6: delete_car $COP_CAR2_8BALL 
end
0395: clear_area 1 at 886.75 -310.0625 range -100.0 2.0 
00AA: get_car_coordinates $CAR_EIGHTBALL store_to $CAR_8BALL_X $CAR_8BALL_Y $CAR_8BALL_Z 
0174: $CAR_8BALL_HEADING = car $CAR_EIGHTBALL z_angle 
03F3: get_car $CAR_EIGHTBALL color $CAR_COLOUR1_8BALL $CAR_COLOUR2_8BALL 

// Open hideout door
while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 210.0 to 10.0 collision_check 0 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

0395: clear_area 1 at 889.6875 -308.1875 range 8.5625 3.0 // This should remove any stuff that is in the way for the cut-scene
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
01ED: clear_actor $PLAYER_ACTOR threat_search 
01D3: actor $EIGHTBALL leave_car $CAR_EIGHTBALL

while 00DB:   is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

03D1: play_wav 
00BC: print_now 'EBAL_B' duration 7000 ms flag 1  // This is the place right here, let's get off the street and find a change of clothes!
0239: actor $EIGHTBALL run_to 892.6875 -308.5625 
wait 1000 ms
gosub @CHECK_EIGHT_STATUS_EIGHTBALL
gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL

01D3: actor $PLAYER_ACTOR leave_car $CAR_EIGHTBALL 
0395: clear_area 1 at 868.625 -311.6875 range 8.25 1.0 
015F: set_camera_position 868.625 -311.6875 8.25 0.0 rotation 0.0 0.0 //low new camera that points to the save house
0160: point_camera 869.5625 -311.5 8.5 switchstyle JUMP_CUT

while 00DB:   is_char_in_car $PLAYER_ACTOR car $CAR_EIGHTBALL
	wait 0 ms
	if
		03D2:   wav_ended 
	then
		03D5: remove_text 'EBAL_B'  // This is the place right here, let's get off the street and find a change of clothes!
	end
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

//Make player walk into the doors and get a change of clothes

0239: actor $PLAYER_ACTOR run_to 892.375 -308.5 
0006: 17@ = 0 

while true
	if or
		8038:   not  $FLAG_PLAYER_IN_AREA == 2 
		8038:   not  $FLAG_EIGHTBALL_IN_AREA == 2 
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	if and
		0038:   $FLAG_PLAYER_IN_AREA == 0 
		00ED:   actor $PLAYER_ACTOR 0 892.375 -308.5 radius 0.5 0.5 
	then
		0239: actor $PLAYER_ACTOR run_to 892.375 -305.5625 
		0004: $FLAG_PLAYER_IN_AREA = 1 
	end
	if and
		0038:   $FLAG_EIGHTBALL_IN_AREA == 0 
		00ED:   actor $EIGHTBALL 0 892.6875 -308.5625 radius 0.5 0.5
	then
		0239: actor $EIGHTBALL run_to 894.1875 -304.25 
		0004: $FLAG_EIGHTBALL_IN_AREA = 1
	end
	if and
		0038:   $FLAG_PLAYER_IN_AREA == 1
		00ED:   actor $PLAYER_ACTOR 0 892.375 -305.5625 radius 0.5 0.5 
	then
		0004: $FLAG_PLAYER_IN_AREA = 2
	end
	if and
		0038:   $FLAG_EIGHTBALL_IN_AREA == 1
		00ED:   actor $EIGHTBALL 0 894.1875 -304.25 radius 0.5 0.5  
	then
		0004: $FLAG_EIGHTBALL_IN_AREA = 2 
	end
	if 
		0029:   17@ >= 10000 
	then
		if or
			8038:   not  $FLAG_PLAYER_IN_AREA == 2 
			8038:   not  $FLAG_EIGHTBALL_IN_AREA == 2 
		then
			0055: set_player_coordinates $PLAYER_CHAR to 892.375 -305.5625 7.6875 
			009F: char_set_idle $PLAYER_ACTOR 
			00A1: set_char_coordinates $EIGHTBALL to 894.1875 -304.25 7.6875 
			009F: char_set_idle $EIGHTBALL
			goto @MISSION_BLOKE_STUCK_8BALL
		end
	end
end //while

:MISSION_BLOKE_STUCK_8BALL
015F: set_camera_position 886.75 -310.0625 9.875 0.0 rotation 0.0 0.0 
0160: point_camera 887.6875 -309.75 9.75 switchstyle JUMP_CUT
wait 500 ms
009F: char_set_idle $EIGHTBALL 
011C: actor $PLAYER_ACTOR clear_objective 
00A1: set_char_coordinates $EIGHTBALL to 884.25 -309.1875 7.5625 

// Close hideout door
while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 0.0 to 10.0 collision_check 0 
	wait 0 ms
end //while

// Clothes change

//8-Ball change
if 
	8118:   not actor $EIGHTBALL dead 
then
	0352: set_actor $EIGHTBALL skin_to 'EIGHT2' 
	while 8248:   not model #SPECIAL01 available 
		wait 0 ms
	end //while
	if 
		8118:   not actor $EIGHTBALL dead 
	then
		0353: refresh_actor $EIGHTBALL 
	end
end

//Player change
if 
	8118:   not actor $PLAYER_ACTOR dead 
then
	0352: set_actor $PLAYER_ACTOR skin_to 'PLAYER' 
	while 8248:   not model #NULL available 
		wait 0 ms
	end //while
	if 
		8118:   not actor $PLAYER_ACTOR dead 
	then
		0353: refresh_actor $PLAYER_ACTOR 
	end
end

0006: 16@ = 0  

// Shake the camera a bunch of times.
while 8019:   not 16@ > 2500
	0209: $SHAKE_INTENSITY = random_int_in_range 30 to 121
	0209: $SHAKE_INTERVAL = random_int_in_range 300 to 701
	0003: shake_cam $SHAKE_INTENSITY	
	wait $SHAKE_INTERVAL ms
end
wait 250 ms

// Open hideout door
while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 210.0 to 10.0 collision_check 0 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

0055: set_player_coordinates $PLAYER_CHAR to 883.5 -308.1875 7.5625 
01B7: release_weather 
01D4: actor $EIGHTBALL go_to_car $CAR_EIGHTBALL and_enter_it_as_a_passenger 
wait 750 ms
gosub @CHECK_EIGHT_STATUS_EIGHTBALL
gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL

01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_EIGHTBALL 
0395: clear_area 1 at 868.625 -311.6875 range 8.25 1.0  
015F: set_camera_position 868.625 -311.6875 8.25 0.0 rotation 0.0 0.0 //low new camera that points to the save house
0160: point_camera 869.5625 -311.5 8.5 switchstyle JUMP_CUT

while true
	if or
		80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_EIGHTBALL 
		80DB:   not is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end //while

// Close hideout door
while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 0.0 to 10.0 collision_check 0 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end //while

02EB: restore_camera_jumpcut 
03C8: set_camera_directly_before_player 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0  
0004: $BLOB_FLAG = 1 

// *************Restart function for 8ball and the player at players hideout***************

:HIDEOUT_REACHED
if 
	0038:   $FLAG_REACHED_HIDEOUT == 1
then 
	02A3: toggle_widescreen 1 
	01B4: set_player $PLAYER_CHAR controllable 0 
	01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
	0171: set_player $PLAYER_CHAR z_angle_to 90.0 
	0395: clear_area 1 at 868.625 -311.6875 range 8.25 1.0 
	015F: set_camera_position 868.625 -311.6875 8.25 0.0 rotation 0.0 0.0 //low new camera that points to the save house
	0160: point_camera 869.5625 -311.5 8.5 switchstyle JUMP_CUT
	0177: set_object $PORTLAND_HIDEOUT_DOOR z_angle_to 0.0 
	023C: load_special_actor 'EIGHT2' as 1 
	0247: request_model #MRWHOOP 
	038B: load_all_models_now 
	009A: $EIGHTBALL = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 884.25 -309.1875 7.562
	0245: set_actor $EIGHTBALL walk_style_to ANIM_GANG2_PED
	0173: set_actor $EIGHTBALL z_angle_to 90.0 
	01ED: clear_actor $EIGHTBALL threat_search 
	00A5: $CAR_EIGHTBALL = create_car #MRWHOOP at $CAR_8BALL_X $CAR_8BALL_Y $CAR_8BALL_Z
	0175: set_car $CAR_EIGHTBALL z_angle_to $CAR_8BALL_HEADING 
	0229: set_car $CAR_EIGHTBALL color_to 0 0
	0224: set_car $CAR_EIGHTBALL health_to 500
	01B7: release_weather 
	01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_EIGHTBALL 
	01D4: actor $EIGHTBALL go_to_car $CAR_EIGHTBALL and_enter_it_as_a_passenger 
	while true
		if or
			80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_EIGHTBALL 
			80DB:   not is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL
		jf break
		wait 0 ms
		gosub @CHECK_EIGHT_STATUS_EIGHTBALL
		gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	end
	039E: set_char_cant_be_dragged_out $EIGHTBALL to 1 
	02EB: restore_camera_jumpcut 
	03C8: set_camera_directly_before_player 
	02A3: toggle_widescreen 0 
	01B4: set_player $PLAYER_CHAR controllable 1 
	01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0
end
// **************************************end of the restart stuff***************************

if 
	$FLAG_REACHED_HIDEOUT == 0
then
	03AE: remove_objects_from_cube 804.0 -948.0 30.0 to 765.125 -924.3125 50.0 
	018E: stop_sound $FIRE_SOUND_8BALL 
	0108: destroy_object $BROKEN_BRIDGE_REMAINS 
	0108: destroy_object $BROKEN_BRIDGE_POLICE_CARS
	0108: destroy_object $RAMP_EIGHT1 
	0108: destroy_object $RAMP_EIGHT2
	0108: destroy_object $RAMP_EIGHT3
	0108: destroy_object $RAMP_EIGHT4
	0108: destroy_object $RAMP_EIGHT5
	0108: destroy_object $RAMP_EIGHT_SECRET1
	0108: destroy_object $RAMP_EIGHT_SECRET2
	0108: destroy_object $RAMP_EIGHT_SECRET3
	0108: destroy_object $RAMP_EIGHT_SECRET4
	0108: destroy_object $RAMP_EIGHT_SECRET5
	0108: destroy_object $RAMP_EIGHT_SECRET6
	if
		0038:   $DEBUGUNLOCKISLANDS == 0
	then 
		03B6: replace_model_at 1027.25 -933.75 15.0 radius 50.0 from #LOD_LAND014 to #INDHELIX_BARRIER 
		0363: toggle_model_render_at 1027.25 -933.75 15.0 radius 50.0 object #INDHELIX_BARRIER 1 
	end
	0004: $FLAG_REACHED_HIDEOUT = 1 
end

016E: override_next_restart at 883.5 -308.1875 7.5625 heading 90.0 // Players hideout
gosub @CHECK_EIGHT_STATUS_EIGHTBALL

018A: $RADAR_BLIP_COORD2_EIGHTBALL = create_checkpoint_at 906.1875 -426.0 -100.0 //Luigis blip
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2
03CF: load_wav 'LIB_B'

while 83D0:   not wav_loaded 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	gosub @CHECK_IN_VEHICLE_STATUS_EIGHTBALL
end

03D1: play_wav 
00BC: print_now 'EBAL_D' duration 5000 ms flag 1  // I know a guy, he's connected, his name's Luigi.
wait 2000 ms 
gosub @CHECK_EIGHT_STATUS_EIGHTBALL
gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
gosub @CHECK_IN_VEHICLE_STATUS_EIGHTBALL

00BC: print_now 'EBAL_D1' duration 7000 ms flag 1  // Me an' him go back so I could probably get you some work. C'mon lets head over there.

//waiting for the player to got to Luigi's

while 83D2:   not wav_ended 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	gosub @CHECK_IN_VEHICLE_STATUS_EIGHTBALL
end

03D5: remove_text 'EBAL_D'  // I know a guy, he's connected, his name's Luigi.
03D5: remove_text 'EBAL_D1'  // Me an' him go back so I could probably get you some work. C'mon lets head over there.

// waiting for the player to get to luigi's

03CF: load_wav 'LIB_C' 

while true
	if or
		81A0:   not player $PLAYER_CHAR stopped $BLOB_FLAG 903.75 -420.1875 14.0 908.25 -431.0625 18.0 
		81AA:   not actor $EIGHTBALL stopped 0 903.75 -420.1875 14.0 908.25 -431.0625 18.0 
		80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_EIGHTBALL 
		80DB:   not is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL 
		83D0:   not wav_loaded 
	jf break
	wait 0 
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
	gosub @CHECK_IN_VEHICLE_STATUS_EIGHTBALL
end

0164: disable_marker $RADAR_BLIP_COORD2_EIGHTBALL 
02A3: toggle_widescreen 1 
0110: clear_player $PLAYER_CHAR wanted_level 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0395: clear_area 1 at 887.375 -417.25 range 13.875 10.0 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
01ED: clear_actor $PLAYER_ACTOR threat_search 
01D3: actor $PLAYER_ACTOR leave_car $CAR_EIGHTBALL 
01D3: actor $EIGHTBALL leave_car $CAR_EIGHTBALL 
03D1: play_wav 
00BC: print_now 'EBAL_G' duration 7000 ms flag 1  // This is Luigi's club. Let's go round the back and use the service door.

while true
	if or
		00DB:   is_char_in_car $PLAYER_ACTOR car $CAR_EIGHTBALL 
		00DB:   is_char_in_car $EIGHTBALL car $CAR_EIGHTBALL 
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE1_STATUS_EIGHTBALL
end

01C3: remove_references_to_car $CAR_EIGHTBALL 
0211: actor $PLAYER_ACTOR walk_to 897.0625 -426.25 
0211: actor $EIGHTBALL walk_to 897.25 -424.5625

while 83D2:   not wav_ended 
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
end

03D5: remove_text 'EBAL_G'  // This is Luigi's club. Let's go round the back and use the service door.
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
039E: set_char_cant_be_dragged_out $EIGHTBALL to 0 


// ****************************Player and eightball cut-scene at luigi's********************

0006: 16@ = 0  

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		8019:   not 16@ > 5000  //	if player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
	gosub @CHECK_EIGHT_STATUS_EIGHTBALL
end

03EF: player $PLAYER_CHAR make_safe 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
03AF: set_streaming 0 
00BA: print_big 'LM1' duration 15000 ms style 2  // 'LUIGI'S GIRLS'
0247: request_model #INDHIBUILD3 
0247: request_model #LUIGICLUBOUT 
0247: request_model #LUIGIINEERCLUB 
023C: load_special_actor 'MICKY' as 2 
023C: load_special_actor 'LUIGI' as 3 
02F3: load_object #CUTOBJ01 'LUDOOR' 
02F3: load_object #CUTOBJ02 'MICKYH' 
02F3: load_object #CUTOBJ03 'EIGHTH' 
02F3: load_object #CUTOBJ04 'LUIGIH' 
02F3: load_object #CUTOBJ05 'PLAYERH' 
while fading 
	wait 0 ms
end
038B: load_all_models_now 
03DE: set_ped_density_multiplier 0.0 
042B: clear_peds_from_cube 926.5 -471.6875 1.0 830.75 -257.9375 25.0 
if
	8118:   not actor $EIGHTBALL dead 
then
	0192: set_actor $EIGHTBALL objective_to_stand_still
end

0192: set_actor $PLAYER_ACTOR objective_to_stand_still 

// Cutscene stuff

while true
	if or
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 3 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
	jf break
	wait 0 ms
end

while true
	if or
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
		8248:   not model #CUTOBJ05 available 
		8248:   not model #INDHIBUILD3 available 
		8248:   not model #LUIGICLUBOUT available 
		8248:   not model #LUIGIINEERCLUB available 
	jf break
	wait 0 ms
end

009B: delete_char $EIGHTBALL 
0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 0 
02E4: load_cutscene_data 'L1_LG' 
0244: set_cutscene_pos 900.75 -427.5 13.8125 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_MICKY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MICKY 'MICKY' 
02E5: $CUTSCENE_EIGHT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_EIGHT 'EIGHT2' 
02E5: $CUTSCENE_LUIGI = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CUTSCENE_LUIGI 'LUIGI' 
02F4: create_cutscene_actor $MICKY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_MICKY 
02F5: set_head_anim $MICKY_CSHEAD 'MICKY' 
02F4: create_cutscene_actor $EIGHT_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_EIGHT 
02F5: set_head_anim $EIGHT_CSHEAD 'EIGHT' 
02F4: create_cutscene_actor $LUIGI_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_LUIGI 
02F5: set_head_anim $LUIGI_CSHEAD 'LUIGI' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ05 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_LUDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_LUDOOR 'LUDOOR' 
0395: clear_area 1 at 896.5625 -426.1875 range 13.875 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 896.5625 -426.1875 13.875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0  
016A: fade 1 for 1500 ms 
0395: clear_area 1 at 887.375 -417.25 range 13.875 10.0 // This should get rid of anything in the alleway
0395: clear_area 1 at 892.75 -425.5 range 13.875 3.0 
0395: clear_area 1 at 896.25 -425.5625 range 13.75 3.0 
0395: clear_area 1 at 899.6875 -425.6875 range 14.0 0.5 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 
0336: set_player $PLAYER_CHAR visible 0

// Displays cutscene text

while 11165 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_H' duration 10000 ms flag 1  // Wait here man while I go in and talk to Luigi.
while 13416 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'EBAL_H'  // Wait here man while I go in and talk to Luigi.
//00BC: text_highpriority 'EBAL_H' duration 10000 ms flag 1 //"Da boss will be out to see you shortly..."
while 30834 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_J' duration 10000 ms flag 1  // 8-Ball's got some business up stairs.
while 33186 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_K' duration 10000 ms flag 1  // Maybe you can do me a favor.
while 35235 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_L' duration 10000 ms flag 1  // One of my girls needs a ride so grab a car and pick up Misty from the clinic. Then bring her back here.
while 41551 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_M' duration 10000 ms flag 1   // Remember no one messes with my girls!
while 001A:   45634 > $CUT_SCENE_TIME  
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_N' duration 10000 ms flag 1   // So keep your hands on the wheel!
while 001A:   47560 > $CUT_SCENE_TIME  
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: text_highpriority 'EBAL_O' duration 10000 ms flag 1   // If you don't mess this up maybe there be more work for you. Now get outta here!
while 001A:   51911 > $CUT_SCENE_TIME  
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'EBAL_O'   // If you don't mess this up maybe there be more work for you. Now get outta here!
while 001A:   52500 > $CUT_SCENE_TIME  
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
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
03AF: set_streaming 1 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 1 
03CB: load_scene 920.25 -425.375 15.0 
0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 1 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 
0249: release_model #INDHIBUILD3 
0249: release_model #LUIGICLUBOUT 
0249: release_model #LUIGIINEERCLUB 
01B4: set_player $PLAYER_CHAR controllable 1 
03DE: set_ped_density_multiplier 1.0 

// *****************************************END OF CUTSCENE*********************************

// *****************************************LUIGI'S GIRLS***********************************

023C: load_special_actor 'MISTY' as 2 
00BC: print_now 'EBAL_5' duration 5000 ms flag 1  // ~g~Get a vehicle!


while 823D:   not special_actor 2 loaded 
	wait 0 ms
end

// Creates the first girl
009A: $GIRL1_LM1 = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 1141.563 -590.75 14.875
01ED: clear_actor $GIRL1_LM1 threat_search 
0173: set_actor $GIRL1_LM1 z_angle_to 90.0 
0245: set_actor $GIRL1_LM1 walk_style_to ANIM_SEXY_WOMANPED
0187: $RADAR_BLIP_PED1_LM1 = create_marker_above_actor $GIRL1_LM1 
0004: $FLAG_BLIP_ON_GIRL1_LM1 = 1 
03CF: load_wav 'LIB_D' 

// Waiting for the player to be in a car
while true
	if or
		80E0:   not is_player_in_any_car $PLAYER_CHAR 
		83D0:   not wav_loaded 
	jf break
	wait 0 ms
	gosub @CHECK_MISTY_STATUS_EIGHTBALL
	if 
		00E0:   is_player_in_any_car $PLAYER_CHAR  
	then 
		00DA: $CAR_LM1 = store_car_player_is_in $PLAYER_CHAR
	end
end

00BC: print_now 'EBAL_6' duration 5000 ms flag 1  // ~g~Pick up Misty!


// Waiting for the player and the girls all to be in the one car

while 0038:   $FLAG_GIRL1_IN_CAR_LM1 == 0 
	wait 0 ms
	if
		0038:   $FLAG_GIRL_IN_GROUP_LM1 == 0
	then
		gosub @CHECK_MISTY_STATUS_EIGHTBALL
		if
			80E0:   not is_player_in_any_car $PLAYER_CHAR
		then
			if
				0038:   $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 == 0
			then
				00BC: print_now 'IN_VEH2' duration 5000 ms flag 1  // ~g~You need some wheels for this job
				if
					0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 1
				then
					0164: disable_marker $RADAR_BLIP_PED1_LM1 
					0004: $FLAG_BLIP_ON_GIRL1_LM1 = 0
				end
				0004: $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 = 1
			end
		else
			00DA: $CAR_LM1 = store_car_player_is_in $PLAYER_CHAR
			if
				0038:   $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 == 1
			then
				00BC: print_now 'EBAL_6' duration 5000 ms flag 1  // ~g~Pick up Misty!
				if
					0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 0
				then
					0187: $RADAR_BLIP_PED1_LM1 = create_marker_above_actor $GIRL1_LM1 
					0004: $FLAG_BLIP_ON_GIRL1_LM1 = 1
				end
				0004: $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 = 0
			end
		end
		if and
			00EB:   player $PLAYER_CHAR 0 $GIRL1_LM1 radius 40.0 40.0
			80EB:   not player $PLAYER_CHAR 0 $GIRL1_LM1 radius 10.0 10.0
		then
			0319: set_actor $GIRL1_LM1 running 1
			0054: get_player_coordinates $PLAYER_CHAR store_to $EIGHT_PLAYER_X $EIGHT_PLAYER_Y $EIGHT_PLAYER_Z 
			0239: actor $GIRL1_LM1 run_to $EIGHT_PLAYER_X $EIGHT_PLAYER_Y
		end
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR
		then
			00DA: $CAR_LM1 = store_car_player_is_in $PLAYER_CHAR
			if
				00EB:   player $PLAYER_CHAR 0 $GIRL1_LM1 radius 8.0 8.0
			then
				01D4: actor $GIRL1_LM1 go_to_car $CAR_LM1 and_enter_it_as_a_passenger
				while true
					if or
						80DB:   not is_char_in_car $GIRL1_LM1 car $CAR_LM1 
						80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_LM1
					jf break
					wait 0 ms
					gosub @CHECK_MISTY_STATUS_EIGHTBALL
					gosub @CHECK_VEHICLE2_STATUS_EIGHTBALL
					if
						00DB:   is_char_in_car $GIRL1_LM1 car $CAR_LM1
					then
						039E: set_char_cant_be_dragged_out $GIRL1_LM1 to 1
					end
					if
						80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_LM1
					then
						if
							0038:   $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 == 0 
						then
							00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
							if
								0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 1
							then
								0164: disable_marker $RADAR_BLIP_PED1_LM1 
								0186: $RADAR_BLIP_CAR1_LM1 = create_marker_above_car $CAR_LM1 
								0004: $FLAG_BLIP_ON_GIRL1_LM1 = 0 
							end
							0004: $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 = 1 
						end
					else
						if
							0038:   $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 == 1 
						then
							00BC: print_now 'EBAL_6' duration 5000 ms flag 1  // ~g~Pick up Misty!
							if
								0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 0
							then
								0187: $RADAR_BLIP_PED1_LM1 = create_marker_above_actor $GIRL1_LM1 
								0164: disable_marker $RADAR_BLIP_CAR1_LM1 
								0004: $FLAG_BLIP_ON_GIRL1_LM1 = 1
							end
							0004: $FLAG_PLAYER_HAD_VEHICLE_MESSAGE_LM1 = 0 
						end
					end
				end //while
				0164: disable_marker $RADAR_BLIP_PED1_LM1 
				0164: disable_marker $RADAR_BLIP_CAR1_LM1 
				0004: $FLAG_BLIP_ON_GIRL1_LM1 = 0 
				0004: $FLAG_GIRL_IN_GROUP_LM1 = 1 
			end
		end
	end
	if
		0038:   $FLAG_GIRL_IN_GROUP_LM1 == 1 
	then
		gosub @CHECK_MISTY_STATUS_EIGHTBALL
		gosub @CHECK_VEHICLE2_STATUS_EIGHTBALL
		if
			80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_LM1 
		then
			if
				0038:   $FLAG_PLAYER_HAD_CAR_MESSAGE_LM1 == 0
			then
				00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
				0186: $RADAR_BLIP_CAR1_LM1 = create_marker_above_car $CAR_LM1 
				0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM1 = 1 
			end
		else
			if
				00DB:   is_char_in_car $GIRL1_LM1 car $CAR_LM1
			then
				00BC: print_now 'LM1_9' duration 10000 ms flag 1  // Hi I'm Misty.
				03D1: play_wav 
				039E: set_char_cant_be_dragged_out $GIRL1_LM1 to 0 
				0004: $FLAG_GIRL1_IN_CAR_LM1 = 1
			end
			if
				0038:   $FLAG_PLAYER_HAD_CAR_MESSAGE_LM1 == 1
			then
				0164: disable_marker $RADAR_BLIP_CAR1_LM1 
				0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM1 = 0
			end
		end
	end
end //while

0164: disable_marker $RADAR_BLIP_PED1_LM1 
01DF: tie_actor $GIRL1_LM1 to_player $PLAYER_CHAR

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_MISTY_STATUS_EIGHTBALL
	gosub @CHECK_MISTY_RANGE_STATUS_EIGHTBALL
	gosub @CHECK_VEHICLE2_STATUS_EIGHTBALL
end //while
03D5: remove_text 'LM1_9'  // Hi I'm Misty.
00BC: print_now 'LM1_2' duration 7000 ms flag 1  // ~g~Take Misty to Luigi's Club.
018A: $RADAR_BLIP_COORD1_LM1 = create_checkpoint_at 906.1875 -426.0 -100.0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 3
0004: $BLOB_FLAG = 1 

// waiting for the player to get to luigi's

while true
	if or
		81A8:   not actor $GIRL1_LM1 stopped $BLOB_FLAG 903.75 -420.1875 14.0 908.25 -431.0625 18.0 
		819E:   not player $PLAYER_CHAR stopped 0 903.75 -420.1875 14.0 908.25 -431.0625 18.0 
	jf break
	wait 0 ms
	gosub @CHECK_MISTY_STATUS_EIGHTBALL
	gosub @CHECK_MISTY_RANGE_STATUS_EIGHTBALL
end



0164: disable_marker $RADAR_BLIP_COORD1_LM1 
01E0: clear_leader $GIRL1_LM1 
// *********************************MISTY CUT AT END****************************************
02A3: toggle_widescreen 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0110: clear_player $PLAYER_CHAR wanted_level 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0395: clear_area 1 at 887.375 -417.25 range 13.875 10.0 // This should get rid of any stuff for the cut-scene
0247: request_model #INDHIBUILD3 
0247: request_model #LUIGICLUBOUT 
0247: request_model #LUIGIINEERCLUB 


if 
	00DF:   is_char_in_any_car $GIRL1_LM1   
then
	039E: set_char_cant_be_dragged_out $GIRL1_LM1 to 0 
	00D9: $CAR_LM1 = store_car_char_is_in $GIRL1_LM1
	01D3: actor $GIRL1_LM1 leave_car $CAR_LM1 
	while 00DF:   is_char_in_any_car $GIRL1_LM1 
		wait 0 ms
		gosub @CHECK_MISTY_STATUS_EIGHTBALL
	end
end

while true
	if or
		8248:   not model #INDHIBUILD3 available 
		8248:   not model #LUIGICLUBOUT available 
		8248:   not model #LUIGIINEERCLUB available 
	jf break
	wait 0 ms
	gosub @CHECK_MISTY_STATUS_EIGHTBALL
end

// Misty walks to the top of the alleyway
0211: actor $GIRL1_LM1 walk_to 900.125 -425.375 
0006: 17@ = 0
while 001B:   1000 > 17@ 
	wait 0 ms
	gosub @CHECK_MISTY_STATUS_EIGHTBALL
end

00A1: set_char_coordinates $GIRL1_LM1 to 898.875 -425.75 13.875 
0173: set_actor $GIRL1_LM1 z_angle_to 90.0 
0211: actor $GIRL1_LM1 walk_to 887.0625 -425.1875 
02A3: toggle_widescreen 1 
015F: set_camera_position 882.5625 -425.5625 14.375 0.0 rotation 0.0 0.0 
0160: point_camera 890.1875 -421.0625 15.0 switchstyle JUMP_CUT
01E3: text_1number_styled 'M_PASS' number 1500 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 1500 
0394: play_mission_passed_music 1 

wait 3500 ms

0169: set_fade_color 0 0 0 
016A: fade 0 for 1000 ms
while fading
	wait 0 ms
end
0373: set_camera_directly_behind_player 
02A3: toggle_widescreen 0 
02EB: restore_camera_jumpcut 
wait 750 ms 
016A: fade 1 for 250 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0

goto @MISSION_PASSED_EIGHTBALL

////////////////////////////////////////////

:CHECK_PLAYER_IN_PORTLAND_FOR_MARKER
if and
	0256:   is_player $PLAYER_CHAR defined 
	8038:   not $SAFEHOUSE_MARKER_RECREATED_EIGHT == 1
then
	if
		03C6:   current_island == LEVEL_INDUSTRIAL
	then
		0164: disable_marker $RADAR_BLIP_COORD1_EIGHTBALL 
		wait 0 ms
		018A: $RADAR_BLIP_COORD1_EIGHTBALL = create_checkpoint_at 875.0 -309.0 $GROUND_SAFEHOUSE_EIGHT
		0004: $SAFEHOUSE_MARKER_RECREATED_EIGHT = 1
	end
end
return


////////////////////////////////////////////

:CHECK_EIGHT_STATUS_EIGHTBALL
if
	0118:   actor $EIGHTBALL dead 
then
	00BC: print_now 'EBAL_4' duration 5000 ms flag 1  // ~r~8-Ball's dead!
	goto @MISSION_FAILED_EIGHTBALL
end
return

////////////////////////////////////////////

:CHECK_VEHICLE1_STATUS_EIGHTBALL
if
	0119:   car $CAR_EIGHTBALL wrecked
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1   // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_EIGHTBALL
end
if and
	01F4:   car $CAR_EIGHTBALL flipped
	01C1:   car $CAR_EIGHTBALL stopped
then
	00BC: print_now 'UPSIDE' duration 5000 ms flag 1   // ~r~You flipped your wheels!
	goto @MISSION_FAILED_EIGHTBALL
end
return

////////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_EIGHTBALL
if
	80DC:   not is_player_in_car $PLAYER_CHAR car $CAR_EIGHTBALL 
then
	0004: $BLOB_FLAG = 0
	if
		0038:   $FLAG_CAR_MESSAGE_8BALL == 0
	then
		00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
		if
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
		then
			0164: disable_marker $RADAR_BLIP_COORD1_EIGHTBALL 
		else
			0164: disable_marker $RADAR_BLIP_COORD2_EIGHTBALL 
		end
		0186: $RADAR_BLIP_CAR1_EIGHTBALL = create_marker_above_car $CAR_EIGHTBALL 
		0004: $FLAG_CAR_MESSAGE_8BALL = 1
	end
else
	0004: $BLOB_FLAG = 1
	if
		0038:   $FLAG_CAR_MESSAGE_8BALL == 1
	then
		0164: disable_marker $RADAR_BLIP_CAR1_EIGHTBALL 
		if
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
		then
			018A: $RADAR_BLIP_COORD1_EIGHTBALL = create_checkpoint_at 875.0 -309.0 $GROUND_SAFEHOUSE_EIGHT
		else
			018A: $RADAR_BLIP_COORD2_EIGHTBALL = create_checkpoint_at 906.1875 -426.0 -100.0  
		end
		0004: $FLAG_CAR_MESSAGE_8BALL = 0 
	end
end
return

////////////////////////////////////////////

:CHECK_MISTY_STATUS_EIGHTBALL
if
	0118:   actor $GIRL1_LM1 dead 
then
	00BC: text_highpriority 'MISTY1' duration 5000 ms flag 1   // ~r~Misty is morgue-meat!
	goto @MISSION_FAILED_EIGHTBALL 
end
return

////////////////////////////////////////////

:CHECK_MISTY_RANGE_STATUS_EIGHTBALL
if and
	8320:   not actor $GIRL1_LM1 in_range_of_player $PLAYER_CHAR 
	0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 0 
then
	00BC: print_now 'HEY4' duration 5000 ms flag 1  // ~g~Lose Misty and Luigi will lose your face! Go and get her!
	0187: $RADAR_BLIP_PED1_LM1 = create_marker_above_actor $GIRL1_LM1 
	0004: $FLAG_BLIP_ON_GIRL1_LM1 = 1
	if
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 3
	then
		0164: disable_marker $RADAR_BLIP_COORD1_LM1 
		0004: $BLOB_FLAG = 0 
	end
end
if and
	00E9:   player $PLAYER_CHAR 0 $GIRL1_LM1 radius 8.0 8.0 
	0038:   $FLAG_BLIP_ON_GIRL1_LM1 == 1
then
	01DF: tie_actor $GIRL1_LM1 to_player $PLAYER_CHAR 
	0164: disable_marker $RADAR_BLIP_PED1_LM1 
	0004: $FLAG_BLIP_ON_GIRL1_LM1 = 0
	if
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 3
	then
		00BC: print_now 'LM1_2' duration 7000 ms flag 1  // ~g~Take Misty to Luigi's Club.
		018A: $RADAR_BLIP_COORD1_LM1 = create_checkpoint_at 906.1875 -426.0 -100.0 
		0004: $BLOB_FLAG = 1 
	end
end
return

////////////////////////////////////////////

:CHECK_VEHICLE2_STATUS_EIGHTBALL
if
	0119:   car $CAR_LM1 wrecked 
then
	if
		0118:   actor $GIRL1_LM1 dead
	then
		00BC: print_now 'MISTY1' duration 5000 ms flag 1  // ~r~Misty is morgue-meat!
		goto @MISSION_FAILED_EIGHTBALL
	else
		00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
		goto @MISSION_FAILED_EIGHTBALL
	end
end
return

////////////////////////////////////////////

:CHECK_PLAYER_IN_RESTRICTED_AREA
0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYERX $PLAYERY $PLAYERZ
if
	0022:   500.0 > $PLAYERX
then
	00BC: print_now 'AREA51' duration 4000 ms flag 1  // ~g~You're not supposed to be here, go back now!
	if
		0038: $RESTICTED_TIMER_RESET_FLAG == 0
	then
		0006: 17@ = 0
		0004: $RESTICTED_TIMER_RESET_FLAG = 1
	else
		if
			0029:   17@ >= 10000 
		then
			gosub @KILL_PLAYER_RESTRICTED	
		end
	end
else
	0004: $RESTICTED_TIMER_RESET_FLAG = 0
end
return

////////////////////////////////////////////

:KILL_PLAYER_RESTRICTED
if
	00E0:   is_player_in_any_car $PLAYER_CHAR
then
	00DA: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
	020B: explode_car $PLAYER_CAR
else
	0322: kill_player $PLAYER_CHAR
end
return

////////////////////////////////////////////

:CHECK_BRIBE_SECRET
if and
	0038:   $BRIBE_SECRET_TRIGGERED == 0
	0056:   is_player_in_area_2d $PLAYER_CHAR coords $BRIBE_AREA_X1 $BRIBE_AREA_Y1 to $BRIBE_AREA_X2 $BRIBE_AREA_Y2 sphere 0
then
	018C: play_sound SOUND_EVIDENCE_PICKUP at 0.0 0.0 0.0 
	0215: destroy_pickup $IND_PICKUP_BRIBE6 
	00BC: print_now 'EBAL_X1' duration 3500 ms flag 1  // ~g~Bribing the law 0/10
	010E: set_player $PLAYER_CHAR minimum_wanted_level_to 5
	0004: $BRIBE_SECRET_TRIGGERED = 1
end
return

////////////////////////////////////////////

// Mission 8ball failed 

:MISSION_FAILED_EIGHTBALL
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
0004: $FLAG_EIGHTBALL_MISSION_LAUNCHED = 0 
if 
	0038:   $FLAG_REACHED_HIDEOUT == 0 
then
	0255: set_critical_mission_restart_at 540.0 -937.6 $GROUND_EIGHT angle 180.0 // New bridge restart
else
	0255: set_critical_mission_restart_at 883.5 -308.1875 7.5625 angle 90.0 // Player hideout
end
00D8: mission_has_finished

while 8256:   not is_player $PLAYER_CHAR defined 
	wait 0 ms
end
goto @MISSION_END_EIGHTBALL

////////////////////////////////////////////

// mission eightball passed

:MISSION_PASSED_EIGHTBALL
01F6: cancel_override_restart 
0004: $LUIGIS_GIRLS_COMPLETED = 1 
0318: set_latest_mission_passed 'LM1'  // 'LUIGI'S GIRLS'
030C: set_mission_points += 1 
0004: $FLAG_LUIGI_MISSION1_PASSED = 1 
0110: clear_player $PLAYER_CHAR wanted_level 
02A7: $LUIGI_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_LUIGI at 892.75 -425.75 13.875 // New blip down alleyway
004F: create_thread @LUIGI_MISSION2_LOOP
goto @MISSION_END_EIGHTBALL

////////////////////////////////////////////

// mission cleanup

:MISSION_CLEANUP_EIGHTBALL
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_8BALL = 0 
03AE: remove_objects_from_cube 804.0 -948.0 30.0 to 765.125 -924.3125 50.0 
018E: stop_sound $FIRE_SOUND_8BALL 
0169: set_fade_color 0 0 0 
0249: release_model #INDHIBUILD3 
0249: release_model #LUIGICLUBOUT 
0249: release_model #LUIGIINEERCLUB 
0249: release_model #MRWHOOP 
0249: release_model #BANSHEE 
0164: disable_marker $RADAR_BLIP_COORD1_EIGHTBALL 
0164: disable_marker $RADAR_BLIP_COORD2_EIGHTBALL 
0164: disable_marker $RADAR_BLIP_CAR1_EIGHTBALL 
009B: delete_char $EIGHTBALL 
009B: delete_char $GIRL1_LM1 
0164: disable_marker $RADAR_BLIP_COORD1_LM1 
0164: disable_marker $RADAR_BLIP_PED1_LM1 
0164: disable_marker $RADAR_BLIP_CAR1_LM1 
if 
	8119:   not car $COP_CAR1_8BALL wrecked
then
	01C3: remove_references_to_car $COP_CAR1_8BALL 
end
if 
	8119:   not car $COP_CAR2_8BALL wrecked
then
	01C3: remove_references_to_car $COP_CAR2_8BALL 
end
if 
	8118:   not actor $GIRL1_LM1 dead 
then
	039E: set_char_cant_be_dragged_out $GIRL1_LM1 to 0 
end
mission_cleanup 
return 

////////////////////////////////////////////
