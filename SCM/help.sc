//#####################################################################################
//#####################################################################################
// BEGIN AMMUNATION PISTOL MONITOR 
//#####################################################################################
//#####################################################################################

:PISTOL_MESSAGE
03A4: name_thread 'PISTOL1'

while true
	wait 10000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		0038:   $ONMISSION == 0
		0038:   $DISPLAYED_PISTOL_NOW_AT_AMMUNITION_HELP_TEXT == 0
	then
		0215: destroy_pickup $SHOP_PISTOL
		0213: $AMMUNATION_COLT_PICKUP = create_pickup #COLT45 type PICKUP_IN_SHOP at 1068.5 -400.75 15.1875
		014D: text_pager 'COLT_IN' 140 2 0  // The Pistol is now in stock at Ammunation!
		0004: $DISPLAYED_PISTOL_NOW_AT_AMMUNITION_HELP_TEXT = 1
		end_thread
	end
end //while


//#####################################################################################
//#####################################################################################
// END AMMUNATION PISTOL MONITOR / BEGIN AMMUNATION UZI MONITOR
//#####################################################################################
//#####################################################################################

:UZI_MESSAGE
03A4: name_thread 'UZI1'

while true
	wait 5000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		0038:   $ONMISSION == 0
		0038:   $DISPLAYED_UZI_NOW_AT_AMMUNITION_HELP_TEXT == 0
	then
		0215: destroy_pickup $SHOP_UZI 
		0213: $AMMUNATION_UZI_PICKUP = create_pickup #UZI type PICKUP_IN_SHOP at 1070.5 -400.75 15.1875
		014D: text_pager 'UZI_IN' 140 2 0  // The Uzi is now in stock at Ammunation!
		0004: $DISPLAYED_UZI_NOW_AT_AMMUNITION_HELP_TEXT = 1
		end_thread
	end
end //while

//#####################################################################################
//#####################################################################################
// END AMMUNATION UZI MONITOR / BEGIN JOEY BF INJECTION MONITOR
//#####################################################################################
//#####################################################################################

:JOEYS_BUGGY_LOOP
03A4: name_thread 'JOE_BUG'

while true
	wait 500 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		03C6:   current_island == LEVEL_INDUSTRIAL
	then
		00BF: get_time_of_day $CURRENT_TIME_HOURS $CURRENT_TIME_MINUTES 
		if and
			0018:   $CURRENT_TIME_HOURS > 17
			001A:   24 > $CURRENT_TIME_HOURS
		then
			if
				0038:   $JOEY_VISITING_MISTY == 0
			then
				014C: set_parked_car_generator $JOEYS_BUGGY cars_to_generate_to 101
				018D: $JOEY_SOUND = create_sound 91 at 937.0625 -275.5 8.875
				0004: $JOEY_VISITING_MISTY = 1
			end
		else
			if
				0038:   $JOEY_VISITING_MISTY == 1
			then
				014C: set_parked_car_generator $JOEYS_BUGGY cars_to_generate_to 0
				018E: stop_sound $JOEY_SOUND 
				0004: $JOEY_VISITING_MISTY = 0
			end
		end
	end
end

//#####################################################################################
//#####################################################################################
// END JOEY BF INJECTION MONITOR / BEGIN TONI_FR
//#####################################################################################
//#####################################################################################

:TONI5_FLAMES_LOOP
03A4: name_thread 'TONI_FR'

while true
	wait 500 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			8121:   not player $PLAYER_CHAR in_zone 'PORT_W'  // Callahan Point
		then
			031A: remove_all_fires
			end_thread
		end
	end
end //while

//#####################################################################################
//#####################################################################################
// END TONI_FR / BEGIN TONI4PG
//#####################################################################################
//#####################################################################################

:TONI4_PAGER_LOOP
03A4: name_thread 'TONI4PG'

while true
	wait 10000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		0038:   $ONMISSION == 0
		03C6:   current_island == LEVEL_INDUSTRIAL
	then
		if
			0038:   $TRIADS_AND_TRIBULATIONS_COMPLETED == 0
		then
			014D: text_pager 'TONI_P' 140 2 0  // I've got some urgent work for you! -Toni
		end
		004F: create_thread @TONI5_PAGER_LOOP
		end_thread
	end
end //while

//#####################################################################################
//#####################################################################################
// END TONI4PG / BEGIN TONI5PG
//#####################################################################################
//#####################################################################################

:TONI5_PAGER_LOOP
03A4: name_thread 'TONI5PG'

while true
	wait 10000 ms
	if and
		0256:   is_player $PLAYER_CHAR defined 
		0038:   $ONMISSION == 0
		03C6:   current_island == LEVEL_INDUSTRIAL
	then
		if
			0038:   $TRIADS_AND_TRIBULATIONS_COMPLETED == 1
		then
			if
				0038:   $BLOW_FISH_COMPLETED == 0
			then
				014D: text_pager 'TONI_P' 140 2 0  // I've got some urgent work for you! -Toni
			end
			end_thread
		end
	end
end //while

//#####################################################################################
//#####################################################################################
// END TONI5PG / BEGIN ASUK_DR
//#####################################################################################
//#####################################################################################

:CLOSE_ASUKA1_DOOR
03A4: name_thread 'ASUK_DR'
if
	03CA:   object $LUIGI_BACKDOOR exists
then
	0176: $DOOR_POSITION_A1 = object $LUIGI_BACKDOOR z_angle
	if
		0038:   $DOOR_CRASH_FLAG == 1
	then
		while 8042:   not $DOOR_POSITION_A1 == 0.0
			if
				0256:   is_player $PLAYER_CHAR defined 
			then
				if
					8057:   not is_player_in_area_3d $PLAYER_CHAR coords 889.5625 -418.0625 15.0 to 895.125 -412.625 18.0 sphere 0
				then
					if and
						0020:   $DOOR_POSITION_A1 > -10.0
						0022:   10.0 > $DOOR_POSITION_A1
					then
						0005: $DOOR_POSITION_A1 = 0.0
					else
						000D: $DOOR_POSITION_A1 -= 10.0
					end
					0177: set_object $LUIGI_BACKDOOR z_angle_to $DOOR_POSITION_A1
				end
			else
				0005: $DOOR_POSITION_A1 = 0.0
				0177: set_object $LUIGI_BACKDOOR z_angle_to $DOOR_POSITION_A1
			end
			wait 0 ms
		end //while
	end
end
end_thread
