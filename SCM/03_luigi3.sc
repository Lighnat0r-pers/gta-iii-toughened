// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Luigi mission 3*********************************
// ***************************************"Drive Misty For Me"****************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
:M03_DRIVEMISTYFORME

03A4: name_thread 'LUIGI3' 

// Mission start stuff

gosub @MISSION_START_LUIGI3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LUIGI3
end

:MISSION_END_LUIGI3
gosub @MISSION_CLEANUP_LUIGI3
end_thread

// ****************************************Mission Start************************************

:MISSION_START_LUIGI3

0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_LUIGI = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
0004: $FLAG_PLAYER_GOT_MESSAGE_LM3 = 0 
0004: $FLAG_PLAYER_GOT_COPS_MESSAGE_LM3 = 0 
0004: $FLAG_PLAYER_NOT_IN_ZONE_LM3 = 0 
0005: $DOOR1_POSITION_LM3 = 0.0 
0005: $DOOR2_POSITION_LM3 = 0.0 
0005: $DIFFERENCE_IN_HEADING_DOOR1_LM3 = 0.0 
0005: $DIFFERENCE_IN_HEADING_DOOR2_LM3 = 0.0 
0004: $FLAG_BLIP_ON_MISTY_LM3 = 0 
0004: $BLOB_FLAG = 1 
0004: $FLAG_CAMERA_MODE_LM3 = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0
0004: $AMBUSH_TRIGGERED_LM3 = 0 

// *****************************************START OF CUT_SCENE******************************

023C: load_special_actor 'LUIGI' as 1 
023C: load_special_actor 'MICKY' as 2 
0247: request_model #INDHIBUILD3 
0247: request_model #LUIGICLUBOUT 
0247: request_model #LUIGIINEERCLUB 
02F3: load_object #CUTOBJ01 'LUDOOR' 
02F3: load_object #CUTOBJ02 'LUIGIH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'MICKYH' 
03DE: set_ped_density_multiplier 0.0 
042B: clear_peds_from_cube 926.5 -471.6875 1.0 830.75 -257.9375 25.0 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
	jf break
	wait 0 ms
end //while
while true
	if or
		8248:   not model #INDHIBUILD3 available 
		8248:   not model #LUIGICLUBOUT available 
		8248:   not model #LUIGIINEERCLUB available 
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 0 
02E4: load_cutscene_data 'L3_DM' 
0244: set_cutscene_pos 900.75 -427.5 13.8125 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_LUIGI = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_LUIGI 'LUIGI' 
02E5: $CUTSCENE_MICKY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MICKY 'MICKY' 
02F4: create_cutscene_actor $LUIGI_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_LUIGI 
02F5: set_head_anim $LUIGI_CSHEAD 'LUIGI' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $MICKY_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_MICKY 
02F5: set_head_anim $MICKY_CSHEAD 'MICKY' 
02E5: $CS_LUDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_LUDOOR 'LUDOOR' 
0395: clear_area 1 at 896.5625 -426.1875 range 13.875 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 896.5625 -426.1875 13.875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   2433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_A' duration 10000 ms flag 1  // Hey I've gotta talk to you... All right Mick I'll talk to yah later.
while 001A:   5504 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LM3_A'  // Hey I've gotta talk to you... All right Mick I'll talk to yah later.
while 001A:   8333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_B' duration 10000 ms flag 1  // How yah doing kid?
while 001A:   9667 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_C' duration 10000 ms flag 1  // The Don's son, Joey Leone, he wants some action from his regular girl Misty.
while 001A:   13833 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_D' duration 10000 ms flag 1  // Go pick her up at Hepburn Heights...
while 001A:   15467 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_E' duration 10000 ms flag 1  // but watch yourself that's Diablo turf.
while 001A:   18233 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_F' duration 10000 ms flag 1  // Then run her over to his garage in Trenton and make it quick,
while 001A:   21100 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_G' duration 10000 ms flag 1  // Joey ain't the kind you keep waiting, remember, this is your foot in the door...
while 001A:   25333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_H' duration 10000 ms flag 1  // so keep your eyes on the road and off Misty!
while 001A:   27701 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LM3_H'  // so keep your eyes on the road and off Misty!
while 001A:   29666 > $CUT_SCENE_TIME
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
03AF: set_streaming 1 
03AD: set_rubbish 1 
03CB: load_scene 920.25 -425.375 15.0 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0373: set_camera_directly_behind_player 
0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 1 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #INDHIBUILD3 
0249: release_model #LUIGICLUBOUT 
0249: release_model #LUIGIINEERCLUB 
03DE: set_ped_density_multiplier 1.0 
023C: load_special_actor 'MISTY' as 2 
0247: request_model #RHINO
0247: request_model #CRIMINAL01

