//#####################################################################################
//#####################################################################################
// BEGIN EIGHT MONITOR
//#####################################################################################
//#####################################################################################

:EIGHTBALL_MISSION_LOOP
wait 0 ms
if or
    0038:   $FLAG_STAUNTON_OPEN == 1  
    0038:   $LUIGIS_GIRLS_COMPLETED == 1  
then
    end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $FLAG_EIGHTBALL_MISSION_LAUNCHED == 0 
	0038:   $ONMISSION == 0 
then
	if
		0038:   $FLAG_REACHED_HIDEOUT == 0 
	then
		if and
			00E4:   player $PLAYER_CHAR 0 540.0 -937.6 radius 3.5 3.5
			03EE:   player $PLAYER_CHAR controllable 
		then
			0417: start_mission M01_GIVEMELIBERTY
			0004: $FLAG_EIGHTBALL_MISSION_LAUNCHED = 1
		end
	else // PLAYER REACHED HIDEOUT
		if and
			00E4:   player $PLAYER_CHAR 0 883.5 -308.1875 radius 3.5 3.5 
			03EE:   player $PLAYER_CHAR controllable 
		then
			0417: start_mission M01_GIVEMELIBERTY
			0004: $FLAG_EIGHTBALL_MISSION_LAUNCHED = 1 
		end
	end
end
goto @EIGHTBALL_MISSION_LOOP

//#####################################################################################
//#####################################################################################
// END EIGHT MONITOR / BEGIN LUIGI MONITORS
//#####################################################################################
//#####################################################################################

:LUIGI_MISSION2_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $DONT_SPANK_MA_BITCH_UP_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 892.75 -425.75 13.875 radius 1.5 2.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LM2' duration 15000 ms style 2  // 'DON'T SPANK MA BITCH UP'
			while fading
				wait 0 ms
			end
			0417: start_mission M02_DONTSPANKMABITCHUP
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LUIGI_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 892.75 -425.75 13.875 radius 1.5 2.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LUIGI_MISSION2_LOOP
			end
		end //while
	end
end
goto @LUIGI_MISSION2_LOOP


:LUIGI_MISSION3_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $DRIVE_MISTY_FOR_ME_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 892.75 -425.75 13.875 radius 1.5 2.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LM3' duration 15000 ms style 2  // 'DRIVE MISTY FOR ME'
			while fading
				wait 0 ms
			end
			0417: start_mission M03_DRIVEMISTYFORME
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LUIGI_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 892.75 -425.75 13.875 radius 1.5 2.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LUIGI_MISSION3_LOOP
			end
		end //while
	end
end
goto @LUIGI_MISSION3_LOOP

//#####################################################################################
//#####################################################################################
// END LUIGI MONITORS / BEGIN JOEY MONITORS
//#####################################################################################
//#####################################################################################

:JOEY_MISSION1_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $MIKE_LIPS_LAST_LUNCH_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
	then
		00BF: get_time_of_day $CURRENT_TIME_HOURS $CURRENT_TIME_MINUTES
		if and
			0028:   $CURRENT_TIME_HOURS >= 5
			001A:   21 > $CURRENT_TIME_HOURS
		then
			if
				03EE:   player $PLAYER_CHAR controllable 
			then
				03EF: player $PLAYER_CHAR make_safe 
				0169: set_fade_color 0 0 0 
				016A: fade 0 for 1500 ms 
				03AF: set_streaming 0 
				00BA: print_big 'JM1' duration 15000 ms style 2  // 'MIKE LIPS LAST LUNCH'
				while fading
					wait 0 ms
				end
				0417: start_mission M04_MIKELIPSLASTLUNCH
			end
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @JOEY_MISSION1_LOOP
			end
			while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
				wait 0 ms
				if
					8256:   not is_player $PLAYER_CHAR defined
				then
					goto @JOEY_MISSION1_LOOP
				end
			end //while
		else
			00BC: print_now 'WRONGT1' duration 5000 ms flag 1  // ~g~Come back between 05:00 and 21:00 for a job
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @JOEY_MISSION1_LOOP
			end
			00BF: get_time_of_day $CURRENT_TIME_HOURS $CURRENT_TIME_MINUTES
			if and
				0028:   $CURRENT_TIME_HOURS >= 5
				001A:   21 > $CURRENT_TIME_HOURS
			then
				goto @JOEY_MISSION1_LOOP
			end
		end //while
	end
end
goto @JOEY_MISSION1_LOOP

