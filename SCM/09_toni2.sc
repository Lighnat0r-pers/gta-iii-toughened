// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 2****************************************
// **************************************Triad Ambush*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

:M09_THEPICKUP

gosub @MISSION_START_TONI2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_TONI2
end

:MISSION_END_TONI2
gosub @MISSION_CLEANUP_TONI2
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_TONI2
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_TONI = 1 
03A4: name_thread 'TONI2' 
0001: wait 0 ms 
0004: $TRIAD1_DEAD = 0 
0004: $TRIAD2_DEAD = 0 
0004: $TRIAD3_DEAD = 0 
0004: $TRIAD4_DEAD = 0 
0004: $TRIAD5_DEAD = 0 
0004: $TRIAD6_DEAD = 0 
0004: $TRIADS_KILLED = 0 
0004: $TRIADS_KILLED_MESSAGE = 0 
0004: $TRIAD_THREAT_CLEARED_T2 = 0 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'NOTE' 
0247: request_model #IND_NEWRIZZOS 
038B: load_all_models_now 

while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #IND_NEWRIZZOS available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'T2_TPU' 
0244: set_cutscene_pos 1218.375 -314.5 28.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_NOTE 'NOTE' 
0395: clear_area 1 at 1219.5 -321.0625 range 27.5 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1219.5 -321.0625 26.375 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
0395: clear_area 1 at 1216.063 -313.0 range 29.875 10.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   151 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_A' duration 10000 ms flag 1  // ~w~TONI's off making people bleed or trying to.
while 001A:   3879 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_AA' duration 10000 ms flag 1  // ~w~He'll never be as tough as his Pop, but he left you a note on the table.
while 001A:   7522 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_B' duration 10000 ms flag 1  // ~w~The laundry has agreed to pay - you did real good kid!
while 001A:   10947 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_C' duration 10000 ms flag 1  // ~w~Go collect the cash and bring it back here. Watch out for the Triads.
while 001A:   14507 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_D' duration 10000 ms flag 1  // ~w~They may be shoving a firecracker up your ass, but don't take no crap.
while 001A:   18705 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM2_E' duration 10000 ms flag 1  // ~w~Nobody I mean nobody, messes with TONI CIPRIANI!
while 001A:   22114 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   23333 > $CUT_SCENE_TIME
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

03AD: set_rubbish 1 
02EA: end_cutscene 
03C8: set_camera_directly_before_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #IND_NEWRIZZOS 

// START OF MISSION

if
	042A:   ped_threat_exists PEDTYPE_GANG_TRIAD THREAT_PLAYER1
then
	03F2: pedgroup PEDTYPE_GANG_TRIAD remove_threat THREAT_PLAYER1
	0004: $TRIAD_THREAT_CLEARED_T2 = 1 
end
014C: set_parked_car_generator $GEN_CAR31 cars_to_generate_to 0 
0213: $TONI2_BRIEFCASE = create_pickup #BRIEFCASE type PICKUP_ONCE at 865.6875 -663.5625 14.75 
03DC: $TONI2_BRIEFCASE_MARKER = create_marker_above_pickup $TONI2_BRIEFCASE 
0247: request_model #BELLYUP 
0247: request_model #GANG03 
0247: request_model #GANG04

while true
	if or
		8248:   not model #BELLYUP available 
		8248:   not model #GANG03 available 
		8248:   not model #GANG04 available
	jf break
	wait 0 ms
end //while

00A5: $TONI2_TRIAD_VAN_FAKE = create_car #BELLYUP at 867.0 -663.5625 14.75
0175: set_car $TONI2_TRIAD_VAN_FAKE z_angle_to 180.0 
00A9: car_set_idle $TONI2_TRIAD_VAN_FAKE 

while 8214:   not pickup $TONI2_BRIEFCASE picked_up 
	wait 0 ms
	if
		01FC:   player $PLAYER_CHAR near_car $TONI2_TRIAD_VAN_FAKE radius 2.0 4.0 unknown 0
	then
		020B: explode_car $TONI2_TRIAD_VAN_FAKE
	end
end
	 
// START OF MISSION

0164: disable_marker $TONI2_BRIEFCASE_MARKER 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
0395: clear_area 1 at 869.375 -639.0 range 15.0 1.0 

009A: $TONI2_TRIAD1  = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 869.375 -639.0 -100.0
01B2: give_actor $TONI2_TRIAD1 weapon WEAPONTYPE_BASEBALLBAT ammo 1 
0211: actor $TONI2_TRIAD1 walk_to 869.375 -656.0 
0395: clear_area 1 at 868.5 -637.0 range 15.0 1.0 

009A: $TONI2_TRIAD2 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 868.5 -637.0 -100.0
0173: set_actor $TONI2_TRIAD2 z_angle_to 180.0 
01B2: give_actor $TONI2_TRIAD2 weapon WEAPONTYPE_PISTOL ammo 200 
015F: set_camera_position 869.6875 -666.0 16.0 0.0 rotation 0.0 0.0 
0159: camera_on_ped $TONI2_TRIAD1 mode FIXED switchstyle INTERPOLATION 
0001: wait 2500 ms 
0395: clear_area 1 at 869.375 -688.0 range 15.0 1.0 

