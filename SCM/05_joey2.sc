// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 2****************************************
// ************************************Kill Chunky Dave***************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

:M05_FAREWELLCHUNKYLEECHONG

gosub @MISSION_START_JOEY2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_JOEY2
end

:MISSION_END_JOEY2
gosub @MISSION_CLEANUP_JOEY2
end_thread

// ***************************************Mission Start*************************************

:MISSION_START_JOEY2
0317: increment_mission_attempts 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_JOEY = 1 
03A4: name_thread 'JOEY2' 
0001: wait 0 ms 
0004: $FLAG_GUN_MESSAGE_JM2 = 0 
0004: $HAS_AUDIO_BEEN_ACTIVATED = 0 
023C: load_special_actor 'JOEY' as 1 
02F3: load_object #CUTOBJ01 'JOEYH' 
02F3: load_object #CUTOBJ02 'PLAYERH' 
02F3: load_object #CUTOBJ03 'TROLL' 
0247: request_model #JOGARAGEEXT 
0247: request_model #JOGARAGEINT 
038B: load_all_models_now 

while true
	if or
		8248:   not model #JOGARAGEEXT available 
		8248:   not model #JOGARAGEINT available 
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'J2_KCL' 
0244: set_cutscene_pos 1190.063 -869.8125 13.9375 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_JOEY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_JOEY 'JOEY' 
02F4: create_cutscene_actor $JOEY_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_JOEY 
02F5: set_head_anim $JOEY_CSHEAD 'JOEY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02E5: $CS_TROLL = create_cutscene_object #CUTOBJ03 
02E6: set_cutscene_anim $CS_TROLL 'TROLL' 
0395: clear_area 1 at 1191.875 -870.375 range 15.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 1191.875 -870.375 -100.0 
0171: set_player $PLAYER_CHAR z_angle_to 230.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
03AF: set_streaming 1 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   5118 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_A' duration 10000 ms flag 2  // Chunky Lee Chong is pushing spank for some new gang from Colombia... or Colorado... or something....
while 001A:   10669 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_B' duration 10000 ms flag 2  // I'm not really sure. Who needs details anyway.
while 001A:   13048 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_C' duration 10000 ms flag 2  // He's got a noodle stand down in China Town.
while 001A:   15427 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_D' duration 10000 ms flag 2  // That rat has sold his last stir fry.
while 001A:   17662 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_E' duration 10000 ms flag 2  // I want you to take him out!
while 001A:   18887 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_F' duration 10000 ms flag 2  // If you need a piece go around back of AmmuNation opposite the subway.
while 001A:   22708 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_G' duration 10000 ms flag 2  // Sort yourself with a nine, you know where it is, right?
while 001A:   25159 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'JM2_H' duration 10000 ms flag 2  // Well remember, just watch your back in China Town, it's Triad territory.
while 001A:   28982 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BE: clear_prints 
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

03AD: set_rubbish 1 
02EA: end_cutscene 
03C8: set_camera_directly_before_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
0249: release_model #JOGARAGEEXT 
0249: release_model #JOGARAGEINT 
023C: load_special_actor 'CHUNKY' as 2 
0247: request_model #GANG03 
0247: request_model #PEREN

while true
	if or
		823D:   not special_actor 2 loaded 
		8248:   not model #GANG03 available 
		8248:   not model #PEREN available
	jf break
	wait 0 ms
end //while

032B: $JOEY2_COLT45_PICKUP = create_weapon_pickup #COLT45 PICKUP_ONCE ammo 45 at 1080.5 -396.0 -100.0 
03DD: pickup $JOEY2_COLT45_PICKUP show_on_radar RADAR_SPRITE_WEAPON $BLIP2_JM2 
0107: $JOEY2_NOODLE_STAND = create_object #NOODLESBOX at 975.0 -720.0 14.0

// START OF MISSION

00A5: $JOEY2_PERENNIAL1 = create_car #PEREN at 1007.063 -756.375 14.5
0175: set_car $JOEY2_PERENNIAL1 z_angle_to 120.0 
020A: set_car $JOEY2_PERENNIAL1 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY

00A5: $JOEY2_PERENNIAL2 = create_car #PEREN at 912.25 -686.0625 14.5
0175: set_car $JOEY2_PERENNIAL2 z_angle_to 90.0 
020A: set_car $JOEY2_PERENNIAL2 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY

