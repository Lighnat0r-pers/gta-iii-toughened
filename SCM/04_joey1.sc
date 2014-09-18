// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 1****************************************
// ************************************Kill Mike Lips*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

:M04_MIKELIPSLASTLUNCH

gosub @MISSION_START_JOEY1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_JOEY1
end

:MISSION_END_JOEY1
gosub @MISSION_CLEANUP_JOEY1
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_JOEY1
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_JOEY = 1 
0004: $MISSION_PASSED_FOR_LIPS_FINISHED = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0
03A4: name_thread 'JOEY1' 
0001: wait 0 ms 

0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM1 = 0 
023C: load_special_actor 'JOEY' as 1 
023C: load_special_actor 'MISTY' as 2 
02F3: load_object #CUTOBJ01 'JOEDOOR' 
02F3: load_object #CUTOBJ02 'JOEYH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'MISTYH' 
0247: request_model #IDAHO 
0247: request_model #JOGARAGEEXT 
0247: request_model #JOGARAGEINT 
038B: load_all_models_now 

while true
	if or
		8248:   not model #JOGARAGEEXT available 
		8248:   not model #JOGARAGEINT available 
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #IDAHO available
	jf break
	wait 0 ms
end //while
while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'J1_LFL' 
0244: set_cutscene_pos 1190.063 -869.8125 13.9375 
00A5: $CUT_CAR2_LM3 = create_car #IDAHO at 1182.5 -857.0 14.0625
0175: set_car $CUT_CAR2_LM3 z_angle_to 291.1875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_JOEY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_JOEY 'JOEY' 
02E5: $CUTSCENE_MISTY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MISTY 'MISTY' 
02F4: create_cutscene_actor $JOEY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_JOEY 
02F5: set_head_anim $JOEY_CSHEAD 'JOEY' 
02F4: create_cutscene_actor $MISTY_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_MISTY 
02F5: set_head_anim $MISTY_CSHEAD 'MISTY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_JOEDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_JOEDOOR 'JOEDOOR' 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR1 0 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR2 0 
0395: clear_area 1 at 1191.875 -870.375 range 15.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1191.875 -870.375 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 230.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_A' duration 10000 ms flag 2  // Hey, I'm bored when you gonna drill me?
while 001A:   2739 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_B' duration 10000 ms flag 2  // In a moment sweet heart, I got a little business to take care of.
while 001A:   6344 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_C' duration 10000 ms flag 2  // I got a little job for you pal.
while 001A:   8362 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_D' duration 10000 ms flag 2  // The Forelli brothers have owed me money for too long
while 001A:   10700 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_E' duration 10000 ms flag 2  // and they need to be taught some respect.
while 001A:   12688 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_F' duration 10000 ms flag 2  // Lips Forelli is stuffing his fat face in St Marks Bistro,
while 001A:   15858 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_G' duration 10000 ms flag 2  // so steal his car and take it to 8-Ball's bomb shop up in Harwood.
while 001A:   19969 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_H' duration 10000 ms flag 2  // You know 8-Ball right?
while 001A:   21519 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_I' duration 3000 ms flag 2  // Once he's fitted it with a bomb, go park the car where you found it.
while 001A:   24979 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_J' duration 10000 ms flag 2  // Then sit back and watch the whole show.
while 001A:   27466 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM1_K' duration 10000 ms flag 2  // But hurry up, he won't be eating forever.
while 001A:   29204 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   30000 > $CUT_SCENE_TIME
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
01B6: set_weather WEATHER_RAINY
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR1 1 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR2 1 
03C8: set_camera_directly_before_player 
02A8: $BLIP2_JM1 = create_marker RADAR_SPRITE_BOMB at 1282.0 -104.0 -100.0 
02A8: $BLIP4_JM1 = create_marker RADAR_SPRITE_SPRAY at 925.0 -359.5 -100.0 
018A: $BLIP3_JM1 = create_checkpoint_at 1335.0 -455.0 -100.0 
0164: disable_marker $BLIP2_JM1 
0164: disable_marker $BLIP3_JM1 
0164: disable_marker $BLIP4_JM1 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #IDAHO 
0249: release_model #JOGARAGEEXT 
0249: release_model #JOGARAGEINT 
00A6: delete_car $CUT_CAR2_LM3 

// START OF MISSION

023C: load_special_actor 'LIPS' as 3 
0247: request_model #IDAHO
0247: request_model #BARREL4 

while true
	if or
		8248:   not model #IDAHO available 
		8248:   not model #BARREL4 available 
		823D:   not special_actor 3 loaded 
	jf break
	wait 0 ms
