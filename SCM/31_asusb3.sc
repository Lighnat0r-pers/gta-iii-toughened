// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************ASUKA SUBURBAN MISSION 3****************************** 
// *****************************************************************************************
// ***************************************'Plane to Sea'************************************
// *****************************************************************************************

// Mission start stuff

:M31_SAM

gosub @MISSION_START_AS3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_AS3
end

:MISSION_END_AS3
gosub @MISSION_CLEANUP_AS3
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_AS3
0317: increment_mission_attempts 
03A4: name_thread 'ASUSB3' 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA1 = 1 
0001: wait 0 ms 

//---------------------------------SET FLAGS & VARIABLES-------------------------------------------

0004: $TIMER_AS3 = 200000 
0004: $COUNTER_CHARLIE = 0 
0004: $FLAG_COMMENCE_APPROACH = 0 
0004: $FLAG_COUNTER_MESSAGE = 0 
0004: $FLAG_RUNWAY_BLIP = 0 
0004: $FLAG_BOAT_BLIP = 0 
0004: $FLAG_BOUY_BLIP = 0 
0004: $PARTICLE_TIME = 0 
0004: $FLAG_PARTICLE = 0 
0004: $FLAG_CHARLIE_1 = 0 
0004: $FLAG_CHARLIE_2 = 0 
0004: $FLAG_CHARLIE_3 = 0 
0004: $FLAG_CHARLIE_4 = 0 
0004: $FLAG_CHARLIE_5 = 0 
0004: $FLAG_CHARLIE_6 = 0 
0004: $FLAG_CHARLIE_7 = 0 
0004: $FLAG_CHARLIE_8 = 0 
0004: $FLAG_MESSAGES = 0 
0004: $FLAG_CREATED_BADDIES = 0 
0004: $FLAG_BOAT_MESSAGE = 0 

// ****************************************LOCATION COORDS**************************************
0005: $PLATFORM_X = -805.0 
0005: $PLATFORM_Y = -1310.0 
0005: $KILLZONE_MIN_X = -1460.0 
0005: $KILLZONE_MIN_Y = -1050.0 
0005: $KILLZONE_MAX_X = -1450.0 
0005: $KILLZONE_MAX_Y = -1040.0 

// ****************************************START OF CUTSCENE********************************

0247: request_model #CSITECUTSCENE 
023C: load_special_actor 'ASUKA' as 1 
023C: load_special_actor 'MIGUEL' as 2 
023C: load_special_actor 'MARIA' as 3 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'ASUKAH' 
02F3: load_object #CUTOBJ03 'MARIAH' 
02F3: load_object #CUTOBJ04 'WHIP' 
038B: load_all_models_now 


while true
	if or
		8248:   not model #CSITECUTSCENE available 
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 3 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A8_PS' 
03AF: set_streaming 1 
0244: set_cutscene_pos 369.0 -327.5 18.4375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CUTSCENE_MIGUEL = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MIGUEL 'MIGUEL' 
02E5: $CUTSCENE_MARIA = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CUTSCENE_MARIA 'MARIA' 
02E5: $CS_WHIP = create_cutscene_object #CUTOBJ04 
02E6: set_cutscene_anim $CS_WHIP 'WHIP' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $MARIA_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_MARIA 
02F5: set_head_anim $MARIA_CSHEAD 'MARIA' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
0055: set_player_coordinates $PLAYER_CHAR to 373.75 -327.25 17.1875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 250 ms 
03AD: set_rubbish 0 
03AF: set_streaming 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime  


// Displays cutscene text

while 001A:   459 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_A' duration 5000 ms flag 1  // ~W~Do we tighten it some more now, or just wait for it to turn black and fall off?
while 001A:   4401 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_B' duration 3000 ms flag 1  // ~w~Give it a quick prod...
while 001A:   7348 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_C' duration 5000 ms flag 1  // ~w~Eeeeeeyoooo! What IS that gooey yellow stuff?
while 001A:   10448 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_C1' duration 5000 ms flag 1  // ~w~Oh hi Babe.
while 001A:   11597 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_D' duration 2000 ms flag 1  // ~w~My Handyman!
while 001A:   13625 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_E' duration 3000 ms flag 1  // ~w~I was bored so I came over to keep Asuka company.
while 001A:   16457 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_F' duration 5000 ms flag 1  // ~w~She's got the makings of a natural this girl.
while 001A:   19021 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_F1' duration 5000 ms flag 1  // ~w~She's managed to extract this little gem from our guest.
while 001A:   22389 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_G' duration 5000 ms flag 1  // ~w~There is a plane coming into Francis International in 2 hours time.
while 001A:   26064 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_G1' duration 5000 ms flag 1  // ~w~It is full of Catalina's poison.
while 001A:   28628 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_H' duration 5000 ms flag 1  // ~w~You can avoid airport security by getting a boat out to the runway-light buoys
while 001A:   33182 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_H1' duration 5000 ms flag 1  // and shooting the plane down on its approach.
while 001A:   35785 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_I' duration 3000 ms flag 1  // ~w~Collect the cargo from the debris and stash it!
while 001A:   39765 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_J' duration 3000 ms flag 1  // ~w~Oh you be careful now, OK baby?
while 001A:   42026 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS3_K' duration 3000 ms flag 1  // ~w~Now try the chilli oil.....
while 001A:   44333 > $CUT_SCENE_TIME
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
0296: unload_special_actor 2 
0249: release_model #CSITECUTSCENE 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
03AD: set_rubbish 1 
03AF: set_streaming 1 
03B7: process_cut_scene_only 1 

