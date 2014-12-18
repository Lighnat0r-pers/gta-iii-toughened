// *******************************************************************************************
// *******************************************************************************************
// **************************************Joey Mission 4***************************************
// ***************************************pick up Toni****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

:M07_CIPRIANISCHAUFFEUR

gosub @MISSION_START_JOEY4
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_JOEY4
end

:MISSION_END_JOEY4
gosub @MISSION_CLEANUP_JOEY4
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_JOEY4
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_JOEY = 1 
03A4: name_thread 'JOEY4' 
0001: wait 0 ms
if
	0038:   $TONIS_CAR_CREATED_BEFORE == 1
then
	00A6: delete_car $TONIS_RIDE 
end

0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 0 
0004: $FLAG_DISPLAYED_HORN_MESSAGE_JM4 = 0 
0004: $TONI_ABUSE1_DONE_BEFORE = 0 
0004: $OBJECTIVE_TRIAD1_DONE_BEFORE = 0 
0004: $OBJECTIVE_TRIAD2_DONE_BEFORE = 0 
0004: $TRIADS_OBJECTIVE_PASSED = 0 
0004: $TONIS_AUDIO_ALL_FINISHED = 0 
0004: $KILLED_TRIAD_AMBUSH_JOEY4 = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0

01EB: set_car_density_to 0.0 
023C: load_special_actor 'JOEY' as 1 
023C: load_special_actor 'TONY' as 2 
02F3: load_object #CUTOBJ01 'JOEDOOR' 
02F3: load_object #CUTOBJ02 'JOEYH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'TONYH' 
0247: request_model #MAFIA 
0247: request_model #IDAHO 
0247: request_model #STALLION 
0247: request_model #JOGARAGEEXT 
0247: request_model #JOGARAGEINT 
038B: load_all_models_now 

while true
	if or
		8248:   not model #MAFIA available 
		8248:   not model #IDAHO available 
		8248:   not model #STALLION available
	jf break
	wait 0 ms
end //while

00A5: $TONIS_RIDE = create_car #MAFIA at 1189.688 -864.25 14.0625
0004: $TONIS_CAR_CREATED_BEFORE = 1 
0175: set_car $TONIS_RIDE z_angle_to -142.0 
041E: set_radio_station DOUBLE_CLEFF_FM -1

while true
	if or
		8248:   not model #JOGARAGEEXT available 
		8248:   not model #JOGARAGEINT available 
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'J4_ETH' 
0244: set_cutscene_pos 1190.063 -869.8125 13.9375 
00A5: $CUT_CAR2_LM3 = create_car #IDAHO at 1182.5 -857.0 14.0625
0175: set_car $CUT_CAR2_LM3 z_angle_to 291.1875 
00A5: $CUT_CAR3_LM3 = create_car #STALLION at 1192.875 -860.75 14.0
0175: set_car $CUT_CAR3_LM3 z_angle_to 150.0 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_JOEY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_JOEY 'JOEY' 
02E5: $CUTSCENE_TONY = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_TONY 'TONY' 
02F4: create_cutscene_actor $JOEY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_JOEY 
02F5: set_head_anim $JOEY_CSHEAD 'JOEY' 
02F4: create_cutscene_actor $TONY_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_TONY 
02F5: set_head_anim $TONY_CSHEAD 'TONY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_JOEDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_JOEDOOR 'JOEDOOR' 
0395: clear_area 1 at 1195.0 -870.25 range 15.0 10.0 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR1 0 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR2 0

//MOVE GARAGE UP 
01BB: store_object $JOEY_DOOR1 position_to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z 
01BB: store_object $JOEY_DOOR2 position_to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z 
0009: $JOEYDOOR1_Z += 3.0 
0009: $JOEYDOOR2_Z += 3.0 

while true
	if or
		834E:   not move_object $JOEY_DOOR1 to $JOEYDOOR1_X $JOEYDOOR1_Y $JOEYDOOR1_Z speed 0.0625 0.0625 100.0 collision_check 0 
		834E:   not move_object $JOEY_DOOR2 to $JOEYDOOR2_X $JOEYDOOR2_Y $JOEYDOOR2_Z speed 0.0625 0.0625 100.0 collision_check 0
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY4
end //while

