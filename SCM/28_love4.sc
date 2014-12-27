// *****************************************************************************************
// *********************************  Love Mission 4  **************************************
// ********************************* Grand Theft Aero **************************************
// *****************************************************************************************
// *** The real packages are still in the Cessna, which is at the airport. 		 ***
// *** When the player arrives he will see a Palantic Construction vans drive away. 	 ***
// *** As he gets closer there are some Colombians inside the hangar, seeing the player  ***
// *** they will attack. After the player has killed them, he will go into the hangar to ***
// *** find out that the package is not there. The player must go to to the building 	 ***
// *** site. There the player will have to fight his way through the Colombians to 	 ***
// *** Catalina & Miguel and the packages.                                               ***
// *****************************************************************************************

// Mission start stuff

:M28_GRANDTHEFTAERO

gosub @MISSION_START_LOVE4
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LOVE4
end

:MISSION_END_LOVE4
gosub @MISSION_CLEANUP_LOVE4
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_LOVE4
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_LOVE = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'LOVE4' 
0004: $FLAG_RESULT1 = 0 
0004: $RESET_TIMERA_FLAG = 0 
0004: $GOON_IN_HANGAR1_FLAG = -1 
0004: $GOON_IN_HANGAR2_FLAG = -1 
0004: $GOON_IN_HANGAR3_FLAG = -1 
0004: $GOON_IN_HANGAR4_FLAG = -1 
0004: $GOON_IN_HANGAR1_DUCKING = -1 
0004: $GOON_IN_HANGAR2_DUCKING = -1 
0004: $GOON_IN_HANGAR3_DUCKING = -1 
0004: $GOON_IN_HANGAR4_DUCKING = -1 
0004: $GOON_IN_HANGAR1_WAITSTATE = 0 
0004: $GOON_IN_HANGAR2_WAITSTATE = 0 
0004: $GOON_IN_HANGAR3_WAITSTATE = 0 
0004: $GOON_IN_HANGAR4_WAITSTATE = 0 
0004: $GOON_AT_YARD1_FLAG = 0 
0004: $GOON_AT_YARD1_DUCK = 0 
0004: $GOON_AT_YARD1_DUCK_TIMER = 0 
0004: $GOON_AT_YARD2_FLAG = 0 
0004: $GOON_AT_YARD2_DUCK = 0 
0004: $GOON_AT_YARD2_DUCK_TIMER = 0 
0004: $GOON_AT_YARD3_FLAG = 0 
0004: $GOON_AT_YARD3_DUCK = 0 
0004: $GOON_AT_YARD3_DUCK_TIMER = 0 
0004: $GOON_AT_YARD4_FLAG = 0 
0004: $GOON_AT_YARD4_DUCK = 0 
0004: $GOON_AT_YARD4_DUCK_TIMER = 0 
0004: $GOON_AT_YARD5_FLAG = 0 
0004: $GOON_AT_YARD6_FLAG = 0 
0004: $GOON_AT_YARD7_DUCK = 0 
0004: $GOON_AT_YARD7_DUCK_TIMER = 0 
0004: $GOON_AT_YARD8_FLAG = 0 
0004: $GOON_AT_YARD8_DUCK = 0 
0004: $GOON_AT_YARD8_DUCK_TIMER = 0 
0004: $GOON_AT_YARD9_FLAG = 0 
0004: $GOON_AT_YARD10_FLAG = 0 
0004: $GOON_AT_YARD10_DUCK = 0 
0004: $GOON_AT_YARD10_DUCK_TIMER = 0 
0004: $GOON_IN_HANGAR1_BLIP_FLAG = 0 
0004: $GOON_IN_HANGAR2_BLIP_FLAG = 0 
0004: $GOON_IN_HANGAR3_BLIP_FLAG = 0 
0004: $GOON_IN_HANGAR4_BLIP_FLAG = 0 
0004: $DUCKING_FLAG = 0 
0004: $C_SITE_AREA_FLAG = 0 
0004: $HANGAR_ROUTE = 0 
0004: $YARD_ROUTE1 = 1 
0004: $YARD_ROUTE2 = 2 
0004: $YARD_ROUTE3 = 3 
014C: set_parked_car_generator $COM_CAR37 cars_to_generate_to 0 


// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'LOVE' as 1 
0247: request_model #TSHRORCKGRDN 
0247: request_model #TSHRORCKGRDN_ALFAS 
02F3: load_object #CUTOBJ01 'LOVEH' 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #TSHRORCKGRDN available 
		8248:   not model #TSHRORCKGRDN_ALFAS available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'D4_GTA' 
0244: set_cutscene_pos 85.1875 -1532.875 243.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_LOVE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_LOVE 'LOVE' 
02F4: create_cutscene_actor $LOVE_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_LOVE 
02F5: set_head_anim $LOVE_CSHEAD 'LOVE' 
0395: clear_area 1 at 82.4375 -1548.438 range 28.0 2.0 
0055: set_player_coordinates $PLAYER_CHAR to 82.4375 -1548.438 28.0 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 1500 ms 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   765 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_A' duration 10000 ms flag 1  // Thank you for retrieving those packages, but they were only a decoy.
while 001A:   4000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_B' duration 10000 ms flag 1  // Sorry about that, but that's sometimes the way in business.
while 001A:   6851 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_C' duration 10000 ms flag 1  // My real objective was hidden on the plane all along.
while 001A:   9951 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_D' duration 10000 ms flag 1  // Unfortunately the port authorities seized the plane and were stripping it down
while 001A:   13204 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_H' duration 10000 ms flag 1  // until I intervened at great personal expense.
while 001A:   16457 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_E' duration 10000 ms flag 1  // Cross the bridge to Shoreside Vale and go to Francis International Airport.
while 001A:   19710 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_F' duration 10000 ms flag 1  // I've paid off the officials.
while 001A:   21394 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE4_G' duration 10000 ms flag 1  // My property will be waiting for you at the customs hanger in the aircraft's fuselage.
while 001A:   27666 > $CUT_SCENE_TIME
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
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #TSHRORCKGRDN 
0249: release_model #TSHRORCKGRDN_ALFAS 
0247: request_model #PANLANT 
0247: request_model #GANG11 
0247: request_model #DODO 
0247: request_model #COLUMB
038B: load_all_models_now 

while true
	if or
		8248:   not model #PANLANT available 
		8248:   not model #GANG11 available 
		8248:   not model #DODO available 
		8248:   not model #COLUMB available 
	jf break
	wait 0 ms
end //while

03AF: set_streaming 1 
016A: fade 1 for 1500 ms 

while fading
	wait 0 ms
end

// ******************************************END OF CUTSCENE********************************

0167: $LOVE_4_BLIP = create_marker_at -1268.438 -528.625 9.8125 color RED visibility BLIP_ONLY 
0168: show_on_radar $LOVE_4_BLIP BOTH 

while 83C6:   not current_island == LEVEL_SUBURBAN
	wait 0 ms
end

if
	0351:   gore_enabled 
then
	029B: $DEADMAN1 = create_object #DEADMAN1 at -1276.813 -528.0 10.5625 
else
	029B: $DEADMAN1 = create_object #DEADMANOBLOOD at -1276.813 -528.0 10.5625 
end

while 80E3:   not player $PLAYER_CHAR 0 -1268.438 -528.625 radius 200.0 200.0 
	wait 0 ms
end

while 83C6:   not current_island == LEVEL_SUBURBAN
	wait 0 ms
end

00A5: $CAR_VAN1_LM4 = create_car #PANLANT at -1282.313 -549.25 10.0625 
0175: set_car $CAR_VAN1_LM4 z_angle_to 110.25 
00A5: $CAR_VAN3_LM4 = create_car #PANLANT at -1281.313 -561.8125 10.0625 
0175: set_car $CAR_VAN3_LM4 z_angle_to 153.0625 
00A5: $WINGLESS_CESSNA = create_car #DODO at -1268.188 -519.0 10.0 
0175: set_car $WINGLESS_CESSNA z_angle_to 180.0 

0164: disable_marker $LOVE_4_BLIP 
0186: $LOVE_4_BLIP = create_marker_above_car $WINGLESS_CESSNA 

0129: $VAN1_DRIVER = create_actor PEDTYPE_GANG_COLOMBIAN #GANG11 in_car $CAR_VAN1_LM4 driverseat 
00A9: car_set_idle $CAR_VAN1_LM4 
00A9: car_set_idle $CAR_VAN3_LM4 
00A9: car_set_idle $WINGLESS_CESSNA 
00AD: set_car_cruise_speed $CAR_VAN1_LM4 to 25.0 
00AE: set_car_driving_style $CAR_VAN1_LM4 to DRIVINGMODE_AVOIDCARS 

009A: $GOON_IN_HANGAR1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1271.813 -511.1875 10.0 
009A: $GOON_IN_HANGAR2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1265.125 -520.625 10.0 
009A: $GOON_IN_HANGAR3 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1263.063 -520.3125 10.0 
009A: $GOON_IN_HANGAR4 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1271.063 -522.0 10.0 
0173: set_actor $GOON_IN_HANGAR4 z_angle_to 170.5625 
020E: actor $GOON_IN_HANGAR2 look_at_actor $GOON_IN_HANGAR3 
020E: actor $GOON_IN_HANGAR3 look_at_actor $GOON_IN_HANGAR2 
01E2: add_route_point $HANGAR_ROUTE at -1271.813 -511.1875 9.75 
01E2: add_route_point $HANGAR_ROUTE at -1263.375 -510.625 9.75 
01E1: set_actor $GOON_IN_HANGAR1 follow_route $HANGAR_ROUTE behaviour FOLLOW_ROUTE_BACKFORWARD 
01B2: give_actor $GOON_IN_HANGAR1 weapon WEAPONTYPE_M16 ammo 9999 
01B2: give_actor $GOON_IN_HANGAR2 weapon WEAPONTYPE_M16 ammo 9999 
01B2: give_actor $GOON_IN_HANGAR4 weapon WEAPONTYPE_M16 ammo 9999 
011A: set_actor $GOON_IN_HANGAR1 search_threat THREAT_FAST_CAR 
011A: set_actor $GOON_IN_HANGAR2 search_threat THREAT_FAST_CAR 
011A: set_actor $GOON_IN_HANGAR3 search_threat THREAT_FAST_CAR 
011A: set_actor $GOON_IN_HANGAR4 search_threat THREAT_FAST_CAR

while 80E3:   not player $PLAYER_CHAR 0 -1281.313 -561.8125 radius 90.0 90.0 // CESSNA
	wait 0 ms
	gosub @CHECK_VEHICLES_WRECKED_LOVE4
end //while

if
	8119:   not car $CAR_VAN1_LM4 wrecked 
then
	00A7: car_goto_coordinates $CAR_VAN1_LM4 coords 439.0 -198.0 21.0 
end

if or
	8118:   not actor $GOON_IN_HANGAR2 dead 
	8118:   not actor $GOON_IN_HANGAR3 dead 
then
	03F9: make_actors $GOON_IN_HANGAR2 $GOON_IN_HANGAR3 converse_in 1000000 ms 
end
if
	8118:   not actor $GOON_IN_HANGAR4 dead 
then
	0372: set_actor $GOON_IN_HANGAR4 anim WAITSTATE_CROSS_ROAD_LOOK wait_state_time 1000000 ms 
end

