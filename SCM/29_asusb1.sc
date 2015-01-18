// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************ASUKA SUBURBAN MISSION 1****************************** 
// *****************************************************************************************
// ******************************************'BAIT'*****************************************
// *****************************************************************************************

// Mission start stuff

:M29_BAIT

gosub @MISSION_START_AS1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_AS1
end

:MISSION_END_AS1
gosub @MISSION_CLEANUP_AS1
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_AS1
0317: increment_mission_attempts 
03A4: name_thread 'ASUSB1' 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA2 = 1 
0001: wait 0 ms 

// ****************************************START OF CUTSCENE********************************

0247: request_model #CSITECUTSCENE 
023C: load_special_actor 'ASUKA' as 1 
023C: load_special_actor 'MIGUEL' as 2 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'ASUKAH' 
02F3: load_object #CUTOBJ03 'WHIP' 
038B: load_all_models_now 


while true
	if or
		8248:   not model #CSITECUTSCENE available 
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 	
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A6_BAIT' 
03AF: set_streaming 1 
0244: set_cutscene_pos 369.0 -327.5 18.4375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CUTSCENE_MIGUEL = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MIGUEL 'MIGUEL' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
02E5: $CS_WHIP = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $CS_WHIP 'WHIP' 
0055: set_player_coordinates $PLAYER_CHAR to 373.75 -327.25 17.1875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   3598 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS1_A' duration 10000 ms flag 1  // ~w~Miguel seems to think I'm mistreating him.
while 001A:   6277 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS1_B' duration 10000 ms flag 1  // ~w~Still, he's revealed the extent to which Catalina fears your quest for revenge.
while 001A:   12209 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS1_C' duration 10000 ms flag 1  // ~w~She has three death squads dotted around Liberty, whose sole job is to hunt you down.
while 001A:   17758 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS1_D' duration 10000 ms flag 1  // ~w~Act as the bait, and get the death squads to follow you to Pike Creek
while 001A:   22581 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AS1_E' duration 10000 ms flag 1  // ~w~where some of my men will be waiting for them.
while 001A:   29000 > $CUT_SCENE_TIME
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

//---------------------------------SET FLAGS & VARIABLES-------------------------------------------
0004: $FLAG_YAK1_DEAD = 0 
0004: $FLAG_YAK2_DEAD = 0 
0004: $FLAG_YAK3_DEAD = 0 
0004: $FLAG_YAK4_DEAD = 0 
0004: $FLAG_YAK5_DEAD = 0 
0004: $FLAG_YAK6_DEAD = 0 
0004: $COUNTER_YAKUZA_KILLED_AS1 = 0 
0004: $FLAG_CARTEL_A_CREATED = 0 
0004: $FLAG_CARTEL_B_CREATED = 0 
0004: $FLAG_CARTEL_C_CREATED = 0 
0004: $FLAG_CARTEL_D_CREATED = 0 
0004: $FLAG_YAKUZA_CREATED_AS1 = 0 
0004: $CARTEL1_AS1_DEAD = 0 
0004: $CARTEL2_AS1_DEAD = 0 
0004: $CARTEL3_AS1_DEAD = 0 
0004: $CARTEL4_AS1_DEAD = 0 
0004: $CARTEL5_AS1_DEAD = 0 
0004: $CARTEL6_AS1_DEAD = 0 
0004: $CARTEL7_AS1_DEAD = 0 
0004: $CARTEL8_AS1_DEAD = 0 
0004: $CARTEL9_AS1_DEAD = 0 
0004: $CARTEL10_AS1_DEAD = 0 
0004: $CARTEL11_AS1_DEAD = 0 
0004: $CARTEL12_AS1_DEAD = 0 
0004: $CARTEL13_AS1_DEAD = 0 
0004: $CARTEL14_AS1_DEAD = 0 
0004: $CARTEL15_AS1_DEAD = 0 
0004: $CARTEL16_AS1_DEAD = 0 
0004: $COUNTER_CARTELS_KILLED_AS1 = 0 
0004: $COUNTER_BAILOUTS = 0 
0004: $FLAG_BAILOUT_A = 0 
0004: $FLAG_BAILOUT_B = 0 
0004: $FLAG_BAILOUT_C = 0 
0004: $FLAG_BAILOUT_D = 0 
0004: $YAKS_A_KILLED_BY_PLAYER = 0 
0004: $YAKS_B_KILLED_BY_PLAYER = 0 
0004: $YAKS_KILLED_BY_PLAYER = 0 
0004: $TIMER_AS3_NOW = 0 
0004: $PARTICLE_TIME = 0 
0004: $FLAG_PARTICLE = 0 
0004: $FLAG_A_ATTACK = 0 
0004: $FLAG_B_ATTACK = 0 
0004: $FLAG_C_ATTACK = 0 
0004: $FLAG_D_ATTACK = 0 
0004: $FLAG_WELLYBOB = 0 
0004: $ROAD_BLOCK_CREATED_AS1 = 0

// ****************************************LOCATION COORDS**************************************

0005: $KILLZONE_CENT_X = -1185.0 
0005: $KILLZONE_CENT_Y = 105.0 
0005: $KILLZONE_MIN_X = -1254.0 
0005: $KILLZONE_MIN_Y = 85.0 
0005: $KILLZONE_MAX_X = -1178.0 
0005: $KILLZONE_MAX_Y = 160.0 
0005: $CARTEL_A_X = -996.8125 // Punk Noodles
0005: $CARTEL_A_Y = -247.5 
0005: $CARTEL_B_X = -877.0 // Dam (east end)
0005: $CARTEL_B_Y = 562.0 
0005: $CARTEL_C_X = -714.0 // AIRPORT
0005: $CARTEL_C_Y = -722.0 
0005: $CARTEL_D_X = -459.0 // Cedar Grove
0005: $CARTEL_D_Y = 251.5 
0005: $YAK1_X = -1168.0 
0005: $YAK1_Y = 110.25 
0005: $YAK2_X = -1185.0 
0005: $YAK2_Y = 90.375 
0005: $YAK3_X = -1205.188 
0005: $YAK3_Y = 94.0625 
0005: $YAK4_X = -1160.0 
0005: $YAK4_Y = 119.5625 
0005: $YAK5_X = -1173.25 
0005: $YAK5_Y = 95.5 
0005: $YAK6_X = -1184.5 
0005: $YAK6_Y = 122.5625 
0005: $CAR_A_AS1_X = 0.0 
0005: $CAR_A_AS1_Y = 0.0 
0005: $CAR_A_AS1_Z = 0.0 
0005: $CAR_B_AS1_X = 0.0 
0005: $CAR_B_AS1_Y = 0.0 
0005: $CAR_B_AS1_Z = 0.0 
0005: $CAR_C_AS1_X = 0.0 
0005: $CAR_C_AS1_Y = 0.0 
0005: $CAR_C_AS1_Z = 0.0 
0005: $CAR_D_AS1_X = 0.0 
0005: $CAR_D_AS1_Y = 0.0 
0005: $CAR_D_AS1_Z = 0.0 
018A: $BLIP_CARTEL_A_AS1 = create_checkpoint_at $CARTEL_A_X $CARTEL_A_Y -100.0 
018A: $BLIP_CARTEL_B_AS1 = create_checkpoint_at $CARTEL_B_X $CARTEL_B_Y -100.0 
018A: $BLIP_CARTEL_C_AS1 = create_checkpoint_at $CARTEL_C_X $CARTEL_C_Y -100.0 
018A: $BLIP_CARTEL_D_AS1 = create_checkpoint_at $CARTEL_D_X $CARTEL_D_Y -100.0 
018A: $BLIP_KILLZONE = create_checkpoint_at $KILLZONE_CENT_X $KILLZONE_CENT_Y -100.0 
0165: set_marker $BLIP_KILLZONE color_to 4 
03C4: set_status_text_to $COUNTER_CARTELS_KILLED_AS1 0 'KILLS'  // KILLS:
01E8: switch_roads_off $KILLZONE_MIN_X $KILLZONE_MIN_Y 65.0 to -1170.0 $KILLZONE_MAX_Y 85.0 
0247: request_model #GANG07 
0247: request_model #GANG08 
0247: request_model #GANG11 
0247: request_model #GANG12 
0247: request_model #SENTINEL 


