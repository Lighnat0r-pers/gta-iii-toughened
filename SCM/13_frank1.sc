// *****************************************************************************************
// ********************************* Frankie Mission 1 *************************************
// *********************************   Pulp Friction   *************************************
// *****************************************************************************************
// *** Frankie wants to discuss war with his lieutenants. He needs Maria out of the house***
// *** for the evening so Claude has to chaperone her. Drive Maria to a dealer to get her***
// *** party gear. Then on to an illegal warehouse party and wait for her outside. While ***
// *** waiting for Maria the police will decide to 'raid the joint'. The player must get ***
// *** Maria out and back to Frankie's safely.						 ***
// *****************************************************************************************

// Mission start stuff

:M13_CHAPERONE

gosub @MISSION_START_FRANKIE1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_FRANKIE1
end

:MISSION_END_FRANKIE1
gosub @MISSION_CLEANUP_FRANKIE1
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_FRANKIE1
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_FRANK = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'FRANK1' 
0004: $CHICO_MESSAGE_FLAG = 0 
0004: $FLAG_BLIP_ON_LIMO = 0 
0004: $TIMERA_RESET = 0 
0004: $TIMERB_RESET = 0 
0004: $CLUBBERS_FLEE_FLAG = 0 
0004: $CLUBBER3_CAR1 = 0 
0004: $CLUBBER5_CAR2 = 0 
0004: $CLUBBER8_CAR3 = 0 
0004: $FLAG_BLIP_ON_MARIA = 0 
0004: $CREATE_MORE_SWAT = 0  
0004: $SWAT1_EXIT_CAR = 0 
0004: $SWAT2_EXIT_CAR = 0 
0004: $MARIA_BLIP = 0 
0004: $ADD_SOUND_FLAG = 0 
0004: $LOCATE_DOME_FLAG = 0 
0004: $CHICO_AUDIO_FLAG = 0 
0004: $SWAT_CAM_NEEDS_RESTORING = 0 
0004: $SKIP_CUTSCENE_FLAG = 0 
0004: $TIMERC_RESET = 0 
0004: $TIMERC_CURRENT = 0 
0004: $TIMERC_STARTED = 0 
0004: $TIMERC = 0 
0004: $TIMERD_RESET = 0 
0004: $TIMERD_CURRENT = 0 
0004: $TIMERD_STARTED = 0 
0004: $TIMERD = 0 
0004: $FUCKUP_FLAG = 0 
0004: $FUCKUP_TIMER_START = 0 
0004: $FUCKUP_TIMER_CURRENT = 0 
0004: $FUCKUP_TIMER = 0 
0004: $SHADOW_COUNTER = 0 
0005: $INSIDE_WAREHOUSE_X = 1273.0 
0005: $INSIDE_WAREHOUSE_Y = -1107.375 
0005: $INSIDE_WAREHOUSE_Z = 11.5 
0005: $OUTSIDE_WAREHOUSE_X = 1261.0 
0005: $OUTSIDE_WAREHOUSE_Y = -1108.0 
0005: $SWAT1_STUCK_X = 0.0 
0005: $SWAT1_STUCK_Y = 0.0 
0005: $SWAT1_STUCK_Z = 0.0 
0005: $SWAT2_STUCK_X = 0.0 
0005: $SWAT2_STUCK_Y = 0.0 
0005: $SWAT2_STUCK_Z = 0.0 
0004: $R = 0 
0004: $G = 0 
0004: $R1 = 0 
0004: $G1 = 0 
0004: $R2 = 0 
0004: $G2 = 0 
0004: $R3 = 0 
0004: $G3 = 0 
0004: $R4 = 0 
0004: $G4 = 0 
0004: $R5 = 0 
0004: $G5 = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0
0004: $SHOW_WRECKED_MESSAGE_FLAG_FRANKIE1 = 0
023C: load_special_actor 'FRANKIE' as 1 
023C: load_special_actor 'MARIA' as 2 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'FRANKH' 
02F3: load_object #CUTOBJ03 'MARIAH' 
0247: request_model #GANG02 
0247: request_model #SALVSDETAIL 
0247: request_model #SWANK_INSIDE 
0247: request_model #FRANKSCLB02 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #GANG02 available 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available
	jf break
	wait 0 ms
end //while

while true
	if or
		8248:   not model #SALVSDETAIL available 
		8248:   not model #SWANK_INSIDE available 
		8248:   not model #FRANKSCLB02 available
	jf break
	wait 0 ms
end //while

if
	0038:   $MARIA_EXISTS == 1 
then
	009B: delete_char $MARIA
end

0004: $MARIA_EXISTS = 0 
02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
0361: close_garage $SALVATORES_GARAGE 
03AD: set_rubbish 0 
0395: clear_area 1 at 1444.938 -186.875 range 56.0 35.0 
02E4: load_cutscene_data 'S1_PF' 
0244: set_cutscene_pos 1457.75 -185.3125 54.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_SALVATORE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_SALVATORE 'FRANKIE' 
02E5: $CUTSCENE_MARIA = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MARIA 'MARIA' 
02E5: $CUTSCENE_MAFIA = create_cutscene_object #GANG02 
02E6: set_cutscene_anim $CUTSCENE_MAFIA 'GANG02' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $SALVATORE_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_SALVATORE 
02F5: set_head_anim $SALVATORE_CSHEAD 'FRANK' 
02F4: create_cutscene_actor $MARIA_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_MARIA 
02F5: set_head_anim $MARIA_CSHEAD 'MARIA' 
0055: set_player_coordinates $PLAYER_CHAR to 1418.0 -186.0 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   219 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_A' duration 15000 ms flag 1  // ~w~Me an' the fellas need to talk business
while 001A:   1849 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_B' duration 15000 ms flag 1  // ~w~so you're gonna look after my girl for the evening.
while 001A:   4493 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_C' duration 15000 ms flag 1  // ~w~HEY MARIA! MOVE YOUR BUTT!
while 001A:   7519 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_D' duration 15000 ms flag 1  // ~w~Dumb broad does this every time.
while 001A:   10505 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_E' duration 15000 ms flag 1  // ~w~And here she is, the one and only Queen of Sheba!
while 001A:   14239 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_F' duration 15000 ms flag 1  // ~w~What were you doing up there?
while 001A:   15964 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_G' duration 15000 ms flag 1  // ~w~Whatever it was, I bet it cost me money.
while 001A:   18485 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_H' duration 15000 ms flag 1  // ~w~Well, you don't think I hang around for the conversation, do you?
while 001A:   21608 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_I' duration 15000 ms flag 1  // ~w~Get in that car and keep your big mouth shut.
while 001A:   24863 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_J' duration 15000 ms flag 1  // ~w~Take the limo but bring it back in one piece, y'hear me?
while 001A:   28287 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_K' duration 15000 ms flag 1  // ~w~And watch her, she can be trouble.
while 001A:   31451 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_L' duration 15000 ms flag 1  // ~w~Yeah, yeah, yeah! I'm sure your new lap dog has everything covered,
while 001A:   34679 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_M' duration 15000 ms flag 1  // ~w~and isn't he big and strong?
while 001A:   36802 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_N' duration 15000 ms flag 1  // ~w~Hey Fido, Let's go visit Chico and get some party treats!
while 001A:   39747 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM1_O' duration 15000 ms flag 1  // ~w~He's at the rail station at the Chinatown waterfront I think.
while 001A:   43500 > $CUT_SCENE_TIME
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

0055: set_player_coordinates $PLAYER_CHAR to 1418.0 -186.0 -100.0 
02EA: end_cutscene 
016A: fade 0 for 0 ms 
0296: unload_special_actor 1 
0249: release_model #GANG02 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #SALVSDETAIL 
0249: release_model #SWANK_INSIDE 
0249: release_model #FRANKSCLB02 
0247: request_model #STRETCH 
0247: request_model #CRIMINAL01 
0395: clear_area 1 at 1444.938 -186.875 range 56.0 35.0 
03AD: set_rubbish 1 
038B: load_all_models_now 

while true
	if or
		8248:   not model #STRETCH available 
		8248:   not model #CRIMINAL01 available 
	jf break
	wait 0 ms
end //while

// START MISSION

00A5: $MARIAS_STRETCH = create_car #STRETCH at 1436.0 -183.0 50.0
041E: set_radio_station RISE_FM -1 
0175: set_car $MARIAS_STRETCH z_angle_to 90.0 
0229: set_car $MARIAS_STRETCH color_to 0 0 // FRANKIES LIMO NEEDS A UNIQUE COLOUR
03AB: set_car $MARIAS_STRETCH strong 1 
0294: set_car $MARIAS_STRETCH resprayable_to 0 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
0004: $MARIA_EXISTS = 1 
01C8: $MARIA = create_actor PEDTYPE_SPECIAL model #SPECIAL02 in_car $MARIAS_STRETCH passenger_seat 1 
01ED: clear_actor $MARIA threat_search 
035F: set_actor $MARIA armour_to 100 
039E: set_char_cant_be_dragged_out $MARIA to 1 
0245: set_actor $MARIA walk_style_to ANIM_SEXY_WOMANPED
if
	80DB:   not is_char_in_car $MARIA car $MARIAS_STRETCH
then
	01D4: actor $MARIA go_to_car $MARIAS_STRETCH and_enter_it_as_a_passenger
end

009A: $CHICO_DRUGDEALER = create_char PEDTYPE_CIVMALE model #CRIMINAL01 at 770.1875 -565.9375 13.75
0173: set_actor $CHICO_DRUGDEALER z_angle_to 265.1875 
01ED: clear_actor $CHICO_DRUGDEALER threat_search 
009F: char_set_idle $CHICO_DRUGDEALER 
0350: set_actor $CHICO_DRUGDEALER maintain_position_when_attacked 1 
022B: switch_ped_roads_off 759.0 -616.0 11.0 to 782.0 -536.0 26.0 
0209: $CAMERA_MODE = random_int_in_ranges 0 4

if
	0038:   $CAMERA_MODE == 0
then
	015F: set_camera_position 1405.688 -190.125 62.4375 0.0 rotation 0.0 0.0 
	0160: point_camera 1427.25 -183.5 49.4375 switchstyle JUMP_CUT
