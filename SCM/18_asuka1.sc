// *****************************************************************************************
// *******************************   Asuka mission 1   ************************************* 
// ******************************* Salvatore's Sendoff *************************************
// *****************************************************************************************
// *** Salvatore will be leaving Luigi's Club in 3 hours. The player will have to kill 	 ***
// *** him before he arrives at his mansion. He will come out of the club with a very 	 ***
// *** large Mafia escort. (3 cars full and 5 extra goons) If the player is spotted 	 ***
// *** before Salvatore leaves the club, they will attack. 				 ***
// *****************************************************************************************

// Mission start stuff

:M18_SAYONARASALVATORE

gosub @MISSION_START_ASUKA1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_ASUKA1
end

:MISSION_END_ASUKA1
gosub @MISSION_CLEANUP_ASUKA1
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_ASUKA1

0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_ASUKA1 = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
03A4: name_thread 'ASUKA1' 
0004: $ASUKA1_SALVATORE_LEAVING_TIME_HOURS = 0 
0004: $ASUKA1_SALVATORE_LEAVING_TIME_MINS = 0 
0004: $ASUKA1_MINS_TO_SALVATORE_LEAVES = 0 
0004: $MAFIA_8_FLAG = 0 
0004: $MAFIA_9_FLAG = 0 
0004: $MAFIA_10_FLAG = 0 
0004: $MAFIA_11_FLAG = 0 
0004: $MAFIA_12_FLAG = 0 
0004: $MAFIA_13_FLAG = 0 
0004: $FRANKIE_FLAG = 0 
0004: $SET_BEAMER_1_KILL_PLAYER = 0 
0004: $SET_BEAMER_2_KILL_PLAYER = 0 
0004: $SET_BEAMER_3_KILL_PLAYER = 0 
0004: $BEAMER1_HEALTH = 0 
0004: $GARAGE_DOOR_CLOSE = 0 
0004: $TIMERA_RESET_FLAG_A1 = 0 
0004: $TIMERB_RESET_FLAG_A1 = 0 
0004: $TIMERC_RESET_FLAG_A1 = 0 
0004: $TIMERC_STARTED_A1 = 0 
0004: $TIMERC_CURRENT_A1 = 0 
0004: $TIMERC_A1 = 0 
0004: $DOOR_CRASH_FLAG = 0 
0004: $SPOTTED_PRINT = 0 
0004: $FRANKIES_RIDE = 0 
0004: $BEAMER_1_DEAD_FLAG = 0 
0004: $BEAMER_2_DEAD_FLAG = 0 
0004: $BEAMER_3_DEAD_FLAG = 0 
0004: $ENTER_CAR_FLAG = 0 
0004: $FUCKERS_CAR = -1 
0004: $FRANKIE_EXISTS_FLAG = 0 
0004: $MAFIA_5_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_7_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_8_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_9_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_10_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_11_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_12_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_13_KILL_PLAYER_FLAG = 0 
0004: $MAFIA_15_KILL_PLAYER_FLAG = 0 
0004: $TIMERX_RESET_FLAG = 0 
0004: $TIMERY_RESET_FLAG = 0 
0004: $TIMERZ_RESET_FLAG = 0 
0005: $MAFIA_CAR1_STUCK_X = 0.0 
0005: $MAFIA_CAR1_STUCK_Y = 0.0 
0005: $MAFIA_CAR1_STUCK_Z = 0.0 
0005: $MAFIA_CAR2_STUCK_X = 0.0 
0005: $MAFIA_CAR2_STUCK_Y = 0.0 
0005: $MAFIA_CAR2_STUCK_Z = 0.0 
0005: $MAFIA_CAR3_STUCK_X = 0.0 
0005: $TAIL_CAR_ASUKA2 = 0.0 
0005: $MAFIA_CAR3_STUCK_Z = 0.0 
023C: load_special_actor 'ASUKA' as 1 
023C: load_special_actor 'MARIA' as 2 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'ASUKAH' 
02F3: load_object #CUTOBJ03 'MARIAH' 
0247: request_model #CONDO_IVY 
0247: request_model #KMRICNDO01 
038B: load_all_models_now 


while true
	if or
		823D:   not special_actor 1 loaded 
		823D:   not special_actor 2 loaded 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #CUTOBJ03 available 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CONDO_IVY available 
		8248:   not model #KMRICNDO01 available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'A1_SS0' 
0244: set_cutscene_pos 523.0625 -636.9375 15.5625 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_ASUKA = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_ASUKA 'ASUKA' 
02E5: $CUTSCENE_MARIA = create_cutscene_object #SPECIAL02 
02E6: set_cutscene_anim $CUTSCENE_MARIA 'MARIA' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $ASUKA_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_ASUKA 
02F5: set_head_anim $ASUKA_CSHEAD 'ASUKA' 
02F4: create_cutscene_actor $MARIA_CSHEAD from_head #CUTOBJ03 and_body $CUTSCENE_MARIA 
02F5: set_head_anim $MARIA_CSHEAD 'MARIA' 
0395: clear_area 1 at 523.5625 -639.375 range 16.5625 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 523.5625 -639.375 16.0 
0171: set_player $PLAYER_CHAR z_angle_to 180.0 
016A: fade 1 for 1500 ms 
02E7: start_cutscene 
03AD: set_rubbish 0 
02E8: $CUT_SCENE_TIME = cutscenetime 

// Displays cutscene text

while 001A:   5353 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_A' duration 15000 ms flag 1  // We have certain issues to clear up before we can continue any form of relationship,
while 001A:   9624 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_B' duration 15000 ms flag 1  // business or otherwise. Lets lay our cards on the table.
while 001A:   13409 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_C' duration 15000 ms flag 1  // I am Yakuza and I know you worked for Salvatore Leone's family.
while 001A:   17788 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_D' duration 15000 ms flag 1  // I can give you work with our organization,
while 001A:   20113 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_E' duration 15000 ms flag 1  // But first you must prove to me that your ties with the Mafia are truly broken.
while 001A:   25303 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

00BF: get_time_of_day $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS 
0008: $ASUKA1_SALVATORE_LEAVING_TIME_HOURS += 3
if
	0018:   $ASUKA1_SALVATORE_LEAVING_TIME_HOURS > 23
then
	000C: $ASUKA1_SALVATORE_LEAVING_TIME_HOURS -= 24
end
0004: $ASUKA1_SALVATORE_LEAVING_TIME_MINS = 30
if
	0018:   $ASUKA1_SALVATORE_LEAVING_TIME_HOURS > 9
then
	02FD: text_2numbers_lowpriority 'AM1_F' numbers $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS duration 15000 ms flag 1  // Salvatore Leone will be leaving Luigi's in about three hours time. (~1~:~1~)
else
	02FD: text_2numbers_lowpriority 'AM1_K' numbers $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS duration 15000 ms flag 1  // Salvatore Leone will be leaving Luigi's in about three hours time. (0~1~:~1~)
end
while 001A:   29629 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_G' duration 15000 ms flag 1  // Make sure he doesn't reach his club alive.
while 001A:   32657 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_H' duration 15000 ms flag 1  // Meanwhile Maria and I will catch up on old times.
while 001A:   37360 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_I' duration 15000 ms flag 1  // Oh..Asuka, you've got a massager.
while 001A:   40118 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'AM1_J' duration 15000 ms flag 1  // That's not a massager.
while 001A:   41666 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1500 ms

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

03AF: set_streaming 1 
03AD: set_rubbish 1 
00BE: clear_prints 

while fading
	wait 0 ms
end

02EA: end_cutscene 
016A: fade 0 for 0 ms 
03C8: set_camera_directly_before_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms

while fading
	wait 0 ms
end

0296: unload_special_actor 1 
0296: unload_special_actor 2 
0249: release_model #CONDO_IVY 
0249: release_model #KMRICNDO01 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #CUTOBJ03 
023C: load_special_actor 'FRANKIE' as 1 
0247: request_model #GANG01 
0247: request_model #GANG02 
0247: request_model #MAFIA 

while true
	if or
		8248:   not model #MAFIA available 
		8248:   not model #GANG01 available 
		8248:   not model #GANG02 available 
		823D:   not special_actor 1 loaded
	jf break
	wait 0 ms
end //while

0005: $CREATE_CHAR_IN_CLUB_X = 894.0 
0005: $CREATE_CHAR_IN_CLUB_Y = -417.0 
0005: $CREATE_CHAR_IN_CLUB_Z = 15.25 
018A: $ASUKA1_SALVATORE_MARKER = create_checkpoint_at $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y $CREATE_CHAR_IN_CLUB_Z 
0005: $BOTTOM_OF_STEPS_X = 885.5 
0005: $BOTTOM_OF_STEPS_Y = -417.0 
0005: $BACK_OF_ALLEY_X = 886.0 
0005: $BACK_OF_ALLEY_Y = -425.75 
0005: $STREET_X = 902.6875 
0005: $STREET_Y = -425.625 
0005: $MAFIA_9_X = 887.5625
0005: $MAFIA_9_Y = -415.25
0005: $MAFIA_10_X = 901.6875 
0005: $MAFIA_10_Y = -422.625 
0005: $MAFIA_11_X = 903.6875 
0005: $MAFIA_11_Y = -422.625 
0005: $MAFIA_12_X = 903.6875 
0005: $MAFIA_12_Y = -427.625 
0005: $MAFIA_13_X = 901.6875 
0005: $MAFIA_13_Y = -427.625 
0004: $MAFIA_8_FLAG = 0 
0004: $MAFIA_9_FLAG = 0 
0004: $MAFIA_10_FLAG = 0 
0004: $MAFIA_11_FLAG = 0 
0004: $MAFIA_12_FLAG = 0 
0004: $MAFIA_13_FLAG = 0 
0004: $KILL_PLAYER_NOW_FLAG = 0 
00BC: print_now 'AM1_5' duration 5000 ms flag 1  // ~g~Get to the Red Light District and wait for Salvatore to leave the club.

if
	0018:   $ASUKA1_SALVATORE_LEAVING_TIME_HOURS > 9
then
	02FE: text_2numbers_highpriority 'AM1_8' numbers $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS duration 5000 ms flag 1  // ~g~Salvatore will be leaving Luigi's at about ~1~:~1~
else
	02FE: text_2numbers_highpriority 'AM1_10' numbers $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS duration 5000 ms flag 1  // ~g~Salvatore will be leaving Luigi's at about 0~1~:~1~
end

while 83C6:   not current_island == LEVEL_INDUSTRIAL
	wait 0 ms
	00C1: $ASUKA1_MINS_TO_SALVATORE_LEAVES = get_minutes_until_time_of_day $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS
	if
		001A:   1 > $ASUKA1_MINS_TO_SALVATORE_LEAVES
	then
		00BC: print_now 'AM1_3' duration 5000 ms flag 1  // ~r~You've missed Salvatore!
		goto @MISSION_FAILED_ASUKA1
	end
end //while

while 8056:   not is_player_in_area_2d $PLAYER_CHAR coords 875.0 -400.0 to 895.0 -430.0 sphere 0
	wait 0 ms
	gosub @CHECK_SPOT_MESSAGE_ASUKA1
end //while

01E8: switch_roads_off 905.0 -448.5625 12.0 to 916.0 -393.0 20.0 
02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_MISSION

if
	00E3:   player $PLAYER_CHAR 0 908.25 -86.0 radius 100.0 100.0 
then
	0005: $WORKING_X_A1 = 1123.625 
	0005: $WORKING_Y_A1 = -81.25 
	0005: $WORKING_Z_A1 = 7.0 
else
	0005: $WORKING_X_A1 = 908.25 
	0005: $WORKING_Y_A1 = -86.0 
	0005: $WORKING_Z_A1 = 7.0 
end

