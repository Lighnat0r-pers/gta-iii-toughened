// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************Luigi Mission 2***************************************
// *******************************Donna' "Spank" Ma Bitch Up********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

:M02_DONTSPANKMABITCHUP
03A4: name_thread 'LUIGI2' 

// Mission start stuff

gosub @MISSION_START_LUIGI2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LUIGI2
end

:MISSION_END_LUIGI2
gosub @MISSION_CLEANUP_LUIGI2
end_thread    

// ********************************************Mission Start********************************

:MISSION_START_LUIGI2
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_LUIGI = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
0004: $FLAG_PLAYER_GOT_HELP_MESSAGE_LM2 = 0 
0004: $FLAG_VICTIM_PED_LM2_CHANGED = 0 
0004: $FLAG_VICTIM_DEAD_LM2 = 0 
0004: $FLAG_CAR_IN_GARAGE_LM2 = 0 
0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM2 = 0 
0004: $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 = 0 
0004: $FLAG_BUYER1_DEAD_LM2 = 0 
0004: $FLAG_BUYER2_DEAD_LM2 = 0 
0004: $FLAG_DONE_LOOKING_BIT_LM2 = 0 
0004: $FLAG_HAD_SPRAY_HELP = 0 
0004: $FLAG_PLAYER_HAD_BAT_MESSAGE_LM2 = 0 
0004: $FLAG_HAD_PATH_MESSAGE_LM2 = 0 
0004: $FLAG_LOCKUP_MESSAGE_LM2 = 0 
0004: $FLAG_GIRL1_RUNNING_LM2 = 0 
0004: $FLAG_GIRL2_RUNNING_LM2 = 0 
0004: $FLAG_PLAYER_IN_AREA_LM2 = 0 
0004: $FLAG_PLAYER_IN_CAR_LM2 = 0 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 0
0004: $PAYNSPRAYDONE = 0

0247: request_model #DOCKER2 
0247: request_model #PROSTITUTE 
0247: request_model #PROSTITUTE2 
0247: request_model #STALLION 
03E6: remove_text_box 

// ****************************************START OF CUTSCENE********************************

0247: request_model #INDHIBUILD3 
0247: request_model #LUIGICLUBOUT 
0247: request_model #LUIGIINEERCLUB 
023C: load_special_actor 'MICKY' as 1 
02F3: load_object #CUTOBJ01 'LUDOOR' 
02F3: load_object #CUTOBJ02 'MICKYH' 
02F3: load_object #CUTOBJ03 'PLAYERH' 
02F3: load_object #CUTOBJ04 'NOTE' 
03DE: set_ped_density_multiplier 0.0 
042B: clear_peds_from_cube 926.5 -471.6875 1.0 830.75 -257.9375 25.0 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ04 available 
	jf break
	wait 0 ms
end //while
while true
	if or
		8248:   not model #INDHIBUILD3 available 
		8248:   not model #LUIGICLUBOUT available 
		8248:   not model #LUIGIINEERCLUB available 
	jf break
	wait 0 ms
end //while

0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 0 
02E4: load_cutscene_data 'L2_DSB' 
0244: set_cutscene_pos 900.75 -427.5 13.8125 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_MICKY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_MICKY 'MICKY' 
02F4: create_cutscene_actor $MICKY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_MICKY 
02F5: set_head_anim $MICKY_CSHEAD 'MICKY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_LUDOOR = create_cutscene_object #CUTOBJ01 
02E6: set_cutscene_anim $CS_LUDOOR 'LUDOOR' 
02E5: $CS_NOTE = create_cutscene_object #CUTOBJ04 
02E6: set_cutscene_anim $CS_NOTE 'NOTE' 
0395: clear_area 1 at 896.5625 -426.1875 range 13.875 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 896.5625 -426.1875 13.875 
0171: set_player $PLAYER_CHAR z_angle_to 270.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime

// Displays cutscene text

