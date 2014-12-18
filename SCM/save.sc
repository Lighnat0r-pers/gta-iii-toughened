:PORTLAND_SAVE
03A4: name_thread 'I_SAVE'

while true
	wait 250 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			03C6:   current_island == LEVEL_INDUSTRIAL
		then
			if
				0038:   $FLAG_PORTLAND_SAVE_ON_RADAR == 0
			then
				0164: disable_marker $PORTLAND_SAVE_MARKER
				02A7: $PORTLAND_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at 870.0 -308.1875 -100.0
				018B: show_on_radar $PORTLAND_SAVE_MARKER BLIP_ONLY
				0004: $FLAG_PORTLAND_SAVE_ON_RADAR = 1
			end
			if
				0121:   player $PLAYER_CHAR in_zone 'REDLIGH'  // Red Light District
			then
				if
					0038:   $LUIGIS_GIRLS_COMPLETED == 1
				then
					if
						0038:   $ONMISSION == 0
					then
						while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 210.0 to 10.0 collision_check 0
							wait 0 ms
						end
					else
						while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 0.0 to 10.0 collision_check 0 
							wait 0 ms
						end
					end
				end
				if and
					0256:   is_player $PLAYER_CHAR defined 
					0038:   $ONMISSION == 0
				then
					if and
						03EE:   player $PLAYER controllable
						019C:   player $PLAYER_CHAR 0 891.1875 -309.6875 7.6875 899.25 -303.25 12.6875
					then
						01B4: set_player $PLAYER_CHAR controllable 0 
						015F: set_camera_position 884.5 -305.3125 13.5 rotation 0.0 0.0 0.0
						0160: point_camera 885.25 -305.8125 13.0 switchstyle JUMP_CUT
						03CF: load_wav 'DOOR_1'
						while 83D0: not wav_loaded
							wait 0 ms
						end
						03D1: play_wav
						while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 0.0 to 8.0 collision_check 0 
							wait 0 ms
						end
						while 83D2: not wav_ended
							wait 0 ms
						end
						03D8: show_save_screen
						wait 0 ms
						while 83D9: not save_done
							wait 0 ms
						end
						0169: set_fade_color 0 0 0
						016A: fade 0 for 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 0 
						end
						wait 1000 ms
						while 834D:   not rotate_object $PORTLAND_HIDEOUT_DOOR from_angle 210.0 to 10.0 collision_check 0 
							wait 0 ms
						end
						0395: clear_area 1 at 888.5625 -308.375 range -100.0 1.0
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							0055: set_player_coordinates $PLAYER_CHAR to 888.5625 -308.375 -100.0 
							0171: set_player $PLAYER_CHAR z_angle_to 90.0
							016A: fade 1 for 1000 ms
							02EB: restore_camera_jumpcut
							03C8: set_camera_directly_before_player
						end
						wait 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 1 
						end
					end
				end
			end
		else // player_in_portland
			if
				0038:   $FLAG_PORTLAND_SAVE_ON_RADAR == 1
			then
				0164: disable_marker $PORTLAND_SAVE_MARKER
				0004: $FLAG_PORTLAND_SAVE_ON_RADAR = 0
			end
		end
	end
end

//#####################################################################################
//#####################################################################################
// END RED LIGHT SAVE / BEGIN STAUNTON SAVE
//#####################################################################################
//#####################################################################################

:STAUNTON_SAVE
03A4: name_thread 'C_SAVE'