00A5: $ASUKA1_MAFIA_CAR1 = create_car #MAFIA at $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1
0174: $MAFIA_CAR_HEADING = car $ASUKA1_MAFIA_CAR1 z_angle 
000D: $MAFIA_CAR_HEADING -= 180.0 
0175: set_car $ASUKA1_MAFIA_CAR1 z_angle_to $MAFIA_CAR_HEADING 
020A: set_car $ASUKA1_MAFIA_CAR1 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
02AA: set_car $ASUKA1_MAFIA_CAR1 immune_to_nonplayer 1 
03ED: set_car $ASUKA1_MAFIA_CAR1 not_damaged_when_upside_down 1 
0009: $WORKING_Y_A1 += 11.0 
00A5: $ASUKA1_MAFIA_CAR2 = create_car #MAFIA at $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1
0175: set_car $ASUKA1_MAFIA_CAR2 z_angle_to $MAFIA_CAR_HEADING 
020A: set_car $ASUKA1_MAFIA_CAR2 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
02AA: set_car $ASUKA1_MAFIA_CAR2 immune_to_nonplayer 1 
03ED: set_car $ASUKA1_MAFIA_CAR2 not_damaged_when_upside_down 1 
0009: $WORKING_Y_A1 += 11.0 
00A5: $ASUKA1_MAFIA_CAR3 = create_car #MAFIA at $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1
0175: set_car $ASUKA1_MAFIA_CAR3 z_angle_to $MAFIA_CAR_HEADING 
020A: set_car $ASUKA1_MAFIA_CAR3 door_status_to CARLOCK_LOCKOUT_PLAYER_ONLY
02AA: set_car $ASUKA1_MAFIA_CAR3 immune_to_nonplayer 1 
03ED: set_car $ASUKA1_MAFIA_CAR3 not_damaged_when_upside_down 1

0129: $ASUKA1_MAFIA1 = create_actor PEDTYPE_GANG_MAFIA #GANG02 in_car $ASUKA1_MAFIA_CAR1 driverseat 
0129: $ASUKA1_MAFIA2 = create_actor PEDTYPE_GANG_MAFIA #GANG01 in_car $ASUKA1_MAFIA_CAR2 driverseat 
0129: $ASUKA1_MAFIA3 = create_actor PEDTYPE_GANG_MAFIA #GANG01 in_car $ASUKA1_MAFIA_CAR3 driverseat
01C8: $ASUKA1_MAFIA4 = create_actor PEDTYPE_GANG_MAFIA model #GANG01 in_car $ASUKA1_MAFIA_CAR3 passenger_seat 0
01C8: $ASUKA1_MAFIA5 = create_actor PEDTYPE_GANG_MAFIA model #GANG02 in_car $ASUKA1_MAFIA_CAR3 passenger_seat 1 
01C8: $ASUKA1_MAFIA6 = create_actor PEDTYPE_GANG_MAFIA model #GANG02 in_car $ASUKA1_MAFIA_CAR1 passenger_seat 0 
01C8: $ASUKA1_MAFIA7 = create_actor PEDTYPE_GANG_MAFIA model #GANG01 in_car $ASUKA1_MAFIA_CAR1 passenger_seat 1 
01C8: $ASUKA1_MAFIA14 = create_actor PEDTYPE_GANG_MAFIA model #GANG02 in_car $ASUKA1_MAFIA_CAR2 passenger_seat 0
011A: set_actor $ASUKA1_MAFIA1 search_threat THREAT_PLAYER1 
011A: set_actor $ASUKA1_MAFIA2 search_threat THREAT_PLAYER1
011A: set_actor $ASUKA1_MAFIA3 search_threat THREAT_PLAYER1
011A: set_actor $ASUKA1_MAFIA4 search_threat THREAT_PLAYER1
011A: set_actor $ASUKA1_MAFIA5 search_threat THREAT_PLAYER1 
011A: set_actor $ASUKA1_MAFIA6 search_threat THREAT_PLAYER1
011A: set_actor $ASUKA1_MAFIA7 search_threat THREAT_PLAYER1
011A: set_actor $ASUKA1_MAFIA14 search_threat THREAT_PLAYER1
0243: set_actor $ASUKA1_MAFIA1 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA2 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA3 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA4 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA5 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA6 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA7 ped_stats_to PEDSTAT_TOUGH_GUY 
0243: set_actor $ASUKA1_MAFIA14 ped_stats_to PEDSTAT_TOUGH_GUY 
01B2: give_actor $ASUKA1_MAFIA1 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA2 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA3 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA4 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA5 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA6 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA7 weapon WEAPONTYPE_UZI ammo 999 
01B2: give_actor $ASUKA1_MAFIA14 weapon WEAPONTYPE_UZI ammo 999 
0005: $WORKING_X_A1 = 908.0 
0005: $WORKING_Y_A1 = -435.5 
0005: $WORKING_Z_A1 = 14.5 
00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR1 coords $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1 
0009: $WORKING_Y_A1 += 7.0 
00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR2 coords $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1 
0009: $WORKING_Y_A1 += 7.0 
00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR3 coords $WORKING_X_A1 $WORKING_Y_A1 $WORKING_Z_A1 
00AE: set_car_driving_style $ASUKA1_MAFIA_CAR1 to DRIVINGMODE_AVOIDCARS
00AE: set_car_driving_style $ASUKA1_MAFIA_CAR2 to DRIVINGMODE_AVOIDCARS
00AE: set_car_driving_style $ASUKA1_MAFIA_CAR3 to DRIVINGMODE_AVOIDCARS
00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR1 to 15.0 
00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR2 to 14.0 
00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR3 to 13.0 

if
	03CA:   object $LUIGI_BACKDOOR exists 
then
	0176: $DOOR_POSITION_A1 = object $LUIGI_BACKDOOR z_angle
end

03CF: load_wav 'A1_A' 

0006: 16@ = 0 
0004: $SKIP_FLAG = 0 

while true
	if or
		001A:   3 > $MAFIA_8_FLAG 
		001A:   3 > $MAFIA_9_FLAG 
		001A:   3 > $MAFIA_10_FLAG 
		001A:   3 > $MAFIA_11_FLAG 
		001A:   3 > $MAFIA_12_FLAG 
		001A:   3 > $MAFIA_13_FLAG
	jf break
	wait 0 ms
	if
		8038:   not  $ASUKA1_MINS_TO_SALVATORE_LEAVES == 0
	then
		00C1: $ASUKA1_MINS_TO_SALVATORE_LEAVES = get_minutes_until_time_of_day $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS
	end
	gosub @CHECK_SPOT_MESSAGE_ASUKA1

	if
		8042:   not  $DOOR_POSITION_A1 == 90.0
	then
		0005: $DIFF_HEADING_DOOR = 90.0 
		0061: $DIFF_HEADING_DOOR -= $DOOR_POSITION_A1 
		if
			0022:   10.0 > $DIFF_HEADING_DOOR
		then
			0005: $DOOR_POSITION_A1 = 90.0
		else
			0009: $DOOR_POSITION_A1 += 10.0 
		end
		0177: set_object $LUIGI_BACKDOOR z_angle_to $DOOR_POSITION_A1 
		0004: $DOOR_CRASH_FLAG = 1
	end

	//____CREATE MAFIA 8 TO GUARD THE STEPS____//

	if
		0038:   $MAFIA_8_FLAG == 0 
	then
		009A: $ASUKA1_MAFIA8 = create_char PEDTYPE_GANG_MAFIA model #GANG02 at $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y $CREATE_CHAR_IN_CLUB_Z
		0243: set_actor $ASUKA1_MAFIA8 ped_stats_to PEDSTAT_TOUGH_GUY 
		01B2: give_actor $ASUKA1_MAFIA8 weapon WEAPONTYPE_UZI ammo 999 
		0211: actor $ASUKA1_MAFIA8 walk_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
		0004: $MAFIA_8_FLAG = 1
	else
		if
			0118:   actor $ASUKA1_MAFIA8 dead
		then
			0004: $KILL_PLAYER_NOW_FLAG = 1 
			0004: $MAFIA_8_FLAG = 4 
		else
			if and
				0038:   $MAFIA_8_FLAG == 1
				00ED:   actor $ASUKA1_MAFIA8 #NULL $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y radius 1.0 1.0 
			then
				0211: actor $ASUKA1_MAFIA8 walk_to 887.5625 -418.5 
				0004: $MAFIA_8_FLAG = 2
			end
			if and
				0038:   $MAFIA_8_FLAG == 2
				00F0:   actor $ASUKA1_MAFIA8 stopped #NULL 887.5625 -418.5 radius 0.5 0.5
			then
				0173: set_actor $ASUKA1_MAFIA8 z_angle_to 90.0 
				009F: char_set_idle $ASUKA1_MAFIA8 
				0004: $MAFIA_8_FLAG = 3
			end
			if and
				0123:   actor $ASUKA1_MAFIA8 spotted_player $PLAYER_CHAR 
				8056:   not is_player_in_area_2d $PLAYER_CHAR coords 845.75 -443.8125 890.75 -433.8125 sphere 0 // ON HIGHER ROOF ABOVE THE ALLEY
				8056:   not is_player_in_area_2d $PLAYER_CHAR coords 920.0625 -408.8125 931.3125 -398.0625 sphere 0 //ON TOP OF SNIPER BUILDING OVER ROAD
			then
				0004: $KILL_PLAYER_NOW_FLAG = 1
			end
		end
	end

	//____CREATE MAFIA 9 TO GUARD THE STEPS____//

	0084: $MAFIA_PREVIOUS_FLAG_ASUKA1 = $MAFIA_8_FLAG
	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_9_FLAG
	0084: $MAFIA_PREVIOUS_ASUKA1 = $ASUKA1_MAFIA8
	0086: $MAFIA_CURRENT_X = $MAFIA_9_X
	0086: $MAFIA_CURRENT_y = $MAFIA_9_Y
	gosub @CREATE_MAFIA_ASUKA1
	0084: $MAFIA_9_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1
	0084: $ASUKA1_MAFIA9 = $MAFIA_CURRENT_ASUKA1

	//___CREATE MAFIA 10 TO GUARD THE ALLEY____//

	0084: $MAFIA_PREVIOUS_FLAG_ASUKA1 = $MAFIA_9_FLAG
	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_10_FLAG
	0084: $MAFIA_PREVIOUS_ASUKA1 = $ASUKA1_MAFIA9
	0086: $MAFIA_CURRENT_X = $MAFIA_10_X
	0086: $MAFIA_CURRENT_y = $MAFIA_10_Y
	gosub @CREATE_MAFIA_ASUKA1
	0084: $MAFIA_10_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1
	0084: $ASUKA1_MAFIA10 = $MAFIA_CURRENT_ASUKA1

	//___CREATE MAFIA 11 TO GUARD THE ALLEY____//

	0084: $MAFIA_PREVIOUS_FLAG_ASUKA1 = $MAFIA_10_FLAG
	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_11_FLAG
	0084: $MAFIA_PREVIOUS_ASUKA1 = $ASUKA1_MAFIA10
	0086: $MAFIA_CURRENT_X = $MAFIA_11_X
	0086: $MAFIA_CURRENT_y = $MAFIA_11_Y
	gosub @CREATE_MAFIA_ASUKA1
	0084: $MAFIA_11_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1
	0084: $ASUKA1_MAFIA11 = $MAFIA_CURRENT_ASUKA1

	//___CREATE MAFIA 12 TO GUARD THE ALLEY____//

	0084: $MAFIA_PREVIOUS_FLAG_ASUKA1 = $MAFIA_11_FLAG
	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_12_FLAG
	0084: $MAFIA_PREVIOUS_ASUKA1 = $ASUKA1_MAFIA11
	0086: $MAFIA_CURRENT_X = $MAFIA_12_X
	0086: $MAFIA_CURRENT_y = $MAFIA_12_Y
	gosub @CREATE_MAFIA_ASUKA1
	0084: $MAFIA_12_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1
	0084: $ASUKA1_MAFIA12 = $MAFIA_CURRENT_ASUKA1

	//___CREATE MAFIA 13 TO GUARD THE ALLEY____//

	0084: $MAFIA_PREVIOUS_FLAG_ASUKA1 = $MAFIA_12_FLAG
	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_13_FLAG
	0084: $MAFIA_PREVIOUS_ASUKA1 = $ASUKA1_MAFIA12
	0086: $MAFIA_CURRENT_X = $MAFIA_13_X
	0086: $MAFIA_CURRENT_y = $MAFIA_13_Y
	gosub @CREATE_MAFIA_ASUKA1
	0084: $MAFIA_13_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1
	0084: $ASUKA1_MAFIA13 = $MAFIA_CURRENT_ASUKA1

	//_______CHECK IF THERE IS A CAR AT THE END OF THE ALLEY IF THERE IS ONE OF THE MAFIA WILL MOVE IT______//

	if
		001A:   1 > $FUCKERS_CAR 
	then
		0327: $FUCKERS_CAR = get_random_car_of_type -1 in_area 900.4375 -431.875 to 905.75 -419.9375 
	end

	if
		0119:   car $FUCKERS_CAR wrecked 
	then
		01C3: remove_references_to_car $FUCKERS_CAR 
		0004: $FUCKERS_CAR = -1 
		0004: $ENTER_CAR_FLAG = 0
	end

	if and
		001A:   5 > $ENTER_CAR_FLAG
		8038:   not  $FUCKERS_CAR == -1 
	then
		if
			003A:   $FUCKERS_CAR == $ASUKA1_MAFIA_CAR1
		then
			if
				8119:   not car $ASUKA1_MAFIA_CAR1 wrecked 
			then
				02C2: car $ASUKA1_MAFIA_CAR1 drive_to_point 904.875 -434.0625 15.0 
			else
				00A6: delete_car $ASUKA1_MAFIA_CAR1 
			end
		else
			if
				003A:   $FUCKERS_CAR == $ASUKA1_MAFIA_CAR2
			then
				if
					8119:   not car $ASUKA1_MAFIA_CAR2 wrecked 
				then
					02C2: car $ASUKA1_MAFIA_CAR2 drive_to_point 904.875 -434.0625 15.0 
				else
					00A6: delete_car $ASUKA1_MAFIA_CAR2
				end
			else
				if
					003A:   $FUCKERS_CAR == $ASUKA1_MAFIA_CAR3
				then
					if
						8119:   not car $ASUKA1_MAFIA_CAR3 wrecked 
					then
						02C2: car $ASUKA1_MAFIA_CAR3 drive_to_point 904.875 -434.0625 15.0 
					else
						00A6: delete_car $ASUKA1_MAFIA_CAR3
					end
				else
					if 
						001A:   4 > $MAFIA_10_FLAG
					then
						if
							0018:   $MAFIA_10_FLAG > 1 
						then
							if
								0203:   actor $ASUKA1_MAFIA10 near_car_on_foot $FUCKERS_CAR radius 4.0 4.0 unknown 0 
							then
								01D5: actor $ASUKA1_MAFIA10 go_to_and_drive_car $FUCKERS_CAR 
								0006: 16@ = 0 
								0004: $ENTER_CAR_FLAG = 10 
							end
						end
					else
						if 
							001A:   4 > $MAFIA_11_FLAG
						then
							if
								0018:   $MAFIA_11_FLAG > 1 
							then
								if
									0203:   actor $ASUKA1_MAFIA11 near_car_on_foot $FUCKERS_CAR radius 4.0 4.0 unknown 0 
								then
									01D5: actor $ASUKA1_MAFIA11 go_to_and_drive_car $FUCKERS_CAR 
									0006: 16@ = 0 
									0004: $ENTER_CAR_FLAG = 11 
								end
							end
						else
							if 
								001A:   4 > $MAFIA_12_FLAG
							then
								if
									0018:   $MAFIA_12_FLAG > 1 
								then
									if
										0203:   actor $ASUKA1_MAFIA12 near_car_on_foot $FUCKERS_CAR radius 4.0 4.0 unknown 0 
									then
										01D5: actor $ASUKA1_MAFIA12 go_to_and_drive_car $FUCKERS_CAR 
										0006: 16@ = 0 
										0004: $ENTER_CAR_FLAG = 12 
									end
								end
							else
								if 
									001A:   4 > $MAFIA_13_FLAG
								then
									if
										0018:   $MAFIA_13_FLAG > 1 
									then
										if
											0203:   actor $ASUKA1_MAFIA13 near_car_on_foot $FUCKERS_CAR radius 4.0 4.0 unknown 0 
										then
											01D5: actor $ASUKA1_MAFIA13 go_to_and_drive_car $FUCKERS_CAR 
											0006: 16@ = 0 
											0004: $ENTER_CAR_FLAG = 13 
										end
									end
								else
									if
										0119:   car $FUCKERS_CAR wrecked 
									then
										01C3: remove_references_to_car $FUCKERS_CAR 
										0004: $KILL_PLAYER_NOW_FLAG = 1
									end
								end
							end
						end
					end
				end
			end
		end
	end
	if
		0038:   $ENTER_CAR_FLAG == 10
	then
		if
			00DB:   is_char_in_car $ASUKA1_MAFIA10 car $FUCKERS_CAR 
		then
			gosub @MOVE_FUCKERS_CAR
			0004: $MAFIA_10_FLAG = 4 
			0004: $ENTER_CAR_FLAG = 5 
		end
	end
	if
		0038:   $ENTER_CAR_FLAG == 11
	then
		if
			00DB:   is_char_in_car $ASUKA1_MAFIA11 car $FUCKERS_CAR 
		then
			gosub @MOVE_FUCKERS_CAR
			0004: $MAFIA_11_FLAG = 4 
			0004: $ENTER_CAR_FLAG = 5 
		end
	end
	if
		0038:   $ENTER_CAR_FLAG == 12 
	then
		if
			00DB:   is_char_in_car $ASUKA1_MAFIA12 car $FUCKERS_CAR 
		then
			gosub @MOVE_FUCKERS_CAR
			0004: $MAFIA_12_FLAG = 4 
			0004: $ENTER_CAR_FLAG = 5 
		end
	end
	if
		0038:   $ENTER_CAR_FLAG == 13 
	then
		if
			00DB:   is_char_in_car $ASUKA1_MAFIA13 car $FUCKERS_CAR 
		then
			gosub @MOVE_FUCKERS_CAR
			0004: $MAFIA_13_FLAG = 4 
			0004: $ENTER_CAR_FLAG = 5 
		end
	end
	if and
		0018:   $ENTER_CAR_FLAG > 9 
		0019:   16@ > 20000 
		8119:   not car $FUCKERS_CAR wrecked 
	then
		if
			80DC:   not is_player_in_car $PLAYER_CHAR car $FUCKERS_CAR 
		then
			01C3: remove_references_to_car $FUCKERS_CAR 
			0004: $ENTER_CAR_FLAG = 0 
			0004: $FUCKERS_CAR = -1 
		else
			0004: $KILL_PLAYER_NOW_FLAG = 1
		end
	end
	if
		0019:   16@ > 180000 
	then
		0004: $FRANKIE_EXISTS_FLAG = 1
	end
	//____________________________________________________________________________________________________//

	if
		0038:   $KILL_PLAYER_NOW_FLAG == 1 
	then
		gosub @KILL_PLAYER_NOW_SCRIPT
	end

	if
		8038:   not  $FRANKIE_EXISTS_FLAG == 0 
	then
		goto @CREATE_SALVATORE
	end
