:INSANE_STUNT
0111: set_wasted_busted_check_to 0 
03A4: name_thread 'HJ'
0004: $LONGEST_FLIGHT_TIME = 0

:MISSION_START_HJ
wait 0 ms
if or
	8256:   not is_player $PLAYER_CHAR defined
	0445:   are_any_car_cheats_activated
then
	goto @MISSION_START_HJ
end
if 
	00E0:   is_player_in_any_car $PLAYER_CHAR 
then
	03C1: $CAR_PLAYER_IS_IN_HJ = player $PLAYER_CHAR car_no_save
	if and
		829C:   not is_boat $CAR_PLAYER_IS_IN_HJ 
		01F3:   car $CAR_PLAYER_IS_IN_HJ airborne
	then
		0004: $TOTAL_ROTATION_INT = 0 
		0005: $HEADING_HJ = 0.0 
		0004: $FLAG_WHEELS_HJ = 0 
		0004: $COUNTER_LAND_ON_WHEELS_HJ = 0 
		0004: $COUNTER_STUNT_ROLLS_HJ = 0 
		0004: $FLAG_CAR_UPSIDEDOWN_HJ = 0 
		0004: $COUNTER_WHEELS_HJ = 0 
		0004: $STUNT_FLAGS_HJ = 0 
		0004: $FLAG_TAKEOFF_HJ = 0 
		0004: $HEIGHT_INT_HJ = 0 
		0005: $HEIGHT_FLOAT_HJ = -100.0 
		0005: $X_FLOAT_HJ = 0.0 
		0005: $Y_FLOAT_HJ = 0.0 
		0005: $Z_FLOAT_HJ = 0.0 
		0005: $TAKEOFF_X_FLOAT_HJ = 0.0 
		0005: $TAKEOFF_Y_FLOAT_HJ = 0.0 
		0005: $TAKEOFF_Z_FLOAT_HJ = 0.0 
		0005: $JUMPEND_X_FLOAT_HJ = 0.0 
		0005: $JUMPEND_Y_FLOAT_HJ = 0.0 
		0005: $DIFFERENCE_X_FLOAT_HJ = 0.0 
		0005: $DIFFERENCE_Y_FLOAT_HJ = 0.0 
		0005: $SUM_DIFFERENCE_XY_HJ = 0.0 
		0005: $JUMPDISTANCE_FLOAT_HJ = 0.0 
		0004: $JUMPDISTANCE_INT_HJ = 0 
		0004: $DISTANCE_DECIMALS_INT_HJ = 0 
		0004: $HEIGHT_DECIMALS_INT_HJ = 0 
		0005: $TEMP_FLOAT = 0.0 
		0005: $HEADING_DIFFERENCE = 0.0 
		0005: $TOTAL_ROTATION = 0.0 
		0005: $HEADING_DIFFERENCE_TEMP = 0.0 
		0005: $OLD_HEADING_HJ = 0.0 
		0004: $GOT_FLIGHT_START = 0 
		0004: $FLIGHT_TIMER_START = 0 
		0004: $FLIGHT_TIMER_END = 0 
		0004: $FLIGHT_TIME = 0 
		0004: $FLAG_FLIGHT_HJ = 0 
		0004: $COLLISION_COUNTER = 0 
		if 
			0137:   car $CAR_PLAYER_IS_IN_HJ id == #DODO
		then
			goto @DODO_FLIGHT_TIME
		end
		while true
			if or
				01F3:   car $CAR_PLAYER_IS_IN_HJ airborne
				001A:   10 > $COLLISION_COUNTER
			jf break
			0008: $COLLISION_COUNTER += 1 
			00AA: get_car_coordinates $CAR_PLAYER_IS_IN_HJ store_to $X_FLOAT_HJ $Y_FLOAT_HJ $Z_FLOAT_HJ 
			0086: $OLD_HEADING_HJ = $HEADING_HJ 
			if
				0038:   $FLAG_TAKEOFF_HJ == 0
			then
				0174: $OLD_HEADING_HJ = car $CAR_PLAYER_IS_IN_HJ z_angle 
				0086: $TAKEOFF_X_FLOAT_HJ = $X_FLOAT_HJ 
				0086: $TAKEOFF_Y_FLOAT_HJ = $Y_FLOAT_HJ 
				0086: $TAKEOFF_Z_FLOAT_HJ = $Z_FLOAT_HJ 
				0004: $FLAG_TAKEOFF_HJ = 1 
			end
			wait 0 ms
			if or
				0119:   car $CAR_PLAYER_IS_IN_HJ wrecked
				8256:   not is_player $PLAYER_CHAR defined 
			then
				goto @MISSION_START_HJ
			end
			if
				80E0:   not is_player_in_any_car $PLAYER_CHAR
			then
				goto @MISSION_START_HJ
			end
			if and
				820D:   not car $CAR_PLAYER_IS_IN_HJ is_upright 
				0038:   $FLAG_CAR_UPSIDEDOWN_HJ == 0
			then
				0004: $FLAG_CAR_UPSIDEDOWN_HJ = 1
			end
			if and
				020D:   car $CAR_PLAYER_IS_IN_HJ is_upright
				0038:   $FLAG_CAR_UPSIDEDOWN_HJ == 1
			then
				0008: $COUNTER_STUNT_ROLLS_HJ += 1
				0004: $FLAG_CAR_UPSIDEDOWN_HJ = 0
			end
			0174: $HEADING_HJ = car $CAR_PLAYER_IS_IN_HJ z_angle 
			0086: $HEADING_DIFFERENCE = $HEADING_HJ 
			0061: $HEADING_DIFFERENCE -= $OLD_HEADING_HJ 
			if
				0020:   $HEADING_DIFFERENCE > 180.0 
			then
				0086: $HEADING_DIFFERENCE_TEMP = $HEADING_DIFFERENCE 
				0005: $HEADING_DIFFERENCE = 360.0 
				0061: $HEADING_DIFFERENCE -= $HEADING_DIFFERENCE_TEMP 
			else
				if 
					0022:   -180.0 > $HEADING_DIFFERENCE 
				then
					0086: $HEADING_DIFFERENCE_TEMP = $HEADING_DIFFERENCE 
					0005: $HEADING_DIFFERENCE = 360.0 
					0059: $HEADING_DIFFERENCE += $HEADING_DIFFERENCE_TEMP 
				end
			end
			if 
				0022:   0.0 > $HEADING_DIFFERENCE 
			then
				0086: $HEADING_DIFFERENCE_TEMP = $HEADING_DIFFERENCE 
				0005: $HEADING_DIFFERENCE = 0.0 
				0061: $HEADING_DIFFERENCE -= $HEADING_DIFFERENCE_TEMP 
			end
			0059: $TOTAL_ROTATION += $HEADING_DIFFERENCE 
			008C: $TOTAL_ROTATION_INT = float_to_integer $TOTAL_ROTATION 
			if
				0024:   $Z_FLOAT_HJ > $HEIGHT_FLOAT_HJ 
			then
				0086: $HEIGHT_FLOAT_HJ = $Z_FLOAT_HJ 
			end
			0005: $Z_FLOAT_HJ = 0.0 
		end //while
	else
		goto @MISSION_START_HJ
	end
