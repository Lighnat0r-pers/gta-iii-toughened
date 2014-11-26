// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *************************************Asuka mission 3************************************* 
// *************************************Boat Spy thing**************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M20_PAPARAZZIPURGE

gosub @MISSION_START_ASUKA3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_ASUKA3
end

:MISSION_END_ASUKA3
gosub @MISSION_CLEANUP_ASUKA3
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_ASUKA3

0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA1 = 1 
0004: $HELP1_DISPLAYED = 0 
0004: $HELP2_DISPLAYED = 0 
03A4: name_thread 'ASUKA3' 
0001: wait 0 ms 
0004: $BEEN_IN_COP_BOAT_BEFORE = 0 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'NOTE' 
0247: request_model #MALE01 
0247: request_model #REEFER 
0247: request_model #SPEEDER 
0247: request_model #PREDATOR 
0247: request_model #STALLION 
0247: request_model #CONDO_IVY 
0247: request_model #KMRICNDO01 
038B: load_all_models_now 


while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CONDO_IVY available 
		8248:   not model #KMRICNDO01 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A2_PP' 
0244: set_cutscene_pos 523.0625 -636.9375 15.5625 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_NOTE 'NOTE' 
0395: clear_area 1 at 523.5625 -639.375 range 16.5625 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 523.5625 -639.375 16.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   3406 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM3_A' duration 10000 ms flag 1  // A reporter has been nosing around.
while 001A:   5677 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM3_B' duration 10000 ms flag 1  // Maria and I have taken a little holiday together until you can get rid of this perverted voyeur.
while 001A:   11354 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM3_C' duration 10000 ms flag 1  // He's probably out in the bay as you read this! Steal a police boat, and sink his career!
while 001A:   16000 > $CUT_SCENE_TIME
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
0001: wait 1000 ms 
016A: fade 1 for 1500 ms 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CONDO_IVY 
0249: release_model #KMRICNDO01 



while true
	if or
		8248:   not model #MALE01 available 
		8248:   not model #SPEEDER available 
		8248:   not model #STALLION available 
		8248:   not model #PREDATOR available 
		8248:   not model #REEFER available 
	jf break
	wait 0 ms
end //while

01B6: set_weather WEATHER_FOGGY
0395: clear_area 1 at 640.0 -608.0 range 0.0 6.0 
00A5: $SPY_BOAT = create_car #SPEEDER at 612.0 -597.0 0.0 
0175: set_car $SPY_BOAT z_angle_to 0.0 
02AA: set_car $SPY_BOAT immune_to_nonplayer 1 
0224: set_car $SPY_BOAT health_to 3000 
03AB: set_car $SPY_BOAT strong 1 
0129: $SPY_BLOKE = create_actor PEDTYPE_CIVMALE #MALE01 in_car $SPY_BOAT driverseat 
0395: clear_area 1 at 568.0 -686.0 range 0.0 6.0 
00A5: $ASUKA_BOAT = create_car #REEFER at 568.0 -686.0 0.0 
0175: set_car $ASUKA_BOAT z_angle_to 180.0 
0395: clear_area 1 at 554.75 -767.5625 range 0.0 6.0 
00A5: $COP_BOAT = create_car #PREDATOR at 554.75 -767.5625 0.0 
0186: $BLIP1_AS3 = create_marker_above_car $COP_BOAT 
if
	8118:   not actor $SPY_BLOKE dead 
then
	0187: $BLIP2_AS3 = create_marker_above_actor $SPY_BLOKE 
	018B: show_on_radar $BLIP2_AS3 MARKER_ONLY 
end

0001: wait 1500 ms 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
015F: set_camera_position 526.0 -643.25 19.5625 rotation 0.0 0.0 0.0 
if
	8119:   not car $SPY_BOAT wrecked 
then
	0158: camera_on_vehicle $SPY_BOAT mode FIXED switchstyle JUMP_CUT
end

0001: wait 3000 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
015A: restore_camera 

if
	8119:   not car $SPY_BOAT wrecked 
then
	0227: $BOAT_HEALTH = car $SPY_BOAT health 
	03C4: set_status_text_to $BOAT_HEALTH 1 'DAM'  // DAMAGE:
	gosub @BOAT_HEALTH
end

0006: 17@ = 0 

while true
	if and
		81FC:   not player $PLAYER_CHAR near_car $SPY_BOAT radius 55.0 55.0 unknown 0 
		0185:   car $SPY_BOAT health >= 2999 
	jf break
	wait 0 ms
	if
		0119:   car $SPY_BOAT wrecked 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	gosub @CHECK_BOATS_DEAD
	if
		8119:   not car $SPY_BOAT wrecked 
	then
		gosub @BOAT_HEALTH
	end
end //while

if
	8119:   not car $SPY_BOAT wrecked 