while true
	if or
		8248:   not model #GANG07 available 
		8248:   not model #GANG08 available 
		8248:   not model #GANG11 available 
		8248:   not model #GANG12 available 
		8248:   not model #SENTINEL available 
	jf break
	wait 0 ms
end //while

gosub @EVERYONE_HATES_YOU
0297: clear_rampage_kills 

while 001A:   16 > $COUNTER_CARTELS_KILLED_AS1 
	wait 0 ms
	0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z 
	if
		00F5:   player $PLAYER_CHAR 0 $KILLZONE_MIN_X $KILLZONE_MIN_Y 65.0 radius $KILLZONE_MAX_X $KILLZONE_MAX_Y 75.0 
	then
		0004: $FLAG_WELLYBOB = 1 
	else
		0004: $FLAG_WELLYBOB = 0
	end

	gosub @YAK_DEATHS

	if
		0018:   $COUNTER_YAKUZA_KILLED_AS1 > 5 
	then
		00BC: print_now 'AS1_G' duration 3000 ms flag 1  // ~r~All the Yakuza are dead!!
		goto @MISSION_FAILED_AS1

	end

	gosub @CARTEL_DEATHS

	01BD: $TIMER_AS3_NOW = current_time_in_ms 
	if
		001C:   $TIMER_AS3_NOW > $PARTICLE_TIME 
	then
		0084: $PARTICLE_TIME = $TIMER_AS3_NOW 
		0008: $PARTICLE_TIME += 6000 
		0004: $FLAG_PARTICLE = 1 
	end

	if
		0038:   $ROAD_BLOCK_CREATED_AS1 == 0
	then
		gosub @ROAD_BLOCK_AS1
	end

	gosub @YAKUZA_KILLZONE_GENERATION

	//--------------------------------CARTEL DEATH SQUAD 1 GENERATOR-----------------------------------------
	if
		0038:   $FLAG_CARTEL_A_CREATED == 0 
	then
		if or
			0121:   player $PLAYER_CHAR in_zone 'SUB_IND'  // Pike Creek
			0121:   player $PLAYER_CHAR in_zone 'AIRPORT'  // Francis Intl. Airport
		then
			00A5: $CARTEL_CAR_A_AS1 = create_car #SENTINEL at $CARTEL_A_X $CARTEL_A_Y 34.0 
			0175: set_car $CARTEL_CAR_A_AS1 z_angle_to 270.0 
			03ED: set_car $CARTEL_CAR_A_AS1 not_damaged_when_upside_down 1 
			0129: $CARTEL1_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_A_AS1 driverseat 
			01C8: $CARTEL2_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_A_AS1 passenger_seat 0 
			01C8: $CARTEL3_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_A_AS1 passenger_seat 1 
			01C8: $CARTEL4_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_A_AS1 passenger_seat 2 
			00A9: car_set_idle $CARTEL_CAR_A_AS1 
			0004: $FLAG_CARTEL_A_CREATED = 1 
		end
	end

	//-----------------------------------CARTEL DEATH SQUAD 1 ATTACK-----------------------------------------
	if
		0038:   $FLAG_CARTEL_A_CREATED == 1 
	then
		0084: $FLAG_ATTACK_TEMP = $FLAG_A_ATTACK
		0086: $CARTEL_TEMP_X = $CARTEL_A_X
		0086: $CARTEL_TEMP_Y = $CARTEL_A_Y
		0086: $CARTEL_CAR_TEMP_AS1_X = $CARTEL_CAR_A_AS1_X
		0086: $CARTEL_CAR_TEMP_AS1_Y = $CARTEL_CAR_A_AS1_Y
		0084: $CARTEL_CAR_TEMP_AS1 = $CARTEL_CAR_A_AS1
		0084: $BLIP_CARTELCAR_TEMP = $BLIP_CARTELCAR_A
		0084: $FLAG_BAILOUT_TEMP = $FLAG_BAILOUT_A
		0084: $PASSENGER_1_TEMP = $CARTEL1_AS1
		0004: $PASSENGER_1_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_2_TEMP = $CARTEL2_AS1
		0004: $PASSENGER_2_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_3_TEMP = $CARTEL3_AS1
		0004: $PASSENGER_3_TEMP_WEAPON = WEAPONTYPE_SHOTGUN
		0084: $PASSENGER_4_TEMP = $CARTEL4_AS1
		0004: $PASSENGER_4_TEMP_WEAPON = WEAPONTYPE_SHOTGUN
		0084: $TARGET_1_TEMP = $YAKUZA1_AS1
		0084: $BLIP_CARTEL_TEMP_AS1 = $BLIP_CARTEL_A_AS1
		0005: $ATTACK_TRIGGER_RADIUS_AS1 = 30.0
		0004: $USE_CHECK_NR = 1

		gosub @CARTEL_DEATH_SQUAD_ATTACK

		0084: $FLAG_A_ATTACK = $FLAG_ATTACK_TEMP
		0086: $CARTEL_CAR_A_AS1_X = $CARTEL_CAR_TEMP_AS1_X
		0086: $CARTEL_CAR_A_AS1_Y = $CARTEL_CAR_TEMP_AS1_Y
		0084: $BLIP_CARTELCAR_A = $BLIP_CARTELCAR_TEMP
		0084: $FLAG_BAILOUT_A = $FLAG_BAILOUT_TEMP
		0084: $BLIP_CARTEL1 = $BLIP_PASSENGER_1_TEMP
		0084: $BLIP_CARTEL2 = $BLIP_PASSENGER_2_TEMP
		0084: $BLIP_CARTEL3 = $BLIP_PASSENGER_3_TEMP
		0084: $BLIP_CARTEL4 = $BLIP_PASSENGER_4_TEMP
	end

	//--------------------------------CARTEL DEATH SQUAD 2 GENERATOR-----------------------------------------
	if
		0038:   $FLAG_CARTEL_B_CREATED == 0 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'BIG_DAM'  // Cochrane Dam
		then
			00A5: $CARTEL_CAR_B_AS1 = create_car #SENTINEL at $CARTEL_B_X $CARTEL_B_Y 74.1875 
			0175: set_car $CARTEL_CAR_B_AS1 z_angle_to 180.0 
			03ED: set_car $CARTEL_CAR_B_AS1 not_damaged_when_upside_down 1 
			0129: $CARTEL5_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_B_AS1 driverseat 
			01C8: $CARTEL6_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_B_AS1 passenger_seat 0 
			01C8: $CARTEL7_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_B_AS1 passenger_seat 1 
			01C8: $CARTEL8_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_B_AS1 passenger_seat 2 
			00A9: car_set_idle $CARTEL_CAR_B_AS1 
			0004: $FLAG_CARTEL_B_CREATED = 1 
		end
	end

	//-----------------------------------CARTEL DEATH SQUAD 2 ATTACK-----------------------------------------
	if
		0038:   $FLAG_CARTEL_B_CREATED == 1 
	then
		0084: $FLAG_ATTACK_TEMP = $FLAG_B_ATTACK
		0086: $CARTEL_TEMP_X = $CARTEL_B_X
		0086: $CARTEL_TEMP_Y = $CARTEL_B_Y
		0086: $CARTEL_CAR_TEMP_AS1_X = $CARTEL_CAR_B_AS1_X
		0086: $CARTEL_CAR_TEMP_AS1_Y = $CARTEL_CAR_B_AS1_Y
		0084: $CARTEL_CAR_TEMP_AS1 = $CARTEL_CAR_B_AS1
		0084: $BLIP_CARTELCAR_TEMP = $BLIP_CARTELCAR_B
		0084: $FLAG_BAILOUT_TEMP = $FLAG_BAILOUT_B
		0084: $PASSENGER_1_TEMP = $CARTEL5_AS1
		0004: $PASSENGER_1_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_2_TEMP = $CARTEL6_AS1
		0004: $PASSENGER_2_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_3_TEMP = $CARTEL7_AS1
		0004: $PASSENGER_3_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_4_TEMP = $CARTEL8_AS1
		0004: $PASSENGER_4_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $TARGET_1_TEMP = $YAKUZA4_AS1
		0084: $BLIP_CARTEL_TEMP_AS1 = $BLIP_CARTEL_B_AS1
		0005: $ATTACK_TRIGGER_RADIUS_AS1 = 30.0
		0004: $USE_CHECK_NR = 1

		gosub @CARTEL_DEATH_SQUAD_ATTACK

		0084: $FLAG_B_ATTACK = $FLAG_ATTACK_TEMP
		0086: $CARTEL_CAR_B_AS1_X = $CARTEL_CAR_TEMP_AS1_X
		0086: $CARTEL_CAR_B_AS1_Y = $CARTEL_CAR_TEMP_AS1_Y
		0084: $BLIP_CARTELCAR_B = $BLIP_CARTELCAR_TEMP
		0084: $FLAG_BAILOUT_B = $FLAG_BAILOUT_TEMP
		0084: $BLIP_CARTEL5 = $BLIP_PASSENGER_1_TEMP
		0084: $BLIP_CARTEL6 = $BLIP_PASSENGER_2_TEMP
		0084: $BLIP_CARTEL7 = $BLIP_PASSENGER_3_TEMP
		0084: $BLIP_CARTEL8 = $BLIP_PASSENGER_4_TEMP
	end

	//--------------------------------CARTEL DEATH SQUAD 3 GENERATOR-----------------------------------------
	if
		0038:   $FLAG_CARTEL_C_CREATED == 0 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'AIRPORT'  // Francis Intl. Airport
		then
			00A5: $CARTEL_CAR_C_AS1 = create_car #SENTINEL at $CARTEL_C_X $CARTEL_C_Y 9.0
			0175: set_car $CARTEL_CAR_C_AS1 z_angle_to 55.0 
			03ED: set_car $CARTEL_CAR_C_AS1 not_damaged_when_upside_down 1 
			0129: $CARTEL9_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_C_AS1 driverseat 
			01C8: $CARTEL10_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_C_AS1 passenger_seat 0 
			01C8: $CARTEL11_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_C_AS1 passenger_seat 1 
			01C8: $CARTEL12_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_C_AS1 passenger_seat 2 
			00A9: car_set_idle $CARTEL_CAR_C_AS1 
			0004: $FLAG_CARTEL_C_CREATED = 1 
		end
	end

	//-----------------------------------CARTEL DEATH SQUAD 3 ATTACK-----------------------------------------
	if
		0038:   $FLAG_CARTEL_C_CREATED == 1 
	then
		0084: $FLAG_ATTACK_TEMP = $FLAG_C_ATTACK
		0086: $CARTEL_TEMP_X = $CARTEL_C_X
		0086: $CARTEL_TEMP_Y = $CARTEL_C_Y
		0086: $CARTEL_CAR_TEMP_AS1_X = $CARTEL_CAR_C_AS1_X
		0086: $CARTEL_CAR_TEMP_AS1_Y = $CARTEL_CAR_C_AS1_Y
		0084: $CARTEL_CAR_TEMP_AS1 = $CARTEL_CAR_C_AS1
		0084: $BLIP_CARTELCAR_TEMP = $BLIP_CARTELCAR_C
		0084: $FLAG_BAILOUT_TEMP = $FLAG_BAILOUT_C
		0084: $PASSENGER_1_TEMP = $CARTEL9_AS1
		0004: $PASSENGER_1_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_2_TEMP = $CARTEL10_AS1
		0004: $PASSENGER_2_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_3_TEMP = $CARTEL11_AS1
		0004: $PASSENGER_3_TEMP_WEAPON = WEAPONTYPE_SHOTGUN
		0084: $PASSENGER_4_TEMP = $CARTEL12_AS1
		0004: $PASSENGER_4_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $TARGET_1_TEMP = $YAKUZA1_AS1
		0084: $BLIP_CARTEL_TEMP_AS1 = $BLIP_CARTEL_C_AS1
		0005: $ATTACK_TRIGGER_RADIUS_AS1 = 30.0
		0004: $USE_CHECK_NR = 1

		gosub @CARTEL_DEATH_SQUAD_ATTACK

		0084: $FLAG_C_ATTACK = $FLAG_ATTACK_TEMP
		0086: $CARTEL_CAR_C_AS1_X = $CARTEL_CAR_TEMP_AS1_X
		0086: $CARTEL_CAR_C_AS1_Y = $CARTEL_CAR_TEMP_AS1_Y
		0084: $BLIP_CARTELCAR_C = $BLIP_CARTELCAR_TEMP
		0084: $FLAG_BAILOUT_C = $FLAG_BAILOUT_TEMP
		0084: $BLIP_CARTEL9 = $BLIP_PASSENGER_1_TEMP
		0084: $BLIP_CARTEL10 = $BLIP_PASSENGER_2_TEMP
		0084: $BLIP_CARTEL11 = $BLIP_PASSENGER_3_TEMP
		0084: $BLIP_CARTEL12 = $BLIP_PASSENGER_4_TEMP
	end

	//--------------------------------CARTEL DEATH SQUAD 4 GENERATOR-----------------------------------------
	if
		0038:   $FLAG_CARTEL_D_CREATED == 0 
	then
		if
			00F5:   player $PLAYER_CHAR 0 $CARTEL_D_X $CARTEL_D_Y 70.0 radius 70.0 70.0 20.0 
		then
			00A5: $CARTEL_CAR_D_AS1 = create_car #SENTINEL at $CARTEL_D_X $CARTEL_D_Y 70.0 
			0175: set_car $CARTEL_CAR_D_AS1 z_angle_to 180.0 
			03ED: set_car $CARTEL_CAR_D_AS1 not_damaged_when_upside_down 1 
			0129: $CARTEL13_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_D_AS1 driverseat 
			01C8: $CARTEL14_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_D_AS1 passenger_seat 0 
			01C8: $CARTEL15_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $CARTEL_CAR_D_AS1 passenger_seat 1 
			01C8: $CARTEL16_AS1 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $CARTEL_CAR_D_AS1 passenger_seat 2 
			00A9: car_set_idle $CARTEL_CAR_D_AS1 
			0004: $FLAG_CARTEL_D_CREATED = 1 
		end
	end

	//-----------------------------------CARTEL DEATH SQUAD 4 ATTACK-----------------------------------------
	if
		0038:   $FLAG_CARTEL_D_CREATED == 1 
	then
		0084: $FLAG_ATTACK_TEMP = $FLAG_D_ATTACK
		0086: $CARTEL_TEMP_X = $CARTEL_D_X
		0086: $CARTEL_TEMP_Y = $CARTEL_D_Y
		0086: $CARTEL_CAR_TEMP_AS1_X = $CARTEL_CAR_D_AS1_X
		0086: $CARTEL_CAR_TEMP_AS1_Y = $CARTEL_CAR_D_AS1_Y
		0084: $CARTEL_CAR_TEMP_AS1 = $CARTEL_CAR_D_AS1
		0084: $BLIP_CARTELCAR_TEMP = $BLIP_CARTELCAR_D
		0084: $FLAG_BAILOUT_TEMP = $FLAG_BAILOUT_D
		0084: $PASSENGER_1_TEMP = $CARTEL13_AS1
		0004: $PASSENGER_1_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_2_TEMP = $CARTEL14_AS1
		0004: $PASSENGER_2_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $PASSENGER_3_TEMP = $CARTEL15_AS1
		0004: $PASSENGER_3_TEMP_WEAPON = WEAPONTYPE_SHOTGUN
		0084: $PASSENGER_4_TEMP = $CARTEL16_AS1
		0004: $PASSENGER_4_TEMP_WEAPON = WEAPONTYPE_M16
		0084: $TARGET_1_TEMP = $YAKUZA4_AS1
		0084: $BLIP_CARTEL_TEMP_AS1 = $BLIP_CARTEL_D_AS1
		0005: $ATTACK_TRIGGER_RADIUS_AS1 = 30.0
		0004: $USE_CHECK_NR = 2

		gosub @CARTEL_DEATH_SQUAD_ATTACK

		0084: $FLAG_D_ATTACK = $FLAG_ATTACK_TEMP
		0086: $CARTEL_CAR_D_AS1_X = $CARTEL_CAR_TEMP_AS1_X
		0086: $CARTEL_CAR_D_AS1_Y = $CARTEL_CAR_TEMP_AS1_Y
		0084: $BLIP_CARTELCAR_D = $BLIP_CARTELCAR_TEMP
		0084: $FLAG_BAILOUT_D = $FLAG_BAILOUT_TEMP
		0084: $BLIP_CARTEL13 = $BLIP_PASSENGER_1_TEMP
		0084: $BLIP_CARTEL14 = $BLIP_PASSENGER_2_TEMP
		0084: $BLIP_CARTEL15 = $BLIP_PASSENGER_3_TEMP
		0084: $BLIP_CARTEL16 = $BLIP_PASSENGER_4_TEMP
	end

	0004: $FLAG_PARTICLE = 0

