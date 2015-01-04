// *****************************************************************************************
// ************************************ Ray mission 1  ************************************* 
// ************************************ Silent Witness *************************************
// *****************************************************************************************
// *** There was a witness to Salvatore's murder, kill him! Go to the witness protection ***
// *** house and flush him out by throwing a grenade through the window. The witness and ***
// *** some police escorts run out and leg it in a car, chase them and kill them.	 ***
// *****************************************************************************************

// Mission start stuff

:M22_SILENCETHESNEAK

gosub @MISSION_START_RAY1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_RAY1
end

:MISSION_END_RAY1
gosub @MISSION_CLEANUP_RAY1
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_RAY1

0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_RAY = 1 
0004: $RAYS_CUTSCENE_FLAG = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'RAY1' 
0004: $WANTED_LVL_FLAG_R1 = 0 
0004: $GAME_TIMER_R1 = 0 
0004: $GAME_TIMER_START_R1 = 0 
0004: $CAR_MOVING_STUCK_FLAG = 0 
0004: $GETAWAY_STUCK_FLAG = 0 
0004: $GET_AWAY_CAR_HEALTH = 1000 
0004: $GAME_TIMER_CURRENT_R1 = 0 
0005: $GET_AWAY_CAR_X = 0.0 
0005: $GET_AWAY_CAR_Y = 0.0 
0005: $GET_AWAY_CAR_Z = 0.0 
0004: $MFAIL_TIMER = 0 
0004: $MFAIL_TIMER_CURRENT = 0 
0004: $MFAIL_TIMER_STARTED = 0 
0004: $MFAIL_TIMER_RESET_FLAG = 0 
0004: $CARLOCK_FLAG = 0 
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
02E4: load_cutscene_data 'R1_SW' 
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
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   2070 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM1_A' duration 8000 ms flag 1  // That scumbag McAffrey, he took more bribes than anyone.
while 001A:   6097 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM1_B' duration 8000 ms flag 1  // He thinks he's gonna get an honorable discharge if he turns states evidence.
while 001A:   9509 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM1_C' duration 8000 ms flag 1  // He just squealed!
while 001A:   11019 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM1_D' duration 8000 ms flag 1  // He's under armed protection in WitSec property down in Newport, some apartment behind the car park.
while 001A:   16109 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM1_E' duration 8000 ms flag 1  // Torch that place, that should flush 'em out, and you'll hunt 'em down, make sure he never talks to nobody.
while 001A:   21333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1500 ms
01B1: give_player $PLAYER_CHAR weapon WEAPONTYPE_GRENADE ammo 12 

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
0373: set_camera_directly_behind_player 
0296: unload_special_actor 1 
0249: release_model #TOILET 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0247: request_model #LI_MAN2 
0247: request_model #SENTINEL 
038B: load_all_models_now 

while true
	if or
		8248:   not model #LI_MAN2 available 
		8248:   not model #SENTINEL available 
	jf break
	wait 0 ms
end //while

03AF: set_streaming 1 
016A: fade 1 for 1500 ms 
0004: $RAYS_CUTSCENE_FLAG = 0 

while fading
	wait 0 ms
end

0247: request_model #SAFEHOUSE 
018A: $RAY1_BLIP = create_checkpoint_at 378.0 -443.1875 29.875 
00BC: print_now 'RM1_1' duration 5000 ms flag 1  // ~g~Check out the witness protection house.

while 8199:   not player $PLAYER_CHAR 0 330.3125 -471.375 375.9375 -431.0625 
	wait 0 ms
end

01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0 
015F: set_camera_position 373.25 -444.6875 28.5 rotation 0.0 0.0 0.0 
0160: point_camera 374.125 -444.25 28.75 switchstyle 1 
0001: wait 3000 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03F4: set_all_cars_can_be_damaged 1 
015A: restore_camera 
03CF: load_wav 'R1_A' 
0004: $GET_AWAY_CAR = 0 
0004: $POLICE_GUARD1 = 0 
0004: $POLICE_GUARD2 = 0 