end //while


if
	0038:   $FRANKIE_EXISTS_FLAG == 0 
then
	if or
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -427.375 to 890.75 -403.875 sphere 0 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -433.8125 to 890.75 -427.375 sphere 0
	then
		0004: $FRANKIE_EXISTS_FLAG = 2
	else
		0004: $FRANKIE_EXISTS_FLAG = 1
	end
end

:CREATE_SALVATORE
if
	0038: $FRANKIE_EXISTS_FLAG == 1
then
	009A: $SALVATORE = create_char PEDTYPE_SPECIAL model #SPECIAL01 at $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y $CREATE_CHAR_IN_CLUB_Z 
	if
		0038:   $KILL_PLAYER_NOW_FLAG == 0 
	then
		0211: actor $SALVATORE walk_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y
	else
		0239: actor $SALVATORE run_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
	end
end

if
	0038: $FRANKIE_EXISTS_FLAG == 2
then
	009A: $SALVATORE = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 900.1875 -416.875 14.0 
	0239: actor $SALVATORE run_to $STREET_X $STREET_Y 
	0004: $FRANKIE_FLAG = 5 
end
if
	0038: $FRANKIE_EXISTS_FLAG == 3
then
	009A: $SALVATORE = create_char PEDTYPE_SPECIAL model #SPECIAL01 at 884.625 -422.9375 14.0 
	0239: actor $SALVATORE run_to $STREET_X $STREET_Y 
	0004: $FRANKIE_FLAG = 5 
end

011A: set_actor $SALVATORE search_threat THREAT_PLAYER1 
0243: set_actor $SALVATORE ped_stats_to PEDSTAT_GEEK_GUY 
02A9: set_char_only_damaged_by_player $SALVATORE to 1 
0164: disable_marker $ASUKA1_SALVATORE_MARKER 
0187: $ASUKA1_SALVATORE_MARKER = create_marker_above_actor $SALVATORE 
00BC: print_now 'AM1_1' duration 5000 ms flag 1  // ~g~Salvatore is now leaving Luigi's!
0004: $GARAGE_DOOR_CLOSE = 0 

while 80DF:   not is_char_in_any_car $SALVATORE 
	wait 0 ms
	if
		0118:   actor $SALVATORE dead 
	then
		goto @MISSION_PASSED_ASUKA1
	end
	if
		8038:   not  $ASUKA1_MINS_TO_SALVATORE_LEAVES == 0 
	then
		00C1: $ASUKA1_MINS_TO_SALVATORE_LEAVES = get_minutes_until_time_of_day $ASUKA1_SALVATORE_LEAVING_TIME_HOURS $ASUKA1_SALVATORE_LEAVING_TIME_MINS 
	end
	if
		0123:   actor $SALVATORE spotted_player $PLAYER_CHAR 
	then
		0004: $KILL_PLAYER_NOW_FLAG = 1 
	end
	if
		8118:   not actor $ASUKA1_MAFIA8 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA8
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_8_FLAG = 4 
	end
	if
		8118:   not actor $ASUKA1_MAFIA9 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA9
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_9_FLAG = 4 
	end
	if
		8118:   not actor $ASUKA1_MAFIA10 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA10
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_10_FLAG = 4 
	end
	if
		8118:   not actor $ASUKA1_MAFIA11 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA11
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_11_FLAG = 4 
	end
	if
		8118:   not actor $ASUKA1_MAFIA12 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA12
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_12_FLAG = 4 
	end
	if
		8118:   not actor $ASUKA1_MAFIA13 dead
	then
		0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA13
		gosub @AI_STUFF_MAFIA_ASUKA1
	else
		0004: $KILL_PLAYER_NOW_FLAG = 1 
		0004: $MAFIA_13_FLAG = 4 
	end
	if
		0038:   $KILL_PLAYER_NOW_FLAG == 1 
	then
		gosub @KILL_PLAYER_NOW_SCRIPT
	end

	//___GET FRANKIE INTO A CAR, IF ALL CARS ARE DEAD FRANKIE RUNS BACK____//

	if
		0119:   car $ASUKA1_MAFIA_CAR1 wrecked 
	then
		0004: $BEAMER_1_DEAD_FLAG = 1 
	end
	if
		0119:   car $ASUKA1_MAFIA_CAR2 wrecked 
	then
		0004: $BEAMER_2_DEAD_FLAG = 1 
	end
	if
		0119:   car $ASUKA1_MAFIA_CAR3 wrecked 
	then
		0004: $BEAMER_3_DEAD_FLAG = 1 
	end

	if
		0038:   $FRANKIE_FLAG == 0
	then
		if
			00ED:   actor $SALVATORE #NULL $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y radius 1.0 1.0
		then
			0239: actor $SALVATORE run_to $STREET_X $STREET_Y 
			0004: $FRANKIE_FLAG = 5 
		end
	end

	if and
		0038:   $FRANKIE_FLAG == 1 
		0038:   $BEAMER_1_DEAD_FLAG == 1 
	then
		if and
			0038:   $BEAMER_3_DEAD_FLAG == 0
			0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR3 radius 30.0 30.0 unknown 0
		then
			01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR3 and_enter_it_as_a_passenger 
			0004: $FRANKIE_FLAG = 3 	 
		else
			0239: actor $SALVATORE run_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
			0004: $FRANKIE_FLAG = 4
		end
	end

	if and
		0038:   $FRANKIE_FLAG == 2 
		0038:   $BEAMER_2_DEAD_FLAG == 1 
	then
		if and
			0038:   $BEAMER_1_DEAD_FLAG == 0 
			0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR1 radius 30.0 30.0 unknown 0 
		then
			01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR1 and_enter_it_as_a_passenger 
			0004: $FRANKIE_FLAG = 1 
		else
			if and
				0038:   $BEAMER_3_DEAD_FLAG == 0 
				0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR3 radius 30.0 30.0 unknown 0 				
			then
				01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR3 and_enter_it_as_a_passenger 
				0004: $FRANKIE_FLAG = 3 
			else
				0239: actor $SALVATORE run_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
				0004: $FRANKIE_FLAG = 4
			end
		end
	end

	if and
		0038:   $FRANKIE_FLAG == 3 
		0038:   $BEAMER_3_DEAD_FLAG == 1 
	then
		if and
			0038:   $BEAMER_1_DEAD_FLAG == 0 
			0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR1 radius 30.0 30.0 unknown 0
		then
			01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR1 and_enter_it_as_a_passenger 
			0004: $FRANKIE_FLAG = 1 	 
		else
			0239: actor $SALVATORE run_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
			0004: $FRANKIE_FLAG = 4
		end
	end

	if and
		0038:   $FRANKIE_FLAG == 4
		00ED:   actor $SALVATORE #NULL $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y radius 1.0 1.0 
	then
		0239: actor $SALVATORE run_to $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y 
		0004: $FRANKIE_FLAG = 6 
	end

	if
		0038:   $FRANKIE_FLAG == 5 
	then
		if
			00ED:   actor $SALVATORE #NULL $STREET_X $STREET_Y radius 1.0 1.0 
		then
			if and
				0038:   $BEAMER_1_DEAD_FLAG == 0 
				0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR1 radius 30.0 30.0 unknown 0 
			then
				01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR1 and_enter_it_as_a_passenger 
				0004: $FRANKIE_FLAG = 1
			else
				if and
					0038:   $BEAMER_2_DEAD_FLAG == 0 
					0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR2 radius 30.0 30.0 unknown 0 
				then
					01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR2 and_enter_it_as_a_passenger 
					0004: $FRANKIE_FLAG = 2 
				else
					if and
						0038:   $BEAMER_3_DEAD_FLAG == 0 
						0203:   actor $SALVATORE near_car_on_foot $ASUKA1_MAFIA_CAR3 radius 30.0 30.0 unknown 0 
					then
						01D4: actor $SALVATORE go_to_car $ASUKA1_MAFIA_CAR3 and_enter_it_as_a_passenger 
						0004: $FRANKIE_FLAG = 3 
					else
						0239: actor $SALVATORE run_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
						0004: $FRANKIE_FLAG = 4 
					end
				end
			end
		end
	end

	if
		0038:   $FRANKIE_FLAG == 6
	then
		if
			00ED:   actor $SALVATORE #NULL $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y radius 1.0 1.0 
		then
			009B: delete_char $SALVATORE 
			00BC: print_now 'AM1_9' duration 5000 ms flag 1  // ~r~Salvatore has escaped back into Luigi's Club!
			goto @MISSION_FAILED_ASUKA1
		end
	end
