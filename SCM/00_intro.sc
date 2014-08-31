// *****************************************************************************************
// ************************************   The Intro    ************************************* 
// *****************************************************************************************

// ****************************************Mission Start************************************

:M00_INTRO
0004: $ONMISSION = 1
0004: $SKIP_FLAG = 0

0001: wait 0 ms

03A4: name_thread 'INTRO'

0169: set_fade_color 0 0 0 

016A: fade 0 for 0 ms 

03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 
01B4: set_player $PLAYER_CHAR controllable 0 
0336: set_player $PLAYER_CHAR visible 0 
03AF: set_streaming 0 

03AD: set_rubbish 0 

// **********************************START OF BANK CUTSCENE****************************

03EF: player $PLAYER_CHAR make_safe 
043D: set_intro_is_playing 1 
03F7: load_island_data 0 
023C: load_special_actor 'CAT' as 1 
023C: load_special_actor 'COLROB' as 2 
023C: load_special_actor 'MIGUEL' as 3 
023C: load_special_actor 'PLAYERX' as 4 
02F3: load_object #CUTOBJ01 'CS_BAN' 
02F3: load_object #CUTOBJ02 'BANKD' 
02F3: load_object #CUTOBJ03 'CS_LOOT' 
02F3: load_object #CUTOBJ04 'COLT1' 
02F3: load_object #CUTOBJ05 'CATH' 

01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
if
	8118:   not actor $PLAYER_ACTOR dead
then
	0352: set_actor $PLAYER_ACTOR skin_to 'PLAYER'
	while 8248:   not model #NULL available 
		wait 0 ms
	end
	if
		8118:   not actor $PLAYER_ACTOR dead
	then
		0353: refresh_actor $PLAYER_ACTOR
	end
end

0374: set_motion_blur 5 
01B6: set_weather WEATHER_FOGGY
00C0: set_current_time 12 00
03B7: process_cut_scene_only 0 
038B: load_all_models_now
while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
	jf break
	wait 0 ms
end
while true
	if or
		8248:   not model #CUTOBJ05 available 
		823D:   not special_actor 3 loaded 
		823D:   not special_actor 4 loaded 
	jf break
	wait 0 ms
end
02E4: load_cutscene_data 'BET' 
03CB: load_scene -559.625 1030.5 40.0 
0244: set_cutscene_pos -537.375 1051.188 36.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #SPECIAL04 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYERX' 
02E5: $CS_CAT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CS_CAT 'CAT' 
02E5: $CS_ROBB = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CS_ROBB 'COLROB' 
02E5: $CUTSCENE_MIGUEL = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CUTSCENE_MIGUEL 'MIGUEL' 
02F4: create_cutscene_actor $CS_CATHEAD from_head #CUTOBJ05 and_body $CS_CAT 
02F5: set_head_anim $CS_CATHEAD 'CAT' 
02E5: $CS_CS_BAN = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_CS_BAN 'CS_BAN' 
02E5: $CS_BANKD = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_BANKD 'BANKD' 
02E5: $CS_LOOT = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $CS_LOOT 'CS_LOOT' 
02E5: $CS_COLT1 = create_cutscene_object #CUTOBJ04 
02E6: set_cutscene_anim $CS_COLT1 'COLT1' 
02E5: $CS_COLT2 = create_cutscene_object #CUTOBJ04 
02E6: set_cutscene_anim $CS_COLT2 'COLT2' 
0418: set_object $CS_CS_BAN draw_last 1 
03AF: set_streaming 1 
02E7: start_cutscene 
016A: fade 1 for 2000 ms 
02E8: $CUT_SCENE_TIME = cutscenetime

while 001A:   17166 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0374: set_motion_blur 3 //SETS UP THE GREEN SECURITY CAMERA

while 001A:   18126 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

043C: set_game_sounds_fade 0 
if
	82E9:   not cutscene_reached_end
then
	0169: set_fade_color 255 255 255 //FLASH SCREEN FOR PLAYER SHOOTING CAMERA
	016A: fade 0 for 100 ms 
	0005: $PARTICLE_X = -537.375 
	0009: $PARTICLE_X += 1.75 
	0005: $PARTICLE_Y = 1051.188 
	000D: $PARTICLE_Y -= 0.375 
	0005: $PARTICLE_Z = 36.875 
	0009: $PARTICLE_Z += 1.9375 
	0005: $PARTICLE_TARGET_X = -537.375 
	0009: $PARTICLE_TARGET_X += 2.0625 
	0005: $PARTICLE_TARGET_Y = 1051.188 
	000D: $PARTICLE_TARGET_Y -= 0.9375 
	0005: $PARTICLE_TARGET_Z = 36.875 
	0009: $PARTICLE_TARGET_Z += 2.625  
	0086: $TEMP_VAR = $PARTICLE_TARGET_X 
	0086: $PARTICLE_TARGET_X = $PARTICLE_X 
	0061: $PARTICLE_TARGET_X -= $TEMP_VAR 
	0086: $TEMP_VAR = $PARTICLE_TARGET_Y 
	0086: $PARTICLE_TARGET_Y = $PARTICLE_Y 
	0061: $PARTICLE_TARGET_Y -= $TEMP_VAR 
	0086: $TEMP_VAR = $PARTICLE_TARGET_Z 
	0086: $PARTICLE_TARGET_Z = $PARTICLE_Z 
	0061: $PARTICLE_TARGET_Z -= $TEMP_VAR 
	039D: scatter_particles type POBJECT_CATALINAS_SHOTGUNFLASH 1.0 0 0 0 0 from $PARTICLE_X $PARTICLE_Y $PARTICLE_Z to $PARTICLE_TARGET_X $PARTICLE_TARGET_Y $PARTICLE_TARGET_Z 
	while fading
		wait 0 ms
		gosub @SKIP_INTRO_BUTTON
	end
