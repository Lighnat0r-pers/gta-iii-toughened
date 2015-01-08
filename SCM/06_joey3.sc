// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 3****************************************
// ***************************************Van heist*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

:M06_VANHEIST

gosub @MISSION_START_JOEY3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_JOEY3
end

:MISSION_END_JOEY3
gosub @MISSION_CLEANUP_JOEY3
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_JOEY3
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_JOEY = 1 
03A4: name_thread 'JOEY3' 
0001: wait 0 ms 
0004: $IN_THE_LOCATE_JOEY3 = 0 
0004: $JOEY3_AMBUSH_TRIGGERED = 0
0004: $SECRET_TRIGGERED_JOEY3 = 0
0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 0
0004: $SECRET_ACTIVATED_JOEY3 = 0
0004: $PLAYER_PASSENGER = 0
0004: $PLAYER_PASSENGER_OLD = 0
0004: $SECRET_SEAT_FLAG_JOEY3 = 0
023C: load_special_actor 'JOEY' as 1 
02F3: load_object #CUTOBJ01 'JOEYH' 
02F3: load_object #CUTOBJ02 'PLAYERH' 
02F3: load_object #CUTOBJ03 'TROLL' 
0247: request_model #JOGARAGEEXT 
0247: request_model #JOGARAGEINT 
038B: load_all_models_now 

while true
	if or
		8248:   not model #JOGARAGEEXT available 
		8248:   not model #JOGARAGEINT available 
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'J3_VH' 
0244: set_cutscene_pos 1190.063 -869.8125 13.9375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_JOEY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_JOEY 'JOEY' 
02F4: create_cutscene_actor $JOEY_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_JOEY 
02F5: set_head_anim $JOEY_CSHEAD 'JOEY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_TROLL = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $CS_TROLL 'TROLL' 
0395: clear_area 1 at 1191.875 -870.375 range 15.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1191.875 -870.375 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 230.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   5515 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_A' duration 10000 ms flag 2  // Alright, we're gonna hit the pay role van.
while 001A:   7894 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_B' duration 10000 ms flag 2  // It leaves the edge of China Town everyday.
while 001A:   10381 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_C' duration 10000 ms flag 2  // Bullets won't even dent the van's armor, so get a car and ram it off the road.
while 001A:   14589 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_D' duration 10000 ms flag 2  // Now hit it hard and the punk ass security guards should bail.
while 001A:   17518 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_E' duration 10000 ms flag 2  // Then take it to the warehouse at the docks and my guys are gonna take over from there.
while 001A:   21627 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM3_F' duration 10000 ms flag 2  // Now it won't be doin' it's rounds all day, so don't hang around.
while 001A:   24675 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   27333 > $CUT_SCENE_TIME
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
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #JOGARAGEEXT 
0249: release_model #JOGARAGEINT 
023C: load_special_actor 'S_GUARD' as 2 
0247: request_model #SECURICA 
0247: request_model #PROSTITUTE 

while true
	if or
		823D:   not special_actor 2 loaded 
		8248:   not model #SECURICA available
		8248:   not model #PROSTITUTE available 
	jf break
	wait 0 ms
end //while

// START OF MISSION

009A: $JOEY3_SECRET_HOOKER = create_char PEDTYPE_SPECIAL model #PROSTITUTE at 1155.0 -854.0 -100.0
0173: set_actor $JOEY3_SECRET_HOOKER z_angle_to 100.0 
00A5: $JOEY3_VAN = create_car #SECURICA at 1063.0 -805.0 14.5625
020A: set_car $JOEY3_VAN door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
02AA: set_car $JOEY3_VAN immune_to_nonplayer 1 
02AC: set_car $JOEY3_VAN immunities 1 1 1 0 1 
00AD: set_car_cruise_speed $JOEY3_VAN to 14.0 
00AE: set_car_driving_style $JOEY3_VAN to DRIVINGMODE_STOPFORCARS
0186: $JOEY3_VAN_MARKER = create_marker_above_car $JOEY3_VAN 
0129: $JOEY3_VAN_DRIVER = create_actor PEDTYPE_SPECIAL #SPECIAL02 in_car $JOEY3_VAN driverseat
0243: set_actor $JOEY3_VAN_DRIVER ped_stats_to PEDSTAT_GEEK_GUY
01C8: $JOEY3_VAN_PASSENGER = create_actor PEDTYPE_SPECIAL model #SPECIAL02 in_car $JOEY3_VAN passenger_seat 0
0243: set_actor $JOEY3_VAN_PASSENGER ped_stats_to PEDSTAT_GEEK_GUY
0227: $JOEY3_VAN_HEALTH = car $JOEY3_VAN health 
03C4: set_status_text_to $JOEY3_VAN_HEALTH COUNTER_DISPLAY_BAR 'DAM'  // DAMAGE:
gosub @CHECK_SECURICAR_HEALTH_STATUS1_JOEY3