:JOEY_MISSION2_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $FAREWELL_CHUNKY_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'JM2' duration 15000 ms style 2  // 'FAREWELL 'CHUNKY' LEE CHONG'
			while fading
				wait 0 ms
			end
			0417: start_mission M05_FAREWELLCHUNKYLEECHONG
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @JOEY_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @JOEY_MISSION2_LOOP
			end
		end //while
	end
end
goto @JOEY_MISSION2_LOOP

:JOEY_MISSION3_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $VAN_HEIST_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'JM3' duration 15000 ms style 2  // 'VAN HEIST'
			while fading
				wait 0 ms
			end
			0417: start_mission M06_VANHEIST
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @JOEY_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @JOEY_MISSION3_LOOP
			end
		end //while
	end
end
goto @JOEY_MISSION3_LOOP

:JOEY_MISSION4_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $CIPRIANIS_CHAUFFEUR_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'JM4' duration 15000 ms style 2  // 'CIPRIANI'S CHAUFFEUR'
			while fading
				wait 0 ms
			end
			0417: start_mission M07_CIPRIANISCHAUFFEUR
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @JOEY_MISSION4_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @JOEY_MISSION4_LOOP
			end
		end //while
	end
end
goto @JOEY_MISSION4_LOOP

//#####################################################################################
//#####################################################################################
// END JOEY MONITORS / BEGIN TONI MONITORS
//#####################################################################################
//#####################################################################################

:TONI_MISSION1_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $TAKING_OUT_THE_LAUNDRY_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1219.75 -319.6875 27.375 radius 1.0 2.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'TM1' duration 15000 ms style 2  // 'TAKING OUT THE LAUNDRY'
			while fading
				wait 0 ms
			end
			0417: start_mission M08_TAKINGOUTTHELAUNDRY
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @TONI_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @TONI_MISSION1_LOOP
			end
		end //while
	end
end
goto @TONI_MISSION1_LOOP

:TONI_MISSION2_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $THE_PICKUP_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1219.75 -319.6875 27.375 radius 1.0 2.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'TM2' duration 15000 ms style 2  // 'THE PICK-UP'
			while fading
				wait 0 ms
			end
			0417: start_mission M09_THEPICKUP
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @TONI_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @TONI_MISSION2_LOOP
			end
		end //while
	end
end
goto @TONI_MISSION2_LOOP

:TONI_MISSION3_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $SALVATORES_CALLED_A_MEETING_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1219.75 -319.6875 27.375 radius 1.0 2.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'TM3' duration 15000 ms style 2  // 'SALVATORE'S CALLED A MEETING'
			while fading
				wait 0 ms
			end
			0417: start_mission M10_SALVATORESCALLEDAMEETING
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @TONI_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @TONI_MISSION3_LOOP
			end
		end //while
	end
end
goto @TONI_MISSION3_LOOP

:TONI_MISSION4_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $TRIADS_AND_TRIBULATIONS_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1219.75 -319.6875 27.375 radius 1.0 2.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'TM4' duration 15000 ms style 2  // 'TRIADS AND TRIBULATIONS'
			while fading
				wait 0 ms
			end
			0417: start_mission M11_TRIADSANDTRIBULATIONS
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @TONI_MISSION4_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @TONI_MISSION4_LOOP
			end
		end //while
	end
end
goto @TONI_MISSION4_LOOP

:TONI_MISSION5_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $BLOW_FISH_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 1219.75 -319.6875 27.375 radius 1.0 2.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'TM5' duration 15000 ms style 2  // 'BLOW FISH'
			while fading
				wait 0 ms
			end
			0417: start_mission M12_BLOWFISH
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @TONI_MISSION5_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1191.688 -870.0 15.0 radius 1.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @TONI_MISSION5_LOOP
			end
		end //while
	end
end
goto @TONI_MISSION5_LOOP

//#####################################################################################
//#####################################################################################
// END TONI MONITORS / BEGIN SALVATORE MONITORS
//#####################################################################################
//#####################################################################################

:FRANKIE_MISSION1_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $CHAPERONE_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
	0038:   $FLAG_FRANKIE_SWITCHED_OFF == 0
then
	if or
		00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
		02B4:   player $PLAYER_CHAR in_cube_on_foot 1466.188 -175.0 50.0 1452.875 -172.0625 60.0 radius 11.5625 sphere 0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'FM1' duration 15000 ms style 2  // 'CHAPERONE'
			while fading
				wait 0 ms
			end
			0417: start_mission M13_CHAPERONE
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @FRANKIE_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION1_LOOP
			end
		end //while
	end