016A: fade 1 for 1800 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   1 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_A' duration 10000 ms flag 1  // Yeah, I know Toni, I've tuned her real sweet. She purrs, you know what I mean?
while 001A:   4000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_B' duration 10000 ms flag 1  // Oh! Here's the guy I was telling you about!
while 001A:   6180 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_C' duration 10000 ms flag 1  // Alright Listen. This guy ain't Italian and he's no mechanic but he can get things fixed.
while 001A:   10230 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_D' duration 10000 ms flag 1  // This is Pops Capo, Toni Cipriani.
while 001A:   13040 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_E' duration 10000 ms flag 1  // Yeah, I'm Toni Cipriani
while 001A:   15110 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_F' duration 10000 ms flag 1  // Take him to Momma's restaurant at St Marks, alright.
while 001A:   18080 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM4_G' duration 10000 ms flag 1  // Now listen to me, I'm planning a job that needs a good driver so drop by sometime later Ok?
while 001A:   23511 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   23833 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end


while 82E9:   not cutscene_reached_end
	wait 0 ms
end

03AD: set_rubbish 1 
00BE: clear_prints 
02EA: end_cutscene
if
	 8119:   not car $TONIS_RIDE wrecked
then
	01C8: $TONI_CIPRIANI = create_actor PEDTYPE_SPECIAL model #SPECIAL02 in_car $TONIS_RIDE passenger_seat 0 
	01ED: clear_actor $TONI_CIPRIANI threat_search 
	039E: set_char_cant_be_dragged_out $TONI_CIPRIANI to 1 
	035F: set_actor $TONI_CIPRIANI armour_to 100 
	0369: put_player $PLAYER_CHAR in_car $TONIS_RIDE
end

0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR1 1 
0363: toggle_model_render_at 1192.188 -867.25 14.0625 radius 6.0 object #JOEY_DOOR2 1 
0395: clear_area 1 at 1198.5 -871.375 range 15.0 10.0 
015F: set_camera_position 1200.813 -869.3125 15.0 0.0 rotation 0.0 0.0 
0160: point_camera 1199.875 -869.6875 15.0 switchstyle JUMP_CUT
0001: wait 0 ms 
02A3: toggle_widescreen 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #IDAHO 
0249: release_model #STALLION 
0249: release_model #JOGARAGEEXT 
0249: release_model #JOGARAGEINT 
00A6: delete_car $CUT_CAR2_LM3 
00A6: delete_car $CUT_CAR3_LM3 
03CF: load_wav 'J4T_1'

while 83D0:   not wav_loaded 
	wait 0 ms
end

03D1: play_wav 
00BC: print_now 'JM4_10' duration 5000 ms flag 1  // OK, Kid. Drive me to the laundry in Chinatown first, I got a bit of business to take care of.

//CAR DRIVING OUT OF GARAGE CUT SCENE

if
	 8119:   not car $TONIS_RIDE wrecked
then
	02C2: car $TONIS_RIDE drive_to_point 1198.5 -871.375 -100.0 
	00AD: set_car_cruise_speed $TONIS_RIDE to 2.0 
	00AE: set_car_driving_style $TONIS_RIDE to 3
end

if
	8118:   not actor $TONI_CIPRIANI dead
then
	022D: set_actor $TONI_CIPRIANI to_look_at_player $PLAYER_CHAR 
	022E: set_player $PLAYER_CHAR to_look_at_actor $TONI_CIPRIANI
end

while 81AD:   not car $TONIS_RIDE sphere 0 near_point 1198.5 -871.375 radius 2.0 2.0
	wait 0 ms
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	if
		0038:   $TONIS_AUDIO_ALL_FINISHED == 0
	then
		while 83D2:   not wav_ended
			wait 0 ms
			gosub @CHECK_TONI_STATUS_JOEY4
		end //while
		03CF: load_wav 'J4T_2'
		while 83D0:   not wav_loaded
			wait 0 ms
			gosub @CHECK_TONI_STATUS_JOEY4
		end //while
		03D1: play_wav 
		00BC: print_now 'JM4_11' duration 5000 ms flag 1  // Those washer women aint been payin' their protection money.
		while 83D2:   not wav_ended
			wait 0 ms
			gosub @CHECK_TONI_STATUS_JOEY4
		end //while
		03CF: load_wav 'J4T_3' 
		0004: $TONIS_AUDIO_ALL_FINISHED = 1 
	end