while 0185:   car $JOEY3_VAN health >= 999
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	gosub @CHECK_SECURICAR_HEALTH_STATUS1_JOEY3
	gosub @CHECK_SECRET_TRIGGER_JOEY3
	gosub @SECRET_TIMER_JOEY3
end //while

if
	8118:   not actor $PLAYER_PASSENGER dead
then
	01E0: clear_leader $PLAYER_PASSENGER
end

if
	8119:   not car $JOEY3_VAN wrecked 
then
	00AE: set_car_driving_style $JOEY3_VAN to DRIVINGMODE_AVOIDCARS
	00AD: set_car_cruise_speed $JOEY3_VAN to 20.0 
	010E: set_player $PLAYER_CHAR minimum_wanted_level_to 1 
	02AA: set_car $JOEY3_VAN immune_to_nonplayer 0 
	0227: $JOEY3_VAN_HEALTH_OLD = car $JOEY3_VAN health 
end

while 0185:   car $JOEY3_VAN health >= 900
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if
		8119:   not car $JOEY3_VAN wrecked 
	then
		0227: $JOEY3_VAN_HEALTH = car $JOEY3_VAN health
		if
			001C:   $JOEY3_VAN_HEALTH_OLD > $JOEY3_VAN_HEALTH
		then
			010E: set_player $PLAYER_CHAR minimum_wanted_level_to 1 
		end
		gosub @CHECK_SECURICAR_HEALTH_STATUS2_JOEY3
	end
end //while

if
	8119:   not car $JOEY3_VAN wrecked 
then
	00AD: set_car_cruise_speed $JOEY3_VAN to 25.0
end

while 0185:   car $JOEY3_VAN health >= 750
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if
		8119:   not car $JOEY3_VAN wrecked 
	then
		0227: $JOEY3_VAN_HEALTH = car $JOEY3_VAN health
		if
			001C:   $JOEY3_VAN_HEALTH_OLD > $JOEY3_VAN_HEALTH
		then
			010E: set_player $PLAYER_CHAR minimum_wanted_level_to 2 
		end
		gosub @CHECK_SECURICAR_HEALTH_STATUS2_JOEY3
	end
end //while

if
	8119:   not car $JOEY3_VAN wrecked 
then
	00AD: set_car_cruise_speed $JOEY3_VAN to 30.0
end

while 0185:   car $JOEY3_VAN health >= 600
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if
		8119:   not car $JOEY3_VAN wrecked 
	then
		0227: $JOEY3_VAN_HEALTH = car $JOEY3_VAN health
		if
			001C:   $JOEY3_VAN_HEALTH_OLD > $JOEY3_VAN_HEALTH
		then
			010E: set_player $PLAYER_CHAR minimum_wanted_level_to 3 
		end
		gosub @CHECK_SECURICAR_HEALTH_STATUS2_JOEY3
	end
end //while

if
	8119:   not car $JOEY3_VAN wrecked
