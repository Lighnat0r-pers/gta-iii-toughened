// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Ray mission 2*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M23_ARMSSHORTAGE

gosub @MISSION_START_RAY2
if 
	0112:   has_deatharrest_been_executed 
then
	gosub @MISSION_FAILED_RAY2
end

:MISSION_END_RAY2
gosub @MISSION_CLEANUP_RAY2
end_thread


// ***************************************Mission Start*************************************

:MISSION_START_RAY2

0317: increment_mission_attempts 
03A4: name_thread 'RAY2' 
0004: $ONMISSION = 1 
0004: $ON_MISSION_FOR_RAY = 1 
0004: $ON_ARMS_SHORTAGE_MISSION = 1 
0004: $RAYS_CUTSCENE_FLAG = 1 
0001: wait 0 ms 
0004: $FLAG_M16_GONE = 0 
0004: $FLAG_UZI_GONE = 0 
0004: $FLAG_ROCKET_GONE = 0 
0004: $FLAG_SHOTGUN_GONE = 0 
0004: $FLAG_MOLOTOV_GONE = 0 
0004: $FLAG_PHIL_IN_AREA = 0 
0004: $FLAG_PHIL_ARRIVED = 0 
0004: $FLAG_PHIL_DEAD = 0 
0004: $FLAG_TRUCKS = 0 
0004: $FLAG_V1_DEAD = 0 
0004: $FLAG_V2_DEAD = 0 
0004: $FLAG_V3_DEAD = 0 
0004: $FLAG_V4_DEAD = 0 
0004: $FLAG_V5_DEAD = 0 
0004: $FLAG_V6_DEAD = 0 
0004: $FLAG_V7_DEAD = 0 
0004: $FLAG_V8_DEAD = 0 
0004: $FLAG_V9_DEAD = 0 
0004: $FLAG_V10_DEAD = 0 
0004: $FLAG_V11_DEAD = 0 
0004: $FLAG_V12_DEAD = 0 
0004: $COUNTER_DEAD_VARMINTS = 0 
0004: $FLAG_CARTEL_ARRIVED = 0 
0004: $STALLION_BAILOUT = 0 
0004: $SENTINEL_BAILOUT = 0 
0004: $PERENIAL_BAILOUT = 0 
0004: $FLAG_STALLION_ARRIVED = 0 
0004: $FLAG_SENTINEL_ARRIVED = 0 
0004: $FLAG_PERENIAL_ARRIVED = 0 
0004: $FLAG_STALLION_CREATED = 0 
0004: $FLAG_SENTINEL_CREATED = 0 
0004: $FLAG_PERENIAL_CREATED = 0 
0004: $FLAG_LAUNCH_STALLION = 0 
0004: $FLAG_LAUNCH_PERENIAL = 0 
0004: $FLAG_SNEAKY_1 = 0 
0004: $FLAG_SNEAKY_2 = 0 
0004: $FLAG_AUDIO = 0 
0004: $FLAG_GATE = 0 
0005: $WH_X_RM2 = 137.125 
0005: $WH_Y_RM2 = 192.375 
0005: $WH2_X_RM2 = 121.5 
0005: $WH2_Y_RM2 = 214.5625 
0005: $VARMINT_GEN1_X = 174.0 
0005: $VARMINT_GEN1_Y = 170.0 
0005: $STAGE_3_X = 153.0 
0005: $STAGE_3_Y = 220.0 
0005: $STAGE_1_X = 172.0 
0005: $STAGE_1_Y = 207.0 
0005: $STAGE_2_X = 152.0 
0005: $STAGE_2_Y = 204.0 
0005: $PHILS_DEFCON_X = 136.5 
0005: $PHILS_DEFCON_Y = 176.6875 
0005: $PHILS_DEFCON_Z = 11.5625 
0005: $M16_X = 145.5 
0005: $M16_Y = 170.0 
0005: $UZI_X = 143.5 
0005: $UZI_Y = 170.0 
0005: $SHOTGUN_X = 141.5 
0005: $SHOTGUN_Y = 170.0 
0005: $ROCKET_X = 126.9375 
0005: $ROCKET_Y = 198.1875 
0005: $MOLOTOV_X = 126.9375 
0005: $MOLOTOV_Y = 191.6875 

// ****************************************START OF CUTSCENE********************************

023C: load_special_actor 'RAY' as 1 
02F3: load_object #CUTOBJ01 'PLAYERH' 
02F3: load_object #CUTOBJ02 'RAYH' 
0247: request_model #TOILET 
038B: load_all_models_now 

while true
	if or
		823D:   not special_actor 1 loaded 
		8248:   not model #CUTOBJ01 available 
		8248:   not model #CUTOBJ02 available 
		8248:   not model #TOILET available 
	jf break
	wait 0 ms
end //while

02E4: load_cutscene_data 'R2_AP' 
03AF: set_streaming 1 
0244: set_cutscene_pos 39.375 -726.625 21.6875 
02E5: $CUTSCENE_PLAYER = create_cutscene_object #NULL 
02E6: set_cutscene_anim $CUTSCENE_PLAYER 'PLAYER' 
02E5: $CUTSCENE_RAY = create_cutscene_object #SPECIAL01 
02E6: set_cutscene_anim $CUTSCENE_RAY 'RAY' 
02F4: create_cutscene_actor $PLAYER_CSHEAD from_head #CUTOBJ01 and_body $CUTSCENE_PLAYER 
02F5: set_head_anim $PLAYER_CSHEAD 'PLAYER' 
02F4: create_cutscene_actor $RAY_CSHEAD from_head #CUTOBJ02 and_body $CUTSCENE_RAY 
02F5: set_head_anim $RAY_CSHEAD 'RAY' 
0395: clear_area 1 at 39.0 -723.5 range 22.0 1.0 
0055: set_player_coordinates $PLAYER_CHAR to 39.0 -723.5 22.0 
0171: set_player $PLAYER_CHAR z_angle_to 90.0 
016A: fade 1 for 250 ms 
041D: set_camera_near_clip 0.1875 
02E7: start_cutscene 
03AF: set_streaming 0 
03AD: set_rubbish 0 
02E8: $CUT_SCENE_TIME = cutscenetime 


// Displays cutscene text

while 001A:   6426 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_A1' duration 10000 ms flag 1  // Hey kid over here!
while 001A:   8218 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_A' duration 10000 ms flag 1  // An old army buddy of mine runs a business in Rockford.
while 001A:   11093 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_B' duration 10000 ms flag 1  // We saw action in Nicaragua, back when the country knew what it was doing.
while 001A:   14634 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_C' duration 10000 ms flag 1  // Some Cartel scum roughed him up yesterday, said they'd be back for some of his stock today.
while 001A:   20938 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_D' duration 10000 ms flag 1  // He's gonna need some back-up and in return he'll give you knock-down rates on any hardware you buy.
while 001A:   26599 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end
00BC: print_now 'RM2_D1' duration 10000 ms flag 1  // I'd go myself but the old sciatica's playing up again -cough cough- so, eerr-hhrrmmm, good luck.
while 001A:   38333 > $CUT_SCENE_TIME
	wait 0 ms
	02E8: $CUT_SCENE_TIME = cutscenetime 