while 001A:   5634 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_C' duration 10000 ms flag 1  // Luigi said to, to give you this so...
while 001A:   7989 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_D' duration 10000 ms flag 1  // here, here take it.
while 001A:   12078 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_A' duration 10000 ms flag 1  // There's a new high on the street goes by the name of SPANK.
while 001A:   15287 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_E' duration 10000 ms flag 1  // Some wiseguy's been introducing this trash to my girls down Portland Harbor.
while 001A:   19558 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_B' duration 10000 ms flag 1  // Go and introduce a bat to his face!
while 001A:   23042 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_F' duration 10000 ms flag 1  // Then take his car, respray it.
while 001A:   25852 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LM2_G' duration 10000 ms flag 1  // I want compensation for this insult!
while 001A:   28632 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LM2_G'  // I want compensation for this insult!
while 001A:   31000 > $CUT_SCENE_TIME
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
03AF: set_streaming 1 
03AD: set_rubbish 1 
03CB: load_scene 920.25 -425.375 15.0 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0373: set_camera_directly_behind_player 
0363: toggle_model_render_at 890.875 -416.875 15.0 radius 6.0 object #BACKDOOR 1 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #CUTOBJ04 
0249: release_model #INDHIBUILD3 
0249: release_model #LUIGICLUBOUT 
0249: release_model #LUIGIINEERCLUB 
03DE: set_ped_density_multiplier 1.0 

// *****************************************END OF CUTSCENE*********************************

022B: switch_ped_roads_off 1609.75 -615.1875 9.0 to 1557.75 -673.375 20.0 
0213: $BAT_LM2 = create_pickup #BAT type PICKUP_ONCE at 917.1875 -425.25 14.5 
03DC: $BAT_BLIP_LM2 = create_marker_above_pickup $BAT_LM2

while true
	if or
		8248:   not model #STALLION available 
		8248:   not model #DOCKER2 available 
		8248:   not model #PROSTITUTE available 
		8248:   not model #PROSTITUTE2 available 
	jf break
	wait 0 ms
end //while

while fading
	wait 0 ms
end

01B4: set_player $PLAYER_CHAR controllable 1 
00BC: print_now 'BAT1' duration 5000 ms flag 1  // ~g~Pick up the bat!

// creates the dealer
009A: $LUIGI2_DEALER = create_char PEDTYPE_CIVFEMALE model #DOCKER2 at 1399.625 -833.6875 -100.0
01BE: set_actor $LUIGI2_DEALER to_look_at_spot 1397.438 -835.5 10.75 
01ED: clear_actor $LUIGI2_DEALER threat_search 

// creates prostitute one
009A: $BUYER1_LM2 = create_char PEDTYPE_PROSTITUTE model #PROSTITUTE at 1397.188 -832.8125 -100.0
01ED: clear_actor $BUYER1_LM2 threat_search 
01BE: set_actor $BUYER1_LM2 to_look_at_spot 1399.625 -833.6875 10.75 

// creates prostitute two
009A: $BUYER2_LM2 = create_char PEDTYPE_PROSTITUTE model #PROSTITUTE2 at 1397.25 -834.375 -100.0
01ED: clear_actor $BUYER2_LM2 threat_search 
01BE: set_actor $BUYER2_LM2 to_look_at_spot 1399.625 -833.6875 10.75 

// dealers car
00A5: $LUIGI2_DEALER_CAR = create_car #STALLION at 1396.625 -837.6875 -100.0
0175: set_car $LUIGI2_DEALER_CAR z_angle_to 301.0 
0135: set_car $LUIGI2_DEALER_CAR door_lock CARLOCK_LOCKED
0187: $LUIGI2_DEALER_MARKER = create_marker_above_actor $LUIGI2_DEALER 

if and
	8118:   not actor $LUIGI2_DEALER dead 
	8118:   not actor $BUYER1_LM2 dead
then
	03F9: make_actors $LUIGI2_DEALER $BUYER1_LM2 converse_in -1 ms 
end

wait 0 ms 
0006: 17@ = 0 