end //while

02CE: get_ground_z_for_3d_coord 1300.0 -130.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL1 = create_object #BARREL4 at 1300.0 -130.0 $LIPSGROUND
02CE: get_ground_z_for_3d_coord 1289.0 -115.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL2 = create_object #BARREL4 at 1289.0 -115.0 $LIPSGROUND
02CE: get_ground_z_for_3d_coord 1279.0 -75.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL3 = create_object #BARREL4 at 1279.0 -75.0 $LIPSGROUND
02CE: get_ground_z_for_3d_coord 1290.0 -103.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL4 = create_object #BARREL4 at 1290.0 -103.0 $LIPSGROUND
02CE: get_ground_z_for_3d_coord 1311.0 -100.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL5 = create_object #BARREL4 at 1311.0 -100.0 $LIPSGROUND
02CE: get_ground_z_for_3d_coord 1293.0 -95.0 100.0 store_to $LIPSGROUND
0107: $LIPSBARREL6 = create_object #BARREL4 at 1293.0 -95.0 $LIPSGROUND

00A5: $LIPSFORELLI_CAR = create_car #IDAHO at 1336.188 -460.75 -100.0
020A: set_car $LIPSFORELLI_CAR door_status_to CARLOCK_FORCE_SHUT_DOORS
0175: set_car $LIPSFORELLI_CAR z_angle_to 90.0 
0294: set_car $LIPSFORELLI_CAR resprayable_to 0 
0186: $BLIP1_JM1 = create_marker_above_car $LIPSFORELLI_CAR 
0004: $COUNTDOWN_JM1 = 151000 
014E: start_timer_at $COUNTDOWN_JM1 

gosub @CHECK_VEHICLE_STATUS_JOEY1

while 80DC:   not is_player_in_car $PLAYER_CHAR car $LIPSFORELLI_CAR
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_TIMER_STATUS_JOEY1
end //while

00BC: print_now 'JM1_1' duration 5000 ms flag 1  // ~g~Take Forelli's car to 8-Ball's garage North of here, behind 'Easy Credit Autos'.
021D: set_free_bomb_shop_to 1 

:GO_TO_8BALLS

0004: $FLAG_CAR_BLIP_DISPLAYED_JM1 = 1

while true
	if and
		8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITION
		8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITIONACTIVE
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_TIMER_STATUS_JOEY1
	0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1
	gosub @CHECK_IN_VEHICLE_STATUS_JOEY1
	0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2
	gosub @CHECK_VEHICLE_NEEDS_REPAIR_JOEY1
end //while

0001: wait 4000 ms 
00BC: print_now 'JM1_2' duration 5000 ms flag 2  // ~g~Park the car back at Marco's Bistro.
0164: disable_marker $BLIP1_JM1 
0164: disable_marker $BLIP2_JM1 
0164: disable_marker $BLIP4_JM1 
021D: set_free_bomb_shop_to 0 

:JOEY_LABEL1 

// Drop the car back at the bistro

wait 0 ms
0004: $FLAG_CAR_BLIP_DISPLAYED_JM1 = 1 
gosub @CHECK_VEHICLE_STATUS_JOEY1
0004: $BLOB_FLAG = 1
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 3

while true
	if or
		81AC:   not car $LIPSFORELLI_CAR stopped $BLOB_FLAG 1339.563 -459.5 49.0 1332.75 -462.75 53.0 
		010F:   player $PLAYER_CHAR wanted_level > 0 
		03C9:   car $LIPSFORELLI_CAR damaged
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_TIMER_STATUS_JOEY1
	gosub @CHECK_IN_VEHICLE_STATUS_JOEY1
	gosub @CHECK_VEHICLE_NEEDS_REPAIR_JOEY1
	if
		019D:   player $PLAYER_CHAR 0 1339.563 -459.5 49.0 1332.75 -462.75 53.0
	then
		if and 
			010F:   player $PLAYER_CHAR wanted_level > 0 
			0038:   $FLAG_DISPLAYED_WANTED_MESSAGE_JM1 == 0
		then
			00BC: print_now 'WANTED1' duration 4000 ms flag 1  // ~g~Shake the cops and lose your wanted level!
			0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM1 = 1 
		end
	else
		0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM1 = 0 
	end
end //while

0164: disable_marker $BLIP1_JM1 
0164: disable_marker $BLIP2_JM1 
0164: disable_marker $BLIP3_JM1 
0164: disable_marker $BLIP4_JM1 
gosub @CHECK_TIMER_STATUS_JOEY1
if
	8119:   not car $LIPSFORELLI_CAR wrecked
