// *****************************************************************************************
// ************************************ Ray mission 3 **************************************
// ************************************ Evidence Dash **************************************
// *****************************************************************************************
// *** The Internal Affairs are aware of Ray's activities, but are unable to get any 	 ***
// *** evidence until now. They have just raided one of Ray's old haunts and are leaving ***
// *** with the evidence. The player must chase them down and ram them with his car, when*** 
// *** their vehicle is rammed one of the packages will roll off the back. The player 	 ***
// *** must grab that first and then go get the next package off them. There will be 8 to*** 
// *** retrieve. Once the player has the stash he must get it back to his hideout.	 ***
// *****************************************************************************************

// Mission start stuff

:M24_EVIDENCEDASH

gosub @MISSION_START_RAY3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_RAY3
end

:MISSION_END_RAY3
gosub @MISSION_CLEANUP_RAY3
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_RAY3

0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_RAY = 1 
0004: $RAYS_CUTSCENE_FLAG = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'RAY3' 
0005: $IA_START_X = -53.0 
0005: $IA_START_Y = -1380.5 
0005: $IA_START_Z = 26.0 
0004: $AMOUNT_DAMAGE_IA_DROP_EVIDENCE = 100
0004: $WANTED_LEVEL_CHANGE = 1 
0004: $DROP_ONE_FLAG = 0 
0004: $DROP_EVIDENCE = 0 
0004: $GREEN = 250 
0004: $RED = 0 
0004: $RED_INCREASE_FLAG = 0 
0004: $RED_DECREASE_FLAG = 0 
0004: $GREEN_INCREASE_FLAG = 0 
0004: $GREEN_DECREASE_FLAG = 0 
0004: $TIMERA_RESET_FLAG = 0 
0004: $IA_HAVE_EVIDENCE_FLAG = 0 
0004: $TEMPORARY_HEALTH_VAR = 0 
0004: $IA_CAR_PREVIOUS_HEALTH = 0 
0004: $IA_CAR_CURRENT_HEALTH = 0 
0004: $AMOUNT_OF_EVIDENCE_PLAYER_HAS = 0 
0004: $GET_COORDS_FLAG = 0 
0004: $TIMERC_RESET_FLAG_R3 = 0 
0004: $TIMERD_RESET_FLAG_R3 = 0 
0004: $TIMERD_CURRENT_R3 = 0 
0004: $TIMERD_STARTED_R3 = 0 
0004: $TIMERD_R3 = 0 
0004: $TIMER_FOR_SPEED = 0 
0004: $RESET_FOR_TIMER = 0 
0005: $OBJECT_CURRENT_COORDS_X = 0.0 
0005: $OBJECT_CURRENT_COORDS_Y = 0.0 
0005: $OBJECT_CURRENT_COORDS_Z = 0.0 
0004: $TARGET_WANTED_LEVEL = 0
0004: $MIN_WANTED_LEVEL = 2
0004: $PLAYER_CAR = 0

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'RAY' as 1 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'RAYH' 
0247: request_model #TOILET 
038B: load_all_models_now 


while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #TOILET available 
	jf break
	wait 0 ms
end //while