// ******************************************END OF CUTSCENE********************************

014E: start_timer_at $TIMER_AS3 
0247: request_model #REEFER 
0247: request_model #DEADDODO 
0247: request_model #PACKAGELARGE 
0247: request_model #BOUY 
0247: request_model #DODO 
0247: request_model #GANG11 
0247: request_model #GANG12 
0247: request_model #COLUMB 

while true
	if or
		8248:   not model #REEFER available 
		8248:   not model #DEADDODO available 
		8248:   not model #PACKAGELARGE available 
		8248:   not model #BOUY available 
		8248:   not model #DODO available 
		8248:   not model #GANG11 available 
		8248:   not model #GANG12 available 
		8248:   not model #COLUMB available
	jf break
	wait 0 ms
end //while

00A5: $PLAYER_AS3_BOAT = create_car #REEFER at -330.5 -1462.375 0.0 
0175: set_car $PLAYER_AS3_BOAT z_angle_to 95.0 
0186: $BLIP_AS3_BOAT = create_marker_above_car $PLAYER_AS3_BOAT 
0004: $FLAG_BOAT_BLIP = 1 
0213: $ROCKET_AS3 = create_pickup #ROCKET type PICKUP_ONCE at -279.5625 -1473.75 6.1875

0107: $BOUY_1_AS3 = create_object #BOUY at -825.0 -1360.0 2.0 
0107: $BOUY_3_AS3 = create_object #BOUY at -705.0 -1410.0 2.0 
0107: $BOUY_5_AS3 = create_object #BOUY at -585.0 -1460.0 2.0 
0107: $BOUY_6_AS3 = create_object #BOUY at -785.0 -1260.0 2.0 
0107: $BOUY_8_AS3 = create_object #BOUY at -665.0 -1310.0 2.0 
0107: $BOUY_10_AS3 = create_object #BOUY at -545.0 -1360.0 2.0 
0107: $BOUY_2_AS3 = create_object #BOUY at -765.0 -1385.0 2.0 
0107: $BOUY_4_AS3 = create_object #BOUY at -645.0 -1435.0 2.0 
0107: $BOUY_7_AS3 = create_object #BOUY at -725.0 -1285.0 2.0 
0107: $BOUY_9_AS3 = create_object #BOUY at -605.0 -1335.0 2.0 
0107: $BOUY_POINT = create_object #BOUY at $PLATFORM_X $PLATFORM_Y 2.0 
0382: set_object $BOUY_1_AS3 collision_detection 1 
0392: object $BOUY_1_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_2_AS3 collision_detection 1 
0392: object $BOUY_2_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_3_AS3 collision_detection 1 
0392: object $BOUY_3_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_4_AS3 collision_detection 1 
0392: object $BOUY_4_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_5_AS3 collision_detection 1 
0392: object $BOUY_5_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_6_AS3 collision_detection 1 
0392: object $BOUY_6_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_7_AS3 collision_detection 1 
0392: object $BOUY_7_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_8_AS3 collision_detection 1 
0392: object $BOUY_8_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_9_AS3 collision_detection 1 
0392: object $BOUY_9_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_10_AS3 collision_detection 1 
0392: object $BOUY_10_AS3 toggle_in_moving_list 1 
0382: set_object $BOUY_POINT collision_detection 1 
0392: object $BOUY_POINT toggle_in_moving_list 1 

//-----------------CREATE CARTEL BADDIES--------------------------------------

gosub @BADDIES

:LOOP_AS3_1 //---player not at location and plane not triggered----------------

0004: $CURRENT_LOOP_AS3 = 1

while true
	wait 0 ms

	gosub @CHECK_BOAT_MESSAGES
	gosub @CHECK_BOAT_BLIP
	gosub @CHECK_LEVEL_CHANGE
	gosub @CHECK_PLAYER_AT_PLATFORM
	gosub @CHECK_PLANE_INIT
	gosub @CHECK_TIMER_FINISHED
	gosub @BADDIES
	
end //while

:LOOP_AS3_2 //---player not at location and plane is triggered-----------------