while 8118:   not actor $LUIGI2_DEALER dead
	gosub @GIRLS_RUNNING
	if and
		0038:   $FLAG_PLAYER_HAD_BAT_MESSAGE_LM2 == 0
		0214:   pickup $BAT_LM2 picked_up 
	then
		0164: disable_marker $BAT_BLIP_LM2 
		03D5: remove_text 'BAT1'  // ~g~Pick up the bat!
		0004: $FLAG_PLAYER_HAD_BAT_MESSAGE_LM2 = 1 
	end
	if
		0118:   actor $LUIGI2_DEALER dead 
	then
		0164: disable_marker $LUIGI2_DEALER_MARKER 
		0004: $FLAG_VICTIM_DEAD_LM2 = 1
	end
	gosub @CHECK_BUYER_STATUS_LUIGI2
	gosub @CHECK_VEHICLE_STATUS_LUIGI2
	if or
		0038:   $FLAG_DONE_LOOKING_BIT_LM2 == 1 
		0057:   is_player_in_area_3d $PLAYER_CHAR coords 1430.75 -807.0 9.0 to 1355.188 -883.1875 20.0 sphere 0 
	then
		0004: $FLAG_DONE_LOOKING_BIT_LM2 = 1 
		0004: $FLAG_PLAYER_IN_AREA_LM2 = 1 
		if
			0038:   $FLAG_VICTIM_DEAD_LM2 == 0
		then
			if and
				00FB:   player $PLAYER_CHAR 0 $LUIGI2_DEALER radius 10.0 10.0 10.0 
				0038:   $FLAG_VICTIM_PED_LM2_CHANGED == 0
			then
				020F: actor $LUIGI2_DEALER look_at_player $PLAYER_CHAR 
				011A: set_actor $LUIGI2_DEALER search_threat THREAT_PLAYER1
				0243: set_actor $LUIGI2_DEALER ped_stats_to PEDSTAT_TOUGH_GUY
				0291: set_actor $LUIGI2_DEALER attack_when_provoked 1 
				01CA: actor $LUIGI2_DEALER kill_player $PLAYER_CHAR 
				0004: $FLAG_VICTIM_PED_LM2_CHANGED = 1
			end
		end
	end
	wait 0 ms
end //while

if and
	8214:   not pickup $BAT_LM2 picked_up 
	0038:   $FLAG_PLAYER_HAD_BAT_MESSAGE_LM2 == 0
then
	00BC: print_now 'NOBAT' duration 5000 ms flag 1  // ~r~You forgot the bat!
	goto @MISSION_FAILED_LUIGI2
end

0164: disable_marker $LUIGI2_DEALER_MARKER 

gosub @CHECK_VEHICLE_STATUS_LUIGI2

0135: set_car $LUIGI2_DEALER_CAR door_lock CARLOCK_UNLOCKED
0186: $LUIGI2_DEALER_CAR_MARKER = create_marker_above_car $LUIGI2_DEALER_CAR 
00BC: print_now 'LM2_1' duration 7000 ms flag 1  // ~g~Take his car and get it resprayed.

// waiting for the player to get into the car



while 80DC:   not is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
	wait 0 ms
	gosub @GIRLS_RUNNING
	gosub @CHECK_VEHICLE_STATUS_LUIGI2
	gosub @CHECK_BUYER_STATUS_LUIGI2
end //while

0004: $FLAG_PLAYER_IN_CAR_LM2 = 1 
0335: set_free_paynspray_to 1 
0329:   garage $PORTLAND_PAYNSPRAY_GARAGE respray_done

:RESPRAY_BIT_LUIGI2
0164: disable_marker $LUIGI2_DEALER_CAR_MARKER 
02A8: $LUIGI2_SPRAYSHOP_MARKER = create_marker RADAR_SPRITE_SPRAY at 924.0 -361.0 10.0 
03BC: $SPHERE1_LM2 = create_sphere 925.0625 -350.5 9.25 radius 2.5 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 1

