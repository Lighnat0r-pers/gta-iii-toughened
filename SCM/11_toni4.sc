// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 4****************************************
// ********************************Kill the Triad Warlords************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

:M11_TRIADSANDTRIBULATIONS

gosub @MISSION_START_TONI4
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_TONI4
end

:MISSION_END_TONI4
gosub @MISSION_CLEANUP_TONI4
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_TONI4
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_TONI = 1 
03A4: name_thread 'TONI4' 
0001: wait 0 ms 
0004: $GRUNTS1_BEEN_CREATED_BEFORE = 0 
0004: $GRUNTS2_BEEN_CREATED_BEFORE = 0 
0004: $GRUNTS3_BEEN_CREATED_BEFORE = 0 
0004: $GRABBED_PEDS_BEFORE = 0 
0004: $BEEN_IN_FISH_FACTORY = 0 
0004: $AUDIO_PLAYED_TM4 = 0 
0004: $TRIAD1_CAN_LEG_IT = 0 
0004: $TRIAD1_CAN_LEG_IT = 0 
0004: $TRIAD1_CAN_LEG_IT = 0 
0004: $PAY_BACK_FOR_TRIADS1 = 0 
0004: $PAY_BACK_FOR_TRIADS2 = 0 
0004: $PAY_BACK_FOR_TRIADS3 = 0 
0004: $TONI4_ENEMY1_CLOSE_SECRET_DONE = 0
0004: $TONI4_ENEMY2_CLOSE_SECRET_DONE = 0
0004: $TONI4_ENEMY3_CLOSE_SECRET_DONE = 0
0237: set_gang GANG_TRIAD primary_weapon_to WEAPONTYPE_UZI secondary_weapon_to WEAPONTYPE_PISTOL 
0247: request_model #GANG01 
0247: request_model #GANG02 
0247: request_model #IND_NEWRIZZOS 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'NOTE' 
038B: load_all_models_now 

while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #GANG01 available 
		8248:   not model #GANG02 available 
		8248:   not model #IND_NEWRIZZOS available 
	jf break
	wait 0 ms
end //while

009A: $TONI4_MAFIA1 = create_char PEDTYPE_GANG_MAFIA model #GANG02 at 1216.375 -309.875 -100.0
009A: $TONI4_MAFIA2 = create_char PEDTYPE_GANG_MAFIA model #GANG01 at 1215.875 -311.1875 29.0
if and
	8118:   not actor $TONI4_MAFIA1 dead 
	8118:   not actor $TONI4_MAFIA2 dead
then
	01B2: give_actor $TONI4_MAFIA1 weapon WEAPONTYPE_CHAINGUN ammo 300 
	011A: set_actor $TONI4_MAFIA1 search_threat THREAT_COP 
	011A: set_actor $TONI4_MAFIA1 search_threat THREAT_GANG_TRIAD 
	0319: set_actor $TONI4_MAFIA1 running 1 
	020E: actor $TONI4_MAFIA1 look_at_actor $TONI4_MAFIA2 
	03F9: make_actors $TONI4_MAFIA1 $TONI4_MAFIA2 converse_in 24000 ms 
	01B2: give_actor $TONI4_MAFIA2 weapon WEAPONTYPE_CHAINGUN ammo 300 
	011A: set_actor $TONI4_MAFIA2 search_threat THREAT_COP 
	011A: set_actor $TONI4_MAFIA2 search_threat THREAT_GANG_TRIAD 
	0319: set_actor $TONI4_MAFIA2 running 1 
	020E: actor $TONI4_MAFIA2 look_at_actor $TONI4_MAFIA1
end

02E4: load_cutscene_data 'T4_TAT' 
0244: set_cutscene_pos 1218.375 -314.5 28.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_NOTE 'NOTE' 
0395: clear_area 1 at 1219.563 -323.0 range 25.5625 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1219.563 -323.0 25.5625 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
0395: clear_area 1 at 1216.063 -313.0 range 29.875 10.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   82 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_A' duration 10000 ms flag 1  // ~w~Oh it's you. TONI ain't here.
while 001A:   2415 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_A2' duration 10000 ms flag 1  // ~w~But he left one of his sugary love letters for you.
while 001A:   4420 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_B' duration 10000 ms flag 1  // ~w~We're at WAR! The Triads have a fish factory as a front.
while 001A:   7629 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_C' duration 10000 ms flag 1  // ~w~Most of their business goes down at the fish market in Chinatown.
while 001A:   11110 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_D' duration 10000 ms flag 1  // ~w~That laundry still owes us protection.
while 001A:   13283 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_E' duration 10000 ms flag 1  // ~w~They reckon the Triads are protecting them now, so I say we exact a fitting punishment.
while 001A:   18058 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_F' duration 10000 ms flag 1  // ~w~Take these boys over and whack the Triad Warlords!
while 001A:   21248 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'TM4_G' duration 10000 ms flag 1  // ~w~Hell, if you get a chance, pop some of their soldiers too.
while 001A:   24000 > $CUT_SCENE_TIME
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

