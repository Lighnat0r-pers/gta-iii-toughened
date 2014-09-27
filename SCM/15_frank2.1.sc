// *****************************************************************************************
// *****************************************************************************************
// *************************************Frankie Mission 2.1*********************************
// ************************************Bomb Da Base Cash Wall*******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M15_BOMBDABASEACTI

gosub @MISSION_START_FRANK21
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_FRANK21
end

:MISSION_END_FRANK21
gosub @MISSION_CLEANUP_FRANK21
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_FRANK21
0004: $ONMISSION = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
0004: $ON_MISSION_FOR_FRANK = 1 

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'FRANKIE' as 1 
02F3: load_object #CUTOBJ01 'FRANKH' 
0247: request_model #GANG02 
0247: request_model #FRANKSCLB02 
0247: request_model #SALVSDETAIL 
0247: request_model #SWANK_INSIDE 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #GANG02 available 
		8248:   not model #FRANKSCLB02 available 
		8248:   not model #SALVSDETAIL available 
		8248:   not model #SWANK_INSIDE available
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'S3_RTC' 
0244: set_cutscene_pos 1457.75 -185.3125 54.875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_SALVATORE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_SALVATORE 'FRANKIE' 
02F4: create_cutscene_actor $SALVATORE_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_SALVATORE 
02F5: set_head_anim $SALVATORE_CSHEAD 'FRANK' 
02E5: $CUTSCENE_MAFIA = create_cutscene_object #GANG02 
02E6: set_cutscene_anim $CUTSCENE_MAFIA 'GANG02' 
0395: clear_area 1 at 1455.063 -187.75 range -100.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1455.063 -187.75 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   5136 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_C' duration 10000 ms flag 1  // ~w~The Cartel has got bottomless funds from pushing that SPANK crap.
while 001A:   8848 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_D' duration 10000 ms flag 1  // ~w~If we make an open attack on them, they'll wipe the floor with us.
while 001A:   12450 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_E' duration 10000 ms flag 1  // ~w~They must be making SPANK on that big boat that Curly lead you to.

while 001A:   15984 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_F' duration 10000 ms flag 1  // ~w~So we gotta use our heads, or rather one head. Your head.
while 001A:   20426 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_G' duration 10000 ms flag 1  // ~w~I'm asking you to destroy that SPANK factory as a personal favor to me, Salvatore Leone.
while 001A:   27076 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_H' duration 10000 ms flag 1  // ~w~If you do this for me, you will be a made man, anything you want.
while 001A:   32651 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'FM3_I' duration 10000 ms flag 1  // ~w~Go and see 8-Ball, you'll need his expertise to blow-up that boat.
while 001A:   36233 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'FM3_I'  // ~w~Go and see 8-Ball, you'll need his expertise to blow-up that boat.
while 001A:   38333 > $CUT_SCENE_TIME
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
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #GANG02 
0249: release_model #FRANKSCLB02 
0249: release_model #SALVSDETAIL 
0249: release_model #SWANK_INSIDE

// *******************************************END OF CUTSCENE*******************************

goto @MISSION_PASSED_FRANK21

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_FRANK21
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_FRANK21

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_FRANK21
0004: $BOMB_DA_BASE_ACT_I_COMPLETED = 1 
0004: $FLAG_FRANKIE_SWITCHED_OFF = 1 
0318: set_latest_mission_passed 'FM21'  // 'BOMB DA BASE: ACT I'
030C: set_mission_points += 1 
0164: disable_marker $SALVATORE_MISSION_MARKER 
02A7: $8BALL_CONTACT_POINT = create_icon_marker_and_sphere RADAR_SPRITE_EIGHT at 1272.188 -92.875 -100.0 
004F: create_thread @FRANKIE_MISSION3_LOOP
goto @MISSION_END_FRANK21

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_FRANK21
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_FRANK = 0 
00D8: mission_has_finished 
return
