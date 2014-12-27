// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 5****************************************
// **********************************Destroy Fish Factory*************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

:M12_BLOWFISH

gosub @MISSION_START_TONI5
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_TONI5
end

:MISSION_END_TONI5
gosub @MISSION_CLEANUP_TONI5
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_TONI5
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_TONI = 1 
03A4: name_thread 'TONI5' 
0001: wait 0 ms 
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

02E4: load_cutscene_data 'T5_BF' 
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

while 001A:   1350 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_B' duration 10000 ms flag 1  // ~w~OK, I've had enough of this shit.
while 001A:   3169 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_C' duration 10000 ms flag 1  // ~w~We're gonna finish the Triads in Liberty once and for all!
while 001A:   5730 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_D' duration 10000 ms flag 1  // 8-Ball's rigged a dustcart with a bomb.
while 001A:   7755 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_E' duration 10000 ms flag 1  // ~w~It's on a timer so if you mess up there'll be no evidence. Go and pick up the dustcart.
while 001A:   12490 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_F' duration 10000 ms flag 1  // ~w~Careful, 8-Ball says it's real sensitive and the slightest bump could set that thing off!
while 001A:   17220 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_G' duration 10000 ms flag 1  // ~w~Their fish factory will open its gates for a dustcart, so you can drive right in.
while 001A:   21330 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_H' duration 10000 ms flag 1  // ~w~Park up between the gas canisters and get the hell out of there!
while 001A:   24141 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_I' duration 10000 ms flag 1  // ~w~I want it to rain mackerel.
while 001A:   25817 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM5_J' duration 10000 ms flag 1  // ~w~We're talking real biblical here, nothing low budget.
while 001A:   28632 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints
while 001A:   30000 > $CUT_SCENE_TIME
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
0249: release_model #IND_NEWRIZZOS 
0247: request_model #TRASH 

while 8248:   not model #TRASH available
	wait 0 ms
end

0004: $TRIADS_SPOT_YOU = 0 
0004: $CLEAR_TRIADS_THREATS = 0 

// START MISSION

00A5: $BLOWFISH_GARBAGE_TRUCK = create_car #TRASH at 1314.0 -106.0 -100.0
02AC: set_car $BLOWFISH_GARBAGE_TRUCK immunities 1 1 0 0 1 
0242: set_car $BLOWFISH_GARBAGE_TRUCK bomb_status_to CARBOMB_TIMED 
0004: $FISH_FACTORY_DESTROYED = 0 
0186: $TONI5_GARBAGE_TRUCK_MARKER = create_marker_above_car $BLOWFISH_GARBAGE_TRUCK

while 80DC:   not is_player_in_car $PLAYER_CHAR car $BLOWFISH_GARBAGE_TRUCK 
	wait 0 ms
	if
		0119:   car $BLOWFISH_GARBAGE_TRUCK wrecked
	then
		goto @MISSION_FAILED_TONI5
	end
	gosub @TRIAD_AI //subroutine in 11_toni4.sc
	if and
		8185:   not car $BLOWFISH_GARBAGE_TRUCK health >= 950 
		80B1:   not is_car_in_area_3d $BLOWFISH_GARBAGE_TRUCK from 961.0 -1112.5 12.5 to 969.5 -1122.75 15.0 sphere 0
	then
		020B: explode_car $BLOWFISH_GARBAGE_TRUCK 
		goto @MISSION_FAILED_TONI5
	end
end //while

0004: $TONI5_TIMER = 151000 
014E: start_timer_at $TONI5_TIMER 
0006: 17@ = 0
00BC: text_highpriority 'T5ENGIN' 5000 ms 1  // ~g~Be careful, the engine was damaged when planting the bomb and is deteriorating fast!
0227: $EXPLOSIVE_TRUCK_HEALTH = car $BLOWFISH_GARBAGE_TRUCK health 
03C4: set_status_text_to $EXPLOSIVE_TRUCK_HEALTH COUNTER_DISPLAY_BAR 'DAM'  // DAMAGE:
0004: $EXPLOSIVE_TRUCK_HEALTH_LOST = 1000 
0060: $EXPLOSIVE_TRUCK_HEALTH_LOST -= $EXPLOSIVE_TRUCK_HEALTH 

