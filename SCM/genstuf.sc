:GENSTUFF
0004: $SECOND_FLOOR_CARS_EXIST = 0 
0004: $THIRD_FLOOR_CARS_EXIST = 0
0004: $FOURTH_FLOOR_CARS_EXIST = 0 
0004: $FIFTH_FLOOR_CARS_EXIST = 0
 
0004: $NEED_TO_CLEAR_AREA_FLAG = 0 // VARIABLE FOR PARKED CARS GENERATOR FOR THE MULTISTORY CARPARK IN NEWPORT
0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0 
0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0 
0004: $FLAG_SOUNDS_ADDED_REDLIGHT = 0
0004: $TRAMPS_BEEN_CREATED = 0
0004: $TRAMP_IS_DEAD = 0
0004: $CAMERA_AMMU1 = 0
0004: $CAMERA_AMMU2 = 0
0004: $FLAG_SOUNDS_ADDED_DOG = 0 // Sound effects for the dog food factory
0004: $FLAG_FAILED_LOVE1 = 0
0004: $FLAG_NEED_WALL_CHANGE_KM1 = 0
0004: $ON_ARMS_SHORTAGE_MISSION = 0
0004: $TRAMP1 = -1
0004: $TRAMP2 = -1
0004: $TRAMP3 = -1 
0004: $TRAMP4 = -1
0004: $AMMU_SAMPLE = 0 
0004: $SPECIAL_AMMU_AUDIO = 0
0004: $AMMU_BLOKE_KILL_PLAYER = 0
03A4: thread 'GENSTUF' 
0111: set_wasted_busted_check_to 0
create_thread @IND_AMMU 
create_thread @FISH_FACTORY_GEN 
create_thread @TRAMP_TUNNEL 
create_thread @IND_SOUND 
create_thread @COM_AMMU 
create_thread @COM_CAR_PARK 
create_thread @DOG_SOUND 
create_thread @COBBLERS 
create_thread @DEATH_PENALTY
end_thread

:COBBLERS
while true
	wait 1000 ms
	if 
		0038: $FLAG_STAUNTON_OPEN == 1
	then
		0215: destroy_pickup $INFO_PICKUP7A 
		0215: destroy_pickup $INFO_PICKUP8 
		0215: destroy_pickup $INFO_PICKUP9 
		0215: destroy_pickup $INFO_PICKUP3 
		0215: destroy_pickup $INFO_PICKUP4 
		0215: destroy_pickup $INFO_PICKUP5 
		0215: destroy_pickup $INFO_PICKUP1 
		end_thread
	end
end