end
if 
	82E9:   not cutscene_reached_end 
then
	044D: load_splash 'NEWS' 
end
if 
	82E9:   not cutscene_reached_end 
then
	0169: set_fade_color 1 1 1 
	016A: fade 0 for 0 ms 
end

while 001A:   18733 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

if 
	82E9:   not cutscene_reached_end 
then
	0169: set_fade_color 1 1 1 
	016A: fade 1 for 0 ms 
end

0374: set_motion_blur 5

while 001A:   25249 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'BETRA_A' duration 4000 ms flag 1  // Sorry, babe.

while 001A:   26060 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'BETRA_B' duration 5000 ms flag 1  // I'm an ambitious girl and you,

while 001A:   27000 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0005: $PARTICLE_X = -537.375 
000D: $PARTICLE_X -= 1.3125 
0005: $PARTICLE_Y = 1051.188 
0009: $PARTICLE_Y += 25.8125 
0005: $PARTICLE_Z = 36.875 
0009: $PARTICLE_Z += 1.3125 
0005: $PARTICLE_TARGET_X = -537.375 
000D: $PARTICLE_TARGET_X -= 0.375 
0005: $PARTICLE_TARGET_Y = 1051.188 
0009: $PARTICLE_TARGET_Y += 25.8125 
0005: $PARTICLE_TARGET_Z = 36.875 
0009: $PARTICLE_TARGET_Z += 1.4375 
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

while 001A:   27030 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0005: $PARTICLE_X = -537.375 
000D: $PARTICLE_X -= 1.8125 
0005: $PARTICLE_Y = 1051.188 
0009: $PARTICLE_Y += 26.0625 
0005: $PARTICLE_Z = 36.875 
0009: $PARTICLE_Z += 1.3125 
0005: $PARTICLE_TARGET_X = -537.375 
000D: $PARTICLE_TARGET_X -= 0.4375 
0005: $PARTICLE_TARGET_Y = 1051.188 
0009: $PARTICLE_TARGET_Y += 25.9375 
0005: $PARTICLE_TARGET_Z = 36.875 
0009: $PARTICLE_TARGET_Z += 1.375 
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

while 001A:   27100 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0374: set_motion_blur 8 //PLAYER IS SHOT MOTION BLUR

if 
	82E9:   not cutscene_reached_end 
then
	0169: set_fade_color 255 255 255 
	016A: fade 0 for 100 ms 
	while fading
		wait 0 ms
		gosub @SKIP_INTRO_BUTTON
	end
end

if 
	82E9:   not cutscene_reached_end 
then 
	016A: fade 1 for 600 ms  
	while fading
		wait 0 ms
		gosub @SKIP_INTRO_BUTTON
	end
end
while 001A:   28710 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end
00BC: print_now 'BETRA_C' duration 2282 ms flag 1  // you're just small time.
043C: set_game_sounds_fade 1
while 001A:   29200 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end
0374: set_motion_blur 5 
while 001A:   30800 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end
0374: set_motion_blur 8 //PLAYER IS SHOT MOTION BLUR
while 001A:   30992 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end
00BE: clear_prints 
03EB: clear_small_messages_only
while 001A:   33333 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end
0169: set_fade_color 0 0 0 
016A: fade 0 for 4000 ms 
0004: $TEXT_ALPHA = 0 
0004: $TEXT_FADING_FLAG = 0 
03F0: enable_text_draw 1
gosub @DRAW_INTRO_TEXT
while fading
	wait 0 ms
	gosub @DRAW_INTRO_TEXT
	gosub @SKIP_INTRO_BUTTON
end
while 82E9:   not cutscene_reached_end
	wait 0 ms
	gosub @DRAW_INTRO_TEXT
	gosub @SKIP_INTRO_BUTTON
end

00BE: clear_prints 
03EB: clear_small_messages_only 
02EA: end_cutscene 
03EF: player $PLAYER_CHAR make_safe 
01B6: set_weather WEATHER_RAINY
0421: force_rain 1 
0296: unload_special_actor 1 
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0296: unload_special_actor 4 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 

// **********************************END OF BANK CUTSCENE******************************

// ******************************START OF JAIL BREAK CUTSCENE**************************

