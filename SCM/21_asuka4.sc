// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************asuka mission 4******************************** 
// ******************************************Pay day for Ray********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M21_PAYDAYFORRAY

gosub @MISSION_START_ASUKA4
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_ASUKA4
end

:MISSION_END_ASUKA4
gosub @MISSION_CLEANUP_ASUKA4
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_ASUKA4

0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA1 = 1 
03A4: name_thread 'ASUKA4' 
0001: wait 0 ms 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'ASUKAH' 
02F3: load_object #CUTOBJ03 'MINNOTE' 
023C: load_special_actor 'ASUKA' as 1 
0247: request_model #CONDO_IVY 
0247: request_model #KMRICNDO01 
038B: load_all_models_now 


while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CONDO_IVY available 
		8248:   not model #KMRICNDO01 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A4_PDR' 
0244: set_cutscene_pos 523.0625 -636.9375 15.5625 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $CS_NOTE 'MINNOTE' 
0395: clear_area 1 at 523.5625 -639.375 range 16.5625 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 523.5625 -639.375 16.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   805 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_A' duration 10000 ms flag 1  // It's my handsome handyman!
while 001A:   3370 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_B' duration 10000 ms flag 1  // Maria's all tied up at the moment but I'll tell her you called.
while 001A:   6758 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_C' duration 10000 ms flag 1  // Who's that? Asuka? I know I've been a naughty girl but I really need to pee! OK?
while 001A:   12673 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_D' duration 10000 ms flag 1  // It's time you met our man inside the LPD.
while 001A:   15481 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_E' duration 10000 ms flag 1  // Here's his payment for the last little job he did for us.
while 001A:   18606 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_F' duration 10000 ms flag 1  // He is understandably cautious.
while 001A:   21381 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_G' duration 10000 ms flag 1  // Get to the pay phone in Torrington as quick as you can and await his instructions.
while 001A:   25955 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   29333 > $CUT_SCENE_TIME
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
0249: release_model #CUTOBJ03 
0249: release_model #CONDO_IVY 
0249: release_model #KMRICNDO01 
0296: unload_special_actor 1 
029B: $PHONE_1_OBJ = create_object #FAKETARGET at 229.1875 -1537.563 26.0 
01C7: remove_object_from_mission_cleanup_list $PHONE_1_OBJ 
029B: $PHONE_2_OBJ = create_object #FAKETARGET at -53.5 -699.0625 26.0 
01C7: remove_object_from_mission_cleanup_list $PHONE_2_OBJ 
029B: $PHONE_3_OBJ = create_object #FAKETARGET at 204.75 -135.0 16.0 
01C7: remove_object_from_mission_cleanup_list $PHONE_3_OBJ 
029B: $PHONE_4_OBJ = create_object #FAKETARGET at 60.25 -964.75 26.0625 
01C7: remove_object_from_mission_cleanup_list $PHONE_4_OBJ 
029B: $PHONE_5_OBJ = create_object #FAKETARGET at 178.5 -15.75 16.25 
01C7: remove_object_from_mission_cleanup_list $PHONE_5_OBJ 
0004: $COUNTDOWN_AS4 = 211000 
014E: start_timer_at $COUNTDOWN_AS4 

0188: $BLIP1_AS4 = create_marker_above_object $PHONE_1_OBJ 
024C: text_phone $PHONE_RAY1 'AM4_1E'  // Get to the Phone at the Hospital. 
03CF: load_wav 'H5_A' 


while true
	if or
		80F6:   not player $PLAYER_CHAR 0 229.1875 -1537.563 26.0 radius 1.0 1.0 3.0 //PHONE1
		8447:   not is_player_lifting_a_phone $PLAYER_CHAR 
	jf break
	wait 0 ms
	gosub @CHECK_TIMER_STATUS_ASUKA4
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0396: pause_timer 1 
015F: set_camera_position 214.8125 -1549.875 32.4375 rotation 0.0 0.0 0.0 
0160: point_camera 215.5 -1549.188 32.0625 switchstyle JUMP_CUT 

while 83C2:   not phone $PHONE_RAY1 answered 
	wait 0 ms
end

03D1: play_wav 

while 0447:    is_player_lifting_a_phone $PLAYER_CHAR 
	wait 0 ms
end

02EB: restore_camera_jumpcut 
0396: pause_timer 0 
0164: disable_marker $BLIP1_AS4 

// Define the follow car and create the thread that will handle creation and ai.
0004: $FOLLOW_CAR_MODEL = #COLUMB
0004: $FOLLOW_DRIVER_MODEL = #GANG11
0005: $FOLLOW_CAR_START_X = 295.0
0005: $FOLLOW_CAR_START_Y = -1580.0
004F: create_thread @CAR_FOLLOWER