if
	0018:   $EXPLOSIVE_TRUCK_HEALTH_LOST > 50
then
	0004: $EXPLOSIVE_TRUCK_HEALTH_LOST = 50
end

0084: $EXPLOSIVE_TRUCK_HEALTH = $EXPLOSIVE_TRUCK_HEALTH_LOST 
0004: $FLAG_CAR_BLIP_DISPLAYED_TM5 = 1 
0004: $BLOB_FLAG = 1

:TONI5_WAIT_FOR_VAN
wait 0 ms

if
	0119:   car $BLOWFISH_GARBAGE_TRUCK wrecked
then
	goto @MISSION_FAILED_TONI5
end

while 81AC:   not car $BLOWFISH_GARBAGE_TRUCK stopped $BLOB_FLAG 961.0 -1112.5 12.5 969.5 -1122.75 15.0
	wait 0 ms
	if
		0119:   car $BLOWFISH_GARBAGE_TRUCK wrecked
	then
		gosub @BLOWUP_TRUCK_TONI5
	end
	gosub @TRIAD_AI //subroutine in 11_toni4.sc
	gosub @TRUCK_HEALTH
	00AA: get_car_coordinates $BLOWFISH_GARBAGE_TRUCK store_to $TONI5_GARBAGE_TRUCK_X $TONI5_GARBAGE_TRUCK_Y $TONI5_GARBAGE_TRUCK_Z
	if and
		00DC:   is_player_in_car $PLAYER_CHAR car $BLOWFISH_GARBAGE_TRUCK
		0038:   $FLAG_CAR_BLIP_DISPLAYED_TM5 == 1
	then
		018A: $BLIP2_TM5 = create_checkpoint_at 965.0 -1117.0 -100.0 
		0004: $BLOB_FLAG = 1 
		0164: disable_marker $TONI5_GARBAGE_TRUCK_MARKER 
		0004: $FLAG_CAR_BLIP_DISPLAYED_TM5 = 0
	end
	if and
		80DC:   not is_player_in_car $PLAYER_CHAR car $BLOWFISH_GARBAGE_TRUCK 
		0038:   $FLAG_CAR_BLIP_DISPLAYED_TM5 == 0
	then
		0186: $TONI5_GARBAGE_TRUCK_MARKER = create_marker_above_car $BLOWFISH_GARBAGE_TRUCK 
		0004: $BLOB_FLAG = 0 
		0164: disable_marker $BLIP2_TM5 
		00BC: print_now 'IN_VEH' duration 5000 ms flag 1  // ~g~Hey! Get back in the vehicle!
		0004: $FLAG_CAR_BLIP_DISPLAYED_TM5 = 1
	end
	if and
		8185:   not car $BLOWFISH_GARBAGE_TRUCK health >= 950 
		80B1:   not is_car_in_area_3d $BLOWFISH_GARBAGE_TRUCK from 961.0 -1112.5 12.5 to 969.5 -1122.75 15.0 sphere 0 
	then
		gosub @BLOWUP_TRUCK_TONI5
	end
	if and
		0038:   $TONI5_TIMER == 0 
		80B1:   not is_car_in_area_3d $BLOWFISH_GARBAGE_TRUCK from 961.0 -1112.5 12.5 to 969.5 -1122.75 15.0 sphere 0
	then
		gosub @BLOWUP_TRUCK_TONI5
	end
	if and
		00DC:   is_player_in_car $PLAYER_CHAR car $BLOWFISH_GARBAGE_TRUCK
		0019:   17@ > 4000
	then
		0006: 17@ = 0
		0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z
		wait 0 ms
		02C7: scatter_platinum 1 at $PLAYER_X $PLAYER_Y $PLAYER_Z 0.5
	end
