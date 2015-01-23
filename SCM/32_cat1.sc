// *******************************************************************************************
// *******************************************************************************************
// *************************************Cat mission 1*****************************************
// *************************************FINAL MISSION*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// For some reason SannyBuilder complains about a jump to zero offset for this mission but not for any of the others. The 0000: opcode (which does nothing) is included to prevent this error.
0000:

// Mission start stuff


:M32_THEEXCHANGE

gosub @MISSION_START_CAT1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_CAT1
end

:MISSION_END_CAT1
gosub @MISSION_CLEANUP_CAT1
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_CAT1
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_CATALINA = 1 
03A4: name_thread 'CAT1' 
0001: wait 0 ms 
0004: $ADDED_THE_BLIP_FOR_MARIA = 0 
0004: $BEEN_ON_HELI_PAD = 0 
0004: $SET_AS_LEADER_BEFORE = 0 
0004: $MARIA_CREATED_BEFORE = 0 
0004: $CAMERA_CUT = 0 

015C: set_zone_gang_info 'WEE_DAM' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'WEE_DAM' NIGHT 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'WEE_DAM' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'WEE_DAM' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 



// ****************************************START OF CUTSCENE********************************

0110: clear_player $PLAYER_CHAR wanted_level 
023C: load_special_actor 'MARIA' as 1 
023C: load_special_actor 'CAT' as 2 
023C: load_special_actor 'COL2' as 3 
023C: load_special_actor 'COLROB' as 4 
02F3: load_object #CUTOBJ01 'FULCASE' 
02F3: load_object #CUTOBJ02 'CATH' 
0247: request_model #GANG11 
0247: request_model #GANG12 
0247: request_model #COLUMB 
0247: request_model #FLATBED 
0247: request_model #NEW_COLMANSN 
0247: request_model #LANDPART15 
0247: request_model #SECURITY_HUT 
0247: request_model #COLUMANSION_WALL 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 4 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #GANG11 available 
		8248:   not model #GANG12 available
	jf break
	wait 0 ms
end //while

while true
	if or
		8248:   not model #COLUMB available 
		8248:   not model #NEW_COLMANSN available 
		8248:   not model #LANDPART15 available 
		8248:   not model #SECURITY_HUT available 
		8248:   not model #COLUMANSION_WALL available
	jf break
	wait 0 ms
end //while

03CB: load_scene -363.5 243.5 59.25 
02E4: load_cutscene_data 'C1_TEX' 
0244: set_cutscene_pos -358.5 249.1875 59.3125 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_MARIA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_MARIA 'MARIA' 
02E5: $CS_CAT = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CS_CAT 'CAT' 
02E5: $CS_COLOB2 = create_cutscene_object #SPECIAL04 
02E6: set_cutscene_anim $CS_COLOB2 'COLROB' 
02E5: $CS_COLOB3 = create_cutscene_object #GANG11 
02E6: set_cutscene_anim $CS_COLOB3 'GANG11' 
02E5: $CS_COLOB4 = create_cutscene_object #GANG12 
02E6: set_cutscene_anim $CS_COLOB4 'GANG12' 
02E5: $CS_CASE = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_CASE 'FULCASE' 
02F4: create_cutscene_actor $CS_CATHEAD from_head #CUTOBJ02 and_body $CS_CAT 
02F5: set_head_anim $CS_CATHEAD 'CAT' 

00A5: $COLUBIAN_CAR1 = create_car #COLUMB at -422.875 291.75 61.75 
0175: set_car $COLUBIAN_CAR1 z_angle_to 226.0 

009A: $COLUBIAN_GUARD1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -395.375 293.375 -100.0 //Near Cat
01B2: give_actor $COLUBIAN_GUARD1 weapon WEAPONTYPE_M16 ammo 200 

009A: $COLUBIAN_GUARD3 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -368.0625 252.375 -100.0 //Guarding gate (west)
01B2: give_actor $COLUBIAN_GUARD3 weapon WEAPONTYPE_M16 ammo 200 
0173: set_actor $COLUBIAN_GUARD3 z_angle_to 0.0 

009A: $COLUBIAN_GUARD4 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -358.0 251.75 -100.0 //Guarding gate	(east)
01B2: give_actor $COLUBIAN_GUARD4 weapon WEAPONTYPE_M16 ammo 200 
0173: set_actor $COLUBIAN_GUARD4 z_angle_to 0.0 

009A: $COLUBIAN_GUARD12 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -392.375 301.0 70.6875 //On mansion balcony (west)
01B2: give_actor $COLUBIAN_GUARD12 weapon WEAPONTYPE_M16 ammo 200 
0173: set_actor $COLUBIAN_GUARD12 z_angle_to 0.0 
0350: set_actor $COLUBIAN_GUARD12 maintain_position_when_attacked 1 

009A: $COLUBIAN_GUARD13 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -374.0 301.0 70.6875 //On mansion balcony (east)
01B2: give_actor $COLUBIAN_GUARD13 weapon WEAPONTYPE_M16 ammo 200 
0173: set_actor $COLUBIAN_GUARD13 z_angle_to 0.0 
0350: set_actor $COLUBIAN_GUARD13 maintain_position_when_attacked 1 