end

016A: fade 0 for 1000 ms


while 82E9:   not cutscene_reached_end
	wait 0 ms
end

00BE: clear_prints 

while fading
	wait 0 ms
end

02EA: end_cutscene 
016A: fade 0 for 0 ms 
0373: set_camera_directly_behind_player 
041D: set_camera_near_clip 0.875 
0001: wait 500 ms 
016A: fade 1 for 1000 ms 
0296: unload_special_actor 1 
0249: release_model #CUTOBJ01 
0249: release_model #CUTOBJ02 
0249: release_model #TOILET 
03AF: set_streaming 1 
03AD: set_rubbish 1 
0004: $RAYS_CUTSCENE_FLAG = 0 

// ******************************************END OF CUTSCENE********************************

// Mission stuff goes here

018A: $BLIP_WAREHOUSE_RM2 = create_checkpoint_at $WH_X_RM2 $WH_Y_RM2 -100.0 

//------------------REQUEST_MODELS ------------------------------

0247: request_model #GANG11 
023C: load_special_actor 'DEALER' as 1 
0247: request_model #GANG12 
0247: request_model #SENTINEL 
0247: request_model #STALLION
0247: request_model #PEREN
0247: request_model #BARRACKS 
0247: request_model #RHINO 

while true
	if or
		8248:   not model #GANG11 available 
		823D:   not special_actor 1 loaded 
		8248:   not model #GANG12 available 
		8248:   not model #SENTINEL available 
		8248:   not model #STALLION available
		8248:   not model #PEREN available
		8248:   not model #BARRACKS available 
		8248:   not model #RHINO available 
	jf break
	wait 0 ms
end //while




//------------------WAITING FOR PLAYER TO ARRIVE---------------------------------------

while 80E3:   not player $PLAYER_CHAR 1 $WH_X_RM2 $WH_Y_RM2 radius 4.0 4.0 
	wait 0 ms
	if and
		0121:   player $PLAYER_CHAR in_zone 'HOSPI_2'  // Rockford
		0038:   $FLAG_TRUCKS == 0
	then
		//--------------------CREATE PHIL'S TRUCKS---------------------------------------------

		00A5: $PHIL_TRUCK_1 = create_car #RHINO at 132.0 173.875 11.5625 
		0175: set_car $PHIL_TRUCK_1 z_angle_to 0.0 
		00A9: car_set_idle $PHIL_TRUCK_1 
		02AC: set_car $PHIL_TRUCK_1 immunities 1 0 0 0 0 
		00A5: $PHIL_TRUCK_2 = create_car #BARRACKS at 133.5 208.75 11.875 
		0175: set_car $PHIL_TRUCK_2 z_angle_to 180.0 
		00A9: car_set_idle $PHIL_TRUCK_2 
		02AC: set_car $PHIL_TRUCK_2 immunities 1 0 0 0 0 
		020A: set_car $PHIL_TRUCK_2 door_status_to CARLOCK_LOCKED 
		0004: $FLAG_TRUCKS = 1 
	end
	if
		0038:   $FLAG_GATE == 0 
	then
		if
			0038:   $GATE2_SFX1 == 0 
		then
			018C: play_sound SOUND_GATE_START_CLUNK at 147.1875 207.3125 10.5625 
			0004: $GATE2_SFX1 = 1 
		end
		while 834E:   not move_object $PHILS_COMPOUND_GATE to 147.1875 214.8125 10.5625 speed 0.0 0.0625 0.0 collision_check 0
			wait 0 ms
		end
		if
			0038:   $NOT_CLUNKED_YET == 1 
		then
			0004: $GATE_SFX2 = 0 
			0004: $NOT_CLUNKED_YET = 0 
		end
		if
			0038:   $GATE2_SFX2 == 0 
		then
			018C: play_sound SOUND_GATE_STOP_CLUNK at 147.1875 214.8125 10.5625 
			0004: $GATE2_SFX2 = 1 
		end
		0004: $FLAG_GATE = 1
	end
end //while

//--------------------PLAYER ARRIVED (CUTSCENE)------------------------------------------
//-----------------------CREATE PHIL-------------------

0395: clear_area 1 at $PHILS_DEFCON_X $PHILS_DEFCON_Y range 11.5 20.0 
009A: $PHIL = create_char PEDTYPE_SPECIAL model #SPECIAL01 at $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
0173: set_actor $PHIL z_angle_to 360.0 
01B2: give_actor $PHIL weapon WEAPONTYPE_BASEBALLBAT ammo 1 
035F: set_actor $PHIL armour_to 100 
0243: set_actor $PHIL ped_stats_to PEDSTAT_TOUGH_GUY 
01ED: clear_actor $PHIL threat_search 
011A: set_actor $PHIL search_threat THREAT_GANG_COLOMBIAN 


//-----------------------CREATE PHIL'S 'SUPPLIES'-------------------------------------

032B: $PHILS_M16 = create_weapon_pickup #M16 type PICKUP_ONCE ammo 60 at $M16_X $M16_Y 11.5 
0213: $PHILS_UZI = create_pickup #UZI type PICKUP_ONCE at $UZI_X $UZI_Y 11.5 
0213: $PHILS_SHOTGUN = create_pickup #SHOTGUN type PICKUP_ONCE at $SHOTGUN_X $SHOTGUN_Y 11.5 
032B: $PHILS_ROCKET = create_weapon_pickup #ROCKET type PICKUP_ONCE ammo 1 at $ROCKET_X $ROCKET_Y 14.5
0213: $PHILS_MOLOTOV = create_pickup #MOLOTOV type PICKUP_ONCE at $MOLOTOV_X $MOLOTOV_Y 14.5
0213: $PHILS_ARMOUR = create_pickup #BODYARMOUR type PICKUP_ON_STREET_SLOW at 121.125 194.875 11.5 

0164: disable_marker $BLIP_WAREHOUSE_RM2 
01B4: set_player $PLAYER_CHAR controllable 0 
01F5: $PLAYER_RM2 = create_emulated_actor_from_player $PLAYER_CHAR 
015F: set_camera_position 141.5 184.5 12.5 rotation 0.0 0.0 0.0 
02A3: toggle_widescreen 1 

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	00DA: $PLAYER_CAR_RM2 = store_car_player_is_in $PLAYER_CHAR 
	0221: set_player $PLAYER_CHAR apply_brakes_to_car 1 
	00A9: car_set_idle $PLAYER_CAR_RM2 
	0158: camera_on_vehicle $PLAYER_CAR_RM2 mode FIXED switchstyle JUMP_CUT
	01D3: actor $PLAYER_RM2 leave_car $PLAYER_CAR_RM2 
	while 00DB:   is_char_in_car $PLAYER_RM2 car $PLAYER_CAR_RM2 
		wait 0 ms
		if
			0119:   car $PLAYER_CAR_RM2 wrecked
		then
			goto @BIBBLE
		end
	end //while