end
if
	0038:   $CAMERA_MODE == 1
then
	015F: set_camera_position 1425.625 -178.4375 50.125 0.0 rotation 0.0 0.0 
	0158: camera_on_vehicle $MARIAS_STRETCH mode FIXED switchstyle JUMP_CUT
end
if
	0038:   $CAMERA_MODE == 2
then
	015F: set_camera_position 1432.125 -179.6875 50.625 0.0 rotation 0.0 0.0 
	0158: camera_on_vehicle $MARIAS_STRETCH mode FIXED switchstyle JUMP_CUT
end
if
	0038:   $CAMERA_MODE == 3
then
	015F: set_camera_position 1421.125 -193.75 63.875 0.0 rotation 0.0 0.0 
	0158: camera_on_vehicle $MARIAS_STRETCH mode FIXED switchstyle JUMP_CUT
end

0369: put_player $PLAYER_CHAR in_car $MARIAS_STRETCH 
016A: fade 0 for 0 ms 
00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
018A: $FM1_BLIP = create_checkpoint_at 775.5 -557.25 14.0 
0247: request_model #GANG01 
0247: request_model #SENTINEL 
0247: request_model #CHEETAH 
0247: request_model #MANANA 
038B: load_all_models_now

while true
	if or
		8248:   not model #GANG01 available 
		8248:   not model #SENTINEL available 
		8248:   not model #CHEETAH available 
		8248:   not model #MANANA available
	jf break
	wait 0 ms
end //while

03AF: set_streaming 1 

gosub @CHECK_MARIA_STATUS_FRANKIE1
gosub @CHECK_VEHICLE_STATUS_FRANKIE1

if
	80DB:   not is_char_in_car $MARIA car $MARIAS_STRETCH
then
	01D4: actor $MARIA go_to_car $MARIAS_STRETCH and_enter_it_as_a_passenger
end

016A: fade 1 for 1500 ms

while fading
	wait 0 ms
end

gosub @CHECK_MARIA_STATUS_FRANKIE1
gosub @CHECK_VEHICLE_STATUS_FRANKIE1

if
	80DB:   not is_char_in_car $MARIA car $MARIAS_STRETCH
then
	01D4: actor $MARIA go_to_car $MARIAS_STRETCH and_enter_it_as_a_passenger
end

02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
0360: open_garage $SALVATORES_GARAGE 
02C2: car $MARIAS_STRETCH drive_to_point 1416.063 -189.4375 49.5

while 81AD:   not car $MARIAS_STRETCH sphere 0 near_point 1420.5 -189.0625 radius 3.0 3.0
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
end //while

0361: close_garage $SALVATORES_GARAGE 
0221: set_player $PLAYER_CHAR apply_brakes_to_car 1

gosub @CHECK_MARIA_STATUS_FRANKIE1

03C8: set_camera_directly_before_player 
02EB: restore_camera_jumpcut 
01B4: set_player $PLAYER_CHAR controllable 1 
03A2: set_car_status $MARIAS_STRETCH to 0 
02A3: toggle_widescreen 0 
0004: $LOCATE_DOME_FLAG = 1 
0247: request_model #ENFORCER 
0247: request_model #SWAT 
0247: request_model #P_MAN1 
0247: request_model #FEMALE01 
0247: request_model #FEMALE02

while 8103:   not actor $MARIA stopped_near_point_in_car 775.5 -557.25 14.0 radius 3.0 3.0 2.0 sphere $LOCATE_DOME_FLAG
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_CHICO_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1

	00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
	if and
		00E5:   player $PLAYER_CHAR 0 $CHICO_X $CHICO_Y radius 30.0 30.0 
		0038:   $CHICO_MESSAGE_FLAG == 0
	then
		00BC: print_now 'FM1_P' duration 5000 ms flag 1  // ~g~That's Chico over there, pull up next to him.
		0004: $CHICO_MESSAGE_FLAG = 1 
	end
	if and
		0038:   $CHICO_MESSAGE_FLAG == 1 
		80E5:   not player $PLAYER_CHAR 0 $CHICO_X $CHICO_Y radius 30.0 30.0
	then
		00BC: print_now 'FM1_6' duration 5000 ms flag 1  // ~g~Chico won't be there forever, get Maria to the waterfront!
		0004: $CHICO_MESSAGE_FLAG = 0
	end
end //while

01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
02A3: toggle_widescreen 1 
03F4: set_all_cars_can_be_damaged 0 
015F: set_camera_position 770.75 -569.9375 14.3125 0.0 rotation 0.0 0.0 
0160: point_camera 770.6875 -568.9375 14.375 switchstyle JUMP_CUT
0164: disable_marker $FM1_BLIP 
0361: close_garage $SALVATORES_GARAGE 
01D3: actor $MARIA leave_car $MARIAS_STRETCH
0004: $SHOW_WRECKED_MESSAGE_FLAG_FRANKIE1 = 1
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1

while 00DF:   is_char_in_any_car $MARIA
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_CHICO_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
	if
		80E9:   not player $PLAYER_CHAR 0 $MARIA radius 20.0 20.0
	then
		00BC: print_now 'FM1_3' duration 5000 ms flag 1  // ~r~Leave Maria and Salvatore will have you whacked, go back and pick her up.
	end
end //while

01D1: actor $MARIA follow_actor $CHICO_DRUGDEALER 
00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 

while 80F0:   not actor $MARIA stopped #NULL $CHICO_X $CHICO_Y radius 3.0 3.0
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_CHICO_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z
	gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
	if
		80E9:   not player $PLAYER_CHAR 0 $MARIA radius 20.0 20.0
	then
		00BC: print_now 'FM1_3' duration 5000 ms flag 1  // ~r~Leave Maria and Salvatore will have you whacked, go back and pick her up.
	end
end //while

03EB: clear_small_messages_only

while 8038:   not  $CHICO_AUDIO_FLAG == 15
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	gosub @CHECK_CHICO_STATUS_FRANKIE1
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 0
		80E1:   not is_button_pressed PAD1 button CROSS
	then
		0004: $SKIP_CUTSCENE_FLAG = 1
	end
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 1
		00E1:   is_button_pressed PAD1 button CROSS
	then
		0004: $SKIP_CUTSCENE_FLAG = 2
	end
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 2
		80E1:   not is_button_pressed PAD1 button CROSS
	then
		040D: clear_mission_audio 
		03CF: load_wav 'S1_F' 
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_FALSE wait_state_time 100 ms 
		0372: set_actor $MARIA anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 15 
		0004: $SKIP_CUTSCENE_FLAG = 3
	end
	if 
		0038:   $CHICO_AUDIO_FLAG == 0
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_A' 
		0004: $CHICO_AUDIO_FLAG = 1
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 1
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_Q' duration 6000 ms flag 2  // ~w~Hey Maria! It's my favorite lady!
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_PLAYANIM_CHAT wait_state_time 10000 ms 
		0004: $CHICO_AUDIO_FLAG = 2
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 2
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_A1' 
		0004: $CHICO_AUDIO_FLAG = 3
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 3
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_Q1' duration 6000 ms flag 2  // ~w~You looking for some fun? A little...hmm? Some SPANK?
		0004: $CHICO_AUDIO_FLAG = 4
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 4
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_B' 
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 5
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 5
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $MARIA store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_R' duration 6000 ms flag 2  // ~w~Hi Chico. Nah, just the usual.
		0372: set_actor $MARIA anim WAITSTATE_PLAYANIM_CHAT wait_state_time 10000 ms 
		0004: $CHICO_AUDIO_FLAG = 6
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 6
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_C' 
		0372: set_actor $MARIA anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 7
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 7
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_PLAYANIM_CHAT wait_state_time 10000 ms 
		03D1: play_wav 
		00BC: print_now 'FM1_S' duration 5000 ms flag 2  // ~w~Here you go lady.
		0004: $CHICO_AUDIO_FLAG = 8
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 8
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_C1' 
		0004: $CHICO_AUDIO_FLAG = 9 
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 9
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_S1' duration 15000 ms flag 2  // ~w~Hey, maybe you should check out the warehouse party at the east end of Atlantic Quays.
		0004: $CHICO_AUDIO_FLAG = 10 
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 10
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_D' 
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 11 
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 11
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $MARIA store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_T' duration 4000 ms flag 2  // ~w~Thanks Chico. See you around.
		0372: set_actor $MARIA anim WAITSTATE_PLAYANIM_CHAT wait_state_time 10000 ms 
		0004: $CHICO_AUDIO_FLAG = 12
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 12
		03D2:   wav_ended
	then
		020E: actor $CHICO_DRUGDEALER look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $CHICO_DRUGDEALER 
		03CF: load_wav 'S1_E' 
		0372: set_actor $MARIA anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 13
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 13
		03D0:   wav_loaded
	then
		00A0: get_char_coordinates $CHICO_DRUGDEALER store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_U' duration 2000 ms flag 1  // ~w~Gracias and enjoy. That's good stuff.
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_PLAYANIM_CHAT wait_state_time 10000 ms 
		0004: $CHICO_AUDIO_FLAG = 14
	end
	if 
		0038:   $CHICO_AUDIO_FLAG == 14
	then
		03CF: load_wav 'S1_F' 
		0372: set_actor $CHICO_DRUGDEALER anim WAITSTATE_FALSE wait_state_time 100 ms 
		0004: $CHICO_AUDIO_FLAG = 15
	end
end //while

:MARIA_GETTING_INTO_CAR

gosub @CHECK_MARIA_STATUS_FRANKIE1
gosub @CHECK_VEHICLE_STATUS_FRANKIE1

03EB: clear_small_messages_only 
01D4: actor $MARIA go_to_car $MARIAS_STRETCH and_enter_it_as_a_passenger 
0319: set_actor $MARIA running 1 
01C2: remove_references_to_actor $CHICO_DRUGDEALER 
022A: switch_ped_roads_on 759.0 -616.0 11.0 to 782.0 -536.0 26.0

while 80DB:   not is_char_in_car $MARIA car $MARIAS_STRETCH
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
end //while

if
	0038:   $ONMISSION == 0
then
	0186: $FM1_BLIP = create_marker_above_car $MARIAS_STRETCH 
	0187: $MARIA_BLIP = create_marker_above_actor $MARIA
end

