// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Love Mission 1********************************* 
// **********************************Save The Old Japanese Gentleman************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M25_LIBERATOR

gosub @MISSION_START_LOVE1
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_LOVE1
end

:MISSION_END_LOVE1
gosub @MISSION_CLEANUP_LOVE1
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_LOVE1

0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_KENJI = 1 
0317: increment_mission_attempts 
0001: wait 0 ms 
0004: $FLAG_OJG_IN_GROUP = 0 
0004: $FLAG_BLIP_ON_OJG_LOVE1 = 0 
0004: $FLAG_BADDIE1_DEAD_LOVE1 = 0 
0004: $FLAG_BADDIE2_DEAD_LOVE1 = 0 
0004: $FLAG_BADDIE3_DEAD_LOVE1 = 0 
0004: $FLAG_BADDIE4_DEAD_LOVE1 = 0 
0004: $FLAG_BADDIE5_DEAD_LOVE1 = 0 
0004: $FLAG_BADDIE6_DEAD_LOVE1 = 0 
0004: $FLAG_GARAGE1_OPEN = 0 
0004: $FLAG_GARAGE2_OPEN = 0 
0004: $FLAG_GARAGE3_OPEN = 0 
0004: $FLAG_GARAGE4_OPEN = 0 
0004: $FLAG_GARAGE5_OPEN = 0 
0004: $OGG_POSITION = 0 
0004: $FLAG_HAD_GARAGE_MESSAGE_LOVE1 = 0 
0004: $OJG_IN_AREA = 0 
0004: $FLAG_OJG_DEAD = 0 
0004: $FLAG_PLAYER_IN_AREA_LOVE1 = 0 
0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_LOVE1 = 0 
0004: $FLAG_MESSAGE_CAR_AGAIN = 0 
0004: $BLOB_FLAG = 1 
0004: $FLAG_OJG_IN_AREA = 0 
0004: $FLAG_BADDIE1_IN_AREA_LOVE1 = 0 
0004: $FLAG_BADDIE2_IN_AREA_LOVE1 = 0 
0004: $FLAG_BADDIE3_IN_AREA_LOVE1 = 0 
0004: $FLAG_BADDIE4_IN_AREA_LOVE1 = 0 
0004: $FLAG_BADDIE5_IN_AREA_LOVE1 = 0 
0004: $FLAG_BADDIE6_IN_AREA_LOVE1 = 0 
if
	0038:   $FLAG_FAILED_LOVE1 == 1 
then
	0361: close_garage $COLUMBIAN_GARAGE1 
	0361: close_garage $COLUMBIAN_GARAGE2 
	0361: close_garage $COLUMBIAN_GARAGE3 
	0361: close_garage $COLUMBIAN_GARAGE4 
	0361: close_garage $COLUMBIAN_GARAGE5
end
0004: $FLAG_FAILED_LOVE1 = 0 
0004: $FLAG_KILL_PLAYER_LOVE1 = 0 

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'LOVE2' as 1 
0247: request_model #TSHRORCKGRDN 
0247: request_model #TSHRORCKGRDN_ALFAS 
02F3: load_object #CUTOBJ01 'LOVEH' 
02F3: load_object #CUTOBJ02 'PLAYERH' 
038B: load_all_models_now  




while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #TSHRORCKGRDN available 
		8248:   not model #TSHRORCKGRDN_ALFAS available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'D1_STOG' 