end //while

goto @MISSION_PASSED_AS1


/////////////////////////////////////////

:YAKUZA_KILLZONE_GENERATION
if
	0038:   $FLAG_YAKUZA_CREATED_AS1 == 0 
then
	if or
		0121:   player $PLAYER_CHAR in_zone 'SUB_IND'  // Pike Creek
		0121:   player $PLAYER_CHAR in_zone 'BIG_DAM'  // Cochrane Dam
	then
		if
			03C6:   current_island == LEVEL_SUBURBAN 
		then
			if
				0038:   $FLAG_YAK1_DEAD == 0 
			then
				009A: $YAKUZA1_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at $YAK1_X $YAK1_Y 70.0 
				0173: set_actor $YAKUZA1_AS1 z_angle_to 130.0 
				01ED: clear_actor $YAKUZA1_AS1 threat_search 
				011A: set_actor $YAKUZA1_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA1_AS1 search_threat THREAT_COP 
				01B2: give_actor $YAKUZA1_AS1 weapon WEAPONTYPE_CHAINGUN ammo 999 
				0350: set_actor $YAKUZA1_AS1 maintain_position_when_attacked 1 
			end
			if
				0038:   $FLAG_YAK2_DEAD == 0 
			then
				009A: $YAKUZA2_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at $YAK2_X $YAK2_Y 72.0 
				0173: set_actor $YAKUZA2_AS1 z_angle_to 45.0 
				01ED: clear_actor $YAKUZA2_AS1 threat_search 
				011A: set_actor $YAKUZA2_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA2_AS1 search_threat THREAT_COP 
				01B2: give_actor $YAKUZA2_AS1 weapon WEAPONTYPE_SHOTGUN ammo 999 
				0350: set_actor $YAKUZA2_AS1 maintain_position_when_attacked 1 
			end
			if
				0038:   $FLAG_YAK3_DEAD == 0 
			then
				009A: $YAKUZA3_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at $YAK3_X $YAK3_Y 72.0 
				0173: set_actor $YAKUZA3_AS1 z_angle_to 295.0 
				01ED: clear_actor $YAKUZA3_AS1 threat_search 
				011A: set_actor $YAKUZA3_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA3_AS1 search_threat THREAT_COP 
				01B2: give_actor $YAKUZA3_AS1 weapon WEAPONTYPE_CHAINGUN ammo 999 
				0350: set_actor $YAKUZA3_AS1 maintain_position_when_attacked 1 
			end
			if
				0038:   $FLAG_YAK4_DEAD == 0 
			then
				009A: $YAKUZA4_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at $YAK4_X $YAK4_Y 72.0 
				0173: set_actor $YAKUZA4_AS1 z_angle_to 130.0 
				01ED: clear_actor $YAKUZA4_AS1 threat_search 
				011A: set_actor $YAKUZA4_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA4_AS1 search_threat THREAT_COP 
				01B2: give_actor $YAKUZA4_AS1 weapon WEAPONTYPE_CHAINGUN ammo 999 
				0350: set_actor $YAKUZA4_AS1 maintain_position_when_attacked 1 
			end
			if
				0038:   $FLAG_YAK5_DEAD == 0 
			then
				009A: $YAKUZA5_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG07 at $YAK5_X $YAK5_Y 72.4375 
				0173: set_actor $YAKUZA5_AS1 z_angle_to 60.0 
				01ED: clear_actor $YAKUZA5_AS1 threat_search 
				011A: set_actor $YAKUZA5_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA5_AS1 search_threat THREAT_COP_CAR 
				01B2: give_actor $YAKUZA5_AS1 weapon WEAPONTYPE_CHAINGUN ammo 999 
				0350: set_actor $YAKUZA5_AS1 maintain_position_when_attacked 1 
			end
			if
				0038:   $FLAG_YAK6_DEAD == 0 
			then
				009A: $YAKUZA6_AS1 = create_char PEDTYPE_GANG_YAKUZA model #GANG08 at $YAK6_X $YAK6_Y 68.75 
				0173: set_actor $YAKUZA6_AS1 z_angle_to 180.0 
				01ED: clear_actor $YAKUZA6_AS1 threat_search 
				011A: set_actor $YAKUZA6_AS1 search_threat THREAT_GANG_COLOMBIAN 
				011A: set_actor $YAKUZA6_AS1 search_threat THREAT_COP_CAR
				01B2: give_actor $YAKUZA6_AS1 weapon WEAPONTYPE_SHOTGUN ammo 999 
				0350: set_actor $YAKUZA6_AS1 maintain_position_when_attacked 1 
			end
			0004: $FLAG_YAKUZA_CREATED_AS1 = 1 
		end
	end