then
	0174: $MIKES_CAR_HEADING = car $LIPSFORELLI_CAR z_angle
	if or
		0020:   $MIKES_CAR_HEADING > 92.0 
		0022:   88.0 > $MIKES_CAR_HEADING
	then
		00BC: print_now 'JM1_6' duration 5000 ms flag 1  // ~g~Put the car back in the correct position.
		goto @JOEY_LABEL1
	end
	if
		00DC:   is_player_in_car $PLAYER_CHAR car $LIPSFORELLI_CAR
	then
		00BC: print_now 'JM1_3' duration 5000 ms flag 2  // ~g~Activate the car bomb then get out of there!
	end
end

:CARS_RIGGED
wait 0 ms
gosub @CHECK_VEHICLE_STATUS_JOEY1

while true
	if or
		81AC:   not car $LIPSFORELLI_CAR stopped 1 1339.563 -459.5 49.0 1332.75 -462.75 53.0 
		00E3:   player $PLAYER_CHAR 0 1337.0 -462.0 radius 30.0 30.0 
	jf break
	wait 0 ms
	gosub @CHECK_FAKE_BOMB_CUTSCENE_JOEY1
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_TIMER_STATUS_JOEY1
	if
		80B1:   not is_car_in_area_3d $LIPSFORELLI_CAR from 1339.563 -459.5 49.0 to 1332.75 -462.75 53.0 sphere 0
	then
		00BC: print_now 'JM1_6' duration 5000 ms flag 1  // ~g~Put the car back in the correct position.
		goto @JOEY_LABEL1
	end
	0174: $MIKES_CAR_HEADING = car $LIPSFORELLI_CAR z_angle
	if or
		0020:   $MIKES_CAR_HEADING > 92.0 
		0022:   88.0 > $MIKES_CAR_HEADING
	then
		00BC: print_now 'JM1_6' duration 5000 ms flag 1  // ~g~Put the car back in the correct position.
		goto @JOEY_LABEL1
	end
	if or
		8185:   not car $LIPSFORELLI_CAR health >= 700 
		03C9:   car $LIPSFORELLI_CAR damaged
	then
		goto @JOEY_LABEL1
	end
end //while

gosub @CHECK_TIMER_STATUS_JOEY1
if
	8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITIONACTIVE
then
	00BC: print_now 'JM1_5' duration 5000 ms flag 1  // ~g~The car bomb's not set!
	goto @CARS_RIGGED
end

//LIPS CUT_SCENE

0395: clear_area 1 at 1325.5 -452.5 range 54.0 4.0 
0395: clear_area 1 at 1328.375 -453.0 range 54.0 4.0 
0395: clear_area 1 at 1330.0 -466.0625 range 49.0 4.0 
0395: clear_area 1 at 1333.563 -465.25 range 49.0 4.0 
014F: stop_timer $COUNTDOWN_JM1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
009A: $JOEY1_MIKELIPS = create_char PEDTYPE_SPECIAL model #SPECIAL03 at 1325.5 -452.5 -100.0
0173: set_actor $JOEY1_MIKELIPS z_angle_to 270.0 
015F: set_camera_position 1337.813 -468.625 49.75 0.0 rotation 0.0 0.0 
0160: point_camera 1337.0 -468.0 49.9375 switchstyle JUMP_CUT
0211: actor $JOEY1_MIKELIPS walk_to 1328.375 -453.0 

gosub @CHECK_MIKE_STATUS_JOEY1

0006: 17@ = 0

if
	8118:   not actor $JOEY1_MIKELIPS dead
then
	while 8126:   not actor $JOEY1_MIKELIPS walking
		wait 0 ms
		gosub @CHECK_VEHICLE_STATUS_JOEY1
		gosub @CHECK_MIKE_STATUS_JOEY1
		if and
			0019:   17@ > 10000 
			8118:   not actor $JOEY1_MIKELIPS dead
		then
			00A1: set_char_coordinates $JOEY1_MIKELIPS to 1328.375 -453.0 -100.0
		end
	end //while
end

0006: 17@ = 0

if
	8118:   not actor $JOEY1_MIKELIPS dead
then
	0211: actor $JOEY1_MIKELIPS walk_to 1330.0 -466.0625 
end

while 8126:   not actor $JOEY1_MIKELIPS walking
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_MIKE_STATUS_JOEY1
	if and
		0019:   17@ > 10000 
		8118:   not actor $JOEY1_MIKELIPS dead
	then
		00A1: set_char_coordinates $JOEY1_MIKELIPS to 1330.0 -466.0625 -100.0 
	end