009A: $TONI2_TRIAD3 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 869.375 -688.0 -100.0
01B2: give_actor $TONI2_TRIAD3 weapon WEAPONTYPE_BASEBALLBAT ammo 1 
0211: actor $TONI2_TRIAD3 walk_to 869.375 -678.0 
0395: clear_area 1 at 868.5 -690.0 range 15.0 1.0
 
009A: $TONI2_TRIAD4 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 868.5 -690.0 -100.0
01B2: give_actor $TONI2_TRIAD4 weapon WEAPONTYPE_PISTOL ammo 100 
0159: camera_on_ped $TONI2_TRIAD3 mode FIXED switchstyle INTERPOLATION 
0001: wait 2500 ms 
0395: clear_area 1 at 892.5625 -666.0 range 15.0 4.0 

00A5: $TONI2_TRIAD_VAN = create_car #BELLYUP at 892.5 -666.0 -100.0
0175: set_car $TONI2_TRIAD_VAN z_angle_to 180.0 
0129: $TONI2_TRIAD5 = create_actor PEDTYPE_GANG_TRIAD #GANG03 in_car $TONI2_TRIAD_VAN driverseat
01C8: $TONI2_TRIAD6 = create_actor PEDTYPE_GANG_TRIAD model #GANG03 in_car $TONI2_TRIAD_VAN passenger_seat 0
01B2: give_actor $TONI2_TRIAD5 weapon WEAPONTYPE_PISTOL ammo 27 
01B2: give_actor $TONI2_TRIAD6 weapon WEAPONTYPE_BASEBALLBAT ammo 1 
00A9: car_set_idle $TONI2_TRIAD_VAN 
0158: camera_on_vehicle $TONI2_TRIAD_VAN mode FIXED switchstyle INTERPOLATION 
01D3: actor $TONI2_TRIAD6 leave_car $TONI2_TRIAD_VAN

while 00DB:   is_char_in_car $TONI2_TRIAD6 car $TONI2_TRIAD_VAN 
	wait 0 ms
	if or
		0118:   actor $TONI2_TRIAD6 dead 
		0119:   car $TONI2_TRIAD_VAN wrecked
	then
		goto @NEXT_BIT_TONI2
	end
end //while

if 
	8118:   not actor $TONI2_TRIAD6 dead
then
	0211: actor $TONI2_TRIAD6 walk_to 886.1875 -665.75 
end

wait 2500 ms

:NEXT_BIT_TONI2
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
02A3: toggle_widescreen 0 
015A: restore_camera 
0001: wait 0 ms 

if
	8118:   not actor $TONI2_TRIAD1 dead
then
	01CC: actor $TONI2_TRIAD1 kill_player $PLAYER_CHAR 
	011A: set_actor $TONI2_TRIAD1 search_threat THREAT_PLAYER1 
end
if
	8118:   not actor $TONI2_TRIAD2 dead
then
	011A: set_actor $TONI2_TRIAD2 search_threat THREAT_PLAYER1 
end
if
	8118:   not actor $TONI2_TRIAD3 dead
then
	01CC: actor $TONI2_TRIAD3 kill_player $PLAYER_CHAR 
	011A: set_actor $TONI2_TRIAD3 search_threat THREAT_PLAYER1 
end
if
	8118:   not actor $TONI2_TRIAD4 dead
then
	011A: set_actor $TONI2_TRIAD4 search_threat THREAT_PLAYER1 
end
if
	8118:   not actor $TONI2_TRIAD6 dead
then
	01CC: actor $TONI2_TRIAD6 kill_player $PLAYER_CHAR 
	011A: set_actor $TONI2_TRIAD6 search_threat THREAT_PLAYER1 
end

00BC: print_now 'TM2_3' duration 5000 ms flag 1  // ~g~It's a trap! Waste them all!!

if
	8118:   not actor $TONI2_TRIAD1 dead
then
	0187: $TONI2_TRIAD1_MARKER = create_marker_above_actor $TONI2_TRIAD1
end
if
	8118:   not actor $TONI2_TRIAD2 dead
then
	0187: $TONI2_TRIAD2_MARKER = create_marker_above_actor $TONI2_TRIAD2
end
if
	8118:   not actor $TONI2_TRIAD3 dead
then
	0187: $TONI2_TRIAD3_MARKER = create_marker_above_actor $TONI2_TRIAD3
end
if
	8118:   not actor $TONI2_TRIAD4 dead
then
	0187: $TONI2_TRIAD4_MARKER = create_marker_above_actor $TONI2_TRIAD4
end
if
	8118:   not actor $TONI2_TRIAD5 dead
then
	0187: $TONI2_TRIAD5_MARKER = create_marker_above_actor $TONI2_TRIAD5
end
if
	8118:   not actor $TONI2_TRIAD6 dead
then
	0187: $TONI2_TRIAD6_MARKER = create_marker_above_actor $TONI2_TRIAD6
end