while 82EE:   not is_projectile_in_cube 376.5 -445.1875 28.0625 to 380.0625 -441.1875 31.6875 //THE WINDOW
	wait 0 ms 
	0419: get_ammo_of_player $PLAYER_CHAR weapon WEAPONTYPE_GRENADE store_to $GET_AWAY_CAR 
	0419: get_ammo_of_player $PLAYER_CHAR weapon WEAPONTYPE_ROCKET store_to $POLICE_GUARD1 
	0058: $GET_AWAY_CAR += $POLICE_GUARD1 
	if and
		0038:   $POLICE_GUARD2 == 0 
		0038:   $GET_AWAY_CAR == 0
	then
		00BC: print_now 'RM1_4' duration 5000 ms flag 1  // ~g~You have used all the grenades! Get some more from ammunation!
		0164: disable_marker $RAY1_BLIP 
		02A8: $RAY1_BLIP = create_marker RADAR_SPRITE_WEAPON at 345.5 -713.5 26.0625 
		0004: $POLICE_GUARD2 = 1 
	end
	if and
		0038:   $POLICE_GUARD2 == 1 
		0018:   $GET_AWAY_CAR > 0 
	then
		00BC: print_now 'RM1_5' duration 5000 ms flag 1  // ~g~Go back and torch the safehouse!
		0164: disable_marker $RAY1_BLIP 
		018A: $RAY1_BLIP = create_checkpoint_at 378.0 -443.1875 29.875 
		0004: $POLICE_GUARD2 = 0 
	end
end //while

02EF: destroy_projectiles_in_cube 376.0625 -445.1875 28.0625 to 380.0625 -441.1875 31.6875 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0 
015F: set_camera_position 373.25 -444.6875 28.5 rotation 0.0 0.0 0.0 
0160: point_camera 374.125 -444.25 28.75 switchstyle INTERPOLATION 
0001: wait 100 ms 
020C: create_explosion EXPLOSION_GRENADE at 378.0 -443.5 28.875 
0001: wait 500 ms 
02CF: $FIRE_1 = create_fire_at 377.0 -444.0 28.0625 
02CF: $FIRE_2 = create_fire_at 377.0 -443.0 28.0625 
02CF: $FIRE_3 = create_fire_at 379.0 -444.0 28.0625 
02CF: $FIRE_4 = create_fire_at 379.0 -443.0 28.0625 
0444: create_fire_audio $FIRE_1 1 
0444: create_fire_audio $FIRE_2 0 
0444: create_fire_audio $FIRE_3 0 
0444: create_fire_audio $FIRE_4 0 
0001: wait 250 ms 
009A: $BURNING_COP = create_char PEDTYPE_CIVMALE model #COP at 378.0 -444.6875 28.25 
0001: wait 250 ms 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 377.0 -441.5625 28.875 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 378.0 -443.25 28.875 
0001: wait 800 ms 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 376.0 -443.3125 30.0 
0001: wait 500 ms 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 376.0 -442.6875 30.0 
02A2: create_particle POBJECT_DARK_SMOKE 0 at 376.0 -443.75 30.0 
0001: wait 1500 ms 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
03F4: set_all_cars_can_be_damaged 1 
02EB: restore_camera_jumpcut 
0373: set_camera_directly_behind_player 

00A5: $GET_AWAY_CAR = create_car #SENTINEL at 380.0 -437.5 21.0625 // IN GARAGE 
0175: set_car $GET_AWAY_CAR z_angle_to 90.0 
020A: set_car $GET_AWAY_CAR door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY 
03AB: set_car $GET_AWAY_CAR strong 1 
0224: set_car $GET_AWAY_CAR health_to 2000
02AC: set_car $GET_AWAY_CAR immunities 1 0 0 0 0 
0129: $POLICE_GUARD1 = create_actor PEDTYPE_CIVMALE #COP in_car $GET_AWAY_CAR driverseat 
01C8: $THE_WITNESS = create_actor PEDTYPE_CIVMALE model #LI_MAN2 in_car $GET_AWAY_CAR passenger_seat 1 
009A: $POLICE_GUARD2 = create_char PEDTYPE_CIVMALE model #COP at 376.5 -435.125 20.0625 
01B2: give_actor $POLICE_GUARD2 weapon WEAPONTYPE_CHAINGUN ammo 5000 
0211: actor $POLICE_GUARD2 walk_to 374.0 -435.125 
009A: $POLICE_GUARD3 = create_char PEDTYPE_CIVMALE model #COP at 376.5 -439.6875 20.0625 
01B2: give_actor $POLICE_GUARD3 weapon WEAPONTYPE_CHAINGUN ammo 5000 
0211: actor $POLICE_GUARD3 walk_to 374.0 -439.6875 
02B9: deactivate_garage $WITSEC_HOUSE_GARAGE 
0299: activate_garage $WITSEC_HOUSE_GARAGE 
0164: disable_marker $RAY1_BLIP 
00AD: set_car_cruise_speed $GET_AWAY_CAR to 20.0 
00AE: set_car_driving_style $GET_AWAY_CAR to DRIVINGMODE_AVOIDCARS 
00A8: car_wander_randomly $GET_AWAY_CAR 
0428: set_car $GET_AWAY_CAR avoid_level_transitions 1 
00BC: print_now 'RM1_2' duration 5000 ms flag 1  // ~g~Take out McAffrey!
01BD: $GAME_TIMER_START_R1 = current_time_in_ms 