end

0159: camera_on_ped $PLAYER_RM2 mode FIXED switchstyle JUMP_CUT


:BIBBLE

0001: wait 0 ms 
0009: $PHILS_DEFCON_Y += 3.0 
0239: actor $PLAYER_RM2 run_to $PHILS_DEFCON_X $PHILS_DEFCON_Y 

while 80E3:   not player $PLAYER_CHAR 0 $PHILS_DEFCON_X $PHILS_DEFCON_Y radius 2.0 2.0 
	wait 0 ms
end

03CF: load_wav 'R2_A' 

while 83D0:   not wav_loaded 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_E' duration 4000 ms flag 1  // Ray phoned ahead....but I thought there'd be more of you.

while 83D2:   not wav_ended 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03CF: load_wav 'R2_B' 

while 83D0:   not wav_loaded 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_E1' duration 4000 ms flag 1  // I can't believe those yellow-bellied bastards left me without proper cover again!

while 83D2:   not wav_ended 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03CF: load_wav 'R2_C' 

while 83D0:   not wav_loaded 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_F' duration 4000 ms flag 1  // Well, three arms are better than one, so grab whatever you need.

while 83D2:   not wav_ended 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03CF: load_wav 'R2_D' 

while 83D0:   not wav_loaded 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_F1' duration 4000 ms flag 1  // Those Colombians'll be here any minute!

while 83D2:   not wav_ended 
	wait 0 ms
	if
		00E1:   is_button_pressed PAD1 button CROSS 
	then
		goto @PEEDLE
	end
end //while

:PEEDLE
040D: clear_mission_audio 
00BE: clear_prints 
01B4: set_player $PLAYER_CHAR controllable 1 
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01BD: $TIMER_START_RM2 = current_time_in_ms 
01BD: $TIMER_NOW_RM2 = current_time_in_ms 
0084: $TIMER_DIF_RM2 = $TIMER_NOW_RM2 
0060: $TIMER_DIF_RM2 -= $TIMER_START_RM2 


//-------GIVE PLAYER TIME TO GET PICKUPS WITHOUT LEAVING COMPOUND-------

0395: clear_area 1 at $VARMINT_GEN1_X $VARMINT_GEN1_Y range 11.5 20.0 
0395: clear_area 1 at $STAGE_3_X $STAGE_3_Y range 11.5 20.0 
0395: clear_area 1 at $STAGE_1_X $STAGE_1_Y range 11.5 20.0 
0395: clear_area 1 at $STAGE_2_X $STAGE_2_Y range 11.5 20.0 

if
	8119:   not car $PHIL_TRUCK_2 wrecked 
then
	020A: set_car $PHIL_TRUCK_2 door_status_to CARLOCK_UNLOCKED 
end

while true
	if and
		001A:   25000 > $TIMER_DIF_RM2 
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 119.0 167.0 to 147.0 246.0 sphere 0 
	jf break
	wait 0 ms
	gosub @PICKUPS
	if
		0056:   is_player_in_area_2d $PLAYER_CHAR coords 147.0 198.0 to 156.0 208.0 sphere 0 
	then
		goto @HERRING
	end
	if
		00E0:   is_player_in_any_car $PLAYER_CHAR 
	then
		goto @HERRING
	end

	01BD: $TIMER_NOW_RM2 = current_time_in_ms 
	0084: $TIMER_DIF_RM2 = $TIMER_NOW_RM2 
	0060: $TIMER_DIF_RM2 -= $TIMER_START_RM2 
	if
		0118:   actor $PHIL dead 
	then
		0004: $FLAG_PHIL_DEAD = 1 
		goto @MISSION_FAILED_RAY2
	end
end //while

:HERRING
//----LOAD PHIL'S SOUND BITE-----------------------------------------
03CF: load_wav 'R2_E' 
while 83D0:   not wav_loaded 
	wait 0 ms
end

//-----------------MAIN LOOP-----------------------------------------

01BD: $TIMER_START_RM2 = current_time_in_ms 

