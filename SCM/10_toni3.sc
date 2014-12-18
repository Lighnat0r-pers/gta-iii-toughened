// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 3****************************************
// *************************************Pick up the Lads**************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

:M10_SALVATORESCALLEDAMEETING

gosub @MISSION_START_TONI3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_TONI3
end

:MISSION_END_TONI3
gosub @MISSION_CLEANUP_TONI3
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_TONI3
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_TONI = 1 
03A4: name_thread 'TONI3' 
03D6: remove_styled_text 'M_PASS'  // MISSION PASSED! $~1~
0001: wait 0 ms 
0004: $CUTSCENE_SEEN_FLAG = 0 
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 0
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1
0004: $LIMO_CAR_MODEL = #PEREN

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

02E4: load_cutscene_data 'T3_MAS' 
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

while 001A:   3006 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_A' duration 10000 ms flag 1  // ~w~Don Salvatore has called a meeting.
while 001A:   5297 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_B' duration 10000 ms flag 1  // ~w~I need you to collect the limo and his boy, Joey, from the garage.
while 001A:   8661 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_C' duration 10000 ms flag 1  // ~w~Then get Luigi from his club, come back here and pick me up,
while 001A:   12025 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_D' duration 10000 ms flag 1  // ~w~then we'll all drive over to the boss's place together.
while 001A:   14817 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_E' duration 10000 ms flag 1  // ~w~Those Triads, they don't know when to stop.
while 001A:   17107 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_F' duration 10000 ms flag 1  // ~w~They want a war. They got a war.
while 001A:   18968 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_G' duration 10000 ms flag 1  // ~w~Now get going.
while 001A:   19787 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints
while 001A:   21666 > $CUT_SCENE_TIME
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

023C: load_special_actor 'TONY' as 1 
023C: load_special_actor 'JOEY2' as 2 
023C: load_special_actor 'LUIGI' as 3 
023C: load_special_actor 'DARKEL' as 4
0247: request_model $LIMO_CAR_MODEL
0247: request_model #BELLYUP 
0247: request_model #GANG03 
0247: request_model #GANG04

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 3 loaded
		823D:   not special_actor 5 loaded
		8248:   not model $LIMO_CAR_MODEL available 
		8248:   not model #BELLYUP available 
		8248:   not model #GANG03 available 
		8248:   not model #GANG04 available
	jf break
	wait 0 ms
end //while

00A5: $TONI3_LIMO = create_car $LIMO_CAR_MODEL at 1187.0 -860.375 14.5
0175: set_car $TONI3_LIMO z_angle_to 225.0 
0229: set_car $TONI3_LIMO color_to 0 0 
03AB: set_car $TONI3_LIMO strong 1 
018A: $TONI3_LIMO_MARKER = create_checkpoint_at 1191.688 -870.0 -100.0 
0294: set_car $TONI3_LIMO resprayable_to 0 

:PICK_UP_JOEY
0004: $FLAG_CAR_BLIP_DISPLAYED = 1 
gosub @CHECK_VEHICLE_STATUS_TONI3

while 80F6:   not player $PLAYER_CHAR 1 1191.688 -870.0 15.0 radius 1.5 1.5 2.0
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

01B4: set_player $PLAYER_CHAR controllable 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
02A3: toggle_widescreen 1 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1000 ms 
0001: wait 1000 ms 
03CB: load_scene 1190.063 -869.8125 13.9375

if
	0256:   is_player $PLAYER_CHAR defined
then
	0395: clear_area 1 at 1190.188 -866.375 range 14.0625 1.0 
	0055: set_player_coordinates $PLAYER_CHAR to 1189.5 -867.5625 14.0625 
	0171: set_player $PLAYER_CHAR z_angle_to 36.0 
	015F: set_camera_position 1186.125 -852.4375 17.1875 0.0 rotation 0.0 0.0 
	0160: point_camera 1186.063 -853.375 16.9375 switchstyle JUMP_CUT
	01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
	0319: set_actor $PLAYER_ACTOR running 1
	if
		8119:   not car $TONI3_LIMO wrecked
	then
		01D5: actor $PLAYER_ACTOR go_to_and_drive_car $TONI3_LIMO
	end
	fade 1 for 1000 ms
	wait 1000 ms
end

gosub @CHECK_VEHICLE_STATUS_TONI3
while 80DC:   not is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

0164: disable_marker $TONI3_LIMO_MARKER 
041E: set_radio_station BANG_RADIO -1 
009A: $JOEY_LEONE = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 1179.375 -858.5625 14.0
01ED: clear_actor $JOEY_LEONE threat_search

gosub @CHECK_VEHICLE_STATUS_TONI3

01D4: actor $JOEY_LEONE go_to_car $TONI3_LIMO and_enter_it_as_a_passenger 
03CF: load_wav 'T3_A'

while 80DB:   not is_char_in_car $JOEY_LEONE car $TONI3_LIMO 
	wait 0 ms
	gosub @CHECK_JOEY_STATUS_TONI3
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

while 83D0:   not wav_loaded
	wait 0 ms
end

03D1: play_wav 
039E: set_char_cant_be_dragged_out $JOEY_LEONE to 1 
018A: $TONI3_LUIGI_MARKER = create_checkpoint_at 906.1875 -426.0 -100.0 

//CAR DRIVING OUT OF GARAGE CUT SCENE

0395: clear_area 1 at 1195.0 -870.25 range 15.0 10.0 
015F: set_camera_position 1200.875 -866.5 19.0 0.0 rotation 0.0 0.0 
0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle JUMP_CUT
01BB: store_object $JOEY_DOOR1 position_to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z 
01BB: store_object $JOEY_DOOR2 position_to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z 
0009: $JOEYDOOR1_Z += 3.0 
0009: $JOEYDOOR2_Z += 3.0 

