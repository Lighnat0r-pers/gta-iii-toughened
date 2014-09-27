// *****************************************************************************************
// *****************************************************************************************
// *************************************Frankie Mission 3***********************************
// ***************************************"BOMB DA BASE"************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M16_BOMBDABASEACTII

gosub @MISSION_START_FRANK3
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_FRANK3
end

:MISSION_END_FRANK3
gosub @MISSION_CLEANUP_FRANK3
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_FRANK3
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_FRANK = 1 
0001: wait 0 ms 
0004: $FLAG_ON_FRANKIE3 = 0 
0004: $FLAG_BLOKE_LEAVE_GROUP_FM3 = 0 
0004: $FLAG_BLOKE_IN_AREA_FM3 = 0 
0004: $TIMER_FM3 = 25000 
0004: $FLAG_GUARD1_FM3_DEAD = 0 
0004: $FLAG_GUARD2_FM3_DEAD = 0 
0004: $FLAG_GUARD3_FM3_DEAD = 0 
0004: $FLAG_GUARD4_FM3_DEAD = 0 
0004: $FLAG_GUARD5_FM3_DEAD = 0 
0004: $FLAG_GUARD6_FM3_DEAD = 0 
0004: $FLAG_GUARD7_FM3_DEAD = 0 
0004: $FLAG_GUARD8_FM3_DEAD = 0 
0004: $FLAG_GUARD9_FM3_DEAD = 0 
0004: $FLAG_GUARD10_FM3_DEAD = 0 
0004: $FLAG_GUARD11_FM3_DEAD = 0 
0004: $FLAG_GUARD12_FM3_DEAD = 0 
0004: $FLAG_GOT_MESSAGE_FM3 = 0 
0004: $FLAG_GUARD3_FM3_CREATED = 0 
0004: $FLAG_GUARD4_FM3_CREATED = 0 
0004: $FLAG_GUARD5_FM3_CREATED = 0 
0004: $FLAG_GUARD6_FM3_CREATED = 0 
0004: $FLAG_BLIP_ON_EIGHTBALL_FM3 = 0 
0004: $FLAG_GUARD1_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD2_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD3_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD4_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD5_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD6_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD7_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD8_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD9_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD10_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD11_LOOKING_FOR_8BALL = 0 
0004: $FLAG_GUARD12_LOOKING_FOR_8BALL = 0 
0004: $FLAG_8BALL_ORDERED_AREA1 = 0 
0004: $FLAG_DROP_CRATE_FM3 = 0 
0004: $COUNTER_GUARDS_DEAD_FM3 = 0 
0004: $BLOB_FLAG = 1 
0004: $FLAG_PLAYED_COPS_AUDIO_FM3 = 0 
0004: $FLAG_PLAYED_8BALL_AUDIO_FM3 = 0 
0004: $FLAG_GUN_HELP1_FM3 = 0 
0004: $FLAG_GUN_HELP2_FM3 = 0 
0004: $FLAG_GUN_HELP3_FM3 = 0 
0004: $FLAG_TIMER_FM3 = 0 
0004: $FLAG_TIMER2_FM3 = 0 
0004: $FLAG_TIMER3_FM3 = 0 
0004: $FLAG_TIMER4_FM3 = 0 
0005: $EIGHTBALL_X_FM3 = 0.0 
0005: $EIGHTBALL_Y_FM3 = 0.0 
0005: $EIGHTBALL_Z_FM3 = 0.0 
0004: $FLAG_COLOMB_CAR1_DEAD = 0 
0004: $FLAG_COLOMB_CAR2_DEAD = 0 
0004: $FLAG_AUDIO_COPS_LOADED_FM3 = 0 
0004: $FLAG_TIMER_SET_FM3 = 0 
0004: $FLAG_8BALL_MOVED1 = 0 
0004: $FLAG_8BALL_MOVED2 = 0 
0004: $FLAG_8BALL_MOVED3 = 0 
0004: $FLAG_8BALL_MOVED4 = 0 
0004: $FLAG_8BALL_MOVED5 = 0 
0004: $FLAG_8BALL_MOVED6 = 0 
0004: $FLAG_8BALL_MOVED7 = 0 
0004: $FLAG_8BALL_MOVED8 = 0 
0004: $FLAG_8BALL_MOVED9 = 0 
0004: $FLAG_8BALL_MOVED10 = 0 
0004: $FLAG_8BALL_MOVED11 = 0 
0004: $FLAG_8BALL_MOVED12 = 0 
0004: $FLAG_CAR_MARKED_FM3 = 0 
0004: $FLAG_8BALL_DUCKING_FM3 = 0
if
	0038:   $FLAG_PLAYER_HAD_CUT1_FM3 == 1 
then
	if or
		0038:   $FLAG_TAKEN_MONEY_OFF_FM3 == 1 
		010A:   player $PLAYER_CHAR money > 99999
	then
		goto @PLAYER_HAS_MONEY
	end
end
01B6: set_weather WEATHER_FOGGY

:PLAYER_NOT_GOT_MONEY

0395: clear_area 1 at 1272.563 -95.5625 range -100.0 2.0 

// ************************START OF CUTSCENE TWO "PLAYER NOT GOT THE MONEY"*****************

023C: load_special_actor 'EIGHT2' as 1 
02F3: load_object #CUTOBJ01 'EITDOOR' 
02F3: load_object #CUTOBJ02 'EIGHTH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
0247: request_model #IND_LAND089C 
0247: request_model #MAK_SEMTECH 
0247: request_model #MAK_BOMB01 
038B: load_all_models_now


while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ01 available
		8248:   not model #IND_LAND089C available 
		8248:   not model #MAK_SEMTECH available 
		8248:   not model #MAK_BOMB01 available
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 1271.75 -91.25 13.875 radius 3.0 object #CS8_DOOR 0 
02E4: load_cutscene_data 'S4_BDBA' 
0244: set_cutscene_pos 1272.5 -90.6875 13.75 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_EIGHT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_EIGHT 'EIGHT2' 
02F4: create_cutscene_actor $EIGHT_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_EIGHT 
02F5: set_head_anim $EIGHT_CSHEAD 'EIGHT' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_EITDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_EITDOOR 'EITDOOR' 
0395: clear_area 1 at 1272.563 -95.5625 range -100.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1272.563 -95.5625 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   2849 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8A' duration 10000 ms flag 1  // ~w~Yo my man! Salvatore phoned ahead,
while 001A:   5438 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8B' duration 10000 ms flag 1  // ~w~but a job like this is gonna need a lot of fireworks.
while 001A:   8136 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8C' duration 10000 ms flag 1  // ~w~I'll need $100,000 to cover expenses,
while 001A:   10752 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8D' duration 10000 ms flag 1  // ~w~but you know with me you get a lot of bang for your buck.
while 001A:   13578 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_CC' duration 10000 ms flag 1  // ~w~Come back brother when you have the money.
while 001A:   14964 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'FM3_CC'  // ~w~Come back brother when you have the money.
while 001A:   15666 > $CUT_SCENE_TIME
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
03AD: set_rubbish 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0363: toggle_model_render_at 1271.75 -91.25 13.875 radius 3.0 object #CS8_DOOR 1 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #IND_LAND089C 
0249: release_model #MAK_SEMTECH 
0249: release_model #MAK_BOMB01 

// ************************END OF CUTSCENE TWO "PLAYER NOT GOT THE MONEY********************

0004: $FLAG_PLAYER_HAD_CUT1_FM3 = 1

goto @MISSION_CLEANUP_FRANK3

:PLAYER_HAS_MONEY

0395: clear_area 1 at 1272.563 -95.5625 range -100.0 2.0 

// ********************************START OF CUTSCENE ONE "GOT THE MONEY"********************

023C: load_special_actor 'EIGHT2' as 1 
02F3: load_object #CUTOBJ01 'EITDOOR' 
02F3: load_object #CUTOBJ02 'EIGHTH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'RIFLE' 
02F3: load_object #CUTOBJ05 'CS_BOMB' 
0247: request_model #IND_LAND089C 
0247: request_model #MAK_SEMTECH 
0247: request_model #MAK_BOMB01 
038B: load_all_models_now