end
goto @FRANKIE_MISSION1_LOOP


:FRANKIE_MISSION2_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $CUTTING_THE_GRASS_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
	0038:   $FLAG_FRANKIE_SWITCHED_OFF == 0
then
	if or
		00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
		02B4:   player $PLAYER_CHAR in_cube_on_foot 1466.188 -175.0 50.0 1452.875 -172.0625 60.0 radius 11.5625 sphere 0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'FM2' duration 15000 ms style 2  // 'CUTTING THE GRASS'
			while fading
				wait 0 ms
			end
			0417: start_mission M14_CUTTINGTHEGRASS
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @FRANKIE_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION2_LOOP
			end
		end //while
	end
end
goto @FRANKIE_MISSION2_LOOP


:FRANKIE_MISSION21_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $BOMB_DA_BASE_ACT_I_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 

then
	if or
		00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
		02B4:   player $PLAYER_CHAR in_cube_on_foot 1466.188 -175.0 50.0 1452.875 -172.0625 60.0 radius 11.5625 sphere 0
	then
		if
			0038:   $FLAG_FRANKIE_SWITCHED_OFF == 0
		then
			if
				03EE:   player $PLAYER_CHAR controllable 
			then
				03EF: player $PLAYER_CHAR make_safe 
				0169: set_fade_color 0 0 0 
				016A: fade 0 for 1500 ms 
				03AF: set_streaming 0 
				00BA: print_big 'FM21' duration 15000 ms style 2  // 'BOMB DA BASE: ACT I'
				while fading
					wait 0 ms
				end
				0417: start_mission M15_BOMBDABASEACTI
			end
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION21_LOOP
			end
			while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
				wait 0 ms
				if
					8256:   not is_player $PLAYER_CHAR defined
				then
					goto @FRANKIE_MISSION21_LOOP
				end
			end //while
		end
		00BC: print_now 'FRANGO' duration 5000 ms flag 1  // ~g~Salvatore wants you to help Toni deal with the Triads first!
		while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION21_LOOP
			end
		end //while
	end
end
goto @FRANKIE_MISSION21_LOOP


:FRANKIE_MISSION3_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $BOMB_DA_BASE_ACT_II_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined
	0038:   $ONMISSION == 0
then
	if
		00F6:   player $PLAYER_CHAR 0 1272.188 -92.875 13.75 radius 1.0 1.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'FM3' duration 15000 ms style 2  // 'BOMB DA BASE: ACT II'
			while fading
				wait 0 ms
			end
			0417: start_mission M16_BOMBDABASEACTII
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @FRANKIE_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1272.188 -92.875 13.75 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION3_LOOP
			end
		end //while
	end
end
goto @FRANKIE_MISSION3_LOOP


:FRANKIE_MISSION4_LOOP
0001: wait $WAIT_TIME ms
if or
	0038:   $FLAG_STAUNTON_OPEN == 1 
	0038:   $LAST_REQUESTS_COMPLETED == 1
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
	0038:   $FLAG_FRANKIE_SWITCHED_OFF == 0
then
	if or
		00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
		02B4:   player $PLAYER_CHAR in_cube_on_foot 1466.188 -175.0 50.0 1452.875 -172.0625 60.0 radius 11.5625 sphere 0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'FM4' duration 15000 ms style 2  // 'LAST REQUESTS'
			while fading
				wait 0 ms
			end
			0417: start_mission M17_LASTREQUESTS
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @FRANKIE_MISSION4_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @FRANKIE_MISSION4_LOOP
			end
		end //while
	end
end
goto @FRANKIE_MISSION4_LOOP


//#####################################################################################
//#####################################################################################
// END SALVATORE TRIGGERS / BEGIN ASUKA1 MONITORS
//#####################################################################################
//#####################################################################################

:ASUKA_MISSION1_LOOP
0001: wait $WAIT_TIME ms
if
	0038:   $SAYONARA_SALVATORE_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AM1' duration 15000 ms style 2  // 'SAYONARA SALVATORE'
			while fading
				wait 0 ms
			end
			0417: start_mission M18_SAYONARASALVATORE
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_MISSION1_LOOP
			end
		end //while
	end
end
goto @ASUKA_MISSION1_LOOP