then
	02AA: set_car $SPY_BOAT immune_to_nonplayer 0 
	02DB: set_boat $SPY_BOAT speed_to 48.0 
end

wait 0 ms


//LOCATION1
0005: $ASUKA3_LOCATION_X = 744.75
0005: $ASUKA3_LOCATION_Y = -350.0625
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION2
0005: $ASUKA3_LOCATION_X = 728.875
0005: $ASUKA3_LOCATION_Y = -133.6875
if
	8119:   not car $SPY_BOAT wrecked 
then
	02DB: set_boat $SPY_BOAT speed_to 45.0 
end
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION3
0005: $ASUKA3_LOCATION_X = 635.5
0005: $ASUKA3_LOCATION_Y = 24.6875
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION4
0005: $ASUKA3_LOCATION_X = 746.5625
0005: $ASUKA3_LOCATION_Y = 252.875
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION5
0005: $ASUKA3_LOCATION_X = 872.0625
0005: $ASUKA3_LOCATION_Y = 335.875
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION6
0005: $ASUKA3_LOCATION_X = 1064.5
0005: $ASUKA3_LOCATION_Y = 180.75
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION7
0005: $ASUKA3_LOCATION_X = 1262.0
0005: $ASUKA3_LOCATION_Y = 166.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION8
0005: $ASUKA3_LOCATION_X = 1566.0
0005: $ASUKA3_LOCATION_Y = 52.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION9
0005: $ASUKA3_LOCATION_X = 1595.0
0005: $ASUKA3_LOCATION_Y = -154.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION10
0005: $ASUKA3_LOCATION_X = 1555.0
0005: $ASUKA3_LOCATION_Y = -299.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION11
0005: $ASUKA3_LOCATION_X = 1617.0
0005: $ASUKA3_LOCATION_Y = -600.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION12
0005: $ASUKA3_LOCATION_X = 1617.0
0005: $ASUKA3_LOCATION_Y = -762.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION13
0005: $ASUKA3_LOCATION_X = 1637.0
0005: $ASUKA3_LOCATION_Y = -950.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION14
0005: $ASUKA3_LOCATION_X = 1535.0
0005: $ASUKA3_LOCATION_Y = -1173.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION15
0005: $ASUKA3_LOCATION_X = 1268.0
0005: $ASUKA3_LOCATION_Y = -1273.0
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION16
0005: $ASUKA3_LOCATION_X = 938.0625
0005: $ASUKA3_LOCATION_Y = -1226.375
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION17
0005: $ASUKA3_LOCATION_X = 618.0
0005: $ASUKA3_LOCATION_Y = -1083.0
if
	8119:   not car $SPY_BOAT wrecked 
then
	02DB: set_boat $SPY_BOAT speed_to 45.0 
end
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION18
0005: $ASUKA3_LOCATION_X = 560.0
0005: $ASUKA3_LOCATION_Y = -899.0
if
	8119:   not car $SPY_BOAT wrecked 
then
	02DB: set_boat $SPY_BOAT speed_to 35.0 
end
gosub @LOCATION_LOOP_BOAT_ASUKA3

//LOCATION19
0005: $ASUKA3_LOCATION_X = 548.0
0005: $ASUKA3_LOCATION_Y = -795.0
if
	8119:   not car $SPY_BOAT wrecked 
then
	02DB: set_boat $SPY_BOAT speed_to 20.0 
end
gosub @LOCATION_LOOP_BOAT_ASUKA3

wait 1000 ms

if and
	8119:   not car $SPY_BOAT wrecked 
	8118:   not actor $SPY_BLOKE dead 
then
	02D4: boat_stop $SPY_BOAT 
	0323: enable_boat $SPY_BOAT anchor 1 
	0362: remove_actor $SPY_BLOKE from_car_and_place_at 547.25 -778.375 -100.0 
	0151: remove_status_text $BOAT_HEALTH
end

00A5: $SPY_CAR = create_car #STALLION at 499.6875 -734.375 -100.0 
0175: set_car $SPY_CAR z_angle_to 90.0 
0319: set_actor $SPY_BLOKE running 1 
0239: actor $SPY_BLOKE run_to 510.0 -775.5625

while 8126:   not actor $SPY_BLOKE walking 
	wait 0 ms
	if
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	gosub @CHECK_BOATS_DEAD
end //while

0239: actor $SPY_BLOKE run_to 505.1875 -751.0625 

while 8126:   not actor $SPY_BLOKE walking 
	wait 0 ms
	if
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	gosub @CHECK_BOATS_DEAD
end //while

0239: actor $SPY_BLOKE run_to 501.0625 -749.5 

while 8126:   not actor $SPY_BLOKE walking 
	wait 0 ms
	if
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	gosub @CHECK_BOATS_DEAD
end //while