:IND_AMMU
03A4: name_thread 'I_AMMU'
while true
	wait 70 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'LITTLEI'  // Saint Mark's
		then
			if
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 1066.563 -403.5 14.0 to 1072.75 -394.0 18.0 sphere 0 
			then
				if
					0038: $CAMERA_AMMU1 == 0
				then
					01B4: set_player $PLAYER_CHAR controllable 0
					0169: set_fade_color 1 1 1 
					03AF: set_streaming 0 (disabled)
					023C: load_special_actor 'SAM' as 4 
					043C: set_game_sounds_fade 0
					016A: fade 0 for 500 ms
					while 823D:   not special_actor 4 loaded
						wait 0 ms
					end
					while fading
						wait 0 ms
					end
					03AF: set_streaming 1
					01BD: $CURRENT_TIME = current_time_in_ms 
					0084: $TIME_DIFFERENCE = $CURRENT_TIME 
					0060: $TIME_DIFFERENCE -= $TIME_SINCE_MURDERING_SHOPKEEPER1
					if 
						$TIME_DIFFERENCE > 60000
					then
						009A: $AMMU_SHOP_BLOKE1 = create_char PEDTYPE_SPECIAL model #SPECIAL04 at 1070.75 -396.9375 14.1875
						0243: set_actor $AMMU_SHOP_BLOKE1 ped_stats_to PEDSTAT_TOUGH_GUY 
						0173: set_actor $AMMU_SHOP_BLOKE1 z_angle_to 170.0 
						0350: set_actor $AMMU_SHOP_BLOKE1 maintain_position_when_attacked 1 
						01B2: give_actor $AMMU_SHOP_BLOKE1 weapon WEAPONTYPE_SHOTGUN ammo 999
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							022D: set_actor $AMMU_SHOP_BLOKE1 to_look_at_player $PLAYER_CHAR
						end
					end
					0296: unload_special_actor 4 
					015F: set_camera_position 1071.938 -402.75 17.0 0.0 rotation 0.0 0.0 
					0452: enable_player_control_camera
					if
						0256:   is_player $PLAYER_CHAR defined 
					then
						0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle JUMP_CUT
						0395: clear_area 1 at 1067.875 -397.25 range 14.1875 1.0 
						0055: set_player_coordinates $PLAYER_CHAR to 1067.875 -397.25 14.1875 
						0171: set_player $PLAYER_CHAR z_angle_to 200.0 
					end
					016A: fade 1 for 500 ms
					while fading
						wait 0 ms
					end
					if
						0256:   is_player $PLAYER_CHAR defined 
					then
						01B4: set_player $PLAYER_CHAR controllable 1 
					end
					if and
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $SPECIAL_AMMU_AUDIO == 0
					then
						if
							0038:   $AMMU_SAMPLE == 0
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_1
						end
						if
							0038:   $AMMU_SAMPLE == 1
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_2
						end
						if
							0038:   $AMMU_SAMPLE == 2
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_3
						end
					end
					0004: $CAMERA_AMMU1 = 1
				else // camera_ammu1 = 1
					if and
						02DF:   player $PLAYER_CHAR agressive
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $AMMU_BLOKE_KILL_PLAYER == 0
					then
						if
							0256:   is_player $PLAYER_CHAR defined
						then
							01CA: actor $AMMU_SHOP_BLOKE1 kill_player $PLAYER_CHAR
						end
						0004: $AMMU_BLOKE_KILL_PLAYER = 1
					end
				end
			else // player not in area
				if
					0038: $CAMERA_AMMU1 == 1
				then
					01B4: set_player $PLAYER_CHAR controllable 0 
					016A: fade 0 for 500 ms
					while fading
						wait 0 ms
					end
					if and
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						0018:   $TIME_DIFFERENCE > 60000
					then
						01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
					end
					009B: delete_char $AMMU_SHOP_BLOKE1 
					0395: clear_area 1 at 1063.25 -395.25 range 14.1875 1.0 
					if
						0256:   is_player $PLAYER_CHAR defined 
					then
						0055: set_player_coordinates $PLAYER_CHAR to 1063.25 -395.25 14.1875
						0171: set_player $PLAYER_CHAR z_angle_to 90.0 
						02EB: restore_camera_jumpcut 
						03C8: set_camera_directly_before_player
					end
					016A: fade 1 for 500 ms
					while fading
						wait 0 ms
					end
					043C: set_game_sounds_fade 1 
					if
						0256:   is_player $PLAYER_CHAR defined 
					then
						01B4: set_player $PLAYER_CHAR controllable 1 
					end
					0008: $AMMU_SAMPLE += 1
					if
						0018: $AMMU_SAMPLE > 2
					then
						0018: $AMMU_SAMPLE = 0
					end
					0004: $AMMU_BLOKE_KILL_PLAYER = 0
					0004: $CAMERA_AMMU1 = 0
				end
			end // IS_PLAYER_IN_AREA_3D
		else // not in LITTLEI
			if
				0038: $CAMERA_AMMU1 == 1
			then
				if and
					0118:   actor $AMMU_SHOP_BLOKE1 dead 
					0018:   $TIME_DIFFERENCE > 60000
				then
					01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
				end
				02EB: restore_camera_jumpcut 
				03C8: set_camera_directly_before_player 
				009B: delete_char $AMMU_SHOP_BLOKE1
				043C: set_game_sounds_fade 1 
				0004: $CAMERA_AMMU1 = 0
			end
		end // IF IS_PLAYER_IN_ZONE player LITTLEI
	end // IS_PLAYER_PLAYING
end //while


