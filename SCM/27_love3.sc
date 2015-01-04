// *****************************************************************************************
// *********************************    Love mission 3   *********************************** 
// ********************************* A Drop in the Ocean ***********************************
// *****************************************************************************************
// *** The Player must pick up several packages that will be dropped from a Cessna into  ***
// *** the bay that night. The player will use a boat to collect them. It is a decoy	 ***
// *** (player does not know this at this time) so the police are aware of them. As soon ***
// *** has the player has picked up the first package the police chopper will be on him. ***
// *** Once the player has collected them all he must get them back to land and to his 	 ***
// *** hideout in a car with the ensuing police chase. 					 ***
// *****************************************************************************************

// Mission start stuff

:M27_ADROPINTHEOCEAN

gosub @MISSION_START_LOVE3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LOVE3
end

:MISSION_END_LOVE3
gosub @MISSION_CLEANUP_LOVE3
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_LOVE3
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_LOVE = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'LOVE3' 
0004: $DRUG_CURRENT_TIMER = 0 
0004: $TEMPORARY_TIME_DRUG = 0 
0004: $LAST_DRUG_DROPPED_TIMER = 0 
0004: $PACKAGE_NUMBERS = 0 
0004: $PACKAGES_COLLECTED = 0 
0004: $POLICE_BOAT_FLAG = 0 
0004: $POLICE_RATING = 0 
0004: $PACKGE_01 = 0 
0004: $PACKGE_02 = 0 
0004: $PACKGE_03 = 0 
0004: $PACKGE_04 = 0 
0004: $PACKGE_05 = 0 
0004: $PACKGE_06 = 0 
0004: $COUNTER_DISPLAY_FLAG = 0 
0005: $PLANEX = 0.0 
0005: $PLANEY = 0.0 
0005: $PLANEZ = 0.0 
0004: $FRENZY_KILL_AMOUNT = 15
0004: $FRENZY_TIME = 90000
01F0: set_max_wanted_level_to 5
014C: set_parked_car_generator $COM_CAR13 cars_to_generate_to 0

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'LOVE2' as 1 
023C: load_special_actor 'OJG2' as 2 
02F3: load_object #CUTOBJ01 'LOVEH' 
0247: request_model #TSHRORCKGRDN 
0247: request_model #TSHRORCKGRDN_ALFAS 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #TSHRORCKGRDN available 
		8248:   not model #TSHRORCKGRDN_ALFAS available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'D3_ADO' 
0244: set_cutscene_pos 85.1875 -1532.875 243.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_LOVE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_LOVE 'LOVE2' 
02E5: $CS_OJG = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CS_OJG 'OJG2' 
02F4: create_cutscene_actor $LOVE_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_LOVE 
02F5: set_head_anim $LOVE_CSHEAD 'LOVE' 
0395: clear_area 1 at 82.4375 -1548.438 range 28.0 2.0 
0055: set_player_coordinates $PLAYER_CHAR to 82.4375 -1548.438 28.0 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 1500 ms 
03AF: set_streaming 1 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   12262 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE3_A' duration 5000 ms flag 1  // In these days of moral hypocrisy certain valuable commodities can be hard to import.
while 001A:   16652 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE3_B' duration 5000 ms flag 1  // On its approach to the airport tonight, a light aircraft will pass over the bay.
while 001A:   20065 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE3_C' duration 5000 ms flag 1  // It will drop several packages into the water.
while 001A:   22434 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE3_D' duration 5000 ms flag 1  // Make sure you pick them up before anyone else does.
while 001A:   25333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end


016A: fade 0 for 1500 ms

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

03AD: set_rubbish 1 
00BE: clear_prints 

while fading
	wait 0 ms
end

02EA: end_cutscene 
016A: fade 0 for 0 ms 
0247: request_model #DEADDODO 
0247: request_model #SPEEDER 
0247: request_model #PREDATOR 
038B: load_all_models_now 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 

while fading
	wait 0 ms
end

0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #TSHRORCKGRDN 
0249: release_model #TSHRORCKGRDN_ALFAS 