if
	8119:   not car $SPY_CAR wrecked 
then
	01D5: actor $SPY_BLOKE go_to_and_drive_car $SPY_CAR 
end

while 80DB:   not is_char_in_car $SPY_BLOKE car $SPY_CAR 
	wait 0 ms
	if
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	if and
		0119:   car $SPY_CAR wrecked 
		8118:   not actor $SPY_BLOKE dead 
	then
		goto @IS_HE_DEAD_YET
	end
	gosub @CHECK_BOATS_DEAD
end //while

if
	8119:   not car $SPY_CAR wrecked 
then
	02C2: car $SPY_CAR drive_to_point 463.0 -727.375 16.0625 
	00AF: set_car_mission $SPY_CAR to MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
	00AE: set_car_driving_style $SPY_CAR to 1 
	00AD: set_car_cruise_speed $SPY_CAR to 15.0 
end

while 81AF:   not car $SPY_CAR 0 463.0 -727.375 16.0625 radius 3.0 3.0 3.0 
	wait 0 ms
	if or
		0119:   car $SPY_CAR wrecked
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	if
		80DB:   not is_char_in_car $SPY_BLOKE car $SPY_CAR 
	then
		goto @IS_HE_DEAD_YET
	end

	if
		8119:   not car $SPY_CAR wrecked
	then
		if
			81FC:   not player $PLAYER_CHAR near_car $SPY_CAR radius 160.0 160.0 unknown 0 
		then
			00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
			if and
				8119:   not car $SPY_CAR wrecked 
				8118:   not actor $SPY_BLOKE dead
			then
				00A6: delete_car $SPY_CAR 
				009B: delete_char $SPY_BLOKE 
			end
			goto @MISSION_FAILED_ASUKA3
		end
	end
	gosub @CHECK_BOATS_DEAD
end //while

//LOCATION1 CAR
0005: $ASUKA3_LOCATION_X = 463.0
0005: $ASUKA3_LOCATION_Y = -727.375
if
	8119:   not car $SPY_CAR wrecked 
then
	02C2: car $SPY_CAR drive_to_point $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 16.0625 
	00AF: set_car_mission $SPY_CAR to MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
	00AE: set_car_driving_style $SPY_CAR to 1 
	00AD: set_car_cruise_speed $SPY_CAR to 15.0 
end
gosub @LOCATION_LOOP_CAR_ASUKA3

//LOCATION2 CAR
0005: $ASUKA3_LOCATION_X = 456.0
0005: $ASUKA3_LOCATION_Y = -707.0625
if
	8119:   not car $SPY_CAR wrecked 
then
	02C2: car $SPY_CAR drive_to_point $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 16.0625 
	00AF: set_car_mission $SPY_CAR to MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
end
gosub @LOCATION_LOOP_CAR_ASUKA3

//LOCATION3 CAR
0005: $ASUKA3_LOCATION_X = 459.0
0005: $ASUKA3_LOCATION_Y = -678.0625
if
	8119:   not car $SPY_CAR wrecked 
then
	02C2: car $SPY_CAR drive_to_point $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 16.0625 
	00AF: set_car_mission $SPY_CAR to MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
end
gosub @LOCATION_LOOP_CAR_ASUKA3

if
	8119:   not car $SPY_CAR wrecked 
then
	00A8: car_wander_randomly $SPY_CAR
	00AE: set_car_driving_style $SPY_CAR to DRIVINGMODE_AVOIDCARS 
	00AD: set_car_cruise_speed $SPY_CAR to 25.0 
end

while 8118:   not actor $SPY_BLOKE dead 
	wait 0 ms
	if
		8118:   not actor $SPY_BLOKE dead 
	then
		if
			80E9:   not player $PLAYER_CHAR 0 $SPY_BLOKE radius 160.0 160.0 
		then
			00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
			if
				8118:   not actor $SPY_BLOKE dead
			then
				009B: delete_char $SPY_BLOKE 
			end
			goto @MISSION_FAILED_ASUKA3
		end
	end
	if
		0119:   car $SPY_CAR wrecked
	then
		goto @MISSION_PASSED_ASUKA3
	end
	if
		80DB:   not is_char_in_car $SPY_BLOKE car $SPY_CAR 
	then
		goto @IS_HE_DEAD_YET
	end
	gosub @CHECK_BOATS_DEAD
end //while

:IS_HE_DEAD_YET
01D0: actor $SPY_BLOKE avoid_player $PLAYER_CHAR 
while 8118:   not actor $SPY_BLOKE dead 
	wait 0 ms
	if
		8118:   not actor $SPY_BLOKE dead 
	then
		if
			80E9:   not player $PLAYER_CHAR 0 $SPY_BLOKE radius 160.0 160.0 
		then
			00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
			if
				8118:   not actor $SPY_BLOKE dead
			then
				009B: delete_char $SPY_BLOKE 
			end
			goto @MISSION_FAILED_ASUKA3
		end
	end
	gosub @CHECK_BOATS_DEAD