// waiting for the player to respray the car

while true
	if or
		8329:   not garage $PORTLAND_PAYNSPRAY_GARAGE respray_done 
		80DC:   not is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
		8199:   not player $PLAYER_CHAR 0 922.5625 -366.0625 928.5625 -354.25
	jf break
	wait 0 ms
	gosub @CHECK_VEHICLE_STATUS_LUIGI2
	gosub @CHECK_BUYER_STATUS_LUIGI2
	gosub @CHECK_IN_VEHICLE_STATUS_LUIGI2
	if and
		00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 925.0625 -350.5 9.25 radius 2.5 2.5 2.5 
		00DC:   is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
	then
		0004: $FLAG_HAD_SPRAY_HELP = 1
		03BD: destroy_sphere $SPHERE1_LM2 
	end
end //while

0335: set_free_paynspray_to 0
03BD: destroy_sphere $SPHERE1_LM2 
0164: disable_marker $LUIGI2_SPRAYSHOP_MARKER 
018A: $LUIGI2_LOCKUP_MARKER = create_checkpoint_at 1087.0 -574.0 -100.0 
03BC: $SPHERE2_LM2 = create_sphere 1088.375 -574.375 13.6875 radius 2.5 
0004: $CURRENT_STEP_FOR_BLIP_MANIPULATION = 2
0004: $FLAG_BLIP2_ON_LM2 = 1 
021B: set_garage $LUIGIS_LOCKUP_GARAGE to_accept_car $LUIGI2_DEALER_CAR 
0006: 17@ = 0 

// Waiting for the player to get back to luigi's

while 821C:   not car_inside_garage $LUIGIS_LOCKUP_GARAGE 
	wait 0 ms
	if and
		0038:   $FLAG_LOCKUP_MESSAGE_LM2 == 0 
		0029:   17@ >= 3000 
	then
		00BC: print_now 'LM2_3' duration 7000 ms flag 1  // ~g~Stash the car in Luigi's lockup!
		0004: $FLAG_LOCKUP_MESSAGE_LM2 = 1
	end
	gosub @CHECK_VEHICLE_DAMAGED_LUIGI2
	if
		0038:   $FLAG_CAR_IN_GARAGE_LM2 == 0 
	then
		gosub @CHECK_VEHICLE_STATUS_LUIGI2
		gosub @CHECK_IN_VEHICLE_STATUS_LUIGI2
		if and
			0038:   $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 == 0 
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car 1088.375 -574.375 13.6875 radius 2.5 2.5 2.5 
			00DC:   is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
		then
			03E5: text_box 'GARAGE'  // Drive the vehicle into the garage, then walk outside.
			03BD: destroy_sphere $SPHERE2_LM2 
			0004: $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 = 1	
		end
		if and
			80F7:   not player $PLAYER_CHAR sphere 0 near_point_in_car 1088.375 -574.375 13.6875 radius 2.5 2.5 2.5 
			0038:   $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 == 1
		then
			0004: $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 = 0
		end
	end
	if
		8119:   not car $LUIGI2_DEALER_CAR wrecked 
	then
		if
			0422:   garage_contain_car $LUIGIS_LOCKUP_GARAGE $LUIGI2_DEALER_CAR
		then
			0004: $FLAG_CAR_IN_GARAGE_LM2 = 1
		else
			0004: $FLAG_CAR_IN_GARAGE_LM2 = 0
		end
	end
end //while

0164: disable_marker $LUIGI2_LOCKUP_MARKER 
03BD: destroy_sphere $SPHERE2_LM2 

goto @MISSION_PASSED_LUIGI2

/////////////////////////////////////////

:CHECK_BUYER_STATUS_LUIGI2
if
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 1430.75 -807.0 9.0 to 1355.188 -883.1875 20.0 sphere 0 
then
	if or
		0118:   actor $BUYER1_LM2 dead 
		0118:   actor $BUYER2_LM2 dead 
	then
		00BC: print_now 'GRLDED' duration 5000 ms flag 1  // ~r~Luigi's girls are dead! He won't be too pleased..
		goto @MISSION_FAILED_LUIGI2
	end
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_STATUS_LUIGI2
if
	0119:   car $LUIGI2_DEALER_CAR wrecked