0395: clear_area 1 at 39.0 -723.5 range 22.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 39.0 -723.5 22.0 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
02E4: load_cutscene_data 'R3_ED' 
0244: set_cutscene_pos 39.375 -726.625 21.6875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_RAY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_RAY 'RAY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $RAY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_RAY 
02F5: set_head_anim $RAY_CSHEAD 'RAY' 
016A: fade 1 for 1500 ms 
041D: set_camera_near_clip 0.1875 
02E7: start_cutscene 
03AF: set_streaming 0 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   10381 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_A' duration 10000 ms flag 1  // I know a real important man in town, a soft touch,
while 001A:   13529 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_H' duration 10000 ms flag 1  // with shall we say, exotic tastes and the money to indulge them.
while 001A:   17950 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_B' duration 10000 ms flag 1  // He's involved in a legal matter and the prosecution has some rather embarrassing photos of him
while 001A:   23502 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_C' duration 10000 ms flag 1  // at a morgue party or something.
while 001A:   26180 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_D' duration 10000 ms flag 1  // The evidence is being driven across town.
while 001A:   29179 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_E' duration 10000 ms flag 1  // You are going to have to ram that car and collect each little bit of evidence as it falls out.
while 001A:   34865 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_F' duration 10000 ms flag 1  // When you've got it all, leave it in the car and torch it.
while 001A:   39290 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM3_G' duration 10000 ms flag 1  // We're both gonna do pretty well outta this kid.
while 001A:   41666 > $CUT_SCENE_TIME
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
041D: set_camera_near_clip 0.875 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
0373: set_camera_directly_behind_player 
0296: unload_special_actor 1 
0249: release_model #TOILET 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0247: request_model #FILES 
0247: request_model #BOBCAT 
0247: request_model #B_MAN3 
038B: load_all_models_now 

while true
	if or
		8248:   not model #BOBCAT available 
		8248:   not model #B_MAN3 available 
		8248:   not model #FILES available 
	jf break
	wait 0 ms
end //while

016A: fade 1 for 1500 ms 
03AF: set_streaming 1 
0004: $RAYS_CUTSCENE_FLAG = 0 

while fading
	wait 0 ms
end

// ******************************************END OF CUTSCENE********************************

00A5: $IA_CAR_RM3 = create_car #BOBCAT at $IA_START_X $IA_START_Y $IA_START_Z 
0428: set_car $IA_CAR_RM3 avoid_level_transitions 1 
039C: set_car $IA_CAR_RM3 watertight 1 
0129: $IA_CAR_DRIVER_1 = create_actor PEDTYPE_CIVMALE #B_MAN3 in_car $IA_CAR_RM3 driverseat 
039E: set_char_cant_be_dragged_out $IA_CAR_DRIVER_1 to 1 
02AA: set_car $IA_CAR_RM3 immune_to_nonplayer 1 
03ED: set_car $IA_CAR_RM3 not_damaged_when_upside_down 1 
02AC: set_car $IA_CAR_RM3 immunities 1 1 1 0 1 
00AD: set_car_cruise_speed $IA_CAR_RM3 to 20.0 
00AE: set_car_driving_style $IA_CAR_RM3 to DRIVINGMODE_AVOIDCARS 
00A8: car_wander_randomly $IA_CAR_RM3 
0186: $PROSECUTION_CAR_BLIP = create_marker_above_car $IA_CAR_RM3 
020A: set_car $IA_CAR_RM3 door_status_to CARLOCK_LOCKED
if
	0038:   $ONMISSION == 0 
then
	0187: $RAYS_EVIDENCE_BLIP = create_marker_above_actor $IA_CAR_DRIVER_1
end

00AA: get_car_coordinates $IA_CAR_RM3 store_to $CAR_STUCK_X $CAR_STUCK_Y $CAR_STUCK_Z 
00AA: get_car_coordinates $IA_CAR_RM3 store_to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 3.0 
0107: $EVIDENCE_1 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 1.0 
0107: $EVIDENCE_2 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 1.0 
0107: $EVIDENCE_3 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 1.0 
0107: $EVIDENCE_4 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 1.0 
0107: $EVIDENCE_5 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0009: $IA_CAR_Z += 1.0 
0107: $EVIDENCE_6 = create_object #FILES at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
0382: set_object $EVIDENCE_1 collision_detection 0 
0382: set_object $EVIDENCE_2 collision_detection 0 
0382: set_object $EVIDENCE_3 collision_detection 0 
0382: set_object $EVIDENCE_4 collision_detection 0 
0382: set_object $EVIDENCE_5 collision_detection 0 
0382: set_object $EVIDENCE_6 collision_detection 0 
035C: place_object $EVIDENCE_1 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
035C: place_object $EVIDENCE_2 relative_to_car $IA_CAR_RM3 offset 0.25 -1.1875 -0.0625 
035C: place_object $EVIDENCE_3 relative_to_car $IA_CAR_RM3 offset -0.25 -1.1875 -0.0625 
035C: place_object $EVIDENCE_4 relative_to_car $IA_CAR_RM3 offset 0.25 -0.6875 -0.0625 
035C: place_object $EVIDENCE_5 relative_to_car $IA_CAR_RM3 offset -0.25 -0.6875 -0.0625 
035C: place_object $EVIDENCE_6 relative_to_car $IA_CAR_RM3 offset -0.25 -1.6875 -0.0625 
0004: $IA_HAVE_EVIDENCE_FLAG = 1
if
	00E0:   is_player_in_any_car $PLAYER_CHAR