while 8038:   not  $TRIADS_KILLED == 6 
	wait 0 ms
	if and
		0118:   actor $TONI2_TRIAD1 dead 
		0038:   $TRIAD1_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD1_MARKER 
		0004: $TRIAD1_DEAD = 1
	end
	if and
		0118:   actor $TONI2_TRIAD2 dead 
		0038:   $TRIAD2_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD2_MARKER 
		0004: $TRIAD2_DEAD = 1
	end
	if and
		0118:   actor $TONI2_TRIAD3 dead 
		0038:   $TRIAD3_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD3_MARKER 
		0004: $TRIAD3_DEAD = 1
	end
	if and
		0118:   actor $TONI2_TRIAD4 dead 
		0038:   $TRIAD4_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD4_MARKER 
		0004: $TRIAD4_DEAD = 1
	end
	if and
		0118:   actor $TONI2_TRIAD5 dead 
		0038:   $TRIAD5_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD5_MARKER 
		0004: $TRIAD5_DEAD = 1
	end
	if and
		0118:   actor $TONI2_TRIAD6 dead 
		0038:   $TRIAD6_DEAD == 0
	then
		0008: $TRIADS_KILLED += 1 
		0164: disable_marker $TONI2_TRIAD6_MARKER 
		0004: $TRIAD6_DEAD = 1
	end
	if
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords 890.0 -639.25 846.5625 -688.0 sphere 0
	then
		if
			8118:   not actor $TONI2_TRIAD2 dead
		then
			01CC: actor $TONI2_TRIAD2 kill_player $PLAYER_CHAR
		end
		if
			8118:   not actor $TONI2_TRIAD4 dead
		then
			01CC: actor $TONI2_TRIAD4 kill_player $PLAYER_CHAR
		end
		if
			8118:   not actor $TONI2_TRIAD5 dead
		then
			01CC: actor $TONI2_TRIAD5 kill_player $PLAYER_CHAR
		end
	end
end //while

00BC: print_now 'TM2_1' duration 5000 ms flag 1  // ~g~Get the cash back to Toni's!!
018A: $TONI2_TONI_MARKER = create_checkpoint_at 1223.0 -327.0 -100.0

while 80F6:   not player $PLAYER_CHAR 1 1219.563 -320.6875 27.375 radius 1.0 1.0 2.0 
	wait 0 ms
end

01B4: set_player $PLAYER_CHAR controllable 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
02A3: toggle_widescreen 1 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
0319: set_actor $PLAYER_ACTOR running 1 
015F: set_camera_position 1214.375 -323.875 29.75 0.0 rotation 0.0 0.0 
0160: point_camera 1215.188 -323.375 29.375 switchstyle JUMP_CUT
0395: clear_area 1 at 1219.563 -314.0 range 29.6875 2.0 
0239: actor $PLAYER_ACTOR run_to 1219.563 -314.0 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 10000 
0006: 17@ = 0

while 8126:   not actor $PLAYER_ACTOR walking
	wait 0 ms
	if and
		0019:   17@ > 7000 
		8118:   not actor $PLAYER_ACTOR dead
	then
		00A1: set_char_coordinates $PLAYER_ACTOR to 1219.563 -314.0 -100.0 
	end
end //while

0395: clear_area 1 at 1219.563 -323.75 range 26.75 2.0 
0239: actor $PLAYER_ACTOR run_to 1219.563 -323.75 
0006: 17@ = 0

while 8126:   not actor $PLAYER_ACTOR walking
	wait 0 ms
	if and
		0019:   17@ > 7000 
		8118:   not actor $PLAYER_ACTOR dead
	then
		00A1: set_char_coordinates $PLAYER_ACTOR to 1219.563 -323.75 -100.0 
	end
end //while

01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
02A3: toggle_widescreen 0 
02EB: restore_camera_jumpcut 
0319: set_actor $PLAYER_ACTOR running 0 

goto @MISSION_PASSED_TONI2

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_TONI2
goto @MISSION_END_TONI2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_TONI2
0004: $THE_PICKUP_COMPLETED = 1 
03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1
0318: set_latest_mission_passed 'TM2'  // 'THE PICK-UP'
030C: set_mission_points += 1 
004F: create_thread @TONI_MISSION3_LOOP
goto @MISSION_END_TONI2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_TONI2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_TONI = 0 
014C: set_parked_car_generator $GEN_CAR31 cars_to_generate_to 101 
0164: disable_marker $TONI2_BRIEFCASE_MARKER 
0164: disable_marker $TONI2_TONI_MARKER 
0164: disable_marker $TONI2_TRIAD1_MARKER 
0164: disable_marker $TONI2_TRIAD2_MARKER 
0164: disable_marker $TONI2_TRIAD3_MARKER 
0164: disable_marker $TONI2_TRIAD4_MARKER 
0164: disable_marker $TONI2_TRIAD5_MARKER 
0164: disable_marker $TONI2_TRIAD6_MARKER 
0215: destroy_pickup $TONI2_BRIEFCASE 
0249: release_model #BELLYUP 
0249: release_model #GANG03 
0249: release_model #GANG04
if
	 0038:   $TRIAD_THREAT_CLEARED_T2 == 1
then
	03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1
end
00D8: mission_has_finished
return