while 001A:   12 > $COUNTER_DEAD_VARMINTS 
	wait 0 ms
	01BD: $TIMER_NOW_RM2 = current_time_in_ms 
	0084: $TIMER_DIF_RM2 = $TIMER_NOW_RM2 
	0060: $TIMER_DIF_RM2 -= $TIMER_START_RM2 
	gosub @PICKUPS

	//--------sentinel gen stuff--------------------------------------------

	if and
		0018:   $TIMER_DIF_RM2 > 2000 
		0038:   $FLAG_SENTINEL_CREATED == 0 
	then
		00A5: $SENTINEL1_RM2 = create_car #SENTINEL at $VARMINT_GEN1_X $VARMINT_GEN1_Y -100.0 
		02AA: set_car $SENTINEL1_RM2 immune_to_nonplayer 1 
		020A: set_car $SENTINEL1_RM2 door_status_to CARLOCK_LOCKED 
		0186: $BLIP_SENTINEL1 = create_marker_above_car $SENTINEL1_RM2 
		0129: $VARMINT_1 = create_actor PEDTYPE_GANG_COLOMBIAN #GANG12 in_car $SENTINEL1_RM2 driverseat 
		01C8: $VARMINT_2 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $SENTINEL1_RM2 passenger_seat 0 
		01C8: $VARMINT_3 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $SENTINEL1_RM2 passenger_seat 1 
		01C8: $VARMINT_4 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $SENTINEL1_RM2 passenger_seat 2 
		00AD: set_car_cruise_speed $SENTINEL1_RM2 to 10.0 
		00AE: set_car_driving_style $SENTINEL1_RM2 to 3 
		02C2: car $SENTINEL1_RM2 drive_to_point $STAGE_1_X $STAGE_1_Y 11.5625 
		0004: $FLAG_SENTINEL_CREATED = 1 
	end

	if and
		0038:   $FLAG_LAUNCH_STALLION == 0 
		0038:   $FLAG_SENTINEL_CREATED == 1 
	then
		if
			8119:   not car $SENTINEL1_RM2 wrecked 
		then
			if
				01AD:   car $SENTINEL1_RM2 sphere 0 near_point $STAGE_1_X $STAGE_1_Y radius 4.0 4.0 
			then
				02C2: car $SENTINEL1_RM2 drive_to_point $STAGE_2_X $STAGE_2_Y 11.5625 
				0004: $FLAG_LAUNCH_STALLION = 1 
			end
		end
	end

	if and
		0038:   $FLAG_LAUNCH_STALLION == 1 
		0038:   $FLAG_SENTINEL_CREATED == 1 
	then
		if
			8119:   not car $SENTINEL1_RM2 wrecked 
		then
			if
				01AD:   car $SENTINEL1_RM2 sphere 0 near_point $STAGE_2_X $STAGE_2_Y radius 4.0 4.0 
			then
				0004: $FLAG_LAUNCH_STALLION = 2 
				0004: $FLAG_SENTINEL_ARRIVED = 1 
				02AA: set_car $SENTINEL1_RM2 immune_to_nonplayer 0 
				020A: set_car $SENTINEL1_RM2 door_status_to CARLOCK_UNLOCKED 
				if
					001A:   2 > $FLAG_CARTEL_ARRIVED 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1
				end
			end
		end
	end
	
	if
		0038:   $FLAG_SENTINEL_CREATED == 1 
	then
		if
			0119:   car $SENTINEL1_RM2 wrecked 
		then
			0004: $FLAG_LAUNCH_STALLION = 1 
			0164: disable_marker $BLIP_SENTINEL1 
		else
			if
				8185:   not car $SENTINEL1_RM2 health >= 950 
			then
				0004: $FLAG_SENTINEL_ARRIVED = 1 
				if
					0038:   $FLAG_LAUNCH_STALLION == 0 
				then
					0004: $FLAG_LAUNCH_STALLION = 1 
				end
				if
					0038:   $FLAG_CARTEL_ARRIVED == 0 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1 
				end
			end
		end
	end

	//-----stallion gen stuff------------------------------------------------

	if and
		0018:   $TIMER_DIF_RM2 > 4000 
		0038:   $FLAG_STALLION_CREATED == 0 
		0018:   $FLAG_LAUNCH_STALLION > 0 
	then
		00A5: $STALLION1_RM2 = create_car #STALLION at $VARMINT_GEN1_X $VARMINT_GEN1_Y -100.0 
		02AA: set_car $STALLION1_RM2 immune_to_nonplayer 1 
		020A: set_car $STALLION1_RM2 door_status_to CARLOCK_LOCKED 
		0186: $BLIP_STALLION1 = create_marker_above_car $STALLION1_RM2 
		0129: $VARMINT_5 = create_actor PEDTYPE_GANG_COLOMBIAN #GANG11 in_car $STALLION1_RM2 driverseat 
		01C8: $VARMINT_6 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $STALLION1_RM2 passenger_seat 0 
		00AD: set_car_cruise_speed $STALLION1_RM2 to 10.0 
		00AE: set_car_driving_style $STALLION1_RM2 to 3 
		02C2: car $STALLION1_RM2 drive_to_point $STAGE_1_X $STAGE_1_Y 11.5625 
		0004: $FLAG_STALLION_CREATED = 1 
	end

	if and
		0038:   $FLAG_LAUNCH_PERENIAL == 0 
		0038:   $FLAG_STALLION_CREATED == 1 
	then
		if
			8119:   not car $STALLION1_RM2 wrecked 
		then
			if
				01AD:   car $STALLION1_RM2 sphere 0 near_point $STAGE_1_X $STAGE_1_Y radius 4.0 4.0 
			then
				02C2: car $STALLION1_RM2 drive_to_point $STAGE_3_X $STAGE_3_Y 11.5625 
				0004: $FLAG_LAUNCH_PERENIAL = 1 
			end
		end
	end

	if and
		0038:   $FLAG_LAUNCH_PERENIAL == 1 
		0038:   $FLAG_STALLION_CREATED == 1 
	then
		if
			8119:   not car $STALLION1_RM2 wrecked 
		then
			if
				01AD:   car $STALLION1_RM2 sphere 0 near_point $STAGE_3_X $STAGE_3_Y radius 4.0 4.0 
			then
				0004: $FLAG_LAUNCH_PERENIAL = 2 
				0004: $FLAG_STALLION_ARRIVED = 1 
				02AA: set_car $STALLION1_RM2 immune_to_nonplayer 0 
				020A: set_car $STALLION1_RM2 door_status_to CARLOCK_UNLOCKED 
				if
					001A:   2 > $FLAG_CARTEL_ARRIVED 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1
				end
			end
		end
	end
	
	if
		0038:   $FLAG_STALLION_CREATED == 1 
	then
		if
			0119:   car $STALLION1_RM2 wrecked 
		then
			0004: $FLAG_LAUNCH_PERENIAL = 1 
			0164: disable_marker $BLIP_STALLION1 
		else
			if
				8185:   not car $STALLION1_RM2 health >= 950 
			then
				0004: $FLAG_STALLION_ARRIVED = 1 
				if
					0038:   $FLAG_CARTEL_ARRIVED == 0 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1 
				end
			end
		end
	end

	//-----perenial gen stuff-----------------------------------------------

	if and
		0018:   $TIMER_DIF_RM2 > 6000 
		0038:   $FLAG_PERENIAL_CREATED == 0 
		0018:   $FLAG_LAUNCH_PERENIAL > 0 
	then
		00A5: $PERENIAL1_RM2 = create_car #PEREN at $VARMINT_GEN1_X $VARMINT_GEN1_Y -100.0 
		02AA: set_car $PERENIAL1_RM2 immune_to_nonplayer 1 
		020A: set_car $PERENIAL1_RM2 door_status_to CARLOCK_LOCKED 
		0186: $BLIP_PERENIAL1 = create_marker_above_car $PERENIAL1_RM2 
		0129: $VARMINT_7 = create_actor PEDTYPE_GANG_COLOMBIAN #GANG12 in_car $PERENIAL1_RM2 driverseat 
		01C8: $VARMINT_8 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $PERENIAL1_RM2 passenger_seat 0 
		01C8: $VARMINT_9 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG12 in_car $PERENIAL1_RM2 passenger_seat 1 
		01C8: $VARMINT_10 = create_actor PEDTYPE_GANG_COLOMBIAN model #GANG11 in_car $PERENIAL1_RM2 passenger_seat 2 
		00AD: set_car_cruise_speed $PERENIAL1_RM2 to 10.0 
		00AE: set_car_driving_style $PERENIAL1_RM2 to 3 
		02C2: car $PERENIAL1_RM2 drive_to_point $STAGE_1_X $STAGE_1_Y 11.5625 
		0004: $FLAG_PERENIAL_CREATED = 1 
	end


	if
		0038:   $FLAG_PERENIAL_CREATED == 1 
	then
		if
			8119:   not car $PERENIAL1_RM2 wrecked 
		then
			if
				01AD:   car $PERENIAL1_RM2 sphere 0 near_point $STAGE_1_X $STAGE_1_Y radius 4.0 4.0 
			then
				0004: $FLAG_PERENIAL_ARRIVED = 1 
				02AA: set_car $PERENIAL1_RM2 immune_to_nonplayer 0 
				020A: set_car $PERENIAL1_RM2 door_status_to CARLOCK_UNLOCKED
				if
					001A:   2 > $FLAG_CARTEL_ARRIVED 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1
				end 
			end
			if
				8185:   not car $PERENIAL1_RM2 health >= 950 
			then
				0004: $FLAG_PERENIAL_ARRIVED = 1 
				if
					0038:   $FLAG_CARTEL_ARRIVED == 0 
				then
					0004: $FLAG_CARTEL_ARRIVED = 1 
				end
			end
		else
			0164: disable_marker $BLIP_PERENIAL1 
		end
	end

	//----------------Sneaky backstab----------------------------------------


	if and
		0018:   $FLAG_CARTEL_ARRIVED > 0 
		0018:   $TIMER_DIF_RM2 > 12000 
	then
		if 
			0038:   $FLAG_SNEAKY_1 == 0 
		then
			if 
				80C2:   not is_point_on_screen 121.25 217.6875 11.5 2.5 
			then
				009A: $VARMINT_11 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 121.25 235.6875 11.5 
				01B2: give_actor $VARMINT_11 weapon WEAPONTYPE_CHAINGUN ammo 300 
				035F: set_actor $VARMINT_11 armour_to 1000
				0162: $BLIP_V11 = create_marker_above_actor $VARMINT_11 color 1 visibility BLIP_ONLY
				0239: actor $VARMINT_11 run_to $PHILS_DEFCON_X $PHILS_DEFCON_Y 
				011A: set_actor $VARMINT_11 search_threat THREAT_PLAYER1 
				011A: set_actor $VARMINT_11 search_threat THREAT_SPECIAL 
				0291: set_actor $VARMINT_11 attack_when_provoked 1 
				0004: $FLAG_SNEAKY_1 = 1 
			end
		end
		if 
			0038:   $FLAG_SNEAKY_2 == 0 
		then
			if 
				80C2:   not is_point_on_screen 121.25 241.5625 11.5 2.5 
			then
				009A: $VARMINT_12 = create_char PEDTYPE_GANG_COLOMBIAN model #GANG11 at 121.25 241.5625 11.5 
				01B2: give_actor $VARMINT_12 weapon WEAPONTYPE_SHOTGUN ammo 50 
				035F: set_actor $VARMINT_12 armour_to 1000
				0162: $BLIP_V12 = create_marker_above_actor $VARMINT_12 color 1 visibility BLIP_ONLY 
				0239: actor $VARMINT_12 run_to 124.125 184.6875 
				011A: set_actor $VARMINT_12 search_threat THREAT_PLAYER1 
				011A: set_actor $VARMINT_12 search_threat THREAT_SPECIAL 
				0291: set_actor $VARMINT_12 attack_when_provoked 1 
				0004: $FLAG_SNEAKY_2 = 1 
			end
		end
	end
	if
		0118:   actor $PHIL dead 
	then
		0004: $FLAG_PHIL_DEAD = 1 
		goto @MISSION_FAILED_RAY2
	end
	if
		0038:   $FLAG_CARTEL_ARRIVED == 1 
	then
		03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
		03D1: play_wav 
		00BC: print_now 'RM2_K' duration 4000 ms flag 1  // Goddam they're here!! LOCK'N'LOAD!!
		0004: $FLAG_CARTEL_ARRIVED = 2 
	end
	gosub @VARMINT_DEATHS
	gosub @BIG_BAILOUT_ROUTINE