end

if
	0038:   $FLAG_YAKUZA_CREATED_AS1 == 1 
then
	if
		83C6:   not current_island == LEVEL_SUBURBAN 
	then
		009B: delete_char $YAKUZA1_AS1 
		009B: delete_char $YAKUZA2_AS1 
		009B: delete_char $YAKUZA3_AS1 
		009B: delete_char $YAKUZA4_AS1 
		009B: delete_char $YAKUZA5_AS1 
		009B: delete_char $YAKUZA6_AS1 
		0004: $FLAG_YAKUZA_CREATED_AS1 = 0 
	end
end
return

/////////////////////////////////////////

:CARTEL_DEATH_SQUAD_ATTACK

if
	0038:   $FLAG_ATTACK_TEMP == 0 
then
	if or
		00E3:   player $PLAYER_CHAR 0 $CARTEL_TEMP_X $CARTEL_TEMP_Y radius $ATTACK_TRIGGER_RADIUS_AS1 $ATTACK_TRIGGER_RADIUS_AS1 
		8038:   not $USE_CHECK_NR == 1
	then
		if or
			00F5:   player $PLAYER_CHAR 0 $CARTEL_TEMP_X $CARTEL_TEMP_Y 70.0 radius $ATTACK_TRIGGER_RADIUS_AS1 $ATTACK_TRIGGER_RADIUS_AS1 20.0 
			8038:   not $USE_CHECK_NR == 2
		then
			if
				8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked 
			then
				03AB: set_car $CARTEL_CAR_TEMP_AS1 strong 1 
				020A: set_car $CARTEL_CAR_TEMP_AS1 door_status_to CARLOCK_LOCKED 
				02AA: set_car $CARTEL_CAR_TEMP_AS1 immune_to_nonplayer 1 
				0164: disable_marker $BLIP_CARTEL_TEMP_AS1 
				00AD: set_car_cruise_speed $CARTEL_CAR_TEMP_AS1 to 50.0 
				00AF: set_car_mission $CARTEL_CAR_TEMP_AS1 to MISSION_RAMPLAYER_FARAWAY 
				00AE: set_car_driving_style $CARTEL_CAR_TEMP_AS1 to DRIVINGMODE_AVOIDCARS 
				0186: $BLIP_CARTELCAR_TEMP = create_marker_above_car $CARTEL_CAR_TEMP_AS1 
				03FB: set_car $CARTEL_CAR_TEMP_AS1 stays_on_current_island 0 
				0004: $FLAG_ATTACK_TEMP = 1 
			end
		else
			if
				0119:   car $CARTEL_CAR_TEMP_AS1 wrecked 
			then
				0164: disable_marker $BLIP_CARTEL_TEMP_AS1 
			end
		end
	else
		if
			0119:   car $CARTEL_CAR_TEMP_AS1 wrecked 
		then
			0164: disable_marker $BLIP_CARTEL_TEMP_AS1 
		end
	end