then
	00D9: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
	if and
		80DE:   not is_player_in_model $PLAYER_CHAR model #RHINO
		0185:   car $PLAYER_CAR >= 500
	then
		0224: set_car $PLAYER_CAR health_to 500
	end
end

while 001A:   6 > $AMOUNT_OF_EVIDENCE_PLAYER_HAS
	wait 0 ms

	// Check if the player is still in the same car, if in a different car set the car health to low
	// and store the car handle. We want to keep the Rhino as a nice secret, so if the player is in one
	// the health won't be decreased.
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR
	then
		if 
			80DC:   not is_player_in_car $PLAYER_CHAR car $PLAYER_CAR
		then
			00D9: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
			if and
				80DE:   not is_player_in_model $PLAYER_CHAR model #RHINO
				0185:   car $PLAYER_CAR >= 500
			then
				0224: set_car $PLAYER_CAR health_to 500
			end

		end
	end
	if
		0119:   car $IA_CAR_RM3 wrecked 
	then
		if
			02BF:   car $IA_CAR_RM3 sunk
		then
			if and
				81FC:   not player $PLAYER_CHAR near_car $IA_CAR_RM3 radius 50.0 50.0 unknown 0 
				82CA:   not is_car_on_screen $IA_CAR_RM3 
			then
				00AA: get_car_coordinates $IA_CAR_RM3 store_to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
				03D3: get_closest_car_node_at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z store_to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z heading $WARP_HEADING 
			else
				00BC: print_now 'RM3_6' duration 5000 ms flag 1  // ~r~The photos will be washed up all over Liberty!
				goto @MISSION_FAILED_RAY3
			end
		else
			goto @MISSION_PASSED_RAY3
		end
	end
	
	if and
		01F4:   car $IA_CAR_RM3 flipped 
		01C1:   car $IA_CAR_RM3 stopped
	then
		gosub @RESTORE_CAR_RAY3
	end
	
	if and
		0038:   $TIMERA_RESET_FLAG == 1 
		81C1:   not car $IA_CAR_RM3 stopped 
	then
		0004: $TIMERA_RESET_FLAG = 0
	end
	
	if
		01C1:   car $IA_CAR_RM3 stopped
	then
		if
			0038:   $TIMERA_RESET_FLAG == 0 
		then
			0006: 16@ = 0 
			0004: $TIMERA_RESET_FLAG = 1 
		end
		if and
			0019:   16@ > 5000 
			0038:   $TIMERA_RESET_FLAG == 1
		then
			gosub @RESTORE_CAR_RAY3	
		end
	end

	if
		81AF:   not car $IA_CAR_RM3 0 $CAR_STUCK_X $CAR_STUCK_Y $CAR_STUCK_Z radius 4.0 4.0 4.0 
	then
		00AA: get_car_coordinates $IA_CAR_RM3 store_to $CAR_STUCK_X $CAR_STUCK_Y $CAR_STUCK_Z 
		0004: $TIMERC_RESET_FLAG_R3 = 0
	end

	if
		01AF:   car $IA_CAR_RM3 0 $CAR_STUCK_X $CAR_STUCK_Y $CAR_STUCK_Z radius 4.0 4.0 4.0 
	then
		if
			0038:   $TIMERC_RESET_FLAG_R3 == 0
		then
			01BD: $TIMERC_STARTED_R3 = current_time_in_ms 
			0004: $TIMERC_RESET_FLAG_R3 = 1 
		else
			01BD: $TIMERC_CURRENT_R3 = current_time_in_ms 
			0084: $TIMERC_R3 = $TIMERC_CURRENT_R3 
			0060: $TIMERC_R3 -= $TIMERC_STARTED_R3
			if
				0018:   $TIMERC_R3 > 8000 
			then
				gosub @RESTORE_CAR_RAY3	
			end
		end
	end
		
	01BD: $TIMER_FOR_SPEED = current_time_in_ms 
	0060: $TIMER_FOR_SPEED -= $RESET_FOR_TIMER 
	if
		0018:   $TIMER_FOR_SPEED > 1000 
	then
		01BD: $RESET_FOR_TIMER = current_time_in_ms 
		if
			01FC:   player $PLAYER_CHAR near_car $IA_CAR_RM3 radius 50.0 50.0 unknown 0 
		then
			00AD: set_car_cruise_speed $IA_CAR_RM3 to 50.0 
		else
			if
				01FC:   player $PLAYER_CHAR near_car $IA_CAR_RM3 radius 130.0 130.0 unknown 0 
			then
				00AD: set_car_cruise_speed $IA_CAR_RM3 to 34.0 
			else
				00AD: set_car_cruise_speed $IA_CAR_RM3 to 20.0 
			end
		end
	end
	
	if
		0038:   $IA_HAVE_EVIDENCE_FLAG == 0 
	then
		if
			0019:   17@ > 500 
		then
			if
				00F5:   player $PLAYER_CHAR 0 $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z radius 1.5 1.5 1.5 
			then
				gosub @EVIDENCE_COLLECTED
			end
		end
		if
			0019:   17@ > 10000 
		then
			if
				00E3:   player $PLAYER_CHAR 0 $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y radius 1.5 1.5
			then
				gosub @EVIDENCE_COLLECTED
			end
		end
	end
	
	0084: $IA_CAR_PREVIOUS_HEALTH = $IA_CAR_CURRENT_HEALTH 
	0227: $IA_CAR_CURRENT_HEALTH = car $IA_CAR_RM3 health 
	if
		0038:   $IA_HAVE_EVIDENCE_FLAG == 1
	then
		if
			020D:   car $IA_CAR_RM3 is_upright
		then
			0084: $TEMPORARY_HEALTH_VAR = $IA_CAR_PREVIOUS_HEALTH 
			0060: $TEMPORARY_HEALTH_VAR -= $AMOUNT_DAMAGE_IA_DROP_EVIDENCE
			if
				001C:   $TEMPORARY_HEALTH_VAR > $IA_CAR_CURRENT_HEALTH 
			then
				00BC: print_now 'RM3_4' duration 3000 ms flag 1  // ~g~The Prosecution has dropped the evidence!
				0224: set_car $IA_CAR_RM3 health_to 1000 
				0004: $IA_CAR_CURRENT_HEALTH = 1000 
				0004: $IA_CAR_PREVIOUS_HEALTH = 1000 
				0004: $IA_HAVE_EVIDENCE_FLAG = 0 
				0004: $DROP_ONE_FLAG = 0 
				0004: $GET_COORDS_FLAG = 1 
			end
		end
	end
	
	if and
		0038:   $IA_HAVE_EVIDENCE_FLAG == 0 
		0038:   $DROP_ONE_FLAG == 0 
	then
		0008: $DROP_EVIDENCE += 1 
		0164: disable_marker $RAYS_EVIDENCE_BLIP 
		if
			0038:   $DROP_EVIDENCE == 1
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_1
			gosub @DROP_PACKAGE_RAY3
			00AD: set_car_cruise_speed $IA_CAR_RM3 to 100.0 
			00AE: set_car_driving_style $IA_CAR_RM3 to DRIVINGMODE_AVOIDCARS
		end
		if
			0038:   $DROP_EVIDENCE == 2
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_2
			gosub @DROP_PACKAGE_RAY3
		end
		if
			0038:   $DROP_EVIDENCE == 3
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_3
			gosub @DROP_PACKAGE_RAY3
		end
		if
			0038:   $DROP_EVIDENCE == 4
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_4
			gosub @DROP_PACKAGE_RAY3
		end
		if
			0038:   $DROP_EVIDENCE == 5
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_5
			gosub @DROP_PACKAGE_RAY3
		end
		if
			0038:   $DROP_EVIDENCE == 6
		then
			0084: $EVIDENCE_TEMP = $EVIDENCE_6
			gosub @DROP_PACKAGE_RAY3
			0164: disable_marker $PROSECUTION_CAR_BLIP 
		end
		0004: $DROP_ONE_FLAG = 1 
	end
	
	if
		0038:   $GET_COORDS_FLAG == 1 
	then
		if
			0038:   $DROP_EVIDENCE == 1 
		then
			01BB: store_object $EVIDENCE_1 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
		if
			0038:   $DROP_EVIDENCE == 2
		then
			01BB: store_object $EVIDENCE_2 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
		if
			0038:   $DROP_EVIDENCE == 3
		then
			01BB: store_object $EVIDENCE_3 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
		if
			0038:   $DROP_EVIDENCE == 4
		then
			01BB: store_object $EVIDENCE_4 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
		if
			0038:   $DROP_EVIDENCE == 5
		then
			01BB: store_object $EVIDENCE_5 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
		if
			0038:   $DROP_EVIDENCE == 6
		then
			01BB: store_object $EVIDENCE_6 position_to $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
		end
	end
	
	if
		0038:   $IA_HAVE_EVIDENCE_FLAG == 0 
	then
		if
			0038:   $RED == 0 
		then
			0004: $RED_DECREASE_FLAG = 0 
			0004: $RED_INCREASE_FLAG = 1 
		end
		if
			0038:   $RED == 250 
		then
			0004: $RED_DECREASE_FLAG = 1 
			0004: $RED_INCREASE_FLAG = 0 
		end
		if
			0038:   $RED_INCREASE_FLAG == 1 
		then
			0008: $RED += 10 
		end
	
		if
			0038:   $RED_DECREASE_FLAG == 1
		then
			000C: $RED -= 10 
		end
		if
			0038:   $GREEN == 0 
		then
			0004: $GREEN_DECREASE_FLAG = 0 
			0004: $GREEN_INCREASE_FLAG = 1 
		end
		if
			0038:   $GREEN == 250 
		then
			0004: $GREEN_DECREASE_FLAG = 1 
			0004: $GREEN_INCREASE_FLAG = 0 
		end
		if
			0038:   $GREEN_INCREASE_FLAG == 1 
		then
			0008: $GREEN += 10 
		end
		if
			0038:   $GREEN_DECREASE_FLAG == 1
		then
			000C: $GREEN -= 10 
		end
		024F: create_corona 0.5 6 0 with_color $RED $GREEN 0 at_point $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
	end
	
	if
		001A:   1 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_1 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	if
		001A:   2 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_2 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	if
		001A:   3 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_3 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	if
		001A:   4 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_4 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	if
		001A:   5 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_5 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	if
		001A:   6 > $DROP_EVIDENCE
	then
		035C: place_object $EVIDENCE_6 relative_to_car $IA_CAR_RM3 offset 0.25 -1.6875 -0.0625 
	end
	