end //while

00BE: clear_prints

while 83D0:   not wav_loaded
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

03D1: play_wav 
00BC: print_now 'JM4_12' duration 5000 ms flag 1  // And watch the car, Joey just fixed this junk heap.
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
	gosub @CHECK_TONI_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

03CF: load_wav 'J4T_4' 

while 83D0:   not wav_loaded
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

03D1: play_wav 
00BC: print_now 'JM4_13' duration 5000 ms flag 1  // So no fancy crap, OK?

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

if
	8118:   not actor $TONI_CIPRIANI dead
then
	022F: set_actor $TONI_CIPRIANI stop_looking 
	0230: set_player $PLAYER_CHAR stop_looking
end

00BE: clear_prints 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
03A2: set_car_status $TONIS_RIDE to 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
015A: restore_camera 
01EB: set_car_density_to 1.0 // TURN ALL THE CARS BACK ON
014C: set_parked_car_generator $GEN_CAR14 cars_to_generate_to 0 
0247: request_model #GANG03 
0247: request_model #GANG04 
03CF: load_wav 'J4_A'

while true
	if or
		8248:   not model #GANG03 available 
		8248:   not model #GANG04 available 
		83D0:   not wav_loaded
	jf break
	wait 0 ms
end //while

022B: switch_ped_roads_off 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
01E8: switch_roads_off 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
0395: clear_area 1 at 843.375 -663.75 range 15.0 10.0 
018A: $JOEY4_LAUNDRY_MARKER = create_checkpoint_at 843.0 -660.0 -100.0 
018B: show_on_radar $JOEY4_LAUNDRY_MARKER BLIP_ONLY
009A: $JOEY4_TRIAD1 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 850.0 -663.0 14.6875
01ED: clear_actor $JOEY4_TRIAD1 threat_search 
02AB: set_actor $JOEY4_TRIAD1 immunities BP 1 FP 1 EP 1 CP 1 MP 1 
0223: set_actor $JOEY4_TRIAD1 health_to 200
009A: $JOEY4_TRIAD2 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 850.0 -664.6875 14.6875
01ED: clear_actor $JOEY4_TRIAD2 threat_search 
02AB: set_actor $JOEY4_TRIAD2 immunities BP 1 FP 1 EP 1 CP 1 MP 1 
0223: set_actor $JOEY4_TRIAD2 health_to 200
020E: actor $JOEY4_TRIAD1 look_at_actor $JOEY4_TRIAD2 
020E: actor $JOEY4_TRIAD2 look_at_actor $JOEY4_TRIAD1 
0164: disable_marker $JOEY4_LAUNDRY_MARKER 
0004: $FLAG_CAR_BLIP_DISPLAYED_JM4 = 1 
0004: $BLOB_FLAG = 1
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1

gosub @CHECK_VEHICLE_STATUS_JOEY4

while true
	if or
		81A0:   not player $PLAYER_CHAR stopped $BLOB_FLAG 839.1875 -667.375 14.0 842.0625 -673.875 17.0 
		010F:   player $PLAYER_CHAR wanted_level > 0 
		80DC:   not is_player_in_car $PLAYER_CHAR car $TONIS_RIDE 
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY4
	gosub @CHECK_IN_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_REPAIR_JOEY4
	if
		01A0:   player $PLAYER_CHAR stopped 0 839.1875 -667.375 14.0 842.0625 -673.875 17.0
	then
		if and
			010F:   player $PLAYER_CHAR wanted_level > 0
			0038:   $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 == 0
		then
			00BC: print_now 'WANTED1' duration 3000 ms flag 1  // ~g~Shake the cops and lose your wanted level!
			0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 1
		end
	else
		if
			8057:   not is_player_in_area_3d $PLAYER_CHAR coords 839.1875 -667.375 14.0 to 842.0625 -673.875 17.0 sphere 0 
		then
			0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 0
		end
	end
end //while

0164: disable_marker $JOEY4_LAUNDRY_MARKER 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
015F: set_camera_position 825.5625 -680.5625 16.5625 0.0 rotation 0.0 0.0 
0160: point_camera 826.3125 -679.875 16.5 switchstyle JUMP_CUT
03CF: load_wav 'J4_B'