03AF: set_streaming 0 
03F7: load_island_data LEVEL_COMMERCIAL
0055: set_player_coordinates $PLAYER_CHAR to 820.875 -941.0625 -100.0 
0169: set_fade_color 0 0 0 
0374: set_motion_blur 6 
023C: load_special_actor 'EIGHT' as 1 
023C: load_special_actor 'OJG_P' as 2 
023C: load_special_actor 'COL1' as 3 
023C: load_special_actor 'COL2' as 4 
02F3: load_object #CUTOBJ01 'CS_TRUK' 
02F3: load_object #CUTOBJ02 'REBEL' 
02F3: load_object #CUTOBJ03 'BRBOMB' 
02F3: load_object #CUTOBJ04 'COL1H' 
0247: request_model #BRIDGEFUKA 
0247: request_model #BRIDGEFUKB 
00C0: set_current_time 2 0 
0247: request_model #TRAFFICLIGHT1 
0247: request_model #RD_SRROAD2A50 
0247: request_model #RD_SRROAD2A20 
0247: request_model #RD_SRROAD2A10 
0247: request_model #RD_CROSSRDA1RW22 
0247: request_model #RD_CROSSROADSA24 
0247: request_model #COM_CUST_ROADS25 
0247: request_model #VEG_TREE3 
0247: request_model #DOUBLESTREETLGHT1 
0247: request_model #VEG_TREEA3 
0247: request_model #VEG_TREENEW17 
0247: request_model #STREETLAMP1 
0247: request_model #BOLLARDLIGHT 
0247: request_model #KB_SCRAP_5 
0247: request_model #POLICETENKB1 
0247: request_model #SCRAPERKB3_NIT 
0247: request_model #CHUNK5LAND 
0247: request_model #POLICEALLY 
0247: request_model #POLICE_COM 
0247: request_model #RD_CROSSRDA1W22 
0247: request_model #TREEPATCHKB7 
0247: request_model #ROADPLANTERKB3 
0247: request_model #ROADPLANTERKB1 
0247: request_model #RD_ROAD3A50 
0247: request_model #AMCO_FLOOR 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		823D:   not special_actor 3 loaded 
		823D:   not special_actor 4 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
	jf break
	wait 0 ms
	gosub @DRAW_INTRO_TEXT
end
while true
	if or
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
		8248:   not model #BRIDGEFUKA available 
		8248:   not model #BRIDGEFUKB available 
	jf break
	wait 0 ms
	gosub @DRAW_INTRO_TEXT
end


01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
if
	8118:   not actor $PLAYER_ACTOR dead
then
	0352: set_actor $PLAYER_ACTOR skin_to 'PLAYERP'
	while 8248:   not model #NULL available 
		wait 0 ms
	end
	if
		8118:   not actor $PLAYER_ACTOR dead
	then
		0353: refresh_actor $PLAYER_ACTOR
	end
end

02E4: load_cutscene_data 'JB' 
0244: set_cutscene_pos 0.0 0.0 0.0 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYERP' 
02E5: $CUTSCENE_EIGHT = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_EIGHT 'EIGHT' 
02E5: $CS_OJG = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CS_OJG 'OJG_P' 
02E5: $CS_COLOMBIAN1 = create_cutscene_object #SPECIAL03 
02E6: set_cutscene_anim $CS_COLOMBIAN1 'COL1' 
02E5: $CS_COLOMBIAN2 = create_cutscene_object #SPECIAL04 
02E6: set_cutscene_anim $CS_COLOMBIAN2 'COL2' 
02E5: $CS_COP1 = create_cutscene_object #COP 
02E6: set_cutscene_anim $CS_COP1 'COP' 
02E5: $CS_COP2 = create_cutscene_object #COP 
02E6: set_cutscene_anim $CS_COP2 'MALE01' 
02F4: create_cutscene_actor $CS_COLOMBIAN1HEAD from_head #CUTOBJ04 and_body $CS_COLOMBIAN1 
02F5: set_head_anim $CS_COLOMBIAN1HEAD 'COL1' 
02E5: $CS_COLT1 = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_COLT1 'CS_TRUK' 
02E5: $CS_COLT2 = create_cutscene_object #CUTOBJ02 
02E6: set_cutscene_anim $CS_COLT2 'REBEL' 
02E5: $BRBOMB = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $BRBOMB 'BRBOMB' 
0418: set_object $CS_COLT1 draw_last 1 
0418: set_object $CS_COLT2 draw_last 1 
02E7: start_cutscene 
0354: set_up_chase_scene 1.0 
00BE: clear_prints 
03EB: clear_small_messages_only 
016A: fade 1 for 2000 ms 
02E8: $CUT_SCENE_TIME = cutscenetime 
0247: request_model #RD_CROSSRDA1W22 
0247: request_model #RD_ROAD2A20 
0247: request_model #BROADWAYBUILD2 
0247: request_model #BROADWAYBUILD 
0247: request_model #AREA5BUILD2 
0247: request_model #COMSWCENTRALBLD7 
0247: request_model #PAPERMACHN01 
0247: request_model #COMSWCENTRALBLD6 
0247: request_model #COM_21WAY5 
0247: request_model #COM_21WAY50 
0247: request_model #COM_21WAY10 
0247: request_model #CM1WAYCROSSCOM 
0247: request_model #COM_21WAY20 
0247: request_model #TW@T_CAFE 
0247: request_model #VEG_BUSH14 
0247: request_model #TREEPATCHTTWRS 
0247: request_model #FLATIRON1 
0247: request_model #VEG_TREE3 
0247: request_model #VEG_TREENEW17 
0247: request_model #BLOCK4_GROUND01 