end //while

if
	8118:   not actor $JOEY1_MIKELIPS dead
then
	0211: actor $JOEY1_MIKELIPS walk_to 1333.563 -465.25 
end

015F: set_camera_position 1344.75 -471.1875 54.0 0.0 rotation 0.0 0.0

if
	8119:   not car $LIPSFORELLI_CAR wrecked 
then
	0158: camera_on_vehicle $LIPSFORELLI_CAR mode FIXED switchstyle JUMP_CUT
end

if
	8118:   not actor $JOEY1_MIKELIPS dead
then
	while 8126:   not actor $JOEY1_MIKELIPS walking
		wait 0 ms
		gosub @CHECK_VEHICLE_STATUS_JOEY1
		gosub @CHECK_MIKE_STATUS_JOEY1
		if and
			0019:   17@ > 10000 
			8118:   not actor $JOEY1_MIKELIPS dead
		then
			00A1: set_char_coordinates $JOEY1_MIKELIPS to  1333.563 -465.25 -100.0 
		end
	end //while
end

if and
	8118:   not actor $JOEY1_MIKELIPS dead 
	8119:   not car $LIPSFORELLI_CAR wrecked 
then
	01D5: actor $JOEY1_MIKELIPS go_to_and_drive_car $LIPSFORELLI_CAR
end

while 80DB:   not is_char_in_car $JOEY1_MIKELIPS car $LIPSFORELLI_CAR
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY1
	gosub @CHECK_MIKE_STATUS_JOEY1
end //while

03F4: set_all_cars_can_be_damaged 1 
0001: wait 2500 ms 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 10000 
0004: $MISSION_PASSED_FOR_LIPS_FINISHED = 1 
0001: wait 5000 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 

goto @MISSION_PASSED_JOEY1

/////////////////////////////////////////

:CHECK_FAKE_BOMB_CUTSCENE_JOEY1
if
	80E3:   not player $PLAYER_CHAR 0 1337.0 -462.0 radius 15.0 15.0
then
	if
		8038: 	not $JOEY1_FAKEBOMB_CUTSCENE_PLAYED == 1
	then
		014F: stop_timer $COUNTDOWN_JM1 
		01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
		01B4: set_player $PLAYER_CHAR controllable 0 
		02A3: toggle_widescreen 1 
		015F: set_camera_position 1337.813 -468.625 49.75 rotation 0.0 0.0 0.0 
		0160: point_camera 1337.0 -468.0 49.9375 switchstyle JUMP_CUT
		wait 3000 ms
		00BC: print_now 'NOBOMB1' duration 3000 ms flag 1  // Hmm.. Nothing seems to be happening. 
		wait 3000 ms
		if
			8119:   not car $LIPSFORELLI_CAR wrecked 
		then
			015F: set_camera_position 1344.75 -471.1875 54.0 0.0 rotation 0.0 0.0
			0158: camera_on_vehicle $LIPSFORELLI_CAR mode FIXED switchstyle JUMP_CUT
		end
		00BC: print_now 'NOBOMB2' duration 3500 ms flag 1  // Maybe you should try activating the bomb again.
		wait 3500 ms
		01B4: set_player $PLAYER_CHAR controllable 1 
		02A3: toggle_widescreen 0 
		01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
		02EB: restore_camera_jumpcut
		014E: start_timer_at $COUNTDOWN_JM1
		0004: $JOEY1_FAKEBOMB_CUTSCENE_PLAYED = 1
	end
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_JOEY1
if
	0119:   car $LIPSFORELLI_CAR wrecked 
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_JOEY1
end
if and
	01F4:   car $LIPSFORELLI_CAR flipped 
	01C1:   car $LIPSFORELLI_CAR stopped
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_JOEY1
end
return

/////////////////////////////////////////

:CHECK_TIMER_STATUS_JOEY1
if
	0038:   $COUNTDOWN_JM1 == 0
then
	00BC: print_now 'OUTTIME' duration 5000 ms flag 1  // ~r~Too slow, man, too slow!
	goto @MISSION_FAILED_JOEY1
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_JOEY1
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $LIPSFORELLI_CAR 
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM1 == 1
then
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		if or
			8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITIONACTIVE
			8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITION
		then
			0164: disable_marker $BLIP2_JM1 
			02A8: $BLIP2_JM1 = create_marker RADAR_SPRITE_BOMB at 1282.0 -104.0 -100.0 
		end
	else
		if or
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 21
		then
			0164: disable_marker $BLIP4_JM1 
			02A8: $BLIP4_JM1 = create_marker RADAR_SPRITE_SPRAY at 925.0 -359.5 -100.0 
		else
			0164: disable_marker $BLIP3_JM1 
			018A: $BLIP3_JM1 = create_checkpoint_at 1335.0 -455.0 -100.0 
			0004: $BLOB_FLAG = 1 
		end
	end
	0164: disable_marker $BLIP1_JM1
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM1 = 0
end