while true
	if or
		8118:   not actor $GOON_IN_HANGAR1 dead 
		8118:   not actor $GOON_IN_HANGAR2 dead 
		8118:   not actor $GOON_IN_HANGAR3 dead 
		8118:   not actor $GOON_IN_HANGAR4 dead 
	jf break
	wait 0 ms

	gosub @CHECK_VEHICLES_WRECKED_LOVE4

	if
		0118:   actor $GOON_IN_HANGAR1 dead 
	then
		0004: $GOON_IN_HANGAR1_FLAG = -100 
		0004: $GOON_IN_HANGAR1_DUCKING = -100 
		0164: disable_marker $GOON_IN_HANGAR1_BLIP
		gosub @SET_DEATH_FLAGS
	end
	if
		0118:   actor $GOON_IN_HANGAR2 dead 
	then
		0004: $GOON_IN_HANGAR2_FLAG = -100 
		0004: $GOON_IN_HANGAR2_DUCKING = -100 
		0164: disable_marker $GOON_IN_HANGAR2_BLIP
		gosub @SET_DEATH_FLAGS
	end
	if
		0118:   actor $GOON_IN_HANGAR3 dead 
	then
		0004: $GOON_IN_HANGAR3_FLAG = -100 
		0004: $GOON_IN_HANGAR3_DUCKING = -100 
		0164: disable_marker $GOON_IN_HANGAR3_BLIP
		gosub @SET_DEATH_FLAGS
	end
	if
		0118:   actor $GOON_IN_HANGAR4 dead 
	then
		0004: $GOON_IN_HANGAR4_FLAG = -100 
		0004: $GOON_IN_HANGAR4_DUCKING = -100 
		0164: disable_marker $GOON_IN_HANGAR4_BLIP
		gosub @SET_DEATH_FLAGS
	end

	if and
		0056:   is_player_in_area_2d $PLAYER_CHAR coords -1285.0 -586.5 to -1254.938 -542.25 sphere 0 //OUT THE FRONT OF THE HANGAR (AREA1)
		02CA:   is_car_on_screen $WINGLESS_CESSNA 
	then
		gosub @SET_DEATH_FLAGS
	end

	if
		0056:   is_player_in_area_2d $PLAYER_CHAR coords -1290.188 -542.25 to -1244.0 -531.75 sphere 0 //INSIDE HANGAR (AREA2)
	then
		if
			8118:   not actor $GOON_IN_HANGAR2 dead 
		then
			01CC: actor $GOON_IN_HANGAR2 kill_player $PLAYER_CHAR
		end
		0004: $GOON_IN_HANGAR2_FLAG = -100 
		0004: $GOON_IN_HANGAR2_DUCKING = -100 
		gosub @SET_DEATH_FLAGS
	end
	if
		0056:   is_player_in_area_2d $PLAYER_CHAR coords -1290.188 -531.75 to -1244.0 -522.875 sphere 0 //INSIDE HANGAR (AREA3)
	then
		if
			8118:   not actor $GOON_IN_HANGAR4 dead 
		then
			01CC: actor $GOON_IN_HANGAR4 kill_player $PLAYER_CHAR
		end
		0004: $GOON_IN_HANGAR4_FLAG = -100 
		0004: $GOON_IN_HANGAR4_DUCKING = -100 
		gosub @SET_DEATH_FLAGS
	end
	if
		0056:   is_player_in_area_2d $PLAYER_CHAR coords -1290.188 -522.875 to -1244.0 -496.875 sphere 0 //INSIDE HANGAR (AREA4)
	then
		if
			8118:   not actor $GOON_IN_HANGAR1 dead 
		then
			01CC: actor $GOON_IN_HANGAR1 kill_player $PLAYER_CHAR
		end
		0004: $GOON_IN_HANGAR1_FLAG = -100 
		0004: $GOON_IN_HANGAR1_DUCKING = -100 
		gosub @SET_DEATH_FLAGS
		if
			8118:   not actor $GOON_IN_HANGAR3 dead 
		then
			01CC: actor $GOON_IN_HANGAR3 kill_player $PLAYER_CHAR
		end
		0004: $GOON_IN_HANGAR3_FLAG = -100 
		0004: $GOON_IN_HANGAR3_DUCKING = -100 
		gosub @SET_DEATH_FLAGS
	end

	gosub @DUCKING_ROUTINE

	if
		0018:   $GOON_IN_HANGAR1_DUCKING > -1 
	then
		if
			0038:   $GOON_IN_HANGAR1_FLAG == 0 
		then
			009F: char_set_idle $GOON_IN_HANGAR1 
			0372: set_actor $GOON_IN_HANGAR1 anim WAITSTATE_FALSE wait_state_time 100 ms 
			0239: actor $GOON_IN_HANGAR1 run_to -1280.188 -520.0625 
			0004: $GOON_IN_HANGAR1_FLAG = 1 
		end
		if
			0038:   $GOON_IN_HANGAR1_FLAG == 1 
		then
			if
				00F0:   actor $GOON_IN_HANGAR1 stopped 0 -1280.188 -520.0625 radius 1.0 1.0
			then
				0004: $GOON_IN_HANGAR1_FLAG = 2 
				0004: $GOON_IN_HANGAR1_DUCKING = 1 
			end
		end
	end

	if
		0018:   $GOON_IN_HANGAR2_DUCKING > -1 
	then
		if
			0038:   $GOON_IN_HANGAR2_FLAG == 0 
		then
			009F: char_set_idle $GOON_IN_HANGAR2 
			0372: set_actor $GOON_IN_HANGAR2 anim WAITSTATE_FALSE wait_state_time 100 ms 
			0239: actor $GOON_IN_HANGAR2 run_to -1256.375 -521.25 
			0004: $GOON_IN_HANGAR2_FLAG = 1 
		end
		if
			0038:   $GOON_IN_HANGAR2_FLAG == 1 
		then
			if
				00F0:   actor $GOON_IN_HANGAR2 stopped 0 -1256.375 -521.25 radius 1.0 1.0
			then
				0004: $GOON_IN_HANGAR2_FLAG = 2 
				0004: $GOON_IN_HANGAR2_DUCKING = 1 
			end
		end
	end

	if
		0018:   $GOON_IN_HANGAR3_DUCKING > -1 
	then
		if
			0038:   $GOON_IN_HANGAR3_FLAG == 0 
		then
			009F: char_set_idle $GOON_IN_HANGAR3 
			0372: set_actor $GOON_IN_HANGAR3 anim WAITSTATE_FALSE wait_state_time 100 ms 
			0239: actor $GOON_IN_HANGAR3 run_to -1254.375 -521.25 
			01B2: give_actor $GOON_IN_HANGAR3 weapon WEAPONTYPE_M16 ammo 9999 
			0004: $GOON_IN_HANGAR3_FLAG = 1 
		end
		if
			0038:   $GOON_IN_HANGAR3_FLAG == 1 
		then
			if
				00F0:   actor $GOON_IN_HANGAR3 stopped 0 -1254.375 -521.25 radius 1.0 1.0
			then
				0004: $GOON_IN_HANGAR3_FLAG = 2 
				0004: $GOON_IN_HANGAR3_DUCKING = 1 
			end
		end
	end

	if
		0018:   $GOON_IN_HANGAR4_DUCKING > -1 
	then
		if
			0038:   $GOON_IN_HANGAR4_FLAG == 0 
		then
			009F: char_set_idle $GOON_IN_HANGAR4 
			0372: set_actor $GOON_IN_HANGAR4 anim WAITSTATE_FALSE wait_state_time 100 ms 
			0239: actor $GOON_IN_HANGAR4 run_to -1280.75 -529.1875 
			0004: $GOON_IN_HANGAR4_FLAG = 1 
		end
		if
			0038:   $GOON_IN_HANGAR4_FLAG == 1 
		then
			if
				00F0:   actor $GOON_IN_HANGAR4 stopped 0 -1280.75 -529.1875 radius 1.0 1.0
			then
				0004: $GOON_IN_HANGAR4_FLAG = 2 
				0004: $GOON_IN_HANGAR4_DUCKING = 1 
			end
		end
	end
end //while

0164: disable_marker $GOON_IN_HANGAR1_BLIP 
0164: disable_marker $GOON_IN_HANGAR2_BLIP 
0164: disable_marker $GOON_IN_HANGAR3_BLIP 
0164: disable_marker $GOON_IN_HANGAR4_BLIP 
01C2: remove_references_to_actor $GOON_IN_HANGAR1 
01C2: remove_references_to_actor $GOON_IN_HANGAR2 
01C2: remove_references_to_actor $GOON_IN_HANGAR3 
01C2: remove_references_to_actor $GOON_IN_HANGAR4 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
00BC: print_now 'LOVE4_5' duration 5000 ms flag 1  // ~g~The package should be in the plane....

if
	0119:   car $WINGLESS_CESSNA wrecked 
then
	00BC: print_now 'LOVE4_9' duration 5000 ms flag 1  // ~r~The plane has been destroyed!
	goto @MISSION_FAILED_LOVE4
end

while 80DC:   not is_player_in_car $PLAYER_CHAR car $WINGLESS_CESSNA 
	wait 0 ms
	gosub @CHECK_VEHICLES_WRECKED_LOVE4
end //while

0001: wait 1000 ms 
00BC: print_now 'LOVE4_2' duration 3000 ms flag 1  // ~g~The package is gone! Track down the Colombians and retrieve it.
0164: disable_marker $LOVE_4_BLIP 

if
	0119:   car $CAR_VAN3_LM4 wrecked 
then
	00BC: print_now 'LOV4_10' duration 5000 ms flag 1  // ~r~The only lead to where the package has gone has been destroyed!
	goto @MISSION_FAILED_LOVE4
end

0186: $LOVE_4_BLIP = create_marker_above_car $CAR_VAN3_LM4 

while 81FD:   not player $PLAYER_CHAR near_car_on_foot $CAR_VAN3_LM4 radius 6.0 6.0 unknown 0 
	wait 0 ms
	if
		0119:   car $CAR_VAN3_LM4 wrecked 
	then
		00BC: print_now 'LOV4_10' duration 5000 ms flag 1  // ~r~The only lead to where the package has gone has been destroyed!
		goto @MISSION_FAILED_LOVE4
	end
end //while

00AA: get_car_coordinates $CAR_VAN3_LM4 store_to $VAN3_X $VAN3_Y $VAN3_Z 
02F8: get_car $CAR_VAN3_LM4 Z_angle_sine_to $X_COMPONENT 
02F9: get_car $CAR_VAN3_LM4 Z_angle_cosine_to $Y_COMPONENT 

0005: $TEMP_RESULT_X = 2.75 
0069: $TEMP_RESULT_X *= $Y_COMPONENT //change both of these to move on the vehicles x axis
0005: $TEMP_RESULT_Y = -2.75 
0069: $TEMP_RESULT_Y *= $X_COMPONENT //
0005: $TEMP_VAR_X = 0.25 
0069: $TEMP_VAR_X *= $X_COMPONENT //change both of these to move on the vehicles y axis
0005: $TEMP_VAR_Y = 0.25 
0069: $TEMP_VAR_Y *= $Y_COMPONENT //
0086: $RESULT1_X = $TEMP_RESULT_X 
0061: $RESULT1_X -= $TEMP_VAR_X 
0086: $RESULT1_Y = $TEMP_RESULT_Y 
0061: $RESULT1_Y -= $TEMP_VAR_Y 
0059: $RESULT1_X += $VAN3_X 
0059: $RESULT1_Y += $VAN3_Y 