while 001A:   9500 > $CUT_SCENE_TIME
	wait 0 ms
	0004: $TEXT_FADING_FLAG = 1 
	gosub @DRAW_INTRO_TEXT
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	0250: create_light_at 196.0625 -1126.938 25.625 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0249: release_model #RD_SRROAD2A50 
0249: release_model #RD_SRROAD2A20 
0249: release_model #RD_SRROAD2A10 
0249: release_model #RD_CROSSROADSA24 
0249: release_model #COM_CUST_ROADS25 
0249: release_model #VEG_TREEA3 
0249: release_model #STREETLAMP1 
0249: release_model #BOLLARDLIGHT 
0249: release_model #KB_SCRAP_5 
0249: release_model #POLICETENKB1 
0249: release_model #SCRAPERKB3_NIT 
0249: release_model #CHUNK5LAND 
0249: release_model #POLICEALLY 
0249: release_model #POLICE_COM 
0249: release_model #TREEPATCHKB7 
0249: release_model #ROADPLANTERKB3 
0249: release_model #ROADPLANTERKB1 
0249: release_model #RD_ROAD3A50 
0249: release_model #AMCO_FLOOR 

while 001A:   13007 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @DRAW_INTRO_TEXT
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	0250: create_light_at 196.0625 -1126.938 25.625 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

03F0: enable_text_draw 0 
00BC: print_now 'JAILB_V' duration 10000 ms flag 1  // *

while 001A:   14500 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	0250: create_light_at 196.0625 -1126.938 25.625 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_A' duration 10000 ms flag 1  // *

while 001A:   15933 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	0250: create_light_at 196.0625 -1126.938 25.625 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0247: request_model #PLANTER_SHORT 
0247: request_model #COM_RVROADS52 
0247: request_model #ROAD_BROADWAY04 
0247: request_model #COM_ROADSRV 
0247: request_model #RD_ROAD1A20 
0247: request_model #RD_CROSSROADS11 
0247: request_model #DOUBLESTREETLGHT1 
0247: request_model #OFIS_BILDKB_4 
0247: request_model #RD_ROAD1A10 
0247: request_model #COM_ROADKB23 
0247: request_model #COM_CUST_ROADS57 
0247: request_model #COM_RVROADS52 

0249: release_model #RD_CROSSRDA1W22 
0249: release_model #RD_ROAD2A20 
0249: release_model #BROADWAYBUILD2 
0249: release_model #BROADWAYBUILD 
0249: release_model #AREA5BUILD2 
0249: release_model #PAPERMACHN01 
0249: release_model #COM_21WAY5 
0249: release_model #TW@T_CAFE 
0249: release_model #TREEPATCHTTWRS 
0249: release_model #FLATIRON1 
0249: release_model #VEG_TREE3 
0249: release_model #VEG_TREENEW17 
0249: release_model #BLOCK4_GROUND01 
0249: release_model #COMSWCENTRALBLD7 
0249: release_model #PAPERMACHN01 

while 001A:   17514 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	0250: create_light_at 196.0625 -1126.938 25.625 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_B' duration 10000 ms flag 1  // *

while 001A:   18933 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0247: request_model #COM_ROADKB23 
0247: request_model #COM_ROADKB22 
0247: request_model #KB_UNDERPASS 
0247: request_model #MUSEUM 
0247: request_model #NBCOM_ROADKB01 
0247: request_model #BVBRIDGSPPRT01 
0247: request_model #FLATIRON1B 
0247: request_model #VEG_TREE3 
0247: request_model #NBBRIDGCABLS01 
0247: request_model #NBBRIDGERDB 
0247: request_model #NBBRIDGERDA 
0247: request_model #NBBRIDGCABLS01 
0247: request_model #BVBRIDGSPPRT01 
0247: request_model #OVERPASS_COMSE 
0247: request_model #COM_LANDNEW221B 
0247: request_model #NBCOM_ROADKB01 
0247: request_model #COM_LANDNEW221 
0247: request_model #FLATIRON1B 
0247: request_model #LODTIRON1B 
0247: request_model #VEG_TREE3 
0247: request_model #OFIS_BILDKB_4 
0247: request_model #KB_OFIS1 
0247: request_model #COMTREEPATCHPRK 
0247: request_model #HOTEL2 
0247: request_model #UNDERGROUND_OVER7 
0247: request_model #RD_ROAD1A50 
0247: request_model #KB_UNDERPASS 
0247: request_model #KBPLANTER4 
0247: request_model #BLOCK4_SCRAPERL0 
0247: request_model #COM_ROADKB12 
0247: request_model #PLANTERBTM_1 
0247: request_model #LODRIDGSPPRT01 
0247: request_model #LODOM_ROADKB01 
0247: request_model #LODRIDGERDA 
0247: request_model #LODRIDGERDB 
0247: request_model #LODRIDGCABLS01 

0249: release_model #COM_21WAY20 
0249: release_model #CM1WAYCROSSCOM 
0249: release_model #COM_21WAY10 
0249: release_model #COMSWCENTRALBLD7 
0249: release_model #COMSWCENTRALBLD6 
041D: set_camera_near_clip 2.5 

while 001A:   20667 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_C' duration 10000 ms flag 1  // *

while 001A:   22181 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