end //while

//-------All Cartel Varmints dead-----------------------------------------------

if
	8118:   not actor $PHIL dead 
then
	0223: set_actor $PHIL health_to 5 
	0350: set_actor $PHIL maintain_position_when_attacked 1 
	00A0: get_char_coordinates $PHIL store_to $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
	if
		80E3:   not player $PLAYER_CHAR 0 $PHILS_DEFCON_X $PHILS_DEFCON_Y radius 2.0 2.0 
	then
		00BC: print_now 'RM2_G' duration 2500 ms flag 1  // ~g~Go and check on Phil!
		0187: $BLIP_PHIL = create_marker_above_actor $PHIL
		while 80E3:   not player $PLAYER_CHAR 0 $PHILS_DEFCON_X $PHILS_DEFCON_Y radius 2.0 2.0 
			wait 0 ms
			if
				0118:   actor $PHIL dead 
			then
				0004: $FLAG_PHIL_DEAD = 1 
				0164: disable_marker $BLIP_PHIL 
				goto @MISSION_FAILED_RAY2
			end
		end //while
	end
end

if
	0118:   actor $PHIL dead 
then
	0004: $FLAG_PHIL_DEAD = 1 
	0164: disable_marker $BLIP_PHIL 
	goto @MISSION_FAILED_RAY2
else
	0223: set_actor $PHIL health_to 100 
end

0164: disable_marker $BLIP_PHIL 
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 
015F: set_camera_position 134.5625 184.6875 11.125 rotation 0.0 0.0 0.0 

if
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	00DA: $PLAYER_CAR_RM2 = store_car_player_is_in $PLAYER_CHAR 
	0221: set_player $PLAYER_CHAR apply_brakes_to_car 1 
	00A9: car_set_idle $PLAYER_CAR_RM2 
	0158: camera_on_vehicle $PLAYER_CAR_RM2 mode FIXED switchstyle JUMP_CUT
	01D3: actor $PLAYER_RM2 leave_car $PLAYER_CAR_RM2 
	while 00DB:   is_char_in_car $PLAYER_RM2 car $PLAYER_CAR_RM2 
		wait 0 ms
		if
			0119:   car $PLAYER_CAR_RM2 wrecked 
		then
			goto @BOOBBLE
		end
		if
			0118:   actor $PHIL dead 
		then
			0004: $FLAG_PHIL_DEAD = 1 
			0164: disable_marker $BLIP_PHIL 
			goto @MISSION_FAILED_RAY2
		end
	end //while
end

:BOOBBLE

01F5: $PLAYER_RM2 = create_emulated_actor_from_player $PLAYER_CHAR 

if
	8118:   not actor $PHIL dead 
then
	020E: actor $PHIL look_at_actor $PLAYER_RM2 
	0159: camera_on_ped $PHIL mode FIXED switchstyle JUMP_CUT 
end

03CF: load_wav 'R2_F' 

while 83D0:   not wav_loaded 
	wait 0 ms
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_L' duration 3000 ms flag 1  // Heh-hey! If I'd teamed up with you in Nicaragua maybe I'd still have my arm!

while 83D2:   not wav_ended 
	wait 0 ms
end //while

if
	0038:   $FLAG_M16_GONE == 0 
then
	0215: destroy_pickup $PHILS_M16 
end
if
	0038:   $FLAG_SHOTGUN_GONE == 0 
then
	0215: destroy_pickup $PHILS_SHOTGUN 
end
if
	0038:   $FLAG_UZI_GONE == 0 
then
	0215: destroy_pickup $PHILS_UZI 
end
if
	0038:   $FLAG_MOLOTOV_GONE == 0 
then
	0215: destroy_pickup $PHILS_MOLOTOV 
end
if
	0038:   $FLAG_ROCKET_GONE == 0 
then
	0215: destroy_pickup $PHILS_ROCKET
end
if
	0038:   $ARMS_SHORTAGE_COMPLETED == 0 
then
	0215: destroy_pickup $PHILS_ARMOUR 
end