while 83D0:   not wav_loaded
	wait 0 ms
end //while

//TONI LANDRETTE CUT_SCENE
if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	03F9: make_actors $JOEY4_TRIAD1 $JOEY4_TRIAD2 converse_in 999999 ms
end

if
	8118:   not actor $TONI_CIPRIANI dead
then
	02AB: set_actor $TONI_CIPRIANI immunities BP 1 FP 1 EP 1 CP 1 MP 1
end

03D1: play_wav 
00BC: print_now 'JM4_2' duration 5000 ms flag 1  // Wait here! Keep the engine running. This ain't a social call.
0395: clear_area 1 at 843.375 -663.75 range 15.0 10.0 
0001: wait 4000 ms 

gosub @CHECK_TONI_STATUS_JOEY4

01B2: give_actor $TONI_CIPRIANI weapon WEAPONTYPE_BASEBALLBAT ammo 0 
01D3: actor $TONI_CIPRIANI leave_car $TONIS_RIDE 

while 00DB:   is_char_in_car $TONI_CIPRIANI car $TONIS_RIDE
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

015F: set_camera_position 841.25 -669.0625 16.5 0.0 rotation 0.0 0.0 
0160: point_camera 842.0625 -668.5 16.3125 switchstyle JUMP_CUT

//TONI WALKS TO DOORS

gosub @CHECK_TONI_STATUS_JOEY4

01BE: set_actor $TONI_CIPRIANI to_look_at_spot 843.875 -663.6875 15.0625 
0006: 17@ = 0 
0211: actor $TONI_CIPRIANI walk_to 843.875 -663.6875

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if and
		0019:   17@ > 10000
		8118:   not actor $TONI_CIPRIANI dead
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 843.875 -663.6875 13.875 
	end
end //while

//OPEN DOORS

while true
	if or
		834D:   not rotate_object $LAUNDRY_DOOR1 from_angle 90.0 to 10.0 collision_check 0 
		834D:   not rotate_object $LAUNDRY_DOOR2 from_angle 90.0 to 10.0 collision_check 0 
	jf break
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

//TONI WALKS IN

gosub @CHECK_TONI_STATUS_JOEY4

0006: 17@ = 0 
0211: actor $TONI_CIPRIANI walk_to 848.0625 -663.375

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if and
		0019:   17@ > 10000
		8118:   not actor $TONI_CIPRIANI dead
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 848.0625 -663.375 13.875 
	end
end //while

0192: set_actor $TONI_CIPRIANI objective_to_stand_still

if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	03F9: make_actors $JOEY4_TRIAD1 $JOEY4_TRIAD2 converse_in 0 ms
end

if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
	8118:   not actor $TONI_CIPRIANI dead
then
	020E: actor $JOEY4_TRIAD1 look_at_actor $TONI_CIPRIANI 
	020E: actor $JOEY4_TRIAD2 look_at_actor $TONI_CIPRIANI 
	022C: set_actor $JOEY4_TRIAD1 to_look_at_actor $TONI_CIPRIANI 
	022C: set_actor $JOEY4_TRIAD2 to_look_at_actor $TONI_CIPRIANI
end

0001: wait 2500 ms 
0176: $DOOR1_POSITION_JM4 = object $LAUNDRY_DOOR1 z_angle 
0176: $DOOR2_POSITION_JM4 = object $LAUNDRY_DOOR2 z_angle

gosub @CHECK_JUST_TONI_STATUS_JOEY4

01BE: set_actor $TONI_CIPRIANI to_look_at_spot 843.875 -663.6875 15.0625

if or
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	01B2: give_actor $JOEY4_TRIAD1 weapon WEAPONTYPE_UZI ammo 100 
	01B2: give_actor $JOEY4_TRIAD2 weapon WEAPONTYPE_UZI ammo 100
end

0319: set_actor $TONI_CIPRIANI running 1

if or
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	0350: set_actor $JOEY4_TRIAD1 maintain_position_when_attacked 1 
	0350: set_actor $JOEY4_TRIAD2 maintain_position_when_attacked 1 
	01C9: actor $JOEY4_TRIAD1 kill_actor $TONI_CIPRIANI 
	01C9: actor $JOEY4_TRIAD2 kill_actor $TONI_CIPRIANI