041D: set_camera_near_clip 4.5 

while 001A:   24522 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_D' duration 10000 ms flag 1  // *

while 001A:   27208 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_E' duration 10000 ms flag 1  // *

while 001A:   29793 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_F' duration 10000 ms flag 1  // *

while 001A:   30599 > $CUT_SCENE_TIME //VERY HIGH SHOT TOWARDS BRIDGE
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

041D: set_camera_near_clip 5.5 
0247: request_model #IND_CUSTOMROAD003
 
0249: release_model #PLANTER_SHORT 
0249: release_model #COM_RVROADS52 
0249: release_model #ROAD_BROADWAY04 
0249: release_model #COM_ROADSRV 
0249: release_model #RD_ROAD1A20 
0249: release_model #RD_CROSSROADS11 
0249: release_model #COM_21WAY50 
0249: release_model #RD_ROAD1A10 
0249: release_model #COM_CUST_ROADS57

while 001A:   32986 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_G' duration 10000 ms flag 1  // *

while 001A:   34817 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_H' duration 10000 ms flag 1  // *

while 001A:   38590 > $CUT_SCENE_TIME
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_I' duration 10000 ms flag 1  // *

while 001A:   40842 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_J' duration 10000 ms flag 1  // *

while 001A:   42066 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

041D: set_camera_near_clip 4.5 
0247: request_model #KMRICNDO01 
0247: request_model #KMRICNDO02 
0247: request_model #VEG_TREENEW17 
0247: request_model #COM_DOCKSAA 
0247: request_model #COM_PIER3 
0247: request_model #GRD_OVERPASS19KB 
0247: request_model #GRD_OVERPASS19BKB 

while 001A:   42535 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_W' duration 10000 ms flag 1  // *

while 001A:   46683 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_K' duration 10000 ms flag 1  // *

while 001A:   49483 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_L' duration 10000 ms flag 1  // *

while 001A:   53406 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_O' duration 10000 ms flag 1  // *

while 001A:   53666 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

041D: set_camera_near_clip 0.875

while 001A:   56077 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_P' duration 5000 ms flag 1  // *

while 001A:   64200 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

040A: remove_car_from_chase 2 

while 001A:   64333 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

040A: remove_car_from_chase 1

while 001A:   64566 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0247: request_model #COM_DOCKSB 
0247: request_model #NEWDOCKBUILDING2 
0247: request_model #NEWDOCKBUILDING 
0247: request_model #BLOCK4_SCRAPERL0
 
0249: release_model #COM_ROADKB22 
0249: release_model #COM_ROADKB23 
0249: release_model #NBCOM_ROADKB01 
0249: release_model #COM_LANDNEW221 
0249: release_model #DOUBLESTREETLGHT1 
0249: release_model #MUSEUM 
0249: release_model #OFIS_BILDKB_4 
0249: release_model #KB_OFIS1 
0249: release_model #COMTREEPATCHPRK 
0249: release_model #HOTEL2 
0249: release_model #UNDERGROUND_OVER7 
0249: release_model #TRAFFICLIGHT1 
0249: release_model #RD_ROAD1A50 
0249: release_model #VEG_BUSH14 
0249: release_model #KB_UNDERPASS 
0249: release_model #OFIS_BILDKB_4 
0249: release_model #KBPLANTER4 
0249: release_model #PLANTERBTM_1 
0249: release_model #COM_RVROADS52 

while 001A:   66171 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_Q' duration 1200 ms flag 1  // Come on!

while 001A:   69378 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_R' duration 1600 ms flag 1  // Senor dickhead!

while 001A:   71994 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_S' duration 2000 ms flag 1  // It's no problem to kill you.

while 001A:   75623 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_T' duration 1800 ms flag 1  // You gonna be sorry.

while 001A:   79633 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

0249: release_model #KMRICNDO01 
0249: release_model #KMRICNDO02 
0249: release_model #VEG_TREE3 
0249: release_model #VEG_TREENEW17 
0249: release_model #COM_DOCKSAA 
0249: release_model #COM_PIER3 
0249: release_model #GRD_OVERPASS19KB 
0249: release_model #GRD_OVERPASS19BKB 

while 001A:   86089 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BC: print_now 'JAILB_U' duration 1800 ms flag 1  // A'right, a'right. Get lost.

while 001A:   87592 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 235 255 250 
	02E8: $CUT_SCENE_TIME = cutscenetime
end

00BE: clear_prints 
03EB: clear_small_messages_only 

while 001A:   98766 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 205 255 230
	02E8: $CUT_SCENE_TIME = cutscenetime
end

while 001A:   101866 > $CUT_SCENE_TIME 
	wait 0 ms
	gosub @SKIP_INTRO_BUTTON
	0250: create_light_at 780.5 -942.875 39.0 RGB_values 205 255 230
	02E8: $CUT_SCENE_TIME = cutscenetime
end

043C: set_game_sounds_fade 0 
0374: set_motion_blur 7 //THE EXPLOSION

if
	82E9:   not cutscene_reached_end 
then
	0169: set_fade_color 255 255 255 
	016A: fade 0 for 100 ms 
	00BE: clear_prints
	while fading
		wait 0 ms
	end
end