03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
020F: actor $COLUBIAN_GUARD1 look_at_player $PLAYER_CHAR 
020F: actor $COLUBIAN_GUARD12 look_at_player $PLAYER_CHAR 
020F: actor $COLUBIAN_GUARD13 look_at_player $PLAYER_CHAR 
0395: clear_area 1 at -362.75 246.5 range 60.0 4.5 

009A: $COLUBIAN_GUARD2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -380.0625 282.5625 -100.0 //Dead guard
0173: set_actor $COLUBIAN_GUARD2 z_angle_to 229.0 
0223: set_actor $COLUBIAN_GUARD2 health_to 0 

016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   22000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
0055: set_player_coordinates $PLAYER_CHAR to -363.25 253.0 -100.0 
while 001A:   32166 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_A' duration 10000 ms flag 2  // The real question is, did you turn up to rescue Maria or to get me back?
while 001A:   38548 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_B' duration 10000 ms flag 2  // Well I got news for you,
while 001A:   40043 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_B2' duration 10000 ms flag 2  // shooting you will be a pleasure but dating you was only business.
while 001A:   43684 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_C' duration 10000 ms flag 2  // You are muy peccinno amigo!
while 001A:   45711 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_D' duration 10000 ms flag 2  // Throw over the cash.
while 001A:   52048 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_E' duration 10000 ms flag 2  // You have been a busy boy!
while 001A:   54527 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_E2' duration 10000 ms flag 2  // But you haven't learned, I'm not to be trusted.
while 001A:   57558 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'CAT2_E3' duration 10000 ms flag 2  // Kill the idiot.
while 001A:   58661 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
while 001A:   65000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
032B: $DEAD_GUARDS_GUN = create_weapon_pickup #COLT45 type PICKUP_ONCE ammo 48 at -380.0625 282.5625 62.5625 
0395: clear_area 1 at -381.75 284.0 range 62.875 1.0 
0055: set_player_coordinates $PLAYER_CHAR to -381.75 284.0 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 232.0 

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

03AD: set_rubbish 1 
02EA: end_cutscene 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0373: set_camera_directly_behind_player 
03B8: clear_weapons_from_player $PLAYER_CHAR 
if
	0038:   $NICKED_HALF_A_MIL_BEFORE == 0 
then
	0109: player $PLAYER_CHAR money += -500000 
	0004: $NICKED_HALF_A_MIL_BEFORE = 1 
end

0296: unload_special_actor 3 
0296: unload_special_actor 4 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #NEW_COLMANSN 
0249: release_model #LANDPART15 
0249: release_model #SECURITY_HUT 
0249: release_model #COLUMANSION_WALL 

while 8248:   not model #FLATBED available 
	wait 0 ms
end

00BC: print_now 'CATINF1' duration 5000 ms flag 2  // ~g~Get Catalina!
0001: wait 1000 ms 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
0004: $COUNTDOWN_CAT1 = 421000 
014E: start_timer_at $COUNTDOWN_CAT1 

00A5: $CAT1_CAR_SECRET = create_car #COLUMB at -350.0 315.0 -100.0 
0175: set_car $CAT1_CAR_SECRET z_angle_to 180.0 
02AC: set_car $CAT1_CAR_SECRET immunities 1 1 1 1 1 

if and
	8118:   not actor $COLUBIAN_GUARD1 dead 
	8118:   not actor $COLUBIAN_GUARD2 dead 
	8118:   not actor $COLUBIAN_GUARD12 dead 
	8118:   not actor $COLUBIAN_GUARD13 dead 
then
	01CC: actor $COLUBIAN_GUARD1 kill_player $PLAYER_CHAR 
	011A: set_actor $COLUBIAN_GUARD1 search_threat THREAT_PLAYER1 
	01CC: actor $COLUBIAN_GUARD2 kill_player $PLAYER_CHAR 
	011A: set_actor $COLUBIAN_GUARD2 search_threat THREAT_PLAYER1 
	01CC: actor $COLUBIAN_GUARD12 kill_player $PLAYER_CHAR 
	011A: set_actor $COLUBIAN_GUARD12 search_threat THREAT_PLAYER1 
	01CC: actor $COLUBIAN_GUARD13 kill_player $PLAYER_CHAR 
	011A: set_actor $COLUBIAN_GUARD13 search_threat THREAT_PLAYER1 
end

if and
	8118:   not actor $COLUBIAN_GUARD3 dead 
	8118:   not actor $COLUBIAN_GUARD4 dead 
then
	011A: set_actor $COLUBIAN_GUARD3 search_threat THREAT_PLAYER1 
	011A: set_actor $COLUBIAN_GUARD4 search_threat THREAT_PLAYER1 
end

022B: switch_ped_roads_off -942.5625 337.0 10.0 to -953.5625 361.375 30.0 // DAM

while 0057:   is_player_in_area_3d $PLAYER_CHAR coords -448.0 241.6875 50.0 to -292.375 365.1875 90.0 sphere 0
	wait 0 ms
	if
		0038:   $COUNTDOWN_CAT1 == 0 
	then
		goto @MISSION_FAILED_CAT1
	end
	0110: clear_player $PLAYER_CHAR wanted_level 
end //while

03B2: start_catalina_flyby 
0004: $ESCAPE_CHOPPER = -1 

while 0038:   $ESCAPE_CHOPPER == -1 
	wait 0 ms
	03B9: create_catalinas_chopper $ESCAPE_CHOPPER 
end

wait 1000 ms