01B4: set_player $PLAYER_CHAR controllable 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
02A3: toggle_widescreen 0 
03F4: set_all_cars_can_be_damaged 1 
0319: set_actor $MARIA running 0 
02EB: restore_camera_jumpcut 
03C8: set_camera_directly_before_player

while 83D0:   not wav_loaded
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
end //while

03D1: play_wav 
00BC: print_now 'FM1_V' duration 5000 ms flag 1  // ~w~C'mon Fido, let's go and check out this party!
0164: disable_marker $FM1_BLIP 
0164: disable_marker $MARIA_BLIP 
018A: $FM1_BLIP = create_checkpoint_at 1256.563 -1099.25 -11.6875 
009A: $FRANK1_MAFIA1 = create_char PEDTYPE_GANG_MAFIA model #GANG01 at 1267.688 -1109.188 11.0
0173: set_actor $FRANK1_MAFIA1 z_angle_to 90.0 
011A: set_actor $FRANK1_MAFIA1 search_threat THREAT_GANG_HOOD 
0243: set_actor $FRANK1_MAFIA1 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_MAFIA1 weapon WEAPONTYPE_PISTOL ammo 99 
0192: set_actor $FRANK1_MAFIA1 objective_to_stand_still 
0291: set_actor $FRANK1_MAFIA1 attack_when_provoked 1 
009A: $FRANK1_MAFIA2 = create_char PEDTYPE_GANG_MAFIA model #GANG01 at 1267.688 -1105.563 11.0
0173: set_actor $FRANK1_MAFIA2 z_angle_to 90.0 
011A: set_actor $FRANK1_MAFIA2 search_threat THREAT_GANG_HOOD 
0243: set_actor $FRANK1_MAFIA2 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_MAFIA2 weapon WEAPONTYPE_PISTOL ammo 99 
0192: set_actor $FRANK1_MAFIA2 objective_to_stand_still 
0291: set_actor $FRANK1_MAFIA2 attack_when_provoked 1 
00A5: $FRANK1_PARTY_CAR1  create_car #SENTINEL at 1243.0 -1112.0 11.0
00A5: $FRANK1_PARTY_CAR2  create_car #CHEETAH at 1247.0 -1112.0 11.0
00A5: $FRANK1_PARTY_CAR3  create_car #MANANA at 1251.0 -1112.0 11.0

/////////////CLUB STUFF////

016F: draw_shadow SHADOW_EXPLOSION at 1270.813 -1107.688 11.0625 rotation 0.0 scale 1.0 transparency 0 colour 255 0 0  
0250: create_light_at 1273.188 -1107.25 11.0625 RGB_values 255 0 0 
018D: $FRANK1_PARTY_SOUND = create_sound SOUND_RAVE_LOOP_INDUSTRIAL_L at 1269.688 -1100.375 14.0 
02A2: create_particle POBJECT_DRY_ICE_SLOWMOTION 0 at 1273.0 -1107.188 10.6875 
02A2: create_particle POBJECT_DRY_ICE_SLOWMOTION 0 at 1273.0 -1107.188 10.6875 
02A2: create_particle POBJECT_DRY_ICE_SLOWMOTION 0 at 1273.063 -1107.063 10.6875 
02A2: create_particle POBJECT_DRY_ICE_SLOWMOTION 0 at 1273.188 -1107.0 10.6875 
02A2: create_particle POBJECT_WALL_STEAM_SLOWMOTION 0 at 1270.0 -1107.313 10.75 
02A2: create_particle POBJECT_PAVEMENT_STEAM_SLOWMOTION 0 at 1271.5 -1107.5 10.5625 
0004: $ADD_SOUND_FLAG = 1 
0004: $LOCATE_DOME_FLAG = 1 
0004: $CHICO_MESSAGE_FLAG = 0 
0004: $FLAG_BLIP_ON_LIMO = 0
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2

///////////////////////////

while 80F1:   not actor $MARIA stopped $LOCATE_DOME_FLAG 1259.0 -1107.75 radius 3.0 3.0 
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_MESSAGE_FLAG == 0
		00EC:   actor $MARIA 0 1258.0 -1100.0 radius 50.0 50.0 
	then
		00BC: print_now 'FM1_9' duration 5000 ms flag 1  // ~g~Thats the party up ahead, drop Maria off out front.
		0004: $CHICO_MESSAGE_FLAG = 1
	end
	gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_AUDIO_FLAG == 15
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_G' 
		0004: $CHICO_AUDIO_FLAG = 16
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 16 
		03D0:   wav_loaded
	then
		0004: $CHICO_AUDIO_FLAG = 17
	end
end //while

if
	8038:   not  $CHICO_AUDIO_FLAG == 17
then
	wait 0 ms
	while 83D0:   not wav_loaded
		wait 0 ms
		gosub @CHECK_MARIA_STATUS_FRANKIE1
		gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	end //while
	0004: $CHICO_AUDIO_FLAG = 17
end

00A0: get_char_coordinates $MARIA store_to $CHICO_X $CHICO_Y $CHICO_Z 
03D1: play_wav 
01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0 
00BC: print_now 'FM1_W' duration 5000 ms flag 1  // ~w~Alright Fido, you wait here and look after the car while I go and shake my butt alright.
0001: wait 0 ms

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
end //while

01B4: set_player $PLAYER_CHAR controllable 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03F4: set_all_cars_can_be_damaged 1 
01D3: actor $MARIA leave_car $MARIAS_STRETCH 

while 00DB:   is_char_in_car $MARIA car $MARIAS_STRETCH 
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_AUDIO_FLAG == 17
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_H' 
		0004: $CHICO_AUDIO_FLAG = 18
	end
end //while

0211: actor $MARIA walk_to 1266.813 -1107.625 
0006: 16@ = 0

while 80ED:   not actor $MARIA 0 1266.813 -1107.625 radius 1.0 1.0
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	if
		0019:   16@ > 20000
	then
		0395: clear_area 0 at 1267.625 -1107.563 range 11.375 3.0 
	end
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_AUDIO_FLAG == 17
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_H' 
		0004: $CHICO_AUDIO_FLAG = 18
	end
end //while

0211: actor $MARIA walk_to $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y 

while 80ED:   not actor $MARIA #NULL $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 1.0 1.0 
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	if
		0019:   16@ > 20000
	then
		0395: clear_area 0 at 1267.625 -1107.563 range 11.375 4.0 
	end
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_AUDIO_FLAG == 17
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_H' 
		0004: $CHICO_AUDIO_FLAG = 18
	end
end //while

0004: $MARIA_EXISTS = 0 
009B: delete_char $MARIA 

:WAIT_FOR_MARIA ////////////////////////////////////////////////////////////////////////

wait 0 ms
gosub @DRAW_DISCO_LIGHTS
gosub @CHECK_VEHICLE_STATUS_FRANKIE1

0006: 16@ = 0

while 00E3:   player $PLAYER_CHAR 0 1262.063 -1099.375 radius 22.0 22.0 
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	if
		0019:   16@ > 10000
	then
		goto @CLUB_BUSTED
	end
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if and
		0038:   $CHICO_AUDIO_FLAG == 17
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_H' 
		0004: $CHICO_AUDIO_FLAG = 18
	end
end //while

00BC: print_now 'FM1_4' duration 500 ms flag 2  // ~g~You've dumped the Don's woman! Get back to the warehouse and wait for Maria!

goto @WAIT_FOR_MARIA

:CLUB_BUSTED//////////////////////////////////////////////////////////////////////////

while true
	if or
		8248:   not model #ENFORCER available 
		8248:   not model #SWAT available 
		8248:   not model #P_MAN1 available 
		8248:   not model #FEMALE01 available 
		8248:   not model #FEMALE02 available
	jf break
	wait 0 ms
end //while

:SWAT_CAR_ONE

00A5: $FRANK1_ENFORCER1 = create_car #ENFORCER at 1293.0 -925.0 -100.0
0175: set_car $FRANK1_ENFORCER1 z_angle_to 225.0 
00AD: set_car_cruise_speed $FRANK1_ENFORCER1 to 40.0 
00AE: set_car_driving_style $FRANK1_ENFORCER1 to DRIVINGMODE_AVOIDCARS
0397: car $FRANK1_ENFORCER1 siren = 1 
020A: set_car $FRANK1_ENFORCER1 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
0129: $FRANK1_SWAT1 = create_actor PEDTYPE_GANG_HOOD #SWAT in_car $FRANK1_ENFORCER1 driverseat
011A: set_actor $FRANK1_SWAT1 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT1 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT1 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT2 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER1 passenger_seat 0
011A: set_actor $FRANK1_SWAT2 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT2 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT2 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT3 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER1 passenger_seat 1
011A: set_actor $FRANK1_SWAT3 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT3 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT3 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT4 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER1 passenger_seat 2
011A: set_actor $FRANK1_SWAT4 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT4 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT4 weapon WEAPONTYPE_PISTOL ammo 99 
00A7: car_goto_coordinates $FRANK1_ENFORCER1 coords 1252.0 -1086.0 -100.0 

if
	0038:   $CREATE_MORE_SWAT == 1
then
	0004: $CREATE_MORE_SWAT = 0
	return
end

:SWAT_CAR_TWO

00A5: $FRANK1_ENFORCER2 = create_car #ENFORCER at 1084.0 -1012.0 -100.0
0175: set_car $FRANK1_ENFORCER2 z_angle_to 180.0 
00AD: set_car_cruise_speed $FRANK1_ENFORCER2 to 40.0 
00AE: set_car_driving_style $FRANK1_ENFORCER2 to DRIVINGMODE_AVOIDCARS
0397: car $FRANK1_ENFORCER2 siren = 1 
020A: set_car $FRANK1_ENFORCER2 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
0129: $FRANK1_SWAT5 = create_actor PEDTYPE_GANG_HOOD #SWAT in_car $FRANK1_ENFORCER2 driverseat
011A: set_actor $FRANK1_SWAT5 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT5 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT5 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT6 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER2 passenger_seat 0
011A: set_actor $FRANK1_SWAT6 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT6 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT6 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT7 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER2 passenger_seat 1
011A: set_actor $FRANK1_SWAT7 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT7 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT7 weapon WEAPONTYPE_PISTOL ammo 99 
01C8: $FRANK1_SWAT8 = create_actor PEDTYPE_GANG_HOOD model #SWAT in_car $FRANK1_ENFORCER2 passenger_seat 2
011A: set_actor $FRANK1_SWAT8 search_threat THREAT_GANG_MAFIA 
0243: set_actor $FRANK1_SWAT8 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FRANK1_SWAT8 weapon WEAPONTYPE_PISTOL ammo 99 
00A7: car_goto_coordinates $FRANK1_ENFORCER2 coords 1235.0 -1099.0 -100.0 
01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
02A3: toggle_widescreen 1 
03F4: set_all_cars_can_be_damaged 0 
015F: set_camera_position 1309.875 -1061.313 15.6875 0.0 rotation 0.0 0.0 
0158: camera_on_vehicle $FRANK1_ENFORCER1 mode FIXED switchstyle JUMP_CUT
03EA: generate_cars_around_camera 1 
0004: $SWAT_CAM_NEEDS_RESTORING = 1