end //while

0247: request_model #FSHFCTRY_DSTRYD 
00BC: print_now 'JM1_3' duration 5000 ms flag 2  // ~g~Activate the car bomb then get out of there!
01B5: force_weather 0

if
	0119:   car $BLOWFISH_GARBAGE_TRUCK wrecked
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_TONI5
end

while 8356:   not explosion_type EXPLOSION_CAR in_cube 961.0 -1112.5 12.5 to 969.5 -1122.75 15.0
	wait 0 ms
	if
		0119:   car $BLOWFISH_GARBAGE_TRUCK wrecked 
	then
		039D: scatter_particles type POBJECT_FIREBALL_AND_SMOKE 4.0 0 0 0 4000 from $TONI5_GARBAGE_TRUCK_X $TONI5_GARBAGE_TRUCK_Y $TONI5_GARBAGE_TRUCK_Z to 0.0 0.0 0.0
		goto @EXPLOSION
	end
	gosub @TRIAD_AI //subroutine in 11_toni4.sc
	gosub @TRUCK_HEALTH
	00AA: get_car_coordinates $BLOWFISH_GARBAGE_TRUCK store_to $TONI5_GARBAGE_TRUCK_X $TONI5_GARBAGE_TRUCK_Y $TONI5_GARBAGE_TRUCK_Z
	if
		80B1:   not is_car_in_area_3d $BLOWFISH_GARBAGE_TRUCK from 961.0 -1112.5 12.5 to 969.5 -1122.75 15.0 sphere 0 
	then
		goto @TONI5_WAIT_FOR_VAN
	end
	if and
		80DC:   not is_player_in_car $PLAYER_CHAR car $BLOWFISH_GARBAGE_TRUCK 
		8228:   not car $BLOWFISH_GARBAGE_TRUCK bomb_status == CARBOMB_TIMEDACTIVE
	then
		00BC: print_now 'JM1_5' duration 5000 ms flag 1  // ~g~The car bomb's not set!
	end
	if or
		8185:   not car $BLOWFISH_GARBAGE_TRUCK health >= 950
		0038:   $TONI5_TIMER == 0
	then
		020B: explode_car $BLOWFISH_GARBAGE_TRUCK 
		039D: scatter_particles type POBJECT_FIREBALL_AND_SMOKE 4.0 0 0 0 4000 from $TONI5_GARBAGE_TRUCK_X $TONI5_GARBAGE_TRUCK_Y $TONI5_GARBAGE_TRUCK_Z to 0.0 0.0 0.0
		goto @EXPLOSION
	end
end //while

:EXPLOSION