if
	8119:   not car $ESCAPE_CHOPPER wrecked 
then
	0186: $BLIP_CAT1 = create_marker_above_car $ESCAPE_CHOPPER 
	018B: show_on_radar $BLIP_CAT1 2 
	015F: set_camera_position -364.5 243.6875 62.6875 rotation 0.0 0.0 0.0 
	0158: camera_on_vehicle $ESCAPE_CHOPPER mode 15 switchstyle 1 
	02A3: toggle_widescreen 1 
	01B4: set_player $PLAYER_CHAR controllable 0 
	01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
	03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
	02AC: set_car $ESCAPE_CHOPPER immunities 1 1 1 1 1 
end

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	0221: set_player $PLAYER_CHAR apply_brakes_to_car 1 
end

0001: wait 5000 ms 
015A: restore_camera 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
0221: set_player $PLAYER_CHAR apply_brakes_to_car 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	0221: set_player $PLAYER_CHAR apply_brakes_to_car 0
end

00BC: print_now 'CATINF2' duration 5000 ms flag 2  // ~g~Follow the chopper to find Catalina.

while 8121:   not player $PLAYER_CHAR in_zone 'BIG_DAM'  // Cochrane Dam
	wait 0 ms
	gosub @CHECK_PASS_FAIL_CLEAR_WANTED_CAT1
end //while

03F1: pedtype PEDTYPE_GANG_COLOMBIAN add_threat THREAT_PLAYER1 
0237: set_gang GANG_COLOMBIAN primary_weapon_to WEAPONTYPE_M16 secondary_weapon_to WEAPONTYPE_M16 
01C2: remove_references_to_actor $COLUBIAN_GUARD1 
01C2: remove_references_to_actor $COLUBIAN_GUARD2 
01C2: remove_references_to_actor $COLUBIAN_GUARD3 
01C2: remove_references_to_actor $COLUBIAN_GUARD4 

00A5: $COLUBIAN_CAR6 = create_car #COLUMB at -946.75 310.0 -100.0 
0175: set_car $COLUBIAN_CAR6 z_angle_to 104.6875 
00A5: $COLUBIAN_CAR7 = create_car #COLUMB at -952.25 310.25 -100.0 
0175: set_car $COLUBIAN_CAR7 z_angle_to 78.75 

009A: $COLUBIAN_GUARD14 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -955.5 309.6875 -100.0 //guards by 1st columbian block
0173: set_actor $COLUBIAN_GUARD14 z_angle_to 220.0 
011A: set_actor $COLUBIAN_GUARD14 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD14 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD14 weapon_accuracy_to 100 
009A: $COLUBIAN_GUARD15 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -943.0 311.0 -100.0 //guards by 1st columbian block
0173: set_actor $COLUBIAN_GUARD15 z_angle_to 176.0 
011A: set_actor $COLUBIAN_GUARD15 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD15 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD15 weapon_accuracy_to 100 

00A5: $COLUBIAN_CAR2 = create_car #COLUMB at -1035.688 464.0625 -100.0 
0175: set_car $COLUBIAN_CAR2 z_angle_to 194.0 
00A5: $COLUBIAN_CAR3 = create_car #COLUMB at -1033.75 458.875 -100.0 
0175: set_car $COLUBIAN_CAR3 z_angle_to 330.75 

032B: $ROCKET_LAUNCH = create_weapon_pickup #ROCKET type PICKUP_ONCE ammo 1 at -1221.2 340.8 31.05 

while 8121:   not player $PLAYER_CHAR in_zone 'WEE_DAM' 
	wait 0 ms
	gosub @CHECK_PASS_FAIL_CLEAR_WANTED_CAT1
end //while

01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 

while 8057:   not is_player_in_area_3d $PLAYER_CHAR coords -927.375 391.5 50.0 to -1124.25 485.0625 0.0 sphere 0 
	wait 0 ms
	gosub @CHECK_PASS_FAIL_CLEAR_WANTED_CAT1
end //while

01C2: remove_references_to_actor $COLUBIAN_GUARD14 
01C2: remove_references_to_actor $COLUBIAN_GUARD15 
01C3: remove_references_to_car $COLUBIAN_CAR6 
01C3: remove_references_to_car $COLUBIAN_CAR7 

009A: $COLUBIAN_GUARD5 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1037.188 467.875 -100.0 //guards by 2nd columbian block
0173: set_actor $COLUBIAN_GUARD5 z_angle_to 272.0 
011A: set_actor $COLUBIAN_GUARD5 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD5 weapon WEAPONTYPE_M16 ammo 500
02E2: set_actor $COLUBIAN_GUARD5 weapon_accuracy_to 100  

009A: $COLUBIAN_GUARD6 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1035.0 454.75 -100.0 //guards by 2nd columbian block
0173: set_actor $COLUBIAN_GUARD6 z_angle_to 247.0 
011A: set_actor $COLUBIAN_GUARD6 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD6 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD6 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD7 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1087.75 472.0 -100.0 //First guard on tower
0173: set_actor $COLUBIAN_GUARD7 z_angle_to 237.0 
0350: set_actor $COLUBIAN_GUARD7 maintain_position_when_attacked 1 
011A: set_actor $COLUBIAN_GUARD7 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD7 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD7 weapon_accuracy_to 100

