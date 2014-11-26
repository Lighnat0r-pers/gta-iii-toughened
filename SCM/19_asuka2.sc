// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************************Asuka mission 2********************************** 
// **************************************Sniper Surveillance********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M19_UNDERSURVEILLANCE

gosub @MISSION_START_ASUKA2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_ASUKA2
end

:MISSION_END_ASUKA2
gosub @MISSION_CLEANUP_ASUKA2
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_ASUKA2

0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA2 = 1 
03A4: name_thread 'ASUKA2' 
0001: wait 0 ms 
0004: $NUMBER_OF_FEDS_KILLED = 0 
0004: $BEEN_DAMAGED_BEFORE = 0 
0004: $FBI_SPOTTED_PLAYER = 0 
0004: $FBI_SPOTTED_PLAYER2 = 0 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'ASUKAH' 
02F3: load_object #CUTOBJ03 'KENJIH' 
023C: load_special_actor 'ASUKA' as 1 
023C: load_special_actor 'KENJI' as 2 
0247: request_model #CONDO_IVY 
0247: request_model #KMRICNDO01 
038B: load_all_models_now 


while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CONDO_IVY available 
		8248:   not model #KMRICNDO01 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A3_SS' 
0244: set_cutscene_pos 523.0625 -636.9375 15.5625 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CUTSCENE_KENJI = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_KENJI 'KENJI' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
02F4: create_cutscene_actor $KENJI_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_KENJI 
02F5: set_head_anim $KENJI_CSHEAD 'KENJI' 
0395: clear_area 1 at 523.5625 -639.375 range 16.5625 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 523.5625 -639.375 16.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   1892 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_A' duration 10000 ms flag 1  // Salvatore's death comes as pleasurable news,
while 001A:   4983 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_A2' duration 10000 ms flag 1  // you are an efficient killer. I like that in a man.
while 001A:   8705 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_B' duration 10000 ms flag 1  // This is my brother Kenji.
while 001A:   10494 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_C' duration 10000 ms flag 1  // Asuka has a little job for you, but when you're done, drop by my casino and we can talk.
while 001A:   16940 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_D' duration 10000 ms flag 1  // Just like Kenji, always trying to play with my toys.
while 001A:   22566 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_E' duration 10000 ms flag 1  // My police source indicates that the Mafia are watching our interests around the city
while 001A:   26394 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_E2' duration 10000 ms flag 1  // in a bid to track you down.
while 001A:   28456 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_F' duration 10000 ms flag 1  // We cannot continue our operations until they are dealt with.
while 001A:   32144 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM2_G' duration 10000 ms flag 1  // Take out these spying fools and end this vendetta once and for all.
while 001A:   36663 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   39000 > $CUT_SCENE_TIME
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
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CONDO_IVY 
0249: release_model #KMRICNDO01 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0247: request_model #GANG01 
0247: request_model #GANG02 
0247: request_model #RUMPO 


while true
	if or
		8248:   not model #GANG01 available 
		8248:   not model #GANG02 available 
		8248:   not model #RUMPO available 
	jf break
	wait 0 ms
end //while

0004: $FED1_ALREADY_DEAD = 0 
0004: $FED2_ALREADY_DEAD = 0 
0004: $FED3_ALREADY_DEAD = 0 
0004: $FED4_ALREADY_DEAD = 0 
0004: $FED5_ALREADY_DEAD = 0 
0004: $FED6_ALREADY_DEAD = 0 
0004: $FED7_ALREADY_DEAD = 0 
0004: $FED8_ALREADY_DEAD = 0 
0004: $FED9_ALREADY_DEAD = 0 
0004: $FED10_ALREADY_DEAD = 0 
0004: $FED11_ALREADY_DEAD = 0 
0004: $FEDVAN1_ALREADY_DEAD = 0 
0004: $COUNTDOWN_AS2 = 391000 
014E: start_timer_at $COUNTDOWN_AS2 

//FEDS ON TOWER BLOCK*****************************************************************************