while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ04 available 
		8248:   not model #CUTOBJ05 available 
	jf break
	wait 0 ms
end //while


while true
	if or
		8248:   not model #IND_LAND089C available 
		8248:   not model #MAK_SEMTECH available 
		8248:   not model #MAK_BOMB01 available 
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 1271.75 -91.25 13.875 radius 3.0 object #CS8_DOOR 0 
02E4: load_cutscene_data 'S4_BDBB' 
0244: set_cutscene_pos 1272.5 -90.6875 13.75 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_EIGHT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_EIGHT 'EIGHT2' 
02F4: create_cutscene_actor $EIGHT_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_EIGHT 
02F5: set_head_anim $EIGHT_CSHEAD 'EIGHT' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_EITDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_EITDOOR 'EITDOOR' 
02E5: $CS_RIFLE = create_cutscene_object #CUTOBJ04 
02E6: set_cutscene_anim $CS_RIFLE 'RIFLE' 
02E5: $CS_BOMB = create_cutscene_object #CUTOBJ05 
02E6: set_cutscene_anim $CS_BOMB 'CS_BOMB' 
0395: clear_area 1 at 1272.563 -95.5625 range -100.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1272.563 -95.5625 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime

// Displays cutscene text

while 001A:   3123 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8E' duration 10000 ms flag 1  // ~w~Okay, let's do this thing!
while 001A:   4903 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8F' duration 10000 ms flag 1  // ~w~I can set this baby to detonate, but I still can't use a piece with these hands.
while 001A:   8643 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_8G' duration 10000 ms flag 1  // ~w~Here, this rifle should help you pop some heads!
while 001A:   10635 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'FM3_8G'  // ~w~Here, this rifle should help you pop some heads!
while 001A:   17000 > $CUT_SCENE_TIME
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
03AD: set_rubbish 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0363: toggle_model_render_at 1271.75 -91.25 13.875 radius 3.0 object #CS8_DOOR 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 
0249: release_model #IND_LAND089C 
0249: release_model #MAK_SEMTECH 
0249: release_model #MAK_BOMB01 

// ********************************END OF CUTSCENE ONE "GOT THE MONEY"**********************

if
	0038:   $FLAG_TAKEN_MONEY_OFF_FM3 == 0
then
	0109: player $PLAYER_CHAR money += -100000 
	0317: increment_mission_attempts 
	0004: $FLAG_TAKEN_MONEY_OFF_FM3 = 1
end

// *********************************START OF THE MISSION STUFF******************************

0247: request_model #GANG11 
0247: request_model #GANG12 
0247: request_model #BARREL4 
0247: request_model #COLUMB 

while true
	if or
		8248:   not model #GANG12 available 
		8248:   not model #GANG11 available 
		8248:   not model #BARREL4 available 
		8248:   not model #COLUMB available 
	jf break
	wait 0 ms
end //while

015C: set_zone_gang_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0107: $BOAT_BARREL7 = create_object #BARREL4 at 1535.125 -930.75 18.6875 
0107: $BOAT_BARREL8 = create_object #BARREL4 at 1535.125 -929.5625 18.6875
0107: $BOAT_BARREL9 = create_object #BARREL4 at 1535.188 -928.4375 18.6875
0107: $BOAT_BARREL15 = create_object #BARREL4 at 1484.813 -942.75 18.6875
0107: $BOAT_BARREL16 = create_object #BARREL4 at 1483.688 -942.75 18.6875
0107: $BOAT_BARREL17 = create_object #BARREL4 at 1482.5 -942.6875 18.6875
0395: clear_area 1 at 1272.75 -96.5 range -100.0 1.0 
009A: $FRANK3_8BALL = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 1272.75 -96.5 -100.0
0173: set_actor $FRANK3_8BALL z_angle_to 270.0 
01ED: clear_actor $FRANK3_8BALL threat_search 
009F: char_set_idle $FRANK3_8BALL 
01B1: give_player $PLAYER_CHAR weapon WEAPONTYPE_SNIPERRIFLE ammo 30 
01B8: set_player $PLAYER_CHAR armed_weapon_to WEAPONTYPE_SNIPERRIFLE 
01DF: tie_actor $FRANK3_8BALL to_player $PLAYER_CHAR 
018A: $FRANK3_CHECKPOINT1 = create_checkpoint_at 1529.0 -824.0 -100.0 

while fading
	wait 0 ms
	gosub @CHECK_8BALL_STATUS_FRANK3
	gosub @CHECK_8BALL_IN_RANGE_STATUS_FRANK3
end //while

03CF: load_wav 'S3_A' 
0006: 16@ = 0 

while true
	if or
		001B:   7000 > 16@ 
		83D0:   not wav_loaded
	jf break
	wait 0 ms
	gosub @CHECK_8BALL_STATUS_FRANK3
	gosub @CHECK_8BALL_IN_RANGE_STATUS_FRANK3
	if
		0038:   $FLAG_GUN_HELP1_FM3 == 0 
	then
		03E5: text_box 'HELP7_A'  // Press and hold the~h~ ~k~~PED_LOCK_TARGET~ button ~w~to ~h~target~w~ with the sniper rifle.
		0004: $FLAG_GUN_HELP1_FM3 = 1 
	end
end //while

0006: 16@ = 0 

while 001B:   7000 > 16@ 
	wait 0 ms
	gosub @CHECK_8BALL_STATUS_FRANK3
	gosub @CHECK_8BALL_IN_RANGE_STATUS_FRANK3
	if
		0038:   $FLAG_GUN_HELP2_FM3 == 0 
	then
		03E5: text_box 'HELP8_A'  // Press the~h~ ~k~~PED_SNIPER_ZOOM_IN~ button ~w~to ~h~zoom in ~w~with the rifle and the~h~ ~k~~PED_SNIPER_ZOOM_OUT~ button ~w~to ~h~zoom out ~w~again.
		0004: $FLAG_GUN_HELP2_FM3 = 1 
	end
end //while

0006: 16@ = 0 

while 001B:   7000 > 16@ 
	wait 0 ms
	gosub @CHECK_8BALL_STATUS_FRANK3
	gosub @CHECK_8BALL_IN_RANGE_STATUS_FRANK3
	if
		0038:   $FLAG_GUN_HELP3_FM3 == 0 
	then
		03E5: text_box 'HELP9_A'  // Press the~h~ ~k~~PED_FIREWEAPON~ button ~w~to ~h~fire~w~ the sniper rifle.
		0004: $FLAG_GUN_HELP3_FM3 = 1 
	end
end //while

//sets up the default guards on the boat

//guard1 on quayside righthand side of the ramp
009A: $FRANK3_CARTEL1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1524.0 -900.0 -100.0
01BE: set_actor $FRANK3_CARTEL1 to_look_at_spot 1524.0 -887.0 -100.0 
01B2: give_actor $FRANK3_CARTEL1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL1 threat_search 
011A: set_actor $FRANK3_CARTEL1 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL1 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL1 attack_when_provoked 1 
035F: set_actor $FRANK3_CARTEL1 armour_to 500

//guard2 on quayside left side of the ramp
009A: $FRANK3_CARTEL2 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at 1530.0 -901.0 -100.0
01BE: set_actor $FRANK3_CARTEL2 to_look_at_spot 1530.0 -887.0 -100.0 
01B2: give_actor $FRANK3_CARTEL2 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL2 threat_search 
011A: set_actor $FRANK3_CARTEL2 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL2 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL2 attack_when_provoked 1 

//guard3 on boat left hand side by exploding creates
009A: $FRANK3_CARTEL3 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1534.563 -936.75 18.375 //follows route 0
01E2: add_route_point 0 at 1533.875 -926.0 -100.0 
01E2: add_route_point 0 at 1534.563 -936.75 -100.0 
01E1: set_actor $FRANK3_CARTEL3 follow_route 0 3 
01B2: give_actor $FRANK3_CARTEL3 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL3 threat_search 
011A: set_actor $FRANK3_CARTEL3 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL3 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL3 attack_when_provoked 1 