// ******************************************END OF CUTSCENE********************************

while true
	if or
		8248:   not model #DEADDODO available 
		8248:   not model #SPEEDER available 
		8248:   not model #PREDATOR available 
	jf break
	wait 0 ms
end //while

00A5: $PLAYERS_BOAT = create_car #SPEEDER at 837.0 -1115.563 -0.1875 
0175: set_car $PLAYERS_BOAT z_angle_to 140.0 
0186: $PLAYERS_BOAT_BLIP = create_marker_above_car $PLAYERS_BOAT 
00BC: print_now 'LOVE3_1' duration 5000 ms flag 1  // ~g~Get a ~r~boat~g~ and follow the ~y~plane~g~!
0358: start_drug_drop_off 

// Impossible if statement because reasons.
if
	0038:   $ONMISSION == 0
then
	018A: $PLANE_BLIP = create_checkpoint_at $PLANEX $PLANEY $PLANEZ 
end

wait 1000 ms 
0004: $PLANE_TIMER = 120000 
014E: start_timer_at $PLANE_TIMER 

:PLANE_DROP_LOOP
wait 0 ms
if
	0359:   drop_off_cessna_shot_down 
then
	00BC: print_now 'LOVE3_4' duration 5000 ms flag 1  // ~r~You destroyed the plane!!
	goto @MISSION_FAILED_LOVE3
end
if
	0038:   $PLANE_TIMER == 0 
then
	014F: stop_timer $PLANE_TIMER 
	00BC: print_now 'LOVE3_5' duration 5000 ms flag 1  // ~g~The plane is now in range.
	0004: $PLANE_TIMER = -1000 
end
if or
	00DE:   is_player_in_model $PLAYER_CHAR model #PREDATOR 
	00DE:   is_player_in_model $PLAYER_CHAR model #SPEEDER 
	00DE:   is_player_in_model $PLAYER_CHAR model #REEFER 
then
	0164: disable_marker $PLAYERS_BOAT_BLIP 
end

0164: disable_marker $PLANE_BLIP 

if
	001A:   6 > $PACKAGE_NUMBERS
then
	035A: find_drop_off_plane_coords $PLANEX $PLANEY $PLANEZ 
	0167: $PLANE_BLIP = create_marker_at $PLANEX $PLANEY $PLANEZ color 4 visibility 2 
	0168: show_on_radar $PLANE_BLIP 3 
	01BD: $DRUG_CURRENT_TIMER = current_time_in_ms 
	0084: $TEMPORARY_TIME_DRUG = $DRUG_CURRENT_TIMER 
	0060: $TEMPORARY_TIME_DRUG -= $LAST_DRUG_DROPPED_TIMER 
	if
		0018:   $TEMPORARY_TIME_DRUG > 7000 
	then
		01BD: $LAST_DRUG_DROPPED_TIMER = current_time_in_ms 
		if and
			0022:   750.0 > $PLANEX 
			0020:   $PLANEX > 615.0 
			0022:   650.0 > $PLANEY 
			0020:   $PLANEY > -1213.0 
		then
			if
				0038:   $PACKAGE_NUMBERS == 0 
			then
				035B: $FLOAT_PACKGE_01 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_1_X = $PLANEX 
				0086: $PACKAGE_1_Y = $PLANEY 
				0004: $PACKGE_01 = 1 
			end
			if
				0038:   $PACKAGE_NUMBERS == 1 
			then
				035B: $FLOAT_PACKGE_02 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_2_X = $PLANEX 
				0086: $PACKAGE_2_Y = $PLANEY 
				0004: $PACKGE_02 = 1 
			end
			if
				0038:   $PACKAGE_NUMBERS == 2 
			then
				035B: $FLOAT_PACKGE_03 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_3_X = $PLANEX 
				0086: $PACKAGE_3_Y = $PLANEY 
				0004: $PACKGE_03 = 1 
			end
			if
				0038:   $PACKAGE_NUMBERS == 3 
			then
				035B: $FLOAT_PACKGE_04 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_4_X = $PLANEX 
				0086: $PACKAGE_4_Y = $PLANEY 
				0004: $PACKGE_04 = 1 
			end
			if
				0038:   $PACKAGE_NUMBERS == 4 
			then
				035B: $FLOAT_PACKGE_05 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_5_X = $PLANEX 
				0086: $PACKAGE_5_Y = $PLANEY 
				0004: $PACKGE_05 = 1 
			end
			if
				0038:   $PACKAGE_NUMBERS == 5 
			then
				035B: $FLOAT_PACKGE_06 = create_drop_off_package $PLANEX $PLANEY $PLANEZ 
				0086: $PACKAGE_6_X = $PLANEX 
				0086: $PACKAGE_6_Y = $PLANEY 
				0004: $PACKGE_06 = 1 
			end
			0008: $PACKAGE_NUMBERS += 1 
		end
	end
