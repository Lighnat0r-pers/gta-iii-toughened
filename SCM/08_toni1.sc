// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 1****************************************
// ***************************************Laundry day*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

:M30_TAKINGOUTTHELAUNDRY

gosub @MISSION_START_TONI1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_TONI1
end

:MISSION_END_TONI1
gosub @MISSION_CLEANUP_TONI1       
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_TONI1
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_TONI = 1 
03A4: name_thread 'TONI1' 
0001: wait 0 ms 
0004: $COUNTER1_TONI1 = 0 
0004: $DEAD_VAN1 = 0 
0004: $DEAD_VAN2 = 0 
0004: $DEAD_VAN3 = 0 
0004: $DEAD_VAN4 = 0 
0004: $IN_VAN1 = 0 
0004: $IN_VAN2 = 0 
0004: $IN_VAN3 = 0 
0004: $IN_VAN4 = 0 

023C: load_special_actor 'TONY' as 1 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'TONYH' 
0247: request_model #IND_NEWRIZZOS 
038B: load_all_models_now

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #IND_NEWRIZZOS available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'T1_TOL' 
0244: set_cutscene_pos 1218.375 -314.5 28.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_TONY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_TONY 'TONY' 
02F4: create_cutscene_actor $TONY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_TONY 
02F5: set_head_anim $TONY_CSHEAD 'TONY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
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

while 001A:   171 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_A' duration 10000 ms flag 1  // ~w~Take a seat kid, take a god damned seat.
while 001A:   3769 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_B' duration 10000 ms flag 1  // ~w~So the laundry won't pay any protection eh?
while 001A:   5825 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_C' duration 10000 ms flag 1  // ~w~The Triads think they can mess with me?
while 001A:   8026 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_D' duration 10000 ms flag 1  // ~w~Let's teach these would be tough guys what it means to be a tough guy.
while 001A:   11500 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints
while 001A:   15961 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_G' duration 10000 ms flag 1  // ~w~Sorry Ma. Yes Ma.
while 001A:   21005 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_H' duration 10000 ms flag 1  // ~w~I want you to destroy their laundry vans
while 001A:   22997 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_I' duration 10000 ms flag 1  // ~w~and mangle any triad gimp that gets in your way.
while 001A:   27589 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM1_J' duration 10000 ms flag 1  // ~w~8-Ball can supply you with what you're gonna need.
while 001A:   29796 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints
while 001A:   31666 > $CUT_SCENE_TIME
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

0247: request_model #MRWONGS 
0247: request_model #CT_MAN1 
03AD: set_rubbish 1 
02EA: end_cutscene 
03C8: set_camera_directly_before_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #IND_NEWRIZZOS 

while true
	if or
		8248:   not model #MRWONGS available 
		8248:   not model #CT_MAN1 available
	jf break
	wait 0 ms
end //while
	 
// START OF MISSION

014C: set_parked_car_generator $GEN_CAR31 cars_to_generate_to 0 

032B: $FREE_PISTOL = create_weapon_pickup #COLT45 PICKUP_ONCE ammo 10 at 1278.75 -81.5 15.0625 
03DD: pickup $FREE_PISTOL show_on_radar RADAR_SPRITE_WEAPON $PISTOL_BLIP 

00A5:$T1_TRIAD_VAN1 = create_car #MRWONGS at 854.0 -778.0 -100.0
0129: $VANMAN1 = create_actor PEDTYPE_CIVMALE #CT_MAN1 in_car $T1_TRIAD_VAN1 driverseat
0186: $BLIP1_VAN1 = create_marker_above_car $T1_TRIAD_VAN1 
00AD: set_car_cruise_speed $T1_TRIAD_VAN1 to 40.0 
00AE: set_car_driving_style $T1_TRIAD_VAN1 to DRIVINGMODE_AVOIDCARS
02AA: set_car $T1_TRIAD_VAN1 immune_to_nonplayer 1 
0243: set_actor $VANMAN1 ped_stats_to PEDSTAT_TOUGH_GUY

00A5: $T1_TRIAD_VAN2 = create_car #MRWONGS at 1020.0 -677.0 -100.0
0129: $VANMAN2 = create_actor PEDTYPE_CIVMALE #CT_MAN1 in_car $T1_TRIAD_VAN2 driverseat
0186: $BLIP2_VAN2 = create_marker_above_car $T1_TRIAD_VAN2 
00AD: set_car_cruise_speed $T1_TRIAD_VAN2 to 40.0 
00AE: set_car_driving_style $T1_TRIAD_VAN2 to DRIVINGMODE_AVOIDCARS
02AA: set_car $T1_TRIAD_VAN2 immune_to_nonplayer 1 
0243: set_actor $VANMAN2 ped_stats_to PEDSTAT_GEEK_GUY

00A5: $T1_TRIAD_VAN3 = create_car #MRWONGS at 904.0 -579.0 -100.0
0129: $VANMAN3 = create_actor PEDTYPE_CIVMALE #CT_MAN1 in_car $T1_TRIAD_VAN3 driverseat
0186: $BLIP3_VAN3 = create_marker_above_car $T1_TRIAD_VAN3 
00AD: set_car_cruise_speed $T1_TRIAD_VAN3 to 40.0 
00AE: set_car_driving_style $T1_TRIAD_VAN3 to DRIVINGMODE_AVOIDCARS
02AA: set_car $T1_TRIAD_VAN3 immune_to_nonplayer 1 
0243: set_actor $VANMAN3 ped_stats_to PEDSTAT_TOUGH_GUY