//guard4 on boat walks behind the large containers towards the rear of the shop
009A: $FRANK3_CARTEL4 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at 1510.188 -941.6875 18.375 //follows route 1
01E2: add_route_point 1 at 1527.5 -942.875 -100.0 
01E2: add_route_point 1 at 1510.188 -941.6875 -100.0 
01E1: set_actor $FRANK3_CARTEL4 follow_route 1 3 
01B2: give_actor $FRANK3_CARTEL4 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL4 threat_search 
011A: set_actor $FRANK3_CARTEL4 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL4 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL4 attack_when_provoked 1

//guard5 on boat just behind the first row of boxes 
009A: $FRANK3_CARTEL5 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1502.563 -926.6875 -100.0 //follows route 2
01E2: add_route_point 2 at 1512.188 -927.5625 -100.0 
01E2: add_route_point 2 at 1502.563 -926.6875 -100.0 
01E1: set_actor $FRANK3_CARTEL5 follow_route 2 3 
01B2: give_actor $FRANK3_CARTEL5 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL5 threat_search 
011A: set_actor $FRANK3_CARTEL5 search_threat THREAT_PLAYER1 
011A: set_actor $FRANK3_CARTEL5 search_threat THREAT_SPECIAL 
0243: set_actor $FRANK3_CARTEL5 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL5 attack_when_provoked 1 
035F: set_actor $FRANK3_CARTEL5 armour_to 500

//guard6 on boat by the rail of the boat
009A: $FRANK3_CARTEL6 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at 1472.5 -917.6875 -100.0 //follows route 3
01E2: add_route_point 3 at 1507.063 -918.6875 -100.0 
01E2: add_route_point 3 at 1472.5 -917.6875 -100.0 
01E1: set_actor $FRANK3_CARTEL6 follow_route 3 3 
01B2: give_actor $FRANK3_CARTEL6 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL6 threat_search 
011A: set_actor $FRANK3_CARTEL6 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL6 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL6 attack_when_provoked 1 

//guard7 on boat end of large boxes by crate 4
009A: $FRANK3_CARTEL7 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1500.25 -922.1875 -100.0 //follows route 4
01E2: add_route_point 4 at 1499.063 -943.6875 -100.0 
01E2: add_route_point 4 at 1500.25 -922.1875 -100.0 
01E1: set_actor $FRANK3_CARTEL7 follow_route 4 3 
01B2: give_actor $FRANK3_CARTEL7 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL7 threat_search 
011A: set_actor $FRANK3_CARTEL7 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL7 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL7 attack_when_provoked 1 

//Guard8 between second last container and crates 5,6 and 7
009A: $FRANK3_CARTEL8 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1489.5 -955.75 -100.0 //follows route 5
01E2: add_route_point 5 at 1490.188 -924.75 -100.0 
01E2: add_route_point 5 at 1489.5 -955.75 -100.0 
01E1: set_actor $FRANK3_CARTEL8 follow_route 5 3 
01B2: give_actor $FRANK3_CARTEL8 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL8 threat_search 
011A: set_actor $FRANK3_CARTEL8 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL8 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL8 attack_when_provoked 1 

//guard9 stands on top of crate6 does not patrol
009A: $FRANK3_CARTEL9 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG12 at 1484.375 -930.5 19.75
01BE: set_actor $FRANK3_CARTEL9 to_look_at_spot 1487.75 -925.5625 -100.0 
01B2: give_actor $FRANK3_CARTEL9 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL9 threat_search 
011A: set_actor $FRANK3_CARTEL9 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL9 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL9 attack_when_provoked 1 

//guard10 walks from right hand side boat door to behind containers and back again
009A: $FRANK3_CARTEL10 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1476.75 -950.875 -100.0 //follows route 6
01E2: add_route_point 6 at 1476.75 -950.875 -100.0 
01E2: add_route_point 6 at 1476.75 -927.1875 -100.0 
01E1: set_actor $FRANK3_CARTEL10 follow_route 6 3 
01B2: give_actor $FRANK3_CARTEL10 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL10 threat_search 
011A: set_actor $FRANK3_CARTEL10 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL10 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL10 attack_when_provoked 1 
035F: set_actor $FRANK3_CARTEL10 armour_to 500

//guard11 on boat top right of the gang plank
009A: $FRANK3_CARTEL11 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1524.0 -919.0 -100.0
01BE: set_actor $FRANK3_CARTEL11 to_look_at_spot 1525.0 -897.0 -100.0 
01B2: give_actor $FRANK3_CARTEL11 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL11 threat_search 
011A: set_actor $FRANK3_CARTEL11 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL11 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL11 attack_when_provoked 1 

//guard12 on boat top left hand side of the gang plank
009A: $FRANK3_CARTEL12 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 1529.0 -919.0 -100.0
01BE: set_actor $FRANK3_CARTEL12 to_look_at_spot 1525.0 -897.0 -100.0 
01B2: give_actor $FRANK3_CARTEL12 weapon WEAPONTYPE_CHAINGUN ammo 30000 
01ED: clear_actor $FRANK3_CARTEL12 threat_search 
011A: set_actor $FRANK3_CARTEL12 search_threat THREAT_PLAYER1 
0243: set_actor $FRANK3_CARTEL12 ped_stats_to PEDSTAT_TOUGH_GUY 
0291: set_actor $FRANK3_CARTEL12 attack_when_provoked 1 

00A5: $CAR_COLUMB1_FM3 = create_car #COLUMB at 1534.375 -891.5 10.75
0175: set_car $CAR_COLUMB1_FM3 z_angle_to 90.0 
00A5: $CAR_COLUMB2_FM3 = create_car #COLUMB at 1515.688 -896.25 10.75
0175: set_car $CAR_COLUMB2_FM3 z_angle_to 314.0 


// waiting for the boat to be destroyed

0004: $BLOB_FLAG = 1 