:FISH_FACTORY_GEN
03A4: name_thread 'FISHGEN'
while true
	wait 1000 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		//FISH FACTORY SET UP
		if
			0038:   $FISH_FACTORY_DESTROYED == 0
		then
			if
				0121:   player $PLAYER_CHAR in_zone 'PORT_W'  // Callahan Point
			then
				//CREATES A GANG OF TRIADS DOWN AT THE FISH FACTORY
				if
					0038: $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 0
				then
					0247: request_model #GANG03 
					0247: request_model #GANG04
					while true
						if or
							8248:   not model #GANG03 available 
							8248:   not model #GANG04 available 
						jf break
						wait 0 ms
					end
					009A: $FISH_TRIAD1 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 997.0 -1112.0 -100.0
					01B2: give_actor $FISH_TRIAD1 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD1 search_threat THREAT_PLAYER1 

					009A: $FISH_TRIAD2 = create_char PEDTYPE_GANG_TRIAD model #GANG04 at 964.0 -1095.0 -100.0
					01B2: give_actor $FISH_TRIAD2 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD2 search_threat THREAT_PLAYER1 

					009A: $FISH_TRIAD3 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 982.0 -1085.0 -100.0
					01B2: give_actor $FISH_TRIAD3 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD3 search_threat THREAT_PLAYER1 

					009A: $FISH_TRIAD4  create_char PEDTYPE_GANG_TRIAD model #GANG04 at 953.0 -1122.0 -100.0
					01B2: give_actor $FISH_TRIAD4 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD4 search_threat THREAT_PLAYER1 

					009A: $FISH_TRIAD5 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 1008.0 -1126.0 -100.0
					01B2: give_actor $FISH_TRIAD5 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD5 search_threat THREAT_PLAYER1 

					009A: $FISH_TRIAD6 = create_char PEDTYPE_GANG_TRIAD model #GANG03 at 974.0 -1142.0 -100.0
					01B2: give_actor $FISH_TRIAD6 weapon WEAPONTYPE_PISTOL ammo 100 
					011A: set_actor $FISH_TRIAD6 search_threat THREAT_PLAYER1 

					009C: char_wander_dir $FISH_TRIAD1 to 0 
					009C: char_wander_dir $FISH_TRIAD2 to 0 
					009C: char_wander_dir $FISH_TRIAD3 to 0 
					009C: char_wander_dir $FISH_TRIAD4 to 0 
					009C: char_wander_dir $FISH_TRIAD5 to 0 
					009C: char_wander_dir $FISH_TRIAD6 to 0 
					0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 1
				end
			else	//	Player not in PORT_W
				if
					0038:   $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 1
				then
					01C2: remove_references_to_actor $FISH_TRIAD1 
					01C2: remove_references_to_actor $FISH_TRIAD2 
					01C2: remove_references_to_actor $FISH_TRIAD3 
					01C2: remove_references_to_actor $FISH_TRIAD4 
					01C2: remove_references_to_actor $FISH_TRIAD5 
					01C2: remove_references_to_actor $FISH_TRIAD6 
					if 
						0038: $ONMISSION == 0
					then
						0249: release_model #GANG03 
						0249: release_model #GANG04
						0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0
					end
				end
			end // IS PLAYER IN ZONE
		else // fish_factory_destroyed
			if
				0038:   $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 1
			then
				01C2: remove_references_to_actor $FISH_TRIAD1 
				01C2: remove_references_to_actor $FISH_TRIAD2 
				01C2: remove_references_to_actor $FISH_TRIAD3 
				01C2: remove_references_to_actor $FISH_TRIAD4 
				01C2: remove_references_to_actor $FISH_TRIAD5 
				01C2: remove_references_to_actor $FISH_TRIAD6 
				if 
					0038: $ONMISSION == 0
				then
					0249: release_model #GANG03 
					0249: release_model #GANG04
					0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0
					end_thread // At this point the thread doesn't do anything anymore anyway, so why keep it running?
				end
			end
		end //fish_factory_destroyed
	end //IS_PLAYER_PLAYING
end //while