while 00A2:   is_char_still_alive $THE_WITNESS 
	wait 0 ms
	if
		8118:   not actor $POLICE_GUARD2 dead 
	then
		if
			80A3:   not is_char_in_area_2d $POLICE_GUARD2 from 375.0 -441.5 to 386.0 -434.0 sphere 0 
		then
			01CA: actor $POLICE_GUARD2 kill_player $PLAYER_CHAR
		end
	end
	if
		8118:   not actor $POLICE_GUARD3 dead 
	then
		if
			80A3:   not is_char_in_area_2d $POLICE_GUARD3 from 375.0 -441.5 to 386.0 -434.0 sphere 0 
		then
			01CA: actor $POLICE_GUARD3 kill_player $PLAYER_CHAR
		end
	end
	if
		0038:   $WANTED_LVL_FLAG_R1 == 0 
	then
		01BD: $GAME_TIMER_CURRENT_R1 = current_time_in_ms 
		0084: $GAME_TIMER_R1 = $GAME_TIMER_CURRENT_R1 
		0060: $GAME_TIMER_R1 -= $GAME_TIMER_START_R1 
		if 
			0018:   $GAME_TIMER_R1 > 3000 
		then
			010E: set_player $PLAYER_CHAR minimum_wanted_level_to 4 
			0187: $RAY1_BLIP = create_marker_above_actor $THE_WITNESS 
			if
				03D0:   wav_loaded
			then
				03D1: play_wav 
			end
			0004: $WANTED_LVL_FLAG_R1 = 1 
		end
	end

	if
		0038:   $WANTED_LVL_FLAG_R1 == 1 
	then
		if and
			80E9:   not player $PLAYER_CHAR 0 $THE_WITNESS radius 160.0 160.0 
			82CB:   not is_actor_on_screen $THE_WITNESS 
		then
			if
				0038:   $MFAIL_TIMER_RESET_FLAG == 0 
			then
				0164: disable_marker $RAY1_BLIP 
				01BD: $MFAIL_TIMER_STARTED = current_time_in_ms 
				0004: $MFAIL_TIMER_RESET_FLAG = 1 

			end
			if
				0038:   $MFAIL_TIMER_RESET_FLAG == 1 
			then
				01BD: $MFAIL_TIMER_CURRENT = current_time_in_ms 
				0084: $MFAIL_TIMER = $MFAIL_TIMER_CURRENT 
				0060: $MFAIL_TIMER -= $MFAIL_TIMER_STARTED 
				if and
					0018:   $MFAIL_TIMER > 4000 
					82CB:   not is_actor_on_screen $THE_WITNESS 
				then
					0004: $MFAIL_TIMER_RESET_FLAG = 0 
					009B: delete_char $THE_WITNESS 
					00BC: print_now 'RM1_3' duration 5000 ms flag 1  // ~r~McAffrey escaped!
					goto @MISSION_FAILED_RAY1
				end
			end
		end
		if
			0038:   $MFAIL_TIMER_RESET_FLAG == 1 
		then
			if or
				00E9:   player $PLAYER_CHAR 0 $THE_WITNESS radius 160.0 160.0 
				02CB:   is_actor_on_screen $THE_WITNESS 
			then
				0164: disable_marker $RAY1_BLIP 
				0187: $RAY1_BLIP = create_marker_above_actor $THE_WITNESS 
				0004: $MFAIL_TIMER_RESET_FLAG = 0 
			end
		end
	end
	if
		80DF:   not is_char_in_any_car $THE_WITNESS 
	then
		01D0: actor $THE_WITNESS avoid_player $PLAYER_CHAR 
	end
	if
		8119:   not car $GET_AWAY_CAR wrecked 
	then
		if
			00DB:   is_char_in_car $THE_WITNESS car $GET_AWAY_CAR 
		then
			if and
				0038:   $CARLOCK_FLAG == 0 
				81AD:   not car $GET_AWAY_CAR sphere 0 near_point 380.0 -437.5 radius 40.0 40.0 
			then
				020A: set_car $GET_AWAY_CAR door_status_to CARLOCK_UNLOCKED 
				00AD: set_car_cruise_speed $GET_AWAY_CAR to 40.0 
				03AB: set_car $GET_AWAY_CAR strong 0
				if
					 0185:   car $GET_AWAY_CAR health >= 800 
				then
					0224: set_car $GET_AWAY_CAR health_to 800 
				end
			end
			if and
				01F4:   car $GET_AWAY_CAR flipped 
				01C1:   car $GET_AWAY_CAR stopped 
			then
				01D3: actor $THE_WITNESS leave_car $GET_AWAY_CAR 
				if
					8118:   not actor $POLICE_GUARD1 dead 
				then
					01CA: actor $POLICE_GUARD1 kill_player $PLAYER_CHAR 
					01B2: give_actor $POLICE_GUARD1 weapon WEAPONTYPE_CHAINGUN ammo 5000 
				end
			end
			if
				00DC:   is_player_in_car $PLAYER_CHAR car $GET_AWAY_CAR 
			then
				01D3: actor $THE_WITNESS leave_car $GET_AWAY_CAR 
				if
					8118:   not actor $POLICE_GUARD1 dead 
				then
					01CA: actor $POLICE_GUARD1 kill_player $PLAYER_CHAR 
					01B2: give_actor $POLICE_GUARD1 weapon WEAPONTYPE_CHAINGUN ammo 5000 
				end
			end
			0227: $GET_AWAY_CAR_HEALTH = car $GET_AWAY_CAR health 
			if
				001A:   200 > $GET_AWAY_CAR_HEALTH 
			then
				01D3: actor $THE_WITNESS leave_car $GET_AWAY_CAR 
				if
					8118:   not actor $POLICE_GUARD1 dead 
				then
					01CA: actor $POLICE_GUARD1 kill_player $PLAYER_CHAR 
					01B2: give_actor $POLICE_GUARD1 weapon WEAPONTYPE_CHAINGUN ammo 5000 
				end
			end
			if
				01C1:   car $GET_AWAY_CAR stopped 
			then
				if 
					0038:   $GETAWAY_STUCK_FLAG == 0 
				then
					0006: 16@ = 0 
					0004: $GETAWAY_STUCK_FLAG = 1 
				end
				if and
					0038:   $GETAWAY_STUCK_FLAG == 1 
					0019:   16@ > 5000
				then
					01D3: actor $THE_WITNESS leave_car $GET_AWAY_CAR 
					if
						8118:   not actor $POLICE_GUARD1 dead 
					then
						01CA: actor $POLICE_GUARD1 kill_player $PLAYER_CHAR 
					01B2: give_actor $POLICE_GUARD1 weapon WEAPONTYPE_CHAINGUN ammo 5000 
					end
				end
			end
			if
				81C1:   not car $GET_AWAY_CAR stopped 
			then
				0004: $GETAWAY_STUCK_FLAG = 0 
			end
			if
				01AD:   car $GET_AWAY_CAR sphere 0 near_point $GET_AWAY_CAR_X $GET_AWAY_CAR_Y radius 3.0 3.0 
			then
				if
					0038:   $CAR_MOVING_STUCK_FLAG == 0 
				then
					0006: 17@ = 0 
					0004: $CAR_MOVING_STUCK_FLAG = 1
				end
				if and
					0038:   $CAR_MOVING_STUCK_FLAG == 1 
					0019:   17@ > 8000 
				then
					01D3: actor $THE_WITNESS leave_car $GET_AWAY_CAR 
					if
						8118:   not actor $POLICE_GUARD1 dead 
					then
						01CA: actor $POLICE_GUARD1 kill_player $PLAYER_CHAR 
					01B2: give_actor $POLICE_GUARD1 weapon WEAPONTYPE_CHAINGUN ammo 5000 
					end
				end
			else
				00AA: get_car_coordinates $GET_AWAY_CAR store_to $GET_AWAY_CAR_X $GET_AWAY_CAR_Y $GET_AWAY_CAR_Z 
				0004: $CAR_MOVING_STUCK_FLAG = 0 
			end
		end
	end
end //while

goto @MISSION_PASSED_RAY1

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_RAY1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_RAY1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_RAY1
0004: $SILENCE_THE_SNEAK_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 30000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 30000 
0394: play_mission_passed_music 1 
0318: set_latest_mission_passed 'RM1'  // 'SILENCE THE SNEAK'
030C: set_mission_points += 1 
004F: create_thread @RAY_MISSION2_LOOP 
goto @MISSION_END_RAY1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_RAY1
0164: disable_marker $RAY1_BLIP 
03AE: remove_objects_from_cube 372.0 -449.0 25.0 to 383.0 -436.0 33.0 
0249: release_model #LI_MAN2 
0249: release_model #SENTINEL 
0249: release_model #SAFEHOUSE 
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_RAY = 0 
031A: remove_all_fires 
00D8: mission_has_finished 
return