while 8038:   not  $FLAG_BLOKE_IN_AREA_FM3 == 13 
	wait 0 ms
	gosub @CAR_DEAD_CHECK
	gosub @GUARD_DEATH_CHECK
	if and
		0038:   $FLAG_BLOKE_LEAVE_GROUP_FM3 == 0 
		0018:   $COUNTER_GUARDS_DEAD_FM3 > 0 
	then
		00BC: print_now 'FM3_8' duration 5000 ms flag 1  // ~r~The guards have been alerted!
		goto @MISSION_FAILED_FRANK3
	end
	gosub @CHECK_8BALL_STATUS_FRANK3
	00A0: get_char_coordinates $FRANK3_8BALL store_to $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3
	if
		0038:   $FLAG_BLOKE_LEAVE_GROUP_FM3 == 0 
	then
		gosub @CHECK_8BALL_IN_RANGE_STATUS_FRANK3
	end
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR
	then
		00DA: $CAR_FM3 = store_car_player_is_in $PLAYER_CHAR 
	end
	gosub @CHECK_8BALL_STATUS_FRANK3
	if
		0038:   $FLAG_BLOKE_LEAVE_GROUP_FM3 == 0
	then
		if and
			00E6:   player $PLAYER_CHAR stopped $BLOB_FLAG 1529.0 -824.0 radius 3.0 4.0 
			00EF:   actor $FRANK3_8BALL sphere 1 1529.0 -824.0 radius 3.0 4.0 
			0038:   $FLAG_BLOKE_LEAVE_GROUP_FM3 == 0
		then
			0164: disable_marker $FRANK3_CHECKPOINT1 
			01E0: clear_leader $FRANK3_8BALL 
			0004: $FLAG_BLOKE_LEAVE_GROUP_FM3 = 1 
			02A3: toggle_widescreen 1 
			01B4: set_player $PLAYER_CHAR controllable 0 
			01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
			03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1
			if and
				0038:   $FLAG_GOT_MESSAGE_FM3 == 0 
				0038:   $FLAG_BLOKE_LEAVE_GROUP_FM3 == 1
			then
				if
					0038:   $FLAG_PLAYED_8BALL_AUDIO_FM3 == 0
				then
					03D1: play_wav 
					0004: $FLAG_PLAYED_8BALL_AUDIO_FM3 = 1
				end
				00BC: print_now 'FM3_8I' duration 5000 ms flag 1  // ~w~Get a good vantage point then I'll head in when you fire the first shot.
				018A: $RADAR_BLIP_COORD3_FM3 = create_checkpoint_at 1498.688 -870.5 -100.0 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 1 
				0004: $FLAG_GOT_MESSAGE_FM3 = 1 
			end
			while 83D2:   not wav_ended
				wait 0 ms
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while
			
			 // Camera looks at the boat and guards	

			015F: set_camera_position 1543.0 -877.75 16.8125 0.0 rotation 0.0 0.0 
			0160: point_camera 1542.375 -878.5625 16.75 switchstyle JUMP_CUT
			if
				0038:   $FLAG_TIMER_FM3 == 0 
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_FM3 = 1 
			end

			while 002B:   5000 >= 16@ 
				wait 0 ms
				if
					00E1:   is_button_pressed PAD1 button CROSS
				then
					goto @CAMERA_JUMP_FRANK3 
				end
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while

			0395: clear_area 0 at 1536.75 -895.0 range 10.75 1.0 
			015F: set_camera_position 1537.063 -899.75 12.5 0.0 rotation 0.0 0.0 
			0160: point_camera 1536.375 -900.375 12.6875 switchstyle JUMP_CUT
			if and
				0038:   $FLAG_TIMER_FM3 == 1 
				0038:   $FLAG_TIMER2_FM3 == 0
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER2_FM3 = 1 
			end

			while 002B:   5000 >= 16@ 
				wait 0 ms
				if
					00E1:   is_button_pressed PAD1 button CROSS
				then
					goto @CAMERA_JUMP_FRANK3 
				end
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while

			0395: clear_area 0 at 1522.813 -916.125 range 19.5625 1.0 
			015F: set_camera_position 1522.813 -916.125 19.5625 0.0 rotation 0.0 0.0 
			0160: point_camera 1521.938 -916.625 19.6875 switchstyle JUMP_CUT
			if and
				0038:   $FLAG_TIMER2_FM3 == 1 
				0038:   $FLAG_TIMER3_FM3 == 0
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER3_FM3 = 1 
			end

			while 002B:   5000 >= 16@ 
				wait 0 ms
				if
					00E1:   is_button_pressed PAD1 button CROSS
				then
					goto @CAMERA_JUMP_FRANK3 
				end
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while

			0395: clear_area 0 at 1476.25 -922.6875 range 19.0 1.0 
			015F: set_camera_position 1476.25 -922.6875 19.0 0.0 rotation 0.0 0.0 
			0160: point_camera 1477.063 -923.25 19.0625 switchstyle JUMP_CUT
			if and
				0038:   $FLAG_TIMER3_FM3 == 1 
				0038:   $FLAG_TIMER4_FM3 == 0
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER4_FM3 = 1 
			end

			while 002B:   5000 >= 16@ 
				wait 0 ms
				if
					00E1:   is_button_pressed PAD1 button CROSS
				then
					goto @CAMERA_JUMP_FRANK3 
				end
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while

			:CAMERA_JUMP_FRANK3

			02EB: restore_camera_jumpcut
			gosub @CAR_DEAD_CHECK
			gosub @GUARD_DEATH_CHECK
			gosub @CLEAR_AREA_CHECK
			gosub @CHECK_8BALL_STATUS_FRANK3

			// checks to see if the player is in a vehicle
			if
				00DF:   is_char_in_any_car $FRANK3_8BALL 
			then
				00D9: $CAR_FM3 = store_car_char_is_in $FRANK3_8BALL
				while 81C1:   not car $CAR_FM3 stopped
					wait 0 ms
					gosub @CAR_DEAD_CHECK
					gosub @GUARD_DEATH_CHECK
					gosub @CLEAR_AREA_CHECK
					gosub @CHECK_8BALL_STATUS_FRANK3
					gosub @CHECK_VEHICLE_STATUS_FRANK3
				end //while

				wait 0 ms
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
				gosub @CHECK_VEHICLE_STATUS_FRANK3

				01D3: actor $FRANK3_8BALL leave_car $CAR_FM3 
				while 00DB:   is_char_in_car $FRANK3_8BALL car $CAR_FM3 
					wait 0 ms
					gosub @CAR_DEAD_CHECK
					gosub @GUARD_DEATH_CHECK
					gosub @CLEAR_AREA_CHECK
					gosub @CHECK_8BALL_STATUS_FRANK3
					gosub @CHECK_VEHICLE_STATUS_FRANK3
				end //while
			end
			02A3: toggle_widescreen 0 
			01B4: set_player $PLAYER_CHAR controllable 1 
			01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
			03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
		end
	end

	// tells players mate to go to his stageing area
	if
		001A:   13 > $FLAG_BLOKE_IN_AREA_FM3 
	then
		gosub @CAR_DEAD_CHECK
		gosub @GUARD_DEATH_CHECK
		gosub @CLEAR_AREA_CHECK
		if
			00F6:   player $PLAYER_CHAR 0 1498.688 -870.5 26.75 radius 3.0 3.0 2.0
		then
			0164: disable_marker $RADAR_BLIP_COORD3_FM3 
		end
		if and
			0038:   $FLAG_PLAYED_8BALL_AUDIO_FM3 == 1 
			0038:   $FLAG_PLAYED_COPS_AUDIO_FM3 == 0
			03D2:   wav_ended
		then
			03D5: remove_text 'FM3_8I'  // ~w~Get a good vantage point then I'll head in.
		end
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 1 
		then
			if
				0038:   $FLAG_8BALL_ORDERED_AREA1 == 0 
			then
				0239: actor $FRANK3_8BALL run_to 1545.875 -867.6875 
				0006: 16@ = 0 
				0004: $FLAG_8BALL_ORDERED_AREA1 = 1 
			end
			if and
				0038:   $FLAG_8BALL_MOVED1 == 0 
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1545.875 -867.6875 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1545.875 -867.6875 10.75 
				0004: $FLAG_8BALL_MOVED1 = 1 
			end
			if and
				0038:   $FLAG_8BALL_DUCKING_FM3 == 0 
				00ED:   actor $FRANK3_8BALL #NULL 1545.875 -867.6875 radius 1.0 1.0
			then
				0004: $FLAG_8BALL_MOVED1 = 1 
				0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 10000 ms
				0004: $FLAG_8BALL_DUCKING_FM3 = 1
			end
			0006: 17@ = 0
			while 001B:   5000 > 17@ 
				wait 0 ms
				gosub @CAR_DEAD_CHECK
				gosub @GUARD_DEATH_CHECK
				gosub @CLEAR_AREA_CHECK
				gosub @CHECK_8BALL_STATUS_FRANK3
			end //while
			0004: $FLAG_BLOKE_IN_AREA_FM3 = 2 
			if
				0038:   $FLAG_CAR_MARKED_FM3 == 0
			then
				01C3: remove_references_to_car $CAR_COLUMB1_FM3 
				01C3: remove_references_to_car $CAR_COLUMB2_FM3 
				0004: $FLAG_CAR_MARKED_FM3 = 1 
			end
		end

		// Bottom of boat ramp
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2
		then
			0239: actor $FRANK3_8BALL run_to 1527.0 -899.0 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 0
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1527.0 -899.0 radius 2.0 2.0 
			then
				0004: $FLAG_8BALL_MOVED2 = 1 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 3 
			end
			if and
				0038:   $FLAG_8BALL_MOVED2 == 0
				0029:   16@ >= 20000
				80ED:   not actor $FRANK3_8BALL #NULL 1527.0 -899.0 radius 2.0 2.0
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1527.0 -899.0 10.75 
				0004: $FLAG_8BALL_MOVED2 = 1 
			end
		end

		// Top of the boat ramp
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 3
		then
			0239: actor $FRANK3_8BALL run_to 1526.0 -919.0  
			if
				0038:   $FLAG_TIMER_SET_FM3 == 1
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 2
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1526.0 -919.0  radius 2.0 2.0 
			then
				0004: $FLAG_8BALL_MOVED3 = 1 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 4 
			end
			if and
				0038:   $FLAG_8BALL_MOVED3 == 0
				0029:   16@ >= 20000
				80ED:   not actor $FRANK3_8BALL #NULL 1526.0 -919.0 radius 2.0 2.0
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1526.0 -919.0 18.375 
				0004: $FLAG_8BALL_MOVED3 = 1 
			end
		end

		// crate one on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 4
		then
			0239: actor $FRANK3_8BALL run_to 1522.875 -924.25   
			if
				0038:   $FLAG_TIMER_SET_FM3 == 2
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 3
			end
			if and
				0038:   $FLAG_8BALL_MOVED4 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1522.875 -924.25 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1522.875 -924.25 18.375
				0004: $FLAG_8BALL_MOVED4 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1522.875 -924.25 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED4 = 1 
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 1
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 2 
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 5 

			end
		end
		
		// Crate two on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5
		then
			0239: actor $FRANK3_8BALL run_to 1517.0 -929.0 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 3
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 4
			end
			if and
				0038:   $FLAG_8BALL_MOVED5 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1517.0 -929.0 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1517.0 -929.0 18.375
				0004: $FLAG_8BALL_MOVED5 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1517.0 -929.0 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED5 = 1 
				03CF: load_wav 'S3_B'
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 2
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 3
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 6
				if
					03D0:   wav_loaded 
				then
					0004: $FLAG_AUDIO_COPS_LOADED_FM3 = 1
				end
				if and
					0038:   $FLAG_PLAYED_COPS_AUDIO_FM3 == 0 
					0038:   $FLAG_AUDIO_COPS_LOADED_FM3 == 1 
				then
					03D1: play_wav 
					0004: $FLAG_PLAYED_COPS_AUDIO_FM3 = 1 
				end
			end
		end

		// Crate three on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 6
		then
			0239: actor $FRANK3_8BALL run_to 1510.0 -923.0 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 4
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 5
			end
			if and
				0038:   $FLAG_8BALL_MOVED6 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1510.0 -923.0 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1510.0 -923.0 18.375
				0004: $FLAG_8BALL_MOVED6 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1510.0 -923.0 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED6 = 1 
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 3
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 4
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 7
			end
		end

		// Crate four on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 7
		then
			0239: actor $FRANK3_8BALL run_to 1504.375 -928.5625 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 5
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 6
			end
			if and
				0038:   $FLAG_8BALL_MOVED7 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1504.375 -928.5625 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1504.375 -928.5625 18.375
				0004: $FLAG_8BALL_MOVED7 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1504.375 -928.5625 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED7 = 1 
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 4
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 5
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 8
			end
		end

		// Crate five on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 8
		then
			0239: actor $FRANK3_8BALL run_to 1493.688 -922.0625 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 6
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 7
			end
			if and
				0038:   $FLAG_8BALL_MOVED8 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1493.688 -922.0625 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1493.688 -922.0625 18.375
				0004: $FLAG_8BALL_MOVED8 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1493.688 -922.0625 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED8 = 1 
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 5
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 6
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 9
			end
		end

		// Crate six on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 9
		then
			0239: actor $FRANK3_8BALL run_to 1487.0 -930.1875 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 7
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 8
			end
			if and
				0038:   $FLAG_8BALL_MOVED9 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1487.0 -930.1875 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1487.0 -930.1875 18.375
				0004: $FLAG_8BALL_MOVED9 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1487.0 -930.1875 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED9 = 1 
				if
					001A:   12 > $COUNTER_GUARDS_DEAD_FM3 
				then
					if
						0038:   $FLAG_8BALL_DUCKING_FM3 == 6
					then
						0372: set_actor $FRANK3_8BALL anim WAITSTATE_PLAYANIM_DUCK wait_state_time 5000 ms 
						0004: $FLAG_8BALL_DUCKING_FM3 = 7
					end
					0006: 17@ = 0 
					while 001B:   5000 > 17@
						wait 0 ms
						gosub @CAR_DEAD_CHECK
						gosub @GUARD_DEATH_CHECK
						gosub @CLEAR_AREA_CHECK
						gosub @CHECK_8BALL_STATUS_FRANK3
					end //while
				end
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 10
			end
		end

		// just past crate six
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 10
		then
			0239: actor $FRANK3_8BALL run_to 1481.5 -926.75
			if
				0038:   $FLAG_TIMER_SET_FM3 == 8
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 9
			end
			if and
				0038:   $FLAG_8BALL_MOVED10 == 0
				0029:   16@ >= 15000
				80ED:   not actor $FRANK3_8BALL #NULL 1481.5 -926.75 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1481.5 -926.75 18.375
				0004: $FLAG_8BALL_MOVED10 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1481.5 -926.75 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED10 = 1 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 11
			end
		end

		// Outside the door on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 11
		then
			0239: actor $FRANK3_8BALL run_to 1475.75 -940.25
			if
				0038:   $FLAG_TIMER_SET_FM3 == 9
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 10
			end
			if and
				0038:   $FLAG_8BALL_MOVED11 == 0
				0029:   16@ >= 15000
				80ED:   not actor $FRANK3_8BALL #NULL 1475.75 -940.25 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1475.75 -940.25 18.375
				0004: $FLAG_8BALL_MOVED11 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1475.75 -940.25 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED11 = 1 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 12
			end
		end

		// Inside the door on the boat
		if
			0038:   $FLAG_BLOKE_IN_AREA_FM3 == 12
		then
			0239: actor $FRANK3_8BALL run_to 1474.188 -940.1875 
			if
				0038:   $FLAG_TIMER_SET_FM3 == 10
			then
				0006: 16@ = 0 
				0004: $FLAG_TIMER_SET_FM3 = 11
			end
			if and
				0038:   $FLAG_8BALL_MOVED12 == 0
				0029:   16@ >= 25000
				80ED:   not actor $FRANK3_8BALL #NULL 1474.188 -940.1875 radius 1.0 1.0 
			then
				00A1: set_char_coordinates $FRANK3_8BALL to 1474.188 -940.1875 18.375
				0004: $FLAG_8BALL_MOVED12 = 1 
			end
			if
				00ED:   actor $FRANK3_8BALL #NULL 1474.188 -940.1875 radius 1.0 1.0 
			then
				0004: $FLAG_8BALL_MOVED12 = 1 
				009F: char_set_idle $FRANK3_8BALL 
				0004: $FLAG_BLOKE_IN_AREA_FM3 = 13 
				0006: 17@ = 0
				while 001B:   3000 > 17@
					wait 0 ms
					gosub @CAR_DEAD_CHECK
					gosub @GUARD_DEATH_CHECK
					gosub @CLEAR_AREA_CHECK
					gosub @CHECK_8BALL_STATUS_FRANK3
				end //while
			end
		end
	end