:SKIP_INTRO_HERE
044D: load_splash 'SPLASH1'
if
	0038:  $SKIP_FLAG == 2
then
	0001: wait 0 ms 
	03F0: enable_text_draw 0 
	043C: set_game_sounds_fade 1 
	0169: set_fade_color 0 0 0 
	016A: fade 0 for 0 ms
end

//FADE OUT AFTER EXPLOSION....
//SWAP BRIDGE FROM FIXED TO DAMAGED

0249: release_model #TRAFFICLIGHT1 
0249: release_model #RD_SRROAD2A50 
0249: release_model #RD_SRROAD2A20 
0249: release_model #RD_SRROAD2A10 
0249: release_model #RD_CROSSRDA1RW22 
0249: release_model #RD_CROSSROADSA24 
0249: release_model #COM_CUST_ROADS25 
0249: release_model #VEG_TREE3 
0249: release_model #DOUBLESTREETLGHT1 
0249: release_model #VEG_TREEA3 
0249: release_model #VEG_TREENEW17 
0249: release_model #STREETLAMP1 
0249: release_model #BOLLARDLIGHT 
0249: release_model #KB_SCRAP_5 
0249: release_model #POLICETENKB1 
0249: release_model #SCRAPERKB3_NIT 
0249: release_model #CHUNK5LAND 
0249: release_model #POLICEALLY 
0249: release_model #POLICE_COM 
0249: release_model #RD_CROSSRDA1W22 
0249: release_model #TREEPATCHKB7 
0249: release_model #ROADPLANTERKB3 
0249: release_model #ROADPLANTERKB1 
0249: release_model #RD_ROAD3A50 
0249: release_model #RD_CROSSRDA1W22 
0249: release_model #RD_ROAD2A20 
0249: release_model #BROADWAYBUILD2 
0249: release_model #BROADWAYBUILD 
0249: release_model #AREA5BUILD2 
0249: release_model #COMSWCENTRALBLD7 
0249: release_model #PAPERMACHN01 
0249: release_model #COMSWCENTRALBLD6 
0249: release_model #COM_21WAY5 
0249: release_model #COM_21WAY50 
0249: release_model #COM_21WAY10 
0249: release_model #CM1WAYCROSSCOM 
0249: release_model #COM_21WAY20 
0249: release_model #TW@T_CAFE 
0249: release_model #VEG_BUSH14 
0249: release_model #TREEPATCHTTWRS 
0249: release_model #FLATIRON1 
0249: release_model #VEG_TREE3 
0249: release_model #VEG_TREENEW17 
0249: release_model #BLOCK4_GROUND01 
0249: release_model #PLANTER_SHORT 
0249: release_model #COM_RVROADS52 
0249: release_model #ROAD_BROADWAY04 
0249: release_model #COM_ROADSRV 
0249: release_model #RD_ROAD1A20 
0249: release_model #RD_CROSSROADS11 
0249: release_model #DOUBLESTREETLGHT1 
0249: release_model #OFIS_BILDKB_4 
0249: release_model #RD_ROAD1A10 
0249: release_model #COM_ROADKB23 
0249: release_model #COM_CUST_ROADS57 
0249: release_model #COM_RVROADS52 
0249: release_model #COM_ROADKB23 
0249: release_model #COM_ROADKB22 
0249: release_model #KB_UNDERPASS 
0249: release_model #MUSEUM 
0249: release_model #NBCOM_ROADKB01 
0249: release_model #BVBRIDGSPPRT01 
0249: release_model #FLATIRON1B 
0249: release_model #LODTIRON1B 
0249: release_model #VEG_TREE3 
0249: release_model #NBBRIDGCABLS01 
0249: release_model #NBBRIDGERDB 
0249: release_model #NBBRIDGERDA 
0249: release_model #NBBRIDGCABLS01 
0249: release_model #BVBRIDGSPPRT01 
0249: release_model #OVERPASS_COMSE 
0249: release_model #COM_LANDNEW221B 
0249: release_model #NBCOM_ROADKB01 
0249: release_model #COM_LANDNEW221 
0249: release_model #FLATIRON1B 
0249: release_model #VEG_TREE3 
0249: release_model #MUSEUM 
0249: release_model #OFIS_BILDKB_4 
0249: release_model #KB_OFIS1 
0249: release_model #COMTREEPATCHPRK 
0249: release_model #HOTEL2 
0249: release_model #UNDERGROUND_OVER7 
0249: release_model #RD_ROAD1A50 
0249: release_model #KB_UNDERPASS 
0249: release_model #KBPLANTER4 
0249: release_model #BLOCK4_SCRAPERL0 
0249: release_model #COM_ROADKB12 
0249: release_model #PLANTERBTM_1 
0249: release_model #FLATIRON1B 
0249: release_model #IND_CUSTOMROAD003 
0249: release_model #KMRICNDO01 
0249: release_model #KMRICNDO02 
0249: release_model #VEG_TREENEW17 
0249: release_model #COM_DOCKSAA 
0249: release_model #COM_PIER3 
0249: release_model #GRD_OVERPASS19KB 
0249: release_model #GRD_OVERPASS19BKB 
0249: release_model #COM_DOCKSB 
0249: release_model #NEWDOCKBUILDING2 
0249: release_model #NEWDOCKBUILDING 
0249: release_model #BLOCK4_SCRAPERL0 
0249: release_model #LODRIDGCABLS01
if
	0038:   $DEBUGUNLOCKISLANDS == 0