if
	0038:   $CREATE_MORE_SWAT == 1
then
	0004: $CREATE_MORE_SWAT = 0
	return
end

if
	8038:   not  $CHICO_AUDIO_FLAG == 18 
then
	while 83D2:   not wav_ended
		wait 100 ms
		gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	end //while
	03CF: load_wav 'S1_H' 
	0004: $CHICO_AUDIO_FLAG = 18
end

if
	0038:   $CHICO_AUDIO_FLAG == 18 
then
	while 83D0:   not wav_loaded
		wait 0 ms
		gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	end //while
	0004: $CHICO_AUDIO_FLAG = 19
end

03D1: play_wav 
00BC: print_now 'FM1_SS' duration 4000 ms flag 2  // ~r~SCANNER: ~g~Four-five to all units: Assist narcotics raid Atlantic Quays...

while true
	if or
		0038:   $SWAT1_EXIT_CAR == 0 
		0038:   $SWAT2_EXIT_CAR == 0
	jf break
	wait 0 ms
	if
		0038:   $FUCKUP_FLAG = 0
	then
		01BD: $FUCKUP_TIMER_START = current_time_in_ms 
		0004: $FUCKUP_FLAG = 1 
	end
	if
		0038:   $FUCKUP_FLAG = 1
	then
		01BD: $FUCKUP_TIMER_CURRENT = current_time_in_ms 
		0084: $FUCKUP_TIMER = $FUCKUP_TIMER_CURRENT 
		0060: $FUCKUP_TIMER -= $FUCKUP_TIMER_START 
		if
			0018:   $FUCKUP_TIMER > 180000 
		then
			0004: $SWAT1_EXIT_CAR = 1 
			0004: $SWAT2_EXIT_CAR = 1
			if
				0038:   $SWAT_CAM_NEEDS_RESTORING == 1 
			then
				0373: set_camera_directly_behind_player 
				02EB: restore_camera_jumpcut 
				01B4: set_player $PLAYER_CHAR controllable 1 
				03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
				02A3: toggle_widescreen 0 
				03F4: set_all_cars_can_be_damaged 1 
				03EA: generate_cars_around_camera 0 
				0004: $SWAT_CAM_NEEDS_RESTORING = 0
			end
			0004: $FUCKUP_FLAG = 2
		end
	end
	gosub @DRAW_DISCO_LIGHTS
	if and
		0038:   $CHICO_AUDIO_FLAG == 19
		03D2:   wav_ended
	then
		03CF: load_wav 'S1_I' 
		0004: $CHICO_AUDIO_FLAG = 20
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 20
		03D0:   wav_loaded
	then
		0004: $CHICO_AUDIO_FLAG = 21
	end

	gosub @CHECK_VEHICLE_STATUS_FRANKIE1

	// Check van 1
	0084: $FRANK1_ENFORCER_TEMP = $FRANK1_ENFORCER1
	0084: $FRANK1_SWAT_TEMP1 = $FRANK1_SWAT1
	0084: $FRANK1_SWAT_TEMP2 = $FRANK1_SWAT2
	0084: $FRANK1_SWAT_TEMP3 = $FRANK1_SWAT3
	0084: $FRANK1_SWAT_TEMP4 = $FRANK1_SWAT4
	0004: $CURRENT_SWAT_CHECK_FLAG = 1
	gosub @CHECK_ENFORCER_REKT_FRANKIE1

	0084: $TIMER_TEMP1_RESET = $TIMERA_RESET
	0084: $TIMER_TEMP1_STARTED = $TIMERA_STARTED
	0084: $TIMER_TEMP2_RESET = $TIMERC_RESET
	0084: $TIMER_TEMP2_STARTED = $TIMERC_STARTED
	0084: $SWAT_TEMP_STUCK_X = $SWAT1_STUCK_X
	0084: $SWAT_TEMP_STUCK_Y = $SWAT1_STUCK_Y
	0084: $SWAT_TEMP_STUCK_Z = $SWAT1_STUCK_Z
	gosub @CHECK_ENFORCER_STUCK_FRANKIE1
	0084: $TIMERA_RESET = $TIMER_TEMP1_RESET
	0084: $TIMERA_STARTED = $TIMER_TEMP1_STARTED
	0084: $TIMERC_RESET = $TIMER_TEMP2_RESET
	0084: $TIMERC_STARTED = $TIMER_TEMP2_STARTED
	0084: $SWAT1_STUCK_X = $SWAT_TEMP_STUCK_X
	0084: $SWAT1_STUCK_Y = $SWAT_TEMP_STUCK_Y
	0084: $SWAT1_STUCK_Z = $SWAT_TEMP_STUCK_Z

	// Check van 2
	0084: $FRANK1_ENFORCER_TEMP = $FRANK1_ENFORCER2
	0084: $FRANK1_SWAT_TEMP1 = $FRANK1_SWAT5
	0084: $FRANK1_SWAT_TEMP2 = $FRANK1_SWAT6
	0084: $FRANK1_SWAT_TEMP3 = $FRANK1_SWAT7
	0084: $FRANK1_SWAT_TEMP4 = $FRANK1_SWAT8
	0004: $CURRENT_SWAT_CHECK_FLAG = 2
	gosub @CHECK_ENFORCER_REKT_FRANKIE1

	0084: $TIMER_TEMP1_RESET = $TIMERB_RESET
	0084: $TIMER_TEMP1_STARTED = $TIMERB_STARTED
	0084: $TIMER_TEMP2_RESET = $TIMERD_RESET
	0084: $TIMER_TEMP2_STARTED = $TIMERD_STARTED
	0084: $SWAT_TEMP_STUCK_X = $SWAT2_STUCK_X
	0084: $SWAT_TEMP_STUCK_Y = $SWAT2_STUCK_Y
	0084: $SWAT_TEMP_STUCK_Z = $SWAT2_STUCK_Z
	gosub @CHECK_ENFORCER_STUCK_FRANKIE1
	0084: $TIMERB_RESET = $TIMER_TEMP1_RESET
	0084: $TIMERB_STARTED = $TIMER_TEMP1_STARTED
	0084: $TIMERD_RESET = $TIMER_TEMP2_RESET
	0084: $TIMERD_STARTED = $TIMER_TEMP2_STARTED
	0084: $SWAT2_STUCK_X = $SWAT_TEMP_STUCK_X
	0084: $SWAT2_STUCK_Y = $SWAT_TEMP_STUCK_Y
	0084: $SWAT2_STUCK_Z = $SWAT_TEMP_STUCK_Z

	0005: $ENFORCER_GET_OUT_RANGE_FRANKIE1 = 8.0
	gosub @CHECK_ENFORCERS_STOPPED_TO_GET_OUT_FRANKIE1

end //while

gosub @CHECK_SWAT_CAM_RESTORE_FRANKIE1

while 001A:   9 > $CLUBBERS_FLEE_FLAG
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	if
		0038:   $CHICO_AUDIO_FLAG == 22
	then
		03CF: load_wav 'S1_J' 
		0004: $CHICO_AUDIO_FLAG = 23
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 23
		03D0:   wav_loaded
	then
		0004: $CHICO_AUDIO_FLAG = 24
	end
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1

	if
		0038:   $CLUBBERS_FLEE_FLAG == 0
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 1
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #P_MAN1
		gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
		0084: $FRANK1_PARTY_PERSON1 = $FRANK1_PARTY_PERSON_TEMP
		0004: $CLUBBERS_FLEE_FLAG = 1
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 1
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 2
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #FEMALE01
		if
			0118:   actor $FRANK1_PARTY_PERSON1 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON1 
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON2 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 2
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON1 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON2 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 2
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 2
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 2
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #CRIMINAL01
		if
			0118:   actor $FRANK1_PARTY_PERSON2 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON2 
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON3 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 3 
			0004: $CLUBBER3_CAR1 = 1
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON2 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON3 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 3 
				0004: $CLUBBER3_CAR1 = 1
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 3
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 1
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #FEMALE02
		if
			0118:   actor $FRANK1_PARTY_PERSON3 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON3
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON4 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 4 
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON3 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON4 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 4
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 4
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 2
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #GANG01
		if
			0118:   actor $FRANK1_PARTY_PERSON4 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON4 
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON5 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 5
			0004: $CLUBBER3_CAR2 = 1
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON4 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON5 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 5 
				0004: $CLUBBER3_CAR2 = 1
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 5
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 2
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #CRIMINAL01
		if
			0118:   actor $FRANK1_PARTY_PERSON5 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON5
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON6 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 6 
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON5 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON6 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 6
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 6
	then
		0004: $FRANK1_PARTY_PERSON_WEAPON_FLAG = 2
		0004: $FRANK1_PARTY_PERSON_MODEL_FLAG = #FEMALE01
		if
			0118:   actor $FRANK1_PARTY_PERSON6 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON6
			gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
			0084: $FRANK1_PARTY_PERSON7 = $FRANK1_PARTY_PERSON_TEMP
			0004: $CLUBBERS_FLEE_FLAG = 7 
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON6 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
				0084: $FRANK1_PARTY_PERSON7 = $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBERS_FLEE_FLAG = 7
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 7
	then
		if
			0118:   actor $FRANK1_PARTY_PERSON7 dead 
		then
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON7
			gosub @CREATE_MARIA_AFTER_PARTY_FRANKIE1
		else
			if
				80EC:   not actor $FRANK1_PARTY_PERSON7 0 $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y radius 2.0 2.0
			then
				gosub @CREATE_MARIA_AFTER_PARTY_FRANKIE1
			end
		end
	end
	if
		0038:   $CLUBBERS_FLEE_FLAG == 8
	then
		if
			0118:   actor $MARIA dead
		then
			goto @MISSION_FAILED_FRANKIE1
		else
			01D2: actor $MARIA follow_player $PLAYER_CHAR
			if or
				00EC:   actor $MARIA 0 1259.2 -1105.4 radius 0.5 0.5 
				0019:   17@ > 10000 // To prevent softlock in case the position is blocked. 
			then
				01D2: actor $MARIA follow_player $PLAYER_CHAR 
				if
					00E9:   player $PLAYER_CHAR 0 $MARIA radius 4.0 4.0 
				then
					01DF: tie_actor $MARIA to_player $PLAYER_CHAR 
					0164: disable_marker $FM1_BLIP 
					0004: $CLUBBERS_FLEE_FLAG = 10
				end
			end
		end
	end

	if or
		8038:   not  $CLUBBER3_CAR1 == 3 
		8038:   not  $CLUBBER5_CAR2 == 3 
		8038:   not  $CLUBBER8_CAR3 == 3 
	then
		gosub @CLUBBERS_INTO_CARS
	end

	gosub @POLICE_IDLE_CHECKS
	gosub @CLUBBERS_IDLE_CHECKS

	if
		0038:   $FUCKUP_FLAG == 2
	then
		0004: $SWAT1_EXIT_CAR = 0 
		0004: $SWAT2_EXIT_CAR = 0 
		0004: $FUCKUP_FLAG = 3
	end
	0005: $ENFORCER_GET_OUT_RANGE_FRANKIE1 = 18.0
	gosub @CHECK_ENFORCERS_STOPPED_TO_GET_OUT_FRANKIE1