0004: $CURRENT_LOOP_AS3 = 2

while true
	wait 0 ms
	gosub @CHECK_BOAT_MESSAGES
	gosub @CHECK_BOAT_BLIP
	gosub @CHECK_LEVEL_CHANGE
	gosub @CHECK_PLAYER_AT_PLATFORM
	gosub @CHECK_PLANE_STATUS
	gosub @CHECK_TIMER_FINISHED

	03A6: get_drug_plane_coords $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 

	gosub @AREA_CHECK
	gosub @BADDIES

end //while

:LOOP_AS3_3 //---player at location, plane not triggered-----------------------

0004: $CURRENT_LOOP_AS3 = 3

while true
	wait 0 ms
	if
		0038:   $FLAG_MESSAGES == 0 
	then
		00BC: print_now 'AS3_3' duration 4000 ms flag 1  // ~g~Wait for the ~y~plane~g~ to start its approach!
	end

	gosub @CHECK_BOAT_BLIP
	gosub @CHECK_PLANE_INIT
	gosub @CHECK_TIMER_FINISHED
	gosub @BADDIES

end //while

:LOOP_AS3_4 //---player at location, plane triggered---------------------------

0004: $CURRENT_LOOP_AS3 = 4

while true
	wait 0 ms

	if
		0038:   $FLAG_MESSAGES == 0 
	then
		00BC: print_now 'AS3_4' duration 4000 ms flag 1  // ~g~Use a rocket launcher to shoot the ~y~plane~g~ down!!
		0004: $FLAG_MESSAGES = 1 
	end

	if
		8119:   not car $PLAYER_AS3_BOAT wrecked 
	then
		if and
			00DC:   is_player_in_car $PLAYER_CHAR car $PLAYER_AS3_BOAT 
			0038:   $FLAG_BOAT_BLIP == 1 
		then
			0164: disable_marker $BLIP_AS3_BOAT 
			0004: $FLAG_BOAT_BLIP = 0 
		end
		if and
			80DC:   not is_player_in_car $PLAYER_CHAR car $PLAYER_AS3_BOAT
			0038:   $FLAG_BOAT_BLIP == 0 
		then
			0186: $BLIP_AS3_BOAT = create_marker_above_car $PLAYER_AS3_BOAT 
			0004: $FLAG_BOAT_BLIP = 1 
			0004: $FLAG_MESSAGES = 0 
		end
	
	gosub @CHECK_PLANE_STATUS
	gosub @CHECK_TIMER_FINISHED

	03A6: get_drug_plane_coords $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 

	gosub @AREA_CHECK
	gosub @BADDIES

end //while

:LOOP_AS3_6 //---drug shipment shot down---(NB not really a loop!)-------------

010E: set_player $PLAYER_CHAR minimum_wanted_level_to 6
0164: disable_marker $BLIP_AS3_BOAT 
0164: disable_marker $BLIP_AS3_BOUY 
00A5: $DODO_AS3 = create_car #DODO at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0224: set_car $DODO_AS3 health_to 1 
0009: $DODO_AS3_X += 1.0 

029B: $CHARLIE_1 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_1 1 
0382: set_object $CHARLIE_1 collision_detection 1 
0392: object $CHARLIE_1 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_1 = create_marker_above_object $CHARLIE_1 
038C: object $CHARLIE_1 scatter 18.0 12.0 6.0 //blossom pattern
000D: $DODO_AS3_Y -= 1.0 

029B: $CHARLIE_2 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_2 1 
0382: set_object $CHARLIE_2 collision_detection 1 
0392: object $CHARLIE_2 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_2 = create_marker_above_object $CHARLIE_2 
038C: object $CHARLIE_2 scatter 14.0 -19.0 7.0 
000D: $DODO_AS3_X -= 1.0 

029B: $CHARLIE_3 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_3 1 
0382: set_object $CHARLIE_3 collision_detection 1 
0392: object $CHARLIE_3 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_3 = create_marker_above_object $CHARLIE_3 
038C: object $CHARLIE_3 scatter 13.0 -15.0 1.0 
000D: $DODO_AS3_X -= 1.0 

029B: $CHARLIE_4 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_4 1 
0382: set_object $CHARLIE_4 collision_detection 1 
0392: object $CHARLIE_4 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_4 = create_marker_above_object $CHARLIE_4 
038C: object $CHARLIE_4 scatter -18.0 -19.5 4.0 
0009: $DODO_AS3_Y += 1.0 

029B: $CHARLIE_5 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_5 1 
0382: set_object $CHARLIE_5 collision_detection 1 
0392: object $CHARLIE_5 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_5 = create_marker_above_object $CHARLIE_5 
038C: object $CHARLIE_5 scatter -7.0 11.0 8.0 
0009: $DODO_AS3_Y += 1.0 