009A: $COLUBIAN_GUARD8 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1142.25 445.25 -100.0 //First guard on second tower
0173: set_actor $COLUBIAN_GUARD8 z_angle_to 287.0 
0350: set_actor $COLUBIAN_GUARD8 maintain_position_when_attacked 1 
011A: set_actor $COLUBIAN_GUARD8 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD8 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD8 weapon_accuracy_to 100

00A5: $COLUBIAN_CAR4 = create_car #FLATBED at -1086.063 464.375 -100.0 
0175: set_car $COLUBIAN_CAR4 z_angle_to 215.0 
00A5: $COLUBIAN_CAR5 = create_car #FLATBED at -1174.75 406.875 -100.0 
0175: set_car $COLUBIAN_CAR5 z_angle_to 322.0 
00A5: $COLUBIAN_CAR8 = create_car #FLATBED at -1164.188 393.6875 -100.0 
0175: set_car $COLUBIAN_CAR8 z_angle_to 23.75 

009A: $COLUBIAN_GUARD16 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1065.25 453.75 -100.0 //guards by 2nd columbian block
0173: set_actor $COLUBIAN_GUARD16 z_angle_to 289.0 
011A: set_actor $COLUBIAN_GUARD16 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD16 weapon WEAPONTYPE_M16 ammo 500 
0350: set_actor $COLUBIAN_GUARD16 maintain_position_when_attacked 1 
02E2: set_actor $COLUBIAN_GUARD16 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD17 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1066.25 475.75 -100.0 //guards by 2nd columbian block
0173: set_actor $COLUBIAN_GUARD17 z_angle_to 224.0 
011A: set_actor $COLUBIAN_GUARD17 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD17 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD17 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD18 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1104.875 440.0625 -100.0 //On boxes
0173: set_actor $COLUBIAN_GUARD18 z_angle_to 292.0 
011A: set_actor $COLUBIAN_GUARD18 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD18 weapon WEAPONTYPE_M16 ammo 500
02E2: set_actor $COLUBIAN_GUARD18 weapon_accuracy_to 100  

009A: $COLUBIAN_GUARD19 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1125.375 448.75 -100.0 //On boxes
0173: set_actor $COLUBIAN_GUARD19 z_angle_to 272.0 
011A: set_actor $COLUBIAN_GUARD19 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD19 weapon WEAPONTYPE_M16 ammo 500 
0350: set_actor $COLUBIAN_GUARD19 maintain_position_when_attacked 1 
02E2: set_actor $COLUBIAN_GUARD19 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD22 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1159.5 424.1875 -100.0 //By boxes
0173: set_actor $COLUBIAN_GUARD22 z_angle_to 278.0 
011A: set_actor $COLUBIAN_GUARD22 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD22 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD22 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD23 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1170.0 379.875 -100.0 //ground near heli pad
0173: set_actor $COLUBIAN_GUARD23 z_angle_to 309.0 
011A: set_actor $COLUBIAN_GUARD23 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD23 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD23 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD24 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1171.688 384.75 -100.0 //ground near heli pad
0173: set_actor $COLUBIAN_GUARD24 z_angle_to 309.0 
011A: set_actor $COLUBIAN_GUARD24 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD24 weapon WEAPONTYPE_M16 ammo 500 
02E2: set_actor $COLUBIAN_GUARD24 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD26 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1156.75 407.5 -100.0 //ground near heli pad
0173: set_actor $COLUBIAN_GUARD26 z_angle_to 319.0 
011A: set_actor $COLUBIAN_GUARD26 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD26 weapon WEAPONTYPE_M16 ammo 500
02E2: set_actor $COLUBIAN_GUARD26 weapon_accuracy_to 100 

while 8057:   not is_player_in_area_3d $PLAYER_CHAR coords -1111.188 446.0 20.0 to -1221.688 366.5625 30.0 sphere 0
	wait 0 ms
	gosub @CHECK_PASS_FAIL_CLEAR_WANTED_CAT1
end //while

01C3: remove_references_to_car $COLUBIAN_CAR2 
01C3: remove_references_to_car $COLUBIAN_CAR3 

009A: $COLUBIAN_GUARD9 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1183.0 370.875 -100.0 //Below Heli Pad with flame thrower
0173: set_actor $COLUBIAN_GUARD9 z_angle_to 342.0 
011A: set_actor $COLUBIAN_GUARD9 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD9 weapon WEAPONTYPE_FLAMETHROWER ammo 1000 
02E2: set_actor $COLUBIAN_GUARD9 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD10 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at -1204.875 343.0 -100.0 //On heli pad with flame thrower
0173: set_actor $COLUBIAN_GUARD10 z_angle_to 342.0 
011A: set_actor $COLUBIAN_GUARD10 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD10 weapon WEAPONTYPE_FLAMETHROWER ammo 1000 
0350: set_actor $COLUBIAN_GUARD10 maintain_position_when_attacked 1 
02E2: set_actor $COLUBIAN_GUARD10 weapon_accuracy_to 100 

009A: $COLUBIAN_GUARD20 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1188.5 368.0 -100.0 //On heli pad with M16
0173: set_actor $COLUBIAN_GUARD20 z_angle_to 7.0 
011A: set_actor $COLUBIAN_GUARD20 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD20 weapon WEAPONTYPE_M16 ammo 1000 
02E2: set_actor $COLUBIAN_GUARD20 weapon_accuracy_to 100 
0350: set_actor $COLUBIAN_GUARD20 maintain_position_when_attacked 1 