end

//TONI RUNS OUT

0395: clear_area 1 at 843.375 -663.75 range 15.0 10.0 
0006: 17@ = 0 

if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	022F: set_actor $JOEY4_TRIAD1 stop_looking 
	022F: set_actor $JOEY4_TRIAD2 stop_looking
end

0239: actor $TONI_CIPRIANI run_to 843.875 -663.6875

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if and
		0019:   17@ > 10000
		8118:   not actor $TONI_CIPRIANI dead
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 843.875 -663.6875 13.875
	end
end //while

01D4: actor $TONI_CIPRIANI go_to_car $TONIS_RIDE and_enter_it_as_a_passenger 
015F: set_camera_position 836.0 -677.8125 15.8125 0.0 rotation 0.0 0.0 
0160: point_camera 836.6875 -677.125 15.625 switchstyle JUMP_CUT
0001: wait 1500 ms

03CF: load_wav 'J4_C'

while 83D0: not wav_loaded
	wait 0 ms
end

03D1: play_wav 
00BC: print_now 'JM4_3' duration 4000 ms flag 1  // It's a Triad ambush! Get us out of here kid!

//TRIADS RUN OUT

if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	0350: set_actor $JOEY4_TRIAD1 maintain_position_when_attacked 0 
	0350: set_actor $JOEY4_TRIAD2 maintain_position_when_attacked 0 
	0239: actor $JOEY4_TRIAD1 run_to 842.0 -663.75 
	0239: actor $JOEY4_TRIAD2 run_to 843.5 -663.75
end

while 8038:   not  $TRIADS_OBJECTIVE_PASSED == 2 
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	if and
		0118:   actor $JOEY4_TRIAD1 dead 
		0038:   $OBJECTIVE_TRIAD1_DONE_BEFORE == 0
	then
		0008: $TRIADS_OBJECTIVE_PASSED += 1 
		0004: $OBJECTIVE_TRIAD1_DONE_BEFORE = 1
	end
	if and
		0118:   actor $JOEY4_TRIAD2 dead 
		0038:   $OBJECTIVE_TRIAD2_DONE_BEFORE == 0
	then
		0008: $TRIADS_OBJECTIVE_PASSED += 1 
		0004: $OBJECTIVE_TRIAD2_DONE_BEFORE = 1
	end
	if and
		0126:   actor $JOEY4_TRIAD1 walking 
		0038:   $OBJECTIVE_TRIAD1_DONE_BEFORE == 0 
	then
		01D9: actor $JOEY4_TRIAD1 destroy_car $TONIS_RIDE 
		0008: $TRIADS_OBJECTIVE_PASSED += 1 
		0004: $OBJECTIVE_TRIAD1_DONE_BEFORE = 1
	end
	if and
		0126:   actor $JOEY4_TRIAD2 walking 
		0038:   $OBJECTIVE_TRIAD2_DONE_BEFORE == 0 
	then
		01D9: actor $JOEY4_TRIAD2 destroy_car $TONIS_RIDE 
		0008: $TRIADS_OBJECTIVE_PASSED += 1 
		0004: $OBJECTIVE_TRIAD2_DONE_BEFORE = 1
	end
end //while

while 80DB:   not is_char_in_car $TONI_CIPRIANI car $TONIS_RIDE
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

009A: $JOEY4_TRIAD3 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 843.0625 -689.0 13.875
01B2: give_actor $JOEY4_TRIAD3 weapon WEAPONTYPE_UZI ammo 100 
0223: set_actor $JOEY4_TRIAD3 health_to 200
01CA: actor $JOEY4_TRIAD3 kill_player $PLAYER_CHAR 
011A: set_actor $JOEY4_TRIAD3 search_threat THREAT_PLAYER1 

009A: $JOEY4_TRIAD4 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 844.25 -634.75 13.875
01B2: give_actor $JOEY4_TRIAD4 weapon WEAPONTYPE_UZI ammo 100 
0223: set_actor $JOEY4_TRIAD4 health_to 200
01CA: actor $JOEY4_TRIAD4 kill_player $PLAYER_CHAR 
011A: set_actor $JOEY4_TRIAD4 search_threat THREAT_PLAYER1