end //while

// *********waiting for 8ball to place the bomb and then he legs it off of the boat********

0006: 16@ = 0 
while 001B:   3000 > 16@ 
	wait 0 ms
	gosub @CAR_DEAD_CHECK
	gosub @GUARD_DEATH_CHECK
	gosub @CHECK_8BALL_STATUS_FRANK3
end //while

// ***********************************BOAT BLOWING UP CUTSCENE******************************

01BD: $PRE_CUTSCENE_START_TIME = current_time_in_ms 
0004: $PRE_CUTSCENE_ELAPSED_TIME = 0 

while true
	if and
		83EE:   not player $PLAYER_CHAR controllable 
		001A:   5000 > $PRE_CUTSCENE_ELAPSED_TIME
	jf break
	wait 0 ms
	gosub @CHECK_8BALL_STATUS_FRANK3
	01BD: $PRE_CUTSCENE_CURRENT_TIME = current_time_in_ms 
	0084: $PRE_CUTSCENE_ELAPSED_TIME = $PRE_CUTSCENE_CURRENT_TIME 
	0060: $PRE_CUTSCENE_ELAPSED_TIME -= $PRE_CUTSCENE_START_TIME
end //while

03EF: player $PLAYER_CHAR make_safe 
0169: set_fade_color 0 0 0 
016A: fade 0 for 1500 ms 
03AF: set_streaming 0 
02F3: load_object #CUTOBJ01 'SHIP' 
02F3: load_object #CUTOBJ02 'GANGP' 

while fading
	wait 0 ms
end