009A: $COLUBIAN_GUARD21 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1176.25 357.0625 -100.0 //On heli pad with AK47
0173: set_actor $COLUBIAN_GUARD21 z_angle_to 58.0 
011A: set_actor $COLUBIAN_GUARD21 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD21 weapon WEAPONTYPE_M16 ammo 1000 
02E2: set_actor $COLUBIAN_GUARD21 weapon_accuracy_to 100 
0350: set_actor $COLUBIAN_GUARD21 maintain_position_when_attacked 1 

009A: $COLUBIAN_GUARD25 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1199.375 334.0625 -100.0 //On heli pad with AK47
0173: set_actor $COLUBIAN_GUARD25 z_angle_to 3.0 
011A: set_actor $COLUBIAN_GUARD21 search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD25 weapon WEAPONTYPE_M16 ammo 1000 
02E2: set_actor $COLUBIAN_GUARD25 weapon_accuracy_to 100 
0350: set_actor $COLUBIAN_GUARD25 maintain_position_when_attacked 1 

009A: $COLUBIAN_GUARD_AMBUSH = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at -1167.25 361.9 -100.0 //On heli pad
0173: set_actor $COLUBIAN_GUARD_AMBUSH z_angle_to -194.0 
011A: set_actor $COLUBIAN_GUARD_AMBUSH search_threat THREAT_PLAYER1 
01B2: give_actor $COLUBIAN_GUARD_AMBUSH weapon WEAPONTYPE_M16 ammo 1000 
02E2: set_actor $COLUBIAN_GUARD_AMBUSH weapon_accuracy_to 100 
0350: set_actor $COLUBIAN_GUARD_AMBUSH maintain_position_when_attacked 1 

009A: $MARIA = create_char PEDTYPE_SPECIAL model #SPECIAL01 at -1201.563 338.5625 -100.0 
02AB: set_actor $MARIA immunities BP 1 FP 1 EP 1 CP 1 MP 1 
0245: set_actor $MARIA walk_style_to ANIM_SEXY_WOMANPED 
022D: set_actor $MARIA to_look_at_player $PLAYER_CHAR 
0173: set_actor $MARIA z_angle_to 339.0 
0223: set_actor $MARIA health_to 10
0004: $MARIA_CREATED_BEFORE = 1 

009A: $CATALINA = create_char PEDTYPE_SPECIAL model #SPECIAL02 at -1182.0 346.0625 -100.0 
02AB: set_actor $CATALINA immunities BP 1 FP 1 EP 1 CP 1 MP 1 
0245: set_actor $CATALINA walk_style_to ANIM_SEXY_WOMANPED 

//SHORT CATALINA ESCAPE CUT SCENE
if
	8118:   not actor $CATALINA dead 
then
	015F: set_camera_position -1190.563 334.375 32.0625 rotation 0.0 0.0 0.0 
	0159: camera_on_ped $MARIA mode FIXED switchstyle JUMP_CUT 
	01B4: set_player $PLAYER_CHAR controllable 0 
	02A3: toggle_widescreen 1 
	03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR 
	then
		0221: set_player $PLAYER_CHAR apply_brakes_to_car 1 
	end

	03CF: load_wav 'C_1' 
	wait 3000 ms 

	if
		8118:   not actor $CATALINA dead 
	then
		0159: camera_on_ped $CATALINA mode FIXED switchstyle INTERPOLATION 
		0239: actor $CATALINA run_to -1163.25 341.1875 
		00BC: print_now 'CAT2_J' duration 3000 ms flag 2  // Get this thing airborne!!
	end

	while 83D0:   not wav_loaded 
		wait 0 ms
	end

	03D1: play_wav
end
 
wait 3000 ms 

02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
02EB: restore_camera_jumpcut 
009B: delete_char $CATALINA 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	0221: set_player $PLAYER_CHAR apply_brakes_to_car 0
end

wait 1000 ms 

if
	8118:   not actor $MARIA dead 
then
	02AB: set_actor $MARIA immunities BP 0 FP 0 EP 0 CP 0 MP 0 
end

if
	8119:   not car $ESCAPE_CHOPPER wrecked 
then
	02AC: set_car $ESCAPE_CHOPPER immunities 0 0 0 0 0 
	03B3: catalina_take_off 
end

if
	8119:   not car $COLUBIAN_CAR5 wrecked 
then
	0129: $COLUBIAN_GUARD11 = create_actor PEDTYPE_GANG_COLOMBIAN #GANG12 in_car $COLUBIAN_CAR5 driverseat 
	01B2: give_actor $COLUBIAN_GUARD11 weapon WEAPONTYPE_M16 ammo 300 
	00AF: set_car_mission $COLUBIAN_CAR5 to MISSION_RAMPLAYER_FARAWAY 
	00AD: set_car_cruise_speed $COLUBIAN_CAR5 to 40.0 
	00AE: set_car_driving_style $COLUBIAN_CAR5 to 3 
	02AC: set_car $COLUBIAN_CAR5 immunities 1 1 0 0 0 
end