then
	03B6: replace_model_at 525.3125 -927.0625 71.8125 radius 20.0 from #NBBRIDGCABLS01 to #NBBRIDGFK2 
	03B6: replace_model_at 706.375 -935.8125 67.0625 radius 20.0 from #NBBRIDGCABLS01 to #NBBRIDGFK2 
	03B6: replace_model_at 529.0 -920.0625 43.5 radius 20.0 from #NBBRIDGERDB to #DAMGBRIDGERDB 
	03B6: replace_model_at 702.75 -939.9375 38.6875 radius 20.0 from #NBBRIDGERDB to #DAMGBRIDGERDB 
	03B6: replace_model_at 529.0 -942.9375 43.5 radius 20.0 from #NBBRIDGERDA to #DAMGBBRIDGERDA 
	03B6: replace_model_at 702.75 -919.9375 38.6875 radius 20.0 from #NBBRIDGERDA to #DAMGBBRIDGERDA 
	03B6: replace_model_at 525.3125 -927.0625 71.8125 radius 20.0 from #LODRIDGCABLS01 to #LODRIDGFK2 
	03B6: replace_model_at 706.375 -935.8125 67.0625 radius 20.0 from #LODRIDGCABLS01 to #LODRIDGFK2 
	03B6: replace_model_at 521.125 -922.9375 43.5 radius 20.0 from #LODRIDGERDB to #LODGBRIDGERDB 
	03B6: replace_model_at 702.75 -939.9375 38.6875 radius 20.0 from #LODRIDGERDB to #LODGBRIDGERDB 
	03B6: replace_model_at 529.0 -940.0625 43.5 radius 20.0 from #LODRIDGERDA to #LODGBBRIDGERDA 
	03B6: replace_model_at 702.75 -919.9375 38.6875 radius 20.0 from #LODRIDGERDA to #LODGBBRIDGERDA 
	029B: $BROKEN_BRIDGE_REMAINS = init_object #BRIDGEFUKA at 715.6875 -937.875 40.1875 
	029B: $BROKEN_BRIDGE_POLICE_CARS = init_object #BRIDGEFUKB at 787.8125 -939.1875 38.9375 
end
0055: set_player_coordinates $PLAYER_CHAR to 811.875 -939.9375 35.75 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
03B7: process_cut_scene_only 1 
03AF: set_streaming 1 
03F0: enable_text_draw 0 
0006: 16@ = 6001 
gosub @DO_BRIDGE_PARTICLES

018D: $FIRE_SOUND_8BALL = create_sound SOUND_PRETEND_FIRE_LOOP at 790.5 -935.625 38.0 
03F0: enable_text_draw 0
if
	8038:   not  $SKIP_FLAG == 2 
then
	0336: set_player $PLAYER_CHAR visible 1 
	0247: request_model #KURUMA 
	038B: load_all_models_now 
	while 8248:   not model #KURUMA available
		wait 0 ms
		gosub @DO_BRIDGE_PARTICLES
	end
	00A5: $CAR_EIGHTBALL = create_car #KURUMA at 812.0 -945.5 35.75
	0229: set_car $CAR_EIGHTBALL color_to 58 1 
	0175: set_car $CAR_EIGHTBALL z_angle_to 262.375 
	009A: $EIGHTBALL = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 811.875 -942.4375 -100.0
	0245: set_actor $EIGHTBALL walk_style_to ANIM_GANG2_PED
	01ED: clear_actor $EIGHTBALL threat_search 
	01BE: set_actor $EIGHTBALL to_look_at_spot 811.875 -939.9375 35.75 
	022D: set_actor $EIGHTBALL to_look_at_player $PLAYER_CHAR 
	0355: clean_up_chase_scene 
	0249: release_model #LODRIDGSPPRT01 
	0249: release_model #LODOM_ROADKB01 
	0249: release_model #LODRIDGERDA 
	0249: release_model #LODRIDGERDB 
	
	while 001A:   107172 > $CUT_SCENE_TIME 
		wait 0 ms
		gosub @DO_BRIDGE_PARTICLES
		gosub @SKIP_INTRO_BUTTON
		0250: create_light_at 780.5 -942.875 39.0 RGB_values 205 255 230 
		02E8: $CUT_SCENE_TIME = cutscenetime
	end
	if
		82E9:   not cutscene_reached_end 
	then
		0169: set_fade_color 255 255 255 
		016A: fade 1 for 6000 ms 
		00BE: clear_prints 
		while fading
			wait 0 ms
			gosub @DO_BRIDGE_PARTICLES
		end
	end
	while 001A:   121666 > $CUT_SCENE_TIME 
		wait 0 ms
		gosub @DO_BRIDGE_PARTICLES
		gosub @SKIP_INTRO_BUTTON
		0250: create_light_at 780.5 -942.875 39.0 RGB_values 205 255 230 
		02E8: $CUT_SCENE_TIME = cutscenetime
	end
	if
		82E9:   not cutscene_reached_end 
	then
		043C: set_game_sounds_fade 1 
		0169: set_fade_color 0 0 0 
		016A: fade 0 for 500 ms 
		00BE: clear_prints 
		while fading
			wait 0 ms
			gosub @DO_BRIDGE_PARTICLES
		end
	end
