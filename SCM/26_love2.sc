// *****************************************************************************************
// *********************************    Love mission 2   *********************************** 
// *********************************  Assassinate Kenji  ***********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M26_WAKAGASHIRAWIPEOUT

gosub @MISSION_START_LOVE2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LOVE2
end

:MISSION_END_LOVE2
gosub @MISSION_CLEANUP_LOVE2
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_LOVE2



0317: increment_mission_attempts 
03A4: name_thread 'LOVE2' 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_LOVE = 1 
0001: wait 0 ms 
0004: $FLAG_CARPARK_BLIP = 0 
0004: $FLAG_KENJI_DEAD = 0 
0004: $FLAG_MESSAGE = 0 
0004: $FLAG_YAK_CREATED_LOVE2 = 0 
0004: $FLAG_WANTED_LOVE2 = 0 
0004: $FLAG_YAK_ATTACK_LOVE2 = 0 
0004: $FLAG_PLAYER_CLEAR = 0 
0005: $CARPARK_MINX = 265.5 
0005: $CARPARK_MINY = -610.5 
0005: $CARPARK_MAXX = 345.5 
0005: $CARPARK_MAXY = -479.5 
0005: $CARPARK_MINZ = 32.5 
0005: $CARPARK_MAXZ = 50.0 
0247: request_model #TSHRORCKGRDN 
0247: request_model #TSHRORCKGRDN_ALFAS 

while true
	if or
		8248:   not model #TSHRORCKGRDN available 
		8248:   not model #TSHRORCKGRDN_ALFAS available 
	jf break
	wait 0 ms
end //while

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'LOVE' as 1 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'LOVEH' 
038B: load_all_models_now 


while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'D2_KK' 
03AF: set_streaming 1 
0244: set_cutscene_pos 85.1875 -1532.875 243.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_LOVE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_LOVE 'LOVE' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $LOVE_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_LOVE 
02F5: set_head_anim $LOVE_CSHEAD 'LOVE' 
0055: set_player_coordinates $PLAYER_CHAR to 85.0 -1548.188 28.25 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 250 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   5434 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_A' duration 4000 ms flag 1  // Nothing drives down real estate prices like a good old fashioned gang war,
while 001A:   9893 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_B' duration 4500 ms flag 1  // apart from an outbreak of plague......but that might be going too far in this case.
while 001A:   14631 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_C' duration 4000 ms flag 1  // I've noticed the Yakuza and the Colombians are far from friends.
while 001A:   18811 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_D' duration 3000 ms flag 1  // Let's capitalise on this business opportunity.
while 001A:   21947 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_E' duration 3500 ms flag 1  // I want you to kill the Yakuza Waka-gashira, Kenji Kasen.
while 001A:   26266 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_F' duration 3500 ms flag 1  // Kenji is attending a meeting at the top of the multi-story carpark in Newport.
while 001A:   30656 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_G' duration 3000 ms flag 1  // Get a Cartel gangcar and eliminate him!
while 001A:   33442 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE2_H' duration 4500 ms flag 1  // The Yakuza must blame the Cartel for this declaration of war.
while 001A:   41066 > $CUT_SCENE_TIME
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
016A: fade 0 for 0 ms 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #TSHRORCKGRDN 
0249: release_model #TSHRORCKGRDN_ALFAS 
03AD: set_rubbish 1 
023C: load_special_actor 'KENJI' as 1 
0247: request_model #GANG07 
0247: request_model #GANG08 
0247: request_model #YAKUZA 
0247: request_model #STRETCH 

while true
	if or
		823D:   not special_actor 1 loaded
		8248:   not model #GANG07 available
		8248:   not model #GANG08 available
		8248:   not model #YAKUZA available
		8248:   not model #STRETCH available
	jf break
	wait 0 ms
end //while

while fading
	wait 0 ms
end

010E: set_player $PLAYER_CHAR minimum_wanted_level_to 5