0005: $M16_X = 145.5 
0005: $M16_Y = 170.0 
0005: $UZI_X = 143.5 
0005: $UZI_Y = 170.0 
0005: $SHOTGUN_X = 141.5 
0005: $SHOTGUN_Y = 170.0 
0213: $PHILS_M16 = create_pickup #M16 type PICKUP_IN_SHOP at $M16_X $M16_Y 11.5 
0213: $PHILS_UZI = create_pickup #SHOTGUN type PICKUP_IN_SHOP at $UZI_X $UZI_Y 11.5 
0213: $PHILS_SHOTGUN = create_pickup #ROCKET type PICKUP_IN_SHOP at $SHOTGUN_X $SHOTGUN_Y 11.5 
0004: $FLAG_M16_GONE = 1 
0004: $FLAG_UZI_GONE = 1 
0004: $FLAG_SHOTGUN_GONE = 1 
03CF: load_wav 'R2_G' 

while 83D0:   not wav_loaded 
	wait 0 ms
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_M' duration 3000 ms flag 1  // If you need any firepower just drop by and take what you need from the lockers.
015F: set_camera_position 143.5 179.0 11.5 rotation 0.0 0.0 0.0 
0160: point_camera 144.0 170.6875 11.5 switchstyle JUMP_CUT 

while 83D2:   not wav_ended 
	wait 0 ms
end //while

03CF: load_wav 'R2_H'

while 83D0:   not wav_loaded 
	wait 0 ms
end //while

03D7: set_wav_location $PHILS_DEFCON_X $PHILS_DEFCON_Y $PHILS_DEFCON_Z 
03D1: play_wav 
00BC: print_now 'RM2_N' duration 3000 ms flag 1  // Leave the cash behind. Now get out of here, I'll handle the cops.

while 83D2:   not wav_ended 
	wait 0 ms
end //while

0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle INTERPOLATION
0001: wait 2000 ms 

if
	8118:   not actor $PHIL dead 
then
	011C: actor $PHIL clear_objective 
	0211: actor $PHIL walk_to 144.0 174.375 
end

while 0038:   $FLAG_PHIL_ARRIVED == 0 
	wait 0 ms
	if
		8118:   not actor $PHIL dead 
	then
		if
			00ED:   actor $PHIL #NULL 144.0 174.375 radius 1.0 1.0 
		then
			0004: $FLAG_PHIL_ARRIVED = 1 
		end
	else
		goto @MISSION_FAILED_RAY2
	end
end //while

009B: delete_char $PHIL 
02A3: toggle_widescreen 0 
02EB: restore_camera_jumpcut 
01B4: set_player $PLAYER_CHAR controllable 1 

goto @MISSION_PASSED_RAY2

/////////////////////////////////////////

// Mission Failed

:MISSION_FAILED_RAY2
if
	0038:   $FLAG_PHIL_DEAD == 1 
then
	00BC: print_now 'RM2_H' duration 3000 ms flag 1  // ~r~Phil has been killed!!
end
00BA: print_big 'M_FAIL' duration 5000 ms style 1  // MISSION FAILED!
goto @MISSION_END_RAY2

/////////////////////////////////////////

// Mission Passed

:MISSION_PASSED_RAY2
if
	0038:   $FLAG_M16_GONE == 0 
then
	0215: destroy_pickup $PHILS_M16 
	0004: $FLAG_M16_GONE = 1 
end
if
	0038:   $FLAG_SHOTGUN_GONE == 0 
then
	0215: destroy_pickup $PHILS_SHOTGUN 
	0004: $FLAG_SHOTGUN_GONE = 1 
end
if
	0038:   $FLAG_UZI_GONE == 0 
then
	0215: destroy_pickup $PHILS_UZI 
	0004: $FLAG_UZI_GONE = 1 
end
if
	0038:   $FLAG_MOLOTOV_GONE == 0 
then
	0215: destroy_pickup $PHILS_MOLOTOV 
	0004: $FLAG_MOLOTOV_GONE = 1 
end
if
	0038:   $FLAG_ROCKET_GONE == 0 
then
	0215: destroy_pickup $PHILS_ROCKET
	0004: $FLAG_ROCKET_GONE = 1 
end
0004: $ARMS_SHORTAGE_COMPLETED = 1 
01E3: text_1number_styled 'M_PASS' number 10000 duration 5000 ms style 1  // MISSION PASSED! $~1~
0394: play_mission_passed_music 1 
0110: clear_player $PLAYER_CHAR wanted_level 
0109: player $PLAYER_CHAR money += 10000 
0318: set_latest_mission_passed 'RM2'  // 'ARMS SHORTAGE'
030C: set_mission_points += 1 
004F: create_thread @RAY_MISSION3_LOOP 
goto @MISSION_END_RAY2

/////////////////////////////////////////

// Mission Cleanup

:MISSION_CLEANUP_RAY2
0004: $ONMISSION = 0 
0004: $ON_MISSION_FOR_RAY = 0 
0004: $ON_ARMS_SHORTAGE_MISSION = 0 
01B4: set_player $PLAYER_CHAR controllable 1 
02A3: toggle_widescreen 0 
02EB: restore_camera_jumpcut 
0249: release_model #SPECIAL01 
0249: release_model #RHINO 
0249: release_model #PATRIOT 
0249: release_model #BARRACKS 
0249: release_model #SENTINEL 
0249: release_model #STALLION 
0249: release_model #GANG11 
0249: release_model #GANG12 
0296: unload_special_actor 1 
0164: disable_marker $BLIP_WAREHOUSE_RM2 
0164: disable_marker $BLIP_SENTINEL1 
0164: disable_marker $BLIP_STALLION1 
0164: disable_marker $BLIP_PERENIAL1 
0164: disable_marker $BLIP_V1 
0164: disable_marker $BLIP_V2 
0164: disable_marker $BLIP_V3 
0164: disable_marker $BLIP_V4 
0164: disable_marker $BLIP_V5 
0164: disable_marker $BLIP_V6 
0164: disable_marker $BLIP_V7 
0164: disable_marker $BLIP_V8 
0164: disable_marker $BLIP_V9 
0164: disable_marker $BLIP_V10 
0164: disable_marker $BLIP_V11 
0164: disable_marker $BLIP_V12 

if
	0038:   $FLAG_M16_GONE == 0 
then
	0215: destroy_pickup $PHILS_M16 
end
if
	0038:   $FLAG_SHOTGUN_GONE == 0 
then
	0215: destroy_pickup $PHILS_SHOTGUN 
end
if
	0038:   $FLAG_UZI_GONE == 0 
then
	0215: destroy_pickup $PHILS_UZI 
end
if
	0038:   $FLAG_MOLOTOV_GONE == 0 
then
	0215: destroy_pickup $PHILS_MOLOTOV 
end
if
	0038:   $FLAG_ROCKET_GONE == 0 
then
	0215: destroy_pickup $PHILS_ROCKET
end
if
	0038:   $ARMS_SHORTAGE_COMPLETED == 0 
then
	0215: destroy_pickup $PHILS_ARMOUR 
end
00D8: mission_has_finished 
return

//---------------------------GOSUBS----------------GOSUBS---------------------------actuallydon'tchaknow