034F: destroy_actor_with_fade $FRANK3_CARTEL1 
034F: destroy_actor_with_fade $FRANK3_CARTEL2 
034F: destroy_actor_with_fade $FRANK3_CARTEL3 
034F: destroy_actor_with_fade $FRANK3_CARTEL4 
034F: destroy_actor_with_fade $FRANK3_CARTEL5 
034F: destroy_actor_with_fade $FRANK3_CARTEL6 
034F: destroy_actor_with_fade $FRANK3_CARTEL7 
034F: destroy_actor_with_fade $FRANK3_CARTEL8 
034F: destroy_actor_with_fade $FRANK3_CARTEL9 
034F: destroy_actor_with_fade $FRANK3_CARTEL10 
034F: destroy_actor_with_fade $FRANK3_CARTEL11 
034F: destroy_actor_with_fade $FRANK3_CARTEL12 
0395: clear_area 1 at 1519.0 -934.5625 range 18.375 25.0 
0108: destroy_object $BOAT_BARREL7 
0108: destroy_object $BOAT_BARREL8 
0108: destroy_object $BOAT_BARREL9 
0108: destroy_object $BOAT_BARREL15 
0108: destroy_object $BOAT_BARREL16 
0108: destroy_object $BOAT_BARREL17 
038B: load_all_models_now

while true
	if or
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
	jf break
	wait 0 ms
end //while

// Swaps boat for building lod then sets boat lod to invisible
0363: toggle_model_render_at 1508.75 -937.1875 20.625 radius 50.0 object #RUSTSHIP_STRUCTURE 0 
03B6: replace_model_at 1508.75 -937.1875 20.625 radius 50.0 from #RUSTSHIP_STRUCTURE to #LOD_LAND014 
0363: toggle_model_render_at 1508.75 -937.1875 20.625 radius 50.0 object #LODTSHIP_STRUCTURE 0 
0363: toggle_model_render_at 1526.75 -907.375 14.25 radius 50.0 object #BOATRAMP1 0 
03B6: replace_model_at 1526.75 -907.375 14.25 radius 50.0 from #BOATRAMP1 to #LOD_LAND014 
02E4: load_cutscene_data 'S4_BDBD' 
0244: set_cutscene_pos 1573.875 -906.0 11.0625 
02E5: $CUTSCENE_EIGHT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_EIGHT 'EIGHT2' 
02E5: $CS_SHIP = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_SHIP 'SHIP' 
02E5: $CS_GANGPLANK = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_GANGPLANK 'GANGP' 
0395: clear_area 1 at 1526.5 -894.75 range -100.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1526.5 -894.75 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
009B: delete_char $FRANK3_8BALL 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
043A: start_boat_foam_animation 
043B: update_boat $CS_SHIP foam_animation 
02E8: $CUT_SCENE_TIME = cutscenetime

// Displays cutscene text

while 001A:   1433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1478.438 -936.5 20.375
while 001A:   2565 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1479.438 -936.5 20.375 
while 001A:   3433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1481.438 -936.5 20.375 
while 001A:   4433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1487.875 -933.875 20.375 
while 001A:   5833 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1490.688 -928.125 20.375 
while 001A:   6433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1595.5 -921.8125 20.375 
while 001A:   7433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1500.5 -921.8125 20.375 
while 001A:   8433 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1502.5 -921.8125 20.375 
while 001A:   9633 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1510.5 -918.1875 20.375 
while 001A:   12833 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1510.5 -918.1875 20.375 
while 001A:   13000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
end
020C: create_explosion EXPLOSION_HELI at 1518.0 -931.8125 19.375
while 001A:   33333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime
	043B: update_boat $CS_SHIP foam_animation
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
03AD: set_rubbish 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02

// *****************************END OF BOAT BLOWING UP CUTSCENE*****************************

goto @MISSION_PASSED_FRANK3

/////////////////////////////////////////

:CHECK_8BALL_STATUS_FRANK3
if
	0118:   actor $FRANK3_8BALL dead 
then
	00BC: print_now 'FM3_7' duration 5000 ms flag 1  // ~r~8-Ball's been iced!
	goto @MISSION_FAILED_FRANK3
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_FRANK3
if
	0119:   car $CAR_FM3 wrecked 
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_FRANK3
end
return

/////////////////////////////////////////

:CHECK_8BALL_IN_RANGE_STATUS_FRANK3
if and
	8320:   not actor $FRANK3_8BALL in_range_of_player $PLAYER_CHAR 
	0038:   $FLAG_BLIP_ON_EIGHTBALL_FM3 == 0
then
	00BC: print_now 'HEY3' duration 5000 ms flag 1  // ~g~You've dropped your main man, go back and get 8-Ball!
	0187: $FRANK3_8BALL_MARKER = create_marker_above_actor $FRANK3_8BALL 
	0164: disable_marker $FRANK3_CHECKPOINT1 
	0004: $BLOB_FLAG = 0 
	0004: $FLAG_BLIP_ON_EIGHTBALL_FM3 = 1
end
if and
	00E9:   player $PLAYER_CHAR 0 $FRANK3_8BALL radius 8.0 8.0 
	0038:   $FLAG_BLIP_ON_EIGHTBALL_FM3 == 1 
then
	01DF: tie_actor $FRANK3_8BALL to_player $PLAYER_CHAR 
	0164: disable_marker $FRANK3_8BALL_MARKER 
	018A: $FRANK3_CHECKPOINT1 = create_checkpoint_at 1529.0 -824.0 -100.0 
	0004: $BLOB_FLAG = 1 
	0004: $FLAG_BLIP_ON_EIGHTBALL_FM3 = 0
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_FRANK3
017A: set_player $PLAYER_CHAR weapon WEAPONTYPE_SNIPERRIFLE ammo_to 0 
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_FRANK3

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_FRANK3
0004: $BOMB_DA_BASE_ACT_II_COMPLETED = 1 
0318: set_latest_mission_passed 'FM3'  // 'BOMB DA BASE: ACT II'
030C: set_mission_points += 1 
01F6: cancel_override_restart 
01E3: text_1number_styled 'M_PASS' number 150000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 150000 
0110: clear_player $PLAYER_CHAR wanted_level 
0164: disable_marker $8BALL_CONTACT_POINT 
0004: $FLAG_FRANKIE_SWITCHED_OFF = 0 
02A7: $SALVATORE_MISSION_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAL at 1455.688 -187.25 -100.0 
004F: create_thread @FRANKIE_MISSION4_LOOP 
goto @MISSION_END_FRANK3

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_FRANK3
01B7: release_weather
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_FRANK = 0 
0004: $FLAG_ON_FRANKIE3 = 0
if
	8118:   not actor $FRANK3_CARTEL1 dead 
then
	0350: set_actor $FRANK3_CARTEL1 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL2 dead 
then
	0350: set_actor $FRANK3_CARTEL2 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL3 dead 
then
	0350: set_actor $FRANK3_CARTEL3 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL4 dead 
then
	0350: set_actor $FRANK3_CARTEL4 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL5 dead 
then
	0350: set_actor $FRANK3_CARTEL5 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL6 dead 
then
	0350: set_actor $FRANK3_CARTEL6 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL7 dead 
then
	0350: set_actor $FRANK3_CARTEL7 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL8 dead 
then
	0350: set_actor $FRANK3_CARTEL8 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL9 dead 
then
	0350: set_actor $FRANK3_CARTEL9 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL10 dead 
then
	0350: set_actor $FRANK3_CARTEL10 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL11 dead 
then
	0350: set_actor $FRANK3_CARTEL11 maintain_position_when_attacked 0
end
if
	8118:   not actor $FRANK3_CARTEL12 dead 
then
	0350: set_actor $FRANK3_CARTEL12 maintain_position_when_attacked 0