while true
	if or
		834E:   not move_object $JOEY_DOOR1 to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z speed 0.0625 0.0625 0.0625 collision_check 0 
		834E:   not move_object $JOEY_DOOR2 to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z speed 0.0625 0.0625 0.0625 collision_check 0 
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

02C2: car $TONI3_LIMO drive_to_point 1198.375 -871.0625 -100.0 
00AD: set_car_cruise_speed $TONI3_LIMO to 4.0 
00AE: set_car_driving_style $TONI3_LIMO to 3

while 81AD:   not car $TONI3_LIMO sphere 0 near_point 1198.375 -871.0625 radius 2.0 2.0 
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

01BB: store_object $JOEY_DOOR1 position_to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z 
01BB: store_object $JOEY_DOOR2 position_to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z 
000D: $JOEYDOOR1_Z -= 3.0 
000D: $JOEYDOOR2_Z -= 3.0

while true
	if or
		834E:   not move_object $JOEY_DOOR1 to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z speed 0.0625 0.0625 0.0625 collision_check 0 
		834E:   not move_object $JOEY_DOOR2 to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z speed 0.0625 0.0625 0.0625 collision_check 0 
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

0186: $TONI3_LIMO_MARKER = create_marker_above_car $TONI3_LIMO 
0164: disable_marker $TONI3_LIMO_MARKER 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
03A2: set_car_status $TONI3_LIMO to 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
02EB: restore_camera_jumpcut 
03C8: set_camera_directly_before_player 
02AC: set_car $TONI3_LIMO immunities 0 0 0 0 0 
0004: $FLAG_DISPLAYED_HORN_MESSAGE_TM3 = 0 
0004: $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 = 0 

00BC: print_now 'T3_JOEY' duration 5000 ms flag 2  //~g~Joey seems heavy today.
0054: get_player_coordinates $PLAYER_CHAR store_to $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z
wait 0 ms
02C7: scatter_platinum 2 at $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z 0.5

//PICK UP LUIGI

0164: disable_marker $TONI3_LUIGI_MARKER

:PICK_UP_LUIGI

gosub @CHECK_VEHICLE_STATUS_TONI3

0004: $FLAG_CAR_BLIP_DISPLAYED = 1 
0004: $BLOB_FLAG = 1 
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 1

while true
	if or
		819E:   not player $PLAYER_CHAR stopped $BLOB_FLAG 903.75 -423.0 14.0 908.25 -431.0 18.0 
		80DC:   not is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
		8122:   not player $PLAYER_CHAR pressing_horn 
		010F:   player $PLAYER_CHAR wanted_level > 0
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
	gosub @CHECK_IN_VEHICLE_STATUS_TONI3
	if and
		01A0:   player $PLAYER_CHAR stopped 0 903.75 -420.1875 14.0 908.25 -431.0625 18.0 
		00DC:   is_player_in_car $PLAYER_CHAR car $TONI3_LIMO
	then
		gosub @CHECK_WANTED_STATUS_TONI3
	end
	if
		819D:   not player $PLAYER_CHAR 0 903.75 -420.1875 14.0 908.25 -431.0625 18.0
	then
		gosub @PLAYER_LEFT_MARKER_TONI3
	end
	if 
		8185:   not car $TONI3_LIMO health >= 600 
	then
		wait 0 ms
		gosub @REPAIR_LIMO_STUFF_TONI3
		goto @PICK_UP_LUIGI
	end
end //while

03D5: remove_text 'WANTED1'  // ~g~Shake the cops and lose your wanted level!
03D5: remove_text 'HORN'  // ~g~Sound the horn.

if
	8119:   not car $TONI3_LIMO wrecked
then
	020A: set_car $TONI3_LIMO door_status_to CARLOCK_LOCKED_PLAYER_INSIDE
end
wait 500 ms
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0164: disable_marker $TONI3_LUIGI_MARKER
if
	8119:   not car $TONI3_LIMO wrecked
then
	020A: set_car $TONI3_LIMO door_status_to CARLOCK_UNLOCKED
end

0395: clear_area 1 at 897.0 -425.5 range 14.6875 6.0 
015F: set_camera_position 900.5 -419.625 14.9375 0.0 rotation 0.0 0.0 
0160: point_camera 900.875 -420.5625 15.0625 switchstyle JUMP_CUT
009A: $TONI3_LUIGI = create_char PEDTYPE_SPECIAL model #SPECIAL03 at 897.0 -425.25 14.75
01ED: clear_actor $TONI3_LUIGI threat_search 
03DE: set_ped_density_multiplier 0.0 
0006: 17@ = 0 
03CF: load_wav 'T3_B' 
0211: actor $TONI3_LUIGI walk_to 901.0 -426.375
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 0

while 8126:   not actor $TONI3_LUIGI walking
	wait 0 ms
	gosub @CHECK_LUIGI_STATUS_TONI3
	gosub @CHECK_VEHICLE_STATUS_TONI3
	if and
		0019:   17@ > 12000 
		8118:   not actor $TONI3_LUIGI dead 
	then
		00A1: set_char_coordinates $TONI3_LUIGI to 901.0 -426.375 -100.0
	end
end //while

01D4: actor $TONI3_LUIGI go_to_car $TONI3_LIMO and_enter_it_as_a_passenger

while 80DB:   not is_char_in_car $TONI3_LUIGI car $TONI3_LIMO
	wait 0 ms
	gosub @CHECK_LUIGI_STATUS_TONI3
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