//-------------------------------BAILOUT----------------------------------------------
:BIG_BAILOUT_ROUTINE
if and
	0038:   $STALLION_BAILOUT == 0 
	0038:   $FLAG_STALLION_ARRIVED == 1 
then
	if and
		8118:   not actor $VARMINT_5 dead 
		8119:   not car $STALLION1_RM2 wrecked 
	then
		01D3: actor $VARMINT_5 leave_car $STALLION1_RM2 
		while 00DB:   is_char_in_car $VARMINT_5 car $STALLION1_RM2 
			wait 0 ms
			if
				0119:   car $STALLION1_RM2 wrecked
			then
				goto @PLOOK2
			end
			if
				0118:   actor $VARMINT_5 dead 
			then
				goto @PLOOK1
			end
		end //while
		if
			8118:   not actor $VARMINT_5 dead 
		then
			0162: $BLIP_V5 = create_marker_above_actor $VARMINT_5 color 1 visibility BLIP_ONLY 
			035F: set_actor $VARMINT_5 armour_to 100 
			01B2: give_actor $VARMINT_5 weapon WEAPONTYPE_UZI ammo 60 
			0239: actor $VARMINT_5 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_5 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_5 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_5 attack_when_provoked 1
		end
	end

	:PLOOK1

	if and
		8118:   not actor $VARMINT_6 dead 
		8119:   not car $STALLION1_RM2 wrecked 
	then
		01D3: actor $VARMINT_6 leave_car $STALLION1_RM2 
		while 00DB:   is_char_in_car $VARMINT_6 car $STALLION1_RM2 
			wait 0 ms
			if
				0119:   car $STALLION1_RM2 wrecked
			then
				goto @PLOOK2
			end
			if
				0118:   actor $VARMINT_6 dead 
			then
				goto @PLOOK2
			end
		end //while
		if
			8118:   not actor $VARMINT_6 dead 
		then
			0162: $BLIP_V6 = create_marker_above_actor $VARMINT_6 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_6 weapon WEAPONTYPE_UZI ammo 60 
			0239: actor $VARMINT_6 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_6 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_6 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_6 attack_when_provoked 1
		end
	end

	:PLOOK2

	0164: disable_marker $BLIP_STALLION1 
	0004: $STALLION_BAILOUT = 1 
end

if and
	0038:   $SENTINEL_BAILOUT == 0 
	0038:   $FLAG_SENTINEL_ARRIVED == 1 
then
	if and
		8118:   not actor $VARMINT_1 dead 
		8119:   not car $SENTINEL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_1 leave_car $SENTINEL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_1 car $SENTINEL1_RM2 
			wait 0 ms
			if
				0119:   car $SENTINEL1_RM2 wrecked
			then
				goto @PLOOK6
			end
			if
				0118:   actor $VARMINT_1 dead 
			then
				goto @PLOOK3
			end
		end //while
		if
			8118:   not actor $VARMINT_1 dead 
		then
			0162: $BLIP_V1 = create_marker_above_actor $VARMINT_1 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_1 weapon WEAPONTYPE_SHOTGUN ammo 20 
			0239: actor $VARMINT_1 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_1 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_1 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_1 attack_when_provoked 1
		end
	end

	:PLOOK3

	if and
		8118:   not actor $VARMINT_2 dead 
		8119:   not car $SENTINEL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_2 leave_car $SENTINEL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_2 car $SENTINEL1_RM2 
			wait 0 ms
			if
				0119:   car $SENTINEL1_RM2 wrecked
			then
				goto @PLOOK6
			end
			if
				0118:   actor $VARMINT_2 dead 
			then
				goto @PLOOK4
			end
		end //while
		if
			8118:   not actor $VARMINT_2 dead 
		then
			0162: $BLIP_V2 = create_marker_above_actor $VARMINT_2 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_2 weapon WEAPONTYPE_SHOTGUN ammo 20 
			0239: actor $VARMINT_2 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_2 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_2 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_2 attack_when_provoked 1
		end
	end

	:PLOOK4

	if and
		8118:   not actor $VARMINT_3 dead 
		8119:   not car $SENTINEL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_3 leave_car $SENTINEL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_3 car $SENTINEL1_RM2 
			wait 0 ms
			if
				0119:   car $SENTINEL1_RM2 wrecked
			then
				goto @PLOOK6
			end
			if
				0118:   actor $VARMINT_3 dead 
			then
				goto @PLOOK5
			end
		end //while
		if
			8118:   not actor $VARMINT_3 dead 
		then
			0162: $BLIP_V3 = create_marker_above_actor $VARMINT_3 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_3 weapon WEAPONTYPE_CHAINGUN ammo 80 
			0239: actor $VARMINT_3 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_3 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_3 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_3 attack_when_provoked 1
		end
	end

	:PLOOK5

	if and
		8118:   not actor $VARMINT_4 dead 
		8119:   not car $SENTINEL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_4 leave_car $SENTINEL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_4 car $SENTINEL1_RM2 
			wait 0 ms
			if
				0119:   car $SENTINEL1_RM2 wrecked
			then
				goto @PLOOK6
			end
			if
				0118:   actor $VARMINT_4 dead 
			then
				goto @PLOOK6
			end
		end //while
		if
			8118:   not actor $VARMINT_4 dead 
		then
			0162: $BLIP_V4 = create_marker_above_actor $VARMINT_4 color 1 BLIP_ONLY 
			035F: set_actor $VARMINT_4 armour_to 100 
			01B2: give_actor $VARMINT_4 weapon WEAPONTYPE_MOLOTOV ammo 5 
			0239: actor $VARMINT_4 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_4 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_4 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_4 attack_when_provoked 1
		end
	end

	:PLOOK6

	0164: disable_marker $BLIP_SENTINEL1 
	0004: $SENTINEL_BAILOUT = 1 
end

if and
	0038:   $PERENIAL_BAILOUT == 0 
	0038:   $FLAG_PERENIAL_ARRIVED == 1 
