:CAMERA
0004: $RAYS_CAMERA1 = 0  
0004: $RAYS_CAMERA2 = 0  
0004: $RAYS_CAMERA3 = 0  
0004: $RAYS_CUTSCENE_FLAG = 0  
03A4: name_thread 'CAMERA'
0111: set_wasted_busted_check_to 0 

:MISSION_START_CAMERA
wait 70 ms
if and
	0256:   is_player $PLAYER_CHAR defined 
	03C6:   current_island == LEVEL_COMMERCIAL
	0038:   $RAYS_CUTSCENE_FLAG == 0
then
	if
		0121:   player $PLAYER_CHAR in_zone 'PARK'  // Belleville Park
	then
		if
			0057:   is_player_in_area_3d $PLAYER_CHAR coords 36.5 -734.5625 21.625 to 47.4375 -726.9375 24.4375 sphere 0
		then
			if
				0056:   is_player_in_area_2d $PLAYER_CHAR coords 36.5 -729.375 47.4375 -726.9375 sphere 0
			then
				if
					0038:   $RAYS_CAMERA1 == 0
				then
					01B4: set_player $PLAYER_CHAR controllable 0
					0169: set_fade_color 1 1 1
					016A: fade 0 for 200 ms
					0004: $RAYS_CAMERA1 = 1
				end
				if and
					0038:   $RAYS_CAMERA1 == 1
					816B:   not fading
				then
					if
						$RAYS_CAMERA2 == 0
					then
						0055: set_player_coordinates $PLAYER_CHAR to 38.9375 -727.8125 21.5625 
						0171: set_player $PLAYER_CHAR z_angle_to 225.0 
					end
					015F: set_camera_position 36.0 -728.3125 24.25 rotation 0.0 0.0 0.0 
					0452: enable_player_control_camera
					0160: point_camera 36.9375 -728.3125 23.875 switchstyle JUMP_CUT 
					016A: fade 1 for 200 ms
					0004: $RAYS_CAMERA1 = 2
				end
				if and
					0038:   $RAYS_CAMERA1 == 2
					816B:   not fading
				then
					01B4: set_player $PLAYER_CHAR controllable 1
					0004: $RAYS_CAMERA1 = 3
					0004: $RAYS_CAMERA2 = 0
					0004: $RAYS_CAMERA3 = 0
				end
			end
			if
				0056:   is_player_in_area_2d $PLAYER_CHAR coords 44.25 -734.5625 47.4375 -729.375 sphere 0 
			then
				if
					0038:   $RAYS_CAMERA2 == 0
				then
					01B4: set_player $PLAYER_CHAR controllable 0
					016A: fade 0 for 200 ms
					0004: $RAYS_CAMERA2 = 1
				end
				if and
					$RAYS_CAMERA2 == 1
					816B:   not fading
				then
					015F: set_camera_position 46.6875 -727.125 22.5 rotation 0.0 0.0 0.0
					0452: enable_player_control_camera
					0160: point_camera 46.4375 -728.0625 22.5625 switchstyle JUMP_CUT 
					016A: fade 1 for 200 ms
					0004: $RAYS_CAMERA2 = 2
				end
				if and
					0038:   $RAYS_CAMERA2 == 2
					816B:   not fading
				then
					01B4: set_player $PLAYER_CHAR controllable 1
					0004: $RAYS_CAMERA1 = 0
					0004: $RAYS_CAMERA2 = 3
					0004: $RAYS_CAMERA3 = 0
				end
			end
			if
				0056:   is_player_in_area_2d $PLAYER_CHAR coords 36.5 -734.5625 44.25 -729.375 sphere 0
			then
				if
					0038:   $RAYS_CAMERA3 == 0
				then
					01B4: set_player $PLAYER_CHAR controllable 0
					016A: fade 0 for 200 ms
					0004: $RAYS_CAMERA3 = 1
				end
				if and
					0038:   $RAYS_CAMERA3 == 1
					816B:   not fading
				then
					015F: set_camera_position 46.5625 -733.875 23.9375 rotation 0.0 0.0 0.0 
					0452: enable_player_control_camera
					0160: point_camera 45.625 -733.5625 23.6875 switchstyle JUMP_CUT 
					016A: fade 1 for 200 ms
					0004: $RAYS_CAMERA3 = 2
				end
				if and
					0038:   $RAYS_CAMERA3 == 2
					816B:   not fading
				then
					01B4: set_player $PLAYER_CHAR controllable 1
					0004: $RAYS_CAMERA1 = 0
					0004: $RAYS_CAMERA2 = 0
					0004: $RAYS_CAMERA3 = 3
				end
			end
		else
			if
				0038:   $RAYS_CAMERA1 == 3
			then
				01B4: set_player $PLAYER_CHAR controllable 0
				016A: fade 0 for 200 ms
				0004: $RAYS_CAMERA1 = 4
			end
			if and
				0038:   $RAYS_CAMERA1 == 4
				816B:   not fading
			then
				0395: clear_area 1 at 38.875 -726.0 range 22.1875 2.0 
				0055: set_player_coordinates $PLAYER_CHAR to 38.875 -726.0 21.5625 
				0171: set_player $PLAYER_CHAR z_angle_to 0.0 
				02EB: restore_camera_jumpcut 
				03C8: set_camera_directly_before_player 
				016A: fade 1 for 200 ms
				0004: $RAYS_CAMERA1 = 5
			end
			if and
				0038:   $RAYS_CAMERA1 == 5
				816B:   not fading
			then
				01B4: set_player $PLAYER_CHAR controllable 1
				0004: $RAYS_CAMERA1 = 0
				0004: $RAYS_CAMERA2 = 0
				0004: $RAYS_CAMERA3 = 0
			end
		end
	else // player_in_zone 'PARK'
		if or
			8038:   not $RAYS_CAMERA1 == 0
			8038:   not $RAYS_CAMERA2 == 0
			8038:   not $RAYS_CAMERA3 == 0
		then
			02EB: restore_camera_jumpcut 
			03C8: set_camera_directly_before_player
			0004: $RAYS_CAMERA1 = 0
			0004: $RAYS_CAMERA2 = 0
			0004: $RAYS_CAMERA3 = 0
		end
	end
end
goto @MISSION_START_CAMERA