039E: set_char_cant_be_dragged_out $TONI3_LUIGI to 1

while 83D0:   not wav_loaded
	wait 0 ms
end

03D1: play_wav 
01B4: set_player $PLAYER_CHAR controllable 1 
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03DE: set_ped_density_multiplier 1.0 
022A: switch_ped_roads_on 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
01E7: switch_roads_on 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
0004: $FLAG_DISPLAYED_HORN_MESSAGE_TM3 = 0 
0004: $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 = 0 

00BC: print_now 'T3_LUIG' duration 5000 ms flag 2  //~g~Luigi isn't much better.
0054: get_player_coordinates $PLAYER_CHAR store_to $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z
wait 0 ms
02C7: scatter_platinum 2 at $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z 0.5

009A: $TONI3_DARKEL = create_char PEDTYPE_SPECIAL model #SPECIAL04 at 1204.75 -306.60 24.97
01ED: clear_actor $TONI3_DARKEL threat_search 
0173: set_actor $TONI3_DARKEL z_angle_to 180.0

//PICK UP TONI

:PICK_UP_TONI

0004: $FLAG_CAR_BLIP_DISPLAYED = 1 
0004: $BLOB_FLAG = 1
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 2
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2

gosub @CHECK_IN_VEHICLE_STATUS_SIMPLE_TONI3

while true
	if or
		819E:   not player $PLAYER_CHAR stopped $BLOB_FLAG 1197.75 -321.0 24.25 1202.0 -327.5 28.0 
		80DC:   not is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
		8122:   not player $PLAYER_CHAR pressing_horn 
		010F:   player $PLAYER_CHAR wanted_level > 0
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
	gosub @CHECK_IN_VEHICLE_STATUS_TONI3
	if and
		01A0:   player $PLAYER_CHAR stopped 0 1197.75 -321.0 24.25 1202.0 -327.5 28.0 
		00DC:   is_player_in_car $PLAYER_CHAR car $TONI3_LIMO
	then
		gosub @CHECK_WANTED_STATUS_TONI3
	end
	if
		819D:   not player $PLAYER_CHAR 0 1197.75 -321.0 24.25 1202.0 -327.5 28.0 
	then
		gosub @PLAYER_LEFT_MARKER_TONI3
	end
	if 
		8185:   not car $TONI3_LIMO health >= 600 
	then
		wait 0 ms
		gosub @REPAIR_LIMO_STUFF_TONI3
		goto @PICK_UP_TONI
	end
end //while

03D5: remove_text 'WANTED1'  // ~g~Shake the cops and lose your wanted level!
03D5: remove_text 'HORN'  // ~g~Sound the horn.

if
	8119:   not car $TONI3_LIMO wrecked
then
	020A: set_car $TONI3_LIMO door_status_to CARLOCK_LOCKED_PLAYER_INSIDE
end
wait 500 ms
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0164: disable_marker $TONI3_TONI_MARKER
if
	8119:   not car $TONI3_LIMO wrecked
then
	020A: set_car $TONI3_LIMO door_status_to CARLOCK_UNLOCKED
end

0395: clear_area 1 at 1213.563 -321.0625 range 26.5 10.0 
009A: $TONI_CIPRIANI = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 1217.0 -321.0625 -100.0
0173: set_actor $TONI_CIPRIANI z_angle_to 90.0 
01ED: clear_actor $TONI_CIPRIANI threat_search 
015F: set_camera_position 1222.188 -328.625 34.4375 rotation 0.0 0.0 0.0 
0160: point_camera 1221.625 -328.0 33.875 switchstyle JUMP_CUT
03DE: set_ped_density_multiplier 0.0 
0006: 17@ = 0 
03CF: load_wav 'T3_C' 
0211: actor $TONI_CIPRIANI walk_to 1205.0 -321.0 
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 0

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_TONI_STATUS_TONI3
	gosub @CHECK_VEHICLE_STATUS_TONI3
	if and
		0019:   17@ > 12000 
		8118:   not actor $TONI_CIPRIANI dead 
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 1205.0 -321.0 -100.0 
	end
end //while


if
	8118:   not actor $TONI3_DARKEL dead
then
	015F: set_camera_position 1200.0 -331.3 34.4375 rotation 0.0 0.0 0.0 
	0160: point_camera 1205.0 -321.3 24.4375 switchstyle JUMP_CUT
	0006: 17@ = 0 
	01B2: give_actor $TONI3_DARKEL weapon WEAPONTYPE_FLAMETHROWER ammo 100 
	0211: actor $TONI3_DARKEL walk_to 1204.3 -316.3 
	while 8126:   not actor $TONI3_DARKEL walking
		wait 0 ms
		gosub @CHECK_TONI_STATUS_TONI3
		gosub @CHECK_VEHICLE_STATUS_TONI3
		if and
			0019:   17@ > 12000 
			8118:   not actor $TONI3_DARKEL dead 
		then
			00A1: set_char_coordinates $TONI3_DARKEL to 1204.3 -316.3 -100.0 
		end
	end //while
	020E: actor $TONI3_DARKEL look_at_actor $TONI_CIPRIANI
	020E: actor $TONI_CIPRIANI look_at_actor $TONI3_DARKEL
	wait 100 ms
	01CB: actor $TONI3_DARKEL kill_actor $TONI_CIPRIANI
	0006: 17@ = 0 

	while 8118:   not actor $TONI_CIPRIANI dead
		wait 0 ms
		gosub @CHECK_VEHICLE_STATUS_TONI3
		if and
			0019:   17@ > 12000 
			8118:   not actor $TONI_CIPRIANI dead 
		then
			0321: kill_actor $TONI_CIPRIANI
		end
	end //while
	00BC: print_now 'JM4_8' duration 5000 ms flag 1  // ~r~Toni's been wasted!
	goto @MISSION_FAILED_TONI3