00BC: print_now 'LOV2FBI' duration 6000 ms flag 1  // ~g~To make sure there are enough witnesses, Donald has informed the FBI of your planned hit!
0001: wait 6000 ms

03CF: load_wav 'LO2_A' 

//While loop 1: player not at carpark AND player not in CAR_COLUMB

:WHILE_LOOP_1
while 0038:   $FLAG_KENJI_DEAD == 0 
	wait 0 ms
	if
		0038:   $FLAG_MESSAGE == 0 
	then
		00BC: print_now 'LOVE2_1' duration 6000 ms flag 1  // ~g~Go to Fort Staunton and steal a Colombian gangcar!
		0001: wait 3000 ms 
		0004: $FLAG_MESSAGE = 1 
	end
	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 1 
		goto @WHILE_LOOP_2
	end
	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 2 
		goto @WHILE_LOOP_3
	end

	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 3 
		goto @WHILE_LOOP_4
	end
end //while
		   		
//While loop 2: player not at carpark AND player in CAR_COLUMB

:WHILE_LOOP_2
while 0038:   $FLAG_KENJI_DEAD == 0 
	wait 0 ms
	if
		0038:   $FLAG_MESSAGE == 1
	then
		00BC: print_now 'LOVE2_2' duration 4000 ms flag 1  // ~g~Now get to the ~p~multi-storey in Newport~g~ and whack Kenji!
		0001: wait 3000 ms 
		0004: $FLAG_MESSAGE = 0 
	end
	if
		0038:   $FLAG_CARPARK_BLIP == 0 
	then
		018A: $BLIP_CARPARK = create_checkpoint_at 305.0 -545.0 30.0 
		0004: $FLAG_CARPARK_BLIP = 1 
	end
	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 0 
		goto @WHILE_LOOP_1
	end
	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 2 
		goto @WHILE_LOOP_3
	end

	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 3 
		goto @WHILE_LOOP_4
	end
end //while

//While loop 3: player at carpark AND NOT in CAR_COLUMB

:WHILE_LOOP_3
if
	0038:   $FLAG_CARPARK_BLIP == 1 
then
	0164: disable_marker $BLIP_CARPARK
	0004: $FLAG_CARPARK_BLIP = 0 
end
while 0038:   $FLAG_KENJI_DEAD == 0 
	wait 0 ms
	if
		0038:   $FLAG_MESSAGE == 1
	then
		00BC: print_now 'LOVE2_3' duration 3000 ms flag 1  // ~r~If you proceed without a Cartel car you will be identified!!
		0004: $FLAG_MESSAGE = 0 
	end

	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 0 
		goto @WHILE_LOOP_1
	end
	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 1 
		goto @WHILE_LOOP_2
	end

	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 3 
		goto @WHILE_LOOP_4
	end
	gosub @CHECK_FAIL_CONDITIONS_LOVE2
	gosub @CREATE_YAKUZA

	if
		0038:   $FLAG_WANTED_LOVE2 == 1 
	then
		03D1: play_wav 
		0004: $FLAG_WANTED_LOVE2 = 2 
	end

end //while

//While loop 4: player at carpark AND in CAR_COLUMB

:WHILE_LOOP_4
if
	0038:   $FLAG_CARPARK_BLIP == 1 
then
	0164: disable_marker $BLIP_CARPARK
	0004: $FLAG_CARPARK_BLIP = 0 