/////////////////

0005: $TEMP_RESULT_X = -2.75 
0069: $TEMP_RESULT_X *= $Y_COMPONENT //change both of these to move on the vehicles x axis
0005: $TEMP_RESULT_Y = 2.75 
0069: $TEMP_RESULT_Y *= $X_COMPONENT //
0005: $TEMP_VAR_X = 0.25 
0069: $TEMP_VAR_X *= $X_COMPONENT //change both of these to move on the vehicles y axis
0005: $TEMP_VAR_Y = 0.25 
0069: $TEMP_VAR_Y *= $Y_COMPONENT //
0086: $RESULT2_X = $TEMP_RESULT_X 
0061: $RESULT2_X -= $TEMP_VAR_X 
0086: $RESULT2_Y = $TEMP_RESULT_Y 
0061: $RESULT2_Y -= $TEMP_VAR_Y 
0059: $RESULT2_X += $VAN3_X 
0059: $RESULT2_Y += $VAN3_Y 
0009: $VAN3_Z += 0.125 

////////////////////////////////////////////////////////////////////////////////

01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
0192: set_actor $PLAYER_ACTOR objective_to_stand_still 
009F: char_set_idle $PLAYER_ACTOR 
0164: disable_marker $LOVE_4_BLIP 
0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z 

0086: $DIFFER_X = $PLAYER_X 
0061: $DIFFER_X -= $RESULT1_X 
0086: $DIFFER_Y = $PLAYER_Y 
0061: $DIFFER_Y -= $RESULT1_Y 
0069: $DIFFER_X *= $DIFFER_X 
0069: $DIFFER_Y *= $DIFFER_Y 
0086: $SUM_DIFFERENCE = $DIFFER_X 
0059: $SUM_DIFFERENCE += $DIFFER_Y 
01FB: $DISTANCE_RESULT1 = square_root $SUM_DIFFERENCE 

0086: $DIFFER_X = $PLAYER_X 
0061: $DIFFER_X -= $RESULT2_X 
0086: $DIFFER_Y = $PLAYER_Y 
0061: $DIFFER_Y -= $RESULT2_Y 
0069: $DIFFER_X *= $DIFFER_X 
0069: $DIFFER_Y *= $DIFFER_Y 
0086: $SUM_DIFFERENCE = $DIFFER_X 
0059: $SUM_DIFFERENCE += $DIFFER_Y 
01FB: $DISTANCE_RESULT2 = square_root $SUM_DIFFERENCE 

if
	0024:   $DISTANCE_RESULT2 > $DISTANCE_RESULT1 
then
	0004: $FLAG_RESULT1 = 1 
else
	0004: $FLAG_RESULT1 = 0
end

if
	0038:   $FLAG_RESULT1 == 1 
then
	015F: set_camera_position $RESULT1_X $RESULT1_Y $VAN3_Z rotation 0.0 0.0 0.0 
	0160: point_camera $RESULT2_X $RESULT2_Y $VAN3_Z switchstyle INTERPOLATION
else 
	015F: set_camera_position $RESULT2_X $RESULT2_Y $VAN3_Z rotation 0.0 0.0 0.0 
	0160: point_camera $RESULT1_X $RESULT1_Y $VAN3_Z switchstyle INTERPOLATION 
end

0001: wait 1000 ms 
00BC: print_now 'LOVE4_3' duration 3000 ms flag 1  // ~g~Panlantic Construction...?
0001: wait 2000 ms 
015A: restore_camera 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
00BB: print 'LOVE4_7' duration 5000 ms flag 1  // ~g~There's a construction yard in Staunton Island, maybe they took the package there.
018A: $LOVE_4_BLIP = create_checkpoint_at 366.9375 -328.0 20.25 
01C2: remove_references_to_actor $GOON_IN_HANGAR1 
01C2: remove_references_to_actor $GOON_IN_HANGAR2 
01C2: remove_references_to_actor $GOON_IN_HANGAR3 
01C2: remove_references_to_actor $GOON_IN_HANGAR4 
01C2: remove_references_to_actor $VAN1_DRIVER 
01C3: remove_references_to_car $CAR_VAN1_LM4 
01C3: remove_references_to_car $CAR_VAN3_LM4 

////////////////////////////////////////////////////////////////////////////////

while 83C6:   not current_island == LEVEL_COMMERCIAL
	wait 0 ms
end

00A5: $COLOMBIAN_CAR = create_car #COLUMB at 346.875 -298.4375 15.75 
0175: set_car $COLOMBIAN_CAR z_angle_to 111.6875 

00A5: $COLOMBIAN_CAR_BOMB = create_car #COLUMB at 352.375 -345.5 -100.0
0175: set_car $COLOMBIAN_CAR_BOMB z_angle_to 180.0

00A5: $CAR_VAN1_LM4 = create_car #PANLANT at 352.875 -308.25 15.75 
00A5: $CAR_VAN2_LM4 = create_car #PANLANT at 359.375 -307.1875 15.75 
0175: set_car $CAR_VAN1_LM4 z_angle_to 180.5625 
0175: set_car $CAR_VAN2_LM4 z_angle_to 222.875 

009A: $GOON_AT_YARD1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 343.9375 -306.25 15.75 
01ED: clear_actor $GOON_AT_YARD1 threat_search 
011A: set_actor $GOON_AT_YARD1 search_threat THREAT_PLAYER1 
0350: set_actor $GOON_AT_YARD1 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD1 use_pednode_seek 0 

009A: $GOON_AT_YARD2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 341.5625 -306.8125 15.75 
01ED: clear_actor $GOON_AT_YARD2 threat_search 
011A: set_actor $GOON_AT_YARD2 search_threat THREAT_PLAYER1 
020E: actor $GOON_AT_YARD2 look_at_actor $GOON_AT_YARD1 
020E: actor $GOON_AT_YARD1 look_at_actor $GOON_AT_YARD2 
03F9: make_actors $GOON_AT_YARD2 $GOON_AT_YARD1 converse_in 10000000 ms 
0350: set_actor $GOON_AT_YARD2 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD2 use_pednode_seek 0 

009A: $GOON_AT_YARD3 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 327.75 -316.625 15.875 
01B2: give_actor $GOON_AT_YARD3 weapon WEAPONTYPE_SHOTGUN ammo 9999 
01ED: clear_actor $GOON_AT_YARD3 threat_search 
011A: set_actor $GOON_AT_YARD3 search_threat THREAT_PLAYER1 
0173: set_actor $GOON_AT_YARD3 z_angle_to 315.0 
0350: set_actor $GOON_AT_YARD3 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD3 use_pednode_seek 0 

009A: $GOON_AT_YARD4 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 335.0625 -338.1875 15.75 
01B2: give_actor $GOON_AT_YARD4 weapon WEAPONTYPE_M16 ammo 9999 
01ED: clear_actor $GOON_AT_YARD4 threat_search 
011A: set_actor $GOON_AT_YARD4 search_threat THREAT_PLAYER1 
0173: set_actor $GOON_AT_YARD4 z_angle_to 25.0 
0372: set_actor $GOON_AT_YARD4 anim 3 wait_state_time 10000000 ms 
0350: set_actor $GOON_AT_YARD4 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD4 use_pednode_seek 0 

009A: $GOON_AT_YARD5 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 348.6875 -320.0625 15.75 
01B2: give_actor $GOON_AT_YARD5 weapon WEAPONTYPE_SHOTGUN ammo 9999 
01ED: clear_actor $GOON_AT_YARD5 threat_search 
011A: set_actor $GOON_AT_YARD5 search_threat THREAT_PLAYER1 
0173: set_actor $GOON_AT_YARD5 z_angle_to 250.0 
0350: set_actor $GOON_AT_YARD5 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD5 use_pednode_seek 0 

009A: $GOON_AT_YARD6 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 357.1875 -319.6875 15.875 
01B2: give_actor $GOON_AT_YARD6 weapon WEAPONTYPE_M16 ammo 9999 
01ED: clear_actor $GOON_AT_YARD6 threat_search 
011A: set_actor $GOON_AT_YARD6 search_threat THREAT_PLAYER1 
0173: set_actor $GOON_AT_YARD6 z_angle_to 250.0 
0350: set_actor $GOON_AT_YARD6 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD6 use_pednode_seek 0 

009A: $GOON_AT_YARD7 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 358.625 -340.6875 16.0 
01B2: give_actor $GOON_AT_YARD7 weapon WEAPONTYPE_SHOTGUN ammo 9999 
01ED: clear_actor $GOON_AT_YARD7 threat_search 
011A: set_actor $GOON_AT_YARD7 search_threat THREAT_PLAYER1 
0173: set_actor $GOON_AT_YARD7 z_angle_to 90.0 
0350: set_actor $GOON_AT_YARD7 maintain_position_when_attacked 1 
0411: set_actor $GOON_AT_YARD7 use_pednode_seek 0 

009A: $GOON_AT_YARD8 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 360.125 -336.0 16.0 
01B2: give_actor $GOON_AT_YARD8 weapon WEAPONTYPE_M16 ammo 9999 
01E2: add_route_point $YARD_ROUTE3 at 360.125 -336.0 16.0 
01E2: add_route_point $YARD_ROUTE3 at 372.1875 -335.3125 17.0 
01E1: set_actor $GOON_AT_YARD8 follow_route $YARD_ROUTE3 behaviour FOLLOW_ROUTE_BACKFORWARD 
01ED: clear_actor $GOON_AT_YARD8 threat_search 
011A: set_actor $GOON_AT_YARD8 search_threat THREAT_PLAYER1 
0411: set_actor $GOON_AT_YARD8 use_pednode_seek 0 

009A: $GOON_AT_YARD9 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 374.75 -340.375 16.0 
01B2: give_actor $GOON_AT_YARD9 weapon WEAPONTYPE_SHOTGUN ammo 9999 
01E2: add_route_point $YARD_ROUTE2 at 374.75 -340.375 16.0 
01E2: add_route_point $YARD_ROUTE2 at 375.1875 -316.625 18.25 
01E1: set_actor $GOON_AT_YARD9 follow_route $YARD_ROUTE2 behaviour FOLLOW_ROUTE_BACKFORWARD 
01ED: clear_actor $GOON_AT_YARD9 threat_search 
011A: set_actor $GOON_AT_YARD9 search_threat THREAT_PLAYER1 
0411: set_actor $GOON_AT_YARD9 use_pednode_seek 0 

009A: $GOON_AT_YARD10 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 391.0 -298.625 17.1875 
01B2: give_actor $GOON_AT_YARD10 weapon WEAPONTYPE_M16 ammo 9999 
01E2: add_route_point $YARD_ROUTE1 at 391.0 -298.625 17.1875 
01E2: add_route_point $YARD_ROUTE1 at 372.6875 -298.6875 17.1875 
01E1: set_actor $GOON_AT_YARD10 follow_route $YARD_ROUTE1 behaviour FOLLOW_ROUTE_BACKFORWARD 
01ED: clear_actor $GOON_AT_YARD10 threat_search 
011A: set_actor $GOON_AT_YARD10 search_threat THREAT_PLAYER1 
0291: set_actor $GOON_AT_YARD10 attack_when_provoked 1 
0411: set_actor $GOON_AT_YARD10 use_pednode_seek 0 