end //while


0164: disable_marker $RAYS_EVIDENCE_BLIP 
00BC: print_now 'RM3_1' duration 5000 ms flag 1  // ~g~Leave the evidence in a car then torch the car.

while 80E0:   not is_player_in_any_car $PLAYER_CHAR 
	wait 0 ms
end

00DA: $PLAYERS_CAR = store_car_player_is_in $PLAYER_CHAR 

while 00E0:   is_player_in_any_car $PLAYER_CHAR 
	wait 0 ms
end

if
	8119:   not car $PLAYERS_CAR wrecked
then
	0186: $RAYS_EVIDENCE_BLIP = create_marker_above_car $PLAYERS_CAR 
	0151: remove_status_text $AMOUNT_OF_EVIDENCE_PLAYER_HAS 
	00BC: print_now 'RM3_7' duration 5000 ms flag 1  // ~g~Now torch the car!
	while 8119:   not car $PLAYERS_CAR wrecked 
		wait 0 ms
	end
end

goto @MISSION_PASSED_RAY3

/////////////////////////////////////////

:DROP_PACKAGE_RAY3
01C0: $TARGET_WANTED_LEVEL = player $PLAYER_CHAR wanted_level
0008: $TARGET_WANTED_LEVEL += 1
if
	001C:   $TARGET_WANTED_LEVEL > $MIN_WANTED_LEVEL