then
	020A: set_car $JOEY3_VAN door_status_to CARLOCK_UNLOCKED
	0151: remove_status_text $JOEY3_VAN_HEALTH
	010E: set_player $PLAYER_CHAR minimum_wanted_level_to 4
	02AC: set_car $JOEY3_VAN immunities 0 0 0 0 0
	0224: set_car $JOEY3_VAN health_to 100
	if
		8118:   not actor $JOEY3_VAN_DRIVER dead
	then
		01D3: actor $JOEY3_VAN_DRIVER leave_car $JOEY3_VAN
	end
	if
		8118:   not actor $JOEY3_VAN_PASSENGER dead
	then
		01D3: actor $JOEY3_VAN_PASSENGER leave_car $JOEY3_VAN
	end
end

gosub @CHECK_VEHICLE_STATUS_JOEY3

while true
	if or
		80DB:   not is_char_in_car $JOEY3_VAN_DRIVER car $JOEY3_VAN 
		80DB:   not is_char_in_car $JOEY3_VAN_PASSENGER car $JOEY3_VAN 
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
end //while

wait 1600 ms 
gosub @CHECK_VEHICLE_STATUS_JOEY3

if and
	8118:   not actor $JOEY3_VAN_DRIVER dead 
	8118:   not actor $JOEY3_VAN_PASSENGER dead
then
	01D0: actor $JOEY3_VAN_DRIVER avoid_player $PLAYER_CHAR 
	01D0: actor $JOEY3_VAN_PASSENGER avoid_player $PLAYER_CHAR 
	041C: make_actor $JOEY3_VAN_PASSENGER say SOUND_SECURITY_GUARD_RUN_AWAY_SHOUT
end


if
	8119:   not car $JOEY3_VAN wrecked
then
	021B: set_garage $SECURICAR_GARAGE to_accept_car $JOEY3_VAN
end

0004: $FLAG_CAR_BLIP_DISPLAYED_JM3 = 1

009A: $JOEY3_AMBUSH = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 1453.0 -818.0 12.0
0173: set_actor $JOEY3_AMBUSH z_angle_to 50.0 
01B2: give_actor $JOEY3_AMBUSH weapon WEAPONTYPE_SHOTGUN ammo 20
0243: set_actor $JOEY3_AMBUSH ped_stats_to PEDSTAT_TOUGH_GUY 
011A: set_actor $JOEY3_AMBUSH search_threat THREAT_PLAYER1

:GARAGE_STOP
0006: 17@ = 0 
while true
	if or
		81AC:   not car $JOEY3_VAN stopped 0 1440.688 -805.5625 10.875 1449.75 -782.0625 15.875 
		80DC:   not is_player_in_car $PLAYER_CHAR car $JOEY3_VAN 
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	gosub @CHECK_IN_VEHICLE_STATUS_JOEY3
	if
		0038:   $SECRET_ACTIVATED_JOEY3 == 0
	then
		if and
			8118:   not actor $JOEY3_VAN_PASSENGER dead
			0019:   17@ > 4000 
		then
			0006: 17@ = 0 
			041C: make_actor $JOEY3_VAN_PASSENGER say SOUND_SECURITY_GUARD_RUN_AWAY_SHOUT
		end
		if and
			0038:   $JOEY3_AMBUSH_TRIGGERED == 0
			00F5:   player $PLAYER_CHAR 0 1444.0 -811.0 11.75 radius 20.0 20.0 10.0
		then
			01CA: actor $JOEY3_AMBUSH kill_player $PLAYER_CHAR 
			0004: $JOEY3_AMBUSH_TRIGGERED = 1 	
		end
	end
	if
		0038:   $IN_THE_LOCATE_JOEY3 == 0
	then
		if
			00F7:   player $PLAYER_CHAR sphere 1 near_point_in_car 1445.0 -811.5 11.75 radius 4.0 6.0 4.0
		then
			0110: clear_player $PLAYER_CHAR wanted_level 
			0004: $IN_THE_LOCATE_JOEY3 = 1 	
		end
	end
	if
		0038:   $IN_THE_LOCATE_JOEY3 == 1
	then
		if and
			80B1:   not is_car_in_area_3d $JOEY3_VAN from 1440.688 -805.5625 10.875 to 1449.75 -782.0625 15.875 sphere 0 
			80F7:   not player $PLAYER_CHAR sphere 0 near_point_in_car 1445.0 -811.5 11.75 radius 4.0 6.0 4.0
		then
			0004: $IN_THE_LOCATE_JOEY3 = 0
		end
	end