end //while

if
	8119:   not car $ASUKA1_MAFIA_CAR1 wrecked 
then
	if
		0038:   $FRANKIE_FLAG == 1 
	then
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR1 coords 1438.0 -183.375 50.5 
		021B: set_garage $SALVATORES_GARAGE to_accept_car $ASUKA1_MAFIA_CAR1 
	else
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR1 coords 1423.688 -168.0625 50.1875 
	end

	if
		0038:   $KILL_PLAYER_NOW_FLAG == 0 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR1 to 20.0 
	else
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR1 to 45.0 
	end
end

if
	8119:   not car $ASUKA1_MAFIA_CAR2 wrecked 
then
	if
		0038:   $FRANKIE_FLAG == 2 
	then
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR3 coords 1438.0 -183.375 50.5 
		021B: set_garage $SALVATORES_GARAGE to_accept_car $ASUKA1_MAFIA_CAR2 
	else
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR2 coords 1418.688 -168.0625 50.1875 
	end

	if
		0038:   $KILL_PLAYER_NOW_FLAG == 0 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR2 to 20.0 
	else
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR2 to 45.0 
	end
end

if
	8119:   not car $ASUKA1_MAFIA_CAR3 wrecked 
then
	if
		0038:   $FRANKIE_FLAG == 3 
	then
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR3 coords 1438.0 -183.375 50.5 
		021B: set_garage $SALVATORES_GARAGE to_accept_car $ASUKA1_MAFIA_CAR3 
	else
		00A7: car_goto_coordinates $ASUKA1_MAFIA_CAR3 coords 1418.688 -168.0625 50.1875 
	end

	if
		0038:   $KILL_PLAYER_NOW_FLAG == 0 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR3 to 20.0 
	else
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR3 to 45.0 
	end
end

01E7: switch_roads_on 905.0 -448.5625 12.0 to 916.0 -393.0 20.0 
02FA: garage $SALVATORES_GARAGE change_to_type GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
if
	8118:   not actor $SALVATORE dead 
then
	035F: set_actor $SALVATORE armour_to 1000
end

0004: $TIMERB_RESET_FLAG_A1 = 0 
0006: 16@ = 0 
0006: 17@ = 0 