then
	010E: set_player $PLAYER_CHAR minimum_wanted_level_to $TARGET_WANTED_LEVEL
else
	010E: set_player $PLAYER_CHAR minimum_wanted_level_to $MIN_WANTED_LEVEL
end
035C: place_object $EVIDENCE_TEMP relative_to_car $IA_CAR_RM3 offset 0.25 -1.1875 0.1875 
0188: $RAYS_EVIDENCE_BLIP = create_marker_above_object $EVIDENCE_TEMP 
0382: set_object $EVIDENCE_TEMP collision_detection 1 
0392: object $EVIDENCE_TEMP toggle_in_moving_list 1 
038C: object $EVIDENCE_TEMP scatter 0.0 0.0 16.0 
035D: make_object $EVIDENCE_TEMP targetable 
0006: 17@ = 0 
return

/////////////////////////////////////////

:RESTORE_CAR_RAY3
if
	82CA:   not is_car_on_screen $IA_CAR_RM3 
then
	00AA: get_car_coordinates $IA_CAR_RM3 store_to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
	03D3: get_closest_car_node_at $IA_CAR_X $IA_CAR_Y $IA_CAR_Z store_to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z heading $WARP_HEADING 
	if
		80C2:   not is_point_on_screen $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 3.0 
	then
		00AB: set_car_coordinates $IA_CAR_RM3 to $IA_CAR_X $IA_CAR_Y $IA_CAR_Z 
		0175: set_car $IA_CAR_RM3 z_angle_to $WARP_HEADING 
	end