0244: set_cutscene_pos 85.1875 -1532.875 243.5 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_LOVE = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_LOVE 'LOVE2' 
02F4: create_cutscene_actor $LOVE_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_LOVE 
02F5: set_head_anim $LOVE_CSHEAD 'LOVE' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
0395: clear_area 1 at 83.0625 -1548.688 range 27.25 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 83.0625 -1548.688 27.25 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 1500 ms 
03AD: set_rubbish 0 
02E7: start_cutscene 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   4111 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_A' duration 10000 ms flag 1  // First of all, let me thank you for dealing with that personal matter.
while 001A:   7246 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_F' duration 10000 ms flag 1  // People will read something into anything these days.
while 001A:   10311 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_B' duration 10000 ms flag 1  // Experience has taught me that a man like you can be very loyal for the right price,
while 001A:   14533 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_H' duration 10000 ms flag 1  // but groups of men get greedy.
while 001A:   17000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_C' duration 10000 ms flag 1  // A valued resource, an old oriental gentleman I know,
while 001A:   20000 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_I' duration 10000 ms flag 1  // has been kept hostage by some South Americans in Aspatria.
while 001A:   23188 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_D' duration 10000 ms flag 1  // They're trying to extort additional funds from me but I don't believe in re-negotiation.
while 001A:   28008 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_E' duration 10000 ms flag 1  // A deal is a deal, so they'll not see a penny from me.
while 001A:   32454 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'LOVE1_G' duration 10000 ms flag 1  // Go and rescue my friend, do whatever it takes.
while 001A:   35034 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
03D5: remove_text 'LOVE1_G'  // Go and rescue my friend, do whatever it takes.
while 001A:   38333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1500 ms

while fading
	wait 0 ms
end

00BE: clear_prints 

while 82E9:   not cutscene_reached_end
	wait 0 ms
end

02EA: end_cutscene 
03AF: set_streaming 1 
03AD: set_rubbish 1 
0373: set_camera_directly_behind_player 
0001: wait 500 ms 
016A: fade 1 for 1500 ms 
0373: set_camera_directly_behind_player 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #TSHRORCKGRDN 
0249: release_model #TSHRORCKGRDN_ALFAS 
0247: request_model #GANG11 
0247: request_model #COLUMB 
023C: load_special_actor 'OJG' as 2 

while true
	if or
		823D:   not special_actor 2 loaded 
		8248:   not model #GANG11 available 
		8248:   not model #COLUMB available 
	jf break
	wait 0 ms
end //while

00BC: print_now 'LOVE1_1' duration 7000 ms flag 1  // ~g~Go 'jack a Colombian gang car, so you can infiltrate the hideout, head north you'll find one in Fort Staunton.

00A5: $CARTEL_CAR_SECRET_LOVE1 = create_car #COLUMB at 127.0 -343.0 16.25 
0175: set_car $CARTEL_CAR_SECRET_LOVE1 z_angle_to 90.0 

// Waiting for the player to be in a colombian car
while 80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
	wait 0 ms
end

018A: $RADAR_BLIP_COORD2_LOVE1 = create_checkpoint_at 52.0 -343.0 -100.0 

// Create OGG
009A: $OJG_LOVE1 = create_char PEDTYPE_SPECIAL model #SPECIAL02 at 57.0 -310.0 15.0625 
01ED: clear_actor $OJG_LOVE1 threat_search 
01BE: set_actor $OJG_LOVE1 to_look_at_spot 57.0 -321.0 16.0 
009F: char_set_idle $OJG_LOVE1 

// Create cartel cars
00BC: print_now 'LOVE1_2' duration 7000 ms flag 1  // ~g~Rescue the Old Oriental Gentleman.
00A5: $GARAGE_CAR1_LOVE1 = create_car #COLUMB at 26.1875 -365.5 15.0625 
0175: set_car $GARAGE_CAR1_LOVE1 z_angle_to 270.0 
00A5: $GARAGE_CAR2_LOVE1 = create_car #COLUMB at 73.5625 -352.6875 15.0625 
0175: set_car $GARAGE_CAR2_LOVE1 z_angle_to 270.0 

// Creates the first guard he follows route 0
009A: $BADDIE1_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 71.0 -332.0 -100.0 
011A: set_actor $BADDIE1_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE1_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE1_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE1_LOVE1 to_look_at_spot 72.0 -318.0 -100.0 
01E2: add_route_point 0 at 71.0 -319.0 -100.0 
01E2: add_route_point 0 at 71.0 -332.0 -100.0 
01E1: set_actor $BADDIE1_LOVE1 follow_route 0 behaviour 3 