while true
	if or
		823D:   not special_actor 2 loaded
		8248:   not model #RHINO available 
		8248:   not model #CRIMINAL01 available 
	jf break
	wait 0 ms
end //while

while fading
	wait 0 ms
end

00BC: print_now 'LM3_10' duration 5000 ms flag 1  // ~g~Get a vehicle!

while 80E0:   not is_player_in_any_car $PLAYER_CHAR
	wait 0 ms
end

00DA: $LUIGI3_PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
00BC: print_now 'LM3_4' duration 7000 ms flag 1  // ~g~Go pick up Misty!
03CF: load_wav 'L2_A' 
018A: $LUIGI3_MISTY_MARKER = create_checkpoint_at 937.875 -259.75 -100.0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1
0004: $BLOB_FLAG = 1

// waiting for the player to get to Misty's flat

while true
	if or
		80E8:   not player $PLAYER_CHAR stopped $BLOB_FLAG 937.875 -259.75 radius 3.0 3.0 
		83D0:   not wav_loaded
	jf break
	wait 0 ms
	gosub @CHECK_IN_VEHICLE_STATUS_LUIGI3
end //while

0004: $BLOB_FLAG = 1 

while true
	if or
		8122:   not player $PLAYER_CHAR pressing_horn 
		80E8:   not player $PLAYER_CHAR stopped $BLOB_FLAG 937.875 -259.75 radius 3.0 3.0 
		8443:   not player $PLAYER_CHAR in_a_car 
	jf break
	wait 0 ms
	gosub @CHECK_IN_VEHICLE_STATUS_LUIGI3
end //while

gosub @CHECK_WRONG_VEHICLE_LUIGI3

03E6: remove_text_box 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
039E: set_char_cant_be_dragged_out $PLAYER_ACTOR to 1 
0001: wait 500 ms 
02A3: toggle_widescreen 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0395: clear_area 1 at 936.1875 -263.875 range 5.0 1.0 

// Change camera angle if player in big vehicle

if or
	00DE:   is_player_in_model $PLAYER_CHAR model #BUS 
	00DE:   is_player_in_model $PLAYER_CHAR model #COACH 
	00DE:   is_player_in_model $PLAYER_CHAR model #FLATBED 
	00DE:   is_player_in_model $PLAYER_CHAR model #FIRETRUK 
	00DE:   is_player_in_model $PLAYER_CHAR model #LANDSTAL 
	00DE:   is_player_in_model $PLAYER_CHAR model #LINERUN
	00DE:   is_player_in_model $PLAYER_CHAR model #TRASH 
	00DE:   is_player_in_model $PLAYER_CHAR model #PONY 
then
	0004: $FLAG_CAMERA_MODE_LM3 = 1 
end
if or
	00DE:   is_player_in_model $PLAYER_CHAR model #MULE 
	00DE:   is_player_in_model $PLAYER_CHAR model #AMBULAN 
	00DE:   is_player_in_model $PLAYER_CHAR model #MRWHOOP 
	00DE:   is_player_in_model $PLAYER_CHAR model #RUMPO 
	00DE:   is_player_in_model $PLAYER_CHAR model #BELLYUP 
	00DE:   is_player_in_model $PLAYER_CHAR model #MRWONGS 
	00DE:   is_player_in_model $PLAYER_CHAR model #YANKEE 
	00DE:   is_player_in_model $PLAYER_CHAR model #SECURICA
then
	0004: $FLAG_CAMERA_MODE_LM3 = 1 
end