while 83B5:   not catalina_shot_down 
	wait 0 ms
	if
		0038:   $COUNTDOWN_CAT1 == 0 
	then
		00BC: print_now 'OUTTIME' duration 5000 ms flag 1  // ~r~Too slow, man, too slow!
		goto @MISSION_FAILED_CAT1
	end
	if
		0118:   actor $MARIA dead
	then
		00BC: print_now 'BITCH_D' duration 5000 ms flag 1  // ~g~Maria's dead!
		goto @MISSION_FAILED_CAT1
	end
	if
		00FC:   player $PLAYER_CHAR 0 $MARIA on_foot radius 10.0 10.0 3.0 
	then
		if
			0038:   $SET_AS_LEADER_BEFORE == 0 
		then
			022F: set_actor $MARIA stop_looking 
			01DF: tie_actor $MARIA to_player $PLAYER_CHAR 
			0004: $SET_AS_LEADER_BEFORE = 1 
		end
	else
		if
			0038:   $SET_AS_LEADER_BEFORE == 1 
		then
			0004: $SET_AS_LEADER_BEFORE = 0 
		end
	end

	if and
		0057:   is_player_in_area_3d $PLAYER_CHAR coords -1142.0 327.75 29.0 to -1215.563 368.375 40.0 sphere 0 
		0038:   $BEEN_ON_HELI_PAD == 0 
	then
		if
			8118:   not actor $COLUBIAN_GUARD10 dead 
		then
			0350: set_actor $COLUBIAN_GUARD10 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD10 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD20 dead 
		then
			0350: set_actor $COLUBIAN_GUARD20 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD20 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD21 dead 
		then
			0350: set_actor $COLUBIAN_GUARD21 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD21 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD25 dead 
		then
			0350: set_actor $COLUBIAN_GUARD25 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD25 kill_player $PLAYER_CHAR 
		end
		0004: $BEEN_ON_HELI_PAD = 1 
	end
	0110: clear_player $PLAYER_CHAR wanted_level 
end //while

:END_OF_GAME

0169: set_fade_color 255 255 255 
016A: fade 0 for 500 ms 
014F: stop_timer $COUNTDOWN_CAT1 
03B4: remove_catalina_heli 

if
	0038:   $MARIA_CREATED_BEFORE == 0 
then
	009A: $MARIA = create_char PEDTYPE_SPECIAL model #SPECIAL01 at -1201.563 338.5625 -100.0 
	02AB: set_actor $MARIA immunities BP 1 FP 1 EP 1 CP 1 MP 1 
	0245: set_actor $MARIA walk_style_to ANIM_SEXY_WOMANPED 
	022D: set_actor $MARIA to_look_at_player $PLAYER_CHAR 
	0173: set_actor $MARIA z_angle_to 339.0 
end

016A: fade 1 for 500 ms

while 8320:   not actor $MARIA in_range_of_player $PLAYER_CHAR 
	wait 0 ms
	if
		0118:   actor $MARIA dead 
	then
		00BC: print_now 'BITCH_D' duration 5000 ms flag 1  // ~g~Maria's dead!
		goto @MISSION_FAILED_CAT1
	end
	if
		8320:   not actor $MARIA in_range_of_player $PLAYER_CHAR 
	then
		if
			0038:   $ADDED_THE_BLIP_FOR_MARIA == 0 
		then
			0187: $MARIAS_BLIP = create_marker_above_actor $MARIA 
			0004: $ADDED_THE_BLIP_FOR_MARIA = 1 
		end
	else
		if
			0038:   $ADDED_THE_BLIP_FOR_MARIA == 1 
		then
			0004: $ADDED_THE_BLIP_FOR_MARIA = 0 
		end
	end
	if and
		0057:   is_player_in_area_3d $PLAYER_CHAR coords -1142.0 327.75 29.0 to -1215.563 368.375 40.0 sphere 0 
		0038:   $BEEN_ON_HELI_PAD == 0 
	then
		if
			8118:   not actor $COLUBIAN_GUARD10 dead 
		then
			0350: set_actor $COLUBIAN_GUARD10 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD10 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD20 dead 
		then
			0350: set_actor $COLUBIAN_GUARD20 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD20 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD21 dead 
		then
			0350: set_actor $COLUBIAN_GUARD21 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD21 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $COLUBIAN_GUARD25 dead 
		then
			0350: set_actor $COLUBIAN_GUARD25 maintain_position_when_attacked 0 
			01CC: actor $COLUBIAN_GUARD25 kill_player $PLAYER_CHAR 
		end
		0004: $BEEN_ON_HELI_PAD = 1 
	end
	0110: clear_player $PLAYER_CHAR wanted_level 
end //while

0006: 16@ = 0 

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		001B:   5000 > 16@  //	if player is not in control after 5 secs do the cutscene anyway
	jf break
	wait 0 ms
	if
		0118:   actor $MARIA dead 
	then
		00BC: print_now 'BITCH_D' duration 5000 ms flag 1  // ~g~Maria's dead!
		goto @MISSION_FAILED_CAT1
	end
end //while

//END OF GAME CUT_SCENE*******************************************************************************************

03EF: player $PLAYER_CHAR make_safe 
0110: clear_player $PLAYER_CHAR wanted_level 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
0006: 16@ = 0 
01B6: set_weather WEATHER_SUNNY 

while 001B:   1500 > 16@ 
	wait 0 ms
end

023C: load_special_actor 'MARIA' as 1 

while 823D:   not special_actor 1 loaded 
	wait 0 ms
end