if and
	8118:   not actor $TONI4_MAFIA1 dead 
	8118:   not actor $TONI4_MAFIA2 dead
then
	03F9: make_actors $TONI4_MAFIA1 $TONI4_MAFIA2 converse_in 0 ms 
end

01B1: give_player $PLAYER_CHAR weapon WEAPONTYPE_SHOTGUN ammo 20 
01B8: set_player $PLAYER_CHAR armed_weapon_to WEAPONTYPE_SHOTGUN

if and
	8118:   not actor $TONI4_MAFIA1 dead 
	8118:   not actor $TONI4_MAFIA2 dead
then
	00A1: set_char_coordinates $TONI4_MAFIA1 to 1220.188 -321.75 26.375 
	00A1: set_char_coordinates $TONI4_MAFIA2 to 1219.0 -321.25 26.375 
end

0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #IND_NEWRIZZOS 
0247: request_model #GANG03 
0247: request_model #GANG04 

while true
	if or
		8248:   not model #GANG03 available 
		8248:   not model #GANG04 available
	jf break
	wait 0 ms
end //while

03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1 
0004: $WARLORDS_DEAD = 0 
0004: $TRIADS_SPOT_YOU = 0 
0004: $CLEAR_TRIADS_THREATS = 0 

if
	8118:   not actor $TONI4_MAFIA1 dead 
then
	01DF: tie_actor $TONI4_MAFIA1 to_player $PLAYER_CHAR 
end
if
	8118:   not actor $TONI4_MAFIA2 dead 
then
	01DF: tie_actor $TONI4_MAFIA2 to_player $PLAYER_CHAR 
end

015C: set_zone_gang_info 'LITTLEI' DAY 15 500 250 0 0 0 0 0 0 
015C: set_zone_gang_info 'LITTLEI' NIGHT 8 500 250 0 0 0 0 0 0 
015C: set_zone_gang_info 'CHINA' DAY 30 350 600 0 0 0 0 0 0 
015C: set_zone_gang_info 'CHINA' NIGHT 30 350 600 0 0 0 0 0 0

// START OF MISSION

009A: $TONI4_TRIAD1 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 906.375 -541.375 14.375 //Fish warhouse (Chinatown)
01B2: give_actor $TONI4_TRIAD1 weapon WEAPONTYPE_UZI ammo 80 
0173: set_actor $TONI4_TRIAD1 z_angle_to 109.0 
0187: $TONI4_TRIAD1_MARKER = create_marker_above_actor $TONI4_TRIAD1 
0223: set_actor $TONI4_TRIAD1 health_to 1000
035F: set_actor $TONI4_TRIAD1 armour_to 500 
0446: set_actor $TONI4_TRIAD1 dismemberment_possible 0
011A: set_actor $TONI4_TRIAD1 search_threat THREAT_PLAYER1 
02A9: set_char_only_damaged_by_player $TONI4_TRIAD1 to 1 
0350: set_actor $TONI4_TRIAD1 maintain_position_when_attacked 1 

009A: $TONI4_TRIAD2 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 968.5625 -682.1875 14.25 //Market place
01B2: give_actor $TONI4_TRIAD2 weapon WEAPONTYPE_UZI ammo 80 
0187: $TONI4_TRIAD2_MARKER = create_marker_above_actor $TONI4_TRIAD2 
0223: set_actor $TONI4_TRIAD2 health_to 1000
035F: set_actor $TONI4_TRIAD2 armour_to 500 
0446: set_actor $TONI4_TRIAD2 dismemberment_possible 0
011A: set_actor $TONI4_TRIAD2 search_threat THREAT_PLAYER1 
02A9: set_char_only_damaged_by_player $TONI4_TRIAD2 to 1 
0350: set_actor $TONI4_TRIAD2 maintain_position_when_attacked 1 