if
	0038:   $FLAG_CAMERA_MODE_LM3 == 1
then
	0395: clear_area 1 at 930.0625 -264.9375 range 7.3125 4.0 
	015F: set_camera_position 930.0625 -264.9375 7.3125 0.0 rotation 0.0 0.0 
	0160: point_camera 930.9375 -265.4375 7.125 switchstyle JUMP_CUT
else
	0395: clear_area 1 at 928.125 -267.5 range 4.0 4.0 
	015F: set_camera_position 928.125 -267.5 5.5625 0.0 rotation 0.0 0.0 
	0160: point_camera 929.125 -267.375 5.625 switchstyle JUMP_CUT
end

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0395: clear_area 1 at 941.6875 -269.1875 range 4.0 1.0 
0164: disable_marker $LUIGI3_MISTY_MARKER 
009A: $LUIGI3_MISTY = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 946.4375 -275.5 3.875
01BE: set_actor $LUIGI3_MISTY to_look_at_spot 942.0 -268.0 -100.0 
01ED: clear_actor $LUIGI3_MISTY threat_search 
0245: set_actor $LUIGI3_MISTY walk_style_to ANIM_SEXY_WOMANPED 

// opens the doors

0176: $DOOR1_POSITION_LM3 = object $MISTY_DOOR1 z_angle 

while 8042:   not  $DOOR1_POSITION_LM3 == 90.0 
	wait 0 ms
	gosub @CHECK_MISTY_STATUS
	0005: $DIFFERENCE_IN_HEADING_DOOR1_LM3 = 90.0 
	0061: $DIFFERENCE_IN_HEADING_DOOR1_LM3 -= $DOOR1_POSITION_LM3 
	if
		0022:   10.0 > $DIFFERENCE_IN_HEADING_DOOR1_LM3 
	then
		0005: $DOOR1_POSITION_LM3 = 90.0 
	else
		0009: $DOOR1_POSITION_LM3 += 10.0
	end
	0177: set_object $MISTY_DOOR1 z_angle_to $DOOR1_POSITION_LM3 
end //while


gosub @CHECK_MISTY_STATUS

0395: clear_area 1 at 944.0625 -270.6875 range 4.0 2.0 
0211: actor $LUIGI3_MISTY walk_to 944.0625 -270.6875 
0006: 17@ = 0

while 8126:   not actor $LUIGI3_MISTY walking
	wait 0 ms
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR 
	then
		00DA: $LUIGI3_PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
		gosub @CHECK_VEHICLE_STATUS_LUIGI3
	end
	gosub @CHECK_MISTY_STATUS
	if and
		0029:   17@ >= 10000 
		8126:   not actor $LUIGI3_MISTY walking
	then
		00A1: set_char_coordinates $LUIGI3_MISTY to 944.0625 -270.6875 3.875 
	end
end //while

0395: clear_area 1 at 941.0 -264.0 range -100.0 4.0 
015F: set_camera_position 934.1875 -265.75 5.875 0.0 rotation 0.0 0.0 
0160: point_camera 934.6875 -264.875 5.6875 switchstyle JUMP_CUT
0177: set_object $MISTY_DOOR1 z_angle_to 0.0 

if and
	8118:   not actor $LUIGI3_MISTY dead 
	8339:   not objects_in_cube 934.0625 -266.4375 2.0 to 935.0625 -268.875 10.0 flags 0 1 1 1 1
then
	0395: clear_area 1 at 934.75 -267.4375 range 3.875 1.0 
	00A1: set_char_coordinates $LUIGI3_MISTY to 934.75 -267.4375 3.875 
end

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	00DA: $LUIGI3_PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
	01D4: actor $LUIGI3_MISTY go_to_car $LUIGI3_PLAYER_CAR and_enter_it_as_a_passenger 
	gosub @CHECK_VEHICLE_STATUS_LUIGI3

	// waiting for Misty to get into the car 

	while 80DB:   not is_char_in_car $LUIGI3_MISTY car $LUIGI3_PLAYER_CAR
		wait 0 ms
		gosub @CHECK_MISTY_STATUS
		gosub @CHECK_VEHICLE_STATUS_LUIGI3
	end //while