02E4: load_cutscene_data 'END' 
0451: load_end_of_game_audio 
0244: set_cutscene_pos -1031.75 451.75 22.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_MARIA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_MARIA 'MARIA'

if
	8118:   not actor $COLUBIAN_GUARD8 dead 
then
	0223: set_actor $COLUBIAN_GUARD8 health_to 0 
end

016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
043F: play_cutscene_music 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   5507 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_A' duration 10000 ms flag 2  // Residents in Cedar Grove have been coming to terms
while 001A:   7855 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_B' duration 10000 ms flag 2  // with the emotional aftermath of a full blown war
while 001A:   10313 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_C' duration 10000 ms flag 2  // that hit the area yesterday.
while 001A:   13610 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_D' duration 10000 ms flag 2  // Local resident, Clive Denver described to police
while 001A:   16428 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_E' duration 10000 ms flag 2  // a single gunman that he saw fleeing the scene, with a dark haired woman.
while 001A:   20514 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_F' duration 10000 ms flag 2  // Oh, you know, we're gonna have such fun, 'cos you know, you know,
while 001A:   22827 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_G' duration 10000 ms flag 2  // I love you, I, I, I, I really do, 'cos you're such a big strong man
while 001A:   26173 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_H' duration 10000 ms flag 2  // and that's just what I need.
while 001A:   28028 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_I' duration 10000 ms flag 2  // Anyway, what was I saying?
while 001A:   29276 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_J' duration 10000 ms flag 2  // Oh, you know, I forget. But you know what it's like, don't you?
while 001A:   31901 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_K' duration 10000 ms flag 2  // The sound of explosions shook nearby homes as people ran for cover.
while 001A:   35772 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_L' duration 10000 ms flag 2  // Several citizens were injured in the panic as ground fire was exchanged
while 001A:   38820 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_M' duration 10000 ms flag 2  // between ground forces and a helicopter circling the dam.
while 001A:   42136 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_N' duration 10000 ms flag 2  // Yeah, we got a good view from down here in the gardens.
while 001A:   44646 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_O' duration 10000 ms flag 2  // When the 'copter finally got taken out,
while 001A:   46971 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_P' duration 10000 ms flag 2  // better than the fireworks on the 4th of July.
while 001A:   49254 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_Q' duration 10000 ms flag 2  // With the death toll already over twenty,
while 001A:   51621 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_R' duration 10000 ms flag 2  // police are still finding bodies.
while 001A:   54000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_S' duration 10000 ms flag 2  // There have been no official denials concerning rumours
while 001A:   56584 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_T' duration 10000 ms flag 2  // that the dead were members of the Colombian Cartel,
while 001A:   59278 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'END_U' duration 4000 ms flag 2  // and still no leads as to the cause of the massacre.
while 001A:   66666 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

043C: set_game_sounds_fade 0 
0169: set_fade_color 1 1 1 
016A: fade 0 for 2000 ms 

while fading
	wait 0 ms
end

while 82E9:   not cutscene_reached_end 
	wait 0 ms
end

00BE: clear_prints 
02EA: end_cutscene 

gosub @MISSION_START_CREDITS

goto @MISSION_PASSED_CAT1

/////////////////////////////////////////

:CHECK_PASS_FAIL_CLEAR_WANTED_CAT1
if
	0038:   $COUNTDOWN_CAT1 == 0 
then
	00BC: print_now 'OUTTIME' duration 5000 ms flag 1  // ~r~Too slow, man, too slow!
	goto @MISSION_FAILED_CAT1
end
if
	03B5:   catalina_shot_down 
then
	goto @END_OF_GAME
end
0110: clear_player $PLAYER_CHAR wanted_level 
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_CAT1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
if
	8118:   not actor $MARIA dead 
then
	034F: destroy_actor_with_fade $MARIA
end
goto @MISSION_END_CAT1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_CAT1
0004: $THE_EXCHANGE_COMPLETED = 1 
0004: $FLAG_ALL_MISSIONS_DONE = 1 
0110: clear_player $PLAYER_CHAR wanted_level 
0318: set_latest_mission_passed 'CAT2'  // 'THE EXCHANGE'
030C: set_mission_points += 1 
0164: disable_marker $COLUMBIAN_MANSION_MARKER 
014C: set_parked_car_generator $SPECIAL_TANK cars_to_generate_to 101 
034C: shoreside_complete 
goto @MISSION_END_CAT1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_CAT1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_CATALINA = 0 
0249: release_model #GANG11 
0249: release_model #GANG12 
0249: release_model #COLUMB 
0249: release_model #FLATBED 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0296: unload_special_actor 4 
014F: stop_timer $COUNTDOWN_CAT1 
022A: switch_ped_roads_on -942.5625 337.0 10.0 to -953.5625 361.375 30.0 
0164: disable_marker $BLIP_CAT1 
0164: disable_marker $MARIAS_BLIP 
009B: delete_char $CATALINA 
03B4: remove_catalina_heli 
0215: destroy_pickup $ROCKET_LAUNCH 
0215: destroy_pickup $DEAD_GUARDS_GUN 
0237: set_gang GANG_COLOMBIAN primary_weapon_to WEAPONTYPE_UZI secondary_weapon_to WEAPONTYPE_CHAINGUN 
015C: set_zone_gang_info 'WEE_DAM' DAY 8 0 0 0 0 0 100 0 0 
015C: set_zone_gang_info 'WEE_DAM' NIGHT 5 0 0 0 0 0 100 0 0 
0152: set_zone_car_info 'WEE_DAM' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'WEE_DAM' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
00D8: mission_has_finished  
return