end

015F: set_camera_position 1206.188 -326.1875 27.0 0.0 rotation 0.0 0.0 
0159: camera_on_ped $TONI_CIPRIANI mode FIXED switchstyle JUMP_CUT
01D4: actor $TONI_CIPRIANI go_to_car $TONI3_LIMO and_enter_it_as_a_passenger

while 80DB:   not is_char_in_car $TONI_CIPRIANI car $TONI3_LIMO
	wait 0 ms
	gosub @CHECK_TONI_STATUS_TONI3
	gosub @CHECK_VEHICLE_STATUS_TONI3
end //while

while 83D0:   not wav_loaded
	wait 0 ms
end

03D1: play_wav 
039E: set_char_cant_be_dragged_out $TONI_CIPRIANI to 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03DE: set_ped_density_multiplier 1.0 

//YET ANOTHER AMBUSH BY THE TRIADS

00A5: $TONI3_TRIAD_VAN1 = create_car #BELLYUP at 1193.0 -228.0 -100.0
0175: set_car $TONI3_TRIAD_VAN1 z_angle_to 180.0 
00AE: set_car_driving_style $TONI3_TRIAD_VAN1 to 3 
00AD: set_car_cruise_speed $TONI3_TRIAD_VAN1 to 30.0 
03AB: set_car $TONI3_TRIAD_VAN1 strong 1 

0129: $TONI3_TRIAD1 = create_actor PEDTYPE_GANG_TRIAD #GANG03 in_car $TONI3_TRIAD_VAN1 driverseat
01B2: give_actor $TONI3_TRIAD1 weapon WEAPONTYPE_UZI ammo 100 
00AF: set_car_mission $TONI3_TRIAD_VAN1 to MISSION_RAMPLAYER_FARAWAY 
011A: set_actor $TONI3_TRIAD1 search_threat THREAT_PLAYER1
 
01C8: $TONI3_TRIAD2 = create_actor PEDTYPE_GANG_TRIAD model #GANG04 in_car $TONI3_TRIAD_VAN1 passenger_seat 0
01B2: give_actor $TONI3_TRIAD2 weapon WEAPONTYPE_UZI ammo 100 
01CC: actor $TONI3_TRIAD2 kill_player $PLAYER_CHAR 
011A: set_actor $TONI3_TRIAD2 search_threat THREAT_PLAYER1 


00A5: $TONI3_TRIAD_VAN2 = create_car #BELLYUP at 1275.75 -346.6875 -100.0
0175: set_car $TONI3_TRIAD_VAN2 z_angle_to 1.0 
00AE: set_car_driving_style $TONI3_TRIAD_VAN2 to 3 
00AD: set_car_cruise_speed $TONI3_TRIAD_VAN2 to 30.0 
03AB: set_car $TONI3_TRIAD_VAN2 strong 1 

0129: $TONI3_TRIAD3 = create_actor PEDTYPE_GANG_TRIAD #GANG03 in_car $TONI3_TRIAD_VAN2 driverseat
01B2: give_actor $TONI3_TRIAD3 weapon WEAPONTYPE_UZI ammo 100 
00AF: set_car_mission $TONI3_TRIAD_VAN2 to MISSION_RAMPLAYER_FARAWAY 
011A: set_actor $TONI3_TRIAD3 search_threat THREAT_PLAYER1 

01C8: $TONI3_TRIAD4 = create_actor PEDTYPE_GANG_TRIAD model #GANG04 in_car $TONI3_TRIAD_VAN2 passenger_seat 0
01B2: give_actor $TONI3_TRIAD4 weapon WEAPONTYPE_UZI ammo 100 
01CC: actor $TONI3_TRIAD4 kill_player $PLAYER_CHAR 
011A: set_actor $TONI3_TRIAD4 search_threat THREAT_PLAYER1 


00A5: $TONI3_TRIAD_VAN3 = create_car #BELLYUP at 1342.5 -281.5 -100.0
0175: set_car $TONI3_TRIAD_VAN3 z_angle_to 90.0 
00AE: set_car_driving_style $TONI3_TRIAD_VAN3 to 3 
00AD: set_car_cruise_speed $TONI3_TRIAD_VAN3 to 30.0 
03AB: set_car $TONI3_TRIAD_VAN3 strong 1 

0129: $TONI3_TRIAD5 = create_actor PEDTYPE_GANG_TRIAD #GANG03 in_car $TONI3_TRIAD_VAN3 driverseat
01B2: give_actor $TONI3_TRIAD5 weapon WEAPONTYPE_UZI ammo 100 
00AF: set_car_mission $TONI3_TRIAD_VAN3 to MISSION_RAMPLAYER_FARAWAY 
011A: set_actor $TONI3_TRIAD5 search_threat THREAT_PLAYER1 

01C8: $TONI3_TRIAD6 = create_actor PEDTYPE_GANG_TRIAD model #GANG04 in_car $TONI3_TRIAD_VAN3 passenger_seat 0
01B2: give_actor $TONI3_TRIAD6 weapon WEAPONTYPE_UZI ammo 100 
01CC: actor $TONI3_TRIAD6 kill_player $PLAYER_CHAR 
011A: set_actor $TONI3_TRIAD6 search_threat THREAT_PLAYER1 