else
	goto @MISSION_START_HJ
end

if
	0038:   $FLAG_TAKEOFF_HJ == 1
then
	00AA: get_car_coordinates $CAR_PLAYER_IS_IN_HJ store_to $JUMPEND_X_FLOAT_HJ $JUMPEND_Y_FLOAT_HJ $TEMP_FLOAT
	while 001A: 90 > $COUNTER_LAND_ON_WHEELS_HJ
		if
			0119:   car $CAR_PLAYER_IS_IN_HJ wrecked
		then
			goto @MISSION_START_HJ
		end
		if
			815E:   not car $CAR_PLAYER_IS_IN_HJ in_air 
		then
			0008: $COUNTER_WHEELS_HJ +=  1
		end
		wait 0 ms
		if
			8256:   not is_player $PLAYER_CHAR defined 
		then
			goto @MISSION_START_HJ
		end
		0008: $COUNTER_LAND_ON_WHEELS_HJ += 1
	end //while
	0004: $COUNTER_LAND_ON_WHEELS_HJ = 0 
	0086: $DIFFERENCE_X_FLOAT_HJ = $TAKEOFF_X_FLOAT_HJ 
	0061: $DIFFERENCE_X_FLOAT_HJ -= $JUMPEND_X_FLOAT_HJ 
	0086: $DIFFERENCE_Y_FLOAT_HJ = $TAKEOFF_Y_FLOAT_HJ 
	0061: $DIFFERENCE_Y_FLOAT_HJ -= $JUMPEND_Y_FLOAT_HJ 
	0069: $DIFFERENCE_X_FLOAT_HJ *= $DIFFERENCE_X_FLOAT_HJ 
	0069: $DIFFERENCE_Y_FLOAT_HJ *= $DIFFERENCE_Y_FLOAT_HJ 
	0086: $SUM_DIFFERENCE_XY_HJ = $DIFFERENCE_X_FLOAT_HJ 
	0059: $SUM_DIFFERENCE_XY_HJ += $DIFFERENCE_Y_FLOAT_HJ 
	01FB: $JUMPDISTANCE_FLOAT_HJ = square_root $SUM_DIFFERENCE_XY_HJ 
	030E: save_jump_distance $JUMPDISTANCE_FLOAT_HJ 
	008C: $JUMPDISTANCE_INT_HJ = float_to_integer $JUMPDISTANCE_FLOAT_HJ 
	0061: $HEIGHT_FLOAT_HJ -= $TAKEOFF_Z_FLOAT_HJ 
	030F: save_jump_height $HEIGHT_FLOAT_HJ 
	008C: $HEIGHT_INT_HJ = float_to_integer $HEIGHT_FLOAT_HJ 
	008D: $TEMP_FLOAT = integer_to_float $JUMPDISTANCE_INT_HJ 
	0061: $JUMPDISTANCE_FLOAT_HJ -= $TEMP_FLOAT 
	0086: $TEMP_FLOAT = $JUMPDISTANCE_FLOAT_HJ 
	0011: $TEMP_FLOAT *= 100.0 
	008C: $DISTANCE_DECIMALS_INT_HJ = float_to_integer $TEMP_FLOAT 
	008D: $TEMP_FLOAT = integer_to_float $HEIGHT_INT_HJ 
	0061: $HEIGHT_FLOAT_HJ -= $TEMP_FLOAT 
	0086: $TEMP_FLOAT = $HEIGHT_FLOAT_HJ 
	0011: $TEMP_FLOAT *= 100.0 
	008C: $HEIGHT_DECIMALS_INT_HJ = float_to_integer $TEMP_FLOAT 
	0310: save_jump_flips $COUNTER_STUNT_ROLLS_HJ 
	0311: save_jump_rotation $TOTAL_ROTATION_INT 