else
	01D2: actor $LUIGI3_MISTY follow_player $PLAYER_CHAR
	while 8126:   not actor $LUIGI3_MISTY walking 
		wait 0 ms
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $LUIGI3_PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
			gosub @CHECK_VEHICLE_STATUS_LUIGI3
		end
		gosub @CHECK_MISTY_STATUS
	end //while
end

01DF: tie_actor $LUIGI3_MISTY to_player $PLAYER_CHAR 
02A3: toggle_widescreen 0 
015A: restore_camera 
039E: set_char_cant_be_dragged_out $PLAYER_ACTOR to 0 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03D1: play_wav 
00BC: print_now 'LM3_5' duration 7000 ms flag 1  // You working regular for Luigi now huh? It's about time he got a driver we can trust!


while 83D2: not wav_ended
	wait 0 ms
	gosub @CHECK_MISTY_STATUS
	gosub @CHECK_MISTY_RANGE_STATUS
	if
		0038:   $AMBUSH_TRIGGERED_LM3 == 0
	then
		gosub @CHECK_AMBUSH_TRIGGER_LUIGI3
	else
		if
			8119:   not car $AMBUSH_CAR_LM3 wrecked	
		then
			00AF: set_car_mission $AMBUSH_CAR_LM3 to MISSION_RAMPLAYER_FARAWAY 
		end
	end
end //while

03D5: remove_text 'LM3_5'  // You working regular for Luigi now huh? It's about time he got a driver we can trust!
00BC: print_now 'LM3_2' duration 5000 ms flag 1  // ~g~Take Misty to Joey's.
018A: $LUIGI3_JOEY_MARKER = create_checkpoint_at 1196.0 -874.0 -100.0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2
0004: $BLOB_FLAG = 1 

// ******************************************AMBUSH!*******************************************



while true
	if or
		80E6:   not player $PLAYER_CHAR stopped $BLOB_FLAG 1196.0 -874.0 radius 3.0 4.0 
		80EF:   not actor $LUIGI3_MISTY sphere 0 1196.0 -874.0 radius 3.0 4.0 
	jf break
	wait 0 ms
	gosub @CHECK_MISTY_STATUS
	gosub @CHECK_MISTY_RANGE_STATUS
	if
		0038:   $AMBUSH_TRIGGERED_LM3 == 0
	then
		gosub @CHECK_AMBUSH_TRIGGER_LUIGI3
	else
		if
			8119:   not car $AMBUSH_CAR_LM3 wrecked	
		then
			00AF: set_car_mission $AMBUSH_CAR_LM3 to MISSION_RAMPLAYER_FARAWAY 
		end
	end
end //while

0164: disable_marker $LUIGI3_JOEY_MARKER 
015F: set_camera_position 1211.813 -882.375 19.375 0.0 rotation 0.0 0.0 
0160: point_camera 1210.938 -881.875 19.3125 switchstyle JUMP_CUT

gosub @CHECK_MISTY_STATUS

01E0: clear_leader $LUIGI3_MISTY 
02A3: toggle_widescreen 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0110: clear_player $PLAYER_CHAR wanted_level 
0395: clear_area 1 at 1190.563 -869.0625 range -100.0 6.0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 

if
	00DF:   is_char_in_any_car $LUIGI3_MISTY
then
	00D9: $LUIGI3_PLAYER_CAR = store_car_char_is_in $LUIGI3_MISTY 
	01D3: actor $LUIGI3_MISTY leave_car $LUIGI3_PLAYER_CAR
	while 00DF:   is_char_in_any_car $LUIGI3_MISTY
		wait 0 ms
		gosub @CHECK_MISTY_STATUS
	end //while
end
0211: actor $LUIGI3_MISTY walk_to 1193.063 -868.25 

if
	00DF:   is_char_in_any_car $PLAYER_ACTOR
then
	00D9: $LUIGI3_PLAYER_CAR = store_car_char_is_in $PLAYER_ACTOR
	01D3: actor $PLAYER_ACTOR leave_car $LUIGI3_PLAYER_CAR
	while 00DF:   is_char_in_any_car $PLAYER_ACTOR
		wait 0 ms
		gosub @CHECK_MISTY_STATUS
	end //while