else
	if
		8038:   not  $DROP_EVIDENCE == 6 
	then
		gosub @CREATE_ANOTHER_CAR
	end
end
return
/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_RAY3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_RAY3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_RAY3
0004: $EVIDENCE_DASH_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 10000 
0110: clear_player $PLAYER_CHAR wanted_level 
0318: set_latest_mission_passed 'RM3'  // 'EVIDENCE DASH'
0394: play_mission_passed_music 1 
030C: set_mission_points += 1 
02A7: $DONALD_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_DON at 86.0625 -1548.688 28.25  
004F: create_thread @LOVE_MISSION1_LOOP
goto @MISSION_END_RAY3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_RAY3
0164: disable_marker $RAYS_EVIDENCE_BLIP 
0164: disable_marker $PROSECUTION_CAR_BLIP 
0151: remove_status_text $AMOUNT_OF_EVIDENCE_PLAYER_HAS 
0249: release_model #BOBCAT 
0249: release_model #B_MAN3 
0249: release_model #DONKEYMAG 
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_RAY = 0 
00D8: mission_has_finished 
return

/////////////////////////////////////////

:CREATE_ANOTHER_CAR
if
	0038:   $TIMERD_RESET_FLAG_R3 == 0 
then
	01BD: $TIMERD_STARTED_R3 = current_time_in_ms 
	0004: $TIMERD_RESET_FLAG_R3 = 1 
end

if
	0038:   $TIMERD_RESET_FLAG_R3 == 1 