end
if
	0020:   $HEIGHT_FLOAT_HJ > 4.0 //4 METERS HIGH
then
	0008: $STUNT_FLAGS_HJ += 1
end
if
	0018:   $JUMPDISTANCE_INT_HJ > 30 //30 METERS LONG
then
	0008: $STUNT_FLAGS_HJ += 1
end
if
	0018:   $COUNTER_STUNT_ROLLS_HJ > 0 //1 ROLLS/FLIPS IN MID AIR
then
	0008: $STUNT_FLAGS_HJ += 1
end
if
	0018:   $TOTAL_ROTATION_INT > 360 //360 SPIN IN MID AIR
then
	0008: $STUNT_FLAGS_HJ += 1
end
if
	0018:   $COUNTER_WHEELS_HJ > 60 //LAND ON WHEELS
then
	0004: $FLAG_WHEELS_HJ = 1
end
if
	0018:   $STUNT_FLAGS_HJ > 0 
then
	0084: $CASH_REWARD = $COUNTER_STUNT_ROLLS_HJ 
	0010: $CASH_REWARD *= 180 
	0058: $CASH_REWARD += $TOTAL_ROTATION_INT 
	0084: $CASH_REWARD_TEMP = $JUMPDISTANCE_INT_HJ 
	0010: $CASH_REWARD_TEMP *= 6 
	0058: $CASH_REWARD += $CASH_REWARD_TEMP 
	0084: $CASH_REWARD_TEMP = $HEIGHT_INT_HJ 
	0010: $CASH_REWARD_TEMP *= 45 
	0058: $CASH_REWARD += $CASH_REWARD_TEMP
	if
		0038:   $FLAG_WHEELS_HJ == 1
	then 
		0010: $CASH_REWARD *= 2
	end
	0068: $CASH_REWARD *= $STUNT_FLAGS_HJ
	0014: $CASH_REWARD /= 3
	0109: player $PLAYER_CHAR money += $CASH_REWARD
	if and
		0038:   $STUNT_FLAGS_HJ == 1
		0038:   $FLAG_WHEELS_HJ == 0
	then
		01E4: text_1number_lowpriority 'HJ_IS' number $CASH_REWARD duration 2000 ms flag 1  // INSANE STUNT BONUS: $~1~
		0312: save_jump_type 1
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 1
		0038:   $FLAG_WHEELS_HJ == 1
	then
		01E4: text_1number_lowpriority 'HJ_PIS' number $CASH_REWARD duration 2000 ms flag 1  // PERFECT INSANE STUNT BONUS: $~1~
		0312: save_jump_type 2
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 2
		0038:   $FLAG_WHEELS_HJ == 0
	then
		01E4: text_1number_lowpriority 'HJ_DIS' number $CASH_REWARD duration 2000 ms flag 1  // DOUBLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 3
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 2
		0038:   $FLAG_WHEELS_HJ == 1
	then
		01E4: text_1number_lowpriority 'HJ_PDIS' number $CASH_REWARD duration 2000 ms flag 1  // PERFECT DOUBLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 4
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 3
		0038:   $FLAG_WHEELS_HJ == 0
	then
		01E4: text_1number_lowpriority 'HJ_TIS' number $CASH_REWARD duration 2000 ms flag 1  // TRIPLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 5
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 3
		0038:   $FLAG_WHEELS_HJ == 1
	then
		01E4: text_1number_lowpriority 'HJ_PTIS' number $CASH_REWARD duration 2000 ms flag 1  // PERFECT TRIPLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 6
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 4
		0038:   $FLAG_WHEELS_HJ == 0
	then
		01E4: text_1number_lowpriority 'HJ_QIS' number $CASH_REWARD duration 2000 ms flag 1  // QUADRUPLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 7
	end
	if and
		0038:   $STUNT_FLAGS_HJ == 4
		0038:   $FLAG_WHEELS_HJ == 1
	then
		01E4: text_1number_lowpriority 'HJ_PQIS' number $CASH_REWARD duration 3000 ms flag 1  // PERFECT QUADRUPLE INSANE STUNT BONUS: $~1~
		0312: save_jump_type 8
	end
	if
		0424:   metric
	then
		if
			0038: $FLAG_WHEELS_HJ == 1
		then
			0308: text_6numbers 'HJSTATW' numbers $JUMPDISTANCE_INT_HJ $DISTANCE_DECIMALS_INT_HJ $HEIGHT_INT_HJ $HEIGHT_DECIMALS_INT_HJ $COUNTER_STUNT_ROLLS_HJ $TOTAL_ROTATION_INT duration 5000 ms flag 5  // Distance: ~1~.~1~m Height: ~1~.~1~m Flips: ~1~ Rotation: ~1~_ And what a great landing!
		else
			0308: text_6numbers 'HJSTAT' numbers $JUMPDISTANCE_INT_HJ $DISTANCE_DECIMALS_INT_HJ $HEIGHT_INT_HJ $HEIGHT_DECIMALS_INT_HJ $COUNTER_STUNT_ROLLS_HJ $TOTAL_ROTATION_INT duration 5000 ms flag 5  // Distance: ~1~.~1~m Height: ~1~.~1~m Flips: ~1~ Rotation: ~1~_
		end
	else
		042D: $JUMPDISTANCE_INT_HJ = metric_to_imperial $JUMPDISTANCE_INT_HJ
		042D: $HEIGHT_INT_HJ = metric_to_imperial $HEIGHT_INT_HJ
		if
			0038: $FLAG_WHEELS_HJ == 1
		then
			0302: text_4numbers 'HJSTAWF' numbers $JUMPDISTANCE_INT_HJ $HEIGHT_INT_HJ $COUNTER_STUNT_ROLLS_HJ $TOTAL_ROTATION_INT duration 5000 ms flag 5  // Distance: ~1~ft Height: ~1~ft Flips: ~1~ Rotation: ~1~_ And what a great landing!
		else
			0302: text_4numbers 'HJSTATF' numbers $JUMPDISTANCE_INT_HJ $HEIGHT_INT_HJ $COUNTER_STUNT_ROLLS_HJ $TOTAL_ROTATION_INT duration 5000 ms flag 5  // Distance: ~1~ft Height: ~1~ft Flips: ~1~ Rotation: ~1~_
		end
	end