009A: $TONI4_TRIAD3 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 968.25 -1136.75 15.0 //Fish factory
01B2: give_actor $TONI4_TRIAD3 weapon WEAPONTYPE_UZI ammo 80 
0173: set_actor $TONI4_TRIAD3 z_angle_to 38.0 
0187: $TONI4_TRIAD3_MARKER = create_marker_above_actor $TONI4_TRIAD3
0223: set_actor $TONI4_TRIAD3 health_to 1000 
035F: set_actor $TONI4_TRIAD3 armour_to 500 
0446: set_actor $TONI4_TRIAD3 dismemberment_possible 0
011A: set_actor $TONI4_TRIAD3 search_threat THREAT_PLAYER1 
02A9: set_char_only_damaged_by_player $TONI4_TRIAD3 to 1 
0350: set_actor $TONI4_TRIAD3 maintain_position_when_attacked 1 
0004: $CHAR_ALREADY_DEAD1 = 0 
0004: $CHAR_ALREADY_DEAD2 = 0 
0004: $CHAR_ALREADY_DEAD3 = 0 
03CF: load_wav 'T4_A'

00BC: print_now 'T4_HINT' duration 5000 ms flag 1  // Remember: Keep your friends close, but your enemies closer.

while 83D0:   not wav_loaded 
	wait 0 ms
end