:ASUKA_MISSION2_LOOP
0001: wait $WAIT_TIME ms
if
	0038:   $UNDER_SURVEILLANCE_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AM2' duration 15000 ms style 2  // 'UNDER SURVEILLANCE'
			while fading
				wait 0 ms
			end
			0417: start_mission M19_UNDERSURVEILLANCE
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_MISSION2_LOOP
			end
		end //while
	end
end
goto @ASUKA_MISSION2_LOOP


:ASUKA_MISSION3_LOOP
0001: wait $WAIT_TIME ms
if
	0038:   $PAPARAZZI_PURGE_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AM3' duration 15000 ms style 2  // 'PAPARAZZI PURGE'
			while fading
				wait 0 ms
			end
			0417: start_mission M20_PAPARAZZIPURGE
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_MISSION3_LOOP
			end
		end //while
	end
end
goto @ASUKA_MISSION3_LOOP


:ASUKA_MISSION4_LOOP
0001: wait $WAIT_TIME ms
if
	0038:   $PAYDAY_FOR_RAY_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AM4' duration 15000 ms style 2  // 'PAYDAY FOR RAY'
			while fading
				wait 0 ms
			end
			0417: start_mission M21_PAYDAYFORRAY
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_MISSION4_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 523.6875 -639.0 16.0625 radius 1.0 4.5 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_MISSION4_LOOP
			end
		end //while
	end
end
goto @ASUKA_MISSION4_LOOP

//#####################################################################################
//#####################################################################################
// END ASUKA1 MONITORS / BEGIN RAY MONITORS
//#####################################################################################
//#####################################################################################

:RAY_MISSION1_LOOP
wait 0 ms
if
	0038:   $SILENCE_THE_SNEAK_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then	
			0004: $RAYS_CUTSCENE_FLAG = 1
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'RM1' duration 15000 ms style 2  // 'SILENCE THE SNEAK'
			while fading
				wait 0 ms
			end
			0417: start_mission M22_SILENCETHESNEAK
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @RAY_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @RAY_MISSION1_LOOP
			end
		end //while
	end
end
goto @RAY_MISSION1_LOOP


:RAY_MISSION2_LOOP
0001: wait 0 ms
if
	0038:   $ARMS_SHORTAGE_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then	
			0004: $RAYS_CUTSCENE_FLAG = 1
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'RM2' duration 15000 ms style 2  // 'ARMS SHORTAGE'
			while fading
				wait 0 ms
			end
			0417: start_mission M23_ARMSSHORTAGE
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @RAY_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @RAY_MISSION2_LOOP
			end
		end //while
	end
end
goto @RAY_MISSION2_LOOP


:RAY_MISSION3_LOOP
0001: wait 0 ms
if
	0038:   $EVIDENCE_DASH_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then	
			0004: $RAYS_CUTSCENE_FLAG = 1
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'RM3' duration 15000 ms style 2  // 'EVIDENCE DASH'
			while fading
				wait 0 ms
			end
			0417: start_mission M24_EVIDENCEDASH
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @RAY_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 38.75 -725.375 22.75 radius 1.1875 1.1875 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @RAY_MISSION3_LOOP
			end
		end //while
	end
end
goto @RAY_MISSION3_LOOP

//#####################################################################################
//#####################################################################################
// END RAY MONITORS / BEGIN DONALD LOVE MONITORS
//#####################################################################################
//#####################################################################################

:LOVE_MISSION1_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $LIBERATOR_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LOVE1' duration 15000 ms style 2  // 'LIBERATOR'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M25_LIBERATOR ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LOVE_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LOVE_MISSION1_LOOP
			end
		end //while
	end
end
goto @LOVE_MISSION1_LOOP


:LOVE_MISSION2_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $WAKAGASHIRA_WIPEOUT_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LOVE2' duration 15000 ms style 2  // 'WAKA-GASHIRA WIPEOUT!'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M26_WAKAGASHIRAWIPEOUT ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LOVE_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LOVE_MISSION2_LOOP
			end
		end //while
	end
end
goto @LOVE_MISSION2_LOOP


:LOVE_MISSION3_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $A_DROP_IN_THE_OCEAN_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LOVE3' duration 15000 ms style 2  // 'A DROP IN THE OCEAN'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M27_ADROPINTHEOCEAN ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LOVE_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LOVE_MISSION3_LOOP
			end
		end //while
	end
end
goto @LOVE_MISSION3_LOOP

:LOVE_MISSION4_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $GRAND_THEFT_AERO_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'LOVE4' duration 15000 ms style 2  // 'GRAND THEFT AERO'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M28_GRANDTHEFTAERO ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @LOVE_MISSION4_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 87.25 -1548.563 28.25 radius 2.0 1.0 2.0 
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @LOVE_MISSION4_LOOP
			end
		end //while
	end