009A: $JOEY2_TRIAD1 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 976.0625 -715.25 14.1875
0173: set_actor $JOEY2_TRIAD1 z_angle_to 346.0 
01B2: give_actor $JOEY2_TRIAD1 weapon WEAPONTYPE_BASEBALLBAT ammo 0 
0194: set_actor $JOEY2_TRIAD1 objective_to_guard_point 976.0625 -715.25 14.1875 
0243: set_actor $JOEY2_TRIAD1 ped_stats_to PEDSTAT_TOUGH_GUY 
009A: $JOEY2_TRIAD2 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 975.6875 -724.6875 14.1875
0173: set_actor $JOEY2_TRIAD2 z_angle_to 222.0 
01B2: give_actor $JOEY2_TRIAD2 weapon WEAPONTYPE_BASEBALLBAT ammo 0 
0194: set_actor $JOEY2_TRIAD2 objective_to_guard_point 975.6875 -724.6875 14.1875 
0243: set_actor $JOEY2_TRIAD2 ped_stats_to PEDSTAT_TOUGH_GUY 
009A: $JOEY2_TRIAD3 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 984.0 -727.6875 14.1875
0173: set_actor $JOEY2_TRIAD3 z_angle_to 243.0 
01B2: give_actor $JOEY2_TRIAD3 weapon WEAPONTYPE_PISTOL ammo 100 
0194: set_actor $JOEY2_TRIAD3 objective_to_guard_point 984.0 -727.6875 14.1875 
0243: set_actor $JOEY2_TRIAD3 ped_stats_to PEDSTAT_TOUGH_GUY 
009A: $CHUNKY_LEE_CHONG = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 975.25 -720.375 14.1875
0173: set_actor $CHUNKY_LEE_CHONG z_angle_to 270.0 
0187: $JOEY2_CHUNKY_MARKER = create_marker_above_actor $CHUNKY_LEE_CHONG 
0192: set_actor $CHUNKY_LEE_CHONG objective_to_stand_still 
0243: set_actor $CHUNKY_LEE_CHONG ped_stats_to PEDSTAT_GEEK_GUY
0319: set_actor $CHUNKY_LEE_CHONG running 1
0223: set_actor $CHUNKY_LEE_CHONG health_to 1000 
035F: set_actor $CHUNKY_LEE_CHONG armour_to 500 
0446: set_actor $CHUNKY_LEE_CHONG dismemberment_possible 0
018B: show_on_radar $JOEY2_CHUNKY_MARKER BLIP_ONLY
0245: set_actor $CHUNKY_LEE_CHONG walk_style_to ANIM_PANIC_CHUNKYPED

while 80FB:   not player $PLAYER_CHAR 0 $CHUNKY_LEE_CHONG radius 40.0 40.0 20.0 
	wait 0 ms
	gosub @STUFF_FOR_WHILE_LOOP_JOEY2
end //while

:KILL_AND_RUN
018B: show_on_radar $JOEY2_CHUNKY_MARKER BOTH
if
	8118:   not actor $JOEY2_TRIAD1 dead
then
	01CA: actor $JOEY2_TRIAD1 kill_player $PLAYER_CHAR 
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD1 to 0 
	011A: set_actor $JOEY2_TRIAD1 search_threat THREAT_PLAYER1
end
if
	8118:   not actor $JOEY2_TRIAD2 dead
then
	01CA: actor $JOEY2_TRIAD2 kill_player $PLAYER_CHAR 
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD2 to 0 
	011A: set_actor $JOEY2_TRIAD2 search_threat THREAT_PLAYER1
end
if
	8118:   not actor $JOEY2_TRIAD3 dead
then
	01CA: actor $JOEY2_TRIAD3 kill_player $PLAYER_CHAR 
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD3 to 0 
	011A: set_actor $JOEY2_TRIAD3 search_threat THREAT_PLAYER1
end
if
	8118:   not actor $CHUNKY_LEE_CHONG dead
then
	0291: set_actor $CHUNKY_LEE_CHONG attack_when_provoked 0 
	02A9: set_char_only_damaged_by_player $CHUNKY_LEE_CHONG to 0  
end

0239: actor $CHUNKY_LEE_CHONG run_to 975.5 -722.875 
0006: 17@ = 0

while 8126:   not actor $CHUNKY_LEE_CHONG walking
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @PICKUP_AND_AUDIO
end //while