end

if
	8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked 
then
	if and
		0038:   $FLAG_BAILOUT_TEMP == 0 
		0038:   $FLAG_ATTACK_TEMP == 1 
	then
		if
			01AD:   car $CARTEL_CAR_TEMP_AS1 sphere 0 near_point $PLAYER_X $PLAYER_Y radius 40.0 40.0 
		then
			00AD: set_car_cruise_speed $CARTEL_CAR_TEMP_AS1 to 60.0
		else
			00AD: set_car_cruise_speed $CARTEL_CAR_TEMP_AS1 to 30.0
		end

		if
			8185:   not car $CARTEL_CAR_TEMP_AS1 health >= 250 
		then
			gosub @BAILOUT
		end

		if and
			80E0:   not is_player_in_any_car $PLAYER_CHAR 
			0038:   $FLAG_BAILOUT_TEMP == 0 
			8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked
		then
			if
				0038:   $FLAG_WELLYBOB == 0 
			then
				0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z
				if
					01AF:   car $CARTEL_CAR_TEMP_AS1 0 $PLAYER_X $PLAYER_Y $PLAYER_Z radius 10.0 10.0 5.0 
				then
					gosub @BAILOUT
				end
			end
		end

		if 
			8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked 
		then
			if and
				01AF:   car $CARTEL_CAR_TEMP_AS1 0 $KILLZONE_CENT_X $KILLZONE_CENT_Y 70.0 radius 17.0 30.0 3.0 
				0038:   $FLAG_BAILOUT_TEMP == 0 
			then
				02AA: set_car $CARTEL_CAR_TEMP_AS1 immune_to_nonplayer 0 
				gosub @BAILOUT
			end
		end
	end
end
	
if
	0038:   $FLAG_BAILOUT_TEMP == 1 
then
	if
		8118:   not actor $PASSENGER_1_TEMP dead 
	then
		01CC: actor $PASSENGER_1_TEMP kill_player $PLAYER_CHAR 
	end
	if
		8118:   not actor $PASSENGER_2_TEMP dead 
	then
		01CC: actor $PASSENGER_2_TEMP kill_player $PLAYER_CHAR 
	end
	if
		8118:   not actor $PASSENGER_3_TEMP dead 
	then
		01CC: actor $PASSENGER_3_TEMP kill_player $PLAYER_CHAR 
	end
	if
		8118:   not actor $PASSENGER_4_TEMP dead 
	then
		if and
			00ED:   actor $PASSENGER_4_TEMP 0 $KILLZONE_CENT_X $KILLZONE_CENT_Y radius 15.0 15.0 
			8118:   not actor $TARGET_1_TEMP dead
		then
			01CB: actor $PASSENGER_4_TEMP kill_actor $TARGET_1_TEMP 
		else
			01CC: actor $PASSENGER_4_TEMP kill_player $PLAYER_CHAR 
		end
	end
end

if
	8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked 
then
	if and
		0038:   $FLAG_BAILOUT_TEMP == 0 
		0038:   $FLAG_ATTACK_TEMP == 1
	then
		gosub @CARTEL_CAR_STUCK
	end
else
	0164: disable_marker $BLIP_CARTELCAR_TEMP 
end

return

/////////////////////////////////////////