while 8038:   not  $WARLORDS_DEAD == 3
	wait 0 ms
	if and
		0118:   actor $TONI4_TRIAD1 dead 
		0038:   $CHAR_ALREADY_DEAD1 == 0
	then
		0164: disable_marker $TONI4_TRIAD1_MARKER 
		0008: $WARLORDS_DEAD += 1 
		0004: $CHAR_ALREADY_DEAD1 = 1 
	end
	if and
		0118:   actor $TONI4_TRIAD2 dead 
		0038:   $CHAR_ALREADY_DEAD2 == 0
	then
		0164: disable_marker $TONI4_TRIAD2_MARKER 
		0008: $WARLORDS_DEAD += 1 
		0004: $CHAR_ALREADY_DEAD2 = 1 
	end
	if and
		0118:   actor $TONI4_TRIAD3 dead 
		0038:   $CHAR_ALREADY_DEAD3 == 0
	then
		0164: disable_marker $TONI4_TRIAD3_MARKER 
		0008: $WARLORDS_DEAD += 1 
		0004: $CHAR_ALREADY_DEAD3 = 1 
	end

	gosub @TRIAD_AI // NOTE: this subroutine is in 34_toni5.sc

	if and
		0121:   player $PLAYER_CHAR in_zone 'CHINA'  // Chinatown
		0038:   $AUDIO_PLAYED_TM4 == 0
	then
		03D1: play_wav 
		0004: $AUDIO_PLAYED_TM4 = 1
	end

	if
		8118:   not actor $TONI4_TRIAD1 dead
	then
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD1 radius 80.0 80.0
			0038:   $GRUNTS1_BEEN_CREATED_BEFORE == 0 
		then
			009A: $TONI4_TRIAD4 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 907.375 -542.375 14.375
			0173: set_actor $TONI4_TRIAD4 z_angle_to 180.0
			01B2: give_actor $TONI4_TRIAD4 weapon WEAPONTYPE_UZI ammo 80
			01DE: tie_actor $TONI4_TRIAD4 to_actor $TONI4_TRIAD1
			011A: set_actor $TONI4_TRIAD4 search_threat THREAT_PLAYER1
			009A: $TONI4_TRIAD5 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 907.375 -542.375 14.375
			0173: set_actor $TONI4_TRIAD5 z_angle_to 160.0
			01B2: give_actor $TONI4_TRIAD5 weapon WEAPONTYPE_UZI ammo 80
			01DE: tie_actor $TONI4_TRIAD5 to_actor $TONI4_TRIAD1
			011A: set_actor $TONI4_TRIAD5 search_threat THREAT_PLAYER1
			02A9: set_char_only_damaged_by_player $TONI4_TRIAD1 to 0
			0004: $GRUNTS1_BEEN_CREATED_BEFORE = 1
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD1 radius 30.0 30.0 
			0038:   $TRIAD1_CAN_LEG_IT == 0 
		then
			0350: set_actor $TONI4_TRIAD1 maintain_position_when_attacked 0 
			0004: $TRIAD1_CAN_LEG_IT = 1
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD1 radius 10.0 10.0 
			0038:   $TONI4_ENEMY1_CLOSE_SECRET_DONE == 0
		then
			0223: set_actor $TONI4_TRIAD1 health_to 19
			035F: set_actor $TONI4_TRIAD1 armour_to 1 
			0446: set_actor $TONI4_TRIAD1 dismemberment_possible 1
			0004: $TONI4_ENEMY1_CLOSE_SECRET_DONE = 1
		end
	end


	if
		8118:   not actor $TONI4_TRIAD2 dead
	then
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD2 radius 80.0 80.0
			0038:   $GRUNTS2_BEEN_CREATED_BEFORE == 0 
		then
			009A: $TONI4_TRIAD6 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 965.5625 -680.1875 14.25
			01B2: give_actor $TONI4_TRIAD6 weapon WEAPONTYPE_UZI ammo 80 
			01DE: tie_actor $TONI4_TRIAD6 to_actor $TONI4_TRIAD2 
			011A: set_actor $TONI4_TRIAD6 search_threat THREAT_PLAYER1 
			009A: $TONI4_TRIAD7 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 965.5 -683.0 14.25
			01B2: give_actor $TONI4_TRIAD7 weapon WEAPONTYPE_UZI ammo 80 
			01DE: tie_actor $TONI4_TRIAD7 to_actor $TONI4_TRIAD2 
			011A: set_actor $TONI4_TRIAD7 search_threat THREAT_PLAYER1 
			02A9: set_char_only_damaged_by_player $TONI4_TRIAD2 to 0 
			0004: $GRUNTS2_BEEN_CREATED_BEFORE = 1 
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD2 radius 30.0 30.0 
			0038:   $TRIAD2_CAN_LEG_IT == 0 
		then
			0350: set_actor $TONI4_TRIAD2 maintain_position_when_attacked 0 
			0004: $TRIAD2_CAN_LEG_IT = 1
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD2 radius 10.0 10.0 
			0038:   $TONI4_ENEMY2_CLOSE_SECRET_DONE == 0
		then
			0223: set_actor $TONI4_TRIAD2 health_to 19
			035F: set_actor $TONI4_TRIAD2 armour_to 1 
			0446: set_actor $TONI4_TRIAD2 dismemberment_possible 1
			0004: $TONI4_ENEMY2_CLOSE_SECRET_DONE = 1
		end
	end

	if
		8118:   not actor $TONI4_TRIAD3 dead
	then
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD3 radius 80.0 80.0
			0038:   $GRUNTS3_BEEN_CREATED_BEFORE == 0 
		then
			009A: $TONI4_TRIAD8 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 967.0625 -1134.0 15.0
			01B2: give_actor $TONI4_TRIAD8 weapon WEAPONTYPE_UZI ammo 80 
			01DE: tie_actor $TONI4_TRIAD8 to_actor $TONI4_TRIAD3 
			011A: set_actor $TONI4_TRIAD8 search_threat THREAT_PLAYER1 
			02A9: set_char_only_damaged_by_player $TONI4_TRIAD3 to 0 
			009A: $TONI4_TRIAD9 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 966.0625 -1129.0 15.0
			01B2: give_actor $TONI4_TRIAD9 weapon WEAPONTYPE_UZI ammo 80 
			01DE: tie_actor $TONI4_TRIAD9 to_actor $TONI4_TRIAD3 
			011A: set_actor $TONI4_TRIAD9 search_threat THREAT_PLAYER1 
			02A9: set_char_only_damaged_by_player $TONI4_TRIAD3 to 0 
			0004: $GRUNTS3_BEEN_CREATED_BEFORE = 1 
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD3 radius 30.0 30.0 
			0038:   $TRIAD3_CAN_LEG_IT == 0 
		then
			0350: set_actor $TONI4_TRIAD3 maintain_position_when_attacked 0 
			0004: $TRIAD3_CAN_LEG_IT = 1
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $TONI4_TRIAD3 radius 10.0 10.0 
			0038:   $TONI4_ENEMY3_CLOSE_SECRET_DONE == 0
		then
			0223: set_actor $TONI4_TRIAD3 health_to 19
			035F: set_actor $TONI4_TRIAD3 armour_to 1 
			0446: set_actor $TONI4_TRIAD3 dismemberment_possible 1
			0004: $TONI4_ENEMY3_CLOSE_SECRET_DONE = 1
		end
	end

	if and
		0038:   $GRUNTS1_BEEN_CREATED_BEFORE == 1 
		0038:   $PAY_BACK_FOR_TRIADS1 == 0
	then
		if or
			0118:   actor $TONI4_TRIAD4 dead 
			0118:   actor $TONI4_TRIAD5 dead 
			0118:   actor $TONI4_TRIAD1 dead
		then
			if
				8118:   not actor $TONI4_TRIAD4 dead
			then
				01CA: actor $TONI4_TRIAD4 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD5 dead
			then
				01CA: actor $TONI4_TRIAD5 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD1 dead
			then
				01CA: actor $TONI4_TRIAD1 kill_player $PLAYER_CHAR 
			end
			0004: $PAY_BACK_FOR_TRIADS1 = 1	
		end
	end

	if and
		0038:   $GRUNTS2_BEEN_CREATED_BEFORE == 1 
		0038:   $PAY_BACK_FOR_TRIADS2 == 0
	then
		if or
			0118:   actor $TONI4_TRIAD6 dead 
			0118:   actor $TONI4_TRIAD7 dead 
			0118:   actor $TONI4_TRIAD2 dead
		then
			if
				8118:   not actor $TONI4_TRIAD6 dead
			then
				01CA: actor $TONI4_TRIAD6 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD7 dead
			then
				01CA: actor $TONI4_TRIAD7 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD2 dead
			then
				01CA: actor $TONI4_TRIAD2 kill_player $PLAYER_CHAR 
			end
			0004: $PAY_BACK_FOR_TRIADS2 = 1	
		end
	end

	if and
		0038:   $GRUNTS3_BEEN_CREATED_BEFORE == 1 
		0038:   $PAY_BACK_FOR_TRIADS3 == 0
	then
		if or
			0118:   actor $TONI4_TRIAD8 dead 
			0118:   actor $TONI4_TRIAD9 dead 
			0118:   actor $TONI4_TRIAD3 dead
		then
			if
				8118:   not actor $TONI4_TRIAD8 dead
			then
				01CA: actor $TONI4_TRIAD8 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD9 dead
			then
				01CA: actor $TONI4_TRIAD9 kill_player $PLAYER_CHAR 
			end
			if
				8118:   not actor $TONI4_TRIAD3 dead
			then
				01CA: actor $TONI4_TRIAD3 kill_player $PLAYER_CHAR 
			end
			0004: $PAY_BACK_FOR_TRIADS3 = 1	
		end
	end

	if
		8118:   not actor $TONI4_MAFIA1 dead 
	then
		if
			80E9:   not player $PLAYER_CHAR 0 $TONI4_MAFIA1 radius 120.0 120.0
		then
			009B: delete_char $TONI4_MAFIA1
		else
			if
				8320:   not actor $TONI4_MAFIA1 in_range_of_player $PLAYER_CHAR
			then
				01DF: tie_actor $TONI4_MAFIA1 to_player $PLAYER_CHAR
			end
		end
	end

	if
		8118:   not actor $TONI4_MAFIA2 dead 
	then
		if
			80E9:   not player $PLAYER_CHAR 0 $TONI4_MAFIA2 radius 120.0 120.0
		then
			009B: delete_char $TONI4_MAFIA2
		else
			if
				8320:   not actor $TONI4_MAFIA2 in_range_of_player $PLAYER_CHAR
			then
				01DF: tie_actor $TONI4_MAFIA2 to_player $PLAYER_CHAR
			end
		end
	end

	if and
		0057:   is_player_in_area_3d $PLAYER_CHAR coords 1025.188 -1108.375 12.0 to 1009.188 -1098.375 16.0 sphere 0 
		80DE:   not is_player_in_model $PLAYER_CHAR model #BELLYUP 
		80DE:   not is_player_in_model $PLAYER_CHAR model #TRASH
	then
		if and
			0057:   is_player_in_area_3d $PLAYER_CHAR coords 1015.563 -1100.5 12.0 to 1009.188 -1108.063 16.0 sphere 0 
			0038:   $BEEN_IN_FISH_FACTORY == 0
		then
			0004: $BEEN_IN_FISH_FACTORY = 1 
		end
		if
			0038:   $BEEN_IN_FISH_FACTORY == 0
		then
			00BC: print_now 'TM4_GAT' duration 5000 ms flag 1  // ~g~You need a 'Triad fish van' to enter.
		end
	end