////////////////////////////////////////

// **************************************CREDITS************************************************
:MISSION_START_CREDITS
wait 0 ms
01B4: set_player $PLAYER_CHAR controllable 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
0336: set_player $PLAYER_CHAR visible 0 
03AD: set_rubbish 0 
02A3: toggle_widescreen 1 
0109: player $PLAYER_CHAR money += 1000000 
0434: show_credits 
0006: 16@ = 0 
00C0: set_current_time 2 40
goto @FIRST_CREDITS_LOOP

while 8436:   not reached_end_of_credits 
	wait 0 ms
	if
		0038:   $CAMERA_CUT == 0 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
		end //while

		:FIRST_CREDITS_LOOP
		
		0055: set_player_coordinates $PLAYER_CHAR to -361.875 248.0 -100.0 // Columbian mansion
		015F: set_camera_position -364.375 265.0625 82.8125 rotation 0.0 0.0 0.0 
		0160: point_camera -363.9375 264.1875 82.625 switchstyle JUMP_CUT 
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   30000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 1 
	end

	if
		0038:   $CAMERA_CUT == 1 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		
		0055: set_player_coordinates $PLAYER_CHAR to -1174.25 -7.0 -100.0  // Industrial bit
		015F: set_camera_position -1176.438 -17.6875 75.9375 rotation 0.0 0.0 0.0 
		0160: point_camera -1175.688 -17.0 75.8125 switchstyle JUMP_CUT 
		00C0: set_current_time 5 40 
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   30000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 2 
	end

	if
		0038:   $CAMERA_CUT == 2 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		
		0055: set_player_coordinates $PLAYER_CHAR to -468.6875 -3.25 -100.0  // Projects
		015F: set_camera_position -413.0625 19.25 54.375 rotation 0.0 0.0 0.0 
		0160: point_camera -413.9375 18.9375 54.0 switchstyle JUMP_CUT 
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   30000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 3 
	end

	if
		0038:   $CAMERA_CUT == 3 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while

		0055: set_player_coordinates $PLAYER_CHAR to -855.6875 -717.25 -100.0  // Airport
		015F: set_camera_position -959.5 -656.375 55.4375 rotation 0.0 0.0 0.0 
		0160: point_camera -958.625 -656.875 55.25 switchstyle JUMP_CUT 
		00C0: set_current_time 22 0
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   30000 > 17@ 
			wait 0 ms
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 4 
	end

	if
		0038:   $CAMERA_CUT == 4 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while

		0055: set_player_coordinates $PLAYER_CHAR to -532.6875 -611.6875 43.25  // Bridge
		015F: set_camera_position -571.5625 -611.125 67.5625 rotation 0.0 0.0 0.0 
		0160: point_camera -570.6875 -611.5625 67.4375 switchstyle JUMP_CUT 
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   30000 > 17@ 
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 5 
	end

	if
		0038:   $CAMERA_CUT == 5 
	then
		016A: fade 0 for 1500 ms 
		while fading
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while

		0055: set_player_coordinates $PLAYER_CHAR to -671.5625 -155.875 -100.0  // Twisted Bridge
		015F: set_camera_position -706.5625 -219.0625 25.75 rotation 0.0 0.0 0.0 
		0160: point_camera -706.125 -218.1875 25.6875 switchstyle JUMP_CUT 
		00C0: set_current_time 1 20 
		01B6: set_weather WEATHER_RAINY 
		0006: 17@ = 0 

		while 001B:   20000 > 17@ 
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while

		016A: fade 1 for 1500 ms 
		0006: 17@ = 0

		while 001B:   40000 > 17@ 
			wait 0 ms
			gosub @CHECK_SKIP_BUTTON_CREDITS
			gosub @CHECK_CREDITS_DONE
		end //while
		0004: $CAMERA_CUT = 0 
	end
end //while

// **********************************END OF CAMERA CUTSCENE****************************

:FINAL_FINAL_SCENE

0435: end_credits 
00C0: set_current_time 7 0 
043C: set_game_sounds_fade 1 
016A: fade 0 for 2000 ms 

while fading
	wait 0 ms
end

0336: set_player $PLAYER_CHAR visible 1 
0222: set_player $PLAYER_CHAR health_to 100 
0395: clear_area 1 at -666.75 -1.75 range 18.75 2.0 
0055: set_player_coordinates $PLAYER_CHAR to -666.75 -1.75 -100.0 
03CB: load_scene -666.75 -1.75 19.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
02EB: restore_camera_jumpcut 
03C8: set_camera_directly_before_player 
02A3: toggle_widescreen 0 
wait 2500

016A: fade 1 for 2000 ms 
0440: stop_cutscene_music

while fading
	wait 0 ms
end
return

////////////////////////////////////////

:CHECK_SKIP_BUTTON_CREDITS
if
	0019:   16@ > 40000 
then
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @FINAL_FINAL_SCENE
	end
end
return

////////////////////////////////////////

:CHECK_CREDITS_DONE
if
	0436:   reached_end_of_credits 
then
	goto @FINAL_FINAL_SCENE
end
return