// Creates the second guard he follows route 1
009A: $BADDIE2_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 61.0 -318.0 -100.0 
011A: set_actor $BADDIE2_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE2_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE2_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE2_LOVE1 to_look_at_spot 61.0 -335.0 -100.0 
01E2: add_route_point 1 at 61.0 -318.0 -100.0 
01E2: add_route_point 1 at 61.0 -335.0 -100.0 
01E1: set_actor $BADDIE2_LOVE1 follow_route 1 behaviour 3 

// Creates the third guard - does not patrol
009A: $BADDIE3_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 42.0 -375.0 -100.0 
011A: set_actor $BADDIE3_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE3_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE3_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE3_LOVE1 to_look_at_spot 42.0 -373.0 -100.0 

// Creates the fourth guard - does not patrol
009A: $BADDIE4_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 52.0 -375.0 -100.0 
011A: set_actor $BADDIE4_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE4_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE4_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE4_LOVE1 to_look_at_spot 52.0 -371.0 -100.0 

// Creates the fifth guard - does not patrol
009A: $BADDIE5_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 32.0 -345.0 -100.0 
011A: set_actor $BADDIE5_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE5_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE5_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE5_LOVE1 to_look_at_spot -30.0 -367.0 -100.0 

// Creates the sixth guard - does not patrol
009A: $BADDIE6_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 33.0 -328.0 -100.0 
011A: set_actor $BADDIE6_LOVE1 search_threat THREAT_PLAYER1 
01B2: give_actor $BADDIE6_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $BADDIE6_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $BADDIE6_LOVE1 to_look_at_spot 35.0 -328.0 -100.0 

// Garage guard1 in garage 2
009A: $GARAGE_BADDIE1_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 55.8125 -312.75 15.0625 
01ED: clear_actor $GARAGE_BADDIE1_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE1_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE1_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE1_LOVE1 to_look_at_spot 56.0 -321.0 -100.0 

// Garage guard2 in garage 2
009A: $GARAGE_BADDIE2_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 58.1875 -312.75 15.0625 
01ED: clear_actor $GARAGE_BADDIE2_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE2_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE2_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE2_LOVE1 to_look_at_spot 56.0 -321.0 -100.0

// Garage guard3 in garage 1
009A: $GARAGE_BADDIE3_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 66.25 -309.9375 15.0625 
01ED: clear_actor $GARAGE_BADDIE3_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE3_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE3_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE3_LOVE1 to_look_at_spot 65.3125 -316.25 -100.0 
035F: set_actor $GARAGE_BADDIE3_LOVE1 armour_to 1000.0

// Garage guard4 in garage 3
009A: $GARAGE_BADDIE4_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 28.625 -339.8125 15.0625 
01ED: clear_actor $GARAGE_BADDIE4_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE4_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE4_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE4_LOVE1 to_look_at_spot 35.25 -339.6875 -100.0 
035F: set_actor $GARAGE_BADDIE4_LOVE1 armour_to 1000.0

// Garage guard5 in garage 4
009A: $GARAGE_BADDIE5_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 29.75 -350.5 15.0625 
01ED: clear_actor $GARAGE_BADDIE5_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE5_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE5_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE5_LOVE1 to_look_at_spot 34.5625 -350.0 -100.0 
035F: set_actor $GARAGE_BADDIE5_LOVE1 armour_to 1000.0

// Garage guard6 in garage 5
009A: $GARAGE_BADDIE6_LOVE1 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 46.6875 -379.25 15.0625 
01ED: clear_actor $GARAGE_BADDIE6_LOVE1 threat_search 
01B2: give_actor $GARAGE_BADDIE6_LOVE1 weapon WEAPONTYPE_CHAINGUN ammo 30000 
0243: set_actor $GARAGE_BADDIE6_LOVE1 ped_stats_to PEDSTAT_TOUGH_GUY 
01BE: set_actor $GARAGE_BADDIE6_LOVE1 to_look_at_spot 47.0625 -375.875 -100.0 
035F: set_actor $GARAGE_BADDIE6_LOVE1 armour_to 1000.0

0004: $BLOB_FLAG = 0 

// waiting for the player to get the OGG to Loves