end

while 82E9:   not cutscene_reached_end
	wait 0 ms
	gosub @DO_BRIDGE_PARTICLES
end

043C: set_game_sounds_fade 1 
0374: set_motion_blur 0 
041D: set_camera_near_clip 0.875 
0355: clean_up_chase_scene 
02EA: end_cutscene 
00BE: clear_prints 
03EB: clear_small_messages_only
if
	0038:   $MASTERDEBUG == 1
then
	03CB: load_scene 807.0 -937.0 35.5625
	0055: set_player_coordinates $PLAYER_CHAR to 825.875 -939.9375 35.00 
	016A: fade 1 for 0 ms 
	0247: request_model #BANSHEE
	038B: load_all_models_now 
	00A5: $CAR_EIGHTBALL = create_car #BANSHEE at 825.0 -945.5 35.75
	0175: set_car $CAR_EIGHTBALL z_angle_to 262.375 
	01C3: remove_references_to_car $CAR_EIGHTBALL
	gosub @SWITCH_CAR_GENERATOR
else
	0055: set_player_coordinates $PLAYER_CHAR to 811.875 -939.9375 35.75 
	0169: set_fade_color 0 0 0 
	016A: fade 0 for 0 ms 
end
03AD: set_rubbish 1 
03B7: process_cut_scene_only 1 
03AF: set_streaming 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 
01B4: set_player $PLAYER_CHAR controllable 1 
0336: set_player $PLAYER_CHAR visible 1 
03F7: load_island_data 1 // Industrial
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
01F5: $PLAYER_ACTOR = create_emulated_actor_from_player $PLAYER_CHAR 
if
	8118:   not actor $PLAYER_ACTOR dead
then
	if
		0038:   $MASTERDEBUG == 1
	then
		0352: set_actor $PLAYER_ACTOR skin_to 'PLAYER'
	else
		0352: set_actor $PLAYER_ACTOR skin_to 'PLAYERP'
	end
	while 8248:   not model #NULL available 
		wait 0 ms
	end
	if
		8118:   not actor $PLAYER_ACTOR dead
	then
		0353: refresh_actor $PLAYER_ACTOR
	end
end

0373: set_camera_directly_behind_player
0296: unload_special_actor 2 
0296: unload_special_actor 3 
0296: unload_special_actor 4 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #CUTOBJ05 

// *******************************END OF JAIL BREAK CUTSCENE***************************

043D: set_intro_is_playing 0 
043C: set_game_sounds_fade 1 
0421: force_rain 0 
004F: create_thread @EIGHTBALL_MISSION_LOOP 
0004: $ONMISSION = 0 
00D8: mission_has_finished 
004E: end_thread 

:SKIP_INTRO_BUTTON//////////////////////////////////////////////////////////
if
	0038: $SKIP_FLAG == 0
then
	if and
		80E1:   not is_button_pressed PAD1 CROSS
		80E1:   not is_button_pressed PAD1 START
	then
		0004: $SKIP_FLAG = 1
	end
end

if
	0038: $SKIP_FLAG == 1
then
	if or
		00E1:   is_button_pressed PAD1 CROSS
		00E1:   is_button_pressed PAD1 START
	then
		0004: $SKIP_FLAG = 2
		goto @SKIP_INTRO_HERE
	end
end
return//////////////////////////////////////////////////////////////////////

:DRAW_INTRO_TEXT//////////////////////////////////////////////////////////
0344: set_text_draw_linewidth 580.0 for_centered_text 
0349: text_draw_style = 0 
0342: set_text_draw_centered 1 
0340: set_text_draw_color 190 190 190 $TEXT_ALPHA 
033F: set_text_draw_letter_width_height 0.75 1.0 
0348: enable_text_draw_proportional 1 
0346: set_text_draw_background_color 0 0 0 $TEXT_ALPHA 
0345: enable_text_draw_background 1 
033E: text_draw 320.0 400.0 'PAPER1'  // *
if
	0038:   $TEXT_FADING_FLAG == 0 
then
	0008: $TEXT_ALPHA += 2 
	if 
		0018:   $TEXT_ALPHA > 255
	then
		0004: $TEXT_ALPHA = 255
	end
else
	000C: $TEXT_ALPHA -= 3 
	if 
		001A:   1 > $TEXT_ALPHA
	then
		0004: $TEXT_ALPHA = 0
	end
end
return//////////////////////////////////////////////////////////////////////

:DO_BRIDGE_PARTICLES////////////////////////////////////////////////////////
if
	0019:   16@ > 6000  
then
	0006: 16@ = 0
	039D: scatter_particles type 10 1.0 0 0 0 6000 from 791.625 -936.875 38.3125 to 0.0 0.0 0.0 
	039D: scatter_particles type 10 1.0 0 0 0 6000 from 788.3125 -938.4375 38.0625 to 0.0 0.0 0.0 
	039D: scatter_particles type 10 1.0 0 0 0 6000 from 786.4375 -942.375 39.75 to 0.0 0.0 0.0 
end
return//////////////////////////////////////////////////////////////////////