then
	00BC: print_now 'WRECKED' duration 5000 ms flag 1  // ~r~The vehicle is wrecked!
	goto @MISSION_FAILED_LUIGI2
end
if and
	01F4:   car $LUIGI2_DEALER_CAR flipped 
	01C1:   car $LUIGI2_DEALER_CAR stopped 
then
	00BC: print_now 'UPSIDE' duration 5000 ms flag 1  // ~r~You flipped your wheels!
	goto @MISSION_FAILED_LUIGI2
end
return

/////////////////////////////////////////

:CHECK_VEHICLE_DAMAGED_LUIGI2
if
	8119:   not car $LUIGI2_DEALER_CAR wrecked
then
	if or
		8185:   not car $LUIGI2_DEALER_CAR health >= 950 
		03C9:   car $LUIGI2_DEALER_CAR damaged 
	then
		00BC: print_now 'JM1_4' duration 5000 ms flag 2  // ~g~You're trashing the vehicle! Get it repaired!
		0164: disable_marker $LUIGI2_LOCKUP_MARKER
		03BD: destroy_sphere $SPHERE2_LM2
		goto @RESPRAY_BIT_LUIGI2
	end
end
return

/////////////////////////////////////////

:CHECK_IN_VEHICLE_STATUS_LUIGI2
if and
	80DC:   not is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
	0038:   $FLAG_PLAYER_HAD_CAR_MESSAGE_LM2 == 0 
then
	00BC: print_now 'IN_VEH' duration 7000 ms flag 1  // ~g~Hey! Get back in the vehicle!
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		0164: disable_marker $LUIGI2_SPRAYSHOP_MARKER 
		03BD: destroy_sphere $SPHERE1_LM2 
	else
		0164: disable_marker $LUIGI2_LOCKUP_MARKER
		03BD: destroy_sphere $SPHERE2_LM2
	end
	0186: $LUIGI2_DEALER_CAR_MARKER = create_marker_above_car $LUIGI2_DEALER_CAR 
	0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM2 = 1 
end
if and
	00DC:   is_player_in_car $PLAYER_CHAR car $LUIGI2_DEALER_CAR 
	0038:   $FLAG_PLAYER_HAD_CAR_MESSAGE_LM2 == 1 
then
	0164: disable_marker $LUIGI2_DEALER_CAR_MARKER 
	if 
		0038:   $CURRENT_STEP_FOR_BLIP_MANIPULATION == 1
	then
		02A8: $LUIGI2_SPRAYSHOP_MARKER = create_marker RADAR_SPRITE_SPRAY at 924.0 -361.0 10.0
		if
			0038:   $FLAG_HAD_SPRAY_HELP == 0 
		then
			03BC: $SPHERE1_LM2 = create_sphere 925.0625 -350.5 9.25 radius 2.5
		end
	else
		018A: $LUIGI2_LOCKUP_MARKER = create_checkpoint_at 1087.0 -574.0 -100.0
		if
			0038:   $FLAG_PLAYER_HAD_GARAGE_MESSAGE_LM2 == 0 
		then
			03BC: $SPHERE2_LM2 = create_sphere 1088.375 -574.375 13.6875 radius 2.5 
		end
	end
	0004: $FLAG_PLAYER_HAD_CAR_MESSAGE_LM2 = 0 
end
return

/////////////////////////////////////////

// Mission Failed
:MISSION_FAILED_LUIGI2
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_LUIGI2


/////////////////////////////////////////

// Mission Passed
:MISSION_PASSED_LUIGI2
0004: $DONT_SPANK_MA_BITCH_UP_COMPLETED = 1 
0318: set_latest_mission_passed 'LM2'  // 'DON'T SPANK MA BITCH UP'
030C: set_mission_points += 1 
01E3: text_1number_styled 'M_PASS' number 4000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 4000 
0110: clear_player $PLAYER_CHAR wanted_level 
004F: create_thread @LUIGI_MISSION3_LOOP 
goto @MISSION_END_LUIGI2