:CARS_GOING_TO_FRANKIES
while true
	wait 0 ms
	if
		0118:   actor $SALVATORE dead 
	then
		goto @MISSION_PASSED_ASUKA1
	end

	//_____SEND MAFIA_8X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_8_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA8
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_8_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____SEND MAFIA_9X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_9_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA9
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_9_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____SEND MAFIA_10X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_10_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA10
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_10_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____SEND MAFIA_11X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_11_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA8
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_11_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____SEND MAFIA_12X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_12_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA12
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_12_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____SEND MAFIA_13X BACK INTO THE CLUB THEN DELETE HIM____//

	0084: $MAFIA_CURRENT_FLAG_ASUKA1 = $MAFIA_13_FLAG
	0084: $MAFIA_CURRENT_ASUKA1 = $ASUKA1_MAFIA13
	gosub @RETREAT_MAFIA_ASUKA1
	0084: $MAFIA_13_FLAG = $MAFIA_CURRENT_FLAG_ASUKA1

	//_____          CARS - IF THEY'RE ATACKED THEY DRIVE FASTER                 _____//
	//_____    IF FRANKIES CAR IS ATTACKED BOTH OTHER CARS ATTACK THE PLAYER     _____//
	//_____IF ONE OF THE OTHER CARS IS DESTROYED THE OTHER WILL ATTACK THE PLAYER_____//

	if
		0118:   actor $SALVATORE dead 
	then
		goto @MISSION_PASSED_ASUKA1
	end

	if and
		0038:   $FRANKIES_RIDE == 0 
		00EE:   actor $SALVATORE 0 1371.0 -283.875 radius 50.0 50.0 
	then
		00D9: $FRANKIES_RIDE = store_car_char_is_in $SALVATORE 
		00AD: set_car_cruise_speed $FRANKIES_RIDE to 20.0 
	end

	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR1
	0084: $ASUKA1_MAFIA_CAR_OTHER1 = $ASUKA1_MAFIA_CAR2
	0084: $ASUKA1_MAFIA_CAR_OTHER2 = $ASUKA1_MAFIA_CAR3
	0004: $ASUKA1_FRANKIE_OTHER1 = 2
	0004: $ASUKA1_FRANKIE_OTHER2 = 3
	gosub @CAR_AI_STUFF_MAFIA_ASUKA1
	0084: $SET_BEAMER_2_KILL_PLAYER = $SET_BEAMER_OTHER1_KILL_PLAYER
	0084: $SET_BEAMER_3_KILL_PLAYER = $SET_BEAMER_OTHER2_KILL_PLAYER
	
	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR2
	0084: $ASUKA1_MAFIA_CAR_OTHER1 = $ASUKA1_MAFIA_CAR3
	0084: $ASUKA1_MAFIA_CAR_OTHER2 = $ASUKA1_MAFIA_CAR1
	0004: $ASUKA1_FRANKIE_OTHER1 = 3
	0004: $ASUKA1_FRANKIE_OTHER2 = 1
	gosub @CAR_AI_STUFF_MAFIA_ASUKA1
	0084: $SET_BEAMER_3_KILL_PLAYER = $SET_BEAMER_OTHER1_KILL_PLAYER
	0084: $SET_BEAMER_1_KILL_PLAYER = $SET_BEAMER_OTHER2_KILL_PLAYER

	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR2
	0084: $ASUKA1_MAFIA_CAR_OTHER1 = $ASUKA1_MAFIA_CAR2
	0084: $ASUKA1_MAFIA_CAR_OTHER2 = $ASUKA1_MAFIA_CAR1
	0004: $ASUKA1_FRANKIE_OTHER1 = 2
	0004: $ASUKA1_FRANKIE_OTHER2 = 1
	gosub @CAR_AI_STUFF_MAFIA_ASUKA1
	0084: $SET_BEAMER_2_KILL_PLAYER = $SET_BEAMER_OTHER1_KILL_PLAYER
	0084: $SET_BEAMER_1_KILL_PLAYER = $SET_BEAMER_OTHER2_KILL_PLAYER

	if and
		0038:   $SET_BEAMER_1_KILL_PLAYER == 1 
		8119:   not car $ASUKA1_MAFIA_CAR1 wrecked 
		803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR1 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR1 to 100.0 
		00AF: set_car_mission $ASUKA1_MAFIA_CAR1 to MISSION_RAMPLAYER_FARAWAY 
	end

	if and
		0038:   $SET_BEAMER_2_KILL_PLAYER == 1 
		8119:   not car $ASUKA1_MAFIA_CAR2 wrecked 
		803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR2 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR2 to 100.0 
		00AF: set_car_mission $ASUKA1_MAFIA_CAR2 to MISSION_RAMPLAYER_FARAWAY 
	end
	if and
		0038:   $SET_BEAMER_3_KILL_PLAYER == 1 
		8119:   not car $ASUKA1_MAFIA_CAR3 wrecked 
		803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR3 
	then
		00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR3 to 100.0 
		00AF: set_car_mission $ASUKA1_MAFIA_CAR3 to MISSION_RAMPLAYER_FARAWAY 
	end

	if
		0038:   $SET_BEAMER_1_KILL_PLAYER == 1 
	then
		if or
			8118:   not actor $ASUKA1_MAFIA1 dead 
			8119:   not car $ASUKA1_MAFIA_CAR1 wrecked
		then
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_CAR_A1 = store_car_player_is_in $PLAYER_CHAR 
				02E3: $PLAYERS_CAR_A1_SPEED = car $PLAYERS_CAR_A1 speed 
				02E3: $ASUKA1_MAFIA_CAR_SPEED = car $ASUKA1_MAFIA_CAR1 speed 
				if and
					0022:   10.0 > $ASUKA1_MAFIA_CAR_SPEED 
					0022:   6.0 > $PLAYERS_CAR_A1_SPEED 
					0204:   actor $ASUKA1_MAFIA1 near_car_in_car $PLAYERS_CAR_A1 radius 10.0 10.0 unknown 0
				then
					if
						8118:   not actor $ASUKA1_MAFIA6 dead 
					then
						01CC: actor $ASUKA1_MAFIA6 kill_player $PLAYER_CHAR 
						0319: set_actor $ASUKA1_MAFIA6 running 1 
					end
					if
						8118:   not actor $ASUKA1_MAFIA7 dead 
					then
						01CC: actor $ASUKA1_MAFIA7 kill_player $PLAYER_CHAR 
						0319: set_actor $ASUKA1_MAFIA7 running 1 
					end
				end
			end
		end
	end

	if
		0038:   $SET_BEAMER_2_KILL_PLAYER == 1 
	then
		if or
			8118:   not actor $ASUKA1_MAFIA2 dead 
			8119:   not car $ASUKA1_MAFIA_CAR2 wrecked
		then
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_CAR_A1 = store_car_player_is_in $PLAYER_CHAR 
				02E3: $PLAYERS_CAR_A1_SPEED = car $PLAYERS_CAR_A1 speed 
				02E3: $ASUKA1_MAFIA_CAR_SPEED = car $ASUKA1_MAFIA_CAR2 speed 
				if and
					0022:   10.0 > $ASUKA1_MAFIA_CAR_SPEED 
					0022:   6.0 > $PLAYERS_CAR_A1_SPEED 
					0204:   actor $ASUKA1_MAFIA2 near_car_in_car $PLAYERS_CAR_A1 radius 10.0 10.0 unknown 0
					8118:   not actor $ASUKA1_MAFIA14 dead 
				then
					01CC: actor $ASUKA1_MAFIA14 kill_player $PLAYER_CHAR 
					0319: set_actor $ASUKA1_MAFIA14 running 1 
				end
			end
		end
	end

	if
		0038:   $SET_BEAMER_3_KILL_PLAYER == 1 
	then
		if or
			8118:   not actor $ASUKA1_MAFIA3 dead 
			8119:   not car $ASUKA1_MAFIA_CAR3 wrecked
		then
			if
				00E0:   is_player_in_any_car $PLAYER_CHAR 
			then
				00DA: $PLAYERS_CAR_A1 = store_car_player_is_in $PLAYER_CHAR 
				02E3: $PLAYERS_CAR_A1_SPEED = car $PLAYERS_CAR_A1 speed 
				02E3: $ASUKA1_MAFIA_CAR_SPEED = car $ASUKA1_MAFIA_CAR3 speed 
				if and
					0022:   10.0 > $ASUKA1_MAFIA_CAR_SPEED 
					0022:   6.0 > $PLAYERS_CAR_A1_SPEED 
					0204:   actor $ASUKA1_MAFIA3 near_car_in_car $PLAYERS_CAR_A1 radius 10.0 10.0 unknown 0
				then
					if
						8118:   not actor $ASUKA1_MAFIA4 dead 
					then
						01CC: actor $ASUKA1_MAFIA4 kill_player $PLAYER_CHAR 
						0319: set_actor $ASUKA1_MAFIA4 running 1 
					end
					if
						8118:   not actor $ASUKA1_MAFIA5 dead 
					then
						01CC: actor $ASUKA1_MAFIA5 kill_player $PLAYER_CHAR 
						0319: set_actor $ASUKA1_MAFIA5 running 1 
					end
				end
			end
		end
	end

	//___________IF THE CARS GET STUCK OR UPSIDEDOWN THIS BIT WILL WARP THEM___________//

	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR1
	0004: $ASUKA1_FRANKIE_CURRENT = 1
	0084: $ASUKA_MAFIA_TEMP1 = $ASUKA1_MAFIA1
	0084: $ASUKA_MAFIA_TEMP2 = $ASUKA1_MAFIA7
	0084: $TIMER_TEMP1_STARTED_A1 = $TIMERA_STARTED_A1
	0084: $TIMER_TEMP1_RESET_FLAG_A1 = $TIMERA_RESET_FLAG_A1
	0004: $TIMER_TEMP1_TIMEOUT_TIME_A1 = 4000
	0084: $TIMER_TEMP2_STARTED_A1 = $TIMERX_STARTED_A1
	0084: $TIMER_TEMP2_RESET_FLAG_A1 = $TIMERX_RESET_FLAG_A1
	0086: $MAFIA_CAR_CURRENT_STUCK_X = $MAFIA_CAR1_STUCK_X
	0086: $MAFIA_CAR_CURRENT_STUCK_Y = $MAFIA_CAR1_STUCK_Z
	0086: $MAFIA_CAR_CURRENT_STUCK_Z = $MAFIA_CAR1_STUCK_Y
	gosub @CAR_STUCK_UPSIDEDOWN_CHECK_ASUKA1
	0084: $TIMERA_STARTED_A1 = $TIMER_TEMP1_STARTED_A1
	0084: $TIMERA_RESET_FLAG_A1 = $TIMER_TEMP1_RESET_FLAG_A1
	0084: $TIMERX_STARTED_A1 = $TIMER_TEMP2_STARTED_A1
	0084: $TIMERX_RESET_FLAG_A1 = $TIMER_TEMP2_RESET_FLAG_A1
	0086: $MAFIA_CAR1_STUCK_X = $MAFIA_CAR_CURRENT_STUCK_X
	0086: $MAFIA_CAR1_STUCK_Y = $MAFIA_CAR_CURRENT_STUCK_Y
	0086: $MAFIA_CAR1_STUCK_Z = $MAFIA_CAR_CURRENT_STUCK_Z

	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR2
	0004: $ASUKA1_FRANKIE_CURRENT = 2
	0084: $ASUKA_MAFIA_TEMP1 = $ASUKA1_MAFIA2
	0084: $ASUKA_MAFIA_TEMP2 = $ASUKA1_MAFIA14
	0084: $TIMER_TEMP1_STARTED_A1 = $TIMERB_STARTED_A1
	0084: $TIMER_TEMP1_RESET_FLAG_A1 = $TIMERB_RESET_FLAG_A1
	0004: $TIMER_TEMP1_TIMEOUT_TIME_A1 = 5000
	0084: $TIMER_TEMP2_STARTED_A1 = $TIMERY_STARTED_A1
	0084: $TIMER_TEMP2_RESET_FLAG_A1 = $TIMERY_RESET_FLAG_A1
	0086: $MAFIA_CAR_CURRENT_STUCK_X = $MAFIA_CAR2_STUCK_X
	0086: $MAFIA_CAR_CURRENT_STUCK_Y = $MAFIA_CAR2_STUCK_Z
	0086: $MAFIA_CAR_CURRENT_STUCK_Z = $MAFIA_CAR2_STUCK_Y
	gosub @CAR_STUCK_UPSIDEDOWN_CHECK_ASUKA1
	0084: $TIMERB_STARTED_A1 = $TIMER_TEMP1_STARTED_A1
	0084: $TIMERB_RESET_FLAG_A1 = $TIMER_TEMP1_RESET_FLAG_A1
	0084: $TIMERY_STARTED_A1 = $TIMER_TEMP2_STARTED_A1
	0084: $TIMERY_RESET_FLAG_A1 = $TIMER_TEMP2_RESET_FLAG_A1
	0086: $MAFIA_CAR2_STUCK_X = $MAFIA_CAR_CURRENT_STUCK_X
	0086: $MAFIA_CAR2_STUCK_Y = $MAFIA_CAR_CURRENT_STUCK_Y
	0086: $MAFIA_CAR2_STUCK_Z = $MAFIA_CAR_CURRENT_STUCK_Z

	0084: $ASUKA1_MAFIA_CAR_CURRENT = $ASUKA1_MAFIA_CAR3
	0004: $ASUKA1_FRANKIE_CURRENT = 3
	0084: $ASUKA_MAFIA_TEMP1 = $ASUKA1_MAFIA3
	0084: $ASUKA_MAFIA_TEMP2 = $ASUKA1_MAFIA4
	0084: $ASUKA_MAFIA_TEMP3 = $ASUKA1_MAFIA5
	0084: $TIMER_TEMP1_STARTED_A1 = $TIMERC_STARTED_A1
	0084: $TIMER_TEMP1_RESET_FLAG_A1 = $TIMERC_RESET_FLAG_A1
	0004: $TIMER_TEMP1_TIMEOUT_TIME_A1 = 5000
	0084: $TIMER_TEMP2_STARTED_A1 = $TIMERZ_STARTED_A1
	0084: $TIMER_TEMP2_RESET_FLAG_A1 = $TIMERZ_RESET_FLAG_A1
	0086: $MAFIA_CAR_CURRENT_STUCK_X = $MAFIA_CAR3_STUCK_X
	0086: $MAFIA_CAR_CURRENT_STUCK_Y = $MAFIA_CAR3_STUCK_Z
	0086: $MAFIA_CAR_CURRENT_STUCK_Z = $MAFIA_CAR3_STUCK_Y
	gosub @CAR_STUCK_UPSIDEDOWN_CHECK_ASUKA1
	0084: $TIMERC_STARTED_A1 = $TIMER_TEMP1_STARTED_A1
	0084: $TIMERC_RESET_FLAG_A1 = $TIMER_TEMP1_RESET_FLAG_A1
	0084: $TIMERZ_STARTED_A1 = $TIMER_TEMP2_STARTED_A1
	0084: $TIMERZ_RESET_FLAG_A1 = $TIMER_TEMP2_RESET_FLAG_A1
	0086: $MAFIA_CAR2_STUCK_X = $MAFIA_CAR_CURRENT_STUCK_X
	0086: $MAFIA_CAR2_STUCK_Y = $MAFIA_CAR_CURRENT_STUCK_Y
	0086: $MAFIA_CAR2_STUCK_Z = $MAFIA_CAR_CURRENT_STUCK_Z

	//___________THIS BIT OPENS THE GARAGE, IF FRANKIE GETS THERE MISSION FAILED_________//

	if and
		0038:   $GARAGE_DOOR_CLOSE == 0 
		00FE:   actor $SALVATORE 0 1426.0 -183.375 50.5 radius 15.0 12.0 6.0 
	then
		0360: open_garage $SALVATORES_GARAGE 
		0004: $GARAGE_DOOR_CLOSE = 1
	end
	if
		0038:   $GARAGE_DOOR_CLOSE == 1
	then
		if
			8057:   not is_player_in_area_3d $PLAYER_CHAR coords 1427.563 -187.25 49.5 to 1442.563 -179.0 53.75 sphere 0
		then
			if
				00A4:   is_char_in_area_3d $SALVATORE from 1428.75 -187.0 50.0 to 1442.5 -179.875 53.0 sphere 0 
			then
				0361: close_garage $SALVATORES_GARAGE 
				0004: $GARAGE_DOOR_CLOSE = 2 
			end
		else
			0360: open_garage $SALVATORES_GARAGE 
		end
	end

	if
		0038:   $GARAGE_DOOR_CLOSE == 2
	then
		if
			0057:   is_player_in_area_3d $PLAYER_CHAR coords 1427.563 -187.25 49.5 to 1442.563 -179.0 53.75 sphere 0 
		then
			0360: open_garage $SALVATORES_GARAGE 
			0004: $GARAGE_DOOR_CLOSE = 1 
		end
		if
			03B1:   garage $SALVATORES_GARAGE door_closed 
		then
			00BC: print_now 'AM1_7' duration 5000 ms flag 1  // ~r~Salvatore's home, safe and sipping a cocktail. Ain't no one gonna call you the 'Jackal'!
			goto @MISSION_FAILED_ASUKA1
		end
	end
end //while

/////////////////////////////////////////

:CREATE_MAFIA_ASUKA1
if and
	0018:   $MAFIA_PREVIOUS_FLAG_ASUKA1 > 0 
	0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 0
then
	0004: $DUMMY_VAR_ASUKA1 = 0
	if
		0118:   actor $MAFIA_PREVIOUS_ASUKA1 dead 
	then
		0004: $DUMMY_VAR_ASUKA1 = 1
	else
		if
			80ED:   not actor $MAFIA_PREVIOUS_ASUKA1 #NULL $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y radius 2.0 2.0 
		then
			0004: $DUMMY_VAR_ASUKA1 = 1
		end
	end
	if
		0038:   $DUMMY_VAR_ASUKA1 == 1 // Previous mafia dead or out of the way.
	then
		009A: $MAFIA_CURRENT_ASUKA1 = create_char PEDTYPE_GANG_MAFIA model #GANG01 at $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y $CREATE_CHAR_IN_CLUB_Z
		01B2: give_actor $MAFIA_CURRENT_ASUKA1 weapon WEAPONTYPE_SHOTGUN ammo 999
		0243: set_actor $MAFIA_CURRENT_ASUKA1 ped_stats_to PEDSTAT_TOUGH_GUY
		035F: set_actor $MAFIA_CURRENT_ASUKA1 armour_to 200 
		0211: actor $MAFIA_CURRENT_ASUKA1 walk_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 1
	end
else
	if
		0018:   $MAFIA_CURRENT_FLAG_ASUKA1 > 0 
	then
		if
			0118:   actor $MAFIA_CURRENT_ASUKA1 dead
		then
			0004: $KILL_PLAYER_NOW_FLAG = 1 
			0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 4
		end
	end
end
if
	0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 1