end

if and
	0018:   $PACKGE_01 > 0 
	001A:   6 > $PACKAGES_COLLECTED 
then
	01E5: text_1number_highpriority 'LOVE3_3' number $PACKAGE_NUMBERS duration 5000 ms flag 1  // ~g~The plane has dropped ~1~ of 6 packages.
end

0084: $PACKGE_TEMP = $PACKGE_01
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_01
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_01 = $PACKGE_TEMP

0084: $PACKGE_TEMP = $PACKGE_02
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_02
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_02 = $PACKGE_TEMP

0084: $PACKGE_TEMP = $PACKGE_03
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_03
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_03 = $PACKGE_TEMP

0084: $PACKGE_TEMP = $PACKGE_04
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_04
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_04 = $PACKGE_TEMP

0084: $PACKGE_TEMP = $PACKGE_05
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_05
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_05 = $PACKGE_TEMP

0084: $PACKGE_TEMP = $PACKGE_06
0084: $FLOAT_PACKGE_TEMP = $FLOAT_PACKGE_06
gosub @CHECK_PACKAGE_PICKUP_LOVE3
0084: $PACKGE_06 = $PACKGE_TEMP

if
	0018:   $PACKGE_06 > 0 			// Final package has been created
then
	if and
		0038:   $POLICE_BOAT_FLAG == 0 
		80C2:   not is_point_on_screen 560.5 -474.0 -0.1875 5.0 
	then
		00A5: $POLICE_BOAT = create_car #PREDATOR at 560.5 -474.0 -0.1875 
		0129: $POLICE_BOAT_DRIVER = create_actor PEDTYPE_CIVMALE #COP in_car $POLICE_BOAT driverseat 
		0175: set_car $POLICE_BOAT z_angle_to 179.75 
		02D3: boat $POLICE_BOAT drive_to $PACKAGE_6_X $PACKAGE_6_Y 0.0 
		0004: $POLICE_BOAT_FLAG = 1
	end
	if
		8119:   not car $POLICE_BOAT wrecked
	then
		if and
			0038:   $POLICE_BOAT_FLAG == 1 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_6_X $PACKAGE_6_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_06 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to $PACKAGE_5_X $PACKAGE_5_Y 0.0 
				0004: $POLICE_BOAT_FLAG = 2 
			end
		end
		if and
			0038:   $POLICE_BOAT_FLAG == 2 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_5_X $PACKAGE_5_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_05 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to $PACKAGE_4_X $PACKAGE_4_Y 0.0 
				0004: $POLICE_BOAT_FLAG = 3 
			end
		end
		if and
			0038:   $POLICE_BOAT_FLAG == 3 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_4_X $PACKAGE_4_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_04 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to $PACKAGE_3_X $PACKAGE_3_Y 0.0 
				0004: $POLICE_BOAT_FLAG = 4 
			end
		end
		if and
			0038:   $POLICE_BOAT_FLAG == 4 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_3_X $PACKAGE_3_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_03 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to $PACKAGE_2_X $PACKAGE_2_Y 0.0 
				0004: $POLICE_BOAT_FLAG = 5 
			end
		end
		if and
			0038:   $POLICE_BOAT_FLAG == 5 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_2_X $PACKAGE_2_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_02 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to $PACKAGE_1_X $PACKAGE_1_Y 0.0 
				0004: $POLICE_BOAT_FLAG = 6 
			end
		end
		if and
			0038:   $POLICE_BOAT_FLAG == 6 
			01AD:   car $POLICE_BOAT sphere 0 near_point $PACKAGE_1_X $PACKAGE_1_Y radius 4.0 4.0 
		then
			if
				0038:   $PACKGE_01 == 1 
			then
				goto @FAIL_POLICE_GOT_PACKAGE_LOVE3
			else
				02D3: boat $POLICE_BOAT drive_to 641.5 594.625 0.0 
				0004: $POLICE_BOAT_FLAG = 99 
			end
		end
	end