009A: $FBI1 = create_char PEDTYPE_CIVMALE model #GANG01 at 383.0 -1447.875 51.375 //Floor4
0173: set_actor $FBI1 z_angle_to 304.0 
011A: set_actor $FBI1 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI1 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI1 maintain_position_when_attacked 1 
0243: set_actor $FBI1 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP1_FBI1 = create_marker_above_actor $FBI1 
009A: $FBI2 = create_char PEDTYPE_CIVMALE model #GANG02 at 381.1875 -1438.188 63.375 //floor6
0173: set_actor $FBI2 z_angle_to 304.0 
011A: set_actor $FBI2 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI2 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI2 maintain_position_when_attacked 1 
0243: set_actor $FBI2 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP2_FBI2 = create_marker_above_actor $FBI2 
009A: $FBI3 = create_char PEDTYPE_CIVMALE model #GANG01 at 383.5 -1452.25 69.375 //floor7
0173: set_actor $FBI3 z_angle_to 304.0 
011A: set_actor $FBI3 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI3 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI3 maintain_position_when_attacked 1 
0243: set_actor $FBI3 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP3_FBI3 = create_marker_above_actor $FBI3 
009A: $FBI8 = create_char PEDTYPE_CIVMALE model #GANG02 at 381.5625 -1451.688 57.5 //floor5
0173: set_actor $FBI8 z_angle_to 304.0 
011A: set_actor $FBI8 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI8 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI8 maintain_position_when_attacked 1 
0243: set_actor $FBI8 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP8_FBI8 = create_marker_above_actor $FBI8 
009A: $FBI9 = create_char PEDTYPE_CIVMALE model #GANG01 at 381.375 -1443.5 75.5 //floor8
0173: set_actor $FBI9 z_angle_to 304.0 
011A: set_actor $FBI9 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI9 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI9 maintain_position_when_attacked 1 
0243: set_actor $FBI9 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP9_FBI9 = create_marker_above_actor $FBI9 
009A: $FBI10 = create_char PEDTYPE_CIVMALE model #GANG02 at 379.0 -1449.563 81.375 //floor9 (Top)
0173: set_actor $FBI10 z_angle_to 304.0 
011A: set_actor $FBI10 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI10 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI10 maintain_position_when_attacked 1 
0243: set_actor $FBI10 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP10_FBI10 = create_marker_above_actor $FBI10 
009A: $FBI11 = create_char PEDTYPE_CIVMALE model #GANG01 at 435.0 -1388.0 26.1 //sneaky backstab
0173: set_actor $FBI11 z_angle_to 137.0 
011A: set_actor $FBI11 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI11 weapon WEAPONTYPE_M16 ammo 600 
0350: set_actor $FBI11 maintain_position_when_attacked 1 
0243: set_actor $FBI11 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP11_FBI11 = create_marker_above_actor $FBI11 

//FEDS AT PARK**********************************************************************************

009A: $FBI4 = create_char PEDTYPE_CIVMALE model #GANG01 at 18.8 -597.5 26.2 //Park
0173: set_actor $FBI4 z_angle_to 161.0 
011A: set_actor $FBI4 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI4 weapon WEAPONTYPE_CHAINGUN ammo 100 
0350: set_actor $FBI4 maintain_position_when_attacked 1 
0243: set_actor $FBI4 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP4_FBI4 = create_marker_above_actor $FBI4 
009A: $FBI7 = create_char PEDTYPE_CIVMALE model #GANG02 at 17.5 -601.0 25.9 //Park
0173: set_actor $FBI7 z_angle_to 343.0 
011A: set_actor $FBI7 search_threat THREAT_PLAYER1 
01B2: give_actor $FBI7 weapon WEAPONTYPE_CHAINGUN ammo 100 
0350: set_actor $FBI7 maintain_position_when_attacked 1 
0243: set_actor $FBI7 ped_stats_to PEDSTAT_TOUGH_GUY 
0187: $BLIP7_FBI7 = create_marker_above_actor $FBI7 

//FEDS IN VAN**********************************************************************************

00A5: $FBI_VAN1 = create_car #RUMPO at 61.25 -1389.375 26.25 
0229: set_car $FBI_VAN1 color_to CARCOLOUR_BLACK CARCOLOUR_BLACK 
02AA: set_car $FBI_VAN1 immune_to_nonplayer 1 
020A: set_car $FBI_VAN1 door_status_to CARLOCK_LOCKED 
0175: set_car $FBI_VAN1 z_angle_to 151.0 
0224: set_car $FBI_VAN1 health_to 2000
02AC: set_car $FBI_VAN1 immunities 1 0 1 0 0 
0129: $FBI5 = create_actor PEDTYPE_CIVMALE #GANG01 in_car $FBI_VAN1 driverseat 
0187: $BLIP5_FBI5 = create_marker_above_actor $FBI5 
01C8: $FBI6 = create_actor PEDTYPE_CIVMALE model #GANG02 in_car $FBI_VAN1 passenger_seat 2 
0187: $BLIP6_FBI6 = create_marker_above_actor $FBI6 
00A9: car_set_idle $FBI_VAN1 
011A: set_actor $FBI5 search_threat THREAT_PLAYER1 
011A: set_actor $FBI6 search_threat THREAT_PLAYER1 
0243: set_actor $FBI5 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $FBI6 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $FBI5 weapon WEAPONTYPE_CHAINGUN ammo 100 
01B2: give_actor $FBI6 weapon WEAPONTYPE_CHAINGUN ammo 100 