end
0211: actor $PLAYER_ACTOR walk_to 1193.063 -868.25 

0001: wait 500 ms 
gosub @CHECK_MISTY_STATUS
01C3: remove_references_to_car $LUIGI3_PLAYER_CAR

// ********************************START OF CUT-SCENE PART TWO******************************

01BD: $PRE_CUTSCENE_START_TIME = current_time_in_ms 
0004: $PRE_CUTSCENE_ELAPSED_TIME = 0 

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		001A:   5000 > $PRE_CUTSCENE_ELAPSED_TIME //	if player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
	gosub @CHECK_MISTY_STATUS
	01BD: $PRE_CUTSCENE_CURRENT_TIME = current_time_in_ms 
	0084: $PRE_CUTSCENE_ELAPSED_TIME = $PRE_CUTSCENE_CURRENT_TIME 
	0060: $PRE_CUTSCENE_ELAPSED_TIME -= $PRE_CUTSCENE_START_TIME 
end //while

03EF: player $PLAYER_CHAR make_safe 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
03AF: set_streaming 0 
023C: load_special_actor 'JOEY' as 1 
02F3: load_object #CUTOBJ01 'JOEDOOR' 
02F3: load_object #CUTOBJ02 'JOEYH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'MISTYH' 
0247: request_model #MAFIA 
0247: request_model #IDAHO 
0247: request_model #STALLION 
0247: request_model #JOGARAGEEXT 
0247: request_model #JOGARAGEINT

while fading
	wait 0 ms
end

009F: char_set_idle $PLAYER_ACTOR
if
	8118:   not actor $LUIGI3_MISTY dead 
then
	009F: char_set_idle $LUIGI3_MISTY 
end

038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #IDAHO available 
		8248:   not model #MAFIA available 
		8248:   not model #STALLION available 
	jf break
	wait 0 ms
end //while
while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ04 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #JOGARAGEEXT available 
		8248:   not model #JOGARAGEINT available
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'J0_DM2' 
0244: set_cutscene_pos 1190.063 -869.8125 13.9375 
00A5: $CUT_CAR_LM3 = create_car #MAFIA at 1189.063 -858.75 14.0
0175: set_car $CUT_CAR_LM3 z_angle_to 76.0 
00A5: $CUT_CAR2_LM3 = create_car #IDAHO at 1182.5 -857.0 14.0625
0175: set_car $CUT_CAR2_LM3 z_angle_to 291.1875 
00A5: $CUT_CAR3_LM3 = create_car #STALLION at 1192.875 -860.75 14.0
0175: set_car $CUT_CAR3_LM3 z_angle_to 150.0 
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
0395: clear_area 1 at 1194.0 -872.5 range 14.0 2.0 
0055: set_player_coordinates $PLAYER_CHAR to 1194.0 -872.5 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 230.0 
009B: delete_char $LUIGI3_MISTY 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime

// Displays cutscene text

while 001A:   10538 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_6' duration 10000 ms flag 1  // Joey...
while 001A:   11896 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LM3_6'  // Joey...
while 001A:   14353 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_6A' duration 10000 ms flag 1  // Am I goin' to play with your big end again?
while 001A:   16869 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_7' duration 10000 ms flag 1  // I'll be with you in a minute spark plug.
while 001A:   20173 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_8' duration 10000 ms flag 1  // Hey, I'm Joey.
while 001A:   21116 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_9' duration 10000 ms flag 1  // Luigi said you were reliable so come back later,
while 001A:   23397 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_9A' duration 10000 ms flag 1  // there might be some work for you.
while 001A:   25088 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM3_9B' duration 10000 ms flag 1  // Alright?
while 001A:   25723 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LM3_9B'  // Alright?
while 001A:   26666 > $CUT_SCENE_TIME
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
03AF: set_streaming 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR1 1 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR2 1 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #MAFIA 
0249: release_model #IDAHO 
0249: release_model #STALLION 
0249: release_model #JOGARAGEEXT 
0249: release_model #JOGARAGEINT 
00A6: delete_car $CUT_CAR_LM3 
00A6: delete_car $CUT_CAR2_LM3 
00A6: delete_car $CUT_CAR3_LM3