014F: stop_timer $TONI5_TIMER 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
015F: set_camera_position 940.25 -1136.75 16.5 0.0 rotation 0.0 0.0 
0160: point_camera 941.0625 -1136.125 16.5 switchstyle JUMP_CUT
0164: disable_marker $TONI5_GARBAGE_TRUCK_MARKER 
0164: disable_marker $BLIP2_TM5 
0001: wait 300 ms 
0003: shake_cam 300 
020C: create_explosion EXPLOSION_HELI at 965.75 -1111.875 15.5 
02CF: $FISH_FIRE3 = create_fire_at 966.0 -1111.75 13.75 
020C: create_explosion EXPLOSION_HELI at 966.0 -1123.0 15.375 
0001: wait 600 ms 
0003: shake_cam 400 
020C: create_explosion EXPLOSION_HELI at 970.0 -1119.0 16.0 
0001: wait 300 ms 
0003: shake_cam 300 
020C: create_explosion EXPLOSION_HELI at 985.0 -1119.0 14.0 
0001: wait 400 ms 
0003: shake_cam 400 
020C: create_explosion EXPLOSION_HELI at 985.0 -1120.0 20.0 
0001: wait 200 ms 
0003: shake_cam 300 
015F: set_camera_position 960.5 -1094.0 21.0625 0.0 rotation 0.0 0.0 
0160: point_camera 961.1875 -1094.688 20.75 switchstyle JUMP_CUT
020C: create_explosion EXPLOSION_HELI at 969.1875 -1104.0 18.25 
0001: wait 300 ms 
0003: shake_cam 400 
020C: create_explosion EXPLOSION_HELI at 968.375 -1119.188 17.375 
0001: wait 200 ms 
0003: shake_cam 300 
020C: create_explosion EXPLOSION_HELI at 979.375 -1103.875 18.875 
0001: wait 300 ms 
0003: shake_cam 400 
020C: create_explosion EXPLOSION_HELI at 976.0 -1108.25 21.375 
0001: wait 300 ms 
0003: shake_cam 300 
039D: scatter_particles type POBJECT_FIREBALL_AND_SMOKE 5.0 0 0 0 5000 from 969.75 -1104.875 18.6875 to 0.0 0.0 0.0 
020C: create_explosion EXPLOSION_HELI at 972.6875 -1102.188 18.5 
020C: create_explosion EXPLOSION_HELI at 986.25 -1103.375 14.6875 
0107: $DEBRIS1_TM5 = create_object #FISH01 at 972.6875 -1103.563 20.5625
0107: $DEBRIS2_TM5 = create_object #FISH01 at 972.6875 -1103.188 20.5625
0107: $DEBRIS3_TM5 = create_object #FISH01 at 978.75 -1107.188 21.5625
0107: $DEBRIS4_TM5 = create_object #FISH01 at 979.75 -1105.188 21.5625
0392: object $DEBRIS1_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS2_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS3_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS4_TM5 toggle_in_moving_list 1 
0381: throw_object $DEBRIS1_TM5 distance -10.0 6.0 18.0 
0381: throw_object $DEBRIS2_TM5 distance 8.0 7.0 16.0 
0381: throw_object $DEBRIS3_TM5 distance -7.0 10.0 14.0 
0381: throw_object $DEBRIS4_TM5 distance 9.0 6.0 15.0 
018C: play_sound sound_test_1 at 969.75 -1104.875 18.6875 
0001: wait 400 ms 
0003: shake_cam 500 
039D: scatter_particles type POBJECT_FIREBALL_AND_SMOKE 5.0 0 0 0 5000 from 974.1875 -1129.75 19.5 to 0.0 0.0 0.0 
020C: create_explosion EXPLOSION_HELI at 982.0 -1102.75 17.375 
020C: create_explosion EXPLOSION_HELI at 973.5625 -1128.75 19.5625 
0107: $DEBRIS5_TM5 = create_object #FISH01 at 982.0 -1103.75 20.375 
0107: $DEBRIS6_TM5 = create_object #FISH01 at 982.0 -1103.0 20.375
0107: $DEBRIS7_TM5 = create_object #FISH01 at 983.0 -1112.0 20.375 
0107: $DEBRIS8_TM5 = create_object #FISH01 at 985.0 -1108.0 19.375 
0107: $DEBRIS9_TM5 = create_object #FISH01 at 977.0 -1113.0 21.375 
0107: $DEBRIS10_TM5 = create_object #FISH01 at 976.0 -1115.0 21.375
0392: object $DEBRIS5_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS6_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS7_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS8_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS9_TM5 toggle_in_moving_list 1 
0392: object $DEBRIS10_TM5 toggle_in_moving_list 1 
0381: throw_object $DEBRIS5_TM5 distance -3.0 6.0 18.0 
0381: throw_object $DEBRIS6_TM5 distance 5.0 7.0 16.0 
0381: throw_object $DEBRIS7_TM5 distance -6.0 7.0 17.0 
0381: throw_object $DEBRIS8_TM5 distance 8.0 9.0 16.0 
0381: throw_object $DEBRIS9_TM5 distance -7.0 8.0 14.0 
0381: throw_object $DEBRIS10_TM5 distance -1.0 10.0 14.0 
018C: play_sound sound_test_1 at 974.1875 -1129.75 19.5 
0169: set_fade_color 255 255 255 
016A: fade 0 for 400 ms 