:EVERYONE_HATES_YOU
// Store threat search for all ped types to be able to clear only the only set by this mission afterwards.
// Then, set all ped types to have the player as threat.
// Yakuza and special are not affected by this.
// Columbian and mafia are also not done, because they are always already hostile at this point.
if
	042A:   ped_threat_exists PEDTYPE_CIVMALE THREAT_PLAYER1
then
	0004: $CIVMALE_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_CIVFEMALE THREAT_PLAYER1
then
	0004: $CIVFEMALE_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_COP THREAT_PLAYER1
then
	0004: $COP_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_GANG_TRIAD THREAT_PLAYER1
then
	0004: $TRIAD_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_GANG_DIABLO THREAT_PLAYER1
then
	0004: $DIABLO_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_GANG_YARDIE THREAT_PLAYER1
then
	0004: $YARDIE_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_GANG_HOOD THREAT_PLAYER1
then
	0004: $HOOD_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_BUM THREAT_PLAYER1
then
	0004: $BUM_HOSTILE_OLD = 1
end
if
	042A:   ped_threat_exists PEDTYPE_PROSTITUTE THREAT_PLAYER1
then
	0004: $PROSTITUTE_HOSTILE_OLD = 1
end

03F1: pedtype PEDTYPE_CIVMALE add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_CIVFEMALE add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_COP add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_GANG_DIABLO add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_GANG_YARDIE add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_GANG_HOOD add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_BUM add_threat THREAT_PLAYER1
03F1: pedtype PEDTYPE_PROSTITUTE add_threat THREAT_PLAYER1

0004: $EVERYONE_HOSTILE_FLAG = 1
return

/////////////////////////////////////////

:STOP_THE_HATE

// Clears threat search for ped types that didn't have it before this mission.
if
	8038:   not $CIVMALE_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_CIVMALE remove_threat THREAT_PLAYER1
end
if
	8038:   not $CIVFEMALE_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_CIVFEMALE remove_threat THREAT_PLAYER1
end
if
	8038:   not $COP_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_COP remove_threat THREAT_PLAYER1
end
if
	8038:   not $TRIAD_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_GANG_TRIAD remove_threat THREAT_PLAYER1
end
if
	8038:   not $DIABLO_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_GANG_DIABLO remove_threat THREAT_PLAYER1
end
if
	8038:   not $YARDIE_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_GANG_YARDIE remove_threat THREAT_PLAYER1
end
if
	8038:   not $HOOD_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_GANG_HOOD remove_threat THREAT_PLAYER1
end
if
	8038:   not $BUM_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_BUM remove_threat THREAT_PLAYER1
end
if
	8038:   not $PROSTITUTE_HOSTILE_OLD == 1
then
	03F2: pedgroup PEDTYPE_PROSTITUTE remove_threat THREAT_PLAYER1
end
0004: $EVERYONE_HOSTILE_FLAG = 0
return

/////////////////////////////////////////

:ROAD_BLOCK_AS1
if
	03C6:   current_island == LEVEL_SUBURBAN 
then
	00A5: $ROAD_BLOCK_CAR1_AS1 = create_car #SENTINEL at -303.5 368.0 78.75
	0175: set_car $ROAD_BLOCK_CAR1_AS1 z_angle_to 10.0 
	00A5: $ROAD_BLOCK_CAR2_AS1 = create_car #SENTINEL at -304.75 374.5 79.0
	0175: set_car $ROAD_BLOCK_CAR2_AS1 z_angle_to 10.0 
	00A5: $ROAD_BLOCK_CAR3_AS1 = create_car #SENTINEL at -305.75 380.5 79.25
	0175: set_car $ROAD_BLOCK_CAR3_AS1 z_angle_to 10.0 

	009A: $ROAD_BLOCK_BADDIE1_AS1 = create_char PEDTYPE_GANG_TRIAD model #GANG07 at -306.75 370.25 79.25
	0173: set_actor $ROAD_BLOCK_BADDIE1_AS1 z_angle_to 275.0
	01B2: give_actor $ROAD_BLOCK_BADDIE1_AS1 weapon WEAPONTYPE_M16 ammo 500 
	035F: set_actor $ROAD_BLOCK_BADDIE1_AS1 armour_to 100 
	02A9: set_char_only_damaged_by_player $ROAD_BLOCK_BADDIE1_AS1 to 1
	0350: set_actor $ROAD_BLOCK_BADDIE1_AS1 maintain_position_when_attacked 1 
	01ED: clear_actor $ROAD_BLOCK_BADDIE1_AS1 threat_search 
	011A: set_actor $ROAD_BLOCK_BADDIE1_AS1 search_threat THREAT_PLAYER1 

	009A: $ROAD_BLOCK_BADDIE2_AS1 = create_char PEDTYPE_GANG_TRIAD model #GANG08 at -307.25 362.5 79.5
	0173: set_actor $ROAD_BLOCK_BADDIE1_AS1 z_angle_to 290.0
	01B2: give_actor $ROAD_BLOCK_BADDIE2_AS1 weapon WEAPONTYPE_M16 ammo 500 
	035F: set_actor $ROAD_BLOCK_BADDIE1_AS1 armour_to 100 
	02A9: set_char_only_damaged_by_player $ROAD_BLOCK_BADDIE2_AS1 to 1
	0350: set_actor $ROAD_BLOCK_BADDIE2_AS1 maintain_position_when_attacked 1 
	01ED: clear_actor $ROAD_BLOCK_BADDIE2_AS1 threat_search 
	011A: set_actor $ROAD_BLOCK_BADDIE2_AS1 search_threat THREAT_PLAYER1

	0004: $ROAD_BLOCK_CREATED_AS1 = 1
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_AS1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
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
goto @MISSION_END_AS1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_AS1
0004: $BAIT_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 35000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 35000 
0318: set_latest_mission_passed 'AS1'  // 'BAIT'
030C: set_mission_points += 1 
004F: create_thread @ASUKA_SUBURBAN_MISSION2_LOOP

goto @MISSION_END_AS1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_AS1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA2 = 0 
gosub @STOP_THE_HATE
0151: remove_status_text $COUNTER_CARTELS_KILLED_AS1 
0164: disable_marker $BLIP_CARTEL1 
0164: disable_marker $BLIP_CARTEL2 
0164: disable_marker $BLIP_CARTEL3 
0164: disable_marker $BLIP_CARTEL4 
0164: disable_marker $BLIP_CARTEL5 
0164: disable_marker $BLIP_CARTEL6 
0164: disable_marker $BLIP_CARTEL7 
0164: disable_marker $BLIP_CARTEL8 
0164: disable_marker $BLIP_CARTEL13 
0164: disable_marker $BLIP_CARTEL14 
0164: disable_marker $BLIP_CARTEL15 
0164: disable_marker $BLIP_CARTEL16 
0164: disable_marker $BLIP_CARTEL_A_AS1 
0164: disable_marker $BLIP_CARTEL_B_AS1 
0164: disable_marker $BLIP_CARTEL_D_AS1 
0164: disable_marker $BLIP_KILLZONE 
0164: disable_marker $BLIP_CARTELCAR_A 
0164: disable_marker $BLIP_CARTELCAR_B 
0164: disable_marker $BLIP_CARTELCAR_D 
01C3: remove_references_to_car $CARTEL_CAR_A_AS1 
01C3: remove_references_to_car $CARTEL_CAR_B_AS1 
01C3: remove_references_to_car $CARTEL_CAR_D_AS1 
if
	0038:   $FLAG_YAK1_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA1_AS1