00A5: $TONI3_TRIAD_VAN4 = create_car #BELLYUP at 1121.563 -345.1875 -100.0
0175: set_car $TONI3_TRIAD_VAN4 z_angle_to 270.0 
00AE: set_car_driving_style $TONI3_TRIAD_VAN4 to 3 
00AD: set_car_cruise_speed $TONI3_TRIAD_VAN4 to 30.0 
03AB: set_car $TONI3_TRIAD_VAN4 strong 1 

0129: $TONI3_TRIAD7 = create_actor PEDTYPE_GANG_TRIAD #GANG03 in_car $TONI3_TRIAD_VAN4 driverseat
01B2: give_actor $TONI3_TRIAD7 weapon WEAPONTYPE_UZI ammo 100 
00AF: set_car_mission $TONI3_TRIAD_VAN4 to MISSION_RAMPLAYER_FARAWAY 
011A: set_actor $TONI3_TRIAD7 search_threat THREAT_PLAYER1 

01C8: $TONI3_TRIAD8 = create_actor PEDTYPE_GANG_TRIAD model #GANG04 in_car $TONI3_TRIAD_VAN4 passenger_seat 0
01B2: give_actor $TONI3_TRIAD8 weapon WEAPONTYPE_UZI ammo 100 
01CC: actor $TONI3_TRIAD8 kill_player $PLAYER_CHAR 
011A: set_actor $TONI3_TRIAD8 search_threat THREAT_PLAYER1 


//ROAD BLOCK

00A5: $TONI3_TRIAD_VAN5 = create_car #BELLYUP at 1383.25 -285.0 -100.0
0175: set_car $TONI3_TRIAD_VAN5 z_angle_to 10.0 
00A5: $TONI3_TRIAD_VAN6 = create_car #BELLYUP at 1383.25 -279.0 -100.0
0175: set_car $TONI3_TRIAD_VAN6 z_angle_to 160.0 

009A: $TONI3_TRIAD9 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 1382.063 -281.6875 -100.0
01B2: give_actor $TONI3_TRIAD9 weapon WEAPONTYPE_UZI ammo 100 
0350: set_actor $TONI3_TRIAD9 maintain_position_when_attacked 1 
01D9: actor $TONI3_TRIAD9 destroy_car $TONI3_LIMO 
011A: set_actor $TONI3_TRIAD9 search_threat THREAT_PLAYER1 

009A: $TONI3_TRIAD10 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 1384.25 -291.5 -100.0
01B2: give_actor $TONI3_TRIAD10 weapon WEAPONTYPE_UZI ammo 100 
0350: set_actor $TONI3_TRIAD10 maintain_position_when_attacked 1 
01D9: actor $TONI3_TRIAD10 destroy_car $TONI3_LIMO 
011A: set_actor $TONI3_TRIAD10 search_threat THREAT_PLAYER1 

0158: camera_on_vehicle $TONI3_TRIAD_VAN1 mode BEHINDCAR switchstyle INTERPOLATION 
0001: wait 3000 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
02EB: restore_camera_jumpcut 

00BC: print_now 'T3_TONI' duration 5000 ms flag 2  //~g~Seems like Toni had a REALLY big lunch today.
0054: get_player_coordinates $PLAYER_CHAR store_to $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z
wait 0 ms
02C7: scatter_platinum 4 at $TONI3_PLAYER_X $TONI3_PLAYER_Y $TONI3_PLAYER_Z 0.5

//GO TO FRANKIES

:GET_TO_FRANKIES

0004: $FLAG_CAR_BLIP_DISPLAYED = 1 
0004: $FLAVOUR_TEXT_FLAG_TONI3 = 3
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 3

if
	8119:   not car $TONI3_LIMO wrecked 
then
	021B: set_garage $SALVATORES_GARAGE to_accept_car $TONI3_LIMO
end

gosub @CHECK_IN_VEHICLE_STATUS_SIMPLE_TONI3

while 821C:   not car_inside_garage $SALVATORES_GARAGE
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
	gosub @CHECK_IN_VEHICLE_STATUS_TONI3
	if
		8119:   not car $TONI3_TRIAD_VAN1 wrecked 
	then
		if and
			00B0:   is_car_in_area_2d $TONI3_TRIAD_VAN1 from 1393.563 -268.1875 to 1427.063 -154.0625 sphere 0
			8118:   not actor $TONI3_TRIAD1 dead 
			8118:   not actor $TONI3_TRIAD2 dead
		then
			01CA: actor $TONI3_TRIAD1 kill_player $PLAYER_CHAR 
			01CA: actor $TONI3_TRIAD2 kill_player $PLAYER_CHAR
		end
	end
	if
		8119:   not car $TONI3_TRIAD_VAN2 wrecked 
	then
		if and
			00B0:   is_car_in_area_2d $TONI3_TRIAD_VAN2 from 1393.563 -268.1875 to 1427.063 -154.0625 sphere 0
			8118:   not actor $TONI3_TRIAD3 dead 
			8118:   not actor $TONI3_TRIAD4 dead
		then
			01CA: actor $TONI3_TRIAD3 kill_player $PLAYER_CHAR 
			01CA: actor $TONI3_TRIAD4 kill_player $PLAYER_CHAR
		end
	end
	if
		8119:   not car $TONI3_TRIAD_VAN3 wrecked 
	then
		if and
			00B0:   is_car_in_area_2d $TONI3_TRIAD_VAN3 from 1393.563 -268.1875 to 1427.063 -154.0625 sphere 0
			8118:   not actor $TONI3_TRIAD5 dead 
			8118:   not actor $TONI3_TRIAD6 dead
		then
			01CA: actor $TONI3_TRIAD5 kill_player $PLAYER_CHAR 
			01CA: actor $TONI3_TRIAD6 kill_player $PLAYER_CHAR
		end
	end
	if
		8119:   not car $TONI3_TRIAD_VAN4 wrecked 
	then
		if and
			00B0:   is_car_in_area_2d $TONI3_TRIAD_VAN4 from 1393.563 -268.1875 to 1427.063 -154.0625 sphere 0
			8118:   not actor $TONI3_TRIAD7 dead 
			8118:   not actor $TONI3_TRIAD8 dead
		then
			01CA: actor $TONI3_TRIAD7 kill_player $PLAYER_CHAR 
			01CA: actor $TONI3_TRIAD8 kill_player $PLAYER_CHAR
		end
	end