:TRAMP_TUNNEL
03A4: name_thread 'TRAMPS'
while true
	wait 1000 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'LITTLEI'  // Saint Mark's
		then
			if
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 1325.0 -512.0 14.0 to 1315.0 -165.75 17.0 sphere 0 
			then
				if
					0038: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE == 0
				then
					0247: request_model #SCUM_MAN 
					0247: request_model #SCUM_WOM
					while true
						if or
							8248:   not model #SCUM_MAN available 
							8248:   not model #SCUM_WOM available 
						jf break
						wait 0 ms
					end
					009A: $TRAMP1 = create_char PEDTYPE_BUM model #SCUM_MAN at 1320.375 -370.0 15.0
					01B2: give_actor $TRAMP1 weapon WEAPONTYPE_MOLOTOV ammo 1 
					0243: set_actor $TRAMP1 ped_stats_to PEDSTAT_GEEK_GUY 
					011A: set_actor $TRAMP1 search_threat THREAT_GUN 
					011A: set_actor $TRAMP1 search_threat THREAT_DEADPEDS 

					009A: $TRAMP2 = create_char PEDTYPE_BUM model #SCUM_WOM at 1317.0 -365.0 15.0
					01B2: give_actor $TRAMP2 weapon WEAPONTYPE_MOLOTOV ammo 1 
					0173: set_actor $TRAMP2 z_angle_to 290.0 
					0243: set_actor $TRAMP2 ped_stats_to PEDSTAT_GEEK_GUY 
					011A: set_actor $TRAMP2 search_threat THREAT_GUN 
					011A: set_actor $TRAMP2 search_threat THREAT_DEADPEDS 

					009A: $TRAMP3 = create_char PEDTYPE_BUM model #SCUM_WOM at 1322.375 -367.0 15.0
					01B2: give_actor $TRAMP3 weapon WEAPONTYPE_MOLOTOV ammo 1 
					0173: set_actor $TRAMP3 z_angle_to 57.0 
					0243: set_actor $TRAMP3 ped_stats_to PEDSTAT_GEEK_GUY 
					011A: set_actor $TRAMP3 search_threat THREAT_GUN 
					011A: set_actor $TRAMP3 search_threat THREAT_DEADPEDS 

					009A: $TRAMP4 = create_char PEDTYPE_BUM model #SCUM_MAN at 1320.0 -362.0 15.0
					01B2: give_actor $TRAMP4 weapon WEAPONTYPE_MOLOTOV ammo 1 
					0173: set_actor $TRAMP4 z_angle_to 180.0 
					0243: set_actor $TRAMP4 ped_stats_to PEDSTAT_GEEK_GUY 
					011A: set_actor $TRAMP4 search_threat THREAT_GUN 
					011A: set_actor $TRAMP4 search_threat THREAT_DEADPEDS 

					0249: release_model #SCUM_MAN 
					0249: release_model #SCUM_WOM 
					0004: $TRAMPS_BEEN_CREATED = 1
					0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 1
				else
					if and
						0038:   $TRAMPS_BEEN_CREATED == 1
						0038:   $TRAMP_IS_DEAD == 0
					then
						if or
							0118:   actor $TRAMP1 dead
							0118:   actor $TRAMP2 dead
							0118:   actor $TRAMP3 dead
							0118:   actor $TRAMP4 dead
						then
							0006: 16@ = 0
							0004: $TRAMP_IS_DEAD = 1
						end
					end
				end
			end
		else // IF IS_PLAYER_IS_ZONE Player LITTLEI
			if
				0038:   $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE == 1
			then
				if
					0038:   $TRAMPS_BEEN_CREATED == 1
				then
					01C2: remove_references_to_actor $TRAMP1
					01C2: remove_references_to_actor $TRAMP2
					01C2: remove_references_to_actor $TRAMP3
					01C2: remove_references_to_actor $TRAMP4
					0004: $TRAMPS_BEEN_CREATED = 0
				end
				if
					0038:   $TRAMP_IS_DEAD == 1
				then
					if
						0019: 16@ > 1440000 // 24 minutes
					then
						0004: $TRAMP_IS_DEAD = 0
						0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0
					end
				else
					0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0
				end
			end
		end // IF IS_PLAYER_IS_ZONE Player LITTLEI
	end // player defined
end //while

:IND_SOUND
03A4: name_thread 'I_SOUND'
while true
	wait 1000 ms
	if
		0256:   is_player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'REDLIGH'  // Red Light District
		then
			00BF: get_time_of_day $CURRENT_TIME_HOURS $CURRENT_TIME_MINUTES
			if or
				0028:   $CURRENT_TIME_HOURS >= 20  
				002A:   5 >= $CURRENT_TIME_HOURS
			then
				if
					0038:   $FLAG_SOUNDS_ADDED_REDLIGHT == 0 
				then
					018D: $SOUND_LOOP8 = create_sound SOUND_STRIP_CLUB_LOOP_2_S at 891.875 -416.875 16.0625 // Luigi's Club
					018D: $SOUND_LOOP9 = create_sound SOUND_STRIP_CLUB_LOOP_1_S at 924.1875 -464.25 16.0 // Sex Kitten Club
					018D: $SOUND_LOOP10 = create_sound SOUND_PORN_CINEMA_1_S at 901.0625 -392.0 15.0 // XXX Cinema1
					018D: $SOUND_LOOP11 = create_sound SOUND_PORN_CINEMA_2_S at 901.1875 -339.0 10.0 // XXX Cinema2
					018D: $SOUND_LOOP12 = create_sound SOUND_PORN_CINEMA_3_S at 960.0625 -379.0 15.0 // XXX Cinema
					0004: $FLAG_SOUNDS_ADDED_REDLIGHT = 1
				end
			else
				if
					0038:   $FLAG_SOUNDS_ADDED_REDLIGHT == 1
				then
					018E: stop_sound $SOUND_LOOP8 
					018E: stop_sound $SOUND_LOOP9 
					018E: stop_sound $SOUND_LOOP10 
					018E: stop_sound $SOUND_LOOP11 
					018E: stop_sound $SOUND_LOOP12
					0004: $FLAG_SOUNDS_ADDED_REDLIGHT = 0
				end
			end
		end
	end