while 80F6:   not player $PLAYER_CHAR 1 366.9375 -328.0 20.25 radius 1.0 1.0 2.0  //LIFT
	wait 0 ms
	if
		0038:   $C_SITE_AREA_FLAG == 0 
	then
		if
			0118:   actor $GOON_AT_YARD1 dead 
		then
			0004: $C_SITE_AREA_FLAG = 1
		end
		if
			0118:   actor $GOON_AT_YARD2 dead 
		then
			0004: $C_SITE_AREA_FLAG = 1
		end
		if
			0118:   actor $GOON_AT_YARD3 dead 
		then
			0004: $C_SITE_AREA_FLAG = 2
		end
		if
			0118:   actor $GOON_AT_YARD4 dead 
		then
			0004: $C_SITE_AREA_FLAG = 3
		end
		if
			0118:   actor $GOON_AT_YARD5 dead 
		then
			0004: $C_SITE_AREA_FLAG = 5
		end
		if
			0118:   actor $GOON_AT_YARD6 dead 
		then
			0004: $C_SITE_AREA_FLAG = 6
		end
		if
			0118:   actor $GOON_AT_YARD7 dead 
		then
			0004: $C_SITE_AREA_FLAG = 4
		end
		if
			0118:   actor $GOON_AT_YARD8 dead 
		then
			0004: $C_SITE_AREA_FLAG = 4
		end
		if
			0118:   actor $GOON_AT_YARD9 dead 
		then
			0004: $C_SITE_AREA_FLAG = 5
		end
	end

	if and
		0038:   $C_SITE_AREA_FLAG == 0 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 331.75 -303.1875 to 354.5 -280.1875 sphere 0 // AREA 1
	then
		0004: $C_SITE_AREA_FLAG = 1
	end
	if and
		0038:   $C_SITE_AREA_FLAG == 1 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 334.375 -314.5625 to 348.1875 -303.1875 sphere 0 // AREA 2
	then
		0004: $C_SITE_AREA_FLAG = 2
	end
	if and
		0038:   $C_SITE_AREA_FLAG == 2 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 326.375 -327.875 to 334.375 -303.1875 sphere 0 // AREA 3
	then
		0004: $C_SITE_AREA_FLAG = 3
	end
	if and
		0038:   $C_SITE_AREA_FLAG == 3 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 326.375 -341.75 to 334.375 -327.875 sphere 0 // AREA 4
	then
		0004: $C_SITE_AREA_FLAG = 4
	end
	if and
		0038:   $C_SITE_AREA_FLAG == 4 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 334.375 -341.75 to 355.875 -314.5625 sphere 0 // AREA 5
	then
		0004: $C_SITE_AREA_FLAG = 5
	end
	if and
		0038:   $C_SITE_AREA_FLAG == 5 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 355.875 -341.75 to 380.25 -314.5625 sphere 0 // AREA 6
	then
		0004: $C_SITE_AREA_FLAG = 6
	end
	
	01BD: $GAME_TIMER_VAR = current_time_in_ms

	gosub @GOON_AT_YARD1_ROUTINE
	gosub @GOON_AT_YARD2_ROUTINE
	gosub @GOON_AT_YARD3_ROUTINE
	gosub @GOON_AT_YARD4_ROUTINE
	gosub @GOON_AT_YARD5_ROUTINE
	gosub @GOON_AT_YARD6_ROUTINE
	gosub @GOON_AT_YARD7_ROUTINE
	gosub @GOON_AT_YARD8_ROUTINE
	gosub @GOON_AT_YARD9_ROUTINE
	gosub @GOON_AT_YARD10_ROUTINE
	if and
		0118:   actor $GOON_AT_YARD1 dead 
		0118:   actor $GOON_AT_YARD2 dead 
		0118:   actor $GOON_AT_YARD3 dead 
		0118:   actor $GOON_AT_YARD4 dead 
		0118:   actor $GOON_AT_YARD5 dead 
	then
		if and
			0118:   actor $GOON_AT_YARD6 dead 
			0118:   actor $GOON_AT_YARD7 dead 
			0118:   actor $GOON_AT_YARD8 dead 
			0118:   actor $GOON_AT_YARD9 dead 
		then
			if
				0038:   $RESET_TIMERA_FLAG == 0 
			then
				0006: 16@ = 0 
				0004: $RESET_TIMERA_FLAG = 1 
			end
			if and
				0019:   16@ > 10000 
				0038:   $RESET_TIMERA_FLAG == 1 
			then
				00BC: print_now 'LOVE4_6' duration 10000 ms flag 1  // ~g~Take the lift up the tower!
				0004: $RESET_TIMERA_FLAG = 2 
			end
		end
	end
	gosub @HAPPY_GANGCAR_SURPRISE
end //while

0164: disable_marker $LOVE_4_BLIP 

// ****************************************START OF CUTSCENE********************************

0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
0006: 16@ = 0 

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		8019:   not 16@ > 5000 //	If player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
end //while	

03EF: player $PLAYER_CHAR make_safe 
023C: load_special_actor 'CAT' as 1 
023C: load_special_actor 'MIGUEL' as 2 
023C: load_special_actor 'ASUKA' as 3 
02F3: load_object #CUTOBJ01 'D4PROPS' //lift
02F3: load_object #CUTOBJ02 'CATH' 
02F3: load_object #CUTOBJ03 'ASUKAH' 
02F3: load_object #CUTOBJ04 'MIGUELH' 
02F3: load_object #CUTOBJ05 'LIFT' 
0247: request_model #CSITECUTSCENE 
03AF: set_streaming 0 

while fading
	wait 0 ms
end

038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 3 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
	jf break
	wait 0 ms
end //while

while true
	if or
		8248:   not model #CUTOBJ04 available 
		8248:   not model #CUTOBJ05 available 
		8248:   not model #CSITECUTSCENE available 
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 374.75 -340.375 16.0 radius 16.0 object #SCAFFOLDLIFT 0 
02E4: load_cutscene_data 'D4_GTA2' 
0244: set_cutscene_pos 369.0 -327.5 18.4375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_CATALINA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_CATALINA 'CAT' 
02E5: $CUTSCENE_MIGUEL = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MIGUEL 'MIGUEL' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CS_WHIP = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_WHIP 'D4PROPS' 
02E5: $CS_LIFT = create_cutscene_object #CUTOBJ05 
02E6: set_cutscene_anim $CS_LIFT 'LIFT' 
02F4: create_cutscene_actor $CS_CATHEAD from_head #CUTOBJ02 and_body $CUTSCENE_CATALINA 
02F5: set_head_anim $CS_CATHEAD 'CAT' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
02F4: create_cutscene_actor $MARIA_CSHEAD from_head #CUTOBJ04 and_body $CUTSCENE_MIGUEL 
02F5: set_head_anim $MARIA_CSHEAD 'MIGUEL' 
0055: set_player_coordinates $PLAYER_CHAR to 373.75 -327.25 17.1875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   15386 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_A' duration 15000 ms flag 1  // Hey, let's get this out of here. God knows what it is
while 001A:   18600 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_B' duration 15000 ms flag 1  // but he seems to want it badly enough so it must be worth something.
while 001A:   21318 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_C' duration 15000 ms flag 1  // Who the Heck!
while 001A:   21933 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
0005: $PARTICLE_X = 369.0 
000D: $PARTICLE_X -= 0.0 
0005: $PARTICLE_Y = -327.5 
000D: $PARTICLE_Y -= 1.25 
0005: $PARTICLE_Z = 18.4375 
0009: $PARTICLE_Z += 48.375 
0005: $PARTICLE_TARGET_X = 369.0 
000D: $PARTICLE_TARGET_X -= 0.0 
0005: $PARTICLE_TARGET_Y = -327.5 
000D: $PARTICLE_TARGET_Y -= 1.375 
0005: $PARTICLE_TARGET_Z = 18.4375 
0009: $PARTICLE_TARGET_Z += 48.5625 
0086: $TEMP_VAR = $PARTICLE_TARGET_X 
0086: $PARTICLE_TARGET_X = $PARTICLE_X 
0061: $PARTICLE_TARGET_X -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Y 
0086: $PARTICLE_TARGET_Y = $PARTICLE_Y 
0061: $PARTICLE_TARGET_Y -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Z 
0086: $PARTICLE_TARGET_Z = $PARTICLE_Z 
0061: $PARTICLE_TARGET_Z -= $TEMP_VAR 
039D: scatter_particles type POBJECT_CATALINAS_GUNFLASH 1.0 0 0 0 0 from $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 

while 001A:   22167 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
0005: $PARTICLE_X = 369.0 
0009: $PARTICLE_X += 0.25 
0005: $PARTICLE_Y = -327.5 
000D: $PARTICLE_Y -= 1.3125 
0005: $PARTICLE_Z = 18.4375 
0009: $PARTICLE_Z += 48.25 
0005: $PARTICLE_TARGET_X = 369.0 
0009: $PARTICLE_TARGET_X += 0.1875 
0005: $PARTICLE_TARGET_Y = -327.5 
000D: $PARTICLE_TARGET_Y -= 1.5625 
0005: $PARTICLE_TARGET_Z = 18.4375 
0009: $PARTICLE_TARGET_Z += 48.4375 
0086: $TEMP_VAR = $PARTICLE_TARGET_X 
0086: $PARTICLE_TARGET_X = $PARTICLE_X 
0061: $PARTICLE_TARGET_X -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Y 
0086: $PARTICLE_TARGET_Y = $PARTICLE_Y 
0061: $PARTICLE_TARGET_Y -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Z 
0086: $PARTICLE_TARGET_Z = $PARTICLE_Z 
0061: $PARTICLE_TARGET_Z -= $TEMP_VAR 
039D: scatter_particles type POBJECT_CATALINAS_GUNFLASH 1.0 0 0 0 0 from $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
while 001A:   22428 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_D' duration 15000 ms flag 1  // YOU!
while 001A:   23270 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_E' duration 15000 ms flag 1  // Hey take it easy amigo! De nada! De nada!
while 001A:   26829 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_F' duration 15000 ms flag 1  // I left you pouring your heart out into the gutter!
while 001A:   29508 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_G' duration 15000 ms flag 1  // Don't shoot amigo. No problem. We all friends. Here, take this.
while 001A:   33871 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_H' duration 15000 ms flag 1  // Don't be such a pussy!
while 001A:   35408 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_I' duration 15000 ms flag 1  // We got no choice baby!
while 001A:   36700 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
0005: $PARTICLE_X = 369.0 
0009: $PARTICLE_X += 2.4375 
0005: $PARTICLE_Y = -327.5 
000D: $PARTICLE_Y -= 3.875 
0005: $PARTICLE_Z = 18.4375 
0009: $PARTICLE_Z += 47.1875 
0005: $PARTICLE_TARGET_X = 369.0 
0009: $PARTICLE_TARGET_X += 2.5625 
0005: $PARTICLE_TARGET_Y = -327.5 
000D: $PARTICLE_TARGET_Y -= 3.625 
0005: $PARTICLE_TARGET_Z = 18.4375 
0009: $PARTICLE_TARGET_Z += 47.0625 
0086: $TEMP_VAR = $PARTICLE_TARGET_X 
0086: $PARTICLE_TARGET_X = $PARTICLE_X 
0061: $PARTICLE_TARGET_X -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Y 
0086: $PARTICLE_TARGET_Y = $PARTICLE_Y 
0061: $PARTICLE_TARGET_Y -= $TEMP_VAR 
0086: $TEMP_VAR = $PARTICLE_TARGET_Z 
0086: $PARTICLE_TARGET_Z = $PARTICLE_Z 
0061: $PARTICLE_TARGET_Z -= $TEMP_VAR 
039D: scatter_particles type POBJECT_CATALINAS_GUNFLASH 1.0 0 0 0 0 from $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
if
	0351:   gore_enabled 