// **********************************END OF CUT-SCENE PART TWO***********************************

goto @MISSION_PASSED_LUIGI3

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_LUIGI3
if and
	80E0:   not is_player_in_any_car $PLAYER_CHAR 
	0038:   $FLAG_PLAYER_GOT_MESSAGE_LM3 == 0 
then
	00BC: print_now 'IN_VEH2' duration 5000 ms flag 1  // ~g~You need some wheels for this job!
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		0164: disable_marker $LUIGI3_MISTY_MARKER 
	end
	0004: $FLAG_PLAYER_GOT_MESSAGE_LM3 = 1 
	0004: $BLOB_FLAG = 0 
end
if and
	00E0:   is_player_in_any_car $PLAYER_CHAR 
	0038:   $FLAG_PLAYER_GOT_MESSAGE_LM3 == 1
then
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		018A: $LUIGI3_MISTY_MARKER = create_checkpoint_at 937.875 -259.75 -100.0 
	end
	00DA: $LUIGI3_PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
	0004: $FLAG_PLAYER_GOT_MESSAGE_LM3 = 0 
	0004: $BLOB_FLAG = 1 
end
return

/////////////////////////////////////////

:CHECK_MISTY_STATUS
if
	0118:   actor $LUIGI3_MISTY dead
then
	00BC: print_now 'MISTY1' duration 5000 ms flag 1  // ~r~Misty is morgue-meat!
	goto @MISSION_FAILED_LUIGI3
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_LUIGI3
if
	0119:   car $LUIGI3_PLAYER_CAR wrecked
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_LUIGI3
end
return

/////////////////////////////////////////

:CHECK_MISTY_RANGE_STATUS
if and
	8320:   not actor $LUIGI3_MISTY in_range_of_player $PLAYER_CHAR 
	0038:   $FLAG_BLIP_ON_MISTY_LM3 == 0 
then
	00BC: print_now 'HEY4' duration 5000 ms flag 1  // ~g~Lose Misty and Luigi will lose your face! Go and get her!
	0187: $RADAR_BLIP_PED1_LM3 = create_marker_above_actor $LUIGI3_MISTY 
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
	then
		0164: disable_marker $LUIGI3_JOEY_MARKER 
	end
	0004: $FLAG_BLIP_ON_MISTY_LM3 = 1 
	0004: $BLOB_FLAG = 0 
end
if and
	00E9:   player $PLAYER_CHAR 0 $LUIGI3_MISTY radius 8.0 8.0 
	0038:   $FLAG_BLIP_ON_MISTY_LM3 == 1 
then
	01DF: tie_actor $LUIGI3_MISTY to_player $PLAYER_CHAR 
	0164: disable_marker $RADAR_BLIP_PED1_LM3 
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
	then
		00BC: print_now 'LM3_2' duration 5000 ms flag 1  // ~g~Take Misty to Joey's.
		018A: $LUIGI3_JOEY_MARKER = create_checkpoint_at 1196.0 -874.0 -100.0 
	end
	0004: $FLAG_BLIP_ON_MISTY_LM3 = 0 
	0004: $BLOB_FLAG = 1
end
return

/////////////////////////////////////////

:CHECK_WRONG_VEHICLE_LUIGI3
if or
	00DE:   is_player_in_model $PLAYER_CHAR model #POLICE
	00DE:   is_player_in_model $PLAYER_CHAR model #FBICAR
	00DE:   is_player_in_model $PLAYER_CHAR model #ENFORCER
then
	00BC: print_now 'LM3_11' duration 5000 ms flag 1  // ~r~You're a cop now? Get outta here!
	goto @MISSION_FAILED_LUIGI3
end
return

////////////////////////////////////////

:CHECK_AMBUSH_TRIGGER_LUIGI3
0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z

if
	0020: $PLAYER_X > 965.0
then
	0004: $AMBUSH_LOCATION_FLAG_LM3 = 1
	gosub @AMBUSH_LM3