end
while 0038:   $FLAG_KENJI_DEAD == 0 
	wait 0 ms
	if
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
	then
		00DA: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR 
		03AB: set_car $PLAYER_CAR strong 1 
	end
	if and
		0038:   $FLAG_YAK_ATTACK_LOVE2 == 0 
		0057:   is_player_in_area_3d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY $CARPARK_MINZ to $CARPARK_MAXX $CARPARK_MAXY $CARPARK_MAXZ sphere 0 
	then
		if
			8118:   not actor $YAK_7_LOVE2 dead 
		then
			01CC: actor $YAK_7_LOVE2 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $YAK_8_LOVE2 dead 
		then
			01CC: actor $YAK_8_LOVE2 kill_player $PLAYER_CHAR 
		end
		0004: $FLAG_YAK_ATTACK_LOVE2 = 1 
	end
	gosub @CHECK_FAIL_CONDITIONS_LOVE2
	if and
		0057:   is_player_in_area_3d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY 35.0 to $CARPARK_MAXX $CARPARK_MAXY $CARPARK_MAXZ sphere 0 
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		8118:   not actor $KENJI dead 
	then
		020F: actor $KENJI look_at_player $PLAYER_CHAR 
	end

	if and
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		if
			8118:   not actor $YAK_7_LOVE2 dead 
		then
			011C: actor $YAK_7_LOVE2 clear_objective 
		end
		if
			8118:   not actor $YAK_8_LOVE2 dead 
		then
			011C: actor $YAK_8_LOVE2 clear_objective 
		end
		0004: $FLAG_YAK_ATTACK_LOVE2 = 0 
		0004: $FLAG_MESSAGE = 1 
		goto @WHILE_LOOP_2
	end

	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		8056:   not is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 0 
		goto @WHILE_LOOP_1
	end


	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY to $CARPARK_MAXX $CARPARK_MAXY sphere 0 
	then
		0004: $FLAG_MESSAGE = 2 
		goto @WHILE_LOOP_3
	end

	gosub @CREATE_YAKUZA

	if
		0038:   $FLAG_WANTED_LOVE2 == 1 
	then
		03D1: play_wav 
		0004: $FLAG_WANTED_LOVE2 = 2 
	end

	if
		0118:   actor $KENJI dead 
	then
		0004: $FLAG_KENJI_DEAD = 1 
		0164: disable_marker $BLIP_KENJI_LOVE2 
	end
end //while

// The deed is done.

while 0038:   $FLAG_PLAYER_CLEAR == 0 
	wait 0 ms
	if
		0038:   $FLAG_KENJI_DEAD == 1 
	then
		00BC: print_now 'LOVE2_5' duration 3000 ms flag 1  // ~g~Kenji is fender meat! Get out of Newport and dump the car!
		0004: $FLAG_KENJI_DEAD = 2 
	end

	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		0057:   is_player_in_area_3d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY $CARPARK_MINZ to $CARPARK_MAXX $CARPARK_MAXY $CARPARK_MAXZ sphere 0 
	then
		00BC: print_now 'LOVE2_4' duration 3000 ms flag 1  // ~r~The Yakuza have identified you!!
		goto @MISSION_FAILED_LOVE2
	end

	if and
		8121:   not player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		00DE:   is_player_in_model $PLAYER_CHAR model #COLUMB 
		0038:   $FLAG_KENJI_DEAD == 2 
	then
		00BC: print_now 'LOVE2_7' duration 3000 ms flag 1  // ~g~ Now dump the car!
		0004: $FLAG_KENJI_DEAD = 3
	end

	if and
		0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		0038:   $FLAG_KENJI_DEAD == 2 
	then
		00BC: print_now 'LOVE2_8' duration 3000 ms flag 1  // ~g~Now get out of Newport!
		0004: $FLAG_KENJI_DEAD = 3 
	end

	if and
		8121:   not player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
	then
		0004: $FLAG_PLAYER_CLEAR = 1 
	end
end //while
	
goto @MISSION_PASSED_LOVE2

/////////////////////////////////////////

:CHECK_FAIL_CONDITIONS_LOVE2
if and
	80E0:   not is_player_in_any_car $PLAYER_CHAR 
	0057:   is_player_in_area_3d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY $CARPARK_MINZ to $CARPARK_MAXX $CARPARK_MAXY $CARPARK_MAXZ sphere 0 