end //while

:DOG_SOUND
03A4: name_thread 'D_SOUND'
while true
	wait 1000 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'PORT_I'  // Trenton
		then
			00BF: get_time_of_day $CURRENT_TIME_HOURS $CURRENT_TIME_MINUTES
			if or
				0028:   $CURRENT_TIME_HOURS >= 9  
				002A:   17 >= $CURRENT_TIME_HOURS
			then
				if
					0038:   $FLAG_SOUNDS_ADDED_DOG == 0 
				then
					018D: $SOUND_LOOP7 = create_sound SOUND_SAWMILL_LOOP_L at 1210.875 -802.1875 15.0 
					0004: $FLAG_SOUNDS_ADDED_DOG = 1
				end
			else
				if
					0038:   $FLAG_SOUNDS_ADDED_DOG == 1
				then
					018E: stop_sound $SOUND_LOOP7
					0004: $FLAG_SOUNDS_ADDED_DOG = 0
				end
			end
		end
	end
end //while

:COM_AMMU
03A4: name_thread 'C_AMMU'
while true
	wait 70 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		then
			if
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 353.25 -711.6875 24.0 to 339.75 -722.375 28.0 sphere 0
			then
				if
					0038: $CAMERA_AMMU2 == 0
				then
					01B4: set_player $PLAYER_CHAR controllable 0
					0169: set_fade_color 1 1 1 
					03AF: set_streaming 0
					023C: load_special_actor 'SAM' as 4 
					043C: set_game_sounds_fade 0
					016A: fade 0 for 500 ms
					while 823D:   not special_actor 4 loaded
						wait 0 ms
					end
					while fading
						wait 0 ms
					end
					03AF: set_streaming 1
					01BD: $CURRENT_TIME = current_time_in_ms 
					0084: $TIME_DIFFERENCE = $CURRENT_TIME 
					0060: $TIME_DIFFERENCE -= $TIME_SINCE_MURDERING_SHOPKEEPER1
					if 
						$TIME_DIFFERENCE > 60000
					then
						009A: $AMMU_SHOP_BLOKE1 = create_char PEDTYPE_SPECIAL model #SPECIAL04 at 350.1875 -719.875 25.375
						0243: set_actor $AMMU_SHOP_BLOKE1 ped_stats_to PEDSTAT_TOUGH_GUY 
						0173: set_actor $AMMU_SHOP_BLOKE1 z_angle_to 170.0 
						0350: set_actor $AMMU_SHOP_BLOKE1 maintain_position_when_attacked 1 
						01B2: give_actor $AMMU_SHOP_BLOKE1 weapon WEAPONTYPE_SHOTGUN ammo 999
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							022D: set_actor $AMMU_SHOP_BLOKE1 to_look_at_player $PLAYER_CHAR
						end
					end
					0296: unload_special_actor 4 
					015F: set_camera_position 341.6875 -720.625 28.0 0.0 rotation 0.0 0.0 
					0452: enable_player_control_camera
					if
						0256:   is_player $PLAYER_CHAR defined
					then
						0157: camera_on_player $PLAYER_CHAR mode FIXED switchstyle JUMP_CUT
						0395: clear_area 1 at 350.6875 -713.0625 range 26.375 1.0 
						0055: set_player_coordinates $PLAYER_CHAR to 350.6875 -713.0625 25.375
						0171: set_player $PLAYER_CHAR z_angle_to 108.0 
					end
					016A: fade 1  500 ms
					while fading
						wait 0 ms
					end
					if
						0256:   is_player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR controllable 1 
					end
					if and
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $SPECIAL_AMMU_AUDIO == 0
					then
						if
							0038:   $AMMU_SAMPLE == 0
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_1
						end
						if
							0038:   $AMMU_SAMPLE == 1
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_2
						end
						if
							0038:   $AMMU_SAMPLE == 2
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say SOUND_AMMUNATION_CHAT_3
						end
					end
					0004: $CAMERA_AMMU2 = 1
				else // camera_ammu1 = 1
					if and
						02DF:   player $PLAYER_CHAR agressive
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $AMMU_BLOKE_KILL_PLAYER == 0
					then
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01CA: actor $AMMU_SHOP_BLOKE1 kill_player $PLAYER_CHAR
						end
						0004: $AMMU_BLOKE_KILL_PLAYER = 1
					end
				end
			else // player not in area
				if
					0038:   $CAMERA_AMMU2 == 1
				then
					01B4: set_player $PLAYER_CHAR controllable 0 
					016A: fade 0 for 500 ms
					while fading
						wait 0 ms
					end
					if and
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						0018:   $TIME_DIFFERENCE > 60000
					then
						01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
					end
					009B: delete_char $AMMU_SHOP_BLOKE1
					0395: clear_area 1 at 352.0 -708.75 range 25.375 1.0 
					if
						0256:   is_player $PLAYER_CHAR defined
					then
						0055: set_player_coordinates $PLAYER_CHAR to 352.0 -708.75 25.375 
						0171: set_player $PLAYER_CHAR z_angle_to 0.0 
						02EB: restore_camera_jumpcut 
						03C8: set_camera_directly_before_player
					end
					016A: fade 1 for 500 ms
					while fading
						wait 0 ms
					end
					043C: set_game_sounds_fade 1
					if
						0256:   is_player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR controllable 1 
					end
					0008: $AMMU_SAMPLE += 1
					if
						0018: $AMMU_SAMPLE > 2
					then
						0018: $AMMU_SAMPLE = 0
					end
					0004: $AMMU_BLOKE_KILL_PLAYER = 0
					0004: $CAMERA_AMMU2 = 0
				end
			end // IS_PLAYER_IN_AREA_3D
		else // not in LITTLEI
			if
				0038:   $CAMERA_AMMU2 == 1
			then
				if and
					0118:   actor $AMMU_SHOP_BLOKE1 dead 
					0018:   $TIME_DIFFERENCE > 60000
				then
					01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
				end
				02EB: restore_camera_jumpcut 
				03C8: set_camera_directly_before_player
				009B: delete_char $AMMU_SHOP_BLOKE1 
				043C: set_game_sounds_fade 1 
				0004: $CAMERA_AMMU2 = 0
			end
		end // IF IS_PLAYER_IN_ZONE player LITTLEI
	end // IS_PLAYER_PLAYING