end //while

01C3: remove_references_to_car $FRANK1_ENFORCER1 
01C3: remove_references_to_car $FRANK1_ENFORCER2 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 3

while 80DF:   not is_char_in_any_car $MARIA
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	if
		0038:   $CHICO_AUDIO_FLAG == 22
	then
		03CF: load_wav 'S1_J' 
		0004: $CHICO_AUDIO_FLAG = 23
	end
	if and
		0038:   $CHICO_AUDIO_FLAG == 23
		03D0:   wav_loaded
	then
		0004: $CHICO_AUDIO_FLAG = 24
	end
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	gosub @CHECK_MARIA_IN_RANGE_FRANKIE1
	if
		0038:   $FLAG_BLIP_ON_MARIA == 0
	then
		gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
	end
	if or
		8038:   not  $CLUBBER3_CAR1 == 3 
		8038:   not  $CLUBBER5_CAR2 == 3 
		8038:   not  $CLUBBER8_CAR3 == 3 
	then
		gosub @CLUBBERS_INTO_CARS
	end

	gosub @POLICE_IDLE_CHECKS
	gosub @CLUBBERS_IDLE_CHECKS
end //while

0164: disable_marker $FM1_BLIP 
0004: $FLAG_BLIP_ON_MARIA = 0 
0004: $FLAG_BLIP_ON_LIMO = 0 
018A: $FM1_BLIP = create_checkpoint_at 1424.0 -183.5 50.0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 4
wait 0 ms

if
	8038:   not  $CHICO_AUDIO_FLAG == 24
then
	while 83D0:   not wav_loaded 
		wait 0 ms
		gosub @DRAW_DISCO_LIGHTS
		if or
			8038:   not  $CLUBBER3_CAR1 == 3 
			8038:   not  $CLUBBER5_CAR2 == 3 
			8038:   not  $CLUBBER8_CAR3 == 3 
		then
			gosub @CLUBBERS_INTO_CARS
		end
		gosub @POLICE_IDLE_CHECKS
		gosub @CLUBBERS_IDLE_CHECKS
		gosub @CHECK_MARIA_STATUS_FRANKIE1
		gosub @CHECK_VEHICLE_STATUS_FRANKIE1
		gosub @CHECK_MARIA_IN_RANGE_FRANKIE1
		if
			0038:   $FLAG_BLIP_ON_MARIA == 0
		then
			gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
		end
		gosub @POLICE_IDLE_CHECKS
		gosub @CLUBBERS_IDLE_CHECKS
	end //while
	0004: $CHICO_AUDIO_FLAG = 24
end

03D1: play_wav 
00BC: print_now 'FM1_X' duration 5000 ms flag 1  // ~w~OK Fido, let's get out of here. Wooooh!
02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_MISSION_KEEPCAR_REMAINCLOSED
if
	8119:   not car $MARIAS_STRETCH wrecked
then
	021B: set_garage $SALVATORES_GARAGE to_accept_car $MARIAS_STRETCH 
end

while 821C:   not car_inside_garage $SALVATORES_GARAGE
	wait 0 ms
	gosub @DRAW_DISCO_LIGHTS
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	gosub @CHECK_VEHICLE_STATUS_FRANKIE1
	if
		01AD:   car $MARIAS_STRETCH sphere 0 near_point 1424.75 -183.0 radius 20.0 20.0
	then
		0110: clear_player $PLAYER_CHAR wanted_level
	end
	gosub @CHECK_MARIA_IN_RANGE_FRANKIE1
	if
		0038:   $FLAG_BLIP_ON_MARIA == 0
	then
		gosub @CHECK_IN_VEHICLE_STATUS_FRANKIE1
	end
	if or
		8038:   not  $CLUBBER3_CAR1 == 3 
		8038:   not  $CLUBBER5_CAR2 == 3 
		8038:   not  $CLUBBER8_CAR3 == 3 
	then
		gosub @CLUBBERS_INTO_CARS
	end

	gosub @POLICE_IDLE_CHECKS
	gosub @CLUBBERS_IDLE_CHECKS
end //while

0110: clear_player $PLAYER_CHAR wanted_level 
016A: fade 0 for 500 ms 
0001: wait 500 ms 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0

gosub @CHECK_MARIA_STATUS_FRANKIE1

01E0: clear_leader $MARIA 
0110: clear_player $PLAYER_CHAR wanted_level 
012A: put_player $PLAYER_CHAR at 1435.75 -176.375 52.25 and_remove_from_car 
0171: set_player $PLAYER_CHAR z_angle_to 184.9375 
0004: $MARIA_EXISTS = 0 
009B: delete_char $MARIA 
009A: $MARIA = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 1435.875 -178.375 54.0
0004: $MARIA_EXISTS = 1 
0173: set_actor $MARIA z_angle_to 184.875 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
01ED: clear_actor $MARIA threat_search 
01ED: clear_actor $PLAYER_ACTOR threat_search 
015F: set_camera_position 1433.438 -173.5625 55.625 0.0 rotation 0.0 0.0 
0159: camera_on_ped $MARIA mode FIXED switchstyle JUMP_CUT
0211: actor $MARIA walk_to 1436.25 -180.625 
0211: actor $PLAYER_ACTOR walk_to 1436.25 -180.625 
00A6: delete_car $MARIAS_STRETCH 
0395: clear_area 0 at 1423.938 -189.1875 range 49.1875 5.0 
016A: fade 1 for 500 ms 
03CF: load_wav 'S1_K' 
0004: $FLAG_BLIP_ON_MARIA = 0 
0004: $SKIP_CUTSCENE_FLAG = 0