then
	00BC: print_now 'LOVE2_4' duration 3000 ms flag 1  // ~r~The Yakuza have identified you!!
	if
		0038:   $FLAG_YAK_CREATED_LOVE2 == 1 
	then
		if and
			8118:   not actor $KENJI dead 
			8119:   not car $KENJI_CAR_LOVE2 wrecked 
		then
			01D5: actor $KENJI go_to_and_drive_car $KENJI_CAR_LOVE2
		end
	end
	goto @MISSION_FAILED_LOVE2
end
if and
	0057:   is_player_in_area_3d $PLAYER_CHAR coords $CARPARK_MINX $CARPARK_MINY 35.0 to $CARPARK_MAXX $CARPARK_MAXY $CARPARK_MAXZ sphere 0 
	80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB
then
	00BC: print_now 'LOVE2_4' duration 3000 ms flag 1  // ~r~The Yakuza have identified you!!
	if
		0038:   $FLAG_YAK_CREATED_LOVE2 == 1 
	then
		if and
			8118:   not actor $KENJI dead 
			8119:   not car $KENJI_CAR_LOVE2 wrecked 
		then
			01D5: actor $KENJI go_to_and_drive_car $KENJI_CAR_LOVE2
		end
	end
	goto @MISSION_FAILED_LOVE2
end
return
	

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_LOVE2
00BA: print_big 'M_FAIL' duration 2000 ms style 1  // MISSION FAILED!
0164: disable_marker $BLIP_KENJI_LOVE2 
034F: destroy_actor_with_fade $KENJI 
goto @MISSION_END_LOVE2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_LOVE2
0004: $WAKAGASHIRA_WIPEOUT_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 30000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 30000 
0318: set_latest_mission_passed 'LOVE2'  // 'WAKA-GASHIRA WIPEOUT!'
030C: set_mission_points += 1 
0164: disable_marker $KENJI_MISION_MARKER 
004F: create_thread @LOVE_MISSION3_LOOP 
goto @MISSION_END_LOVE2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_LOVE2
if 
	0038:   $FLAG_CARPARK_BLIP == 1 
then
	0164: disable_marker $BLIP_CARPARK
end
0164: disable_marker $BLIP_KENJI_LOVE2 
034F: destroy_actor_with_fade $KENJI 
0296: unload_special_actor 1 
02EB: restore_camera_jumpcut 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LOVE = 0 
0249: release_model #GANG07 
0249: release_model #GANG08 
0249: release_model #STRETCH 
0249: release_model #YAKUZA 
00D8: mission_has_finished
return

////////////////////////////////////////

:CREATE_YAKUZA
if
	0038:   $FLAG_YAK_CREATED_LOVE2 == 0 