end //while

:COM_CAR_PARK
03A4: name_thread 'C_CARP'
while true
	wait 250 ms
	if
		0256:   is_player $PLAYER_CHAR defined
	then
		if and
			03C6:   current_island == LEVEL_COMMERCIAL
			0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		then
			if
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 266.8125 -610.875 25.0 to 306.25 -479.875 30.0 sphere 0 // 1ST FLOOR LOCATE
			then
				01EB: set_car_density_to 0.0 
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 30.375 to 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
					0004: $THIRD_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 32.8125 to 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
					0004: $FOURTH_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 1
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 306.25 -610.875 28.0 to 346.75 -479.875 32.375 sphere 0  // 2ND FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 32.8125 to 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
					0004: $FOURTH_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 2
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 1
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 266.8125 -610.875 30.375 to 306.25 -479.875 34.8125 sphere 0 // 3RD FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 3
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 2
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 306.25 -610.875 32.8125 to 346.75 -479.875 40.0 sphere 0 // 4TH FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 28.0 to 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
					0004: $SECOND_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FIFTH_FLOOR_OF_CARS
					0004: $FIFTH_FLOOR_CARS_EXIST = 1
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 4
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 3
				0057:   is_player_in_area_3d $PLAYER_CHAR coords 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0 sphere 0 // 5TH FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 28.0 to 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
					0004: $SECOND_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 30.375 to 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
					0004: $THIRD_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FIFTH_FLOOR_OF_CARS
					0004: $FIFTH_FLOOR_CARS_EXIST = 1
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 5
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
				8057:   not is_player_in_area_3d $PLAYER_CHAR coords 266.8125 -610.875 25.0 to 346.75 -479.875 40.0 sphere 0 // ENTIRE CARPARK LOCATE
			then
				01EB: set_car_density_to 1.0
				03BA: clear_cars_from_cube 306.25 -610.875 28.0 to 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
				03BA: clear_cars_from_cube 266.8125 -610.875 30.375 to 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
				03BA: clear_cars_from_cube 306.25 -610.875 32.8125 to 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
				03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
				0004: $SECOND_FLOOR_CARS_EXIST = 0
				0004: $THIRD_FLOOR_CARS_EXIST = 0
				0004: $FOURTH_FLOOR_CARS_EXIST = 0
				0004: $FIFTH_FLOOR_CARS_EXIST = 0
				0004: $NEED_TO_CLEAR_AREA_FLAG = 0
			end
		end // IF CURRENT_LEVEL == 2 and IS_PLAYER_IN_ZONE player COM_EAS
		if and
			0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
			8057:   not is_player_in_area_3d $PLAYER_CHAR coords 266.8125 -610.875 25.0 to 346.75 -479.875 40.0 sphere 0 // ENTIRE CARPARK LOCATE
		then
			01EB: set_car_density_to 1.0
			03BA: clear_cars_from_cube 306.25 -610.875 28.0 to 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
			03BA: clear_cars_from_cube 266.8125 -610.875 30.375 to 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
			03BA: clear_cars_from_cube 306.25 -610.875 32.8125 to 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
			03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 to 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
			0004: $SECOND_FLOOR_CARS_EXIST = 0
			0004: $THIRD_FLOOR_CARS_EXIST = 0
			0004: $FOURTH_FLOOR_CARS_EXIST = 0
			0004: $FIFTH_FLOOR_CARS_EXIST = 0
			0004: $NEED_TO_CLEAR_AREA_FLAG = 0
		end
	end //player defined