then
	0005: $PARTICLE_X = 369.0 
	0009: $PARTICLE_X += 2.4375 
	0005: $PARTICLE_Y = -327.5 
	000D: $PARTICLE_Y -= 3.8125 
	0005: $PARTICLE_Z = 18.4375 
	0009: $PARTICLE_Z += 47.1875 
	0005: $PARTICLE_TARGET_X = 369.0 
	0009: $PARTICLE_TARGET_X += 2.375 
	0005: $PARTICLE_TARGET_Y = -327.5 
	000D: $PARTICLE_TARGET_Y -= 4.0625 
	0005: $PARTICLE_TARGET_Z = 18.4375 
	0009: $PARTICLE_TARGET_Z += 47.3125 
	0086: $TEMP_VAR = $PARTICLE_TARGET_X 
	0086: $PARTICLE_TARGET_X = $PARTICLE_X 
	0061: $PARTICLE_TARGET_X -= $TEMP_VAR 
	0086: $TEMP_VAR = $PARTICLE_TARGET_Y 
	0086: $PARTICLE_TARGET_Y = $PARTICLE_Y 
	0061: $PARTICLE_TARGET_Y -= $TEMP_VAR 
	0086: $TEMP_VAR = $PARTICLE_TARGET_Z 
	0086: $PARTICLE_TARGET_Z = $PARTICLE_Z 
	0061: $PARTICLE_TARGET_Z -= $TEMP_VAR 
	0061: $PARTICLE_TARGET_X -= $PARTICLE_X 
	0061: $PARTICLE_TARGET_Y -= $PARTICLE_Y 
	0061: $PARTICLE_TARGET_Z -= $PARTICLE_Z 
	0011: $PARTICLE_TARGET_X *= 0.0 
	0011: $PARTICLE_TARGET_Y *= 0.0 
	0011: $PARTICLE_TARGET_Z *= 0.0 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle 5 0.0 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	0437: scatter_particle PARTICLE_TEST 0.1875 at $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to 0.0 0.0 0.0 
end
while 001A:   37627 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_J' duration 15000 ms flag 1  // We always got a choice you dumb bastard!
while 001A:   41684 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_K' duration 15000 ms flag 1  // I'm sorry about that crazy bitch man, they all the same...por favor??
while 001A:   46468 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_L' duration 15000 ms flag 1  // So the whore got away.
while 001A:   48918 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_M' duration 15000 ms flag 1  // But you've done me a favor,
while 001A:   50755 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_N' duration 15000 ms flag 1  // you're not the only one that has a score to settle with the Cartel,
while 001A:   54352 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_O' duration 15000 ms flag 1  // this worm killed my brother!
while 001A:   56266 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_P' duration 15000 ms flag 1  // I never killed no Yakuza!
while 001A:   57299 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_Q' duration 15000 ms flag 1  // LIAR! We all saw the Cartel assassin.
while 001A:   60721 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_R' duration 15000 ms flag 1  // We are going to hunt down and kill all you Colombian dogs!
while 001A:   64778 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_S' duration 15000 ms flag 1  // I'll be operating on our friend here to extract information and a little pleasure.
while 001A:   70710 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_T' duration 15000 ms flag 1  // You, drop by later, I'm sure I'll require your services.
while 001A:   75150 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'GTAB_U' duration 15000 ms flag 1  // Please amigo, don't leave me with her, she psycho chica! Amigo? Hey AMEEEGO!!!...Aiiieeeeaaargghh!
while 001A:   86666 > $CUT_SCENE_TIME
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
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 
0249: release_model #CSITECUTSCENE 
0247: request_model #YAKUZA 
0247: request_model #GANG07 
038B: load_all_models_now 

while true
	if or
		8248:   not model #YAKUZA available 
		8248:   not model #GANG07 available
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 374.75 -340.375 16.0 radius 16.0 object #SCAFFOLDLIFT 1 
0373: set_camera_directly_behind_player 

if
	03CA:   object $FIXED_INSIDE exists 
then
	0108: destroy_object $FIXED_INSIDE 
end

if
	03CA:   object $FIXED_OUTSIDE exists 
then
	0108: destroy_object $FIXED_OUTSIDE 
end

029B: $FIXED_INSIDE = create_object #BROKEN_INSIDE at 362.8125 -341.3125 17.375 
01C7: remove_object_from_mission_cleanup_list $FIXED_INSIDE 
029B: $FIXED_OUTSIDE = create_object #BROKEN_OUTSIDE at 360.8125 -390.875 22.5625 
01C7: remove_object_from_mission_cleanup_list $FIXED_OUTSIDE 
00A5: $YAKUZA_CAR1 = create_car #YAKUZA at 339.8125 -290.625 16.0 // out front
00A5: $YAKUZA_CAR2 = create_car #YAKUZA at 359.0625 -291.0625 16.0 // out front
00A5: $YAKUZA_CAR3 = create_car #YAKUZA at 363.5625 -339.0625 16.0 // smash fence car
0175: set_car $YAKUZA_CAR1 z_angle_to 158.1875 
0175: set_car $YAKUZA_CAR2 z_angle_to 146.8125 
0175: set_car $YAKUZA_CAR3 z_angle_to 339.3125 
009A: $YAKUZA_GUARD1 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 367.375 -334.1875 16.0625 
01B2: give_actor $YAKUZA_GUARD1 weapon WEAPONTYPE_UZI ammo 300 
0291: set_actor $YAKUZA_GUARD1 attack_when_provoked 1 
009A: $YAKUZA_GUARD2 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 367.625 -337.875 16.0625 
01B2: give_actor $YAKUZA_GUARD2 weapon WEAPONTYPE_UZI ammo 300 
020E: actor $YAKUZA_GUARD2 look_at_actor $YAKUZA_GUARD1 
020E: actor $YAKUZA_GUARD1 look_at_actor $YAKUZA_GUARD2 
0291: set_actor $YAKUZA_GUARD2 attack_when_provoked 1 
03F9: make_actors $YAKUZA_GUARD1 $YAKUZA_GUARD2 converse_in 10000000 ms 
009A: $YAKUZA_GUARD3 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 361.8125 -345.25 16.0 
01B2: give_actor $YAKUZA_GUARD3 weapon WEAPONTYPE_SHOTGUN ammo 300 
0173: set_actor $YAKUZA_GUARD3 z_angle_to 170.0 
0291: set_actor $YAKUZA_GUARD3 attack_when_provoked 1 
009A: $YAKUZA_GUARD4 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 335.5625 -295.6875 16.0 
01B2: give_actor $YAKUZA_GUARD4 weapon WEAPONTYPE_SHOTGUN ammo 300 
0173: set_actor $YAKUZA_GUARD4 z_angle_to 237.0 
0291: set_actor $YAKUZA_GUARD4 attack_when_provoked 1 
009A: $YAKUZA_GUARD5 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at 335.875 -298.0 16.0 
01B2: give_actor $YAKUZA_GUARD5 weapon WEAPONTYPE_UZI ammo 300 
0173: set_actor $YAKUZA_GUARD5 z_angle_to 129.0 
0350: set_actor $YAKUZA_GUARD5 maintain_position_when_attacked 1 
0291: set_actor $YAKUZA_GUARD5 attack_when_provoked 1 

if
	8118:   not actor $GOON_AT_YARD1 dead
then
	0321: kill_actor $GOON_AT_YARD1 
end
if
	8118:   not actor $GOON_AT_YARD2 dead
then
	0321: kill_actor $GOON_AT_YARD2 
end
if
	8118:   not actor $GOON_AT_YARD3 dead
then
	0321: kill_actor $GOON_AT_YARD3 
end
if
	8118:   not actor $GOON_AT_YARD4 dead
then
	0321: kill_actor $GOON_AT_YARD4 
end
if
	8118:   not actor $GOON_AT_YARD5 dead
then
	0321: kill_actor $GOON_AT_YARD5 
end
if
	8118:   not actor $GOON_AT_YARD6 dead
then
	0321: kill_actor $GOON_AT_YARD6 
end
if
	8118:   not actor $GOON_AT_YARD7 dead
then
	0321: kill_actor $GOON_AT_YARD7 
end
if
	8118:   not actor $GOON_AT_YARD8 dead
then
	0321: kill_actor $GOON_AT_YARD8 
end
if
	8118:   not actor $GOON_AT_YARD9 dead
then
	0321: kill_actor $GOON_AT_YARD9 
end
if
	8118:   not actor $GOON_AT_YARD10 dead
then
	0321: kill_actor $GOON_AT_YARD10 
end

03AF: set_streaming 1 
016A: fade 1 for 1500 ms 

while fading
	wait 0 ms
end

// ******************************************END OF CUTSCENE********************************

00BC: print_now 'LOVE4_4' duration 5000 ms flag 1  // ~g~Take the package back to Donald Love!

018A: $LOVE_4_BLIP = create_checkpoint_at 87.25 -1548.563 27.25 // LOVES PAD

009A: $LOVE4_AMBUSH_GOON1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 80.5 -1556.0 -100.0 
01B2: give_actor $LOVE4_AMBUSH_GOON1 weapon WEAPONTYPE_M16 ammo 9999 
01ED: clear_actor $LOVE4_AMBUSH_GOON1 threat_search 
011A: set_actor $LOVE4_AMBUSH_GOON1 search_threat THREAT_PLAYER1 
0173: set_actor $LOVE4_AMBUSH_GOON1 z_angle_to 350.0 
0350: set_actor $LOVE4_AMBUSH_GOON1 maintain_position_when_attacked 1 

009A: $LOVE4_AMBUSH_GOON2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 80.5 -1533.0 -100.0 
01B2: give_actor $LOVE4_AMBUSH_GOON2 weapon WEAPONTYPE_M16 ammo 9999 
01ED: clear_actor $LOVE4_AMBUSH_GOON2 threat_search 
011A: set_actor $LOVE4_AMBUSH_GOON2 search_threat THREAT_PLAYER1 
0173: set_actor $LOVE4_AMBUSH_GOON2 z_angle_to 180.0 
0350: set_actor $LOVE4_AMBUSH_GOON2 maintain_position_when_attacked 1 

while 80F9:   not player $PLAYER_CHAR stopped 1 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	wait 0 ms
end

01C3: remove_references_to_car $YAKUZA_CAR1 
01C3: remove_references_to_car $YAKUZA_CAR2 
01C3: remove_references_to_car $YAKUZA_CAR3 
01C3: remove_references_to_car $CAR_VAN1_LM4 
01C3: remove_references_to_car $CAR_VAN2_LM4 
01C2: remove_references_to_actor $YAKUZA_GUARD1 
01C2: remove_references_to_actor $YAKUZA_GUARD2 
01C2: remove_references_to_actor $YAKUZA_GUARD3 
01C2: remove_references_to_actor $YAKUZA_GUARD4 
01C2: remove_references_to_actor $YAKUZA_GUARD5 
01C2: remove_references_to_actor $GOON_AT_YARD1 
01C2: remove_references_to_actor $GOON_AT_YARD2 
01C2: remove_references_to_actor $GOON_AT_YARD3 
01C2: remove_references_to_actor $GOON_AT_YARD4 
01C2: remove_references_to_actor $GOON_AT_YARD5 
01C2: remove_references_to_actor $GOON_AT_YARD6 
01C2: remove_references_to_actor $GOON_AT_YARD7 
01C2: remove_references_to_actor $GOON_AT_YARD8 
01C2: remove_references_to_actor $GOON_AT_YARD9 
01C2: remove_references_to_actor $GOON_AT_YARD10 