/////////////////////////////////////////

// Mission Cleanup
:MISSION_CLEANUP_LUIGI2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LUIGI = 0 
if
	0038:   $FLAG_PLAYER_HAD_BAT_MESSAGE_LM2 == 0 
then
	0164: disable_marker $BAT_BLIP_LM2 
	0215: destroy_pickup $BAT_LM2
end
if
	8119:   not car $LUIGI2_DEALER_CAR wrecked
then
	0135: set_car $LUIGI2_DEALER_CAR door_lock CARLOCK_UNLOCKED
end
021B: set_garage $LUIGIS_LOCKUP_GARAGE to_accept_car -1 
0249: release_model #STALLION 
0249: release_model #DOCKER2 
0249: release_model #PROSTITUTE 
0249: release_model #PROSTITUTE2 
0164: disable_marker $LUIGI2_DEALER_MARKER 
0164: disable_marker $LUIGI2_DEALER_CAR_MARKER 
0164: disable_marker $LUIGI2_SPRAYSHOP_MARKER 
0164: disable_marker $LUIGI2_LOCKUP_MARKER 
0164: disable_marker $BAT_BLIP_LM2 
03BD: destroy_sphere $SPHERE1_LM2 
03BD: destroy_sphere $SPHERE2_LM2 
0335: set_free_paynspray_to 0 
022A: switch_ped_roads_on 1609.75 -615.1875 9.0 to 1557.75 -673.375 20.0 
00D8: mission_has_finished 
return 

/////////////////////////////////////////

:GIRLS_RUNNING
if and
	0038:   $FLAG_PLAYER_IN_CAR_LM2 == 0 
	0038:   $FLAG_PLAYER_IN_AREA_LM2 == 1
	0038:   $FLAG_VICTIM_PED_LM2_CHANGED == 1 
then

	// checks for girl1
	if
		0038:   $FLAG_BUYER1_DEAD_LM2 == 0
	then
		if
			0118:   actor $BUYER1_LM2 dead
		then
			0004: $FLAG_BUYER1_DEAD_LM2 = 1
		else
			if
				0038:   $FLAG_GIRL1_RUNNING_LM2 == 0 
			then
				0239: actor $BUYER1_LM2 run_to 1387.188 -837.375 
				0004: $FLAG_GIRL1_RUNNING_LM2 = 1
			end
			if and
				0038:   $FLAG_GIRL1_RUNNING_LM2 == 1
				00FF:   actor $BUYER1_LM2 #NULL 1387.188 -837.375 10.75 radius 4.0 4.0 4.0
			then
				01D0: actor $BUYER1_LM2 avoid_player $PLAYER_CHAR 
				0004: $FLAG_GIRL1_RUNNING_LM2 = 2
			end
		end
	end

	// checks for girl2
	if
		0038:   $FLAG_BUYER2_DEAD_LM2 == 0
	then
		if
			0118:   actor $BUYER2_LM2 dead
		then
			0004: $FLAG_BUYER2_DEAD_LM2 = 1
		else
			if
				0038:   $FLAG_GIRL2_RUNNING_LM2 == 0 
			then
				0239: actor $BUYER2_LM2 run_to 1385.938 -839.25 
				0004: $FLAG_GIRL2_RUNNING_LM2 = 1
			end
			if and
				0038:   $FLAG_GIRL2_RUNNING_LM2 == 1
				00FF:   actor $BUYER2_LM2 #NULL 1385.938 -839.25 10.75 radius 4.0 4.0 4.0 
			then
				01D0: actor $BUYER2_LM2 avoid_player $PLAYER_CHAR 
				0004: $FLAG_GIRL2_RUNNING_LM2 = 2
			end
		end
	end
end
return