end //while

:SECOND_FLOOR_OF_CARS // 2ND FLOOR CARS
03C5: create_random_car_for_carpark 311.5 -510.25 28.0625 91.0 
03C5: create_random_car_for_carpark 323.5 -526.5 28.0625 270.3125 
03C5: create_random_car_for_carpark 342.625 -542.3125 28.0625 268.375 
03C5: create_random_car_for_carpark 311.4375 -554.375 28.0625 91.0625 
03C5: create_random_car_for_carpark 310.4375 -574.625 28.0625 269.4375 
03C5: create_random_car_for_carpark 342.6875 -590.4375 28.0625 268.4375 
return 

:THIRD_FLOOR_OF_CARS // 3RD FLOOR CARS
03C5: create_random_car_for_carpark 302.25 -580.5 30.5 270.3125 
03C5: create_random_car_for_carpark 289.5 -564.5625 30.5 88.0 
03C5: create_random_car_for_carpark 283.875 -548.375 30.5 92.5 
03C5: create_random_car_for_carpark 270.625 -528.4375 30.5 88.5625 
03C5: create_random_car_for_carpark 301.5 -484.75 30.375 271.625 
return 

:FOURTH_FLOOR_OF_CARS // 4TH FLOOR CARS
03C5: create_random_car_for_carpark 311.0625 -512.625 32.8125 91.125 
03C5: create_random_car_for_carpark 342.625 -536.25 32.8125 266.625 
03C5: create_random_car_for_carpark 311.4375 -564.125 32.8125 267.5 
03C5: create_random_car_for_carpark 330.5 -584.3125 32.8125 267.75 
03C5: create_random_car_for_carpark 342.875 -600.625 32.8125 87.25 
return 

:FIFTH_FLOOR_OF_CARS // 5TH FLOOR CARS
03C5: create_random_car_for_carpark 282.3125 -582.5 35.1875 267.0 
03C5: create_random_car_for_carpark 302.6875 -574.5 35.1875 271.0625 
03C5: create_random_car_for_carpark 270.9375 -530.4375 35.1875 88.3125 
03C5: create_random_car_for_carpark 303.1875 -510.5625 35.1875 88.625 
03C5: create_random_car_for_carpark 283.1875 -502.75 35.1875 89.4375 
03C5: create_random_car_for_carpark 302.375 -485.5 35.1875 266.0 
return

////////////////////////////////////////

:LAUGHS
03A4: name_thread 'LAUGHS' 
while 0038:   $SHOULD_LAUGH == 1
	0209: 0@ = random_int_in_ranges 0 13 // 13 options
//	if
//		0039:   0@ == 0
//	then
		03CF: load_wav 'S1_F' 
//	end