end
goto @MISSION_START_HJ

:DODO_FLIGHT_TIME
while 01F3:   car $CAR_PLAYER_IS_IN_HJ airborne
	wait 0 ms
	if
		0038: $GOT_FLIGHT_START == 0
	then
		01BD: $FLIGHT_TIMER_START = current_time_in_ms 
		0004: $FLAG_FLIGHT_HJ = 1
		0004: $GOT_FLIGHT_START = 1
	end
	if
		02BF:   car $CAR_PLAYER_IS_IN_HJ sunk
	then
		goto @CESSNA_FLIGHT_BIT
	end
	if or
		0119:   car $CAR_PLAYER_IS_IN_HJ wrecked
		8256:   not is_player $PLAYER_CHAR defined
	then
		goto @MISSION_START_HJ
	end
	if
		80E0:   not is_player $PLAYER_CHAR driving
	then
		goto @MISSION_START_HJ
	end
end //while

:CESSNA_FLIGHT_BIT
if
	0038:   $FLAG_FLIGHT_HJ == 1
then
	01BD: $FLIGHT_TIMER_END = current_time_in_ms 
	0084: $FLIGHT_TIME = $FLIGHT_TIMER_END
	0060: $FLIGHT_TIME -= $FLIGHT_TIMER_START
	0014: $FLIGHT_TIME /= 1000
	if
		0018:   $FLIGHT_TIME > 1
	then
		if
			001C:   $FLIGHT_TIME > $LONGEST_FLIGHT_TIME
		then
			0084: $LONGEST_FLIGHT_TIME = $FLIGHT_TIME
		end
		01E5: text_1number_highpriority 'DODO_FT' number $FLIGHT_TIME duration 5000 ms flag 1  // You flew for ~1~ seconds!
		0406: save_dodo_flight_time $FLIGHT_TIME
	end
end
goto @MISSION_START_HJ