end //while

goto @MISSION_PASSED_TONI4

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_TONI4
015C: set_zone_gang_info 'CHINA' DAY 20 0 300 0 0 0 0 0 20 
015C: set_zone_gang_info 'CHINA' NIGHT 10 0 400 0 0 0 0 0 10
goto @MISSION_END_TONI4

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_TONI4
0004: $TRIADS_AND_TRIBULATIONS_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 30000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 30000 
0318: set_latest_mission_passed 'TM4'  // 'TRIADS AND TRIBULATIONS'
030C: set_mission_points += 1 
004F: create_thread @TONI_MISSION5_LOOP 
015C: set_zone_gang_info 'CHINA' DAY 20 0 200 0 0 0 0 0 20 
015C: set_zone_gang_info 'CHINA' NIGHT 10 0 300 0 0 0 0 0 10 
goto @MISSION_END_TONI4

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_TONI4
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_TONI = 0 
0164: disable_marker $TONI4_TRIAD1_MARKER 
0164: disable_marker $TONI4_TRIAD2_MARKER 
0164: disable_marker $TONI4_TRIAD3_MARKER 
0249: release_model #GANG01 
0249: release_model #GANG02 
0249: release_model #GANG03 
0249: release_model #GANG04 
03F1: pedtype PEDTYPE_GANG_TRIAD add_threat THREAT_PLAYER1
0237: set_gang GANG_TRIAD primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_BASEBALLBAT 
015C: set_zone_gang_info 'LITTLEI' DAY 17 300 0 0 0 0 0 0 20 
015C: set_zone_gang_info 'LITTLEI' NIGHT 11 400 0 0 0 0 0 0 10 
00D8: mission_has_finished
return