while 80EF:   not actor $OJG_LOVE1 sphere $BLOB_FLAG 49.0 -1550.0 radius 3.0 4.0 
	wait 0 ms
	gosub @CHECK_OGG_STATUS_LOVE1
	// Checks to see while the player is not in the compound if he is in a colombian car or not
	if
		0038:   $FLAG_PLAYER_IN_AREA_LOVE1 == 0 
	then
		if
			80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
		then
			if
				0038:   $FLAG_PLAYER_GOT_CAR_MESSAGE_LOVE1 == 0 
			then
				00BC: print_now 'LOVE1_5' duration 5000 ms flag 1  // ~g~Stop hanging around, get a Colombian Gang car and rescue Love's associate.
				0164: disable_marker $RADAR_BLIP_COORD2_LOVE1 
				0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_LOVE1 = 1 
			end
		else
			if
				0038:   $FLAG_PLAYER_GOT_CAR_MESSAGE_LOVE1 == 1 
			then
				018A: $RADAR_BLIP_COORD2_LOVE1 = create_checkpoint_at 52.0 -343.0 -100.0 
				0004: $FLAG_PLAYER_GOT_CAR_MESSAGE_LOVE1 = 0 
			end
		end
	end

	// Checks to see if the player has located close enough to the player to be set into his group	
	if and
		0038:   $FLAG_OJG_IN_GROUP == 0 
		00E9:   player $PLAYER_CHAR 0 $OJG_LOVE1 radius 3.0 3.0 
	then
		01DF: tie_actor $OJG_LOVE1 to_player $PLAYER_CHAR 
		00BC: print_now 'LOVE1_3' duration 7000 ms flag 1  // ~g~Take the Old Oriental Gentleman back to Donald Love's building.
		0164: disable_marker $RADAR_BLIP_COORD2_LOVE1 
		018A: $RADAR_BLIP_COORD1_LOVE1 = create_checkpoint_at 49.0625 -1550.5 -100.0 
		0004: $BLOB_FLAG = 1 
		0004: $FLAG_OJG_IN_GROUP = 1
	end
	if
		0038:   $FLAG_OJG_IN_GROUP == 0 
	then
		if
			0057:   is_player_in_area_3d $PLAYER_CHAR coords 92.1875 -329.375 15.0 to 96.375 -315.75 18.0 sphere 0 
		then
			if and
				80DE:   not is_player_in_model $PLAYER_CHAR model #COLUMB 
				0038:   $FLAG_MESSAGE_CAR_AGAIN == 0 
				0038:   $FLAG_PLAYER_IN_AREA_LOVE1 == 1 
			then
				00BC: print_now 'LOVE1_7' duration 5000 ms flag 1  // ~g~The gate will only open for a Colombian Gang-car.
				0004: $FLAG_MESSAGE_CAR_AGAIN = 1 
			end
		else
			0004: $FLAG_MESSAGE_CAR_AGAIN = 0 
		end
	end

	// Checks for the normal guards in the compound
	if
		0038:   $FLAG_BADDIE1_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE1_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE1_DEAD_LOVE1 = 1 
		end
	end
	if
		0038:   $FLAG_BADDIE2_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE2_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE2_DEAD_LOVE1 = 1 
		end
	end
	if
		0038:   $FLAG_BADDIE3_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE3_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE3_DEAD_LOVE1 = 1 
		end
	end
	if
		0038:   $FLAG_BADDIE4_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE4_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE4_DEAD_LOVE1 = 1 
		end
	end
	if
		0038:   $FLAG_BADDIE5_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE5_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE5_DEAD_LOVE1 = 1 
		end
	end
	if
		0038:   $FLAG_BADDIE6_DEAD_LOVE1 == 0 
	then
		if
			0118:   actor $BADDIE6_LOVE1 dead 
		then
			0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
			0004: $FLAG_BADDIE6_DEAD_LOVE1 = 1 
		end
	end

	// Checks to see if the garage door is open and if the guards are still alive sets them to kill the player
	if and
		8118:   not actor $GARAGE_BADDIE1_LOVE1 dead
		0038:   $FLAG_GARAGE2_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE1_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE1_LOVE1 kill_player $PLAYER_CHAR 
	end
	if and
		8118:   not actor $GARAGE_BADDIE2_LOVE1 dead
		0038:   $FLAG_GARAGE2_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE2_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE2_LOVE1 kill_player $PLAYER_CHAR 
	end
	if and
		8118:   not actor $GARAGE_BADDIE3_LOVE1 dead
		0038:   $FLAG_GARAGE1_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE3_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE3_LOVE1 kill_player $PLAYER_CHAR 
	end
	if and
		8118:   not actor $GARAGE_BADDIE4_LOVE1 dead
		0038:   $FLAG_GARAGE3_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE4_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE4_LOVE1 kill_player $PLAYER_CHAR 
	end
	if and
		8118:   not actor $GARAGE_BADDIE5_LOVE1 dead
		0038:   $FLAG_GARAGE4_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE5_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE5_LOVE1 kill_player $PLAYER_CHAR 
	end
	if and
		8118:   not actor $GARAGE_BADDIE6_LOVE1 dead
		0038:   $FLAG_GARAGE5_OPEN == 1 
	then
		011A: set_actor $GARAGE_BADDIE6_LOVE1 search_threat THREAT_PLAYER1 
		01CC: actor $GARAGE_BADDIE6_LOVE1 kill_player $PLAYER_CHAR 
	end

	// Checks to see if the player is in the colombian compound and if the guards are alive sets them to kill the player
	if
		0057:   is_player_in_area_3d $PLAYER_CHAR coords 31.0 -317.0 14.0 to 91.0 -394.0 25.0 sphere 0 
	then
		0004: $FLAG_KILL_PLAYER_LOVE1 = 1 
	end
	if
		0038:   $FLAG_KILL_PLAYER_LOVE1 == 1 
	then
		0004: $FLAG_PLAYER_IN_AREA_LOVE1 = 1
		if
			0038:   $FLAG_HAD_GARAGE_MESSAGE_LOVE1 == 0 
		then
			00BC: print_now 'LOVE1_4' duration 7000 ms flag 1  // ~g~The Old Oriental Gentleman must be in one of the garages....
			0004: $FLAG_HAD_GARAGE_MESSAGE_LOVE1 = 1
		end
		if
			0038:   $FLAG_BADDIE1_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE1_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE1_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE1_LOVE1 run_to 72.5 -321.875 
					0004: $FLAG_BADDIE1_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE1_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE1_LOVE1 0 72.5 -321.875 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE1_LOVE1 objective_to_guard_point 72.5 -321.875 15.125 
						020F: actor $BADDIE1_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE1_LOVE1 maintain_position_when_attacked 1 
					end
				end

				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE1_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE1_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE1_LOVE1
				end 
			end
		end
		if
			0038:   $FLAG_BADDIE2_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE2_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE2_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE2_LOVE1 run_to 66.5 -332.0 
					0004: $FLAG_BADDIE2_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE2_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE2_LOVE1 0 66.5 -332.0 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE2_LOVE1 objective_to_guard_point 66.5 -332.0 15.125 
						020F: actor $BADDIE2_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE2_LOVE1 maintain_position_when_attacked 1 
					end
				end
				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE2_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE2_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE2_LOVE1
				end 
			end
		end
		if
			0038:   $FLAG_BADDIE3_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE3_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE3_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE3_LOVE1 run_to 44.375 -360.6875 
					0004: $FLAG_BADDIE3_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE3_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE3_LOVE1 0 44.375 -360.6875 radius 0.5 0.5 
					then
						0239: actor $BADDIE3_LOVE1 run_to 47.875 -360.0625 
						0004: $FLAG_BADDIE3_IN_AREA_LOVE1 = 2
					end
				end
				if
					0038:   $FLAG_BADDIE3_IN_AREA_LOVE1 == 2 
				then
					if
						00EC:   actor $BADDIE3_LOVE1 0 47.875 -360.0625 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE3_LOVE1 objective_to_guard_point 47.875 -360.0625 15.0625 
						020F: actor $BADDIE3_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE3_LOVE1 maintain_position_when_attacked 1 
					end
				end
				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE3_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE3_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE3_LOVE1
				end 
			end
		end
		if
			0038:   $FLAG_BADDIE4_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE4_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE4_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE4_LOVE1 run_to 57.0 -365.25
					0004: $FLAG_BADDIE4_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE4_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE4_LOVE1 0 57.0 -365.25 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE4_LOVE1 objective_to_guard_point 57.0 -365.25 15.0625 
						020F: actor $BADDIE4_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE4_LOVE1 maintain_position_when_attacked 1 
					end
				end
				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE4_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE4_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE4_LOVE1
				end 
			end
		end
		if
			0038:   $FLAG_BADDIE5_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE5_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE5_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE5_LOVE1 run_to 38.6875 -345.0625 
					0004: $FLAG_BADDIE5_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE5_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE5_LOVE1 0 38.6875 -345.0625 radius 0.5 0.5 
					then
						0239: actor $BADDIE5_LOVE1 run_to 45.75 -344.25 
						0004: $FLAG_BADDIE5_IN_AREA_LOVE1 = 2
					end
				end
				if
					0038:   $FLAG_BADDIE5_IN_AREA_LOVE1 == 2 
				then
					if
						00EC:   actor $BADDIE5_LOVE1 0 45.75 -344.25 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE5_LOVE1 objective_to_guard_point 45.75 -344.25 15.0625 
						020F: actor $BADDIE5_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE5_LOVE1 maintain_position_when_attacked 1 
					end
				end
				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE5_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE5_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE5_LOVE1
				end 
			end
		end
		if
			0038:   $FLAG_BADDIE6_DEAD_LOVE1 == 0 
		then
			if
				8118:   not actor $BADDIE6_LOVE1 dead 
			then
				if
					0038:   $FLAG_BADDIE6_IN_AREA_LOVE1 == 0 
				then
					0239: actor $BADDIE6_LOVE1 run_to  37.25 -331.0
					0004: $FLAG_BADDIE6_IN_AREA_LOVE1 = 1 
				end
				if
					0038:   $FLAG_BADDIE6_IN_AREA_LOVE1 == 1 
				then
					if
						00EC:   actor $BADDIE6_LOVE1 0  37.25 -331.0 radius 0.5 0.5 
					then
						0239: actor $BADDIE6_LOVE1 run_to 42.5 -331.75
						0004: $FLAG_BADDIE6_IN_AREA_LOVE1 = 2
					end
				end
				if
					0038:   $FLAG_BADDIE6_IN_AREA_LOVE1 == 2 
				then
					if
						00EC:   actor $BADDIE6_LOVE1 0 42.5 -331.75 radius 0.5 0.5 
					then
						0194: set_actor $BADDIE6_LOVE1 objective_to_guard_point 42.5 -331.75 15.0625 
						020F: actor $BADDIE6_LOVE1 look_at_player $PLAYER_CHAR 
						0350: set_actor $BADDIE6_LOVE1 maintain_position_when_attacked 1 
					end
				end
				if
					00E9:   player $PLAYER_CHAR 0 $BADDIE6_LOVE1 radius 3.0 3.0
				then
					00A0: get_char_coordinates $BADDIE6_LOVE1 store_to $BOMB_X $BOMB_Y $BOMB_Z
					020C: create_explosion EXPLOSION_GRENADE at $BOMB_X $BOMB_Y $BOMB_Z
					0003: shake_cam 500
					01C2: remove_references_to_actor $BADDIE6_LOVE1
				end 
			end
		end

		// Checks for garage1
		if
			019C:   player $PLAYER_CHAR 0 63.0 -317.5 13.0 69.25 -321.6875 20.0 
		then
			if
				0038:   $FLAG_GARAGE1_OPEN == 0 
			then
				0360: open_garage $COLUMBIAN_GARAGE1 
				0004: $FLAG_GARAGE1_OPEN = 1 
			end
		end

		// Checks for garage2
		if
			019C:   player $PLAYER_CHAR 0 53.6875 -317.5 13.0 61.0 -320.4375 20.0 
		then
			if
				0038:   $FLAG_GARAGE2_OPEN == 0 
			then
				0360: open_garage $COLUMBIAN_GARAGE2 
				0004: $FLAG_GARAGE2_OPEN = 1 
			end
		end

		// Checks for garage3
		if
			019C:   player $PLAYER_CHAR 0 31.75 -344.375 13.0 35.0625 -335.5625 20.0 
		then
			if
				0038:   $FLAG_GARAGE3_OPEN == 0 
			then
				0360: open_garage $COLUMBIAN_GARAGE3 
				0004: $FLAG_GARAGE3_OPEN = 1 
			end
		end

		// Checks for garage4
		if
			019C:   player $PLAYER_CHAR 0 31.375 -355.5625 13.0 34.1875 -344.75 20.0 
		then
			if
				0038:   $FLAG_GARAGE4_OPEN == 0 
			then
				0360: open_garage $COLUMBIAN_GARAGE4 
				0004: $FLAG_GARAGE4_OPEN = 1 
			end
		end

		// Checks for garage5
		if
			019C:   player $PLAYER_CHAR 0 52.875 -376.25 13.0 42.0 -373.1875 20.0 
		then
			if
				0038:   $FLAG_GARAGE5_OPEN == 0 
			then
				0360: open_garage $COLUMBIAN_GARAGE5 
				0004: $FLAG_GARAGE5_OPEN = 1 
			end
		end
	end

	// Checks to see if the OGG is in the players group and does the group breaking stuff
	if
		0038:   $FLAG_OJG_IN_GROUP == 1 
	then
		gosub @CHECK_OGG_STATUS_LOVE1
		if and
			8320:   not actor $OJG_LOVE1 in_range_of_player $PLAYER_CHAR 
			0038:   $FLAG_BLIP_ON_OJG_LOVE1 == 0 
		then
			00BC: print_now 'HEY8' duration 5000 ms flag 1  // ~g~Protection means just that -Protect the Old Oriental Gentleman!
			0187: $RADAR_BLIP_PED1_LOVE1 = create_marker_above_actor $OJG_LOVE1 
			0164: disable_marker $RADAR_BLIP_COORD1_LOVE1 
			0004: $FLAG_BLIP_ON_OJG_LOVE1 = 1 
			0004: $BLOB_FLAG = 0
		end
		if and
			00E9:   player $PLAYER_CHAR 0 $OJG_LOVE1 radius 8.0 8.0 
			0038:   $FLAG_BLIP_ON_OJG_LOVE1 == 1 
		then
			01DF: tie_actor $OJG_LOVE1 to_player $PLAYER_CHAR 
			00BC: print_now 'LOVE1_3' duration 7000 ms flag 1  // ~g~Take the Old Oriental Gentleman back to Donald Love's building.
			0164: disable_marker $RADAR_BLIP_PED1_LOVE1 
			018A: $RADAR_BLIP_COORD1_LOVE1 = create_checkpoint_at 49.0625 -1550.5 -100.0 
			0004: $FLAG_BLIP_ON_OJG_LOVE1 = 0 
			0004: $BLOB_FLAG = 1 
		end
	end