while true
	wait 250 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			03C6:   current_island == LEVEL_COMMERCIAL
		then
			if
				0038:   $FLAG_STAUNTON_SAVE_ON_RADAR == 0
			then
				0164: disable_marker $STAUNTON_SAVE_MARKER
				02A7: $STAUNTON_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at 103.25 -469.1875 -100.0
				018B: show_on_radar $STAUNTON_SAVE_MARKER BLIP_ONLY
				0004: $FLAG_STAUNTON_SAVE_ON_RADAR = 1
			end
			if
				0121:   player $PLAYER_CHAR in_zone 'PARK'  // Belleville Park
			then
				if
					0038:   $ONMISSION == 0
				then
					while true
						if or
							834E:   not move_object $STAUNTON_HIDEOUT_DOOR1 to 105.3125 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0 
							834E:   not move_object $STAUNTON_HIDEOUT_DOOR2 to 100.6875 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0
						jf break
						wait 0 ms
					end
				else
					while true
						if or
							834E:   not move_object $STAUNTON_HIDEOUT_DOOR1 to 103.8125 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0 
							834E:   not move_object $STAUNTON_HIDEOUT_DOOR2 to 102.1875 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0
						jf break
						wait 0 ms
					end
				end
				if and
					0256:   is_player $PLAYER_CHAR defined 
					0038:   $ONMISSION == 0
				then
					if and
						03EE:   player $PLAYER controllable
						019C:   player $PLAYER_CHAR 0 105.6875 -486.0 15.0 100.75 -483.375 18.0
					then
						01B4: set_player $PLAYER_CHAR controllable 0 
						015F: set_camera_position 98.5 -472.0 19.8125 rotation 0.0 0.0 0.0
						0160: point_camera 98.9375 -472.875 19.4375 switchstyle JUMP_CUT
						03CF: load_wav 'DOOR_3'
						while 83D0: not wav_loaded
							wait 0 ms
						end
						03D1: play_wav
						while true
							if or
								834E:   not move_object $STAUNTON_HIDEOUT_DOOR1 to 103.8125 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0 
								834E:   not move_object $STAUNTON_HIDEOUT_DOOR2 to 102.1875 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0 
							jf break
							wait 0 ms
						end
						while 83D2: not wav_ended
							wait 0 ms
						end
						03D8: show_save_screen
						wait 0 ms
						while 83D9: not save_done
							wait 0 ms
						end
						0169: set_fade_color 0 0 0
						016A: fade 0 for 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 0 
						end
						wait 1000 ms
						while true
							if or
								834E:   not move_object $STAUNTON_HIDEOUT_DOOR1 to 105.3125 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0 
								834E:   not move_object $STAUNTON_HIDEOUT_DOOR2 to 100.6875 -482.75 16.25 speed 0.0625 0.0 0.0 collision_check 0
							jf break
							wait 0 ms
						end
						0395: clear_area 1 at 103.0 -478.5 range 14.875 1.0
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							0055: set_player_coordinates $PLAYER_CHAR to 103.0 -478.5 14.875 
							0171: set_player $PLAYER_CHAR z_angle_to 0.0
							016A: fade 1 for 1000 ms
							02EB: restore_camera_jumpcut
							03C8: set_camera_directly_before_player
						end
						wait 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 1 
						end
					end
				end
			end
		else // player_in_staunton
			if
				0038: $FLAG_STAUNTON_SAVE_ON_RADAR == 1
			then
				0164: disable_marker $STAUNTON_SAVE_MARKER
				0004: $FLAG_STAUNTON_SAVE_ON_RADAR = 0
			end
		end
	end
end

//#####################################################################################
//#####################################################################################
// END STAUNTON SAVE / BEGIN SSV SAVE
//#####################################################################################
//#####################################################################################

:SSV_SAVE
03A4: name_thread 'S_SAVE'