while 8038:   not  $FLAG_BLIP_ON_MARIA == 8
	wait 0 ms
	gosub @CHECK_MARIA_STATUS_FRANKIE1
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 0
		80E1:   not is_button_pressed PAD1 button CROSS
	then
		0004: $SKIP_CUTSCENE_FLAG = 1
	end
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 1
		00E1:   is_button_pressed PAD1 button CROSS
	then
		0004: $SKIP_CUTSCENE_FLAG = 2
	end
	if and
		0038:   $SKIP_CUTSCENE_FLAG == 2
		80E1:   not is_button_pressed PAD1 button CROSS
	then
		016A: fade 0 for 0 ms 
		0001: wait 0 ms 
		040D: clear_mission_audio 
		03EB: clear_small_messages_only 
		02A3: toggle_widescreen 0 
		01B4: set_player $PLAYER_CHAR controllable 1 
		03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
		03F4: set_all_cars_can_be_damaged 1 
		009B: delete_char $MARIA 
		0055: set_player_coordinates $PLAYER_CHAR to 1443.563 -188.25 55.0 
		0171: set_player $PLAYER_CHAR z_angle_to 180.0 
		0373: set_camera_directly_behind_player 
		02EB: restore_camera_jumpcut 
		016A: fade 1 for 500 ms 
		0004: $SKIP_CUTSCENE_FLAG = 3
		goto @MISSION_PASSED_FRANKIE1
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 0
		00ED:   actor $MARIA #NULL 1436.25 -180.625 radius 1.0 1.0 
	then
		0211: actor $MARIA walk_to 1440.5 -179.125 
		0004: $FLAG_BLIP_ON_MARIA = 1
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 1
		00E4:   player $PLAYER_CHAR 0 1436.25 -180.625 radius 1.0 1.0 
	then
		0211: actor $PLAYER_ACTOR walk_to 1440.625 -181.375 
		0004: $FLAG_BLIP_ON_MARIA = 2
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 2
		00F0:   actor $MARIA stopped #NULL 1440.5 -179.125 radius 1.0 1.0 
	then
		0172: $SWAT1_STUCK_X = actor $MARIA z_angle 
		000D: $SWAT1_STUCK_X -= 3.0 
		if
			0022:   0.0 > $SWAT1_STUCK_X
		then
			0005: $SWAT1_STUCK_X = 359.0 
		end
		if
			0022:   180.0 > $SWAT1_STUCK_X
		then
			0005: $SWAT1_STUCK_X = 180.0
		end
		0173: set_actor $MARIA z_angle_to $SWAT1_STUCK_X 
		022D: set_actor $MARIA to_look_at_player $PLAYER_CHAR
		if
			00E7:   player $PLAYER_CHAR stopped 0 1440.625 -181.375 radius 1.0 1.0
		then
			022F: set_actor $MARIA stop_looking 
			015F: set_camera_position 1442.063 -173.125 55.8125 0.0 rotation 0.0 0.0 
			0160: point_camera 1441.75 -174.0 55.6875 switchstyle JUMP_CUT
			0171: set_player $PLAYER_CHAR z_angle_to 0.0 
			020E: actor $PLAYER_ACTOR look_at_actor $MARIA 
			0210: player $PLAYER_CHAR look_at_actor $MARIA 
			020E: actor $MARIA look_at_actor $PLAYER_ACTOR 
			0004: $FLAG_BLIP_ON_MARIA = 3
		end
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 3
		03D0:   wav_loaded 
	then
		020E: actor $PLAYER_ACTOR look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $PLAYER_ACTOR 
		00A0: get_char_coordinates $MARIA store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_Y' duration 8000 ms flag 1  // ~w~You know I enjoyed myself for the first time in a long while, and you treated me really good. With respect and everything.
		0372: set_actor $MARIA anim WAITSTATE_PLAYANIM_CHAT wait_state_time 20000 ms 
		0004: $FLAG_BLIP_ON_MARIA = 4
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 4
		03D2:   wav_ended 
	then
		020E: actor $PLAYER_ACTOR look_at_actor $MARIA 
		020E: actor $MARIA look_at_actor $PLAYER_ACTOR 
		03CF: load_wav 'S1_L' 
		0004: $FLAG_BLIP_ON_MARIA = 5
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 5
		03D0:   wav_loaded 
	then
		00A0: get_char_coordinates $MARIA store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D1: play_wav 
		00BC: print_now 'FM1_AA' duration 8000 ms flag 1  // ~w~Oh, I'd better go. I'll see you around I hope.
		0004: $FLAG_BLIP_ON_MARIA = 6 
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 6
		03D2:   wav_ended 
	then
		03EB: clear_small_messages_only 
		0372: set_actor $MARIA anim WAITSTATE_FALSE wait_state_time 100 ms 
		0211: actor $PLAYER_ACTOR walk_to 1443.563 -188.25 
		0211: actor $MARIA walk_to 1453.5 -179.3125 
		0004: $FLAG_BLIP_ON_MARIA = 7
	end
	if and
		0038:   $FLAG_BLIP_ON_MARIA == 7 
		00E3:   player $PLAYER_CHAR 0 1443.563 -188.25 radius 1.0 1.0 
		82CB:   not is_actor_on_screen $MARIA 
	then
		0004: $MARIA_EXISTS = 0 
		009B: delete_char $MARIA 
		0004: $FLAG_BLIP_ON_MARIA = 8
	end
end //while

0373: set_camera_directly_behind_player 
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03F4: set_all_cars_can_be_damaged 1

goto @MISSION_PASSED_FRANKIE1


/////////////////////////////////////////

:CHECK_MARIA_IN_RANGE_FRANKIE1
if and
	8320:   not actor $MARIA in_range_of_player $PLAYER_CHAR 
	0038:   $FLAG_BLIP_ON_MARIA == 0
then
	00BC: print_now 'FM1_10' duration 5000 ms flag 1  // ~g~You have left Maria behind, go back and pick her up.
	0164: disable_marker $FM1_BLIP 
	0187: $FM1_BLIP = create_marker_above_actor $MARIA 
	0004: $FLAG_BLIP_ON_MARIA = 1
end
if and
	00E9:   player $PLAYER_CHAR 0 $MARIA radius 8.0 8.0 
	0038:   $FLAG_BLIP_ON_MARIA == 1
then
	01DF: tie_actor $MARIA to_player $PLAYER_CHAR 
	0164: disable_marker $FM1_BLIP 
	018A: $FM1_BLIP = create_checkpoint_at 1424.0 -183.5 50.0 
	0004: $FLAG_BLIP_ON_MARIA = 0
end
return

/////////////////////////////////////////

:CHECK_ENFORCERS_STOPPED_TO_GET_OUT_FRANKIE1
if and
	01AD:   car $FRANK1_ENFORCER1 sphere 0 near_point 1252.0 -1086.0 radius $ENFORCER_GET_OUT_RANGE_FRANKIE1 $ENFORCER_GET_OUT_RANGE_FRANKIE1
	0038:   $SWAT1_EXIT_CAR == 0
then
	0084: $FRANK1_ENFORCER_TEMP = $FRANK1_ENFORCER1
	gosub @CHECK_SWAT_ARRIVAL_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT1
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT2
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT3
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT4
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	if and
		8118:   not actor $FRANK1_MAFIA2 dead 
		8118:   not actor $FRANK1_SWAT1 dead
	then
		01C9: actor $FRANK1_MAFIA2 kill_actor $FRANK1_SWAT1
	end
	0004: $SWAT1_EXIT_CAR = 1 
end
if and
	01AD:   car $FRANK1_ENFORCER2 sphere 0 near_point 1235.0 -1099.0 radius $ENFORCER_GET_OUT_RANGE_FRANKIE1 $ENFORCER_GET_OUT_RANGE_FRANKIE1 
	0038:   $SWAT2_EXIT_CAR == 0 
then
	0084: $FRANK1_ENFORCER_TEMP = $FRANK1_ENFORCER2
	gosub @CHECK_SWAT_ARRIVAL_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT5
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT6
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT7
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT8
	gosub @SET_SWAT_HOSTILITY_FRANKIE1
	if and
		8118:   not actor $FRANK1_MAFIA1 dead 
		8118:   not actor $FRANK1_SWAT5 dead
	then
		01C9: actor $FRANK1_MAFIA1 kill_actor $FRANK1_SWAT5
	end
	0004: $SWAT2_EXIT_CAR = 1 
end
return

/////////////////////////////////////////

:CREATE_MARIA_AFTER_PARTY_FRANKIE1
gosub @CHECK_SWAT_CAM_RESTORE_FRANKIE1
0004: $MARIA_EXISTS = 1 
009A: $MARIA = create_char PEDTYPE_SPECIAL model #SPECIAL02 at $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y $INSIDE_WAREHOUSE_Z
0245: set_actor $MARIA walk_style_to ANIM_SEXY_WOMANPED
035F: set_actor $MARIA armour_to 100 
01ED: clear_actor $MARIA threat_search 
0164: disable_marker $FM1_BLIP 
0187: $FM1_BLIP = create_marker_above_actor $MARIA 
00BC: print_now 'FM1_5' duration 4000 ms flag 2  // ~g~Get Maria safely back to Salvatore's!
010E: set_player $PLAYER_CHAR minimum_wanted_level_to 3
0319: set_actor $MARIA running 1 
0054: get_player_coordinates $PLAYER_CHAR store_to $CHICO_X $CHICO_Y $CHICO_Z 
0239: actor $MARIA run_to 1259.2 -1105.4 
0239: actor $MARIA run_to $CHICO_X $CHICO_Y 
0004: $CLUBBERS_FLEE_FLAG = 9 
return

/////////////////////////////////////////

:CHECK_CREATE_NEXT_PARTY_PERSON_FRANKIE1
009A: $FRANK1_PARTY_PERSON_TEMP = create_char PEDTYPE_GANG_MAFIA model $FRANK1_PARTY_PERSON_MODEL_FLAG at $INSIDE_WAREHOUSE_X $INSIDE_WAREHOUSE_Y $INSIDE_WAREHOUSE_Z
011A: set_actor $FRANK1_PARTY_PERSON_TEMP search_threat THREAT_GANG_HOOD 
0243: set_actor $FRANK1_PARTY_PERSON_TEMP ped_stats_to PEDSTAT_TOUGH_GUY 
if
	0038:   $FRANK1_PARTY_PERSON_WEAPON_FLAG == 1
then
	01B2: give_actor $FRANK1_PARTY_PERSON_TEMP weapon WEAPONTYPE_UZI ammo 99 
else
	01B2: give_actor $FRANK1_PARTY_PERSON_TEMP weapon WEAPONTYPE_PISTOL ammo 50 
end
0319: set_actor $FRANK1_PARTY_PERSON_TEMP running 1 
0239: actor $FRANK1_PARTY_PERSON_TEMP run_to $OUTSIDE_WAREHOUSE_X $OUTSIDE_WAREHOUSE_Y 
return

/////////////////////////////////////////

:CHECK_ENFORCER_REKT_FRANKIE1
if
	8119:   not   car $FRANK1_ENFORCER_TEMP wrecked 
then
	if or
		81F4:   not   car $FRANK1_ENFORCER_TEMP flipped 
		81C1:   not   car $FRANK1_ENFORCER_TEMP stopped
	then
		if
			82BF:   not   car $FRANK1_ENFORCER_TEMP sunk 
		then
			return
		end
	end
end
01C3: remove_references_to_car $FRANK1_ENFORCER_TEMP 
01C2: remove_references_to_actor $FRANK1_SWAT_TEMP1 
01C2: remove_references_to_actor $FRANK1_SWAT_TEMP2 
01C2: remove_references_to_actor $FRANK1_SWAT_TEMP3 
01C2: remove_references_to_actor $FRANK1_SWAT_TEMP4 
0004: $CREATE_MORE_SWAT = 1
if
	0038: $CURRENT_SWAT_CHECK_FLAG == 1
then
	gosub @SWAT_CAR_ONE
else
	gosub @SWAT_CAR_TWO
end
return

/////////////////////////////////////////

:CHECK_ENFORCER_STUCK_FRANKIE1
if and
	0038:   $TIMER_TEMP1_RESET == 1
	81C1:   not car $FRANK1_ENFORCER_TEMP stopped
then
	0004: $TIMER_TEMP1_RESET = 0
end
if
	01C1:   car $FRANK1_ENFORCER_TEMP stopped 