end //while

0164: disable_marker $TONI3_LIMO_MARKER 
0164: disable_marker $TONI3_SALVATORE_MARKER 
015F: set_camera_position 1421.75 -182.5 52.5 0.0 rotation 0.0 0.0 
0158: camera_on_vehicle $TONI3_LIMO mode FIXED switchstyle INTERPOLATION
0001: wait 1000 ms 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0

if
	00E0:   is_player_in_any_car $PLAYER_CHAR
then
	012A: put_player $PLAYER_CHAR at 1454.563 -189.5 55.0 and_remove_from_car
else
	0055: set_player_coordinates $PLAYER_CHAR to 1454.563 -189.5 55.0 
end

if
	8118:   not actor $TONI3_TRIAD1 dead 
then
	009B: delete_char $TONI3_TRIAD1
end
if
	8118:   not actor $TONI3_TRIAD2 dead 
then
	009B: delete_char $TONI3_TRIAD2
end
if
	8118:   not actor $TONI3_TRIAD3 dead 
then
	009B: delete_char $TONI3_TRIAD3
end
if
	8118:   not actor $TONI3_TRIAD4 dead 
then
	009B: delete_char $TONI3_TRIAD4
end
if
	8118:   not actor $TONI3_TRIAD5 dead 
then
	009B: delete_char $TONI3_TRIAD5
end
if
	8118:   not actor $TONI3_TRIAD6 dead 
then
	009B: delete_char $TONI3_TRIAD6
end
if
	8118:   not actor $TONI3_TRIAD7 dead 
then
	009B: delete_char $TONI3_TRIAD7
end
if
	8118:   not actor $TONI3_TRIAD8 dead 
then
	009B: delete_char $TONI3_TRIAD8
end
if
	8118:   not actor $TONI3_TRIAD9 dead 
then
	009B: delete_char $TONI3_TRIAD9
end
if
	8118:   not actor $TONI3_TRIAD10 dead 
then
	009B: delete_char $TONI3_TRIAD10
end
if
	8119:   not car $TONI3_TRIAD_VAN1 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN1
end
if
	8119:   not car $TONI3_TRIAD_VAN2 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN2
end
if
	8119:   not car $TONI3_TRIAD_VAN3 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN3
end
if
	8119:   not car $TONI3_TRIAD_VAN4 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN4
end
if
	8119:   not car $TONI3_TRIAD_VAN5 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN5
end
if
	8119:   not car $TONI3_TRIAD_VAN6 wrecked
then
	00A6: delete_car $TONI3_TRIAD_VAN6
end

01BD: $PRE_CUTSCENE_START_TIME = current_time_in_ms 
0004: $PRE_CUTSCENE_ELAPSED_TIME = 0

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		001A:   5000 > $PRE_CUTSCENE_ELAPSED_TIME //	if player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
	01BD: $PRE_CUTSCENE_CURRENT_TIME = current_time_in_ms 
	0084: $PRE_CUTSCENE_ELAPSED_TIME = $PRE_CUTSCENE_CURRENT_TIME 
	0060: $PRE_CUTSCENE_ELAPSED_TIME -= $PRE_CUTSCENE_START_TIME
end //while

03EF: player $PLAYER_CHAR make_safe 

// ****************************************START OF CUTSCENE2********************************

0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
0395: clear_area 1 at 1427.0 -187.75 range 50.0 12.0 
0395: clear_area 1 at 1444.938 -186.875 range 56.0 30.0 
03AD: set_rubbish 0 
03AF: set_streaming 0 
023C: load_special_actor 'FRANKIE' as 4 
0247: request_model #GANG02 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'FRANKH' 
02F3: load_object #CUTOBJ03 'JOEYH' 
02F3: load_object #CUTOBJ04 'LUIGIH' 
02F3: load_object #CUTOBJ05 'TONYH' 
0247: request_model #SALVSDETAIL 
0247: request_model #SWANK_INSIDE 
0247: request_model #FRANKSCLB02

while fading
	wait 0 ms
end

038B: load_all_models_now

while true
	if or
		823D:   not special_actor 4 loaded 
		8248:   not model #GANG02 available 
		8248:   not model #SALVSDETAIL available 
		8248:   not model #SWANK_INSIDE available 
		8248:   not model #FRANKSCLB02 available
	jf break
	wait 0 ms
end //while