end
034F: destroy_actor_with_fade $FRANK3_8BALL 
0249: release_model #GANG11 
0249: release_model #GANG12 
0249: release_model #BARREL4 
01C2: remove_references_to_actor $FRANK3_8BALL 
0249: release_model #COLUMB 
0164: disable_marker $FRANK3_CHECKPOINT1 
0164: disable_marker $RADAR_BLIP_COORD3_FM3 
014F: stop_timer $TIMER_FM3 
03AC: clear_route 0 
03AC: clear_route 1 
03AC: clear_route 2 
03AC: clear_route 3 
03AC: clear_route 4 
03AC: clear_route 5 
03AC: clear_route 6 
015C: set_zone_gang_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 
015C: set_zone_gang_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0152: set_zone_car_info 'PORT_E' NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0108: destroy_object $BOAT_BARREL7 
0108: destroy_object $BOAT_BARREL8 
0108: destroy_object $BOAT_BARREL9 
0108: destroy_object $BOAT_BARREL15 
0108: destroy_object $BOAT_BARREL16 
0108: destroy_object $BOAT_BARREL17 
00D8: mission_has_finished 
return

/////////////////////////////////////////

:GUARD_DEATH_CHECK

//guard1
if
	0038:   $FLAG_GUARD1_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL1 dead
	then
		0004: $FLAG_GUARD1_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD1_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2 
				0038:   $FLAG_GUARD2_FM3_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1
			then
				if
					0038:   $FLAG_COLOMB_CAR2_DEAD == 0
				then
					0239: actor $FRANK3_CARTEL1 run_to 1517.563 -896.5625 
				else
					0239: actor $FRANK3_CARTEL1 run_to 1523.25 -893.6875
				end
				011A: set_actor $FRANK3_CARTEL1 search_threat THREAT_SPECIAL 
				0004: $FLAG_GUARD1_LOOKING_FOR_8BALL = 1 
			end
			if
				0038:   $FLAG_GUARD1_LOOKING_FOR_8BALL == 1
			then
				if
					0038:   $FLAG_COLOMB_CAR2_DEAD == 0
				then
					if
						00FF:   actor $FRANK3_CARTEL1 #NULL 1517.563 -896.5625 10.75 radius 0.5 0.5 2.0 
					then
						0194: set_actor $FRANK3_CARTEL1 objective_to_guard_point 1517.563 -896.5625 10.75 
						0350: set_actor $FRANK3_CARTEL1 maintain_position_when_attacked 1 
						01BE: set_actor $FRANK3_CARTEL1 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3
					end
				else
					if
						00FF:   actor $FRANK3_CARTEL1 #NULL 1523.25 -893.6875 10.75 radius 0.5 0.5 2.0 
					then
						0194: set_actor $FRANK3_CARTEL1 objective_to_guard_point 1523.25 -893.6875 10.75 
						0350: set_actor $FRANK3_CARTEL1 maintain_position_when_attacked 1 
						01BE: set_actor $FRANK3_CARTEL1 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3
					end
				end
			end
		end
	end
end

//guard2
if
	0038:   $FLAG_GUARD2_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL2 dead
	then
		0004: $FLAG_GUARD2_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD2_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2 
				0038:   $FLAG_GUARD1_FM3_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1
			then
				if
					0038:   $FLAG_COLOMB_CAR1_DEAD == 0
				then
					0239: actor $FRANK3_CARTEL2 run_to 1532.875 -893.75
				else
					0239: actor $FRANK3_CARTEL2 run_to 1528.563 -892.1875 
				end
				011A: set_actor $FRANK3_CARTEL2 search_threat THREAT_SPECIAL 
				0004: $FLAG_GUARD2_LOOKING_FOR_8BALL = 1 
			end
			if
				0038:   $FLAG_GUARD2_LOOKING_FOR_8BALL == 1
			then
				if
					0038:   $FLAG_COLOMB_CAR1_DEAD == 0
				then
					if
						00FF:   actor $FRANK3_CARTEL2 #NULL 1532.875 -893.75 10.75 radius 0.5 0.5 2.0 
					then
						0194: set_actor $FRANK3_CARTEL2 objective_to_guard_point 1532.875 -893.75 10.75 
						01BE: set_actor $FRANK3_CARTEL2 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
						0350: set_actor $FRANK3_CARTEL2 maintain_position_when_attacked 1
					end
				else
					if
						00FF:   actor $FRANK3_CARTEL2 #NULL 1528.563 -892.1875 10.75 radius 0.5 0.5 2.0 
					then
						0194: set_actor $FRANK3_CARTEL2 objective_to_guard_point 1528.563 -892.1875 10.75 
						01BE: set_actor $FRANK3_CARTEL2 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
						0350: set_actor $FRANK3_CARTEL2 maintain_position_when_attacked 1 
					end
				end
			end
		end
	end
end

//guard3
if
	0038:   $FLAG_GUARD3_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL3 dead
	then
		0004: $FLAG_GUARD3_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD3_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2 
				0018:   $COUNTER_GUARDS_DEAD_FM3 > 0 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
			then
				011A: set_actor $FRANK3_CARTEL3 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL3 run_to 1534.063 -931.1875 
				0004: $FLAG_GUARD3_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD3_LOOKING_FOR_8BALL == 1
				00FF:   actor $FRANK3_CARTEL3 #NULL 1534.063 -931.1875 18.375 radius 0.5 0.5 2.0 
			then
				0194: set_actor $FRANK3_CARTEL3 objective_to_guard_point 1534.063 -931.1875 18.375 
				01BE: set_actor $FRANK3_CARTEL3 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL3 maintain_position_when_attacked 1 
			end
		end
	end
end

//guard4
if
	0038:   $FLAG_GUARD4_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL4 dead
	then
		0004: $FLAG_GUARD4_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD4_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 4 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0018:   $COUNTER_GUARDS_DEAD_FM3 > 0 
			then
				011A: set_actor $FRANK3_CARTEL4 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL4 run_to 1517.5 -940.5625 
				0004: $FLAG_GUARD4_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD4_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL4 0 1517.5 -940.5625 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL4 run_to 1516.063 -932.5625 
				0004: $FLAG_GUARD4_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD4_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL4 0 1516.063 -932.5625 18.375 radius 0.5 0.5 2.0
			then
				0194: set_actor $FRANK3_CARTEL4 objective_to_guard_point 1516.063 -932.5625 18.375 
				01BE: set_actor $FRANK3_CARTEL4 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL4 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard5
if
	0038:   $FLAG_GUARD5_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL5 dead
	then
		0004: $FLAG_GUARD5_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD5_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD6_FM3_DEAD == 1 
				0038:   $FLAG_GUARD7_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL5 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL5 run_to 1505.563 -926.0625 
				0004: $FLAG_GUARD5_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD5_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL5 0 1505.563 -926.0625 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL5 run_to 1507.188 -924.0 
				0004: $FLAG_GUARD5_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD5_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL5 0 1507.188 -924.0 18.375 radius 0.5 0.5 2.0
			then
				0194: set_actor $FRANK3_CARTEL5 objective_to_guard_point 1507.188 -924.0 18.375  
				01BE: set_actor $FRANK3_CARTEL5 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL5 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard6
if
	0038:   $FLAG_GUARD6_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL6 dead
	then
		0004: $FLAG_GUARD6_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD6_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD5_FM3_DEAD == 1 
				0038:   $FLAG_GUARD7_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL6 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL6 run_to 1501.0 -919.75 
				0004: $FLAG_GUARD6_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD6_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL6 0 1501.0 -919.75 18.375 radius 0.5 0.5 2.0
			then
				0194: set_actor $FRANK3_CARTEL6 objective_to_guard_point 1501.0 -919.75 18.375 
				01BE: set_actor $FRANK3_CARTEL6 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL6 maintain_position_when_attacked 1 
			end
		end
	end
end

//guard7
if
	0038:   $FLAG_GUARD7_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL7 dead
	then
		0004: $FLAG_GUARD7_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD7_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD5_FM3_DEAD == 1 
				0038:   $FLAG_GUARD6_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL7 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL7 run_to 1499.375 -937.75 
				0004: $FLAG_GUARD7_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD7_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL7 0 1499.375 -937.75 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL7 run_to 1502.188 -930.75
				0004: $FLAG_GUARD7_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD7_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL7 0 1502.188 -930.75 18.375 radius 0.5 0.5 2.0 
			then
				0194: set_actor $FRANK3_CARTEL7 objective_to_guard_point 1502.188 -930.75 18.375   
				01BE: set_actor $FRANK3_CARTEL7 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL7 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard8