while 8038:   not  $NUMBER_OF_FEDS_KILLED == 11 
	wait 0 ms
	if and
		0118:   actor $FBI1 dead 
		0038:   $FED1_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP1_FBI1 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED1_ALREADY_DEAD = 1 
	end
	if and
		0118:   actor $FBI2 dead 
		0038:   $FED2_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP2_FBI2 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED2_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI3 dead 
		0038:   $FED3_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP3_FBI3 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED3_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI4 dead 
		0038:   $FED4_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP4_FBI4 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED4_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI5 dead 
		0038:   $FED5_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP5_FBI5 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED5_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI6 dead 
		0038:   $FED6_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP6_FBI6 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED6_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI7 dead 
		0038:   $FED7_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP7_FBI7 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED7_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI8 dead 
		0038:   $FED8_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP8_FBI8 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED8_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI9 dead 
		0038:   $FED9_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP9_FBI9 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED9_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI10 dead 
		0038:   $FED10_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP10_FBI10 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED10_ALREADY_DEAD = 1 
	end

	if and
		0118:   actor $FBI11 dead 
		0038:   $FED11_ALREADY_DEAD == 0 
	then
		0164: disable_marker $BLIP11_FBI11 
		0008: $NUMBER_OF_FEDS_KILLED += 1 
		0004: $FED11_ALREADY_DEAD = 1 
	end

	if
		8118:   not actor $FBI1 dead 
	then
		0226: $FBI1HEALTH = actor $FBI1 health 
	end
	if
		8118:   not actor $FBI2 dead 
	then
		0226: $FBI2HEALTH = actor $FBI2 health 
	end
	if
		8118:   not actor $FBI3 dead 
	then
		0226: $FBI3HEALTH = actor $FBI3 health 
	end
	if
		8118:   not actor $FBI4 dead 
	then
		0226: $FBI4HEALTH = actor $FBI4 health 
	end
	if
		8118:   not actor $FBI5 dead 
	then
		0226: $FBI5HEALTH = actor $FBI5 health 
	end
	if
		8118:   not actor $FBI6 dead 
	then
		0226: $FBI6HEALTH = actor $FBI6 health 
	end
	if
		8118:   not actor $FBI7 dead 
	then
		0226: $FBI7HEALTH = actor $FBI7 health 
	end
	if
		8118:   not actor $FBI8 dead 
	then
		0226: $FBI8HEALTH = actor $FBI8 health 
	end
	if
		8118:   not actor $FBI9 dead 
	then
		0226: $FBI9HEALTH = actor $FBI9 health 
	end
	if
		8118:   not actor $FBI10 dead 
	then
		0226: $FBI10HEALTH = actor $FBI10 health 
	end
	if
		8118:   not actor $FBI10 dead 
	then
		0226: $FBI11HEALTH = actor $FBI11 health 
	end
	if or
		001A:   100 > $FBI1HEALTH 
		001A:   100 > $FBI2HEALTH 
		001A:   100 > $FBI3HEALTH 
		001A:   100 > $FBI8HEALTH 
		001A:   100 > $FBI9HEALTH 
		001A:   100 > $FBI10HEALTH 
		001A:   100 > $FBI11HEALTH 
	then
		gosub @TOWER_GUYS_SPOT_PLAYER
	end
	if or
		0118:   actor $FBI1 dead 
		0118:   actor $FBI2 dead 
		0118:   actor $FBI3 dead 
		0118:   actor $FBI8 dead 
		0118:   actor $FBI9 dead 
		0118:   actor $FBI10 dead 
		0118:   actor $FBI11 dead 
	then
		gosub @TOWER_GUYS_SPOT_PLAYER
	end
	if or
		001A:   100 > $FBI4HEALTH 
		001A:   100 > $FBI7HEALTH 
	then
		gosub @PARK_GUYS_SPOT_PLAYER
	end
	if or
		0118:   actor $FBI4 dead 
		0118:   actor $FBI7 dead 
	then
		gosub @PARK_GUYS_SPOT_PLAYER
	end
	if
		8119:   not car $FBI_VAN1 wrecked 
	then
		if and
			8185:   not car $FBI_VAN1 health >= 1999 
			0038:   $BEEN_DAMAGED_BEFORE == 0 
			8118:   not actor $FBI5 dead 
			8118:   not actor $FBI6 dead 
		then
			02AA: set_car $FBI_VAN1 immune_to_nonplayer 0 
			01CC: actor $FBI5 kill_player $PLAYER_CHAR 
			01CC: actor $FBI6 kill_player $PLAYER_CHAR 
			020A: set_car $FBI_VAN1 door_status_to CARLOCK_UNLOCKED 
			0004: $BEEN_DAMAGED_BEFORE = 1
		end
	end
	if
		0038:   $COUNTDOWN_AS2 == 0
	then
		goto @MISSION_FAILED_ASUKA2
	end