end //while

0164: disable_marker $RADAR_BLIP_COORD1_LOVE1 
01E0: clear_leader $OJG_LOVE1 
02A3: toggle_widescreen 1 
01B4: set_player $PLAYER_CHAR controllable 0 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 1 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 1 

// Checks to see if the OJG is in a car, if so orders him to get out 
if
	00DF:   is_char_in_any_car $OJG_LOVE1 
then
	00D9: $CAR2_LOVE1 = store_car_char_is_in $OJG_LOVE1 
	01D3: actor $OJG_LOVE1 leave_car $CAR2_LOVE1 
	while 00DF:   is_char_in_any_car $OJG_LOVE1 
		wait 0 ms
		gosub @CHECK_OGG_STATUS_LOVE1
	end //while
end

// Tells the OJG to go into Loves buildings
0239: actor $OJG_LOVE1 run_to 59.5 -1548.688 
0006: 17@ = 0 
while 001B:   1500 > 17@ 
	wait 0 ms
	gosub @CHECK_OGG_STATUS_LOVE1
end //while

00A1: set_char_coordinates $OJG_LOVE1 to 82.875 -1548.875 27.1875 
0173: set_actor $OJG_LOVE1 z_angle_to 270.0 
0211: actor $OJG_LOVE1 walk_to 98.6875 -1548.75 
015F: set_camera_position 77.5 -1548.75 28.1875 rotation 0.0 0.0 0.0 
0160: point_camera 93.875 -1548.875 28.25 switchstyle 2 
0006: 17@ = 0 