029B: $CHARLIE_6 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_6 1 
0382: set_object $CHARLIE_6 collision_detection 1 
0392: object $CHARLIE_6 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_6 = create_marker_above_object $CHARLIE_6 
038C: object $CHARLIE_6 scatter -17.0 4.75 7.0 
0009: $DODO_AS3_X += 1.0 

029B: $CHARLIE_7 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_7 1 
0382: set_object $CHARLIE_7 collision_detection 1 
0392: object $CHARLIE_7 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_7 = create_marker_above_object $CHARLIE_7 
038C: object $CHARLIE_7 scatter -11.0 12.0 7.0 
0009: $DODO_AS3_X += 1.0 

029B: $CHARLIE_8 = create_object #PACKAGELARGE at $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
0240: flash_object $CHARLIE_8 1 
0382: set_object $CHARLIE_8 collision_detection 1 
0392: object $CHARLIE_8 toggle_in_moving_list 1 
0188: $BLIP_CHARLIE_8 = create_marker_above_object $CHARLIE_8 
038C: object $CHARLIE_8 scatter 10.0 10.0 0.0 

0006: 16@ = 0


:LOOP_AS3_7 //----collect the packages!!--------------

while 001A:   8 > $COUNTER_CHARLIE 
	wait 0 ms
	gosub @BADDIES

	if
		0038:   $FLAG_COUNTER_MESSAGE == 0 
	then
		00BC: print_now 'AS3_5' duration 5000 ms flag 1  // ~g~Collect the cargo!
		0004: $FLAG_COUNTER_MESSAGE = 1 
	end

	if
		001F:   16@ > $PARTICLE_TIME_
	then
		008A: $PARTICLE_TIME = 16@
		0008: $PARTICLE_TIME += 200 
		0004: $FLAG_PARTICLE = 1 
	end

	if
		0038:   $FLAG_PARTICLE == 1 
	then
		0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_1
		0084: $CHARLIE_TEMP = $CHARLIE_1
		0004: $PARTICLES_TIME_LIMIT = 6000
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_1_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_1_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_1_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_2
		0004: $PARTICLES_TIME_LIMIT = 4000
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_2_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_2_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_2_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_3
		0004: $PARTICLES_TIME_LIMIT = 7000
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_3_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_3_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_3_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_4
		0004: $PARTICLES_TIME_LIMIT = 3500
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_4_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_4_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_4_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_5
		0004: $PARTICLES_TIME_LIMIT = 8000
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_5_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_5_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_5_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_6
		0004: $PARTICLES_TIME_LIMIT = 6000
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_6_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_6_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_6_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_7
		0004: $PARTICLES_TIME_LIMIT = 7500
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_7_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_7_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_7_Z = $CHARLIE_TEMP_Z

		0084: $CHARLIE_TEMP = $CHARLIE_8
		0004: $PARTICLES_TIME_LIMIT = 4750
		gosub @CHECK_PACKAGE_PARTICLES
		0086: $CHARLIE_8_X = $CHARLIE_TEMP_X
		0086: $CHARLIE_8_Y = $CHARLIE_TEMP_Y
		0086: $CHARLIE_8_Z = $CHARLIE_TEMP_Z

		0004: $FLAG_PARTICLE = 0 

	end

	if or
		00DE:   is_player_in_model $PLAYER_CHAR model #REEFER 
		00DE:   is_player_in_model $PLAYER_CHAR model #PREDATOR 
		00DE:   is_player_in_model $PLAYER_CHAR model #SPEEDER 
	then
		0004: $CHECK_NR_USED = 1
	else
		0004: $CHECK_NR_USED = 2
	end

	0084: $CHARLIE_TEMP = $CHARLIE_1
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_1
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_1
	0086: $CHARLIE_TEMP_X = $CHARLIE_1_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_1_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_1_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_1 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_2
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_2
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_2
	0086: $CHARLIE_TEMP_X = $CHARLIE_2_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_2_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_2_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_2 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_3
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_3
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_3
	0086: $CHARLIE_TEMP_X = $CHARLIE_3_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_3_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_3_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_3 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_4
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_4
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_4
	0086: $CHARLIE_TEMP_X = $CHARLIE_4_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_4_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_4_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_4 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_5
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_5
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_5
	0086: $CHARLIE_TEMP_X = $CHARLIE_5_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_5_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_5_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_5 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_6
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_6
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_6
	0086: $CHARLIE_TEMP_X = $CHARLIE_6_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_6_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_6_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_6 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_7
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_7
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_7
	0086: $CHARLIE_TEMP_X = $CHARLIE_7_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_7_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_7_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_7 = $FLAG_CHARLIE_TEMP

	0084: $CHARLIE_TEMP = $CHARLIE_8
	0084: $BLIP_CHARLIE_TEMP = $BLIP_CHARLIE_8
	0084: $FLAG_CHARLIE_TEMP = $FLAG_CHARLIE_8
	0086: $CHARLIE_TEMP_X = $CHARLIE_8_X
	0086: $CHARLIE_TEMP_Y = $CHARLIE_8_Y
	0086: $CHARLIE_TEMP_Z = $CHARLIE_8_Z
	gosub @CHECK_PACKAGE_PICKUP
	0084: $FLAG_CHARLIE_8 = $FLAG_CHARLIE_TEMP