then
	if
		00ED:   actor $MAFIA_CURRENT_ASUKA1 #NULL $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y radius 1.0 1.0 
	then
		0211: actor $MAFIA_CURRENT_ASUKA1 walk_to $MAFIA_CURRENT_X $MAFIA_CURRENT_Y 
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 2
	end
end
if
	0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 2
then
	if
		00F0:   actor $MAFIA_CURRENT_ASUKA1 stopped #NULL $MAFIA_CURRENT_X $MAFIA_CURRENT_Y radius 0.5 0.5
	then
		0173: set_actor $MAFIA_CURRENT_ASUKA1 z_angle_to 90.0 
		009F: char_set_idle $MAFIA_CURRENT_ASUKA1
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 3
	end
end
if and
	0018:   $MAFIA_CURRENT_FLAG_ASUKA1 > 0 
	001A:   4 > $MAFIA_CURRENT_FLAG_ASUKA1
then
	gosub @AI_STUFF_MAFIA_ASUKA1
end
return

/////////////////////////////////////////

:AI_STUFF_MAFIA_ASUKA1
if and
	0123:   actor $MAFIA_CURRENT_ASUKA1 spotted_player $PLAYER_CHAR 
	8056:   not is_player_in_area_2d $PLAYER_CHAR coords 845.75 -443.8125 890.75 -433.8125 sphere 0 // ON HIGHER ROOF ABOVE THE ALLEY
	8056:   not is_player_in_area_2d $PLAYER_CHAR coords 920.0625 -408.8125 931.3125 -398.0625 sphere 0 //ON TOP OF SNIPER BUILDING OVER ROAD
then
	0004: $KILL_PLAYER_NOW_FLAG = 1
end
return


/////////////////////////////////////////

:RETREAT_MAFIA_ASUKA1
if and
	8038:   not  $MAFIA_CURRENT_FLAG_ASUKA1 == 4 
	0118:   actor $MAFIA_CURRENT_ASUKA1 dead
then
	0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 4 
end
if
	0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 3 
then
	0211: actor $MAFIA_CURRENT_ASUKA1 walk_to $BACK_OF_ALLEY_X $BACK_OF_ALLEY_Y 
	0291: set_actor $MAFIA_CURRENT_ASUKA1 attack_when_provoked 1 
	0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 5 
end
if
	8038:   not  $MAFIA_CURRENT_FLAG_ASUKA1 == 4 
then
	if and
		0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 5 
		00ED:   actor $MAFIA_CURRENT_ASUKA1 #NULL $BACK_OF_ALLEY_X $BACK_OF_ALLEY_Y radius 1.0 1.0 
	then
		0211: actor $MAFIA_CURRENT_ASUKA1 walk_to $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y 
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 6 
	end
	if and
		0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 6 
		00ED:   actor $MAFIA_CURRENT_ASUKA1 #NULL $BOTTOM_OF_STEPS_X $BOTTOM_OF_STEPS_Y radius 1.0 1.0 
	then
		0211: actor $MAFIA_CURRENT_ASUKA1 walk_to $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y 
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 7 
	end
	if and
		0038:   $MAFIA_CURRENT_FLAG_ASUKA1 == 7 
		00ED:   actor $MAFIA_CURRENT_ASUKA1 #NULL $CREATE_CHAR_IN_CLUB_X $CREATE_CHAR_IN_CLUB_Y radius 0.5 0.5 
	then
		009B: delete_char $MAFIA_CURRENT_ASUKA1 
		0004: $MAFIA_CURRENT_FLAG_ASUKA1 = 4 
	end
end
return

/////////////////////////////////////////

:CAR_AI_STUFF_MAFIA_ASUKA1
if
	8119:   not car $ASUKA1_MAFIA_CAR_CURRENT wrecked 
then
	0227: $BEAMER1_HEALTH = car $ASUKA1_MAFIA_CAR_CURRENT health 
	if
		001A:   1000 > $BEAMER1_HEALTH
	then
		if
			803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR_CURRENT 
		then
			00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR_CURRENT to 50.0 
		end
		if and
			8119:   not car $ASUKA1_MAFIA_CAR_OTHER1 wrecked 
			803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR_OTHER1 
		then
			if
				8038:   not  $ASUKA1_FRANKIE_OTHER1 == 2
			then
				0004: $SET_BEAMER_OTHER1_KILL_PLAYER = 1
			end
			00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR_OTHER1 to 50.0 
		end
		if and
			8119:   not car $ASUKA1_MAFIA_CAR_OTHER2 wrecked 
			803A:   not  $FRANKIES_RIDE == $ASUKA1_MAFIA_CAR_OTHER2 
		then
			00AD: set_car_cruise_speed $ASUKA1_MAFIA_CAR_OTHER2 to 50.0 
			if
				8038:   not  $ASUKA1_FRANKIE_OTHER2 == 2
			then
				0004: $SET_BEAMER_OTHER2_KILL_PLAYER = 1
			end
		end
	end
else
	if
		8119:   not car $ASUKA1_MAFIA_CAR_OTHER2 wrecked 
	then
		if
			803A:   not  $FRANKIE_FLAG == $ASUKA1_FRANKIE_OTHER2
		then
			0004: $SET_BEAMER_OTHER2_KILL_PLAYER = 1
		else
			if and
				8119:   not car $ASUKA1_MAFIA_CAR_OTHER1 wrecked 
				803A:   not  $FRANKIE_FLAG == $ASUKA1_FRANKIE_OTHER1 
			then
				0004: $SET_BEAMER_OTHER1_KILL_PLAYER = 1 
			end
		end
	end
end
return

/////////////////////////////////////////

:CAR_STUCK_UPSIDEDOWN_CHECK_ASUKA1
if
	8119:   not car $ASUKA1_MAFIA_CAR_CURRENT wrecked 
then
	if and
		01F4:   car $ASUKA1_MAFIA_CAR_CURRENT flipped 
		01C1:   car $ASUKA1_MAFIA_CAR_CURRENT stopped 
	then
		gosub @CAR_DO_STUFF_WHEN_STUCK_ASUKA1
	end
	if and
		0038:   $TIMER_TEMP1_RESET_FLAG_A1 == 1 
		81C1:   not car $ASUKA1_MAFIA_CAR_CURRENT stopped 
	then
		0004: $TIMER_TEMP1_RESET_FLAG_A1 = 0
	end
	if
		01C1:   car $ASUKA1_MAFIA_CAR_CURRENT stopped 
	then
		if
			0038:   $TIMER_TEMP1_RESET_FLAG_A1 == 0 
		then
			0004: $TIMER_TEMP1_RESET_FLAG_A1 = 1 
			01BD: $TIMER_TEMP1_STARTED_A1 = current_time_in_ms 
		end

		if
			0038:   $TIMER_TEMP1_RESET_FLAG_A1 == 1 
		then
			01BD: $TIMER_TEMP1_CURRENT_A1 = current_time_in_ms 
			0084: $TIMER_TEMP1_A1 = $TIMER_TEMP1_CURRENT_A1
			0060: $TIMER_TEMP1_A1 -= $TIMER_TEMP1_STARTED_A1
			if
				001C:   $TIMER_TEMP1_A1 > $TIMER_TEMP1_TIMEOUT_TIME_A1 	
			then			
				gosub @CAR_DO_STUFF_WHEN_STUCK_ASUKA1
			end
		end
	end
	if
		01AF:   car $ASUKA1_MAFIA_CAR_CURRENT 0 $MAFIA_CAR_CURRENT_STUCK_X $MAFIA_CAR_CURRENT_STUCK_Y $MAFIA_CAR_CURRENT_STUCK_Z radius 4.0 4.0 4.0 
	then
		if
			0038: $TIMER_TEMP2_RESET_FLAG_A1 == 0 
		then
			01BD: $TIMER_TEMP2_STARTED_A1 = current_time_in_ms 
			0004: $TIMER_TEMP2_RESET_FLAG_A1 = 1 
		end
		if
			0038:   $TIMER_TEMP2_RESET_FLAG_A1 == 1 
		then
			01BD: $TIMER_TEMP2_CURRENT_A1 = current_time_in_ms 
			0084: $TIMER_TEMP2_A1 = $TIMER_TEMP2_CURRENT_A1
			0060: $TIMER_TEMP2_A1 -= $TIMER_TEMP2_STARTED_A1
			if
				0018:   $TIMER_TEMP2_A1 > 5000 
			then
				gosub @CAR_DO_STUFF_WHEN_STUCK_ASUKA1
			end
		end
	end

	if
		81AF:   not car $ASUKA1_MAFIA_CAR_CURRENT 0 $MAFIA_CAR_CURRENT_STUCK_X $MAFIA_CAR_CURRENT_STUCK_Y $MAFIA_CAR_CURRENT_STUCK_Z radius 4.0 4.0 4.0 
	then
		00AA: get_car_coordinates $ASUKA1_MAFIA_CAR_CURRENT store_to $MAFIA_CAR_CURRENT_STUCK_X $MAFIA_CAR_CURRENT_STUCK_Y $MAFIA_CAR_CURRENT_STUCK_Z 
		0004: $TIMER_TEMP2_RESET_FLAG_A1 = 0 
	end
end
return

/////////////////////////////////////////

:CAR_DO_STUFF_WHEN_STUCK_ASUKA1
if 
	82CA:   not is_car_on_screen $ASUKA1_MAFIA_CAR_CURRENT 
then
	00AA: get_car_coordinates $ASUKA1_MAFIA_CAR_CURRENT store_to $A1_X $A1_Y $A1_Z 
	02C1: set $A1_X $A1_Y $A1_Z to_car_path_coords_closest_to $A1_X $A1_Y $A1_Z 
	if
		80E3:   not player $PLAYER_CHAR 0 $A1_X $A1_Y radius 80.0 80.0
	then
		00AB: set_car_coordinates $ASUKA1_MAFIA_CAR_CURRENT to $A1_X $A1_Y $A1_Z 
		039F: turn_car $ASUKA1_MAFIA_CAR_CURRENT to_face 1438.0 -183.375 
	else
		gosub @MAFIA_SET_HOSTILE_WHEN_CAR_STUCK_ASUKA1
	end
else
	gosub @MAFIA_SET_HOSTILE_WHEN_CAR_STUCK_ASUKA1
end
return

/////////////////////////////////////////

:MAFIA_SET_HOSTILE_WHEN_CAR_STUCK_ASUKA1
if
	8118:   not actor $ASUKA_MAFIA_TEMP1 dead 
then
	01CC: actor $ASUKA_MAFIA_TEMP1 kill_player $PLAYER_CHAR 
end
if
	8118:   not actor $ASUKA_MAFIA_TEMP2 dead 
then
	01CC: actor $ASUKA_MAFIA_TEMP2 kill_player $PLAYER_CHAR 
end
if
	0038: $ASUKA1_FRANKIE_CURRENT == 3
then
	if
		8118:   not actor $ASUKA_MAFIA_TEMP3 dead 
	then
		01CC: actor $ASUKA_MAFIA_TEMP3 kill_player $PLAYER_CHAR 
	end
end
if and
	003A:   $FRANKIE_FLAG == $ASUKA1_FRANKIE_CURRENT
	8118:   not actor $SALVATORE dead 
then
	01B2: give_actor $SALVATORE weapon WEAPONTYPE_M16 ammo 1000 
	01CC: actor $SALVATORE kill_player $PLAYER_CHAR 
end
return

/////////////////////////////////////////

:CHECK_SPOT_MESSAGE_ASUKA1
if and
	0038:   $GARAGE_DOOR_CLOSE == 0 
	0121:   player $PLAYER_CHAR in_zone 'REDLIGH'  // Red Light District
then
	00BC: print_now 'AM1_6' duration 5000 ms flag 1  // ~g~If you hang around Luigi's club, the Mafia will spot you!
	0164: disable_marker $ASUKA1_SALVATORE_MARKER 
	0004: $GARAGE_DOOR_CLOSE = 1
end
return

/////////////////////////////////////////

:SET_MAFIA_KILL_PLAYER_ASUKA1
if
	8118:   not actor $ASUKA1_MAFIA_TEMP dead 
then
	01CC: actor $ASUKA1_MAFIA_TEMP kill_player $PLAYER_CHAR 
end
return

/////////////////////////////////////////