if
	8118:   not actor $TONI_CIPRIANI dead
then
	02AB: set_actor $TONI_CIPRIANI immunities BP 0 FP 0 EP 0 CP 0 MP 0
end

if and
	8118:   not actor $JOEY4_TRIAD1 dead 
	8118:   not actor $JOEY4_TRIAD2 dead
then
	02AB: set_actor $JOEY4_TRIAD1 immunities BP 0 FP 0 EP 0 CP 0 MP 0 
	02AB: set_actor $JOEY4_TRIAD2 immunities BP 0 FP 0 EP 0 CP 0 MP 0
end


0247: request_model #COACH 

while 8248:   not model #COACH available
	wait 0 ms
end //while

0395: clear_area 1 at 831.0 -629.0 range 20.0 20.0 
00A5: $JOEY4_BUS = create_car #COACH at 831.0 -629.0 -100.0
0229: set_car $JOEY4_BUS color_to 5 5
0175: set_car $JOEY4_BUS z_angle_to 120.0
020A: set_car $JOEY4_BUS door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
02AA: set_car $JOEY4_BUS immune_to_nonplayer 1 
0224: set_car $JOEY4_BUS health_to 2000

create_thread @CREATE_PEONS_JOEY4

015F: set_camera_position 836.0 -649.0 16.5 0.0 rotation 0.0 0.0 
0158: camera_on_vehicle $JOEY4_BUS mode FIXED switchstyle JUMP_CUT
00BC: print_now 'JM4_9' duration 8000 ms flag 1  // ~g~The Triads have invented a cloning machine that looks suspiciously like a bus! Destroy it ASAP!

wait 5000 ms

01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
015A: restore_camera 

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 

// CLOSE DOORS
while true
	if or
		834D:   not rotate_object $LAUNDRY_DOOR1 from_angle 0.0 to 10.0 collision_check 0 
		834D:   not rotate_object $LAUNDRY_DOOR2 from_angle 180.0 to 10.0 collision_check 0 
	jf break
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

0004: $FLAG_CAR_BLIP_DISPLAYED_JM4 = 1 


if
	8118:   not actor $JOEY4_TRIAD1 dead
then
	011A: set_actor $JOEY4_TRIAD1 search_threat THREAT_PLAYER1
end

if
	8118:   not actor $JOEY4_TRIAD2 dead
then
	011A: set_actor $JOEY4_TRIAD2 search_threat THREAT_PLAYER1
end

0395: clear_area 1 at 1216.688 -328.0625 range 26.0 6.0 
0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 0 
0004: $BLOB_FLAG = 1 

while 8119:   not car $JOEY4_BUS wrecked
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

0109: player $PLAYER_CHAR money += 20000
018C: play_sound SOUND_PART_MISSION_COMPLETE at 0.0 0.0 0.0

// waiting for the player to get to Toni's

018A: $JOEY4_MOMMAS_MARKER = create_checkpoint_at 1216.75 -327.5625 -100.0 
018B: show_on_radar $JOEY4_MOMMAS_MARKER 2
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2
0164: disable_marker $JOEY4_MOMMAS_MARKER

while true
	if or
		81A0:   not player $PLAYER_CHAR stopped $BLOB_FLAG 1215.0 -326.875 25.0 1220.188 -330.5 27.0 
		010F:   player $PLAYER_CHAR wanted_level > 0 
		80DC:   not is_player_in_car $PLAYER_CHAR car $TONIS_RIDE
	jf break
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_IN_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if
		01A0:   player $PLAYER_CHAR stopped 0 1215.0 -326.875 25.0 1220.188 -330.5 27.0
	then
		if and
			010F:   player $PLAYER_CHAR wanted_level > 0
			0038:   $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 == 0
		then
			00BC: print_now 'WANTED1' duration 3000 ms flag 1  // ~g~Shake the cops and lose your wanted level!
			0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 1
		end
	else
		if
			8057:   not is_player_in_area_3d $PLAYER_CHAR coords 1215.0 -326.875 25.0 to 1220.188 -330.5 27.0 sphere 0 
		then
			0004: $FLAG_DISPLAYED_WANTED_MESSAGE_JM4 = 0
		end
	end
end //while