/*
	if
		0039:   0@ == 1
	then
		03CF: load_wav 'LAUGH2'
	end
	if
		0039:   0@ == 2
	then
		03CF: load_wav 'LAUGH3'
	end
	if
		0039:   0@ == 3
	then
		03CF: load_wav 'LAUGH4'
	end
	if
		0039:   0@ == 4
	then
		03CF: load_wav 'LAUGH5'
	end
	if
		0039:   0@ == 5
	then
		03CF: load_wav 'LAUGH6'
	end
	if
		0039:   0@ == 6
	then
		03CF: load_wav 'LAUGH7'
	end
	if
		0039:   0@ == 7
	then
		03CF: load_wav 'LAUGH8'
	end
	if
		0039:   0@ == 8
	then
		03CF: load_wav 'LAUGH9'
	end
	if
		0039:   0@ == 9
	then
		03CF: load_wav 'LAUGHA'
	end
	if
		0039:   0@ == 10
	then
		03CF: load_wav 'LAUGHB'
	end
	if
		0039:   0@ == 11
	then
		03CF: load_wav 'LAUGHC'
	end
	if
		0039:   0@ == 12
	then
		03CF: load_wav 'LAUGHD'
	end
*/
	while 83D0:   not wav_loaded
		wait 0 ms
	end
	03D1: play_wav
	while 83D2:   now wav_ended
		wait 0 ms
	end
	wait 100 ms
	goto @LAUGHS // keep looping
end //while
end_thread

////////////////////////////////////////

// Forcefully check the player health against a 'max health' var. If it's higher, reduce it. 
// if the player health is not more than 0 (i.e. the player is dead) the var will be decreased by 1. 
// A flag needs to be set to prevent the var from being decreased multiple times. If the var is 10 or less, 
// the thread ends to stop the player from being instakilled by this thread when the var hits 0.
:DEATH_PENALTY
03A4: name_thread 'DEATH'
0004: $MAX_HEALTH = 100
0004: $DEATH_ONGOING_FLAG = 0
while 0018: $MAX_HEALTH > 10
	wait 0 ms
	if
		0183:   player $PLAYER_CHAR health > $MAX_HEALTH
	then
		0222: set_player $PLAYER_CHAR health_to $MAX_HEALTH
	end
	
	if and
		0038:   $DEATH_ONGOING_FLAG == 0
		8183:   not player $PLAYER_CHAR health > 0
	then
		000C: $MAX_HEALTH -= 1
		0004: $DEATH_ONGOING_FLAG = 1
	end
	if and
		0038:   $DEATH_ONGOING_FLAG == 1
		0183:   player $PLAYER_CHAR health > 0
	then
		0004: $DEATH_ONGOING_FLAG = 0
	end
end //while
end_thread

////////////////////////////////////////

// Used to create a continuous supply of triads from the bus while the rest of the mission keeps going.
// Thread will end on destruction of the bus or when the on_mission flag is false (player failed the mission).
// This thread is in here instead of in 07_joey.sc because for some reason putting it in there crashes the \
// game as soon as it is started.
:CREATE_PEONS_JOEY4
03A4: name_thread 'PEONS'
wait 0 ms

0247: request_model #GANG03 

while 8248:   not model #GANG03 available
	wait 0 ms
end //while

while true
	if and
		8119:   not car $JOEY4_BUS wrecked 
		0038:   $ONMISSION == 1
	jf break
	wait 0 ms

	01C8: $JOEY4_PEON = create_actor PEDTYPE_GANG_TRIAD model #GANG03 in_car $JOEY4_BUS passenger_seat 0
	01B2: give_actor $JOEY4_PEON weapon WEAPONTYPE_PISTOL ammo 100 
	0223: set_actor $JOEY4_PEON health_to 200
	011A: set_actor $JOEY4_PEON search_threat THREAT_PLAYER1 


	01D3: actor $JOEY4_PEON leave_car $JOEY4_BUS 
	while 00DB:   is_char_in_car $JOEY4_PEON car $JOEY4_BUS 
		wait 0 ms
		if
			0118:   actor $JOEY4_PEON dead 
		then
			goto @CREATE_PEONS_JOEY4 // Effectively a continue for the create peons loop
		end
		if
			0119:   car $JOEY4_BUS wrecked 
		then
			end_thread // Effectively a break for the create peons loop
		end			
	end //while


	0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z
	0239: actor $JOEY4_PEON run_to $PLAYER_X $PLAYER_Y
	wait 100 ms
	if
		0118:   actor $JOEY4_PEON dead 
	then
		goto @CREATE_PEONS_JOEY4 // Effectively a continue for the create peons loop
	end
	01CA: actor $JOEY4_PEON kill_player $PLAYER_CHAR 
	01C2: remove_references_to_actor $JOEY4_PEON
end //while
end_thread