end //while

00BC: print_now 'OUT_VEH' duration 5000 ms flag 2  // ~g~Get out of the vehicle!

while 821C:   not car_inside_garage $SECURICAR_GARAGE
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if
		80B1:   not is_car_in_area_3d $JOEY3_VAN from 1440.688 -805.5625 10.875 to 1449.75 -782.0625 15.875 sphere 0
	then
		goto @GARAGE_STOP
	end
	wait 0 ms 	// has to be here otherwise it will see that the vehicle is destroyed failing the mission
			// before seeing that it is in the garage.
end //while

0164: disable_marker $BLIP2_JM3 

goto @MISSION_PASSED_JOEY3

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_JOEY3
if
	0119:   car $JOEY3_VAN wrecked 
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_JOEY3
end
if and
	01F4:   car $JOEY3_VAN flipped 
	01C1:   car $JOEY3_VAN stopped
then
	goto @MISSION_FAILED_JOEY3
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_JOEY3
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $JOEY3_VAN
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM3 == 1 
then
	018A: $BLIP2_JM3 = create_checkpoint_at 1445.75 -796.6875 -100.0 
	018B: show_on_radar $BLIP2_JM3 BLIP_ONLY
	0164: disable_marker $JOEY3_VAN_MARKER 
	00BC: print_now 'JM3_1' duration 5000 ms flag 1  // ~g~Take the van to the lock up.
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM3 = 0
end
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $JOEY3_VAN
	0038:   $FLAG_CAR_BLIP_DISPLAYED_JM3 == 0
then
	0186: $JOEY3_VAN_MARKER = create_marker_above_car $JOEY3_VAN 
	0164: disable_marker $BLIP2_JM3 
	00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	0004: $FLAG_CAR_BLIP_DISPLAYED_JM3 = 1
end
return

/////////////////////////////////////////

:CHECK_SECURICAR_HEALTH_STATUS1_JOEY3
0227: $JOEY3_VAN_HEALTH = car $JOEY3_VAN health 
0004: $JOEY3_VAN_HEALTH_LOST = 1000 
0060: $JOEY3_VAN_HEALTH_LOST -= $JOEY3_VAN_HEALTH 
if
	0018:   $JOEY3_VAN_HEALTH_LOST > 400 
then
	0004: $JOEY3_VAN_HEALTH_LOST = 400
end
0084: $JOEY3_VAN_HEALTH = $JOEY3_VAN_HEALTH_LOST 
0014: $JOEY3_VAN_HEALTH /= 4 
return

/////////////////////////////////////////

:CHECK_SECURICAR_HEALTH_STATUS2_JOEY3
0084: $JOEY3_VAN_HEALTH_OLD = $JOEY3_VAN_HEALTH 
0004: $JOEY3_VAN_HEALTH_LOST = 1000 
0060: $JOEY3_VAN_HEALTH_LOST -= $JOEY3_VAN_HEALTH 
if
	0018:   $JOEY3_VAN_HEALTH_LOST > 400 
then
	0004: $JOEY3_VAN_HEALTH_LOST = 400
end
0084: $JOEY3_VAN_HEALTH = $JOEY3_VAN_HEALTH_LOST 
0014: $JOEY3_VAN_HEALTH /= 4
return

////////////////////////////////////////

:CHECK_SECRET_TRIGGER_JOEY3
if
	00E0:   is_player_in_any_car $PLAYER_CHAR