end
if
	0038:   $FLAG_YAK2_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA2_AS1
end
if
	0038:   $FLAG_YAK3_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA3_AS1
end
if
	0038:   $FLAG_YAK4_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA4_AS1
end
if
	0038:   $FLAG_YAK5_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA5_AS1
end
if
	0038:   $FLAG_YAK6_DEAD == 0 
then
	01C2: remove_references_to_actor $YAKUZA6_AS1
end
0249: release_model #GANG07 
0249: release_model #GANG08 
0249: release_model #GANG11 
0249: release_model #GANG12 
0249: release_model #SENTINEL 
00D8: mission_has_finished 
return

////////////////////////////////////////

///________________________________GOSUBS_______GOSUBS________________________________BYTHEWAY


//-----------------------------------------CHECK FOR YAK DEATHS-------------------------------

:YAK_DEATHS
if
	0038:   $FLAG_YAKUZA_CREATED_AS1 == 1
then
	if and
		0118:   actor $YAKUZA1_AS1 dead 
		0038:   $FLAG_YAK1_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK1_DEAD = 1 
	end
	if and
		0118:   actor $YAKUZA2_AS1 dead 
		0038:   $FLAG_YAK2_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK2_DEAD = 1 
	end
	if and
		0118:   actor $YAKUZA3_AS1 dead 
		0038:   $FLAG_YAK3_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK3_DEAD = 1 
	end
	if and
		0118:   actor $YAKUZA4_AS1 dead 
		0038:   $FLAG_YAK4_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK4_DEAD = 1 
	end
	if and
		0118:   actor $YAKUZA5_AS1 dead 
		0038:   $FLAG_YAK5_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK5_DEAD = 1 
	end
	if and
		0118:   actor $YAKUZA6_AS1 dead 
		0038:   $FLAG_YAK6_DEAD == 0 
	then
		0008: $COUNTER_YAKUZA_KILLED_AS1 += 1 
		0004: $FLAG_YAK6_DEAD = 1 
	end

	0298: $YAKS_A_KILLED_BY_PLAYER = rampage_kills #GANG07 
	0298: $YAKS_B_KILLED_BY_PLAYER = rampage_kills #GANG08 
	0084: $YAKS_KILLED_BY_PLAYER = $YAKS_A_KILLED_BY_PLAYER 
	0058: $YAKS_KILLED_BY_PLAYER += $YAKS_B_KILLED_BY_PLAYER

	if
		0018:   $YAKS_KILLED_BY_PLAYER > 0 
	then
		if
			8118:   not actor $YAKUZA1_AS1 dead
		then
			011A: set_actor $YAKUZA1_AS1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $YAKUZA2_AS1 dead
		then
			011A: set_actor $YAKUZA2_AS1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $YAKUZA3_AS1 dead
		then
			011A: set_actor $YAKUZA3_AS1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $YAKUZA4_AS1 dead
		then
			011A: set_actor $YAKUZA4_AS1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $YAKUZA5_AS1 dead
		then
			011A: set_actor $YAKUZA5_AS1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $YAKUZA6_AS1 dead
		then
			011A: set_actor $YAKUZA6_AS1 search_threat THREAT_PLAYER1
		end
	end
end
return

////////////////////////////////////////

//-----------------------------------------------------'BAILOUTS'----------------

:BAILOUT
if
	0038:   $FLAG_BAILOUT_TEMP == 0 
then
	0004: $FLAG_BAILOUT_TEMP = 1 
	0008: $COUNTER_BAILOUTS += 1 
	0164: disable_marker $BLIP_CARTELCAR_TEMP 
	020A: set_car $CARTEL_CAR_TEMP_AS1 door_status_to CARLOCK_UNLOCKED

	0084: $PASSENGER_CURRENT = $PASSENGER_1_TEMP
	0084: $PASSENGER_CURRENT_WEAPON = $PASSENGER_1_TEMP_WEAPON
	gosub @GET_PASSENGER_OUT_CAR
	0084: $BLIP_PASSENGER_1_TEMP = $BLIP_PASSENGER_CURRENT

	0084: $PASSENGER_CURRENT = $PASSENGER_2_TEMP
	0084: $PASSENGER_CURRENT_WEAPON = $PASSENGER_2_TEMP_WEAPON
	gosub @GET_PASSENGER_OUT_CAR
	0084: $BLIP_PASSENGER_2_TEMP = $BLIP_PASSENGER_CURRENT

	0084: $PASSENGER_CURRENT = $PASSENGER_3_TEMP
	0084: $PASSENGER_CURRENT_WEAPON = $PASSENGER_3_TEMP_WEAPON
	gosub @GET_PASSENGER_OUT_CAR
	0084: $BLIP_PASSENGER_3_TEMP = $BLIP_PASSENGER_CURRENT

	0084: $PASSENGER_CURRENT = $PASSENGER_4_TEMP
	0084: $PASSENGER_CURRENT_WEAPON = $PASSENGER_4_TEMP_WEAPON
	gosub @GET_PASSENGER_OUT_CAR
	0084: $BLIP_PASSENGER_4_TEMP = $BLIP_PASSENGER_CURRENT
end
return

////////////////////////////////////////

:GET_PASSENGER_OUT_CAR
if and
	8118:   not actor $PASSENGER_CURRENT dead 
	8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked
then
	01D3: actor $PASSENGER_CURRENT leave_car $CARTEL_CAR_TEMP_AS1 
	while 00DB:   is_char_in_car $PASSENGER_CURRENT car $CARTEL_CAR_TEMP_AS1
		wait 0 ms
		if or
			0118:   actor $PASSENGER_CURRENT dead
			0119:   car $CARTEL_CAR_TEMP_AS1 wrecked 
		then
			return
		end
	end //while
	011A: set_actor $PASSENGER_CURRENT search_threat THREAT_PLAYER1 
	01B2: give_actor $PASSENGER_CURRENT weapon $PASSENGER_CURRENT_WEAPON ammo 100 
	035F: set_actor $PASSENGER_CURRENT armour_to 100 
	0187: $BLIP_PASSENGER_CURRENT = create_marker_above_actor $PASSENGER_CURRENT 
end
return

////////////////////////////////////////

//-----------------------------------------------CARTEL DEATHS-----------------------------

:CARTEL_DEATHS
if
	0038:   $FLAG_CARTEL_A_CREATED == 1 
then
	if and
		0038:   $CARTEL1_AS1_DEAD == 0 
		0118:   actor $CARTEL1_AS1 dead 
	then
		0004: $CARTEL1_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL1 
	end
	if and
		0038:   $CARTEL2_AS1_DEAD == 0 
		0118:   actor $CARTEL2_AS1 dead 
	then
		0004: $CARTEL2_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL2 
	end
	if and
		0038:   $CARTEL3_AS1_DEAD == 0 
		0118:   actor $CARTEL3_AS1 dead 
	then
		0004: $CARTEL3_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL3 
	end
	if and
		0038:   $CARTEL4_AS1_DEAD == 0 
		0118:   actor $CARTEL4_AS1 dead 
	then
		0004: $CARTEL4_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL4 
	end
	if and
		0038:   $CARTEL1_AS1_DEAD == 1 
		0038:   $CARTEL2_AS1_DEAD == 1
		0038:   $CARTEL3_AS1_DEAD == 1 
		0038:   $CARTEL4_AS1_DEAD == 1 
		0038:   $FLAG_BAILOUT_A == 0
	then
		0008: $COUNTER_BAILOUTS += 1 
		0004: $FLAG_BAILOUT_A = 1 
	end