while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
		8248:   not model #CUTOBJ05 available
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'S0_MAS' 
0244: set_cutscene_pos 1457.75 -185.3125 54.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_TONY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_TONY 'TONY' 
02E5: $CUTSCENE_JOEY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_JOEY 'JOEY2' 
02E5: $CUTSCENE_LUIGI = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CUTSCENE_LUIGI 'LUIGI' 
02E5: $CUTSCENE_SALVATORE = create_cutscene_object #SPECIAL04 
02E6: set_cutscene_anim $CUTSCENE_SALVATORE 'FRANKIE' 
02E5: $CUTSCENE_MAFIA = create_cutscene_object #GANG02 
02E6: set_cutscene_anim $CUTSCENE_MAFIA 'GANG02' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $SALVATORE_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_SALVATORE 
02F5: set_head_anim $SALVATORE_CSHEAD 'FRANK' 
02F4: create_cutscene_actor $JOEY_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_JOEY 
02F5: set_head_anim $JOEY_CSHEAD 'JOEY' 
02F4: create_cutscene_actor $LUIGI_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_LUIGI 
02F5: set_head_anim $LUIGI_CSHEAD 'LUIGI' 
02F4: create_cutscene_actor $TONY_CSHEAD from_head #CUTOBJ05 and_body $CUTSCENE_TONY 
02F5: set_head_anim $TONY_CSHEAD 'TONY' 
0171: set_player $PLAYER_CHAR z_angle_to 341.0 
016A: fade 1 for 1500 ms 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime

while 001A:   416 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_H' duration 10000 ms flag 1  // ~w~You did good back there kid, real good.
while 001A:   3252 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_I' duration 10000 ms flag 1  // ~w~Come on, let's introduce you to the Don.
while 001A:   4866 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_J' duration 10000 ms flag 1  // ~w~Heeyyy! Luigi!
while 001A:   5839 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_K' duration 10000 ms flag 1  // ~w~Oh my girls have been missing you so long Salvatore, you been away too long.
while 001A:   10201 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_L' duration 10000 ms flag 1  // ~w~You tell them that once this unfortunate business is taken care of,
while 001A:   13769 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_M' duration 10000 ms flag 1  // ~w~we'll all go down to the club and celebrate, ok?
while 001A:   17654 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_N' duration 10000 ms flag 1  // ~w~Here's my boy.
while 001A:   18718 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_N2' duration 10000 ms flag 1  // ~w~How you doin' pop?
while 001A:   19529 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_O' duration 10000 ms flag 1  // ~w~You got yourself a good woman yet?
while 001A:   21673 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_P' duration 10000 ms flag 1  // ~w~Hey, your mother, god bless her soul, would be turning over in her grave
while 001A:   25525 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_Q' duration 10000 ms flag 1  // ~w~to see you without a wife.
while 001A:   26615 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_R' duration 10000 ms flag 1  // ~w~I know Pop, I'm working on it.
while 001A:   29462 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_S' duration 10000 ms flag 1  // ~w~TONI! How's your Momma?
while 001A:   32814 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_T' duration 10000 ms flag 1  // ~w~She's a great woman you know. Strong. Firenze.
while 001A:   35855 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_U' duration 10000 ms flag 1  // ~w~She's good...fine.
while 001A:   37787 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_V' duration 10000 ms flag 1  // ~w~Terrific, Terrific. Now listen you guys, you go inside while I talk to our new friend here.
while 001A:   44707 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM3_W' duration 10000 ms flag 1  // ~w~I see nothing but good things for you my boy...
while 001A:   47837 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   48666 > $CUT_SCENE_TIME
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

00BE: clear_prints 
016A: fade 0 for 0 ms 
02EA: end_cutscene 
016A: fade 0 for 0 ms 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0296: unload_special_actor 4 
0296: unload_special_actor 5
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 
0249: release_model #SALVSDETAIL 
0249: release_model #SWANK_INSIDE 
0249: release_model #FRANKSCLB02 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 

goto @MISSION_PASSED_TONI3

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_TONI3
if
	0119:   car $TONI3_LIMO wrecked 
then
	if
		0038: $FLAVOUR_TEXT_FLAG_TONI3 == 1
	then
		00BC: print_now 'TM3_A1' duration 5000 ms flag 1  // ~r~Joey's Fried!
	else
		if
			0038: $FLAVOUR_TEXT_FLAG_TONI3 == 2
		then
			00BC: print_now 'TM3_A2' duration 5000 ms flag 1  // ~r~Joey and Luigi have been cremated!
		else
			if
				0038: $FLAVOUR_TEXT_FLAG_TONI3 == 3
			then
				00BC: print_now 'TM3_A3' duration 5000 ms flag 1  // ~r~Joey, Luigi and Toni are Toast!
			end
		end
	end
	goto @MISSION_FAILED_TONI3
end
return

/////////////////////////////////////////

:CHECK_JOEY_STATUS_TONI3
if
	0118:   actor $JOEY_LEONE dead
then
	goto @MISSION_FAILED_TONI3
end
return

/////////////////////////////////////////

:CHECK_LUIGI_STATUS_TONI3
if
	0118:   actor $TONI3_LUIGI dead
then
	goto @MISSION_FAILED_TONI3
end
return

/////////////////////////////////////////

:CHECK_TONI_STATUS_TONI3
if
	0118:   actor $TONI_CIPRIANI dead
then
	goto @MISSION_FAILED_TONI3
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_TONI3
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
	0038:   $FLAG_CAR_BLIP_DISPLAYED == 1 
then
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 999
	then
		02A8: $BLIP5_T3 = create_marker RADAR_SPRITE_SPRAY at 925.0 -359.5 -100.0 
	else
		if
			0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
		then
			018A: $TONI3_LUIGI_MARKER = create_checkpoint_at 906.1875 -426.0 -100.0 
			0004: $BLOB_FLAG = 1 
		else
			if
				0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
			then
				018A: $TONI3_TONI_MARKER = create_checkpoint_at 1200.5 -322.5 -100.0 
				0004: $BLOB_FLAG = 1
			else
				018A: $TONI3_SALVATORE_MARKER = create_checkpoint_at 1428.563 -183.0625 -100.0 
				018B: show_on_radar $TONI3_SALVATORE_MARKER BLIP_ONLY 
			end
		end
	end
	0164: disable_marker $TONI3_LIMO_MARKER 
	0004: $FLAG_CAR_BLIP_DISPLAYED = 0