then
	if
		0038:   $TIMER_TEMP1_RESET == 0
	then
		01BD: $TIMER_TEMP1_STARTED = current_time_in_ms  
		0004: $TIMER_TEMP1_RESET = 1
	end
	if
		0038:   $TIMER_TEMP1_RESET == 1
	then	
		01BD: $TIMER_TEMP1_CURRENT = current_time_in_ms 
		0084: $TIMER_TEMP1 = $TIMER_TEMP1_CURRENT 
		0060: $TIMER_TEMP1 -= $TIMER_TEMP1_STARTED
		if
			0018:   $TIMER_TEMP1 > 5000  
		then
			01C3: remove_references_to_car $FRANK1_ENFORCER_TEMP 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP1 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP2 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP3 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP4 
			0004: $CREATE_MORE_SWAT = 1
			if
				0038: $CURRENT_SWAT_CHECK_FLAG == 1
			then
				gosub @SWAT_CAR_ONE
			else
				gosub @SWAT_CAR_TWO
			end
		end
	end
end
if
	01AF:   car $FRANK1_ENFORCER_TEMP 0 $SWAT_TEMP_STUCK_X $SWAT_TEMP_STUCK_Y $SWAT_TEMP_STUCK_Z radius 2.0 2.0 2.0 
then
	if
		0038:   $TIMER_TEMP2_RESET == 0 
	then
		01BD: $TIMER_TEMP2_STARTED = current_time_in_ms 
		0004: $TIMER_TEMP2_RESET = 1
	end
	if
		0038:   $TIMER_TEMP2_RESET == 1
	then
		01BD: $TIMER_TEMP2_CURRENT = current_time_in_ms 
		0084: $TIMER_TEMP2 = $TIMER_TEMP2_CURRENT 
		0060: $TIMER_TEMP2 -= $TIMER_TEMP2_STARTED
		if
			0018:   $TIMER_TEMP2 > 8000 
		then
			01C3: remove_references_to_car $FRANK1_ENFORCER_TEMP 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP1 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP2 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP3 
			01C2: remove_references_to_actor $FRANK1_SWAT_TEMP4 
			0004: $CREATE_MORE_SWAT = 1
			if
				0038: $CURRENT_SWAT_CHECK_FLAG == 1
			then
				gosub @SWAT_CAR_ONE
			else
				gosub @SWAT_CAR_TWO
			end
		end
	end
end
if
	81AF:   not car $FRANK1_ENFORCER_TEMP 0 $SWAT_TEMP_STUCK_X $SWAT_TEMP_STUCK_Y $SWAT_TEMP_STUCK_Z radius 2.0 2.0 2.0
then
	00AA: get_car_coordinates $FRANK1_ENFORCER_TEMP store_to $SWAT_TEMP_STUCK_X $SWAT_TEMP_STUCK_Y $SWAT_TEMP_STUCK_Z 
	0004: $TIMER_TEMP2_RESET = 0
end
return



/////////////////////////////////////////

:CHECK_SWAT_ARRIVAL_FRANKIE1
gosub @CHECK_SWAT_CAM_RESTORE_FRANKIE1
if
	0038:   $CHICO_AUDIO_FLAG == 21
then
	if
		8118:   not actor $FRANK1_MAFIA1 dead
	then
		00A0: get_char_coordinates $FRANK1_MAFIA1 store_to $CHICO_X $CHICO_Y $CHICO_Z 
		03D7: set_wav_location $CHICO_X $CHICO_Y $CHICO_Z
	else
		01C2: remove_references_to_actor $FRANK1_MAFIA1 
		if
			8118:   not actor $FRANK1_MAFIA2 dead
		then
			00A0: get_char_coordinates $FRANK1_MAFIA2 store_to $CHICO_X $CHICO_Y $CHICO_Z 
			03D7: set_wav_location $CHICO_X $CHICO_Y $CHICO_Z
		else
			01C2: remove_references_to_actor $FRANK1_MAFIA2 
		end
	end
	03D1: play_wav 
	00BC: print_now 'FM1_TT' duration 5000 ms flag 1  // ~w~IT'S A POLICE RAID!
	0004: $CHICO_AUDIO_FLAG = 22 
end

00AD: set_car_cruise_speed $FRANK1_ENFORCER_TEMP to 0.0
return

/////////////////////////////////////////

:CHECK_SWAT_CAM_RESTORE_FRANKIE1
if
	0038:   $SWAT_CAM_NEEDS_RESTORING == 1 
then
	0373: set_camera_directly_behind_player 
	02EB: restore_camera_jumpcut 
	01B4: set_player $PLAYER_CHAR controllable 1 
	03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
	02A3: toggle_widescreen 0 
	03F4: set_all_cars_can_be_damaged 1 
	03EA: generate_cars_around_camera 0 
	0004: $SWAT_CAM_NEEDS_RESTORING = 0 
end
return

/////////////////////////////////////////

:SET_SWAT_HOSTILITY_FRANKIE1
if
	8118:   not actor $FRANK1_SWAT_TEMP dead
then
	01D3: actor $FRANK1_SWAT_TEMP leave_car $FRANK1_ENFORCER_TEMP 
	0291: set_actor $FRANK1_SWAT_TEMP attack_when_provoked 1
else
	01C2: remove_references_to_actor $FRANK1_SWAT_TEMP 
end

return

/////////////////////////////////////////

:CHECK_MARIA_STATUS_FRANKIE1
if
	0118:   actor $MARIA dead
then
	00BC: print_now 'FM1_7' duration 5000 ms flag 1  // ~r~Maria's dead! Salvatore won't be too pleased...
	goto @MISSION_FAILED_FRANKIE1
end
return

/////////////////////////////////////////

:CHECK_CHICO_STATUS_FRANKIE1
if
	0118:   actor $CHICO_DRUGDEALER dead
then
	if
		0038: $SHOW_WRECKED_MESSAGE_FLAG_FRANKIE1 == 1
	then
		00BC: print_now 'FM1_8' duration 5000 ms flag 1  // ~r~You wasted Maria's supplier!
	end
	goto @MISSION_FAILED_FRANKIE1
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_FRANKIE1
if
	0119:   car $MARIAS_STRETCH wrecked
then
	goto @MISSION_FAILED_FRANKIE1
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_FRANKIE1
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $MARIAS_STRETCH 
	0038:   $FLAG_BLIP_ON_LIMO == 0
then
	if or
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 0
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
	then
		0004: $LOCATE_DOME_FLAG = 0 
		0164: disable_marker $FM1_BLIP 
	else
		if or
			0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 3
			0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 4
		then
			0164: disable_marker $FM1_BLIP
		end
	end
	0186: $FM1_BLIP = create_marker_above_car $MARIAS_STRETCH 
	00BC: print_now 'FM1_1' duration 5000 ms flag 1  // ~g~Get back into the Stretch!
	0004: $FLAG_BLIP_ON_LIMO = 1
end
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $MARIAS_STRETCH 
	0038:   $FLAG_BLIP_ON_LIMO == 1
then
	0164: disable_marker $FM1_BLIP 
	0004: $FLAG_BLIP_ON_LIMO = 0
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 0
	then
		0004: $LOCATE_DOME_FLAG = 1 
		0187: $FM1_BLIP = create_marker_above_actor $CHICO_DRUGDEALER 
	else
		if
			0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 2
		then
			0004: $LOCATE_DOME_FLAG = 1 
			018A: $FM1_BLIP = create_checkpoint_at 1262.063 -1099.375 -100.0
		else
			if
				0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 3
			then
				0187: $FM1_BLIP = create_marker_above_actor $MARIA
			else
				if
					0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 4
				then
					018A: $FM1_BLIP = create_checkpoint_at 1424.0 -183.5 50.0
				end
			end
		end
	end
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_FRANKIE1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_FRANKIE1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_FRANKIE1
0004: $CHAPERONE_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 10000 
0110: clear_player $PLAYER_CHAR wanted_level 
0394: play_mission_passed_music 1 
0318: set_latest_mission_passed 'FM1'  // 'CHAPERONE'
030C: set_mission_points += 1 
02A7: $TONI_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_TONY at 1219.563 -321.0 26.375 
004F: create_thread @TONI_MISSION4_LOOP 
004F: create_thread @FRANKIE_MISSION2_LOOP 
goto @MISSION_END_FRANKIE1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_FRANKIE1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_FRANK = 0 
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1
if
	0038:   $ADD_SOUND_FLAG == 1 
then
	018E: stop_sound $FRANK1_PARTY_SOUND
end
03AE: remove_objects_from_cube 1264.0 -1111.0 5.0 to 1275.0 -1103.0 15.0 
0249: release_model #CRIMINAL01 
0249: release_model #STRETCH 
0249: release_model #GANG01 
0249: release_model #SENTINEL 
0249: release_model #CHEETAH 
0249: release_model #MANANA 
0249: release_model #ENFORCER 
0249: release_model #SWAT 
0249: release_model #P_MAN1 
0249: release_model #FEMALE01 
0249: release_model #FEMALE02 
0164: disable_marker $FM1_BLIP 
02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_MISSION_KEEPCAR 
021B: set_garage $SALVATORES_GARAGE to_accept_car -1 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
00D8: mission_has_finished
return

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// Functions ///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

:CLUBBERS_INTO_CARS
if
	0018:   $CLUBBERS_FLEE_FLAG > 2 
then
	0084: $CLUBBER_CAR_TEMP = $CLUBBER3_CAR1
	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON3
	0084: $FRANK1_PARTY_CAR_TEMP = $FRANK1_PARTY_CAR1
	0084: $CLUBBER_CAR_TEMP = $CLUBBER3_CAR1
	gosub @CLUBBERS_INTO_CARS_STUFF
	0084: $CLUBBER3_CAR1 = $CLUBBER_CAR_TEMP
end

if
	0018:   $CLUBBERS_FLEE_FLAG > 4 
then
	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON5
	0084: $FRANK1_PARTY_CAR_TEMP = $FRANK1_PARTY_CAR2
	0084: $CLUBBER_CAR_TEMP = $CLUBBER5_CAR2
	gosub @CLUBBERS_INTO_CARS_STUFF
	0084: $CLUBBER5_CAR2 = $CLUBBER_CAR_TEMP
end

if
	0018:   $CLUBBERS_FLEE_FLAG > 7 
then
	0084: $CLUBBER_CAR_TEMP = $CLUBBER3_CAR1
	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON7
	0084: $FRANK1_PARTY_CAR_TEMP = $FRANK1_PARTY_CAR3
	0084: $CLUBBER_CAR_TEMP = $CLUBBER8_CAR3
	gosub @CLUBBERS_INTO_CARS_STUFF
	0084: $CLUBBER8_CAR3 = $CLUBBER_CAR_TEMP