then
	00A5: $KENJI_CAR_LOVE2 = create_car #YAKUZA at 302.0 -550.0 37.0 
	0175: set_car $KENJI_CAR_LOVE2 z_angle_to 90.0 
	00A9: car_set_idle $KENJI_CAR_LOVE2 
	02AA: set_car $KENJI_CAR_LOVE2 immune_to_nonplayer 0 
	02AC: set_car $KENJI_CAR_LOVE2 immunities 0 0 1 0 0
	00A5: $YAK_CAR_1_LOVE2 = create_car #STRETCH at 291.375 -547.0 37.0 
	0175: set_car $YAK_CAR_1_LOVE2 z_angle_to 320.0 
	00A9: car_set_idle $YAK_CAR_1_LOVE2 
	02AA: set_car $YAK_CAR_1_LOVE2 immune_to_nonplayer 0 
	02AC: set_car $YAK_CAR_1_LOVE2 immunities 0 0 1 0 0
	00A5: $YAK_CAR_2_LOVE2 = create_car #YAKUZA at 294.5625 -558.0 37.0 
	0175: set_car $YAK_CAR_2_LOVE2 z_angle_to 96.0 
	00A9: car_set_idle $YAK_CAR_2_LOVE2 
	02AA: set_car $YAK_CAR_2_LOVE2 immune_to_nonplayer 0 
	02AC: set_car $YAK_CAR_2_LOVE2 immunities 0 0 1 0 0
	00A5: $YAK_CAR_1_LOVE2 = create_car #STRETCH at 299.375 -540.0 37.0 
	0175: set_car $YAK_CAR_1_LOVE2 z_angle_to 296.0 
	00A9: car_set_idle $YAK_CAR_1_LOVE2 
	02AA: set_car $YAK_CAR_1_LOVE2 immune_to_nonplayer 0 
	02AC: set_car $YAK_CAR_1_LOVE2 immunities 0 0 1 0 0
	009A: $YAK_1_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 286.375 -543.5 37.0 
	0173: set_actor $YAK_1_LOVE2 z_angle_to 180.0 
	009A: $YAK_2_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at 304.5 -544.25 37.0 
	0173: set_actor $YAK_2_LOVE2 z_angle_to 40.0 
	035F: set_actor $YAK_2_LOVE2 armour_to 100 
	009A: $YAK_3_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 299.25 -534.0 37.0 
	0173: set_actor $YAK_3_LOVE2 z_angle_to 20.0 
	009A: $YAK_4_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at 295.0 -562.0 37.0 
	0173: set_actor $YAK_4_LOVE2 z_angle_to 180.0 
	009A: $YAK_5_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 295.0 -544.0 37.0 
	0173: set_actor $YAK_5_LOVE2 z_angle_to 15.0 
	035F: set_actor $YAK_5_LOVE2 armour_to 100 
	009A: $YAK_6_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at 300.0 -556.0 37.0 
	0173: set_actor $YAK_6_LOVE2 z_angle_to 160.0 
	009A: $YAK_7_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at 301.0 -516.0 37.0 
	0173: set_actor $YAK_7_LOVE2 z_angle_to 45.0 
	009A: $YAK_8_LOVE2 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at 273.0 -570.0 37.0 
	0173: set_actor $YAK_8_LOVE2 z_angle_to 260.0 
	01B2: give_actor $YAK_1_LOVE2 weapon WEAPONTYPE_M16 ammo 80 
	01B2: give_actor $YAK_2_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	01B2: give_actor $YAK_3_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	02E2: set_actor $YAK_3_LOVE2 weapon_accuracy_to 40 
	01B2: give_actor $YAK_4_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	02E2: set_actor $YAK_4_LOVE2 weapon_accuracy_to 40 
	01B2: give_actor $YAK_5_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	02E2: set_actor $YAK_5_LOVE2 weapon_accuracy_to 40 
	01B2: give_actor $YAK_6_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	01B2: give_actor $YAK_7_LOVE2 weapon WEAPONTYPE_SHOTGUN ammo 25 
	01B2: give_actor $YAK_8_LOVE2 weapon WEAPONTYPE_UZI ammo 60 
	02E2: set_actor $YAK_8_LOVE2 weapon_accuracy_to 40 
	011A: set_actor $YAK_1_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_2_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_3_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_4_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_5_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_6_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_7_LOVE2 search_threat THREAT_PLAYER1 
	011A: set_actor $YAK_8_LOVE2 search_threat THREAT_PLAYER1 
	009A: $KENJI = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 304.1875 -543.0625 36.25 
	0173: set_actor $KENJI z_angle_to 140.0 
	011A: set_actor $KENJI search_threat THREAT_PLAYER1 
	01B2: give_actor $KENJI weapon WEAPONTYPE_UZI ammo 60 
	035F: set_actor $KENJI armour_to 100 
	02AB: set_actor $KENJI immunities BP 0 FP 0 EP 1 CP 0 MP 0
	0187: $BLIP_KENJI_LOVE2 = create_marker_above_actor $KENJI 
	0350: set_actor $KENJI maintain_position_when_attacked 1 
	0004: $FLAG_YAK_CREATED_LOVE2 = 1 
end
return