then
	01BD: $TIMERD_CURRENT_R3 = current_time_in_ms 
	0084: $TIMERD_R3 = $TIMERD_CURRENT_R3 
	0060: $TIMERD_R3 -= $TIMERD_STARTED_R3 
	if
		0018:   $TIMERD_R3 > 15000 
	then
		00BC: print_now 'RM3_8' duration 5000 ms flag 1  // ~r~That car is a decoy!!
		0164: disable_marker $PROSECUTION_CAR_BLIP 
		01C3: remove_references_to_car $IA_CAR_RM3 
		01C2: remove_references_to_actor $IA_CAR_DRIVER_1 
		if
			00E3:   player $PLAYER_CHAR 0 $IA_START_X $IA_START_Y radius 150.0 150.0 
		then
			00A5: $IA_CAR_RM3 = create_car #BOBCAT at 254.8125 -667.375 25.25 
		else
			00A5: $IA_CAR_RM3 = create_car #BOBCAT at $IA_START_X $IA_START_Y $IA_START_Z 
		end
		0129: $IA_CAR_DRIVER_1 = create_actor PEDTYPE_CIVMALE #B_MAN3 in_car $IA_CAR_RM3 driverseat 
		039C: set_car $IA_CAR_RM3 watertight 1 
		039E: set_char_cant_be_dragged_out $IA_CAR_DRIVER_1 to 1 
		02AA: set_car $IA_CAR_RM3 immune_to_nonplayer 1 
		03ED: set_car $IA_CAR_RM3 not_damaged_when_upside_down 1 
		02AC: set_car $IA_CAR_RM3 immunities 1 1 1 0 1 
		00AD: set_car_cruise_speed $IA_CAR_RM3 to 100.0 
		00AE: set_car_driving_style $IA_CAR_RM3 to DRIVINGMODE_AVOIDCARS 
		00A8: car_wander_randomly $IA_CAR_RM3 
		0186: $PROSECUTION_CAR_BLIP = create_marker_above_car $IA_CAR_RM3 
		020A: set_car $IA_CAR_RM3 door_status_to CARLOCK_LOCKED 
		0428: set_car $IA_CAR_RM3 avoid_level_transitions 1 
		0004: $TIMERD_RESET_FLAG_R3 = 0 
	end
end
return

:EVIDENCE_COLLECTED
0164: disable_marker $RAYS_EVIDENCE_BLIP 
0004: $GET_COORDS_FLAG = 0 
018C: play_sound SOUND_EVIDENCE_PICKUP at $OBJECT_CURRENT_COORDS_X $OBJECT_CURRENT_COORDS_Y $OBJECT_CURRENT_COORDS_Z 
if
	0038:   $DROP_EVIDENCE == 1 
then
	0108: destroy_object $EVIDENCE_1 
	03C4: set_status_text_to $AMOUNT_OF_EVIDENCE_PLAYER_HAS 0 'COLLECT'  // COLLECTED:
end
if
	0038:   $DROP_EVIDENCE == 2
then
	0108: destroy_object $EVIDENCE_2
end
if
	0038:   $DROP_EVIDENCE == 3
then
	0108: destroy_object $EVIDENCE_3
end
if
	0038:   $DROP_EVIDENCE == 4
then
	0108: destroy_object $EVIDENCE_4
end
if
	0038:   $DROP_EVIDENCE == 5
then
	0108: destroy_object $EVIDENCE_5
end
if
	0038:   $DROP_EVIDENCE == 6
then
	0108: destroy_object $EVIDENCE_6
end
0008: $AMOUNT_OF_EVIDENCE_PLAYER_HAS += 1 
01E5: text_1number_highpriority 'RM3_5' number $AMOUNT_OF_EVIDENCE_PLAYER_HAS duration 5000 ms flag 1  // ~g~You have ~1~ of 6 evidence packages.
0004: $IA_HAVE_EVIDENCE_FLAG = 1 
0006: 17@ = 0 
return