if
	0038:   $FLAG_GUARD8_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL8 dead
	then
		0004: $FLAG_GUARD8_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD8_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD9_FM3_DEAD == 1 
				0038:   $FLAG_GUARD10_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL8 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL8 run_to 1491.563 -935.75 
				0004: $FLAG_GUARD8_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD8_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL8 0 1491.563 -935.75 18.375 radius 0.5 0.5 2.0
			then
				0239: actor $FRANK3_CARTEL8 run_to 1487.563 -933.5625 
				0004: $FLAG_GUARD8_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD8_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL8 0 1487.563 -933.5625 18.375 radius 0.5 0.5 2.0 
			then
				0194: set_actor $FRANK3_CARTEL8 objective_to_guard_point 1487.563 -933.5625 18.375 
				01BE: set_actor $FRANK3_CARTEL8 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL8 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard9
if
	0038:   $FLAG_GUARD9_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL9 dead
	then
		0004: $FLAG_GUARD9_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD9_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 6 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD8_FM3_DEAD == 1 
				0038:   $FLAG_GUARD10_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL9 search_threat THREAT_SPECIAL 
				0194: set_actor $FRANK3_CARTEL9 objective_to_guard_point 1484.375 -930.5 19.75 
				0350: set_actor $FRANK3_CARTEL9 maintain_position_when_attacked 1 
				01BE: set_actor $FRANK3_CARTEL9 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0004: $FLAG_GUARD9_LOOKING_FOR_8BALL = 1 
			end
		end
	end
end

//guard10
if
	0038:   $FLAG_GUARD10_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL10 dead
	then
		0004: $FLAG_GUARD10_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD10_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 6 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD9_FM3_DEAD == 1 
				0038:   $FLAG_GUARD8_FM3_DEAD == 1
			then
				011A: set_actor $FRANK3_CARTEL10 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL10 run_to 1476.688 -936.25 
				0004: $FLAG_GUARD10_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD10_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL10 0 1476.688 -936.25 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL10 run_to 1482.563 -930.5 
				0004: $FLAG_GUARD10_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD10_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL10 0 1482.563 -930.5 18.375 radius 0.5 0.5 2.0 
			then
				0194: set_actor $FRANK3_CARTEL10 objective_to_guard_point 1482.563 -930.5 18.375 
				01BE: set_actor $FRANK3_CARTEL10 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL10 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard11
if
	0038:   $FLAG_GUARD11_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL11 dead
	then
		0004: $FLAG_GUARD11_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD11_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2 
				0038:   $FLAG_GUARD12_FM3_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD1_FM3_DEAD == 1 
				0038:   $FLAG_GUARD2_FM3_DEAD == 1 
			then
				011A: set_actor $FRANK3_CARTEL11 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL11 run_to 1528.5 -927.5
				0004: $FLAG_GUARD11_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD11_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL11 0 1528.5 -927.5 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL11 run_to 1521.5 -927.1875 
				0004: $FLAG_GUARD11_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD11_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL11 0 1521.5 -927.1875 18.375 radius 0.5 0.5 2.0 
			then
				0194: set_actor $FRANK3_CARTEL11 objective_to_guard_point 1521.5 -927.1875 18.375 
				01BE: set_actor $FRANK3_CARTEL11 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL11 maintain_position_when_attacked 1  
			end
		end
	end
end

//guard12
if
	0038:   $FLAG_GUARD12_FM3_DEAD == 0 
then
	if
		0118:   actor $FRANK3_CARTEL12 dead
	then
		0004: $FLAG_GUARD12_FM3_DEAD = 1 
		0008: $COUNTER_GUARDS_DEAD_FM3 += 1 
	else
		if
			0038:   $FLAG_GUARD12_LOOKING_FOR_8BALL == 0
		then
			if or
				0038:   $FLAG_BLOKE_IN_AREA_FM3 == 2 
				0038:   $FLAG_GUARD11_FM3_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR1_DEAD == 1 
				0038:   $FLAG_COLOMB_CAR2_DEAD == 1 
				0038:   $FLAG_GUARD1_FM3_DEAD == 1 
				0038:   $FLAG_GUARD2_FM3_DEAD == 1 
			then
				011A: set_actor $FRANK3_CARTEL12 search_threat THREAT_SPECIAL 
				0239: actor $FRANK3_CARTEL12 run_to 1517.563 -923.0625 
				0004: $FLAG_GUARD12_LOOKING_FOR_8BALL = 1
			end
			if and
				0038:   $FLAG_GUARD12_LOOKING_FOR_8BALL == 1
				00FE:   actor $FRANK3_CARTEL12 0 1517.563 -923.0625 18.375 radius 0.5 0.5 2.0 
			then
				0239: actor $FRANK3_CARTEL12 run_to 1512.688 -929.0 
				0004: $FLAG_GUARD12_LOOKING_FOR_8BALL = 2  
			end
			if and
				0038:   $FLAG_GUARD12_LOOKING_FOR_8BALL == 2
				00FE:   actor $FRANK3_CARTEL12 0 1512.688 -929.0 18.375 radius 0.1875 0.1875 2.0 
			then
				0194: set_actor $FRANK3_CARTEL12 objective_to_guard_point 1512.688 -929.0 18.375
				01BE: set_actor $FRANK3_CARTEL12 to_look_at_spot $EIGHTBALL_X_FM3 $EIGHTBALL_Y_FM3 $EIGHTBALL_Z_FM3 
				0350: set_actor $FRANK3_CARTEL12 maintain_position_when_attacked 1  
			end
		end
	end
end

return

:CAR_DEAD_CHECK
if and
	0038:   $FLAG_COLOMB_CAR1_DEAD == 0
	0119:   car $CAR_COLUMB1_FM3 wrecked
then
	0004: $FLAG_COLOMB_CAR1_DEAD = 1
end
if and
	0038:   $FLAG_COLOMB_CAR2_DEAD == 0
	0119:   car $CAR_COLUMB2_FM3 wrecked
then
	0004: $FLAG_COLOMB_CAR2_DEAD = 1
end
return

:CLEAR_AREA_CHECK
if
	002A:   2 >= $FLAG_BLOKE_IN_AREA_FM3
then
	0395: clear_area 0 at 1545.875 -867.6875 range 10.75 1.0 
	0395: clear_area 0 at 1527.0 -899.0 range 10.75 1.0 
	0395: clear_area 0 at 1526.0 -919.0 range 18.375 1.0 
	0395: clear_area 0 at 1522.875 -924.25 range 18.375 1.0 
	0395: clear_area 0 at 1517.0 -929.0 range 18.375 1.0 
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 3 
then
	0395: clear_area 0 at 1527.0 -899.0 range 10.75 1.0 
	0395: clear_area 0 at 1526.0 -919.0 range 18.375 1.0 
	0395: clear_area 0 at 1522.875 -924.25 range 18.375 1.0 
	0395: clear_area 0 at 1517.0 -929.0 range 18.375 1.0 
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 4
then
	0395: clear_area 0 at 1526.0 -919.0 range 18.375 1.0 
	0395: clear_area 0 at 1522.875 -924.25 range 18.375 1.0 
	0395: clear_area 0 at 1517.0 -929.0 range 18.375 1.0 
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 5
then
	0395: clear_area 0 at 1522.875 -924.25 range 18.375 1.0 
	0395: clear_area 0 at 1517.0 -929.0 range 18.375 1.0 
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 

end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 6
then
	0395: clear_area 0 at 1517.0 -929.0 range 18.375 1.0 
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 7
then
	0395: clear_area 0 at 1510.0 -923.0 range 18.375 1.0 
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 8
then
	0395: clear_area 0 at 1504.375 -928.5625 range 18.375 1.0 
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 9
then
	0395: clear_area 0 at 1493.688 -922.0625 range 18.375 1.0 
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 10
then
	0395: clear_area 0 at 1487.0 -930.1875 range 18.375 1.0 
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 11
then
	0395: clear_area 0 at 1481.5 -926.75 range 18.375 1.0 
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
if
	0038:   $FLAG_BLOKE_IN_AREA_FM3 == 12
then
	0395: clear_area 0 at 1475.75 -940.25 range 18.375 1.0 
	0395: clear_area 0 at 1474.188 -940.1875 range 18.375 1.0 
end
return