0188: $BLIP1_AS4 = create_marker_above_object $PHONE_5_OBJ 
024C: text_phone $PHONE_RAY5 'AM4_1A'  // Get to the Phone in West Belleville Park.
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03CF: load_wav 'A4_A' 

while true
	if or
		80F6:   not player $PLAYER_CHAR 0 178.5 -15.75 16.25 radius 1.0 1.0 3.0 //PHONE5
		8447:   not is_player_lifting_a_phone $PLAYER_CHAR 
	jf break
	wait 0 ms
	gosub @CHECK_TIMER_STATUS_ASUKA4
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0396: pause_timer 1 
015F: set_camera_position 173.0 -18.0 20.0 rotation 0.0 0.0 0.0 
0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle JUMP_CUT

while 83C2:   not phone $PHONE_RAY5 answered 
	wait 0 ms
end

03D1: play_wav 

while 0447:    is_player_lifting_a_phone $PLAYER_CHAR 
	wait 0 ms
end

02EB: restore_camera_jumpcut 
0396: pause_timer 0 
0164: disable_marker $BLIP1_AS4 



0188: $BLIP1_AS4 = create_marker_above_object $PHONE_2_OBJ 
024C: text_phone $PHONE_RAY2 'AM4_1B' // Get to the Phone on Liberty Campus.
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03CF: load_wav 'A4_B'

while true
	if or
		80F6:   not player $PLAYER_CHAR 0 -53.5 -699.0625 26.0 radius 1.0 1.0 3.0 //PHONE2
		8447:   not is_player_lifting_a_phone $PLAYER_CHAR 
	jf break
	wait 0 ms
	gosub @CHECK_TIMER_STATUS_ASUKA4
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0396: pause_timer 1 
015F: set_camera_position -77.4375 -702.5 33.5625 rotation 0.0 0.0 0.0 
0160: point_camera -76.5 -702.375 33.25 switchstyle JUMP_CUT 

while 83C2:   not phone $PHONE_RAY2 answered 
	wait 0 ms
end

03D1: play_wav 

while 0447:    is_player_lifting_a_phone $PLAYER_CHAR 
	wait 0 ms
end

02EB: restore_camera_jumpcut 
0396: pause_timer 0 
0164: disable_marker $BLIP1_AS4 


0188: $BLIP1_AS4 = create_marker_above_object $PHONE_3_OBJ 
024C: text_phone $PHONE_RAY3 'AM4_1C'  // Get to the Phone in South Belleville Park.
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03CF: load_wav 'A4_C' 

while true
	if or
		80F6:   not player $PLAYER_CHAR 0 204.75 -135.0 16.0 radius 1.0 1.0 3.0 //PHONE3
		8447:   not is_player_lifting_a_phone $PLAYER_CHAR 
	jf break
	wait 0 ms
	gosub @CHECK_TIMER_STATUS_ASUKA4
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0396: pause_timer 1 
015F: set_camera_position 191.625 -130.5 20.0 rotation 0.0 0.0 0.0 
0160: point_camera 192.5 -130.8125 19.6875 switchstyle JUMP_CUT 

while 83C2:   not phone $PHONE_RAY3 answered 
	wait 0 ms
end

03D1: play_wav 

while 0447:    is_player_lifting_a_phone $PLAYER_CHAR 
	wait 0 ms
end

02EB: restore_camera_jumpcut 
0396: pause_timer 0 
0164: disable_marker $BLIP1_AS4 
0188: $BLIP1_AS4 = create_marker_above_object $PHONE_4_OBJ 
024C: text_phone $PHONE_RAY4 'AM4_1D'  // Meet me in the toilet block in the park.
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03CF: load_wav 'A4_D' 

while true
	if or
		80F6:   not player $PLAYER_CHAR 0 60.25 -964.75 26.0625 radius 1.0 1.0 3.0 //PHONE4
		8447:   not is_player_lifting_a_phone $PLAYER_CHAR 
	jf break
	wait 0 ms
	gosub @CHECK_TIMER_STATUS_ASUKA4
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0396: pause_timer 1 
015F: set_camera_position 51.6875 -973.0625 30.5 rotation 0.0 0.0 0.0 
0160: point_camera 52.375 -972.4375 30.125 switchstyle JUMP_CUT 

// The player led the follow car right to Ray! He won't stand for this!
if
	0038:   $BEING_FOLLOWED == 1
then
	0004: $SHAKE_FOLLOW_CAR_FAILED = 1
	024C: text_phone $PHONE_RAY4 'AM4_1F'  // Get lost.
	03CF: load_wav 'H5_B'
end

while 83C2:   not phone $PHONE_RAY4 answered 
	wait 0 ms
end

03D1: play_wav 

while 0447:    is_player_lifting_a_phone $PLAYER_CHAR 
	wait 0 ms
end