0164: disable_marker $JOEY4_MOMMAS_MARKER 
0395: clear_area 1 at 1216.5 -326.75 range 26.0 6.0 
0395: clear_area 1 at 1219.563 -319.1875 range 27.6875 2.0 
01B4: set_player $PLAYER_CHAR controllable 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
02A3: toggle_widescreen 1 
015F: set_camera_position 1224.063 -333.375 26.5 0.0 rotation 0.0 0.0 
0160: point_camera 1223.375 -332.6875 26.5625 switchstyle JUMP_CUT

if
	8118:   not actor $TONI_CIPRIANI dead 
then
	01B9: set_actor $TONI_CIPRIANI armed_weapon_to WEAPONTYPE_UNARMED
	022D: set_actor $TONI_CIPRIANI to_look_at_player $PLAYER_CHAR 
	022E: set_player $PLAYER_CHAR to_look_at_actor $TONI_CIPRIANI
end

0164: disable_marker $JOEY4_CAR_MARKER

03CF: load_wav 'J4_D'

while 83D0: not wav_loaded
	wait 0 ms
end

03D1: play_wav 
00BC: print_now 'JM4_4' duration 4000 ms flag 1  // The Triads think they can mess with me, the triads, with ME!

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

03CF: load_wav 'J4_E'

while 83D0: not wav_loaded
	wait 0 ms
end

03D1: play_wav 
00BC: print_now 'JM4_5' duration 5000 ms flag 1  // Drop by later and we'll give them something to launder, their own blood stained clothes!

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

03CF: load_wav 'J4_F'

while 83D0: not wav_loaded
	wait 0 ms
end

03D1: play_wav 

while 83D2:   not wav_ended
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
end //while

gosub @CHECK_TONI_STATUS_JOEY4

if
	8118:   not actor $TONI_CIPRIANI dead 
then
	0319: set_actor $TONI_CIPRIANI running 0 
	01D3: actor $TONI_CIPRIANI leave_car $TONIS_RIDE 
	022F: set_actor $TONI_CIPRIANI stop_looking 
	0230: set_player $PLAYER_CHAR stop_looking
end

while 00DB:   is_char_in_car $TONI_CIPRIANI car $TONIS_RIDE
	wait 0 ms
	gosub @CHECK_TONI_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
end //while

gosub @CHECK_JUST_TONI_STATUS_JOEY4

0006: 17@ = 0 
0395: clear_area 1 at 1219.375 -324.375 range 26.0625 2.0 
0211: actor $TONI_CIPRIANI walk_to 1219.375 -324.375

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if and
		0019:   17@ > 10000
		8118:   not actor $TONI_CIPRIANI dead
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 1219.375 -324.375 -100.0
	end
end //while

gosub @CHECK_JUST_TONI_STATUS_JOEY4

0006: 17@ = 0 
0395: clear_area 1 at 1219.5 -315.375 range 29.875 2.0 
0211: actor $TONI_CIPRIANI walk_to 1219.5 -318.5625 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 3000 duration 7000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 3000 

while 8126:   not actor $TONI_CIPRIANI walking
	wait 0 ms
	gosub @CHECK_JUST_TONI_STATUS_JOEY4
	gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
	gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	if and
		0019:   17@ > 10000
		8118:   not actor $TONI_CIPRIANI dead
	then
		00A1: set_char_coordinates $TONI_CIPRIANI to 1219.5 -318.5625 28.375 
	end
end //while

02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
02EB: restore_camera_jumpcut 
009B: delete_char $TONI_CIPRIANI

goto @MISSION_PASSED_JOEY4

/////////////////////////////////////////

:CHECK_VEHICLE_REPAIR_JOEY4
if
	8185:   not car $TONIS_RIDE health >= 900 