end //while

goto @MISSION_PASSED_ASUKA2

////////////////////////////////////////

:TOWER_GUYS_SPOT_PLAYER

if
	0038:   $FBI_SPOTTED_PLAYER0 == 0 
then
	if
		8118:   not actor $FBI1 dead 
	then
		01CA: actor $FBI1 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI1 weapon_accuracy_to 40
	end
	if
		8118:   not actor $FBI2 dead 
	then
		01CA: actor $FBI2 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI2 weapon_accuracy_to 04
	end
	if
		8118:   not actor $FBI3 dead 
	then
		01CA: actor $FBI3 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI3 weapon_accuracy_to 50
	end
	if
		8118:   not actor $FBI8 dead 
	then
		01CA: actor $FBI8 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI8 weapon_accuracy_to 40
	end
	if
		8118:   not actor $FBI9 dead 
	then
		01CA: actor $FBI9 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI9 weapon_accuracy_to 50
	end
	if
		8118:   not actor $FBI10 dead 
	then
		01CA: actor $FBI10 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI10 weapon_accuracy_to 70
	end
	if
		8118:   not actor $FBI11 dead 
	then
		01CA: actor $FBI11 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI11 weapon_accuracy_to 90
	end
	0004: $FBI_SPOTTED_PLAYER0 = 1 
end
return

////////////////////////////////////////

:PARK_GUYS_SPOT_PLAYER

if
	0038:   $FBI_SPOTTED_PLAYER2 == 0 
then
	if
		8118:   not actor $FBI4 dead 
	then
		01CA: actor $FBI4 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI4 weapon_accuracy_to 70
	end
	if
		8118:   not actor $FBI4 dead 
	then
		01CA: actor $FBI7 kill_player $PLAYER_CHAR 
		02E2: set_actor $FBI7 weapon_accuracy_to 70
	end
	0004: $FBI_SPOTTED_PLAYER2 = 1 
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_ASUKA2
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_ASUKA2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_ASUKA2
0004: $UNDER_SURVEILLANCE_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 15000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 15000 
0318: set_latest_mission_passed 'AM2'  // 'UNDER SURVEILLANCE'
030C: set_mission_points += 1 
02A7: $KENJI_MISION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_KENJI at 459.0625 -1413.0 26.0625 
0164: disable_marker $STAUNTON_AMMUNATION_MARKER 
0164: disable_marker $STAUNTON_PAYNSPRAY_MARKER 
004F: create_thread @ASUKA_MISSION3_LOOP 
goto @MISSION_END_ASUKA2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_ASUKA2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA1 = 0 
0249: release_model #GANG01 
0249: release_model #GANG02 
0249: release_model #RUMPO 
0164: disable_marker $BLIP1_FBI1 
0164: disable_marker $BLIP2_FBI2 
0164: disable_marker $BLIP3_FBI3 
0164: disable_marker $BLIP4_FBI4 
0164: disable_marker $BLIP5_FBI5 
0164: disable_marker $BLIP6_FBI6 
0164: disable_marker $BLIP7_FBI7 
0164: disable_marker $BLIP8_FBI8 
0164: disable_marker $BLIP9_FBI9 
0164: disable_marker $BLIP10_FBI10 
0164: disable_marker $BLIP11_FBI11 
014F: stop_timer $COUNTDOWN_AS2 
00D8: mission_has_finished 
return