if
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 974.1875 -727.5 1003.375 -748.75 sphere 0 
then
	0005: $CHUNKY_TARGET_X1 = 979.0625
	0005: $CHUNKY_TARGET_Y1 = -720.75
	0005: $CHUNKY_TARGET_X2 = 976.6875
	0005: $CHUNKY_TARGET_Y2 = -687.0
	0005: $CHUNKY_TARGET_X3 = 943.5
	0005: $CHUNKY_TARGET_Y3 = -679.1875
	0005: $CHUNKY_TARGET_X4 = 920.25
	0005: $CHUNKY_TARGET_Y4 = -681.5
	0084: $PERENNIAL_USED_JOEY2 = $JOEY2_PERENNIAL2
	0004: $RUN_THE_OTHER_WAY_FLAG = 1
else
	0005: $CHUNKY_TARGET_X1 = 985.0625
	0005: $CHUNKY_TARGET_Y1 = -733.875
	0005: $CHUNKY_TARGET_X2 = 1004.188
	0005: $CHUNKY_TARGET_Y2 = -736.875
	0005: $CHUNKY_TARGET_X3 = 1006.25
	0005: $CHUNKY_TARGET_Y3 = -753.1875
	0084: $PERENNIAL_USED_JOEY2 = $JOEY2_PERENNIAL1
	0004: $RUN_THE_OTHER_WAY_FLAG = 0
end

0239: actor $CHUNKY_LEE_CHONG run_to $CHUNKY_TARGET_X1 $CHUNKY_TARGET_Y1 

while 8126:   not actor $CHUNKY_LEE_CHONG walking
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @PICKUP_AND_AUDIO
end //while

0239: actor $CHUNKY_LEE_CHONG run_to $CHUNKY_TARGET_X2 $CHUNKY_TARGET_Y2 

while 8126:   not actor $CHUNKY_LEE_CHONG walking
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @PICKUP_AND_AUDIO
end //while

0239: actor $CHUNKY_LEE_CHONG run_to $CHUNKY_TARGET_X3 $CHUNKY_TARGET_Y3 

while 8126:   not actor $CHUNKY_LEE_CHONG walking
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @PICKUP_AND_AUDIO
end //while

if
	0038:   $RUN_THE_OTHER_WAY_FLAG == 1
then
	0239: actor $CHUNKY_LEE_CHONG run_to $CHUNKY_TARGET_X4 $CHUNKY_TARGET_Y4 
	while 8126:   not actor $CHUNKY_LEE_CHONG walking
		wait 0 ms
		gosub @CHECK_CHUNKY_STATUS_JOEY2
		gosub @PICKUP_AND_AUDIO
	end //while
end

gosub @CHECK_CHUNKY_STATUS_JOEY2
gosub @CHECK_CHUNKYS_CAR_STATUS_JOEY2

01D5: actor $CHUNKY_LEE_CHONG go_to_and_drive_car $PERENNIAL_USED_JOEY2

while 80DB:   not is_char_in_car $CHUNKY_LEE_CHONG car $PERENNIAL_USED_JOEY2
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @CHECK_CHUNKYS_CAR_STATUS_JOEY2
	gosub @CHECK_GUN_PICKED_UP_STATUS_JOEY2
end //while

if 
	8119:   not car $PERENNIAL_USED_JOEY2 wrecked 
then
	00A8: car_wander_randomly $PERENNIAL_USED_JOEY2 
	00AE: set_car_driving_style $PERENNIAL_USED_JOEY2 to DRIVINGMODE_AVOIDCARS
	00AD: set_car_cruise_speed $PERENNIAL_USED_JOEY2 to 50.0
end

while 0185:   car $PERENNIAL_USED_JOEY2 health >= 300 
	wait 0 ms
	gosub @CHECK_AMMU_BLOKE_AUDIO_REQUIRED_JOEY2
	if
		0119:   car $PERENNIAL_USED_JOEY2 wrecked
	then
		goto @MISSION_PASSED_JOEY2
	end
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @CHECK_RANGE_JOEY2
	if
		80DB:   not is_char_in_car $CHUNKY_LEE_CHONG car $PERENNIAL_USED_JOEY2 
	then
		goto @FUCKIN_RUN_FOR_IT
	end
	if and
		01F4:   car $PERENNIAL_USED_JOEY2 flipped 
		01C1:   car $PERENNIAL_USED_JOEY2 stopped
	then
		goto @FUCKIN_RUN_FOR_IT
	end
	gosub @CHECK_GUN_PICKED_UP_STATUS_JOEY2
end //while

gosub @CHECK_CHUNKY_STATUS_JOEY2

01D3: actor $CHUNKY_LEE_CHONG leave_car $PERENNIAL_USED_JOEY2 