02EB: restore_camera_jumpcut 
014F: stop_timer $COUNTDOWN_AS4 
0164: disable_marker $BLIP1_AS4 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
0004: $RAYS_CUTSCENE_FLAG = 1

if
	0038:   $SHAKE_FOLLOW_CAR_FAILED == 1
then
	00BC: print_now 'AM4_NO' duration 5000 ms flag 1  // ~r~You were being followed!
	goto @MISSION_FAILED_ASUKA4
end

018A: $BLIP1_AS4 = create_checkpoint_at 38.75 -725.375 22.75 

while 80F6:   not player $PLAYER_CHAR 1 38.75 -725.375 22.75 radius 1.0 1.0 2.0 
	wait 0 ms
end

0164: disable_marker $BLIP1_AS4 
01BD: $PRE_CUTSCENE_START_TIME = current_time_in_ms 
0004: $PRE_CUTSCENE_ELAPSED_TIME = 0 

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		001A:   5000 > $PRE_CUTSCENE_ELAPSED_TIME // if player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
	01BD: $PRE_CUTSCENE_CURRENT_TIME = current_time_in_ms 
	0084: $PRE_CUTSCENE_ELAPSED_TIME = $PRE_CUTSCENE_CURRENT_TIME 
	0060: $PRE_CUTSCENE_ELAPSED_TIME -= $PRE_CUTSCENE_START_TIME 
end //while

//RAY CUT SCENE*************************************************************************

03EF: player $PLAYER_CHAR make_safe 
0110: clear_player $PLAYER_CHAR wanted_level 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
03AF: set_streaming 0 
023C: load_special_actor 'RAY' as 2 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'RAYH' 

while fading
	wait 0 ms
end

038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'R0_PDR2' 
0244: set_cutscene_pos 39.375 -726.625 21.6875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_RAY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_RAY 'RAY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $RAY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_RAY 
02F5: set_head_anim $RAY_CSHEAD 'RAY' 
0395: clear_area 1 at 39.0 -723.5 range 22.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 39.0 -723.5 22.0 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime
 
while 001A:   2887 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_3' duration 10000 ms flag 1  // You must be Asuka's new errand boy!
while 001A:   6583 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_4' duration 10000 ms flag 1  // You got the money? Is it all here?
while 001A:   10279 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_5' duration 10000 ms flag 1  // I know what you're thinking, another bent cop.
while 001A:   13282 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_6' duration 10000 ms flag 1  // Well, it's a bent world.
while 001A:   15014 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_7' duration 10000 ms flag 1  // Just 'cause I lost a few partners, those suckers from internal affairs have started sniffing around.
while 001A:   20212 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_8' duration 10000 ms flag 1  // Reckon they can smell me.
while 001A:   21944 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_9' duration 10000 ms flag 1  // Well, this city is just one big open sewer.
while 001A:   24716 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_10' duration 10000 ms flag 1  // But I'm gonna need some non-union help.
while 001A:   27719 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM4_11' duration 10000 ms flag 1  // And if you're interested you'll know where to find me.
while 001A:   30611 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   31666 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1500 ms

while fading
	wait 0 ms
end

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

03AD: set_rubbish 1 
00BE: clear_prints 
02EA: end_cutscene 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 

goto @MISSION_PASSED_ASUKA4


/////////////////////////////////////////

:CHECK_TIMER_STATUS_ASUKA4
if
	0038:   $COUNTDOWN_AS4 == 0 
then
	00BC: print_now 'OUTTIME' duration 5000 ms flag 1  // ~r~Too slow, man, too slow!
	goto @MISSION_FAILED_ASUKA4
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_ASUKA4
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_ASUKA4

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_ASUKA4
0004: $PAYDAY_FOR_RAY_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 11000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 11000 
0318: set_latest_mission_passed 'AM4'  // 'PAYDAY FOR RAY'
030C: set_mission_points += 1 
02A7: $RAY_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_RAY at 38.75 -725.375 -100.0 
0373: set_camera_directly_behind_player 
004F: create_thread @RAY_MISSION1_LOOP
goto @MISSION_END_ASUKA4

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_ASUKA4
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA1 = 0 
014F: stop_timer $COUNTDOWN_AS4 
0164: disable_marker $BLIP1_AS4 
024E: disable_phone $PHONE_RAY1 
024E: disable_phone $PHONE_RAY2 
024E: disable_phone $PHONE_RAY3 
024E: disable_phone $PHONE_RAY4 
0108: destroy_object $PHONE_1_OBJ 
0108: destroy_object $PHONE_2_OBJ 
0108: destroy_object $PHONE_3_OBJ 
0108: destroy_object $PHONE_4_OBJ 
0108: destroy_object $PHONE_5_OBJ 
0004: $RAYS_CUTSCENE_FLAG = 0 
0396: pause_timer 0 
00D8: mission_has_finished 
return