end

if
	0038:   $PACKAGES_COLLECTED == 6 
then
	00BC: print_now 'LOVE3_2' duration 5000 ms flag 1  // ~g~You have all the packages! Take them back to Donald Love.
	0164: disable_marker $PLANE_BLIP 
	018A: $PLANE_BLIP = create_checkpoint_at 87.25 -1548.563 27.25 
	0004: $TEMPORARY_TIME_DRUG = 0 
	goto @GARAGE_LOOP_LOVE3
end

goto @PLANE_DROP_LOOP

:GARAGE_LOOP_LOVE3

while 83C6:   not current_island == LEVEL_COMMERCIAL
	wait 0 ms
end

while 80F9:   not player $PLAYER_CHAR stopped 1 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	wait 0 ms
end

// NEW STUFF HERE
010E: set_player $PLAYER_CHAR minimum_wanted_level_to 5 // Should be this already, but just in case since it's needed for the rampage to work.

01F9: init_rampage 'PAGE_00' weapon WEAPONTYPE_M16 time $FRENZY_TIME $FRENZY_KILL_AMOUNT targets CAR_POLICE CAR_ENFORCER CAR_FBI CAR_BARRACKS flag 0  // .
0014: $FRENZY_TIME /= 1000 // Convert from ms to sec
00BA: print_big 'RAMPAGE' duration 5000 ms style 5  // RAMPAGE!!
036D: text_2numbers_styled 'LOVE3PG' numbers $FRENZY_KILL_AMOUNT $FRENZY_TIME duration 10000 ms style 6  // Destroy ~1~ law enforcement vehicles in ~2~ seconds to scare them away!
01FA: $FRENZY_STATUS = rampage_status

while 0038:   $FRENZY_STATUS == FRENZY_ONGOING
	wait 0 ms
	01FA: $FRENZY_STATUS = rampage_status
end

if
	0038:   $FRENZY_STATUS == FRENZY_FAILED
then
	goto @MISSION_FAILED_LOVE3
end

0110: clear_player $PLAYER_CHAR wanted_level 

while 80F9:   not player $PLAYER_CHAR stopped 1 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	wait 0 ms
	0110: clear_player $PLAYER_CHAR wanted_level 
end

01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0 
0110: clear_player $PLAYER_CHAR wanted_level 
015F: set_camera_position 81.3125 -1540.063 27.75 rotation 0.0 0.0 0.0 
0160: point_camera 81.8125 -1540.875 27.75 switchstyle JUMP_CUT 
02A3: toggle_widescreen 1 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
0239: actor $PLAYER_ACTOR run_to 87.4375 -1548.688 
0006: 16@ = 0 

while true
	if and
		80E4:   not player $PLAYER_CHAR 0 87.4375 -1548.688 radius 1.0 1.0 
		8019:   not 16@ > 3000
	jf break
	wait 0 ms
end //while

0239: actor $PLAYER_ACTOR run_to 98.75 -1548.625 
016A: fade 0 for 1000 ms 
0395: clear_area 0 at 87.25 -1548.563 range 28.25 2.0 

while fading
	wait 0 ms
end

011C: actor $PLAYER_ACTOR clear_objective 
009F: char_set_idle $PLAYER_ACTOR 
0239: actor $PLAYER_ACTOR run_to 81.25 -1548.875 
011C: actor $PLAYER_ACTOR clear_objective 
009F: char_set_idle $PLAYER_ACTOR 
0001: wait 250 ms 
0055: set_player_coordinates $PLAYER_CHAR to 81.25 -1548.875 27.375 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
03C8: set_camera_directly_before_player 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03F4: set_all_cars_can_be_damaged 1 
016A: fade 1 for 1000 ms 