end
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
	0038:   $FLAG_CAR_BLIP_DISPLAYED == 0
then
	0186: $TONI3_LIMO_MARKER = create_marker_above_car $TONI3_LIMO 
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 999
	then
		0164: disable_marker $BLIP5_T3 
	else
		if
			0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
		then
			0164: disable_marker $TONI3_LUIGI_MARKER 
			0004: $BLOB_FLAG = 0 
		else
			if
				0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
			then
				0164: disable_marker $TONI3_TONI_MARKER
				0004: $BLOB_FLAG = 0 
			else
				0164: disable_marker $TONI3_SALVATORE_MARKER
			end
		end
	end
	00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	0004: $FLAG_CAR_BLIP_DISPLAYED = 1
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_SIMPLE_TONI3
if
	8119:   not car $TONI3_LIMO wrecked
then
	if
		80DC:   not is_player_in_car $PLAYER_CHAR car $TONI3_LIMO 
	then
		0164: disable_marker $TONI3_LIMO_MARKER 
		0186: $TONI3_LIMO_MARKER = create_marker_above_car $TONI3_LIMO 
		0004: $BLOB_FLAG = 0
		00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	end
end
return

/////////////////////////////////////////

:CHECK_WANTED_STATUS_TONI3
if
	010F:   player $PLAYER_CHAR wanted_level > 0
then
	if
		0038:   $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 == 0
	then
		00BC: print_now 'WANTED1' duration 5000 ms flag 1  // ~g~Shake the cops and lose your wanted level!
		0004: $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 = 1
	end
else
	if
		0038:   $FLAG_DISPLAYED_HORN_MESSAGE_TM3 == 0
	then
		00BC: print_now 'HORN' duration 5000 ms flag 1  // ~g~Sound the horn.
		0004: $FLAG_DISPLAYED_HORN_MESSAGE_TM3 = 1
	end
end
return

/////////////////////////////////////////

:PLAYER_LEFT_MARKER_TONI3
if or
	0038:   $FLAG_DISPLAYED_HORN_MESSAGE_TM3 == 1 
	0038:   $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 == 1
then
	03D5: remove_text 'WANTED1'  // ~g~Shake the cops and lose your wanted level!
	03D5: remove_text 'HORN'  // ~g~Sound the horn.
	0004: $FLAG_DISPLAYED_HORN_MESSAGE_TM3 = 0 
	0004: $FLAG_DISPLAYED_WANTED_MESSAGE_TM3 = 0
end
return

/////////////////////////////////////////

:REPAIR_LIMO_STUFF_TONI3
wait 500 ms
gosub @CHECK_VEHICLE_STATUS_TONI3
00BC: print_now 'TRASH' duration 5000 ms flag 2  // ~g~You've junked your wheels real bad! Get your vehicle repaired!
0164: disable_marker $TONI3_LIMO_MARKER 
0164: disable_marker $TONI3_LUIGI_MARKER 
0186: $TONI3_LIMO_MARKER = create_marker_above_car $TONI3_LIMO 
018B: show_on_radar $TONI3_LIMO_MARKER BLIP_ONLY 
0004: $FLAG_CAR_BLIP_DISPLAYED = 1 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 999
while 8185:   not car $TONI3_LIMO health >= 600
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_TONI3
	gosub @CHECK_IN_VEHICLE_STATUS_TONI3
end //while
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1
0164: disable_marker $BLIP5_T3
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_TONI3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_TONI3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_TONI3
0004: $SALVATORES_CALLED_A_MEETING_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 15000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 15000 
0318: set_latest_mission_passed 'TM3'  // 'SALVATORE'S CALLED A MEETING'
030C: set_mission_points += 1 
004F: create_thread @FRANKIE_MISSION1_LOOP 
0164: disable_marker $LUIGI_MISSION_MARKER 
0164: disable_marker $JOEY_MISSION_MARKER 
0164: disable_marker $TONI_MISSION_MARKER 
0164: disable_marker $SALVATORE_MISSION_MARKER 
02A7: $SALVATORE_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAL at 1455.688 -187.25 -100.0 
00A6: delete_car $TONI3_LIMO 
02EB: restore_camera_jumpcut 
0373: set_camera_directly_behind_player 
goto @MISSION_END_TONI3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_TONI3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_TONI = 0 
0164: disable_marker $TONI3_LIMO_MARKER 
0164: disable_marker $TONI3_SALVATORE_MARKER 
0164: disable_marker $TONI3_LUIGI_MARKER 
0164: disable_marker $TONI3_TONI_MARKER 
0164: disable_marker $BLIP5_T3 
034F: destroy_actor_with_fade $JOEY_LEONE 
034F: destroy_actor_with_fade $TONI3_LUIGI 
034F: destroy_actor_with_fade $TONI_CIPRIANI 
034F: destroy_actor_with_fade $TONI3_DARKEL
0249: release_model #STRETCH 
0249: release_model #BELLYUP 
0249: release_model #GANG03 
0249: release_model #GANG04 
0249: release_model #GANG02 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0296: unload_special_actor 4 
0296: unload_special_actor 5
021B: set_garage $SALVATORES_GARAGE to_accept_car -1 
03D5: remove_text 'IN_VEH'  // ~g~Hey! Get back in the vehicle!
00D8: mission_has_finished 
return