while 00DB:   is_char_in_car $CHUNKY_LEE_CHONG car $PERENNIAL_USED_JOEY2
	wait 0 ms
	gosub @CHECK_AMMU_BLOKE_AUDIO_REQUIRED_JOEY2
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @CHECK_RANGE_JOEY2
	if
		0119:   car $PERENNIAL_USED_JOEY2 wrecked
	then
		goto @MISSION_PASSED_JOEY2
	end
	gosub @CHECK_GUN_PICKED_UP_STATUS_JOEY2
end //while

:FUCKIN_RUN_FOR_IT

if
	8118:   not actor $CHUNKY_LEE_CHONG dead 
then
	01D0: actor $CHUNKY_LEE_CHONG avoid_player $PLAYER_CHAR
end

while 8118:   not actor $CHUNKY_LEE_CHONG dead 
	wait 0 ms
	gosub @CHECK_CHUNKY_STATUS_JOEY2
	gosub @PICKUP_AND_AUDIO
	gosub @CHECK_AMMU_BLOKE_AUDIO_REQUIRED_JOEY2
	gosub @CHECK_RANGE_JOEY2
end //while

goto @MISSION_PASSED_JOEY2


/////////////////////////////////////////

:CHECK_CHUNKY_STATUS_JOEY2
if
	0118:   actor $CHUNKY_LEE_CHONG dead
then
	goto @MISSION_PASSED_JOEY2
end
return

/////////////////////////////////////////

:STUFF_FOR_WHILE_LOOP_JOEY2
gosub @CHECK_AMMU_BLOKE_AUDIO_REQUIRED_JOEY2
gosub @CHECK_CHUNKY_STATUS_JOEY2
gosub @CHECK_GUN_PICKED_UP_STATUS_JOEY2
if
	8118:   not actor $CHUNKY_LEE_CHONG dead
then
	02A9: set_char_only_damaged_by_player $CHUNKY_LEE_CHONG to 1 
	0226: $JOEY2_CHUNKY_HEALTH = actor $CHUNKY_LEE_CHONG health
end
if
	8118:   not actor $JOEY2_TRIAD1 dead
then
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD1 to 1 
	0226: $JOEY2_TRIAD1_HEALTH = actor $JOEY2_TRIAD1 health
end
if
	8118:   not actor $JOEY2_TRIAD2 dead
then
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD2 to 1 
	0226: $JOEY2_TRIAD2_HEALTH = actor $JOEY2_TRIAD2 health
end
if
	8118:   not actor $JOEY2_TRIAD3 dead
then
	02A9: set_char_only_damaged_by_player $JOEY2_TRIAD3 to 1 
	0226: $JOEY2_TRIAD3_HEALTH = actor $JOEY2_TRIAD3 health
end
if or
	001A:   99 > $JOEY2_TRIAD1_HEALTH 
	001A:   99 > $JOEY2_TRIAD2_HEALTH 
	001A:   99 > $JOEY2_TRIAD3_HEALTH 
	001A:   99 > $JOEY2_CHUNKY_HEALTH
	0118:   actor $JOEY2_TRIAD1 dead 
	0118:   actor $JOEY2_TRIAD2 dead 
	0118:   actor $JOEY2_TRIAD3 dead
then
	goto @KILL_AND_RUN
end
return

/////////////////////////////////////////

:CHECK_CHUNKYS_CAR_STATUS_JOEY2
if
	0119:   car $PERENNIAL_USED_JOEY2 wrecked
then
	goto @FUCKIN_RUN_FOR_IT
else
	if
		8185:   not car $PERENNIAL_USED_JOEY2 health >= 300
	then
		goto @FUCKIN_RUN_FOR_IT
	end
	if
		0038:   $RUN_THE_OTHER_WAY_FLAG == 1
	then
		if
			80B0:   not is_car_in_area_2d $PERENNIAL_USED_JOEY2 from 922.6875 -673.875 to 906.5625 -698.0 sphere 0
		then
			goto @FUCKIN_RUN_FOR_IT
		end
	else
		if
			80B0:   not is_car_in_area_2d $PERENNIAL_USED_JOEY2 from 1004.0 -738.0 to 1012.0 -763.0 sphere 0 
		then
			goto @FUCKIN_RUN_FOR_IT
		end
	end
end
return

/////////////////////////////////////////

:CHECK_GUN_PICKED_UP_STATUS_JOEY2
if and
	0214:   pickup $JOEY2_COLT45_PICKUP picked_up 
	0038:   $BEEN_IN_SHOP_BEFORE == 0 