:PUT_HIT_OUT_ON_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA1
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA2
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA3
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA4
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA5
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA6
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA7
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA8
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA9
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA10
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA11
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA12
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA13
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
0084: $ASUKA1_MAFIA_TEMP = $ASUKA1_MAFIA14
gosub @SET_MAFIA_KILL_PLAYER_ASUKA1
return

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_ASUKA1
gosub @PUT_HIT_OUT_ON_PLAYER_ASUKA1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_ASUKA1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_ASUKA1
0004: $SAYONARA_SALVATORE_COMPLETED = 1 
gosub @PUT_HIT_OUT_ON_PLAYER_ASUKA1
01E3: text_1number_styled 'M_PASS' number 25000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0109: player $PLAYER_CHAR money += 25000 
03F1: pedtype PEDTYPE_GANG_MAFIA add_threat THREAT_PLAYER1 
0237: set_gang GANG_MAFIA primary_weapon_to WEAPONTYPE_PISTOL secondary_weapon_to WEAPONTYPE_SHOTGUN 
0110: clear_player $PLAYER_CHAR wanted_level 
0318: set_latest_mission_passed 'AM1'  // 'SAYONARA SALVATORE'
0394: play_mission_passed_music 1 
030C: set_mission_points += 1 
004F: create_thread @ASUKA_MISSION2_LOOP 
004F: create_thread @JOEYS_BUGGY_LOOP 
goto @MISSION_END_ASUKA1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_ASUKA1
004F: create_thread @CLOSE_ASUKA1_DOOR 
021B: set_garage $SALVATORES_GARAGE to_accept_car -1 
0249: release_model #MAFIA 
0249: release_model #GANG01 
0249: release_model #GANG02 
0296: unload_special_actor 1 
0164: disable_marker $ASUKA1_SALVATORE_MARKER 
01E7: switch_roads_on 905.0 -448.5625 12.0 to 916.0 -393.0 20.0 
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_ASUKA1 = 0 
00D8: mission_has_finished 
return

/////////////////////////////////////////

:KILL_PLAYER_NOW_SCRIPT
if and
	0038:   $SPOTTED_PRINT == 0 
	03D0:   wav_loaded 
then
	00BC: print_now 'AM1_2' duration 5000 ms flag 1  // ~r~You have been spotted!
	03D1: play_wav 
	0004: $SPOTTED_PRINT = 1 
end

if
	8118:   not actor $SALVATORE dead 
then
	0319: set_actor $SALVATORE running 1 
end

if or
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 845.75 -443.8125 to 890.75 -433.8125 sphere 0 //HIGHER ROOF
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -433.8125 to 890.75 -427.375 sphere 0 //LOWER ROOF
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 890.75 -433.6875 23.0 to 900.75 -403.75 46.0 sphere 0 //CLUB ROOF
then
	if and
		8038:   not  $MAFIA_8_FLAG == 4 
		0018:   $MAFIA_8_FLAG > 1 
		0038:   $MAFIA_8_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA8 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA8 kill_player $PLAYER_CHAR 
		0004: $MAFIA_8_KILL_PLAYER_FLAG = 1 
	end
	if and
		8038:   not  $MAFIA_9_FLAG == 4 
		0018:   $MAFIA_9_FLAG > 1 
		0038:   $MAFIA_9_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA9 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA9 kill_player $PLAYER_CHAR 
		0004: $MAFIA_9_KILL_PLAYER_FLAG = 1 
	end
	if and
		8038:   not  $MAFIA_10_FLAG == 4 
		0018:   $MAFIA_10_FLAG > 1 
		0038:   $MAFIA_10_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA10 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA10 kill_player $PLAYER_CHAR 
		0004: $MAFIA_10_KILL_PLAYER_FLAG = 1 
	end
	if and
		8038:   not  $MAFIA_11_FLAG == 4 
		0018:   $MAFIA_11_FLAG > 1 
		0038:   $MAFIA_11_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA11 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA11 kill_player $PLAYER_CHAR 
		0004: $MAFIA_11_KILL_PLAYER_FLAG = 1 
	end
	if and
		8038:   not  $MAFIA_12_FLAG == 4 
		0018:   $MAFIA_12_FLAG > 1 
		0038:   $MAFIA_12_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA12 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA12 kill_player $PLAYER_CHAR 
		0004: $MAFIA_12_KILL_PLAYER_FLAG = 1 
	end
	if and
		8038:   not  $MAFIA_13_FLAG == 4 
		0018:   $MAFIA_13_FLAG > 1 
		0038:   $MAFIA_13_KILL_PLAYER_FLAG == 0 
	then
		0350: set_actor $ASUKA1_MAFIA13 maintain_position_when_attacked 1 
		01CA: actor $ASUKA1_MAFIA13 kill_player $PLAYER_CHAR 
		0004: $MAFIA_13_KILL_PLAYER_FLAG = 1 
	end

	if
		0038:   $FRANKIE_EXISTS_FLAG == 0 
	then
		if
			0038:   $TIMERB_RESET_FLAG_A1 == 0 
		then
			0006: 17@ = 0 
			0004: $TIMERB_RESET_FLAG_A1 = 1 
		end
		if and
			0038:   $TIMERB_RESET_FLAG_A1 == 1 
			0019:   17@ > 30000 
			001A:   1 > $ASUKA1_MINS_TO_SALVATORE_LEAVES 
		then
			0004: $FRANKIE_EXISTS_FLAG = 2 	
		end
	end

	if or
		0038:   $MAFIA_10_KILL_PLAYER_FLAG == 1 
		0038:   $MAFIA_10_FLAG == 4 
	then
		if or
			0038:   $MAFIA_11_KILL_PLAYER_FLAG == 1 
			0038:   $MAFIA_11_FLAG == 4 
		then
			if or
				0038:   $MAFIA_12_KILL_PLAYER_FLAG == 1 
				0038:   $MAFIA_12_FLAG == 4
			then
				if or
					0038:   $MAFIA_13_KILL_PLAYER_FLAG == 1 
					0038:   $MAFIA_13_FLAG == 4 
				then 
					if and 
						001A:   1 > $ASUKA1_MINS_TO_SALVATORE_LEAVES 
						0038:   $FRANKIE_EXISTS_FLAG == 0 
					then
						0004: $FRANKIE_EXISTS_FLAG = 2 
					end
				end
			end
		end
	end
	return

else
	if and
		8038:   not  $MAFIA_8_FLAG == 4 
		8038:   not  $MAFIA_8_FLAG == 0 
		0038:   $MAFIA_8_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA8 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA8 maintain_position_when_attacked 0 
		0004: $MAFIA_8_KILL_PLAYER_FLAG = 0 
	end
	if and
		8038:   not  $MAFIA_9_FLAG == 4 
		8038:   not  $MAFIA_9_FLAG == 0 
		0038:   $MAFIA_9_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA9 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA9 maintain_position_when_attacked 0 
		0004: $MAFIA_9_KILL_PLAYER_FLAG = 0 
	end
	if and
		8038:   not  $MAFIA_10_FLAG == 4 
		8038:   not  $MAFIA_10_FLAG == 0 
		0038:   $MAFIA_10_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA10 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA10 maintain_position_when_attacked 0 
		0004: $MAFIA_10_KILL_PLAYER_FLAG = 0 
	end
	if and
		8038:   not  $MAFIA_11_FLAG == 4 
		8038:   not  $MAFIA_11_FLAG == 0 
		0038:   $MAFIA_11_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA11 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA11 maintain_position_when_attacked 0 
		0004: $MAFIA_11_KILL_PLAYER_FLAG = 0 
	end
	if and
		8038:   not  $MAFIA_12_FLAG == 4 
		8038:   not  $MAFIA_12_FLAG == 0 
		0038:   $MAFIA_12_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA12 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA12 maintain_position_when_attacked 0 
		0004: $MAFIA_12_KILL_PLAYER_FLAG = 0 
	end
	if and
		8038:   not  $MAFIA_13_FLAG == 4 
		8038:   not  $MAFIA_13_FLAG == 0 
		0038:   $MAFIA_13_KILL_PLAYER_FLAG == 1 
	then
		0411: set_actor $ASUKA1_MAFIA13 use_pednode_seek 1 
		0350: set_actor $ASUKA1_MAFIA13 maintain_position_when_attacked 0 
		0004: $MAFIA_13_KILL_PLAYER_FLAG = 0 
	end
end