end //while

//------------------------------Stashing the Charlie-----------------------------------

00BC: print_now 'STASH' duration 4000 ms flag 1  // ~g~Stash the SPANK back at the ~p~construction site!
018A: $BLIP_STASH = create_checkpoint_at 367.25 -328.0 19.5 

009A: $KAPPA_CARTEL11 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at 370.0 -350.5 44.5
0173: set_actor $KAPPA_CARTEL11 z_angle_to 140.0
011A: set_actor $KAPPA_CARTEL11 search_threat THREAT_PLAYER1 
0350: set_actor $KAPPA_CARTEL11 maintain_position_when_attacked 1
01B2: give_actor $KAPPA_CARTEL11 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $KAPPA_CARTEL11 weapon_accuracy_to 100 
035F: set_actor $KAPPA_CARTEL11 armour_to 100 
01CC: actor $KAPPA_CARTEL11 kill_player $PLAYER_CHAR 


009A: $KAPPA_CARTEL12 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 348.0 -344.75 16.7
0173: set_actor $KAPPA_CARTEL12 z_angle_to 195.0 
011A: set_actor $KAPPA_CARTEL12 search_threat THREAT_PLAYER1 
0350: set_actor $KAPPA_CARTEL12 maintain_position_when_attacked 1
01B2: give_actor $KAPPA_CARTEL12 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $KAPPA_CARTEL12 weapon_accuracy_to 100 
035F: set_actor $KAPPA_CARTEL12 armour_to 100 
01CC: actor $KAPPA_CARTEL12 kill_player $PLAYER_CHAR 


while 80F6:   not player $PLAYER_CHAR 1 366.9375 -328.0 18.5 radius 1.0 1.0 4.0 
	wait 0 ms
end

0164: disable_marker $BLIP_STASH 

//  ******************************************* START OF CUTSCENE ***************************

03EF: player $PLAYER_CHAR make_safe 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
03AF: set_streaming 0 
00BA: print_big 'AS4' duration 15000 ms style 2  // 'RANSOM'

while fading
	wait 0 ms
end

0247: request_model #CSITECUTSCENE 
023C: load_special_actor 'ASUKA' as 1 
023C: load_special_actor 'MIGUEL' as 2 
02F3: load_object #CUTOBJ01 'WHIP' 
02F3: load_object #CUTOBJ02 'NOTE' 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CSITECUTSCENE available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A9_ASD' 
0244: set_cutscene_pos 369.0 -327.5 18.4375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CUTSCENE_MIGUEL = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MIGUEL 'MIGUEL' 
02E5: $CS_WHIP = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_WHIP 'WHIP' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_NOTE 'NOTE' 
0055: set_player_coordinates $PLAYER_CHAR to 373.75 -327.25 17.1875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   3000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT1_A' duration 5000 ms flag 1  // I've got your precious Maria. If you don't want her face to look like she fell out with the butcher.
while 001A:   8000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT1_B' duration 4000 ms flag 1  // bring $500,000 to the Villa at Cedar Grove.
while 001A:   12444 > $CUT_SCENE_TIME
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

00BE: clear_prints 
02EA: end_cutscene 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CSITECUTSCENE 
03AD: set_rubbish 1 

goto @MISSION_PASSED_AS3

////////////////////////////////////////

:CHECK_PACKAGE_PICKUP
if
	0038:   $FLAG_CHARLIE_TEMP == 0 
then
	if or
		00F5:   player $PLAYER_CHAR 0 $CHARLIE_TEMP_X $CHARLIE_TEMP_Y $CHARLIE_TEMP_Z radius 4.0 4.0 4.0 
		8038:   not $CHECK_NR_USED == 1
	then
		if or
			0178:   player $PLAYER_CHAR picked_up_object $CHARLIE_TEMP 
			8038:   not $CHECK_NR_USED == 2
		then
			0164: disable_marker $BLIP_CHARLIE_TEMP 
			0108: destroy_object $CHARLIE_TEMP 
			0008: $COUNTER_CHARLIE += 1 
			01E5: text_1number_highpriority 'AS3_6' number $COUNTER_CHARLIE duration 3000 ms flag 1  // ~g~~1~ OF 8
			0004: $FLAG_CHARLIE_TEMP = 1
		end
	end
end
return

/////////////////////////////////////////

:CHECK_PACKAGE_PARTICLES
if
	0038:   $FLAG_CHARLIE_TEMP == 0 