then
	00DA: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
	if
		8431:   not car $PLAYER_CAR passenger_seat_free 0
	then
		0004: $SECRET_SEAT_FLAG_JOEY3 = 0
		gosub @SECRET_DO_PASSENGER_STUFF_JOEY3
	end
	if and
		0038:   $SECRET_TRIGGERED_JOEY3 == 0
		8431:   not car $PLAYER_CAR passenger_seat_free 1
	then
		0004: $SECRET_SEAT_FLAG_JOEY3 = 1
		gosub @SECRET_DO_PASSENGER_STUFF_JOEY3
	end
	if and
		0038:   $SECRET_TRIGGERED_JOEY3 == 0
		8431:   not car $PLAYER_CAR passenger_seat_free 2
	then
		0004: $SECRET_SEAT_FLAG_JOEY3 = 2
		gosub @SECRET_DO_PASSENGER_STUFF_JOEY3
	end

	if
		0038:   $SECRET_TRIGGERED_JOEY3 == 0 // No prostitute as passenger found.
	then
		if or
			0038:   $SECRET_HOOKER_PICKED_UP_JOEY3 == 0
			0118:   actor $JOEY3_SECRET_HOOKER dead
		then
			0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 0
		end
		if
			8118:   not actor $JOEY3_SECRET_HOOKER dead
		then
			00A0: get_char_coordinates $JOEY3_SECRET_HOOKER store_to $JOEY3_HOOKER_X $JOEY3_HOOKER_Y $JOEY3_HOOKER_Z 
			if
				00E8: player $PLAYER_CHAR stopped 0 near_point_in_car $JOEY3_HOOKER_X $JOEY3_HOOKER_Y radius 5.0 5.0
			then
				01D4: actor $JOEY3_SECRET_HOOKER go_to_car $PLAYER_CAR and_enter_it_as_a_passenger
				0004: $SECRET_HOOKER_PICKED_UP_JOEY3 = 1
			end
		end
	end
else
	if or
		0038:   $SECRET_HOOKER_PICKED_UP_JOEY3 == 0
		0118:   actor $JOEY3_SECRET_HOOKER dead
	then
		0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 0
	end
end
return

////////////////////////////////////////

:SECRET_DO_PASSENGER_STUFF_JOEY3
if or
	0038:   $SECRET_HOOKER_PICKED_UP_JOEY3 == 0
	0118:   actor $JOEY3_SECRET_HOOKER dead
then
	0432: $PLAYER_PASSENGER = get_passenger_in_car $PLAYER_CAR seat $SECRET_SEAT_FLAG_JOEY3
	01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
else
	0084: $PLAYER_PASSENGER = $JOEY3_SECRET_HOOKER
end

// If it's not the same passenger as before, reset the timer, check if we're
// actually dealing with a prostitute and set the trigger flag for the secret if so.
// If the player enters through the passenger door the script will see him being the 
// passenger but the model check is made for a char not a player so it would cause a crash.
if and
	803A:   not $PLAYER_PASSENGER == $PLAYER_CHAR
	803A:   not $PLAYER_PASSENGER == $PLAYER_ACTOR
	803A:   not $PLAYER_PASSENGER_OLD == $PLAYER_PASSENGER
then
	0084: $PLAYER_PASSENGER_OLD = $PLAYER_PASSENGER
	0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 0
	if
		8118:   not actor $PLAYER_PASSENGER dead
	then
		if or
			02F2:   actor $PLAYER_PASSENGER model == #PROSTITUTE
			02F2:   actor $PLAYER_PASSENGER model == #PROSTITUTE2
		then
			01DF: tie_actor $PLAYER_PASSENGER to_player $PLAYER_CHAR 
			039E: set_char_cant_be_dragged_out $PLAYER_PASSENGER to 1
			0004: $SECRET_TRIGGERED_JOEY3 = 1
		else
			0004: $SECRET_TRIGGERED_JOEY3 = 0
		end
	else
		0004: $SECRET_TRIGGERED_JOEY3 = 0
	end
end
return

////////////////////////////////////////

:SECRET_TIMER_JOEY3
if
	0038:   $SECRET_TRIGGERED_JOEY3 == 1