goto @MISSION_PASSED_LOVE3

/////////////////////////////////////////

:FAIL_POLICE_GOT_PACKAGE_LOVE3	
0215: destroy_pickup $FLOAT_PACKGE_01 
0215: destroy_pickup $FLOAT_PACKGE_02 
0215: destroy_pickup $FLOAT_PACKGE_03 
0215: destroy_pickup $FLOAT_PACKGE_04 
0215: destroy_pickup $FLOAT_PACKGE_05 
0215: destroy_pickup $FLOAT_PACKGE_06 
00BC: print_now 'LOVE3_6' duration 5000 ms flag 1  // ~r~The Police got to the packages first!
02D3: boat $POLICE_BOAT drive_to 641.5 594.625 0.0 
02DB: set_boat $POLICE_BOAT speed_to 100.0
goto @MISSION_FAILED_LOVE3		

/////////////////////////////////////////

:CHECK_PACKAGE_PICKUP_LOVE3
if
	0038:   $PACKGE_TEMP == 1 
then
	if
		0214:   pickup $FLOAT_PACKGE_TEMP picked_up 
	then
		018C: play_sound SOUND_EVIDENCE_PICKUP at 0.0 0.0 0.0 
		0008: $PACKAGES_COLLECTED += 1 
		if
			0038:   $COUNTER_DISPLAY_FLAG == 0 
		then
			03C4: set_status_text_to $PACKAGES_COLLECTED COUNTER_DISPLAY_NUMBER 'COLLECT'  // COLLECTED:
			0004: $COUNTER_DISPLAY_FLAG = 1 
		end
		0008: $POLICE_RATING += 1 
		010E: set_player $PLAYER_CHAR minimum_wanted_level_to $POLICE_RATING 
		0004: $PACKGE_TEMP = 2 
	end
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_LOVE3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_LOVE3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_LOVE3
0004: $A_DROP_IN_THE_OCEAN_COMPLETED = 1 
0004: $FLAG_SHORESIDE_OPEN = 1 
034B: staunton_complete 
if
	03CA:   object $SUBWAY_GATE2 exists 
then
	0108: destroy_object $SUBWAY_GATE2 
end
if
	03CA:   object $SUBWAY_GATE3 exists 
then
	0108: destroy_object $SUBWAY_GATE3 
end
if
	03CA:   object $TUNNEL_STAUNTON_BLOCK exists 
then
	0108: destroy_object $TUNNEL_STAUNTON_BLOCK 
end
if
	03CA:   object $LIFT_BRIDGE_BLOCK exists 
then
	0108: destroy_object $LIFT_BRIDGE_BLOCK 
end
01E7: switch_roads_on 496.6875 75.5 -30.0 to 484.0 44.1875 0.0 //tunnel to suburbia
01E7: switch_roads_on -46.75 -648.0 39.0 to -69.0625 -614.0 50.0 //Commercial to Suburbia Bridge

01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 10000 
0110: clear_player $PLAYER_CHAR wanted_level 
0318: set_latest_mission_passed 'LOVE3'  // 'A DROP IN THE OCEAN'
0394: play_mission_passed_music 1 
030C: set_mission_points += 1 
004F: create_thread @LOVE_MISSION4_LOOP  

goto @MISSION_END_LOVE3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_LOVE3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LOVE = 0 
014F: stop_timer $PLANE_TIMER 
0151: remove_status_text $PACKAGES_COLLECTED 
0249: release_model #SPEEDER 
0249: release_model #DEADDODO 
0164: disable_marker $PLAYERS_BOAT_BLIP 
0164: disable_marker $PLANE_BLIP 
01F0: set_max_wanted_level_to 6
014C: set_parked_car_generator $COM_CAR13 cars_to_generate_to 101 
00D8: mission_has_finished 
return

////////////////////////////////////////