then
	01BB: store_object $CHARLIE_TEMP position_to $CHARLIE_TEMP_X $CHARLIE_TEMP_Y $CHARLIE_TEMP_Z 
	if
		001E:   $PARTICLES_TIME_LIMIT > 16@
	then
		 039D: scatter_particles type POBJECT_FIRE_TRAIL 0.375 0 0 0 200 from $CHARLIE_TEMP_X $CHARLIE_TEMP_Y $CHARLIE_TEMP_Z to 0.0 0.0 0.0 
	else
		 039D: scatter_particles type POBJECT_DRY_ICE 0.25 0 0 0 200 from $CHARLIE_TEMP_X $CHARLIE_TEMP_Y $CHARLIE_TEMP_Z to 0.0 0.0 0.0 
	end
end
return

/////////////////////////////////////////

:CHECK_BOAT_MESSAGES
if and
	0038:   $FLAG_MESSAGES == 0 
	0038:   $FLAG_BOAT_MESSAGE == 0 
then
	00BC: print_now 'AS3_1' duration 4000 ms flag 1  // ~g~Find the ~r~boat~g~ and get to the ~b~marker buoy!
	0004: $FLAG_BOAT_MESSAGE = 1 
	0004: $FLAG_MESSAGES = 1 
end
if and
	0038:   $FLAG_MESSAGES == 0 
	0038:   $FLAG_BOAT_MESSAGE == 1 
then
	if
		0038:   $CURRENT_LOOP_AS3 == 1
	then
		00BC: print_now 'AS3_1A' duration 4000 ms flag 1  // ~g~Now get to the ~b~marker buoy!
	else
		00BC: print_now 'AS3_2' duration 4000 ms flag 1  // ~b~Get to the runway marker buoys! ~y~The plane is on its final approach!!
	end
	0004: $FLAG_BOAT_MESSAGE = 2 
	0004: $FLAG_MESSAGES = 1 
end
return

/////////////////////////////////////////

:CHECK_BOAT_BLIP
if or
	00DE:   is_player_in_model $PLAYER_CHAR model #REEFER 
	00DE:   is_player_in_model $PLAYER_CHAR model #PREDATOR 
	00DE:   is_player_in_model $PLAYER_CHAR model #SPEEDER 
then
	if
		0038:   $FLAG_BOAT_BLIP == 1 
	then
		0164: disable_marker $BLIP_AS3_BOAT 
		0004: $FLAG_BOAT_BLIP = 0
	end
	if
		0038:   $FLAG_BOUY_BLIP == 0
	then
		0188: $BLIP_AS3_BOUY = create_marker_above_object $BOUY_POINT 
		0004: $FLAG_BOUY_BLIP = 1 
		0004: $FLAG_MESSAGES = 0
		if
			0038:   $CURRENT_LOOP_AS3 == 2
		then
			0004: $FLAG_BOAT_MESSAGE = 1 
		end
	end
else
	if and
		0038:   $FLAG_BOAT_BLIP == 0 
		8119:   not car $PLAYER_AS3_BOAT wrecked 
	then
		0186: $BLIP_AS3_BOAT = create_marker_above_car $PLAYER_AS3_BOAT 
		0004: $FLAG_BOAT_BLIP = 1 
	end
	if
		0038:   $FLAG_BOUY_BLIP == 1
	then
		0164: disable_marker $BLIP_AS3_BOUY 
		0004: $FLAG_BOUY_BLIP = 0 
		0004: $FLAG_MESSAGES = 0 
		if
			0038:   $CURRENT_LOOP_AS3 == 2
		then
			0004: $FLAG_BOAT_MESSAGE = 1 
		end
	end
end
return

/////////////////////////////////////////

:CHECK_LEVEL_CHANGE
if and
	00E3:   player $PLAYER_CHAR 0 $PLATFORM_X $PLATFORM_Y radius 160.0 160.0 
	83C6:   not current_island == LEVEL_SUBURBAN 
then
	044C: change_to_island LEVEL_SUBURBAN 
end
return

////////////////////////////////////////

:CHECK_TIMER_FINISHED
if
	001A:   1 > $TIMER_AS3 
then
	014F: stop_timer $TIMER_AS3 
end
return

////////////////////////////////////////

:CHECK_PLAYER_AT_PLATFORM
if
	00E3:   player $PLAYER_CHAR 0 $PLATFORM_X $PLATFORM_Y radius 15.0 15.0 
then
	0164: disable_marker $BLIP_AS3_BOUY 
	00BE: clear_prints 
	0004: $FLAG_MESSAGES = 0 
	if
		0038:   $CURRENT_LOOP_AS3 == 1
	then
		goto @LOOP_AS3_3
	else
		goto @LOOP_AS3_4
	end
end
return

////////////////////////////////////////