then
	if and
		80DF:   not is_char_in_any_car $PLAYER_PASSENGER
		00E0:   is_player_in_any_car $PLAYER_CHAR
	then
		00DA: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
		01D4: actor $PLAYER_PASSENGER go_to_car $PLAYER_CAR and_enter_it_as_a_passenger
	end
	if
		01FC:   player $PLAYER_CHAR near_car $JOEY3_VAN radius 10.0 10.0 unknown 0
	then
		if
			0038:   $SECRET_TIMER_JOEY_STARTED_FLAG == 0
		then
			0006: 16@ = 0
			0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 1
		else
			if
				0019:   16@ > 5000
			then
				goto @SECRET_ACTIVATE_JOEY3
			end
		end
	else
		0004: $SECRET_TIMER_JOEY_STARTED_FLAG = 0
	end 
end
return

/////////////////////////////////////////

:SECRET_ACTIVATE_JOEY3
0006: 16@ = 0
01E0: clear_leader $PLAYER_PASSENGER
020A: set_car $JOEY3_VAN door_status_to CARLOCK_UNLOCKED
0151: remove_status_text $JOEY3_VAN_HEALTH
if
	8118:   not actor $JOEY3_VAN_DRIVER dead
then
	01D3: actor $JOEY3_VAN_DRIVER leave_car $JOEY3_VAN
	0319: set_actor $JOEY3_VAN_DRIVER running 1
end
if
	8118:   not actor $JOEY3_VAN_PASSENGER dead
then
	01D3: actor $JOEY3_VAN_PASSENGER leave_car $JOEY3_VAN
	01D0: actor $JOEY3_VAN_PASSENGER avoid_player $PLAYER_CHAR 
end
while 00DB:   is_char_in_car $JOEY3_VAN_DRIVER car $JOEY3_VAN 
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if or
		0019:   16@ > 10000
		0118:   actor $JOEY3_VAN_DRIVER dead
		0119:   car $PLAYER_CAR wrecked
	then
		goto @SECRET_FINISHED_JOEY3
	end
end //while

if
	8118:   not actor $JOEY3_VAN_DRIVER dead
then
	01D5: actor $JOEY3_VAN_DRIVER go_to_and_drive_car $PLAYER_CAR 
end

while 80DB:   not is_char_in_car $JOEY3_VAN_DRIVER car $PLAYER_CAR 
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_JOEY3
	if or
		0019:   16@ > 10000
		0118:   actor $JOEY3_VAN_DRIVER dead
		0119:   car $PLAYER_CAR wrecked
	then
		goto @SECRET_FINISHED_JOEY3
	end
end //while

if
	8119:   not car $PLAYER_CAR wrecked
then
	00A8: car_wander_randomly $PLAYER_CAR
end


:SECRET_FINISHED_JOEY3
if
	8119:   not car $JOEY3_VAN wrecked
then
	021B: set_garage $SECURICAR_GARAGE to_accept_car $JOEY3_VAN
end

if and
	8118:   not actor $JOEY3_VAN_DRIVER dead
	8118:   not actor $PLAYER_PASSENGER dead
then
	01DE: tie_actor $PLAYER_PASSENGER to_actor $JOEY3_VAN_DRIVER 
end
0004: $FLAG_CAR_BLIP_DISPLAYED_JM3 = 1
0004: $SECRET_ACTIVATED_JOEY3 = 1
goto @GARAGE_STOP

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_JOEY3
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_JOEY3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_JOEY3
0004: $VAN_HEIST_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 20000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 20000 
0318: set_latest_mission_passed 'JM3'  // 'VAN HEIST'
030C: set_mission_points += 1 
03A5: set_garage $SECURICAR_GARAGE type_to GARAGE_COLLECTSPECIFICCARS CAR_SECURICAR
004F: create_thread @JOEY_MISSION4_LOOP 
goto @MISSION_END_JOEY3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_JOEY3
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_JOEY = 0 
0164: disable_marker $JOEY3_VAN_MARKER 
0164: disable_marker $BLIP2_JM3 
0296: unload_special_actor 2 
021B: set_garage $SECURICAR_GARAGE to_accept_car -1 
0249: release_model #SECURICA 
0151: remove_status_text $JOEY3_VAN_HEALTH 
00D8: mission_has_finished
return