while 80FF:   not actor $OJG_LOVE1 0 98.6875 -1548.75 27.25 radius 0.5 0.5 4.0 
	wait 0 ms
	gosub @CHECK_OGG_STATUS_LOVE1
	if
		0029:   17@ >= 8000 
	then
		if
			80FF:   not actor $OJG_LOVE1 0 98.6875 -1548.75 27.25 radius 0.5 0.5 4.0 
		then
			034F: destroy_actor_with_fade $OJG_LOVE1 
			goto @MISSION_BLOKE_STUCK_LOVE1
		end
	end
end //while

:MISSION_BLOKE_STUCK_LOVE1

009F: char_set_idle $OJG_LOVE1 
02EB: restore_camera_jumpcut 
034F: destroy_actor_with_fade $OJG_LOVE1 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
01F7: set_player $PLAYER_CHAR ignored_by_cops_state_to 0 
03BF: set_player $PLAYER_CHAR ignored_by_everyone_to 0 

goto @MISSION_PASSED_LOVE1

/////////////////////////////////////////

:CHECK_OGG_STATUS_LOVE1
if
	0118:   actor $OJG_LOVE1 dead 
then
	00BC: print_now 'LOVE1_6' duration 5000 ms flag 1  // ~r~The Old Oriental Gentleman's guts are all over the street!
	goto @MISSION_FAILED_LOVE1