01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
03F4: set_all_cars_can_be_damaged 0 
0110: clear_player $PLAYER_CHAR wanted_level 
015F: set_camera_position 81.3125 -1540.063 27.75 rotation 0.0 0.0 0.0 
0160: point_camera 81.8125 -1540.875 27.75 switchstyle 2 
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

while fading
	wait 0 ms
end

0395: clear_area 0 at 87.25 -1548.563 range 28.25 2.0 
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

goto @MISSION_PASSED_LOVE4

/////////////////////////////////////////

:CHECK_VEHICLES_WRECKED_LOVE4
if
	0119:   car $WINGLESS_CESSNA wrecked 
then
	00BC: print_now 'LOVE4_9' duration 5000 ms flag 1  // ~r~The plane has been destroyed!
	goto @MISSION_FAILED_LOVE4
end
if
	0119:   car $CAR_VAN3_LM4 wrecked 
then
	00BC: print_now 'LOV4_10' duration 5000 ms flag 1  // ~r~The only lead to where the package has gone has been destroyed!
	goto @MISSION_FAILED_LOVE4
end
return		

////////////////////////////////////////

:HAPPY_GANGCAR_SURPRISE
if
	01FC:   player $PLAYER_CHAR near_car $COLOMBIAN_CAR_BOMB radius 5.0 5.0 unknown 0
then
	0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z
	020B: explode_car $COLOMBIAN_CAR_BOMB
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	000D: $PLAYER_X -= 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	000D: $PLAYER_Y -= 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	0009: $PLAYER_X += 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	0009: $PLAYER_X += 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	0009: $PLAYER_Y += 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	0009: $PLAYER_Y += 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	000D: $PLAYER_X -= 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	000D: $PLAYER_X -= 5.0
	020C: create_explosion EXPLOSION_CAR at $PLAYER_X $PLAYER_Y $PLAYER_Z
	wait 500 ms
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR
	then
		00DA: $PLAYER_CAR = store_car_player_is_in $PLAYER_CHAR
		020B: explode_car $PLAYER_CAR
	else
		0322: kill_player $PLAYER_CHAR
	end
	00BC: print_now 'BOOM' duration 5000 ms flag 1  // ~r~Boom goes the dynamite!
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_LOVE4
014C: set_parked_car_generator $COM_CAR37 cars_to_generate_to 101
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_LOVE4

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_LOVE4
0004: $GRAND_THEFT_AERO_COMPLETED = 1 
014C: set_parked_car_generator $COM_CAR37 cars_to_generate_to 0 
014C: set_parked_car_generator $COM_CAR38 cars_to_generate_to 0 
014C: set_parked_car_generator $GEN_CAR60 cars_to_generate_to 101 
014C: set_parked_car_generator $GEN_CAR61 cars_to_generate_to 101 
014C: set_parked_car_generator $GEN_CAR62 cars_to_generate_to 101 
014C: set_parked_car_generator $GEN_CAR63 cars_to_generate_to 101 
01E7: switch_roads_on -46.75 -648.0 39.0 to -69.0625 -614.0 50.0 
0164: disable_marker $ASUKA1_MISSION_MARKER 
01E3: text_1number_styled 'M_PASS' number 50000 duration 2000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 50000 
0110: clear_player $PLAYER_CHAR wanted_level 
0318: set_latest_mission_passed 'LOVE4'  // 'GRAND THEFT AERO'
015C: set_zone_gang_info 'CONSTRU' DAY 30 0 0 0 250 0 50 0 20 
015C: set_zone_gang_info 'CONSTRU' NIGHT 15 0 0 0 300 0 70 0 10 
0394: play_mission_passed_music 1 
030C: set_mission_points += 1 
02A7: $ASUKA1_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_ASUKA at 366.9375 -328.0 20.25 
004F: create_thread @ASUKA_SUBURBAN_MISSION1_LOOP
0164: disable_marker $DONALD_MISSION_MARKER 
goto @MISSION_END_LOVE4

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_LOVE4
0164: disable_marker $LOVE_4_BLIP 
0164: disable_marker $GOON_IN_HANGAR1_BLIP 
0164: disable_marker $GOON_IN_HANGAR2_BLIP 
0164: disable_marker $GOON_IN_HANGAR3_BLIP 
0164: disable_marker $GOON_IN_HANGAR4_BLIP 
03AC: clear_route $HANGAR_ROUTE 
03AC: clear_route $YARD_ROUTE1 
03AC: clear_route $YARD_ROUTE2 
03AC: clear_route $YARD_ROUTE3 
0249: release_model #PANLANT 
0249: release_model #GANG11 
0249: release_model #DODO 
0249: release_model #YAKUZA 
0249: release_model #GANG07 
01C4: remove_references_to_object $DEADMAN1
0249: release_model #COLUMB  
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LOVE = 0 
00D8: mission_has_finished 
return

////////////////////////////////////////

:SET_DEATH_FLAGS
if
	0038:   $GOON_IN_HANGAR1_FLAG == -1 
then
	0004: $GOON_IN_HANGAR1_FLAG = 0 
end
if
	0038:   $GOON_IN_HANGAR1_DUCKING == -1 
then
	0004: $GOON_IN_HANGAR1_DUCKING = 0 
end
if
	0038:   $GOON_IN_HANGAR2_FLAG == -1 
then
	0004: $GOON_IN_HANGAR2_FLAG = 0 
end
if
	0038:   $GOON_IN_HANGAR2_DUCKING == -1 
then
	0004: $GOON_IN_HANGAR2_DUCKING = 0 
end
if
	0038:   $GOON_IN_HANGAR3_FLAG == -1 
then
	0004: $GOON_IN_HANGAR3_FLAG = 0 
end
if
	0038:   $GOON_IN_HANGAR3_DUCKING == -1 
then
	0004: $GOON_IN_HANGAR3_DUCKING = 0 
end
if
	0038:   $GOON_IN_HANGAR4_FLAG == -1 
then
	0004: $GOON_IN_HANGAR4_FLAG = 0 
end
if
	0038:   $GOON_IN_HANGAR4_DUCKING == -1 
then
	0004: $GOON_IN_HANGAR4_DUCKING = 0 
end
if and
	0038:   $GOON_IN_HANGAR1_BLIP_FLAG == 0 
	8118:   not actor $GOON_IN_HANGAR1 dead
then
	0187: $GOON_IN_HANGAR1_BLIP = create_marker_above_actor $GOON_IN_HANGAR1 
	00BC: print_now 'LOVE4_1' duration 5000 ms flag 1  // ~r~The Colombian Cartel is here!!
	0004: $GOON_IN_HANGAR1_BLIP_FLAG = 1 
end
if and
	0038:   $GOON_IN_HANGAR2_BLIP_FLAG == 0 
	8118:   not actor $GOON_IN_HANGAR2 dead
then
	0187: $GOON_IN_HANGAR2_BLIP = create_marker_above_actor $GOON_IN_HANGAR2 
	00BC: print_now 'LOVE4_1' duration 5000 ms flag 1  // ~r~The Colombian Cartel is here!!
	0004: $GOON_IN_HANGAR2_BLIP_FLAG = 1 
end
if and
	0038:   $GOON_IN_HANGAR3_BLIP_FLAG == 0 
	8118:   not actor $GOON_IN_HANGAR3 dead
then
	0187: $GOON_IN_HANGAR3_BLIP = create_marker_above_actor $GOON_IN_HANGAR3 
	00BC: print_now 'LOVE4_1' duration 5000 ms flag 1  // ~r~The Colombian Cartel is here!!
	0004: $GOON_IN_HANGAR3_BLIP_FLAG = 1 
end
if and
	0038:   $GOON_IN_HANGAR4_BLIP_FLAG == 0 
	8118:   not actor $GOON_IN_HANGAR4 dead
then
	0187: $GOON_IN_HANGAR4_BLIP = create_marker_above_actor $GOON_IN_HANGAR4 
	00BC: print_now 'LOVE4_1' duration 5000 ms flag 1  // ~r~The Colombian Cartel is here!!
	0004: $GOON_IN_HANGAR4_BLIP_FLAG = 1 
end
return

////////////////////////////////////////

:DUCKING_ROUTINE
if
	0019:   16@ > 3000 
then
	if
		0038:   $DUCKING_FLAG == 0 
	then
		0004: $DUCKING_FLAG = 1 
	else
		0004: $DUCKING_FLAG = 1 
	end
end
if
	0038:   $GOON_IN_HANGAR1_DUCKING == 1 
then
	0004: $GOON_TEMP = $GOON_IN_HANGAR1
	0004: $GOON_TEMP_WAITSTATE = $GOON_IN_HANGAR1_WAITSTATE
	0005: $TARGET_POS_X = -1280.188
	0005: $TARGET_POS_Y = -520.0625
	gosub @DO_DUCKING_FOR_GOON
	0004: $GOON_IN_HANGAR1_WAITSTATE = $GOON_TEMP_WAITSTATE
end
if
	0038:   $GOON_IN_HANGAR2_DUCKING == 1 
then
	0004: $GOON_TEMP = $GOON_IN_HANGAR2
	0004: $GOON_TEMP_WAITSTATE = $GOON_IN_HANGAR2_WAITSTATE
	0005: $TARGET_POS_X = -1256.375
	0005: $TARGET_POS_Y = -521.25
	gosub @DO_DUCKING_FOR_GOON
	0004: $GOON_IN_HANGAR2_WAITSTATE = $GOON_TEMP_WAITSTATE
end
if
	0038:   $GOON_IN_HANGAR3_DUCKING == 1 
then
	0004: $GOON_TEMP = $GOON_IN_HANGAR3
	0004: $GOON_TEMP_WAITSTATE = $GOON_IN_HANGAR3_WAITSTATE
	0005: $TARGET_POS_X = -1254.375
	0005: $TARGET_POS_Y = -521.25
	gosub @DO_DUCKING_FOR_GOON
	0004: $GOON_IN_HANGAR3_WAITSTATE = $GOON_TEMP_WAITSTATE
end
if
	0038:   $GOON_IN_HANGAR4_DUCKING == 1 
then
	0004: $GOON_TEMP = $GOON_IN_HANGAR4
	0004: $GOON_TEMP_WAITSTATE = $GOON_IN_HANGAR4_WAITSTATE
	0005: $TARGET_POS_X = -1280.75
	0005: $TARGET_POS_Y = -529.1875
	gosub @DO_DUCKING_FOR_GOON
	0004: $GOON_IN_HANGAR4_WAITSTATE = $GOON_TEMP_WAITSTATE
end
return

////////////////////////////////////////

:DO_DUCKING_FOR_GOON
if
	00F0:   actor $GOON_TEMP stopped 0 $TARGET_POS_X $TARGET_POS_Y radius 1.5 1.5 