else
	if
		0022: 920.0 > $PLAYER_X
	then
		0004: $AMBUSH_LOCATION_FLAG_LM3 = 2
		gosub @AMBUSH_LM3
	else
		if
			0020: $PLAYER_Y > -185.0
		then
			00BC: print_now 'LM3EX1' duration 5000 ms flag 1  // ~r~Luigi wants a reliable driver. You went the wrong way!
			goto @MISSION_FAILED_LUIGI3
		end
	end
end
return


/////////////////////////////////////////

:AMBUSH_LM3

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 

if
	0038:   $AMBUSH_LOCATION_FLAG_LM3 == 1
then
	015F: set_camera_position 978.0 -259.0 13.0 rotation 0.0 0.0 0.0 
	0395: clear_area 1 at 1002.0 -294.0 range 10.0 10.0
	00A5: $AMBUSH_CAR_LM3 = create_car #RHINO at 1002.0 -294.0 5.0
else
	015F: set_camera_position 909.0 -257.0 13.0 rotation 0.0 0.0 0.0 
	0395: clear_area 1 at 914.0 -296.0 range 10.0 10.0
	00A5: $AMBUSH_CAR_LM3 = create_car #RHINO at 914.0 -296.0 -100.0 
end
wait 1000 ms
0158: camera_on_vehicle $AMBUSH_CAR_LM3 mode FIXED switchstyle JUMP_CUT

00BC: print_now 'LM3EX2' duration 2500 ms flag 1  // ~y~One of Misty's former lovers! 

wait 2500 ms

0129: $AMBUSH_PED_LM3 = create_actor PEDTYPE_CIVMALE #CRIMINAL01 in_car $AMBUSH_CAR_LM3 driverseat
011A: set_actor $AMBUSH_PED_LM3 search_threat THREAT_PLAYER1
00AF: set_car_mission $AMBUSH_CAR_LM3 to MISSION_RAMPLAYER_FARAWAY 
00AD: set_car_cruise_speed $AMBUSH_CAR_LM3 to 60.0 
00AE: set_car_driving_style $AMBUSH_CAR_LM3 to 3 
02AC: set_car $AMBUSH_CAR_LM3 immunities 1 1 1 1 1
020A: set_car $AMBUSH_CAR_LM3 door_status_to CARLOCK_LOCKED
02AA: set_car $AMBUSH_CAR_LM3 immune_to_nonplayer 1 
03AB: set_car $AMBUSH_CAR_LM3 strong 1 
0423: car $AMBUSH_CAR_LM3 improve_handling 2.0
01EC: make_car $AMBUSH_CAR_LM3 very_heavy 1

// Location 1 is easier to escape, so give the ambush a bigger headstart.
if
	0038:   $AMBUSH_LOCATION_FLAG_LM3 == 1
then
	wait 3500 ms
else
	wait 1500 ms
end

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 

02EB: restore_camera_jumpcut
0004: $AMBUSH_TRIGGERED_LM3 = 1
return


/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_LUIGI3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_LUIGI3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_LUIGI3
0004: $DRIVE_MISTY_FOR_ME_COMPLETED = 1 
0318: set_latest_mission_passed 'LM3'  // 'DRIVE MISTY FOR ME'
030C: set_mission_points += 1 
01E3: text_1number_styled 'M_PASS' number 1000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 1000 
0110: clear_player $PLAYER_CHAR wanted_level 
02A7: $JOEY_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_JOEY at 1191.688 -870.0 -100.0 
004F: create_thread @JOEY_MISSION1_LOOP
0164: disable_marker $LUIGI_MISSION_MARKER  
goto @MISSION_END_LUIGI3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_LUIGI3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LUIGI = 0 
034F: destroy_actor_with_fade $LUIGI3_MISTY 
0249: release_model #MAFIA 
0249: release_model #IDAHO 
0249: release_model #STALLION 
0164: disable_marker $LUIGI3_MISTY_MARKER 
0164: disable_marker $LUIGI3_JOEY_MARKER 
0164: disable_marker $RADAR_BLIP_PED1_LM3 
00D8: mission_has_finished 
return 