/////////////////////////////////////////

:TRIAD_AI
if and
	0121:   player $PLAYER_CHAR in_zone 'PORT_W'  // Callahan Point
	0038:   $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 1 
	0038:   $CLEAR_TRIADS_THREATS == 0 
then
	if 
		8118:   not actor $FISH_TRIAD1 dead
	then
		01ED: clear_actor $FISH_TRIAD1 threat_search
	end
	if 
		8118:   not actor $FISH_TRIAD2 dead
	then
		01ED: clear_actor $FISH_TRIAD2 threat_search
	end
	if 
		8118:   not actor $FISH_TRIAD3 dead
	then
		01ED: clear_actor $FISH_TRIAD3 threat_search
	end
	if 
		8118:   not actor $FISH_TRIAD4 dead
	then
		01ED: clear_actor $FISH_TRIAD4 threat_search
	end
	if 
		8118:   not actor $FISH_TRIAD5 dead
	then
		01ED: clear_actor $FISH_TRIAD5 threat_search
	end
	if 
		8118:   not actor $FISH_TRIAD6 dead
	then
		01ED: clear_actor $FISH_TRIAD6 threat_search
	end
	03F2: pedgroup PEDTYPE_GANG_TRIAD remove_threat THREAT_PLAYER1 
	0004: $CLEAR_TRIADS_THREATS = 1
end
if and
	0121:   player $PLAYER_CHAR in_zone 'FISHFAC'
	0038:   $TRIADS_SPOT_YOU == 0
then
	if or
		80E0:   not is_player_in_any_car $PLAYER_CHAR 
		0118:   actor $FISH_TRIAD1 dead 
		0118:   actor $FISH_TRIAD2 dead 
		0118:   actor $FISH_TRIAD3 dead 
		0118:   actor $FISH_TRIAD4 dead 
		0118:   actor $FISH_TRIAD5 dead 
		0118:   actor $FISH_TRIAD6 dead
	then
		if
			8118:   not actor $FISH_TRIAD1 dead 
		then
			011A: set_actor $FISH_TRIAD1 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $FISH_TRIAD2 dead 
		then
			011A: set_actor $FISH_TRIAD2 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $FISH_TRIAD3 dead 
		then
			011A: set_actor $FISH_TRIAD3 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $FISH_TRIAD4 dead 
		then
			011A: set_actor $FISH_TRIAD4 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $FISH_TRIAD5 dead 
		then
			011A: set_actor $FISH_TRIAD5 search_threat THREAT_PLAYER1
		end
		if
			8118:   not actor $FISH_TRIAD6 dead 
		then
			011A: set_actor $FISH_TRIAD6 search_threat THREAT_PLAYER1
		end
		0004: $TRIADS_SPOT_YOU = 1 
	end
end
return