if
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 920.0625 -408.8125 to 931.3125 -398.0625 sphere 0 //ON TOP OF SNIPER BUILDING OVER ROAD
then
	if
		8038:   not  $MAFIA_5_KILL_PLAYER_FLAG == -100 
	then
		if
			8118:   not actor $ASUKA1_MAFIA5 dead
		then
			if
				0038:   $MAFIA_5_KILL_PLAYER_FLAG == 0 
			then
				0239: actor $ASUKA1_MAFIA5 run_to 919.25 -397.0 //CORNER OF STREET
				0004: $MAFIA_5_KILL_PLAYER_FLAG = 1 
			end
		else
			0004: $MAFIA_5_KILL_PLAYER_FLAG = -100 
		end
	end
	if
		8038:   not  $MAFIA_5_KILL_PLAYER_FLAG == -100 
	then
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 1
			00ED:   actor $ASUKA1_MAFIA5 #NULL 919.25 -397.0 radius 1.0 1.0 //CORNER OF STREET
		then
			0239: actor $ASUKA1_MAFIA5 run_to 958.375 -397.0625 //IN FRONT OF ALLEY
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 2 
		end
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 2
			00ED:   actor $ASUKA1_MAFIA5 #NULL 958.375 -397.0625 radius 1.0 1.0 //IN FRONT OF ALLEY
		then
			0411: set_actor $ASUKA1_MAFIA5 use_pednode_seek 0 
			0239: actor $ASUKA1_MAFIA5 run_to 958.0 -416.6875 //BOTTOM OF STEPS
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 3 
		end
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 3
			00ED:   actor $ASUKA1_MAFIA5 #NULL 958.0 -416.6875 radius 1.0 1.0 //BOTTOM OF STEPS
		then
			0239: actor $ASUKA1_MAFIA5 run_to 949.0625 -416.5625 //LANDING ON STEPS
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 4 
		end
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 4
			00ED:   actor $ASUKA1_MAFIA5 #NULL 949.0625 -416.5625 radius 1.0 1.0 //LANDING ON STEPS
		then
			0239: actor $ASUKA1_MAFIA5 run_to 948.9375 -407.5625 //TOP OF STEPS
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 5 
		end
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 5
			00ED:   actor $ASUKA1_MAFIA5 #NULL 948.9375 -407.5625 radius 1.0 1.0 //TOP OF STEPS
		then
			0239: actor $ASUKA1_MAFIA5 run_to 929.8125 -404.75 //ON THE SNIPER ROOF
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 6 
		end
		if and
			0038:   $MAFIA_5_KILL_PLAYER_FLAG == 6
			00ED:   actor $ASUKA1_MAFIA5 #NULL 929.8125 -404.75 radius 1.0 1.0 //ON THE SNIPER ROOF
		then
			0350: set_actor $ASUKA1_MAFIA5 maintain_position_when_attacked 1 
			01CA: actor $ASUKA1_MAFIA5 kill_player $PLAYER_CHAR 
			0411: set_actor $ASUKA1_MAFIA5 use_pednode_seek 1 
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 7 
		end
	end

	if
		8038:   not  $MAFIA_7_KILL_PLAYER_FLAG == -100 
	then
		if
			8118:   not actor $ASUKA1_MAFIA7 dead
		then
			if
				0038:   $MAFIA_7_KILL_PLAYER_FLAG == 0 
			then
				0239: actor $ASUKA1_MAFIA7 run_to 919.25 -397.0 //CORNER OF STREET
				0004: $MAFIA_7_KILL_PLAYER_FLAG = 1 
			end
		else
			0004: $MAFIA_7_KILL_PLAYER_FLAG = -100 
		end
	end
	if
		8038:   not  $MAFIA_7_KILL_PLAYER_FLAG == -100 
	then
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 1
			00ED:   actor $ASUKA1_MAFIA7 #NULL 919.25 -397.0 radius 1.0 1.0 //CORNER OF STREET
		then
			0239: actor $ASUKA1_MAFIA7 run_to 958.375 -397.0625 //IN FRONT OF ALLEY
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 2 
		end
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 2
			00ED:   actor $ASUKA1_MAFIA7 #NULL 958.375 -397.0625 radius 1.0 1.0 //IN FRONT OF ALLEY
		then
			0411: set_actor $ASUKA1_MAFIA7 use_pednode_seek 0 
			0239: actor $ASUKA1_MAFIA7 run_to 958.0 -416.6875 //BOTTOM OF STEPS
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 3 
		end
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 3
			00ED:   actor $ASUKA1_MAFIA7 #NULL 958.0 -416.6875 radius 1.0 1.0 //BOTTOM OF STEPS
		then
			0239: actor $ASUKA1_MAFIA7 run_to 949.0625 -416.5625 //LANDING ON STEPS
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 4 
		end
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 4
			00ED:   actor $ASUKA1_MAFIA7 #NULL 949.0625 -416.5625 radius 1.0 1.0 //LANDING ON STEPS
		then
			0239: actor $ASUKA1_MAFIA7 run_to 948.9375 -407.5625 //TOP OF STEPS
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 5 
		end
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 5
			00ED:   actor $ASUKA1_MAFIA7 #NULL 948.9375 -407.5625 radius 1.0 1.0 //TOP OF STEPS
		then
			0239: actor $ASUKA1_MAFIA7 run_to 930.0625 -407.9375 //ON THE SNIPER ROOF
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 6 
		end
		if and
			0038:   $MAFIA_7_KILL_PLAYER_FLAG == 6
			00ED:   actor $ASUKA1_MAFIA7 #NULL 930.0625 -407.9375 radius 1.0 1.0 //ON THE SNIPER ROOF
		then
			0350: set_actor $ASUKA1_MAFIA7 maintain_position_when_attacked 1 
			01CA: actor $ASUKA1_MAFIA7 kill_player $PLAYER_CHAR 
			0411: set_actor $ASUKA1_MAFIA7 use_pednode_seek 1 
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 7 
		end
	end

	if
		0038:   $MAFIA_15_KILL_PLAYER_FLAG == 0 
	then
		if
			80C2:   not is_point_on_screen 949.0625 -416.5625 19.5 2.0 
		then
			009A: $ASUKA1_MAFIA15 = create_char PEDTYPE_GANG_MAFIA model #GANG02 at 958.0 -416.6875 14.1875 
			0243: set_actor $ASUKA1_MAFIA15 ped_stats_to PEDSTAT_TOUGH_GUY 
			01B2: give_actor $ASUKA1_MAFIA15 weapon WEAPONTYPE_SHOTGUN ammo 999 
			0411: set_actor $ASUKA1_MAFIA15 use_pednode_seek 0 
			0211: actor $ASUKA1_MAFIA15 walk_to 949.0625 -416.5625 //LANDING ON STEPS
			0004: $MAFIA_15_KILL_PLAYER_FLAG = 1 
		end
	end

	if
		8038:   not  $MAFIA_15_KILL_PLAYER_FLAG == -100 
	then
		if and
			0018:   $MAFIA_15_KILL_PLAYER_FLAG > 0 
			0118:   actor $ASUKA1_MAFIA15 dead 
		then
			0004: $MAFIA_15_KILL_PLAYER_FLAG = -100 
		end
	end
	if
		8038:   not  $MAFIA_15_KILL_PLAYER_FLAG == -100 
	then
		if and
			0038:   $MAFIA_15_KILL_PLAYER_FLAG == 1
			00ED:   actor $ASUKA1_MAFIA15 #NULL 949.0625 -416.5625  radius 1.0 1.0 //LANDING ON STEPS
		then
			0239: actor $ASUKA1_MAFIA15 run_to 948.9375 -407.5625 //TOP OF STEPS
			0004: $MAFIA_15_KILL_PLAYER_FLAG = 2 
		end
		if and
			0038:   $MAFIA_15_KILL_PLAYER_FLAG == 2
			00ED:   actor $ASUKA1_MAFIA15 #NULL 948.9375 -407.5625 radius 1.0 1.0 //TOP OF STEPS
		then
			0411: set_actor $ASUKA1_MAFIA15 use_pednode_seek 0 
			0239: actor $ASUKA1_MAFIA15 run_to 929.5 -406.625 //ON THE SNIPER ROOF
			0004: $MAFIA_15_KILL_PLAYER_FLAG = 3 
		end
		if and
			0038:   $MAFIA_15_KILL_PLAYER_FLAG == 3
			00ED:   actor $ASUKA1_MAFIA15 #NULL 929.5 -406.625 radius 1.0 1.0 //ON THE SNIPER ROOF
		then
			0350: set_actor $ASUKA1_MAFIA15 maintain_position_when_attacked 1 
			01CA: actor $ASUKA1_MAFIA15 kill_player $PLAYER_CHAR 
			0411: set_actor $ASUKA1_MAFIA15 use_pednode_seek 1 
			0004: $MAFIA_15_KILL_PLAYER_FLAG = 4
		end
	end

	if or
		0038:   $MAFIA_5_KILL_PLAYER_FLAG == 7
		0038:   $MAFIA_5_KILL_PLAYER_FLAG == -100
	then
		if
			8038:   not  $FRANKIE_EXISTS_FLAG == 0 
		then
			0004: $FRANKIE_EXISTS_FLAG = 3 
		end
	end


	if or
		0038:   $MAFIA_7_KILL_PLAYER_FLAG == 7
		0038:   $MAFIA_7_KILL_PLAYER_FLAG == -100
	then
		if
			8038:   not  $FRANKIE_EXISTS_FLAG == 0 
		then
			0004: $FRANKIE_EXISTS_FLAG = 3 
		end
	end


	if or
		0038:   $MAFIA_15_KILL_PLAYER_FLAG == 4
		0038:   $MAFIA_15_KILL_PLAYER_FLAG == -100
	then
		if
			8038:   not  $FRANKIE_EXISTS_FLAG == 0 
		then
			0004: $FRANKIE_EXISTS_FLAG = 3 
		end
	end

	if
		0038:   $FRANKIE_EXISTS_FLAG == 0 
	then
		if
			0038:   $TIMERB_RESET_FLAG_A1 == 0 
		then
			0006: 17@ = 0 
			0004: $TIMERB_RESET_FLAG_A1 = 1 
		end
		if and
			0038:   $TIMERB_RESET_FLAG_A1 == 1 
			0019:   17@ > 15000 
			001A:   1 > $ASUKA1_MINS_TO_SALVATORE_LEAVES 
		then
			0004: $FRANKIE_EXISTS_FLAG = 3 	
		end
	end
	return
else
	if and
		8038:   not  $MAFIA_5_KILL_PLAYER_FLAG == -100 
		8038:   not  $MAFIA_5_KILL_PLAYER_FLAG == 0 
	then
		if 
			8118:   not actor $ASUKA1_MAFIA5 dead 
		then
			0411: set_actor $ASUKA1_MAFIA5 use_pednode_seek 1 
			0350: set_actor $ASUKA1_MAFIA5 maintain_position_when_attacked 0 
			0004: $MAFIA_5_KILL_PLAYER_FLAG = 0 
		else
			0004: $MAFIA_5_KILL_PLAYER_FLAG = -100 
		end
	end

	if and
		8038:   not  $MAFIA_7_KILL_PLAYER_FLAG == -100 
		8038:   not  $MAFIA_7_KILL_PLAYER_FLAG == 0 
	then
		if 
			8118:   not actor $ASUKA1_MAFIA7 dead 
		then
			0411: set_actor $ASUKA1_MAFIA7 use_pednode_seek 1 
			0350: set_actor $ASUKA1_MAFIA7 maintain_position_when_attacked 0 
			0004: $MAFIA_7_KILL_PLAYER_FLAG = 0 
		else
			0004: $MAFIA_7_KILL_PLAYER_FLAG = -100 
		end
	end

	if and
		8038:   not  $MAFIA_15_KILL_PLAYER_FLAG == -100 
		8038:   not  $MAFIA_15_KILL_PLAYER_FLAG == 0 
	then
		if 
			8118:   not actor $ASUKA1_MAFIA15 dead 
		then
			0411: set_actor $ASUKA1_MAFIA15 use_pednode_seek 1 
			0350: set_actor $ASUKA1_MAFIA15 maintain_position_when_attacked 0 
			0004: $MAFIA_15_KILL_PLAYER_FLAG = 0 
		else
			0004: $MAFIA_15_KILL_PLAYER_FLAG = -100 
		end
	end
end

if or
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -427.375 to 890.75 -403.875 sphere 0 //BACK OF CLUB
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 890.75 -427.375 13.0 to 900.0 -423.8125 18.875 sphere 0 //ALLEYWAY
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 900.0 -443.0 to 927.0 -378.0 sphere 0 //FRONT OF CLUB
then
	if and
		8038:   not  $MAFIA_8_FLAG == 4 
		8038:   not  $MAFIA_8_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA8 kill_player $PLAYER_CHAR 
	end
	if and
		8038:   not  $MAFIA_9_FLAG == 4 
		8038:   not  $MAFIA_9_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA9 kill_player $PLAYER_CHAR 
	end
	if and
		8038:   not  $MAFIA_10_FLAG == 4 
		8038:   not  $MAFIA_10_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA10 kill_player $PLAYER_CHAR 
	end
	if and
		8038:   not  $MAFIA_11_FLAG == 4 
		8038:   not  $MAFIA_11_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA11 kill_player $PLAYER_CHAR 
	end
	if and
		8038:   not  $MAFIA_12_FLAG == 4 
		8038:   not  $MAFIA_12_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA12 kill_player $PLAYER_CHAR 
	end
	if and
		8038:   not  $MAFIA_13_FLAG == 4 
		8038:   not  $MAFIA_13_FLAG == 0 
	then
		01CA: actor $ASUKA1_MAFIA13 kill_player $PLAYER_CHAR 
	end

	if
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 900.0 -443.0 to 927.0 -378.0 sphere 0 //FRONT OF CLUB
	then
		if
			8118:   not actor $ASUKA1_MAFIA5 dead
		then
			01CA: actor $ASUKA1_MAFIA5 kill_player $PLAYER_CHAR 
		end
		if
			8118:   not actor $ASUKA1_MAFIA7 dead
		then
			01CA: actor $ASUKA1_MAFIA7 kill_player $PLAYER_CHAR 
		end
	end
	if
		0038:   $FRANKIE_EXISTS_FLAG == 0 
	then
		if
			0038:   $TIMERB_RESET_FLAG_A1 == 0 
		then
			0006: 17@ = 0 
			0004: $TIMERB_RESET_FLAG_A1 = 1 
		end
		if and
			0038:   $TIMERB_RESET_FLAG_A1 == 1 
			0019:   17@ > 25000 
			001A:   1 > $ASUKA1_MINS_TO_SALVATORE_LEAVES 
		then
			0004: $FRANKIE_EXISTS_FLAG = 2 	
		end
	end
else
	0004: $KILL_PLAYER_NOW_FLAG = 0 
end

return

////////////////////////////////////////

:MOVE_FUCKERS_CAR
00AE: set_car_driving_style $FUCKERS_CAR to DRIVINGMODE_AVOIDCARS 
00AD: set_car_cruise_speed $FUCKERS_CAR to 20.0 
if or
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -427.375 to 890.75 -403.875 sphere 0 //BACK OF CLUB
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 890.75 -427.375 13.0 to 900.0 -423.8125 18.875 sphere 0 //ALLEYWAY
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 845.75 -443.8125 to 890.75 -433.8125 sphere 0 //HIGHER ROOF
	0056:   is_player_in_area_2d $PLAYER_CHAR coords 878.75 -433.8125 to 890.75 -427.375 sphere 0 //LOWER ROOF
	0057:   is_player_in_area_3d $PLAYER_CHAR coords 890.75 -433.6875 23.0 to 900.75 -403.75 46.0 sphere 0//CLUB ROOF
then
	00A8: car_wander_randomly $FUCKERS_CAR 
	0428: set_car $FUCKERS_CAR avoid_level_transitions 1 
else
	00AF: set_car_mission $FUCKERS_CAR to MISSION_RAMPLAYER_FARAWAY
end
return