if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $LIPSFORELLI_CAR 
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM1 == 0
then
	0186: $BLIP1_JM1 = create_marker_above_car $LIPSFORELLI_CAR 
	if
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		0164: disable_marker $BLIP2_JM1 
	else
		if or
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 21
		then
			0164: disable_marker $BLIP4_JM1 
		else
			0164: disable_marker $BLIP3_JM1 
			0004: $BLOB_FLAG = 0
		end
	end
	00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM1 = 1
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_NEEDS_REPAIR_JOEY1
if or
	8185:   not car $LIPSFORELLI_CAR health >= 700 
	03C9:   car $LIPSFORELLI_CAR damaged
then
	00BD: print_soon 'JM1_4' duration 5000 ms flag 2  // ~g~You're trashing the vehicle! Get it repaired!
	if
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 3
	then
		0164: disable_marker $BLIP3_JM1
		0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 21
	end
	0164: disable_marker $BLIP1_JM1 
	0186: $BLIP1_JM1 = create_marker_above_car $LIPSFORELLI_CAR 
	018B: show_on_radar $BLIP1_JM1 BLIP_ONLY
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM1 = 1
	while 03C9:   car $LIPSFORELLI_CAR damaged 
		wait 0 ms
		gosub @CHECK_VEHICLE_STATUS_JOEY1
		if
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
		then
			if or
				8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITIONACTIVE
				8228:   not car $LIPSFORELLI_CAR bomb_status == CARBOMB_ONIGNITION
			then
				0164: disable_marker $BLIP2_JM1 
			end
		end
		gosub @CHECK_TIMER_STATUS_JOEY1
		gosub @CHECK_IN_VEHICLE_STATUS_JOEY1
		if
			0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 21
		then
			0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 3
		end
	end //while
	0164: disable_marker $BLIP4_JM1
	if
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
	then
		goto @GO_TO_8BALLS
	else
		goto @JOEY_LABEL1
	end
end
return

/////////////////////////////////////////

:CHECK_MIKE_STATUS_JOEY1
if
	0118:   actor $JOEY1_MIKELIPS dead 
then
	goto @MISSION_PASSED_JOEY1
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_JOEY1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_JOEY1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_JOEY1
0004: $MIKE_LIPS_LAST_LUNCH_COMPLETED = 1 
if 
	0038:   $MISSION_PASSED_FOR_LIPS_FINISHED == 0 
then
	0394: play_mission_passed_music 1 
	01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
	0109: player $PLAYER_CHAR money += 10000 
	0004: $MISSION_PASSED_FOR_LIPS_FINISHED = 1 
end
0318: set_latest_mission_passed 'JM1'  // 'MIKE LIPS LAST LUNCH'
030C: set_mission_points += 1 
034F: destroy_actor_with_fade $JOEY1_MIKELIPS 
004F: create_thread @JOEY_MISSION2_LOOP 
goto @MISSION_END_JOEY1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_JOEY1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_JOEY = 0 
01B7: release_weather
0164: disable_marker $BLIP1_JM1 
0164: disable_marker $BLIP2_JM1 
0164: disable_marker $BLIP3_JM1 
0164: disable_marker $BLIP4_JM1 
0249: release_model #IDAHO 
0249: release_model #BARREL4 
0296: unload_special_actor 3 
0108: destroy_object $LIPSBARREL1
0108: destroy_object $LIPSBARREL2
0108: destroy_object $LIPSBARREL3
0108: destroy_object $LIPSBARREL4
0108: destroy_object $LIPSBARREL5
0108: destroy_object $LIPSBARREL6 
014F: stop_timer $COUNTDOWN_JM1 
if 
	8119:   not car $LIPSFORELLI_CAR wrecked 
then
	0294: set_car $LIPSFORELLI_CAR resprayable_to 1 
	020A: set_car $LIPSFORELLI_CAR door_status_to CARLOCK_UNLOCKED
	044F: make_craigs_car_a_bit_stronger $LIPSFORELLI_CAR 0 
end
021D: set_free_bomb_shop_to 0 
00D8: mission_has_finished 
return 