end
return

:CLUBBERS_INTO_CARS_STUFF
if
	0038:   $CLUBBER_CAR_TEMP == 1 
then
	if
		8118:   not actor $FRANK1_PARTY_PERSON_TEMP dead 
	then
		if
			00ED:   actor $FRANK1_PARTY_PERSON_TEMP #NULL $OUTSIDE_WAREHOUSE_X $OUTSIDE_WAREHOUSE_Y radius 3.0 3.0 
		then
			if
				00AC:   is_car_still_alive $FRANK1_PARTY_CAR_TEMP 
			then
				if
					01AD:   car $FRANK1_PARTY_CAR_TEMP sphere 0 near_point 1243.0 -1112.0 radius 8.0 8.0
				then
					01D5: actor $FRANK1_PARTY_PERSON_TEMP go_to_and_drive_car $FRANK1_PARTY_CAR_TEMP 
					0004: $CLUBBER_CAR_TEMP = 2
				else
					0291: set_actor $FRANK1_PARTY_PERSON_TEMP attack_when_provoked 1 
					01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
					01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP 
					0004: $CLUBBER_CAR_TEMP = 3
				end
			else
				0291: set_actor $FRANK1_PARTY_PERSON_TEMP attack_when_provoked 1 
				01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
				01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP 
				0004: $CLUBBER_CAR_TEMP = 3
			end
		end
	else
		01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP 
		01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
		0004: $CLUBBER_CAR_TEMP = 3
	end
end
if
	0038:   $CLUBBER_CAR_TEMP == 2 
then
	if
		8118:   not actor $FRANK1_PARTY_PERSON_TEMP dead 
	then
		if
			8119:   not car $CLUBBER_CAR_TEMP wrecked
		then
			if
				00DB:   is_char_in_car $FRANK1_PARTY_PERSON_TEMP car $FRANK1_PARTY_CAR_TEMP
			then
				00AE: set_car_driving_style $FRANK1_PARTY_CAR_TEMP to DRIVINGMODE_AVOIDCARS
				00AD: set_car_cruise_speed $FRANK1_PARTY_CAR_TEMP to 100.0 
				00A8: car_wander_randomly $FRANK1_PARTY_CAR_TEMP 
				0428: set_car $FRANK1_PARTY_CAR_TEMP avoid_level_transitions 1 
				01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
				0004: $CLUBBER_CAR_TEMP = 3
			end
		else
			0291: set_actor $FRANK1_PARTY_PERSON_TEMP attack_when_provoked 1 
			01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP 
			01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
			0004: $CLUBBER_CAR_TEMP = 3
		end
	else
		01C3: remove_references_to_car $FRANK1_PARTY_CAR_TEMP 
		01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP 
		0004: $CLUBBER_CAR_TEMP = 3
	end
end
return

:CLUBBERS_IDLE_CHECKS
if and
	0118:   actor $FRANK1_SWAT1 dead 
	0118:   actor $FRANK1_SWAT2 dead 
	0118:   actor $FRANK1_SWAT3 dead 
	0118:   actor $FRANK1_SWAT4 dead 
	0118:   actor $FRANK1_SWAT5 dead 
	0118:   actor $FRANK1_SWAT6 dead
	0118:   actor $FRANK1_SWAT7 dead 
	0118:   actor $FRANK1_SWAT8 dead
then
	if
		8118:   not actor $FRANK1_PARTY_PERSON1 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON1 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON1
	if
		8118:   not actor $FRANK1_PARTY_PERSON2 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON2 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON2
	if
		8118:   not actor $FRANK1_PARTY_PERSON3 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON3 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON3
	if
		8118:   not actor $FRANK1_PARTY_PERSON4 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON4 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON4
	if
		8118:   not actor $FRANK1_PARTY_PERSON5 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON5 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON5
	if
		8118:   not actor $FRANK1_PARTY_PERSON6 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON6 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON6
	if
		8118:   not actor $FRANK1_PARTY_PERSON7 dead
	then
		01D0: actor $FRANK1_PARTY_PERSON7 avoid_player $PLAYER_CHAR
	end
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON7
else
	0006: 1@ = 1
	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON1
	gosub @CLUBBERS_IDLE_CHECKS_STUFF

	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON4
	gosub @CLUBBERS_IDLE_CHECKS_STUFF

	0006: 1@ = 2
	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON2
	gosub @CLUBBERS_IDLE_CHECKS_STUFF

	0084: $FRANK1_PARTY_PERSON_TEMP = $FRANK1_PARTY_PERSON6
	gosub @CLUBBERS_IDLE_CHECKS_STUFF
end
return

:CLUBBERS_IDLE_CHECKS_STUFF
if
	8118:   not actor $FRANK1_PARTY_PERSON_TEMP dead 
then
	if and
		02A0:   actor $FRANK1_PARTY_PERSON_TEMP stopped
		82E0:   not actor $FRANK1_PARTY_PERSON_TEMP firing_weapon
	then
		if
			0039:   1@ == 1
		then
			009C: char_wander_dir $FRANK1_PARTY_PERSON_TEMP to -1
		else
			01D0: actor $FRANK1_PARTY_PERSON_TEMP avoid_player $PLAYER_CHAR
		end
	end
else
	01C2: remove_references_to_actor $FRANK1_PARTY_PERSON_TEMP
end
return

:POLICE_IDLE_CHECKS
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT1
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT2
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT3
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT4
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT5
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT6
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT7
gosub @POLICE_IDLE_CHECKS_STUFF
0084: $FRANK1_SWAT_TEMP = $FRANK1_SWAT8
gosub @POLICE_IDLE_CHECKS_STUFF
return

:POLICE_IDLE_CHECKS_STUFF
if
	8118:   not actor $FRANK1_SWAT_TEMP dead 
then
	041C: make_actor $FRANK1_SWAT_TEMP say SOUND_SWAT_PED_SHOUT
	if and
		02A0:   actor $FRANK1_SWAT_TEMP stopped
		82E0:   not actor $FRANK1_SWAT_TEMP firing_weapon
	then
		if
			8118:   not actor $FRANK1_PARTY_PERSON1 dead
		then
			01C9: actor $FRANK1_SWAT_TEMP kill_actor $FRANK1_PARTY_PERSON1
		else
			if
				8118:   not actor $FRANK1_PARTY_PERSON2 dead
			then
				01C9: actor $FRANK1_SWAT_TEMP kill_actor $FRANK1_PARTY_PERSON2
			else
				if
					8118:   not actor $FRANK1_PARTY_PERSON4 dead
				then
					01C9: actor $FRANK1_SWAT_TEMP kill_actor $FRANK1_PARTY_PERSON4
				else
					if
						8118:   not actor $FRANK1_PARTY_PERSON6 dead
					then
						01C9: actor $FRANK1_SWAT_TEMP kill_actor $FRANK1_PARTY_PERSON6
					else
						01CA: actor $FRANK1_SWAT_TEMP kill_player $PLAYER_CHAR 
						01C2: remove_references_to_actor $FRANK1_SWAT_TEMP
					end
				end
			end
		end
	end
else
	01C2: remove_references_to_actor $FRANK1_SWAT_TEMP
end
return

:DRAW_DISCO_LIGHTS
0008: $SHADOW_COUNTER += 1
if and
	0018:   $SHADOW_COUNTER > 28 
	001A:   32 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1272.563 -1107.375 12.0 rotation 30.0 scale 0.75 transparency 0 colour $R $G 0 
	0250: create_light_at 1272.438 -1107.563 13.0625 RGB_values $R $G 0
else
	0209: $G = random_int_in_ranges 0 101 
	0209: $R = random_int_in_ranges 0 101
end
if and
	0018:   $SHADOW_COUNTER > 15 
	001A:   20 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1270.938 -1107.625 12.0 rotation 0.0 scale 1.1875 transparency 0 colour $R1 $G1 0
	0250: create_light_at 1272.438 -1107.125 13.0625 RGB_values $R1 $G1 0 
else
	0209: $G1 = random_int_in_ranges 0 101 
	0209: $R1 = random_int_in_ranges 0 101
end
if and
	0018:   $SHADOW_COUNTER > 20 
	001A:   40 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1273.25 -1107.0 12.0 rotation 80.0 scale 1.0 transparency 0 colour $R2 $G2 0 
	0250: create_light_at 1272.438 -1107.563 12.75 RGB_values $R2 $G2 0 
else
	0209: $G2 = random_int_in_ranges 0 101 
	0209: $R2 = random_int_in_ranges 0 101
end
if and
	0018:   $SHADOW_COUNTER > 18 
	001A:   40 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1273.25 -1107.688 12.0 rotation 140.0 scale 0.75 transparency 0 colour $R3 $G3 0 
	0250: create_light_at 1272.438 -1107.125 12.75 RGB_values $R3 $G3 0
else
	0209: $G3 = random_int_in_ranges 0 101 
	0209: $R3 = random_int_in_ranges 0 101
end
if and
	0018:   $SHADOW_COUNTER > 5 
	001A:   14 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1271.438 -1108.0 12.0 rotation 235.0 scale 1.0625 transparency 0 colour $R4 $G4 0 
	0250: create_light_at 1272.438 -1107.563 12.5 RGB_values $R4 $G4 0 
else
	0209: $G4 = random_int_in_ranges 0 101 
	0209: $R4 = random_int_in_ranges 0 101
end
if and
	0018:   $SHADOW_COUNTER > 9 
	001A:   26 > $SHADOW_COUNTER 
then
	016F: draw_shadow SHADOW_EXPLOSION at 1271.5 -1107.0 12.0 rotation 325.0 scale 1.75 transparency 0 colour $R5 $G5 0 
	0250: create_light_at 1272.438 -1107.125 12.5 RGB_values $R5 $G5 0 
else
	0209: $G5 = random_int_in_ranges 0 101 
	0209: $R5 = random_int_in_ranges 0 101
end
if and
	0038:   $SHADOW_COUNTER == 40 
	0018:   $SHADOW_COUNTER > 40
then
	0004: $SHADOW_COUNTER = 0 
end
return