end
goto @LOVE_MISSION4_LOOP

//#####################################################################################
//#####################################################################################
// END DONALD LOVE MONITORS / BEGIN ASUKA2 MONITORS
//#####################################################################################
//#####################################################################################

:ASUKA_SUBURBAN_MISSION1_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $BAIT_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AS1' duration 15000 ms style 2  // 'BAIT'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M29_BAIT ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_SUBURBAN_MISSION1_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_SUBURBAN_MISSION1_LOOP
			end
		end //while
	end
end
goto @ASUKA_SUBURBAN_MISSION1_LOOP

:ASUKA_SUBURBAN_MISSION2_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $ESPRESSO_2_GO_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AS2' duration 15000 ms style 2  // 'ESPRESSO-2-GO!'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M30_ESPRESSO2GO ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_SUBURBAN_MISSION2_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_SUBURBAN_MISSION2_LOOP
			end
		end //while
	end
end
goto @ASUKA_SUBURBAN_MISSION2_LOOP

:ASUKA_SUBURBAN_MISSION3_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $SAM_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
	then
		if
			03EE:   player $PLAYER_CHAR controllable 
		then
			03EF: player $PLAYER_CHAR make_safe 
			0169: set_fade_color 0 0 0 
			016A: fade 0 for 1500 ms 
			03AF: set_streaming 0 
			00BA: print_big 'AS3' duration 15000 ms style 2  // 'S.A.M.'
			while fading
				wait 0 ms
			end
			// 0417: start_mission M31_SAM ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		end
		if
			8256:   not is_player $PLAYER_CHAR defined
		then
			goto @ASUKA_SUBURBAN_MISSION3_LOOP
		end
		while 00F6:   player $PLAYER_CHAR 0 367.25 -328.0625 19.5 radius 1.0 1.0 2.0
			wait 0 ms
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @ASUKA_SUBURBAN_MISSION3_LOOP
			end
		end //while
	end
end
goto @ASUKA_SUBURBAN_MISSION3_LOOP

//#####################################################################################
//#####################################################################################
// END ASUKA2 MONITORS / BEGIN THE EXCHANGE MONITOR
//#####################################################################################
//#####################################################################################

:CAT_MISSION1_LOOP
0001: wait $WAIT_TIME ms
end_thread ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if
	0038:   $THE_EXCHANGE_COMPLETED == 1 
then
	end_thread
end
if and
	0256:   is_player $PLAYER_CHAR defined 
	0038:   $ONMISSION == 0 
then
	if
		00F6:   player $PLAYER_CHAR 0 -362.75 246.5 60.0 radius 4.5 4.5 2.0 
	then
		if or
			0038:   $NICKED_HALF_A_MIL_BEFORE == 1
			010A:   player $PLAYER_CHAR money > 499999
		then
			if
				03EE:   player $PLAYER_CHAR controllable 
			then
				03EF: player $PLAYER_CHAR make_safe 
				0169: set_fade_color 0 0 0 
				016A: fade 0 for 1500 ms 
				03AF: set_streaming 0 
				00BA: print_big 'CAT2' duration 15000 ms style 2  // 'THE EXCHANGE'
				while fading
					wait 0 ms
				end
				// 0417: start_mission M32_THEEXCHANGE ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			end
			if
				8256:   not is_player $PLAYER_CHAR defined
			then
				goto @CAT_MISSION1_LOOP
			end
			while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
				wait 0 ms
				if
					8256:   not is_player $PLAYER_CHAR defined
				then
					goto @CAT_MISSION1_LOOP
				end
			end //while
		else
			if
				0038:   $NICKED_HALF_A_MIL_BEFORE == 0
			then
				00BC: print_now 'CAT_MON' duration 5000 ms flag 1  // ~g~You don't have enough money yet. You need $500,000.
			end
			while 00F6:   player $PLAYER_CHAR 0 1455.688 -187.25 55.5625 radius 1.0 1.0 2.0
				wait 0 ms
				if
					8256:   not is_player $PLAYER_CHAR defined
				then
					goto @CAT_MISSION1_LOOP
				end
			end //while
		end
	end
end
goto @CAT_MISSION1_LOOP

//#####################################################################################
//#####################################################################################
// END THE EXCHANGE MONITOR
//#####################################################################################
//#####################################################################################