then
	0164: disable_marker $BLIP2_JM2 
	0004: $BEEN_IN_SHOP_BEFORE = 1 
end
return

/////////////////////////////////////////

:CHECK_AMMU_BLOKE_AUDIO_REQUIRED_JOEY2
if
	8214:   not pickup $JOEY2_COLT45_PICKUP picked_up
then
	gosub @AMMU_BLOKE_AUDIO
end
return

/////////////////////////////////////////

:CHECK_RANGE_JOEY2
if
	80E9:   not player $PLAYER_CHAR 0 $CHUNKY_LEE_CHONG radius 160.0 160.0
then
	00BC: print_now 'AWAY' duration 5000 ms flag 2  // ~r~He's clean out of here!
	goto @MISSION_FAILED_JOEY2
end
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_JOEY2
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_JOEY2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_JOEY2
0004: $FAREWELL_CHUNKY_COMPLETED = 1 
0394: play_mission_passed_music 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 10000 
0318: set_latest_mission_passed 'JM2'  // 'FAREWELL 'CHUNKY' LEE CHONG'
030C: set_mission_points += 1 
004F: create_thread @JOEY_MISSION3_LOOP 
if 
	0038:   $DISPLAYED_PISTOL_NOW_AT_AMMUNITION_HELP_TEXT == 0 
then
	004F: create_thread @PISTOL_MESSAGE
end
goto @MISSION_END_JOEY2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_JOEY2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_JOEY = 0 
0004: $SPECIAL_AMMU_AUDIO = 0 
0249: release_model #GANG03 
0249: release_model #PEREN 
0296: unload_special_actor 2 
0164: disable_marker $JOEY2_CHUNKY_MARKER 
0164: disable_marker $BLIP2_JM2 
0215: destroy_pickup $JOEY2_COLT45_PICKUP  
if 
	8118:   not actor $CHUNKY_LEE_CHONG dead 
then
	034F: destroy_actor_with_fade $CHUNKY_LEE_CHONG
end
00D8: mission_has_finished 
return

/////////////////////////////////////////

:AMMU_BLOKE_AUDIO
if
	0038:   $HAS_AUDIO_BEEN_ACTIVATED == 0
then
	if
		0057:   is_player_in_area_3d $PLAYER_CHAR coords 1066.563 -403.5 14.0 to 1072.75 -394.0 18.0 sphere 0
	then
		0004: $SPECIAL_AMMU_AUDIO = 1
		03CF: load_wav 'AMMU_B' 
		if
			0038:   $CAMERA_AMMU1 == 1
		then
			if
				8118:   not actor $AMMU_SHOP_BLOKE1 dead
			then
				while 83D0:   not wav_loaded
					wait 0 ms
					if or
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						02DF: player $PLAYER_CHAR agressive
					then
						goto @CLEAR_AUDIO
					end
				end //while
				03D1: play_wav 
				00BC: print_now 'AMMU_B' duration 5000 ms flag 2  // Joey told me to tool you up...
				while 83D2:   not wav_ended 
					wait 0 ms
					if or
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						02DF: player $PLAYER_CHAR agressive
					then
						goto @CLEAR_AUDIO
					end
				end //while
				03CF: load_wav 'AMMU_C'
				while 83D0:   not wav_loaded
					wait 0 ms
					if or
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						02DF: player $PLAYER_CHAR agressive
					then
						goto @CLEAR_AUDIO
					end
				end //while
				03D1: play_wav 
				00BC: print_now 'AMMU_C' duration 5000 ms flag 2  // So go around back of the shop. I left you a nine in the yard.

:CLEAR_AUDIO

				0004: $HAS_AUDIO_BEEN_ACTIVATED = 1 
				0004: $SPECIAL_AMMU_AUDIO = 0
			else
				0004: $SPECIAL_AMMU_AUDIO = 0 
				040D: clear_mission_audio
			end
		end
	else
		0004: $SPECIAL_AMMU_AUDIO = 0 
		040D: clear_mission_audio
	end
end
return

/////////////////////////////////////////

:PICKUP_AND_AUDIO
gosub @CHECK_GUN_PICKED_UP_STATUS_JOEY2
if and
	8118:   not actor $CHUNKY_LEE_CHONG dead 
	0019:   17@ > 2500
then
	0006: 17@ = 0 
	041C: make_actor $CHUNKY_LEE_CHONG say SOUND_CHUNKY_RUN_SHOUT
end
return