end
if
	0038:   $FLAG_CARTEL_B_CREATED == 1 
then
	if and
		0038:   $CARTEL5_AS1_DEAD == 0 
		0118:   actor $CARTEL5_AS1 dead 
	then
		0004: $CARTEL5_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL5 
	end
	if and
		0038:   $CARTEL6_AS1_DEAD == 0 
		0118:   actor $CARTEL6_AS1 dead 
	then
		0004: $CARTEL6_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL6 
	end
	if and
		0038:   $CARTEL7_AS1_DEAD == 0 
		0118:   actor $CARTEL7_AS1 dead 
	then
		0004: $CARTEL7_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL7 
	end
	if and
		0038:   $CARTEL8_AS1_DEAD == 0 
		0118:   actor $CARTEL8_AS1 dead 
	then
		0004: $CARTEL8_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL8 
	end
	if and
		0038:   $CARTEL5_AS1_DEAD == 1 
		0038:   $CARTEL6_AS1_DEAD == 1
		0038:   $CARTEL7_AS1_DEAD == 1 
		0038:   $CARTEL8_AS1_DEAD == 1 
		0038:   $FLAG_BAILOUT_B == 0
	then
		0008: $COUNTER_BAILOUTS += 1 
		0004: $FLAG_BAILOUT_B = 1 
	end
end
if
	0038:   $FLAG_CARTEL_C_CREATED == 1 
then
	if and
		0038:   $CARTEL9_AS1_DEAD == 0 
		0118:   actor $CARTEL9_AS1 dead 
	then
		0004: $CARTEL9_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL9 
	end
	if and
		0038:   $CARTEL10_AS1_DEAD == 0 
		0118:   actor $CARTEL10_AS1 dead 
	then
		0004: $CARTEL10_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL10 
	end
	if and
		0038:   $CARTEL11_AS1_DEAD == 0 
		0118:   actor $CARTEL11_AS1 dead 
	then
		0004: $CARTEL11_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL11 
	end
	if and
		0038:   $CARTEL12_AS1_DEAD == 0 
		0118:   actor $CARTEL12_AS1 dead 
	then
		0004: $CARTEL12_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL12 
	end
	if and
		0038:   $CARTEL9_AS1_DEAD == 1 
		0038:   $CARTEL10_AS1_DEAD == 1
		0038:   $CARTEL11_AS1_DEAD == 1 
		0038:   $CARTEL12_AS1_DEAD == 1 
		0038:   $FLAG_BAILOUT_C == 0
	then
		0008: $COUNTER_BAILOUTS += 1 
		0004: $FLAG_BAILOUT_C = 1 
	end
end
if
	0038:   $FLAG_CARTEL_D_CREATED == 1 
then
	if and
		0038:   $CARTEL13_AS1_DEAD == 0 
		0118:   actor $CARTEL13_AS1 dead 
	then
		0004: $CARTEL13_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL13 
	end
	if and
		0038:   $CARTEL14_AS1_DEAD == 0 
		0118:   actor $CARTEL14_AS1 dead 
	then
		0004: $CARTEL14_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL14 
	end
	if and
		0038:   $CARTEL15_AS1_DEAD == 0 
		0118:   actor $CARTEL15_AS1 dead 
	then
		0004: $CARTEL15_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL15 
	end
	if and
		0038:   $CARTEL16_AS1_DEAD == 0 
		0118:   actor $CARTEL16_AS1 dead 
	then
		0004: $CARTEL16_AS1_DEAD = 1 
		0008: $COUNTER_CARTELS_KILLED_AS1 += 1 
		0164: disable_marker $BLIP_CARTEL16 
	end
	if and
		0038:   $CARTEL13_AS1_DEAD == 1 
		0038:   $CARTEL14_AS1_DEAD == 1
		0038:   $CARTEL15_AS1_DEAD == 1 
		0038:   $CARTEL16_AS1_DEAD == 1 
		0038:   $FLAG_BAILOUT_D == 0
	then
		0008: $COUNTER_BAILOUTS += 1 
		0004: $FLAG_BAILOUT_D = 1 
	end
end
return

//------------------------------------STUCK CAR ROUTINES-------------------------------------

:CARTEL_CAR_STUCK
if
	8119:   not car $CARTEL_CAR_TEMP_AS1 wrecked 
then
	if and
		01F4:   car $CARTEL_CAR_TEMP_AS1 flipped 
		01C1:   car $CARTEL_CAR_TEMP_AS1 stopped 
	then
		if
			82CA:   not is_car_on_screen $CARTEL_CAR_TEMP_AS1 
		then
			gosub @RESPAWN_CARTEL_CAR
		else
			gosub @BAILOUT
		end
	end
	if
		02BF:   car $CARTEL_CAR_TEMP_AS1 sunk 
	then
		if
			82CA:   not is_car_on_screen $CARTEL_CAR_TEMP_AS1 
		then
			gosub @RESPAWN_CARTEL_CAR
		else
			0004: $FLAG_BAILOUT_TEMP = 1 
			0008: $COUNTER_BAILOUTS += 1 
			0164: disable_marker $BLIP_CARTELCAR_TEMP 
			039C: set_car $CARTEL_CAR_TEMP_AS1 watertight 0 
			0050: gosub @CARTEL_DEATHS 
		end
	end

	if
		0038:   $FLAG_PARTICLE == 1 
	then
		0086: $CAR_TEMP_X_OLD = $CARTEL_CAR_TEMP_AS1_X 
		0086: $CAR_TEMP_Y_OLD = $CARTEL_CAR_TEMP_AS1_Y 
		00AA: get_car_coordinates $CARTEL_CAR_TEMP_AS1 store_to $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z
		if
			01AD:   car $CARTEL_CAR_TEMP_AS1 sphere 0 near_point $CAR_TEMP_X_OLD $CAR_TEMP_Y_OLD radius 3.0 3.0 
		then
			gosub @RESPAWN_CARTEL_CAR
		end
	end
else
	0164: disable_marker $BLIP_CARTELCAR_TEMP 
end
return

////////////////////////////////////////

:RESPAWN_CARTEL_CAR
00AA: get_car_coordinates $CARTEL_CAR_TEMP_AS1 store_to $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z 
03D3: get_closest_car_node_at $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z store_to $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z heading $CARTEL_HEADING 
if
	80C2:   not is_point_on_screen $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z 3.0
then
	00AB: set_car_coordinates $CARTEL_CAR_TEMP_AS1 to $CARTEL_CAR_TEMP_AS1_X $CARTEL_CAR_TEMP_AS1_Y $CARTEL_CAR_TEMP_AS1_Z 
	0175: set_car $CARTEL_CAR_TEMP_AS1 z_angle_to $CARTEL_HEADING 
	0450: car $CARTEL_CAR_TEMP_AS1 warp_to_player
end
return