end
return
	

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_LOVE1
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
0004: $FLAG_FAILED_LOVE1 = 1 
goto @MISSION_END_LOVE1

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_LOVE1
0004: $LIBERATOR_COMPLETED = 1 
0318: set_latest_mission_passed 'LOVE1'  // 'LIBERATOR'
030C: set_mission_points += 1 
01E3: text_1number_styled 'M_PASS' number 40000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0109: player $PLAYER_CHAR money += 40000 
0110: clear_player $PLAYER_CHAR wanted_level 
004F: create_thread @LOVE_MISSION2_LOOP 
goto @MISSION_END_LOVE1

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_LOVE1
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_LOVE = 0 
03AC: clear_route 0 
03AC: clear_route 1 
01B4: set_player $PLAYER_CHAR controllable 1 
0249: release_model #GANG11 
0249: release_model #COLUMB 
0164: disable_marker $RADAR_BLIP_PED1_LOVE1 
0164: disable_marker $RADAR_BLIP_COORD1_LOVE1 
0164: disable_marker $RADAR_BLIP_COORD2_LOVE1 
if
	8118:   not actor $BADDIE1_LOVE1 dead 
then
	0350: set_actor $BADDIE1_LOVE1 maintain_position_when_attacked 0 
end
if
	8118:   not actor $BADDIE2_LOVE1 dead 
then
	0350: set_actor $BADDIE2_LOVE1 maintain_position_when_attacked 0 
end
if
	8118:   not actor $BADDIE3_LOVE1 dead 
then
	0350: set_actor $BADDIE3_LOVE1 maintain_position_when_attacked 0 
end
if
	8118:   not actor $BADDIE4_LOVE1 dead 
then
	0350: set_actor $BADDIE4_LOVE1 maintain_position_when_attacked 0 
end
if
	8118:   not actor $BADDIE5_LOVE1 dead 
then
	0350: set_actor $BADDIE5_LOVE1 maintain_position_when_attacked 0 
end
if
	8118:   not actor $BADDIE6_LOVE1 dead 
then
	0350: set_actor $BADDIE6_LOVE1 maintain_position_when_attacked 0 
end
00D8: mission_has_finished 
return