00A5: $T1_TRIAD_VAN4 = create_car #MRWONGS at 996.0 -463.0 14.0
0129: $VANMAN4 = create_actor PEDTYPE_CIVMALE #CT_MAN1 in_car $T1_TRIAD_VAN4 driverseat
0186: $BLIP4_VAN4 = create_marker_above_car $T1_TRIAD_VAN4 
00AD: set_car_cruise_speed $T1_TRIAD_VAN4 to 40.0 
00AE: set_car_driving_style $T1_TRIAD_VAN4 to DRIVINGMODE_AVOIDCARS
02AA: set_car $T1_TRIAD_VAN4 immune_to_nonplayer 1 
0243: set_actor $VANMAN4 ped_stats_to PEDSTAT_GEEK_GUY

0004: $VANS_AMOUNT_TONI1 = 4

while 803A:   not  $COUNTER1_TONI1 == $VANS_AMOUNT_TONI1
	wait 0 ms

	// CHECK VAN1
	0084: $TEMP_VAN_TONI1 = $T1_TRIAD_VAN1
	0084: $TEMP_VANMAN_TONI1 = $VANMAN1
	0084: $TEMP_BLIP_TONI1 = $BLIP1_VAN1
	0084: $TEMP_DEAD_VAN = $DEAD_VAN1
	0084: $TEMP_IN_VAN = $IN_VAN1
	gosub @CHECK_VAN_STUFF_TONI1
	0084: $DEAD_VAN1 = $TEMP_DEAD_VAN
	0084: $IN_VAN1 = $TEMP_IN_VAN

	// CHECK VAN2
	0084: $TEMP_VAN_TONI1 = $T1_TRIAD_VAN2
	0084: $TEMP_VANMAN_TONI1 = $VANMAN2
	0084: $TEMP_BLIP_TONI1 = $BLIP2_VAN2
	0084: $TEMP_DEAD_VAN = $DEAD_VAN2
	0084: $TEMP_IN_VAN = $IN_VAN2
	gosub @CHECK_VAN_STUFF_TONI1
	0084: $DEAD_VAN2 = $TEMP_DEAD_VAN
	0084: $IN_VAN2 = $TEMP_IN_VAN

	// CHECK VAN3
	0084: $TEMP_VAN_TONI1 = $T1_TRIAD_VAN3
	0084: $TEMP_VANMAN_TONI1 = $VANMAN3
	0084: $TEMP_BLIP_TONI1 = $BLIP3_VAN3
	0084: $TEMP_DEAD_VAN = $DEAD_VAN3
	0084: $TEMP_IN_VAN = $IN_VAN3
	gosub @CHECK_VAN_STUFF_TONI1
	0084: $DEAD_VAN3 = $TEMP_DEAD_VAN
	0084: $IN_VAN3 = $TEMP_IN_VAN

	// CHECK VAN4
	0084: $TEMP_VAN_TONI1 = $T1_TRIAD_VAN4
	0084: $TEMP_VANMAN_TONI1 = $VANMAN4
	0084: $TEMP_BLIP_TONI1 = $BLIP4_VAN4
	0084: $TEMP_DEAD_VAN = $DEAD_VAN4
	0084: $TEMP_IN_VAN = $IN_VAN4
	gosub @CHECK_VAN_STUFF_TONI1
	0084: $DEAD_VAN4 = $TEMP_DEAD_VAN
	0084: $IN_VAN4 = $TEMP_IN_VAN

end //while

goto @MISSION_PASSED_TONI1

/////////////////////////////////////////

:CHECK_VAN_STUFF_TONI1
// CHECK VAN
if and
	0119:   car $TEMP_VAN_TONI1 wrecked 
	0038:   $TEMP_DEAD_VAN == 0
then
	0164: disable_marker $TEMP_BLIP_TONI1 
	0004: $TEMP_DEAD_VAN = 1 
	0008: $COUNTER1_TONI1 += 1
end
if and
	8119:   not car $TEMP_VAN_TONI1 wrecked
	8118:   not actor $TEMP_VANMAN_TONI1 dead
then
	if or
		8185:   not car $TEMP_VAN_TONI1 health >= 999
		80DB:   not is_char_in_car $TEMP_VANMAN_TONI1 car $TEMP_VAN_TONI1
	then
		02AA: set_car $TEMP_VAN_TONI1 immune_to_nonplayer 0
	end
end
if
	8119:   not car $TEMP_VAN_TONI1 wrecked
then
	if and
		00DC:   is_player_in_car $PLAYER_CHAR car $TEMP_VAN_TONI1 
		0038:   $TEMP_IN_VAN == 0
	then
		02AA: set_car $TEMP_VAN_TONI1 immune_to_nonplayer 0 
		0004: $TEMP_IN_VAN = 1
	end
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_TONI1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_TONI1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_TONI1
0004: $TAKING_OUT_THE_LAUNDRY_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 20000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 20000 
0318: set_latest_mission_passed 'TM1'  // 'TAKING OUT THE LAUNDRY'
030C: set_mission_points += 1 
004F: create_thread @TONI_MISSION2_LOOP
004F: create_thread @UZI_MESSAGE 
goto @MISSION_END_TONI1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_TONI1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_TONI = 0 
0164: disable_marker $BLIP1_VAN1 
0164: disable_marker $BLIP2_VAN2 
0164: disable_marker $BLIP3_VAN3
0164: disable_marker $BLIP4_VAN4
0164: disable_marker $PISTOL_BLIP 
0215: destroy_pickup $FREE_PISTOL 
014C: set_parked_car_generator $GEN_CAR31 cars_to_generate_to 101 
0249: release_model #MRWONGS 
0249: release_model #CT_MAN1 
00D8: mission_has_finished
return