then
	if
		0038:   $DUCKING_FLAG == 0
	then
		0372: set_actor $GOON_TEMP anim WAITSTATE_FALSE wait_state_time 100 ms 
		0350: set_actor $GOON_TEMP maintain_position_when_attacked 1 
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_TEMP destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_TEMP kill_player $PLAYER_CHAR 
		end
		0004: $GOON_TEMP_WAITSTATE = 0 
	else
		if
			0038:   $GOON_TEMP_WAITSTATE == 0 
		then
			0350: set_actor $GOON_TEMP maintain_position_when_attacked 1 
			0192: set_actor $GOON_TEMP objective_to_stand_still 
			0372: set_actor $GOON_TEMP anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_TEMP_WAITSTATE = 1
		end
	end
else
	0350: set_actor $GOON_TEMP maintain_position_when_attacked 0 
	0239: actor $GOON_TEMP run_to $TARGET_POS_X $TARGET_POS_Y 
end
return

////////////////////////////////////////

:GOON_AT_YARD1_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 0 
	8118:   not actor $GOON_AT_YARD1 dead
then
	if
		0038:   $GOON_AT_YARD1_FLAG == 0 
	then
		0350: set_actor $GOON_AT_YARD1 maintain_position_when_attacked 0 
		0372: set_actor $GOON_AT_YARD1 anim WAITSTATE_FALSE wait_state_time 100 ms 
		01B2: give_actor $GOON_AT_YARD1 weapon WEAPONTYPE_M16 ammo 9999 
		0239: actor $GOON_AT_YARD1 run_to 345.0625 -309.5625 
		0004: $GOON_AT_YARD1_FLAG = 1 
	end
	if and
		0038:   $GOON_AT_YARD1_FLAG == 1 
		00ED:   actor $GOON_AT_YARD1 0 345.0625 -309.5625 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD1 run_to 345.3125 -313.1875 
		0004: $GOON_AT_YARD1_FLAG = 2 
	end
	if and
		0038:   $GOON_AT_YARD1_FLAG == 2 
		00ED:   actor $GOON_AT_YARD1 0 345.3125 -313.1875 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD1 run_to 342.125 -312.75 
		0004: $GOON_AT_YARD1_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD1_FLAG == 3 
		00ED:   actor $GOON_AT_YARD1 0 342.125 -312.75 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD1 maintain_position_when_attacked 1
		0004: $GOON_AT_YARD1_FLAG = 4
	end
	if and
		0038:   $GOON_AT_YARD1_FLAG == 3 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD1_DUCK_TIMER 
	then
		0084: $GOON_AT_YARD1_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD1_DUCK_TIMER += 3000 
		if
			0038:   $GOON_AT_YARD1_DUCK == 0 
		then
			0372: set_actor $GOON_AT_YARD1 anim WAITSTATE_FALSE wait_state_time 100 ms
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD1 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD1 kill_player $PLAYER_CHAR 
			end
			if
				0038:   $C_SITE_AREA_FLAG == 1 
			then
				0004: $GOON_AT_YARD1_DUCK = 1 
			end
		else
			0192: set_actor $GOON_AT_YARD1 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD1 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD1_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD2_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 0 
	8118:   not actor $GOON_AT_YARD2 dead
then
	if
		0038:   $GOON_AT_YARD2_FLAG == 0 
	then
		0372: set_actor $GOON_AT_YARD2 anim WAITSTATE_FALSE wait_state_time 100 ms 
		01B2: give_actor $GOON_AT_YARD2 weapon WEAPONTYPE_SHOTGUN ammo 9999 
		0350: set_actor $GOON_AT_YARD2 maintain_position_when_attacked 1
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD2 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD2 kill_player $PLAYER_CHAR 
		end
		0004: $GOON_AT_YARD2_FLAG = 1 
		0084: $GOON_AT_YARD2_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD2_DUCK_TIMER += 2000 
	end
	if and
		0038:   $GOON_AT_YARD2_FLAG == 1 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD2_DUCK_TIMER 
	then
		0350: set_actor $GOON_AT_YARD2 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD2 run_to 333.625 -307.5625 
		0004: $GOON_AT_YARD2_FLAG = 2 
	end
	if and
		0038:   $GOON_AT_YARD2_FLAG == 2 
		00ED:   actor $GOON_AT_YARD2 0 333.625 -307.5625 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD2 run_to 333.4375 -304.75 
		0004: $GOON_AT_YARD2_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD2_FLAG == 3 
		00ED:   actor $GOON_AT_YARD2 0 333.4375 -304.75 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD2 maintain_position_when_attacked 1
		0004: $GOON_AT_YARD2_FLAG = 4
	end
	if and
		0038:   $GOON_AT_YARD2_FLAG == 4 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD2_DUCK_TIMER 
	then
		0084: $GOON_AT_YARD2_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD2_DUCK_TIMER += 3000 
		if
			0038:   $GOON_AT_YARD2_DUCK == 0 
		then
			0372: set_actor $GOON_AT_YARD2 anim WAITSTATE_FALSE wait_state_time 100 ms
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD2 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD2 kill_player $PLAYER_CHAR 
			end
			if
				001A:   3 > $C_SITE_AREA_FLAG 
			then
				0004: $GOON_AT_YARD2_DUCK = 1 
			end
		else
			0192: set_actor $GOON_AT_YARD2 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD2 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD2_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD3_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 1 
	8118:   not actor $GOON_AT_YARD3 dead
then
	if
		0038:   $GOON_AT_YARD3_FLAG == 0 
	then
		0372: set_actor $GOON_AT_YARD3 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0350: set_actor $GOON_AT_YARD3 maintain_position_when_attacked 1
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD3 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD3 kill_player $PLAYER_CHAR 
		end
		0004: $GOON_AT_YARD3_FLAG = 1 
		0084: $GOON_AT_YARD3_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD3_DUCK_TIMER += 2000 
	end
	if and
		0038:   $GOON_AT_YARD3_FLAG == 1 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD3_DUCK_TIMER 
	then
		0350: set_actor $GOON_AT_YARD3 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD3 run_to 331.6875 -329.125
		0004: $GOON_AT_YARD3_FLAG = 2 
	end
	if and
		0038:   $GOON_AT_YARD3_FLAG == 2 
		00ED:   actor $GOON_AT_YARD3 0 331.6875 -329.125 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD3 run_to 327.625 -329.125 
		0004: $GOON_AT_YARD3_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD3_FLAG == 3 
		00ED:   actor $GOON_AT_YARD3 0 327.625 -329.125 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD3 maintain_position_when_attacked 1
		0004: $GOON_AT_YARD3_FLAG = 4
	end
	if and
		0038:   $GOON_AT_YARD3_FLAG == 4 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD3_DUCK_TIMER 
	then
		0084: $GOON_AT_YARD3_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD3_DUCK_TIMER += 3000 
		if
			0038:   $GOON_AT_YARD3_DUCK == 0 
		then
			0372: set_actor $GOON_AT_YARD3 anim WAITSTATE_FALSE wait_state_time 100 ms
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD3 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD3 kill_player $PLAYER_CHAR 
			end
			if
				001A:   4 > $C_SITE_AREA_FLAG 
			then
				0004: $GOON_AT_YARD3_DUCK = 1 
			end
		else
			0192: set_actor $GOON_AT_YARD3 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD3 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD3_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD4_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 2 
	8118:   not actor $GOON_AT_YARD4 dead
then
	if
		0038:   $GOON_AT_YARD4_FLAG == 0 
	then
		0372: set_actor $GOON_AT_YARD4 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0350: set_actor $GOON_AT_YARD4 maintain_position_when_attacked 1
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD4 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD4 kill_player $PLAYER_CHAR 
		end
		0004: $GOON_AT_YARD4_FLAG = 1
	end
	if and
		0038:   $GOON_AT_YARD4_FLAG == 1 
		0123:   actor $GOON_AT_YARD4 spotted_player $PLAYER_CHAR 
	then
		0084: $GOON_AT_YARD4_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD4_DUCK_TIMER += 2000 
		0004: $GOON_AT_YARD4_FLAG = 2 
	end
	if and
		0038:   $GOON_AT_YARD4_FLAG == 2 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD4_DUCK_TIMER
	then
		0350: set_actor $GOON_AT_YARD4 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD4 run_to 338.625 -329.375 
		0004: $GOON_AT_YARD4_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD4_FLAG == 3 
		00ED:   actor $GOON_AT_YARD4 0 338.625 -329.375 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD4 maintain_position_when_attacked 1
		0004: $GOON_AT_YARD4_FLAG = 4
	end
	if and
		0038:   $GOON_AT_YARD4_FLAG == 4 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD4_DUCK_TIMER 
	then
		0084: $GOON_AT_YARD4_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD4_DUCK_TIMER += 3000 
		if
			0038:   $GOON_AT_YARD4_DUCK == 0 
		then
			0372: set_actor $GOON_AT_YARD4 anim WAITSTATE_FALSE wait_state_time 100 ms
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD4 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD4 kill_player $PLAYER_CHAR 
			end
			if
				001A:   5 > $C_SITE_AREA_FLAG 
			then
				0004: $GOON_AT_YARD4_DUCK = 1 
			end
		else
			0192: set_actor $GOON_AT_YARD4 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD4 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD4_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD5_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 3 
	8118:   not actor $GOON_AT_YARD5 dead
then
	if
		0038:   $GOON_AT_YARD5_FLAG == 0 
	then
		0350: set_actor $GOON_AT_YARD5 maintain_position_when_attacked 0 
		0372: set_actor $GOON_AT_YARD5 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0239: actor $GOON_AT_YARD5 run_to 354.625 -325.375 
		0004: $GOON_AT_YARD5_FLAG = 1
	end
	if and
		0038:   $GOON_AT_YARD5_FLAG == 1 
		00ED:   actor $GOON_AT_YARD5 0 354.625 -325.375 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD5 run_to 345.9375 -325.4375 
		0004: $GOON_AT_YARD5_FLAG = 2
	end
	if and
		0038:   $GOON_AT_YARD5_FLAG == 2 
		00ED:   actor $GOON_AT_YARD5 0 345.9375 -325.4375 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD5 run_to 341.625 -327.4375 
		0004: $GOON_AT_YARD5_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD5_FLAG == 3 
		00ED:   actor $GOON_AT_YARD5 0 341.625 -327.4375 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD5 maintain_position_when_attacked 1
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD5 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD5 kill_player $PLAYER_CHAR 
			0004: $GOON_AT_YARD5_FLAG = 4
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD6_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 2 
	8118:   not actor $GOON_AT_YARD6 dead
then
	if
		0038:   $GOON_AT_YARD6_FLAG == 0 
	then
		0350: set_actor $GOON_AT_YARD6 maintain_position_when_attacked 0 
		0372: set_actor $GOON_AT_YARD6 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0239: actor $GOON_AT_YARD6 run_to 365.875 -317.25 
		0004: $GOON_AT_YARD6_FLAG = 1
	end
	if
		0038:   $GOON_AT_YARD6_FLAG == 1 
	then
		if
			00ED:   actor $GOON_AT_YARD6 0 365.875 -317.25 radius 1.0 1.0 
		then
			0239: actor $GOON_AT_YARD6 run_to 335.6875 -316.25 
			0004: $GOON_AT_YARD6_FLAG = 2
		end
	end
	if
		0038:   $GOON_AT_YARD6_FLAG == 2 
	then
		if
			00ED:   actor $GOON_AT_YARD6 0 335.6875 -316.25 radius 1.0 1.0 
		then
			0350: set_actor $GOON_AT_YARD6 maintain_position_when_attacked 1
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD6 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD6 kill_player $PLAYER_CHAR 
				0004: $GOON_AT_YARD6_FLAG = 3
			end
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD7_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 3 
	8118:   not actor $GOON_AT_YARD7 dead