:CHECK_PLANE_INIT
if
	001A:   96000 > $TIMER_AS3
then
	if
		0038:   $FLAG_COMMENCE_APPROACH == 0 
	then
		033A: create_incoming_cessna 
		0004: $FLAG_COMMENCE_APPROACH = 1 
		03A6: get_drug_plane_coords $DODO_AS3_X $DODO_AS3_Y $DODO_AS3_Z 
	end
	00BE: clear_prints 
	0004: $FLAG_MESSAGES = 0 
	if
		0038:   $CURRENT_LOOP_AS3 == 1
	then
		goto @LOOP_AS3_2
	else
		goto @LOOP_AS3_4
	end
end
return

/////////////////////////////////////////

:CHECK_PLANE_STATUS
if
	033B:   incoming_cessna_landed 
then
	goto @MISSION_FAILED_AS3
end

if
	033C:   incoming_cessna_destroyed 
then
	00BE: clear_prints 
	014F: stop_timer $TIMER_AS3 
	0004: $FLAG_MESSAGES = 0 
	goto @LOOP_AS3_6
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_AS3
00BA: print_big 'M_FAIL' duration 2000 ms style 1  // MISSION FAILED!
if
	0130:   player $PLAYER_CHAR busted 
then
	0420: override_police_station LEVEL_COMMERCIAL 
end
if
	0117:   player $PLAYER_CHAR wasted 
then
	041F: override_hospital LEVEL_COMMERCIAL 
end
goto @MISSION_END_AS3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_AS3
0004: $SAM_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 45000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 45000 
0164: disable_marker $ASUKA1_MISSION_MARKER 
0164: disable_marker $COLUMBIAN_MANSION_MARKER 
02A7: $COLUMBIAN_MANSION_MARKER = create_icon_marker_and_sphere 3 at -362.75 245.875 60.0 
004F: create_thread @CAT_MISSION1_LOOP  
0318: set_latest_mission_passed 'AS3'  // 'S.A.M.'
030C: set_mission_points += 1 

goto @MISSION_END_AS3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_AS3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA2 = 0 
014F: stop_timer $TIMER_AS3 
0164: disable_marker $BLIP_AS3_BOAT 
0164: disable_marker $BLIP_AS3_BOUY 
0164: disable_marker $BLIP_STASH 
if
	8214:   not pickup $ROCKET_AS3 picked_up 
then
	0215: destroy_pickup $ROCKET_AS3 
end
0249: release_model #BOUY 
0249: release_model #REEFER 
0249: release_model #PACKAGELARGE 
0249: release_model #DEADDODO 
0249: release_model #DODO 
0249: release_model #GANG12 
0249: release_model #GANG11 
0249: release_model #COLUMB 
00D8: mission_has_finished 
return

////////////////////////////////////////

//________________________________GOSUBS_______GOSUBS________________________________BYTHEWAY

:BADDIES

if and
	0038:   $FLAG_CREATED_BADDIES == 0 
	03C6:   current_island == LEVEL_SUBURBAN