while true
	wait 250 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			03C6:   current_island == LEVEL_SUBURBAN
		then
			if
				0038:   $FLAG_SHORESIDE_SAVE_ON_RADAR == 0
			then
				0164: disable_marker $SHORESIDE_SAVE_MARKER
				02A7: $SHORESIDE_SAVE_MARKER = create_icon_marker_and_sphere RADAR_SPRITE_SAVE at -665.0 -6.5 -100.0
				018B: show_on_radar $SHORESIDE_SAVE_MARKER BLIP_ONLY
				0004: $FLAG_SHORESIDE_SAVE_ON_RADAR = 1
			end
			if
				0121:   player $PLAYER_CHAR in_zone 'PROJECT'  // Wichita Gardens
			then
				if
					0038: $ONMISSION == 0
				then
					while 834D:   not rotate_object $SSV_HIDEOUT_DOOR from_angle 250.0 to 10.0 collision_check 0 
						wait 0 ms
					end
				else
					while 834D:   not rotate_object $SSV_HIDEOUT_DOOR from_angle 180.0 to 10.0 collision_check 0 
						wait 0 ms
					end
				end
				if and
					0256:   is_player $PLAYER_CHAR defined 
					0038:   $ONMISSION == 0
				then
					if and
						03EE:   player $PLAYER controllable
						019C:   player $PLAYER_CHAR 0 -670.5 3.875 18.0 -660.0 12.6875 22.0
					then
						01B4: set_player $PLAYER_CHAR controllable 0 
						015F: set_camera_position -678.125 -6.4375 24.4375 rotation 0.0 0.0 0.0 
						0160: point_camera -677.375 -5.875 24.0625 switchstyle JUMP_CUT 
						while 834D:   not rotate_object $SSV_HIDEOUT_DOOR from_angle 180.0 to 8.0 collision_check 0 
							wait 0 ms
						end
						03D8: show_save_screen
						wait 0 ms
						while 83D9: not save_done
							wait 0 ms
						end
						0169: set_fade_color 0 0 0
						016A: fade 0 for 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 0 
						end
						wait 1000 ms
						while 834D:   not rotate_object $SSV_HIDEOUT_DOOR from_angle 250.0 to 10.0 collision_check 0 
							wait 0 ms
						end
						0395: clear_area 1 at -666.75 -1.75 range -100.0 1.0
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							0055: set_player_coordinates $PLAYER_CHAR to -666.75 -1.75 -100.0 
							0171: set_player $PLAYER_CHAR z_angle_to 180.0
							016A: fade 1 for 1000 ms
							02EB: restore_camera_jumpcut
							03C8: set_camera_directly_before_player
						end
						wait 1000 ms
						if
							0256:   is_player $PLAYER_CHAR defined 
						then
							01B4: set_player $PLAYER_CHAR controllable 1 
						end
					end
				end
			end
		else // player_in_shoreside
			if
				0038: $FLAG_SHORESIDE_SAVE_ON_RADAR == 1
			then
				0164: disable_marker $SHORESIDE_SAVE_MARKER
				0004: $FLAG_SHORESIDE_SAVE_ON_RADAR = 0
			end
		end
	end
end

//#####################################################################################
//#####################################################################################
// END SSV SAVE / BEGIN PORTLAND RESTART
//#####################################################################################
//#####################################################################################

:PORTLAND_RESTART
03A4: name_thread 'I_RSTRT'
while true
	wait 1000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		03C6:   current_island == LEVEL_INDUSTRIAL
	then
		016C: restart_if_wasted at 1144.25 -596.875 13.875 heading 90.0 
		016D: restart_if_busted at 1143.875 -675.1875 -100.0 heading 90.0
		end_thread
	end
end //while

//#####################################################################################
//#####################################################################################
// END PORTLAND RESTART / BEGIN STAUNTON RESTART
//#####################################################################################
//#####################################################################################

:STAUNTON_RESTART
03A4: name_thread 'C_RSTRT'
while true
	wait 1000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		03C6:   current_island == LEVEL_COMMERCIAL
	then
		if or
			0038:   $FLAG_STAUNTON_OPEN == 1
			0038:   $DEBUGUNLOCKISLANDS == 1
		then
			016C: restart_if_wasted at 183.5 -17.75 16.1875 heading 180.0
			016D: restart_if_busted at 340.25 -1123.375 25.0 heading 180.0
			end_thread
		end
	end
end //while

//#####################################################################################
//#####################################################################################
// END STAUNTON RESTART / BEGIN SSV RESTART
//#####################################################################################
//#####################################################################################

:SSV_RESTART
03A4: name_thread 'S_RSTRT'
while true
	wait 1000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		03C6:   current_island == LEVEL_SUBURBAN
	then
		if or
			0038:   $FLAG_SHORESIDE_OPEN == 1
			0038:   $DEBUGUNLOCKISLANDS == 1
		then
			016C: restart_if_wasted at -1253.0 -138.1875 57.75 heading 90.0 
			016D: restart_if_busted at -1259.5 -44.5 57.75 heading 90.0
			end_thread
		end
	end
end //while