then
	if
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD7_DUCK_TIMER
	then
		0350: set_actor $GOON_AT_YARD7 maintain_position_when_attacked 1 
		0084: $GOON_AT_YARD7_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD7_DUCK_TIMER += 3000
		if
			0038:   $GOON_AT_YARD7_DUCK == 0
		then
			0372: set_actor $GOON_AT_YARD7 anim WAITSTATE_FALSE wait_state_time 100 ms 
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD7 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD7 kill_player $PLAYER_CHAR 
			end
			if
				001A:   6 > $C_SITE_AREA_FLAG
			then
				0004: $GOON_AT_YARD7_DUCK = 1
			end
		else
			0192: set_actor $GOON_AT_YARD7 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD7 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD7_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD8_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 3 
	8118:   not actor $GOON_AT_YARD8 dead
then
	if
		0038:   $GOON_AT_YARD8_FLAG == 0 
	then
		0192: set_actor $GOON_AT_YARD8 objective_to_stand_still 
		009F: char_set_idle $GOON_AT_YARD8 
		03AC: clear_route $YARD_ROUTE3 
		0372: set_actor $GOON_AT_YARD8 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0350: set_actor $GOON_AT_YARD8 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD8 run_to 375.4375 -331.1875 
		0004: $GOON_AT_YARD8_FLAG = 1
	end
	if and
		0038:   $GOON_AT_YARD8_FLAG == 1 
		00ED:   actor $GOON_AT_YARD8 0 375.4375 -331.1875 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD8 run_to 363.6875 -330.9375 
		0004: $GOON_AT_YARD8_FLAG = 2
	end
	if and
		0038:   $GOON_AT_YARD8_FLAG == 2 
		00ED:   actor $GOON_AT_YARD8 0 363.6875 -330.9375 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD8 maintain_position_when_attacked 1
		0004: $GOON_AT_YARD8_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD8_FLAG == 3 
		001C:   $GAME_TIMER_VAR > $GOON_AT_YARD8_DUCK_TIMER 
	then
		0084: $GOON_AT_YARD8_DUCK_TIMER = $GAME_TIMER_VAR 
		0008: $GOON_AT_YARD8_DUCK_TIMER += 3000 
		if
			0038:   $GOON_AT_YARD8_DUCK == 0
		then
			0372: set_actor $GOON_AT_YARD8 anim WAITSTATE_FALSE wait_state_time 100 ms 
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD8 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD8 kill_player $PLAYER_CHAR 
			end
			if
				001A:   6 > $C_SITE_AREA_FLAG
			then
				0004: $GOON_AT_YARD8_DUCK = 1
			end
		else
			0192: set_actor $GOON_AT_YARD8 objective_to_stand_still 
			0372: set_actor $GOON_AT_YARD8 anim WAITSTATE_PLAYANIM_DUCK wait_state_time 3000 ms 
			0004: $GOON_AT_YARD8_DUCK = 0 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD9_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 3 
	8118:   not actor $GOON_AT_YARD9 dead
then
	if
		0038:   $GOON_AT_YARD9_FLAG == 0 
	then
		0192: set_actor $GOON_AT_YARD9 objective_to_stand_still 
		009F: char_set_idle $GOON_AT_YARD9 
		03AC: clear_route $YARD_ROUTE2 
		0372: set_actor $GOON_AT_YARD9 anim WAITSTATE_FALSE wait_state_time 100 ms 
		0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD8 run_to 374.9375 -311.8125 
		0004: $GOON_AT_YARD9_FLAG = 1
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 1 
		00ED:   actor $GOON_AT_YARD9 0 374.9375 -311.8125 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD9 run_to 348.125 -301.9375 
		0004: $GOON_AT_YARD9_FLAG = 2
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 2 
		00ED:   actor $GOON_AT_YARD9 0 348.125 -301.9375 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD9 run_to 342.9375 -302.625
		0004: $GOON_AT_YARD9_FLAG = 3 
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 3 
		00ED:   actor $GOON_AT_YARD9 0 342.9375 -302.625 radius 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD9 run_to 327.625 -317.25 
		0004: $GOON_AT_YARD9_FLAG = 4 
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 4 
		00ED:   actor $GOON_AT_YARD9 0 327.625 -317.25 radius 1.0 1.0
	then
		if
			0038:   $C_SITE_AREA_FLAG == 4
		then
			0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 1 
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD9 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD9 kill_player $PLAYER_CHAR 
			end
		else
			0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 0 
			0239: actor $GOON_AT_YARD9 run_to 335.1875 -334.875 
			0004: $GOON_AT_YARD9_FLAG = 5
		end
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 5 
		00ED:   actor $GOON_AT_YARD9 0 335.1875 -334.875 radius 1.0 1.0
	then
		if
			0038:   $C_SITE_AREA_FLAG == 5
		then
			0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 1 
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD9 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD9 kill_player $PLAYER_CHAR 
			end
		else
			0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 0 
			0239: actor $GOON_AT_YARD9 run_to 360.375 -337.9375 
			0004: $GOON_AT_YARD9_FLAG = 6
		end
	end
	if and
		0038:   $GOON_AT_YARD9_FLAG == 6 
		00ED:   actor $GOON_AT_YARD9 0 360.375 -337.9375 radius 1.0 1.0
	then
		0350: set_actor $GOON_AT_YARD9 maintain_position_when_attacked 1 
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD9 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD9 kill_player $PLAYER_CHAR 
		end
	end
end
return

////////////////////////////////////////

:GOON_AT_YARD10_ROUTINE
if and
	0018:   $C_SITE_AREA_FLAG > 0 
	8118:   not actor $GOON_AT_YARD10 dead
then
	if
		0038:   $GOON_AT_YARD10_FLAG == 0 
	then
		0291: set_actor $GOON_AT_YARD10 attack_when_provoked 0 
		0192: set_actor $GOON_AT_YARD10 objective_to_stand_still 
		009F: char_set_idle $GOON_AT_YARD10 
		03AC: clear_route $YARD_ROUTE1 
		0372: set_actor $GOON_AT_YARD10 anim 0 wait_state_time 100 ms 
		0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 0 
		0239: actor $GOON_AT_YARD10 run_to 372.5625 -298.4375 
		0004: $GOON_AT_YARD10_FLAG = 1 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 1 
		00ED:   actor $GOON_AT_YARD10 0 372.5625 -298.4375 radius 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 1 
		0004: $GOON_AT_YARD10_FLAG = 2
	end
	if
		0038:   $GOON_AT_YARD10_FLAG == 2 
	then
		if
			0038:   $C_SITE_AREA_FLAG == 1
		then
			if
				001C:   $GAME_TIMER_VAR > $GOON_AT_YARD10_DUCK_TIMER 
			then
				0084: $GOON_AT_YARD10_DUCK_TIMER = $GAME_TIMER_VAR 
				0008: $GOON_AT_YARD10_DUCK_TIMER += 3000 
				if
					0038:   $GOON_AT_YARD10_DUCK == 0
				then
					0372: set_actor $GOON_AT_YARD10 anim WAITSTATE_FALSE wait_state_time 100 ms
					if
						00E0:   is_player_in_any_car $PLAYER_CHAR 
					then
						00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
						01D9: actor $GOON_AT_YARD10 destroy_car $PLAYERS_VEHICLE
					else
						01CA: actor $GOON_AT_YARD10 kill_player $PLAYER_CHAR 
					end
					0004: $GOON_AT_YARD10_DUCK = 1 
				else
					0192: set_actor $GOON_AT_YARD10 objective_to_stand_still 
					0372: set_actor $GOON_AT_YARD10 anim 14 wait_state_time 3000 ms 
					0004: $GOON_AT_YARD10_DUCK = 0
				end
			end
		else
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 0 
			0372: set_actor $GOON_AT_YARD10 anim 0 wait_state_time 100 ms 
			0239: actor $GOON_AT_YARD10 run_to 372.8125 -266.8125 
			0004: $GOON_AT_YARD10_FLAG = 3 
		end
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 3 
		00ED:   actor $GOON_AT_YARD10 0 372.8125 -266.8125 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD10 run_to 363.875 -266.5 
		0004: $GOON_AT_YARD10_FLAG = 4 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 4 
		00ED:   actor $GOON_AT_YARD10 0 363.875 -266.5 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD10 run_to 361.9375 -290.5 
		0004: $GOON_AT_YARD10_FLAG = 5 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 5 
		00ED:   actor $GOON_AT_YARD10 0 361.9375 -290.5 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD10 run_to 341.375 -298.1875 
		0004: $GOON_AT_YARD10_FLAG = 6 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 6 
		00ED:   actor $GOON_AT_YARD10 0 341.375 -298.1875 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD10 run_to 342.3125 -303.625 
		0004: $GOON_AT_YARD10_FLAG = 7 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 7 
		00ED:   actor $GOON_AT_YARD10 0 342.3125 -303.625 1.0 1.0 
	then
		if
			0038:   $C_SITE_AREA_FLAG == 2
		then
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 1
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD10 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD10 kill_player $PLAYER_CHAR 
			end
		else
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 0 
			0239: actor $GOON_AT_YARD10 run_to 338.1875 -308.1875 
			0004: $GOON_AT_YARD10_FLAG = 8 
		end
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 8 
		00ED:   actor $GOON_AT_YARD10 0 338.1875 -308.1875 1.0 1.0 
	then
		0239: actor $GOON_AT_YARD10 run_to 330.4375 -314.0625 
		0004: $GOON_AT_YARD10_FLAG = 9 
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 9 
		00ED:   actor $GOON_AT_YARD10 0 330.4375 -314.0625 1.0 1.0 
	then
		if or
			0038:   $C_SITE_AREA_FLAG == 3
			0038:   $C_SITE_AREA_FLAG == 4
		then
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 1
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD10 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD10 kill_player $PLAYER_CHAR 
			end
		else
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 0 
			0239: actor $GOON_AT_YARD10 run_to 334.625 -338.6875 
			0004: $GOON_AT_YARD10_FLAG = 10 
		end
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 10 
		00ED:   actor $GOON_AT_YARD10 0 334.625 -338.6875 1.0 1.0 
	then
		if
			0038:   $C_SITE_AREA_FLAG == 5
		then
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 1
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
				01D9: actor $GOON_AT_YARD10 destroy_car $PLAYERS_VEHICLE
			else
				01CA: actor $GOON_AT_YARD10 kill_player $PLAYER_CHAR 
			end
		else
			0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 0 
			0239: actor $GOON_AT_YARD10 run_to 360.1875 -336.6875 
			0004: $GOON_AT_YARD10_FLAG = 11 
		end
	end
	if and
		0038:   $GOON_AT_YARD10_FLAG == 11 
		00ED:   actor $GOON_AT_YARD10 0 360.1875 -336.6875 1.0 1.0 
	then
		0350: set_actor $GOON_AT_YARD10 maintain_position_when_attacked 1
		if
			00E0:   is_player_in_any_car $PLAYER_CHAR 
		then
			00DA: $PLAYERS_VEHICLE = store_car_player_is_in $PLAYER_CHAR 
			01D9: actor $GOON_AT_YARD10 destroy_car $PLAYERS_VEHICLE
		else
			01CA: actor $GOON_AT_YARD10 kill_player $PLAYER_CHAR 
		end
	end
end
return

////////////////////////////////////////