then
	if and
		8118:   not actor $VARMINT_7 dead 
		8119:   not car $PERENIAL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_7 leave_car $PERENIAL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_7 car $PERENIAL1_RM2 
			wait 0 ms
			if
				0119:   car $PERENIAL1_RM2 wrecked
			then
				goto @PLOOK10
			end
			if
				0118:   actor $VARMINT_7 dead 
			then
				goto @PLOOK7
			end
		end //while
		if
			8118:   not actor $VARMINT_7 dead 
		then
			0162: $BLIP_V7 = create_marker_above_actor $VARMINT_7 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_7 weapon WEAPONTYPE_SHOTGUN ammo 10 
			0239: actor $VARMINT_7 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_7 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_7 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_7 attack_when_provoked 1
		end
	end

	:PLOOK7

	if and
		8118:   not actor $VARMINT_8 dead 
		8119:   not car $PERENIAL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_8 leave_car $PERENIAL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_8 car $PERENIAL1_RM2 
			wait 0 ms
			if
				0119:   car $PERENIAL1_RM2 wrecked
			then
				goto @PLOOK10
			end
			if
				0118:   actor $VARMINT_8 dead 
			then
				goto @PLOOK8
			end
		end //while
		if
			8118:   not actor $VARMINT_8 dead 
		then
			0162: $BLIP_V8 = create_marker_above_actor $VARMINT_8 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_8 weapon WEAPONTYPE_CHAINGUN ammo 45 
			0239: actor $VARMINT_8 run_to 129.6875 199.75 
			011A: set_actor $VARMINT_8 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_8 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_8 attack_when_provoked 1
		end
	end

	:PLOOK8

	if and
		8118:   not actor $VARMINT_9 dead 
		8119:   not car $PERENIAL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_9 leave_car $PERENIAL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_9 car $PERENIAL1_RM2 
			wait 0 ms
			if
				0119:   car $PERENIAL1_RM2 wrecked
			then
				goto @PLOOK10
			end
			if
				0118:   actor $VARMINT_9 dead 
			then
				goto @PLOOK9
			end
		end //while
		if
			8118:   not actor $VARMINT_9 dead 
		then
			0162: $BLIP_V9 = create_marker_above_actor $VARMINT_9 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_9 weapon WEAPONTYPE_PISTOL ammo 30
			0239: actor $VARMINT_9 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_9 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_9 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_9 attack_when_provoked 1
		end
	end

	:PLOOK9

	if and
		8118:   not actor $VARMINT_10 dead 
		8119:   not car $PERENIAL1_RM2 wrecked 
	then
		01D3: actor $VARMINT_10 leave_car $PERENIAL1_RM2 
		while 00DB:   is_char_in_car $VARMINT_10 car $PERENIAL1_RM2 
			wait 0 ms
			if
				0119:   car $PERENIAL1_RM2 wrecked
			then
				goto @PLOOK10
			end
			if
				0118:   actor $VARMINT_10 dead 
			then
				goto @PLOOK10
			end
		end //while
		if
			8118:   not actor $VARMINT_10 dead 
		then
			0162: $BLIP_V10 = create_marker_above_actor $VARMINT_10 color 1 visibility BLIP_ONLY 
			01B2: give_actor $VARMINT_10 weapon WEAPONTYPE_SHOTGUN ammo 20
			035F: set_actor $VARMINT_10 armour_to 100 
			0239: actor $VARMINT_10 run_to $WH_X_RM2 $WH_Y_RM2 
			011A: set_actor $VARMINT_10 search_threat THREAT_PLAYER1 
			011A: set_actor $VARMINT_10 search_threat THREAT_SPECIAL 
			0291: set_actor $VARMINT_10 attack_when_provoked 1
		end
	end

	:PLOOK10

	0164: disable_marker $BLIP_PERENIAL1 
	0004: $PERENIAL_BAILOUT = 1 
end
return

//-------------------VARMINT DEATHS-----------------------------------------

:VARMINT_DEATHS
if
	0038:   $FLAG_SENTINEL_CREATED == 1 
then
	if and
		0038:   $FLAG_V1_DEAD == 0 
		0118:   actor $VARMINT_1 dead
	then
		0004: $FLAG_V1_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V1 
	end
	if and
		0038:   $FLAG_V2_DEAD == 0 
		0118:   actor $VARMINT_2 dead
	then
		0004: $FLAG_V2_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V2 
	end
	if and
		0038:   $FLAG_V3_DEAD == 0 
		0118:   actor $VARMINT_3 dead
	then
		0004: $FLAG_V3_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V3 
	end
	if and
		0038:   $FLAG_V4_DEAD == 0 
		0118:   actor $VARMINT_4 dead
	then
		0004: $FLAG_V4_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V4 
	end
end

if
	0038:   $FLAG_STALLION_CREATED == 1 
then
	if and
		0038:   $FLAG_V5_DEAD == 0 
		0118:   actor $VARMINT_5 dead
	then
		0004: $FLAG_V5_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V5 
	end
	if and
		0038:   $FLAG_V6_DEAD == 0 
		0118:   actor $VARMINT_6 dead
	then
		0004: $FLAG_V6_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V6 
	end
end

if
	0038:   $FLAG_PERENIAL_CREATED == 1 
then
	if and
		0038:   $FLAG_V7_DEAD == 0 
		0118:   actor $VARMINT_7 dead
	then
		0004: $FLAG_V7_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V7 
	end
	if and
		0038:   $FLAG_V8_DEAD == 0 
		0118:   actor $VARMINT_8 dead
	then
		0004: $FLAG_V8_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V8 
	end
	if and
		0038:   $FLAG_V9_DEAD == 0 
		0118:   actor $VARMINT_9 dead
	then
		0004: $FLAG_V9_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V9 
	end
	if and
		0038:   $FLAG_V10_DEAD == 0 
		0118:   actor $VARMINT_10 dead
	then
		0004: $FLAG_V10_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V10 
	end
end

if
	0038:   $FLAG_SNEAKY_1 == 1 
then
	if and
		0038:   $FLAG_V11_DEAD == 0 
		0118:   actor $VARMINT_11 dead
	then
		0004: $FLAG_V11_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V11 
	end
end
if
	0038:   $FLAG_SNEAKY_2 == 1 
then
	if and
		0038:   $FLAG_V12_DEAD == 0 
		0118:   actor $VARMINT_12 dead
	then
		0004: $FLAG_V12_DEAD = 1 
		0008: $COUNTER_DEAD_VARMINTS += 1 
		0164: disable_marker $BLIP_V12 
	end
end
return

//---------------PICKUPS------------------------

:PICKUPS
if
	0038:   $FLAG_M16_GONE == 0 
then
	if
		0214:   pickup $PHILS_M16 picked_up 
	then
		01B8: set_player $PLAYER_CHAR armed_weapon_to 6 
		0004: $FLAG_M16_GONE = 1 
	end
end
if
	0038:   $FLAG_UZI_GONE == 0 
then
	if
		0214:   pickup $PHILS_UZI picked_up 
	then
		01B8: set_player $PLAYER_CHAR armed_weapon_to 3 
		0004: $FLAG_UZI_GONE = 1 
	end
end
if
	0038:   $FLAG_ROCKET_GONE == 0 
then
	if
		0214:   pickup $PHILS_ROCKET picked_up 
	then
		01B8: set_player $PLAYER_CHAR armed_weapon_to 8 
		0004: $FLAG_ROCKET_GONE = 1 
	end
end
if
	0038:   $FLAG_SHOTGUN_GONE == 0 
then
	if
		0214:   pickup $PHILS_SHOTGUN picked_up 
	then
		01B8: set_player $PLAYER_CHAR armed_weapon_to 4 
		0004: $FLAG_SHOTGUN_GONE = 1 
	end
end
if
	0038:   $FLAG_MOLOTOV_GONE == 0 
then
	if
		0214:   pickup $PHILS_MOLOTOV picked_up 
	then
		01B8: set_player $PLAYER_CHAR armed_weapon_to 10 
		0004: $FLAG_MOLOTOV_GONE = 1 
	end
end
return