then
	009A: $KAPPA_CARTEL1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1015.0 -1269.0 -100.0 
	0173: set_actor $KAPPA_CARTEL1 z_angle_to 265.0 
	011A: set_actor $KAPPA_CARTEL1 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL1 weapon WEAPONTYPE_CHAINGUN ammo 100 
	035F: set_actor $KAPPA_CARTEL1 armour_to 100 
	0350: set_actor $KAPPA_CARTEL1 maintain_position_when_attacked 1 

	009A: $KAPPA_CARTEL2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1013.0 -1260.688 -100.0 
	0173: set_actor $KAPPA_CARTEL2 z_angle_to 300.0 
	011A: set_actor $KAPPA_CARTEL2 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL2 weapon WEAPONTYPE_M16 ammo 100 
	035F: set_actor $KAPPA_CARTEL2 armour_to 100 

	009A: $KAPPA_CARTEL3 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1027.25 -1265.188 -100.0 
	0173: set_actor $KAPPA_CARTEL3 z_angle_to 265.0 
	011A: set_actor $KAPPA_CARTEL3 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL3 weapon WEAPONTYPE_CHAINGUN ammo 100 
	035F: set_actor $KAPPA_CARTEL3 armour_to 100 

	009A: $KAPPA_CARTEL4 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1380.0 -1043.0 -100.0 
	0173: set_actor $KAPPA_CARTEL4 z_angle_to 340.0 
	011A: set_actor $KAPPA_CARTEL4 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL4 weapon WEAPONTYPE_M16 ammo 100 
	035F: set_actor $KAPPA_CARTEL4 armour_to 100 

	009A: $KAPPA_CARTEL5 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1392.0 -1043.25 -100.0 
	0173: set_actor $KAPPA_CARTEL5 z_angle_to 240.0 
	011A: set_actor $KAPPA_CARTEL5 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL5 weapon WEAPONTYPE_M16 ammo 100 
	035F: set_actor $KAPPA_CARTEL5 armour_to 100 

	009A: $KAPPA_CARTEL6 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1488.0 -1056.0 -100.0 
	0173: set_actor $KAPPA_CARTEL6 z_angle_to 110.0 
	011A: set_actor $KAPPA_CARTEL6 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL6 weapon WEAPONTYPE_M16 ammo 100 
	035F: set_actor $KAPPA_CARTEL6 armour_to 100 

	009A: $KAPPA_CARTEL7 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1473.0 -1062.0 -100.0 
	0173: set_actor $KAPPA_CARTEL7 z_angle_to 280.0 
	011A: set_actor $KAPPA_CARTEL7 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL7 weapon WEAPONTYPE_M16 ammo 100 
	035F: set_actor $KAPPA_CARTEL7 armour_to 100 

	009A: $KAPPA_CARTEL8 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -849.0 -1235.0 -100.0 
	0173: set_actor $KAPPA_CARTEL8 z_angle_to 250.0 
	011A: set_actor $KAPPA_CARTEL8 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL8 weapon WEAPONTYPE_CHAINGUN ammo 100 
	035F: set_actor $KAPPA_CARTEL8 armour_to 100 

	009A: $KAPPA_CARTEL9 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1478.0 -1055.0 -100.0 
	0173: set_actor $KAPPA_CARTEL9 z_angle_to 250.0 
	011A: set_actor $KAPPA_CARTEL9 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL9 weapon WEAPONTYPE_CHAINGUN ammo 100 
	035F: set_actor $KAPPA_CARTEL9 armour_to 100 

	00A5: $CARTEL_CAR_A_AS1 = create_car #COLUMB at -1019.0 -1263.0 -100.0 
	0175: set_car $CARTEL_CAR_A_AS1 z_angle_to 50.0 
	00A5: $CARTEL_CAR_B_AS1 = create_car #COLUMB at -1383.25 -1045.0 -100.0 
	0175: set_car $CARTEL_CAR_B_AS1 z_angle_to 231.5 
	00A5: $CARTEL_CAR_D_AS1 = create_car #COLUMB at -1478.25 -1062.75 -100.0 
	0175: set_car $CARTEL_CAR_B_AS1 z_angle_to 250.0 

	009A: $KAPPA_CARTEL10 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1385.25 -1035.0 -100.0 
	0173: set_actor $KAPPA_CARTEL10 z_angle_to 231.0 
	011A: set_actor $KAPPA_CARTEL10 search_threat THREAT_PLAYER1 
	01B2: give_actor $KAPPA_CARTEL10 weapon WEAPONTYPE_ROCKET ammo 50
	035F: set_actor $KAPPA_CARTEL10 armour_to 10000 

	0004: $FLAG_CREATED_BADDIES = 1 
end

if
	0038:   $FLAG_CREATED_BADDIES == 1 
then
	if and
		00E3:   player $PLAYER_CHAR 0 -1019.0 -1263.0 radius 60.0 60.0 
		8118:   not actor $KAPPA_CARTEL3 dead 
	then
		01CC: actor $KAPPA_CARTEL3 kill_player $PLAYER_CHAR 
	end
	
	if
		00E3:   player $PLAYER_CHAR 0 -1385.25 -1035.0 radius 80.0 80.0 
	then
		if
			8118:   not actor $KAPPA_CARTEL4 dead
		then
			01CC: actor $KAPPA_CARTEL4 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $KAPPA_CARTEL5 dead
		then
			01CC: actor $KAPPA_CARTEL5 kill_player $PLAYER_CHAR 
		end
	end

	if
		00E3:   player $PLAYER_CHAR 0 -1478.25 -1062.75 radius 80.0 80.0 
	then
		if
			8118:   not actor $KAPPA_CARTEL6 dead
		then
			01CC: actor $KAPPA_CARTEL6 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $KAPPA_CARTEL7 dead
		then
			01CC: actor $KAPPA_CARTEL7 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $KAPPA_CARTEL9 dead
		then
			01CC: actor $KAPPA_CARTEL9 kill_player $PLAYER_CHAR 
		end
	end
end
return

////////////////////////////////////////

:AREA_CHECK
if and
	0024:   $DODO_AS3_X > $KILLZONE_MIN_X 
	0024:   $KILLZONE_MAX_X > $DODO_AS3_X 
	0024:   $DODO_AS3_Y > $KILLZONE_MIN_Y 
	0024:   $KILLZONE_MAX_Y > $DODO_AS3_Y
	0020:   $DODO_AS3_Z > 5.0 
	0022:   30.0 > $DODO_AS3_Z  
then
	goto @MISSION_FAILED_AS3
end
return

////////////////////////////////////////