then
	00BC: print_now 'JM4_6' duration 2500 ms flag 1  // Hey watch the car! I said no fancy crap.
	03D1: play_wav 
	00BD: print_soon 'JM1_4' duration 5000 ms flag 2  // ~g~You're trashing the vehicle! Get it repaired!
	0164: disable_marker $JOEY4_LAUNDRY_MARKER 
	02A8: $JOEY4_SPRAYSHOP_MARKER = create_marker RADAR_SPRITE_SPRAY at 924.0 -361.0 10.0 
	03BC: $JOEY4_SPRAYSHOP_SPHERE = create_sphere 925.35 -360.5 10.8 radius 3.5 
	while 8185:   not car $TONIS_RIDE health >= 950 
		wait 0 ms
		gosub @CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
		gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
	end
	03BD: destroy_sphere $JOEY4_SPRAYSHOP_SPHERE 
	0164: disable_marker $JOEY4_SPRAYSHOP_MARKER 
	018A: $JOEY4_LAUNDRY_MARKER = create_checkpoint_at 843.0 -660.0 -100.0 
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_JOEY4
if
	0119:   car $TONIS_RIDE wrecked 
then
	00BC: print_now 'JM4_8' duration 5000 ms flag 1  // ~r~Toni's been wasted!
	goto @MISSION_FAILED_JOEY4
end
gosub @CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
return

/////////////////////////////////////////

:CHECK_SIMPLE_VEHICLE_STATUS_JOEY4
if
	0119:   car $TONIS_RIDE wrecked 
then
	goto @MISSION_FAILED_JOEY4
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_FLIPPED_STATUS_JOEY4
if and
	01F4:   car $TONIS_RIDE flipped 
	01C1:   car $TONIS_RIDE stopped
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_JOEY4
end
return

/////////////////////////////////////////

:CHECK_TONI_STATUS_JOEY4
if or
	0119:   car $TONIS_RIDE wrecked 
	0118:   actor $TONI_CIPRIANI dead
then
	00BC: print_now 'JM4_8' duration 5000 ms flag 1  // ~r~Toni's been wasted!
	goto @MISSION_FAILED_JOEY4
end
return

/////////////////////////////////////////

:CHECK_JUST_TONI_STATUS_JOEY4
if
	0118:   actor $TONI_CIPRIANI dead
then
	00BC: print_now 'JM4_8' duration 5000 ms flag 1  // ~r~Toni's been wasted!
	goto @MISSION_FAILED_JOEY4
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_JOEY4
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $TONIS_RIDE
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM4 == 0
then
	0186: $JOEY4_CAR_MARKER = create_marker_above_car $TONIS_RIDE 
	0004: $BLOB_FLAG = 0 
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		0164: disable_marker $JOEY4_LAUNDRY_MARKER
	else
		0164: disable_marker $JOEY4_MOMMAS_MARKER 
	end
	00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM4 = 1 
end
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $TONIS_RIDE 
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM4 == 1
then
	0004: $BLOB_FLAG = 1 
	0164: disable_marker $JOEY4_CAR_MARKER
	if
		0038: $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		018A: $JOEY4_LAUNDRY_MARKER = create_checkpoint_at 843.0 -660.0 -100.0 
	else
		018A: $JOEY4_MOMMAS_MARKER = create_checkpoint_at 1216.75 -327.5625 -100.0
	end
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM4 = 0
end
return


/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_JOEY4
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_JOEY4

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_JOEY4
0004: $CIPRIANIS_CHAUFFEUR_COMPLETED = 1 
0318: set_latest_mission_passed 'JM4'  // 'CIPRIANI'S CHAUFFEUR'
030C: set_mission_points += 1 
02A7: $TONI_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_TONY at 1219.563 -321.0 26.375 
004F: create_thread @TONI_MISSION1_LOOP
0164: disable_marker $JOEY_MISSION_MARKER   
goto @MISSION_END_JOEY4

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_JOEY4
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_JOEY = 0 
0164: disable_marker $JOEY4_LAUNDRY_MARKER 
0164: disable_marker $JOEY4_CAR_MARKER 
0164: disable_marker $JOEY4_MOMMAS_MARKER 
0249: release_model #MAFIA 
0249: release_model #GANG03 
0249: release_model #GANG04 
0249: release_model #BUS
022A: switch_ped_roads_on 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
01E7: switch_roads_on 824.875 -633.75 13.0 to 845.25 -693.75 18.0 
0296: unload_special_actor 2 
014C: set_parked_car_generator $GEN_CAR14 cars_to_generate_to 101 
034F: destroy_actor_with_fade $TONI_CIPRIANI 
03C7: set_sensitivity_to_crime 1.0
00D8: mission_has_finished
return


////////////////////////////////////////////////////////////////////////////////////////////