end //while

goto @MISSION_PASSED_ASUKA3

/////////////////////////////////////////

:LOCATION_LOOP_CAR_ASUKA3
while 81AF:   not car $SPY_CAR 0 $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 16.0625 radius 3.0 3.0 3.0 
	wait 0 ms
	if or
		0119:   car $SPY_CAR wrecked
		0118:   actor $SPY_BLOKE dead 
	then
		goto @MISSION_PASSED_ASUKA3
	end
	if
		80DB:   not is_char_in_car $SPY_BLOKE car $SPY_CAR 
	then
		goto @IS_HE_DEAD_YET
	end

	if
		8119:   not car $SPY_CAR wrecked
	then
		if
			81FC:   not player $PLAYER_CHAR near_car $SPY_CAR radius 160.0 160.0 unknown 0 
		then
			00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
			if and
				8119:   not car $SPY_CAR wrecked 
				8118:   not actor $SPY_BLOKE dead
			then
				00A6: delete_car $SPY_CAR 
				009B: delete_char $SPY_BLOKE 
			end
			goto @MISSION_FAILED_ASUKA3
		end
	end
	gosub @CHECK_BOATS_DEAD
end //while
return

/////////////////////////////////////////

:LOCATION_LOOP_BOAT_ASUKA3
if
	8119:   not car $SPY_BOAT wrecked 
then
	02D3: boat $SPY_BOAT drive_to $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 0.0 
end

while 81AF:   not car $SPY_BOAT 0  $ASUKA3_LOCATION_X $ASUKA3_LOCATION_Y 0.0 radius 6.0 6.0 6.0 
	wait 0 ms
	if
		0119:   car $SPY_BOAT wrecked 
	then
		goto @MISSION_PASSED_ASUKA3
	end

	if
		8119:   not car $SPY_BOAT wrecked
	then
		if
			81FC:   not player $PLAYER_CHAR near_car $SPY_BOAT radius 160.0 160.0 unknown 0 
		then
			00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
			if and
				8119:   not car $SPY_BOAT wrecked 
				8118:   not actor $SPY_BLOKE dead
			then
				00A6: delete_car $SPY_BOAT 
				009B: delete_char $SPY_BLOKE 
			end
			goto @MISSION_FAILED_ASUKA3
		end
	end
	gosub @CHECK_BOATS_DEAD
	if
		8119:   not car $SPY_BOAT wrecked 
	then
		gosub @BOAT_HEALTH
	end

end //while
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_ASUKA3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_ASUKA3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_ASUKA3
0151: remove_status_text $BOAT_HEALTH 
0004: $PAPARAZZI_PURGE_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 10000 
0318: set_latest_mission_passed 'AM3'  // 'PAPARAZZI PURGE'
030C: set_mission_points += 1 
004F: create_thread @ASUKA_MISSION4_LOOP 
goto @MISSION_END_ASUKA3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_ASUKA3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA1 = 0 
01B7: release_weather
0164: disable_marker $BLIP1_AS3 
0164: disable_marker $BLIP2_AS3 
0249: release_model #MALE01 
0249: release_model #SPEEDER 
0249: release_model #REEFER 
0249: release_model #PREDATOR 
0249: release_model #STALLION 
0151: remove_status_text $BOAT_HEALTH 
00D8: mission_has_finished 
return

/////////////////////////////////////////

:BOAT_HEALTH
0227: $BOAT_HEALTH = car $SPY_BOAT health 
0004: $BOAT_HEALTH2 = 3000 
0060: $BOAT_HEALTH2 -= $BOAT_HEALTH 
if
	0018:   $BOAT_HEALTH2 > 3000 
then
	0004: $BOAT_HEALTH2 = 3000 
end
0084: $BOAT_HEALTH = $BOAT_HEALTH2 
0014: $BOAT_HEALTH /= 30 
return 

/////////////////////////////////////////

:CHECK_BOATS_DEAD
if
	8119:   not car $COP_BOAT wrecked 
then
	if and
		00DC:   is_player_in_car $PLAYER_CHAR car $COP_BOAT 
		0038:   $BEEN_IN_COP_BOAT_BEFORE == 0 
	then
		0164: disable_marker $BLIP1_AS3 
		0004: $BEEN_IN_COP_BOAT_BEFORE = 1 
	end
else
	if
		0038:   $BEEN_IN_COP_BOAT_BEFORE == 0 
	then
		0164: disable_marker $BLIP1_AS3 
		0004: $BEEN_IN_COP_BOAT_BEFORE = 1 
	end
end
return