if
	8117:   not player $PLAYER_CHAR wasted
then
	03B6: replace_model_at 981.5 -1123.875 16.6875 radius 80.0 from #FISHFCTORY to #FSHFCTRY_DSTRYD
end

016A: fade 1 for 400 ms 
02CF: $FISH_FIRE2 = create_fire_at 979.25 -1106.063 14.6875 
02CF: $FISH_FIRE4 = create_fire_at 981.0 -1132.0 14.0 
02CF: $FISH_FIRE6 = create_fire_at 970.5625 -1107.5 18.5 
02CF: $FISH_FIRE7 = create_fire_at 965.75 -1123.375 14.0 
0004: $FISH_FACTORY_DESTROYED = 1 
0001: wait 3000 ms 
01B7: release_weather 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
02EB: restore_camera_jumpcut

goto @MISSION_PASSED_TONI5

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_TONI5
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_TONI5

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_TONI5
0004: $BLOW_FISH_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 30000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 30000 
0164: disable_marker $SALVATORE_MISSION_MARKER 
02A7: $SALVATORE_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAL at 1455.688 -187.25 -100.0 
015C: set_zone_gang_info 'FISHFAC' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'FISHFAC' NIGHT 0 0 0 0 0 0 0 0 0 
014C: set_parked_car_generator $GEN_CAR47 cars_to_generate_to 0 
014C: set_parked_car_generator $GEN_CAR48 cars_to_generate_to 0 
014C: set_parked_car_generator $GEN_CAR49 cars_to_generate_to 0 
0004: $FLAG_FRANKIE_SWITCHED_OFF = 0 
0318: set_latest_mission_passed 'TM5'  // 'BLOW FISH'
030C: set_mission_points += 1 
0164: disable_marker $TONI_MISSION_MARKER 
004F: create_thread @TONI5_FLAMES_LOOP
goto @MISSION_END_TONI5

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_TONI5
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_TONI = 0 
0164: disable_marker $TONI5_GARBAGE_TRUCK_MARKER 
0164: disable_marker $BLIP2_TM5 
014F: stop_timer $TONI5_TIMER 
0151: remove_status_text $EXPLOSIVE_TRUCK_HEALTH 
0249: release_model #TRASH 
0249: release_model #FSHFCTRY_DSTRYD 
03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1
0169: set_fade_color 1 1 1 
00D8: mission_has_finished
return

/////////////////////////////////////////

:BLOWUP_TRUCK_TONI5
if
	8119:   not car $BLOWFISH_GARBAGE_TRUCK wrecked
then
	020B: explode_car $BLOWFISH_GARBAGE_TRUCK 
end
039D: scatter_particles type POBJECT_FIREBALL_AND_SMOKE 4.0 0 0 0 4000 from $TONI5_GARBAGE_TRUCK_X $TONI5_GARBAGE_TRUCK_Y $TONI5_GARBAGE_TRUCK_Z to 0.0 0.0 0.0
goto @MISSION_FAILED_TONI5
return

/////////////////////////////////////////

:TRUCK_HEALTH
if
	8119:   not car $BLOWFISH_GARBAGE_TRUCK wrecked
then
	0227: $EXPLOSIVE_TRUCK_HEALTH = car $BLOWFISH_GARBAGE_TRUCK health 
	0004: $EXPLOSIVE_TRUCK_HEALTH_LOST = 1000 
	0060: $EXPLOSIVE_TRUCK_HEALTH_LOST -= $EXPLOSIVE_TRUCK_HEALTH 
	if
		0018:   $EXPLOSIVE_TRUCK_HEALTH_LOST > 50 
	then
		0004: $EXPLOSIVE_TRUCK_HEALTH_LOST = 50 
	end
	0084: $EXPLOSIVE_TRUCK_HEALTH = $EXPLOSIVE_TRUCK_HEALTH_LOST
end
return
