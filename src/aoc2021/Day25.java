package aoc2021;
public class Day25 implements Day{
    @Override
    public void run(){
        String input = """
                       >.v>vv>>..vv>..v.v......>v>>>v.>v.>..v...v......v>....>.vv..>>..>>vv.>..vv>>.>...v...v.....>.vv..>v...>.>>...v>.>>..vv....>>.v.v>v>v>vvv.vv
                       ...vvv.v.vvvv>.v.>..>.>>>v..>v...>..v..>.v>>.v..v.....>v..v.....>vv..vv...vv.v...vv>.v.>..v..v.>>.v>>>v.>>>.v..vv>>.....v.....v.v>>v......v
                       ..v>..v>.>>vvv>>...v.v..>>....>vv>.>v>v..>>>v...>.......>.>>>v.>>v..vvvv...v.v.v.v...>.vv.>>v>...>.....>>....v>..v...v.....v..v>>...>.vv.v>
                       ..>.....>v>.>vv.v..>>>.>...v>.>.v.>.>vvv....v...v..>.......>v>vvvv>>vv>>>.v>v....vv..v..>>.v>>v.>..vv..v.>..>...>....>.>.>.>..vvvv>.>>..>>.
                       ....>.>vv.>.>>.>..vvv.>vv......>...v.v..v..v>...v.v>>..>...vv..>>.>..>v>..>..>...vv.v..v>..v..vvvv..>.v>>.>..>>v.>v>v....>..v..v..>..v>...v
                       vvvvv.v.v.....v>.vvv.............>vv.vv>v.v..>>v.>..>v>v...>v>v.>vv.>.>......v>vv>.>.>v..v>>>.v>v>.>.v>>.>>.vv.v>>>vvv..>>>v...>.>..>.>.v.v
                       .v..v>..>.>v.vv.>v>v>.v.v>.>v>>v..>.....v..>>...>v>..>.>>.v>v>v.>>>.>...v>>>.v>>....>v...>.>.>.v>>v.v..>.>v..v>.vv.v..v>.>..v....v>.......v
                       ...>..v.v.v>v.>..>..>.>>>v..vvvv>...>.vv>>..v....>.....>.v>>>v.vv.>v>..v..>>>..vv..>.v..v>..vv.>>.v>v.v>.....vvv>v>v>....>>......v..vv.v>.v
                       ...v.v>..vv>.v.v>v..>.....>v..>>...>>v..v....>v.>v...v.>>..v>..>>..vv......v.>.>...v>.>v...v.v.v.......>..>.v>>..v..v>vv>.v>v.v>v....>..vv.
                       ....>.v..>..vv..>>.>.v>>>.....>>v..v..>.v>...>....vvvv>.v..>.....>..>>v>>>vv....>.v>>.>>.>.v>vv..v....v.>>>.v>.vv...>.>.>>vv.>>.v>....v...>
                       .>.v>>v>.>.......v.v>v>v..v...v..>>>v.vv.v.vv...v....v>.>>.v..>>>v.>>..vvv.v...v.>vv..>v.v...>..>>vvvv........>v.>....>.v.>...vv..>>....>.>
                       v>>.v...>v.>....>>.vv...>.>.v....>v.>..v.....v>.v>v.>>.....v>>>v...v..v..>v>.>>.>>.vv.>.v>v>>>>v.>>v.v.v...v....vv...>..v..v>v.>.v>....>>v.
                       .vv.v.v...>vv..vv.vv.vvv>.>....v....>.>..v..>.v>.vvv.vv>v..v.....v>.v..>..>..v>>...vv>..>...>>.........>..v...v>........v...>....>..>>>vv>.
                       .>v....>..>v>>.>>>...vv>.v.vv..v....>>>..v.>>>>v.v.>..vv.v.>v.v....>.>vvv.v..v...>vvv>.v.>vv.v..>>>.v>.>...>v.>..v>.vv...>....>>.>v>.vvv>.v
                       ..>.....>v.v..v>.vv...>..vv..v.v>.>.vv.....>.vv..>v>v..v.v.v....>...v.vv.....v.>...>>.>..vv.v.vvv....>v..vv.>....vvvv.v..>v.>...v>>..>>.>..
                       v.>>..>.vv.>.>....v.vvv.v...vv....vvv..>..v.vv..>>>...>.....v.>>....v.>>>.>>.vv.v.v.v>.v>>.>vvvvv>.>....v>>.>>.v.>.v...v.v>.....vvv>v..vvv>
                       ..v>v.v>.v..v..>.>vvv..vv.>..>v....>....>..>v>v..>>.v>v..v..>v.>>>>.>..v.v.vvv>.>....v.>v...v>>..>..>vv...v.>..>..vv..v.vv..>v.>..>>>>.>>.>
                       v.>vv..>..v.>vv>....>..v..v>v.vvvv.>..v.v.>v..>..>>....>.vvv>.>>>.v>.v..vvv....>.v.v>v.vv>vv>..v.>v..v..>>...>.....v.>>v.>>>vv>>>v.....v.>v
                       >>>v>.>>.v>>..>.>>>..>>>.>..v.v.>.......>v>vv>v>.v.vv>v>.>v..v.>v>vv.v.>....>vvv>v.v....v.vv>.v...>>v.>v>>>..vv...>..vv...v.v.v.vv....>>vvv
                       .>.v..>...>...vv.>v..>..v.>v..v.v>.>...v..vvv.v>>.>vvv>v.v.v>>..>.v>.>.v.vv...v.v>.vvv>..>.>>..vv>....>>.v.>..>...>.>>v.v.v..v.>>..v>.>..v.
                       .>>.v>>..v>>.>.....v>vv>>>v.....v....v>>..v.v>v.v>vv.>>....v>....>v..>>.......>.>.vv>...>.>>>..v.....>.v.>>>..>v..>>.vv>.>vvv>>vvv........v
                       ...>v>>vv..v.vv>v...v..v.....>>>>.v>>>v>v...>.>v..v.>.....v>..>.v..>>vv..v...>>>vv.>v..v.>>..>....>>.v..>>>.....v..v>>v.>...v>..>>.v.vv.>.v
                       .vvv...>.v>>..>.....>.>..v>.>.v...v>>..>.>>v..>...>.v.>vvvv....>.v....>.v.....vvvv>v.>.>v..>...v...>>>>...>vv.>>v.v>.v.v.>vv..v.>v.>v>>v.>.
                       >v.v>..v...>.>>>v.>.>.>v....>v...v.v.....>.>.vvv>.....vv>...vv>...>>.v.v.........>vv>v>..>.v.v>>v>v>.>..v......v>.>>>>>vv..>v.>...>>v..>v..
                       >..>v.vv..v>>>..>>>v>.>v.vv.vv.>>...v>.vvv..>...>>.vvv.v......v...vvv.v.vv.>.>.>>v>>..v>>...>>>v.v.>....v>.vvvv>>>.vv.v>..v...v.>.vv.v>.>v.
                       >>v.>>vv>v..v....v>v.>>.>...>.>v...>>..vv...vvvvvv...>..v>...>v.v..>>.>.v>.v.v.>>>.v.>v>>..>.vvv>vv..>v>>..v...>...v.v.>.v...vv...>v>.v..>>
                       .>.v......>>.v>.>..>..v>vv>...vv.>>v..>..vv.vv..>>..v..vvv..v..vvvv.>.>>......>>.v>>....v....>>.v.v...v.>......>..v>.v.>v>..v.>..v.vvv.v>>.
                       >..>.v>>.>vv...>>v>>...v.>v.v.>>v.>..>>..>.v..v.vvv>>..>>.v..>..v....v.......>>....vv>.....>>.>.vv......v>vv.v..v>v.......v..>>..v.v>>>v>>v
                       vvv..>..v>>..v>.v..>.>...>vvv.v.vvv....>.v.>>.>v.v.>.>v.>>vv>v>.v>>..>..>..v.>v.v>..v>>..>.vvv..>v.>.v.v.>vvvv.......v>.>.>..v>>>>>>..vv.>.
                       ....v..vv....>v.>>v.v.>.>v.>..>.>v.v.v>.v...>>v..>..>.vvvvv.>vv.>>>v.v.v..vv.>>.>.>.v.v>..v.>vv..>v..>.v>..>.>v.>v.v...>v.v.>v...v..>vv>v.>
                       .....>.v.v>>vv.......>.>>.vv>..v...v..>>>..>>v>>...>>..vv>>>..>...v>>>vv...v...>>...v..vv.>v..v>.v>..v..v.>>>.....vv..v...v...>vv..>..v>...
                       >.>v>.>>.>v>>v.>v.>>>....>.....>>..v>.v.vvvv..>..>v......>...>..vv...>vv.>>..vv..v....>.v..vvv..v>v>...>.v.....>..>.>.>>..>.....>....v>>.>>
                       vv.vv>>>...>>...>...>..>....v>v.v>.v>v>.>vv>..>.v..>v.>v.v..v..>v..>vv>..v.>.>v.v..>>>v>v.>v...>.vvv>.>>v.>>v>.v>..>..v>....>vv...>v.>>....
                       >vv.v>v>v>v.>v>v.>v..>vv.v>>.>...v>.v>...v>.vv>......>.v.>....v.vv..v>>...v......vv..>..>v.v>>>......v....>.>>....>.v>vvv.>>........>.vv...
                       vvv>......v>..>..v>..vv.>...>.>>.v..v>.v.v>v..>.....v..>..>.>>...vvv.>>.vv..v>>...>.>.v..>.>>v..>>.>>v.>.>.v>>>>v.v.v.v>.v....>v..v....v>>.
                       ...v.>vv..>.v.vv>..v..vv..v..v..v..v....>..>v.....v>....vv.>vv>v>...v.>..>...v.>v.>>.v>vv>v>...v>v>>...>..v>.>.>>vv>.v..>>>vvv>..v......>vv
                       v.v..>v.....>v..>vv...>>..>.v....v>v.v.v..v>>...>>.v.v>...>>>v...>>.>vv...v.v>v....v.v.v...>...vv..>....v>>v>v>.v....v.>>..>>>>>.>.>.>v>.>.
                       >.v>.vv.>..v...v>>...>vv....v>.>v>v>>v.v.>>v.>>..v...v.........vvv....>.>.....vv.v...>>v.vv.>>vv.>..>.v.>>...>v..v>v.v>>vvv>v.v.>v>.>v>...>
                       v..v.v.vv...>>.v>..v.....vv>>v>>>>v...v..v..>...>..v>..>>.>>>v...vv.v.v>..>.vv>....v>.v>..vv..>>vv..v..>...>>>v>v.v..>..>>vv..v>.v..v>v.v>>
                       v...v>v...>v>v>...>..v.>v...v..>>>v>..v.....vv..>....vvv>>v.......>..>>>.v>v.v.vv>.>>>>>vv>>>v.v.>>.v>>.>..v>v.v..>.>>.>v...v.v.>.>.>...>v>
                       .v.>v..v.v.>.v...>v...>..v>>>v..v>.>v.>v.>...>v.v..>.v>v>>v>.......>>..>v.>>.......>v>..v>.vvv..vvv.v.......>....>v>.....>...v>.v>>>.>v.>.v
                       vv....>v.....vvv.>.>vvv..>......v>>v.>v>.v.v.vv.v>v.v......v.>v>>vvv>v.v.>..v>vv.>.v........>...vv>v>......v.v>>>.>.v>>>v.vv...>>...v>.>..>
                       .v..vv.>.vv....vvv>.v.....v>v>.v>..vvv..v...>>..v..>>.>>v..v.>vv...>>>....vv>.v..v..vv..>.>>>...>>v..>..>.v>.vv>..v.>v...>.v>.>..>vv.v...vv
                       >....>>>v..v>v..>v......v>>>.>..>.vv.>...>.>>>>>v..>v>..>>v......v>v...v>...v...>.>.>.v.v>v...v...v>..v>>v...>.v>>...v...>>..>.>vv>..>..vv.
                       .v..v........v>.>.v>v.v>.>v.v.>>>..>..>.v>.>v>vv.v.>v....>.v.vv.>..>v>vv.>v.>..>.v..v..>v....v>vv....v.>>.>....v.>>.v...>v>..>...>...v.v>..
                       >>.v.>.v>.>vv...v>>v>..v.v.>v>.>....>>>..>.v>>v.v.....v.v.....>>...v>>.vv>......v>>>.>.>v>v........>....v>..v.>.>..>>.....>v>vvv.>..v.>>..v
                       .v.v..>>.vvvv..vv.>.v.v....>.v>..>v.>v.v>..v....>>>.>>>>.....>.v.v>>v>.v>>v>..>.vvvvv.v>vv.>.>v>v>>v.>........v>.v>.>>v..>.vv>>>>.>.v..>.>.
                       .v...>v.v..>v.>v.>>..vv>v>.>v>.v.>v....>.....v>...vv>v.v>v>..>v>.v.>...>>.v...>>vv>..v.>>v>......v...v.........v.>v>..vv..>.>..v......v>...
                       ......v..>v..>...v>.>vv>...v.v..v.vv.v.>..>v.vvvvv.>..vvvv..>vv...v>...v>>>.......vv.>.>.>>....>..v.>>..>>...>>>.>.vv.vv>v>>..v>.>..vv.....
                       ..>v.......v.>vvv>..v.v...v>.vvv.>v.v.>...v>v>>.>.....v>>vv.>.>...>v..>.v.vvv>>.vv.>v...>v.>..v.v.>.v>.>.>.v.v>v..>..>...vv>>vv.>>>..>v..vv
                       .>>.>v>>>....v>...>.v>v>>>.....v.v>..v.v..v.v>>v.v>v..>v..v>..v>v>.v.>>.v.>>v>.>v.vvv>..v.v.......v.>>.vv>>>>v...v.>>....>.>>vv>v..vvvv>..v
                       .....>...v..v.......v.vvvv>v.v..v..v>>v>..v.v...v>..>..>>v.....>>...v.vvv.>v.v...v>>..>v.>.vvv..vv..>vv......v.v..>..>...>v>>v.v..v....>..>
                       ....>..>....v....vv>..>..>v>.>>>v...>v>>..v>.>v...vv>.>.v.>.vv...v>.....v.....v.v..v..>..v>v....v.v>>>>..v...v.vv..>...v.>>..v>.v.v.>.>>.>.
                       .vv....v.>>>>v>..v..>vvvv.v.>v.vv.v>..v...>..v...>>>.v>.vv>.>>.v.>v.>..>v>...v..v.>...v>.v...>>.>...>....>..v.>...>>.>.v>.vv.v>v.vvv.>.>v>.
                       >vv..v>.v....v.vv..v>v.v...>.>...>v..v>>.vv.vv.>..>>.>..v...>v..>v>......>.>...>v>>vv.vv>v.v>vvv>...>......>>.....vvv....v>.vvvvv>>vvv>.>v>
                       >vv>v.....>.v.>.>v..v.v.>..>.>>...v.v.vvv.>..>>..v...>vv.>.v>.v.v>....v..v.>v>...>>.v...v.vv>.>v.v..v.v.>..>>.vv.v>vv...v>v..>..>>.vv>..vv.
                       .vv.vvv>..vv.>>...>..v...v..v.....>>..>>v..>vv.>...>>...v>>v.>.v..v>v>vv.>.v>v..v.>vv.v.>>>>v>...>..v..>>>.>..v>.>..vv..>>.v.>vv.vv.>>.>..v
                       v>..v>.v.....v......v..>...v>....v>v.>...v...>.>>.....>v....>v...vv>>v>>..>v.>>.v..v....v.vv..v>..v>v>.v.v.v>v....>..>vvv.vv>v>>..>.>.vv>.v
                       .>.>..>>....v>...v..>v.>v..>.v>v...>v>..>>v>...............>vv.>>.>..>..v.>.>.>..v>>v>.>.>>>>v>..v.>>>v.v.>v>v.v.....v>>..v>..v.>.....>v.v>
                       v..vvv..>>v.>v>...>....vvvv...>v..vv.v>.v>.v>>>.v.v.v..v..v.v.>..>>.v..v...v.v.....>.>..v..vv.......>v>.>>..vv>>>v.>.>..v..vv.vv.>.>v>.....
                       >......>.>.>v..v>vv.v..v>.>..v.......v...v..>v>>>>v>.v.v....v..>.>>v...v.vv..v..v>>>....v...v.>>>>vv..>..>v.......>.>>...>v>>v>..>v..v..v.>
                       >..v..v>.....>v>.>v...v.>>vv..v.vvv...v..v.....v.v.v>>..v..vv.v>v.v.v...>...>.>.....v>..>..vv>vv....>v.....>..>..v>>v.v...v.>>v....v>>>.>>>
                       >v>>>v.....v.v.v.v.>v.>.>.v.......vv.>>.vv...>...vv..v..>.v..>.>>...vvv.>vv>..vv.v.>>>v>>vvvv>>v.>.....>>v....v..v....>.v>.>.>>v>.v>..>.>v.
                       v...vvvv...vv>.v.v...vvv>.v>>...v..........>.v>>..>v..>>v..v.v>.v.vv.>.vv...v....v..>...>..>..>v.>vv>v.vv>.....vvv.vv......>.v.......v.>v.>
                       ...v..>v..>...>>>vv..vv>>.>.>>vvv..vvv..vv.v>v.v..>....>>..>.v.v>..>>>v>>.v...v.>.v...vv..>>>.v>..>..v>>v>..>..>..vv..>..>.vv..v..>>.v.v...
                       v>>>.vv>.vv.>v......v..>v..>>..v>v..v..vv.>>.>>v....vv>v>.>>.v>>>>.v>....vv>>v.>...>v.>>vv.....>....v..vv.v.>.>>.v.>v.vv.>>.v...>vv.v>>>...
                       >vv.>v..>..>>.>>>.v...v...v.>.v..v>..>>>v>..v.v.>.>..>..>.>>>>.>v...>.>...>.....v..vvvv.vv>>....v>..v..vv>..v.....>>...>.v...>.>>.v...vv...
                       v>>>...v.vv..vv..vvv...>.>v.v.>>...>...>.v...>v>v.>>>..vv>>v.>>>.....vv.>..>.>v>>v>>..>.>>.v.v.>.>.v.>>..>>>..v.>...v...vv.v>.v>.>.......v.
                       .....>..>..>>.....>.>>v.v>>..>>v>>.v..v..vvvv.>.v.v...>..v.v>....vv>>.>.>v..v..v...v..vv>>..v....>..>.v...v.v....v.....vv>>>>v......>..>.vv
                       >..>..v.v>.>>v>...>v..vv>.vv>v.>vvvvv>.v.v.v...v.>v.>..v...>.>.>.v>>.>.....>>.>.v.v>.v....>.vv.v.>.>v>>v.v>>>>.>v.>>..>vv.vv..v>v.>v.v.v.v>
                       ...vvv>>v>>.v>....>.v.vv..>vvvv.>.>>.v.>>.v....>..>v.>vvvvv.....v>>v..>>v..>..vv..>vvv>.>>>..>.v...vvvv.v..v..v..vvv.v....>v...>.v.>......>
                       >..v.....>.>.>.>..vvv.>>>.....>.vv>.v>.v>.>.>>>..v..vv.v.>vv..v>..>.v.v.v..vv..>.>.>.v..vv.vv...vv>v>.>>.>>>vv....>..>v>.>.v>.>>....v...>..
                       ...v.v..>>.v..v.v>.v>>....vvv.>v.....>.v>>.>>...>.>....>..>>>...v>vv.v>..v>v.>>v...>v>.v>v>>>>.vv...v..>>..>.>...>..>.vv...>.>..vvvv.>..>.v
                       >v.v.v..v.v.v..vv.>.>...>.v>>.>.>vv>.>>v>.>>.v.>.v.v>..v.vv.>.v...v..vvv...vv..>.>>.>v.vv...>vv>.v>>>.>>..>...>.>v..v>v>..v..v.v...v.>v>.vv
                       ..v.v...v....v..>vv>vv>v.>vv>....>.>>.v>..v.>v...>>>v.>...>...>..>.>...vv..v>v.>>>v...>...v.v.>...vv....vv.v.>.vv...>v.v..vv..>v.....>>>vv.
                       >.>.>>>..>>>.>>>v>...>.v>vv.....vv>..v...>.v.v>>v.>>........>>.v>v>v.....vv......>.v.>.>>>v>..v>.v...v..vv>.v.v>>....>.v>...>..v>v>v>...>..
                       v>>vv.>>>>>v>>.>v.vv>.>.>.v>vv..>v.>vv.>v....>.>...>>>v..vvv.....vv..>v...vvv..>v..vv>.>>>>.>...>>...>>>.v....v.vv>..vv.v..>v...v.>.v.vv..>
                       >.>>>v........>.v>...v>..>.>.>>vv..>..vv.>.v..v>vv>..>...v..>.>v>vvvv>>v.>>.>..v..>v..v.>>.v>v>..vv>.>v.>.....>.v>>.vv.v..>..>....v.v....>.
                       .v>...>.v.>.>.>v.>>......vv.v>>.v>.v...>>>...v..v..>.....>.v.vv.v..v.v>..v>......>.v.>>..vvv.v.>v.>..v>vvvv>>.v.v.v.v......v...v.v..>v...>v
                       >>.vv..>.v.>>>>>..v...>.>.v.>>.>vvv.>>>.>..>v......>>v.>.>.v>>.v...>v>v..v..vv..>....v..v...>>...>v.v.>>..v>v...v..v>..>.v.>.>.>v.>.>.>.>v>
                       .v.>.>>vv..>...>..v.v.>.v>v>v>....>>>>.>>....v.v>v.>v...v.v..>v>>.>.>..v.>>.vv.vvv.v..v>>>>v...>v>>.>......v...>.>....vvv.>..>.>...>..>.>vv
                       .vv...v.v.>v>...v.vv..vvv>>.......>.>....>vv.v.......>vv>v.>....>.v>.>.>.v.v.v..v.v.>...v>..v.vv...>v..>v>v.>v>.v.vv..v>.v..v.v>....vv.vvv>
                       vv.>....vv.v>.v.v.vv..>v.vv>..v.v>..v.vv.v..v.v.>.>.....v>.>....v>.>v...vv>.v>.v>...v>>..v>>....vv.>....v>.>>...vv>..>.>...v..>......v.vvvv
                       ..v.>vvv.>.v.>>.>.v.>.v>>...>>..v>>vv>.vv.vv>.v.vv>>.vv.v>..vv>>v....v.>...v>>..v..>v.>>v>v.>...v......v...>v.>........v.>>...>vv...>.>v.v.
                       >.>>v>.v>>>..>v..>v>>v.>.vvv..v.>..>.v..v.........v>v.>..>v>.>v.>v>.vv....v..vvv........>>.>>.>>>>..>.vv>..v...>.>....vv>v...>v.vv>>>>>....
                       .vvvv>..v>.v.v.....v>vv..v.vv>vv>v.v.>v...v>>v..>..>.vv>vvv>.v..>v>vv>......v>.>.v.v...vvv.v>>>.>..>vv>>.v.>v.>...>>.v>>v>>.v.v>>.v>v..>.v.
                       v.v...vvvv..v.v.>v>...v>.>..vv.vvv>>>....>v.....v>.>vvvv>vv>>.>.v>>.v.v..>..>v>>>vvv>.>>..>.>>..>vv.>v.v...vv.>v>vv..v.>>>.>v>..v..vv>....>
                       .vv..>vv..>..>.>.v>.>.>>..>..>.>...>>v.>>.>.>vvv>..>v.>.>v......>>.>....>.v.>>vv.v.>vv....>vv..v.>v.v.>v>>.vv..>.v>>..v.......>.v>>.>..>v.>
                       >v>..>.v>>.>.v..>vvv....v.>..>.vv.>...v>>..>..v..vvv>v>>.v.vv>>>v>>>>>.v.>vv.>..v>.>...vv.vvvv>vv.>vv..vvv..v...>.>.v..>..>v>>>v....v>>.>.>
                       v.v.vv>.>vv.>>....vvv.v>.>.>..v.>.vv..v>>..>>v>>.vv..v..>vv>>.>.>..>>.v>..>..vvv.>..vv.....v>>>.>.v..v.....>..v>>..v.vvv.>.vv....>>v..v>.v.
                       >>>...v...v.vv..v..vv..>.>..v....vv...>vv>>>v..v>..>v.....>vv.v..vv>.vvv..vv>.v>v>.v....>v...>.vv..>....v.>vv>.>vv..>.vv>...>v.>v..>v>..>.>
                       ..>.....>.>..>v.>..v>>.v>.>....>..>....>vv.v...v..>>v..>.>.>>.>....v.>>v.....>.>....v.v>..v.....>.>.....v>>.>v>.v.vv.v>v>...>.vv>..vv...v>.
                       .v.....>>v...>vv>>v.v..>..>.>v>.>.>>>vv.v>.v>v......>.v....>.>>vv..>v..>..v...v.>..v>v..>..v...>.>.v>.v>..v.....vv.vvv>..v>v...vv.>.>...>.>
                       >.......>..v.v...v>v.v..v>v.vv..>.>>>...v..v..>>>.v..>..v>..>..v..>.>.>.v..>>.v>.v..>vv>v.v.vv>..>.v..vv>vv.v.......>.v.>...>vv..>.vv.....>
                       .>.>..>.>vv.>v.vvvv.>>>.v.>.v..vvv>>>>...v..v>v..v.>.>.v.v.vv....vv......vv..>.>>>>..vv..>>v>..v>>>>v.>>..>.>v.v.>...>>>..v.v.>.vv.>vv.v>..
                       ..v...v>...>..>.>...>v.>v.........v..>>v....>>>.v.>v>.v..v>>>v....vv..>..>v.v.>.>....v..vvvvv..v.v.vv...v.>vv...v>>>>..vvvv..>>>v..>vv>...v
                       .>v>.>.>.v>>.>>..v>...vv.......>..>...v.>v.>.v>.>vv>>.v.v.vv...v>....vv>v.v...>v..v.v.v>>v>v>>>......>v..>...vv..>.>.>..v.>>>v....>v.>.>.vv
                       >v....v.v..v...>>.>v.>>.v>v>....>>.v>>v.v>>v>vv>v.>>..>..>v....>vvv.......v..v>.>>v.>>v.>...v>..v..>vv>v.v>.v......v.>.vv>>>.......>v....vv
                       .v>>.>>>.>.v.>...v..>>>.v>v.>.vvv>.>..>..v..>v.v..>.>...>vv.v.v.>..>>v>.>v>.v...>>>>v.vv.vv>>>v.v.>vvvvv>>>..v>>....vv>v.>v>.v..v...v..v>v>
                       ...vv.>......v..>v..>..>.>.v>.>>.vvv>>>v>v..>.vv....>>v>..v..v>.v>>.>>.>..>v.>>.v>.>.>.....v..v..v.>>....>v..>.v......v>.v..>>vv...>vvv.vvv
                       v.>......v>.>.v..>vv>v>.>v>...v..v>>v.vv....v>vvv>.v.v....v.v>....>.>v.vv.v>>>.>>>>v>>v...v...v..v>.v>>vvv>vv.v.v..v.>v..vv>.v.>.v..>vv.>..
                       ..>>>v>>...>.>.....>v>vv>v...>v.v>v>>.v>>>v>..>v.....vvvv...v..>>.v.v>..>.>.>vv...vv...>>.>....>>v.>v.>.>...>v.....vv...v>....>v....v..v>..
                       ..>v..vv.>...v..v.v..v.v>vv......vv.v.....v.>....>...>v......v...v>>...>..>......>>.>>..vv>...v.>.v.v>>>v.....>>.>>...vv.>.>.>vvv...>>>.v..
                       ......v.>>.v>>vvv.v>..>v.>.vv....>v>>..>vv>>>.>.>..>....v..>vv.v..>v>..>..v..>v.>.>.......>>>v.vvv...>..v....>>v.>>>....>v..>.v>>>..vv>>v.>
                       .>....v.vvvvv>>v..v...vv.>.>.v.>>...>.>.>v.>v...v.v>.>.>>>..vv>.v>vv..v.....v.v.v.>>vv>v>>.v....v...v>v...v>v.v>>..>...>v.v.v.v...>v.v..v.v
                       ...>...>.vvv.v.>..>v>..>v.>>.>v..v.vvvv...v..v.v.>vv.vv.v.>...v...vv....>v>.v.>>v.v.>>>v.v.>...v>>..>v.>v..>......v>>.>..v.v>>v>v..>..>>.>.
                       .v..v.v.v>.>...vv.v...>.>vvv>...vv......>v.v......v...>..v...>..v>..vv>v>>v>>.v>...vv>.>.v.>vv>v..>v.>.v..v.>..>..>...v.>v.v..v.>>vv.vv>..>
                       .v...v...>vv...>v.v>>v.v.>v>.v>>v...>vv......>......>..v.vv...v.>>..v..v>>.v.v>v.>>.vv>>..>..vvv...>.v.>>v...vv>v...>.>.v.....vvv.vvvvv>.v.
                       v>>>>..>.v>>>v>...v..>..>>>v>>..v>.>vv...>v>>.>.v.....>v..>vv...>v.>v....>vv>...vvv.....v..>vv.v.v.v>.>v....v....vvv>.>>..>v.....>v>.v.v>..
                       .>..v..>>v.vvvv>>.>>>vvvv.>>.v....>.>>.>vv...>.....v..v..v.vvv..>>..>.vv>v...v..v>>v>>.v.vvv>v>.>.v>...v..v.vv....>>.>.......>..v.>>v>...v>
                       .>..v.vv>.v.>.v.>v.>v..v>..>.>.vvv..v>>..>.>v.vv>v....>v>..>.v>v>..>v........v.>vv...>.vvv>......>>.v.v...>v...v..>v...>v>.v..>.>>>.>.>....
                       ...>...vv.>v>..>.>.v.v>>>>>>vv>...>v.>.>v...>>.>.>v..v.v.>......v.vvv..>...v>>v>..vv>.....>..>>v...>>>..>.>..v..v>v.vv.>...v.v>>.>v....>>..
                       ....>.vv.v....v.v>.v>v.vv...v>.....v>.>v.vv.>v.>..>vv..v.vv..v>.v>....>..vv>v>v>v..>>.v....v.v>..>..v.>>..vv>>v.........>v>.>>.v.>..>.vv>..
                       >.v..v.>...v...v>>v>>.v.vv>>>........>v>>.vv.v>.>.>.>..v....>vv.>.>....v.>..>.v.v.>..v.v.>v>v.>>>..>>.>.vv>v.>>>.........>..v>v.v.>>v.>>>.>
                       ..v..v..v.v>...v>v..>....>........>v.v>v.>>..v...vvv....>.>>v....>.>..>.>...vv..>>v>v>.>>v..>>...>....vvvv>...v.v.v.>...>>........>.>...>..
                       ...>.vv.>>....>.>.v>...>>>>>v..v....>..v.>..v...>....v..>.v>.v>vv.>v>....>...>.vv..vvv.>vvv>>.vv.>>>.v.......v.>>>>..>...v.v..v...v.v..>v>v
                       vv....>..vv>>>>vv..>>>.>....v..vv....v>..vv.>.>>..vv.>.v.....>.>.v>...>.v.>v..>.>..>>>..>.vv>>v>.v>.>>.....>.>.v.>..>..vv.>....vv>>>>>>.v>v
                       .v>>v.vv......v.>>v....>.>.>v..v>v..>>.>>>.vvv>...>...v..>..>>.vv>.>...>>..>>.>.v..>>v..>>..>.v.v>v>.>......>v>v.>.v>v>..v>......v...>v..vv
                       .v.v.v..v.v..vv>v..........>....vv>v>.v.v>...v>v>>.....v...vv>..vvv>.>....v.v...>>.v....vvv>.vv....>.>>..v.>.vvv>..v..v.>.>..>v....>.>>>>>.
                       vv..v.........>>v.v.v.>vv>>.v.vv....>v.>>>>v...>>vv.>.v>...vvvvv..>.>>vv.>v>vv...>..v..vv>..>>>v>.v.>vv.>.>.>..>..vv..v>..>>.v..>.>vvv.>...
                       .vvv>>vvv.>>..>...>v>>.vv.>>..>>v.vv.vvvv.v>vvv.>...>>....>..v..v>>v.v..>>>...>.v.v>vv...>>..vvvv.>v>v.v..>.>...v..v>v.v>..>...vv>..>....>.
                       .v>.>.>>>.>.v.vvvv>.>v>..>.vv.>.>>...vvv.v.....v>..>.>.>vvvv>>.>.>.v.v>>vvv>..>..vvv>>vv>>.v..vv>>v...>>>..v..>>..>vv....>>.v>.....vv......
                       .v.>v.>vv.v.v..v>....vv.>.v.v>>>.......v.>.>>.v...v>.>...>....vvv>.vv>v.....v...v..>..>....vv.>.....v>.v.>.>..>vvv.v.>..vvv.>vv...v......v>
                       v>....v>>.v>.vv>vv.>.>..>>...>v>..v..v......>v>...v..v>..>.>....>.>.v.v...v.v>>.vv.vv..>.v>...>>..>.>v.....v..>>..>>>..v..>...>v.v.v.>>.v..
                       >..vv.v.>.....>...>v>>>...v>>.vvv..>.>.>...vv>>....>.>.>v>>>.v..>v>vvvv>..v>v.v..>v>.v>>>.>>..v.v.>...v..v.v.>>.>.vv..v.vv>v..v......>v.v>.
                       vv.>....>.>v..v>.vv.>...>.......v>.>v.>.>.....v.v.>.>.>v.>>vv...>.v>.v...vv>.v.vv.v..>vv.>...v>.>..>>>v>.>v..>v.......>>v>v.v....v..v>.>.>.
                       v.>>..>vv.v>.>....v..>>>.>>...>.......>v.v.>>.>.>..v.v..>>v.>v.vv...>>......vv>>.v.v>..v>.>..>....v>>.>v...v.vv.>.>>.>>>vv>...v.>...v......
                       .....v.>.v....v...>..v>v..>.v>..>.>v.>>>vv.>>v>.vv.>....>v.>.v..vvv>.>.>.vv.>...v>>.>.vv>.v.....>v..>v.v...>.>>v...v>vv.v.v.v>>>v>...>.>.>>
                       v.>....v>>..>v.>.vv.>vv.......v..>.>v.>.>.v..v.v>vv.....v....vv.>>..v.>v...v>.v>.vvv.....>>v>.>.>v............v.>.....>.>...>>.....>.v.>>v.
                       ...>>>>>v..>...v...>.vv.>..vv.v..>.>>..vv.v.>>.>>....v.>vv>..v.>>>.v.>.>.v>..vvvvvv..v>>>..>>...v>.>v..vv........>>v>>.>v>..>v>.>..>...v.v.
                       vv.>v>v>>>v.v.v.>v>>vv..v>.>v.>..v>....>.vvv........>>v>..>v>.v..v.v>v>.v>.vv.vv>v>>v..v.v>.v>>v...>>.>>>...>>>v.vvv>.....>...v.vv>..>v>.v.
                       ...v...v..v....v.>v.>v.v>..>vvv...vvv..>>v.>.>.>.v.....v>vv.>v.v>>.vvv.v>v.vv.vvvv..>.>...vv.>....vv.>v.>..v......vv>.v>.>..>v.v>v...vv.v.v
                       vvv>.v>......v.v.v..vv.>v..vv>.....v.>.vvvv>.v..>v..v>v>vv>.>.vvv.>>v....v>>>v>vv>v.......>....>.>...v..v.v....v..>>v...>>>.v.v..v..>v>vv..
                       >>v..v..vv.vv>.>...v>>>.vvv>>>v..v>>.>>v..>.>>.v.v.v..v.>v..v.>.>v>>.v...>v>>....>vvv>>v>v>.>.v...v.v.>>>....>.>>v>...v.>.>....>.vv.>...v.>
                       v.vv.......vv.>......v>....v..>v......vv>.v.....v.....>..v...>v>.vvv.vv.....vv>.v>v>..v....>v....>>....v..vv>.v..>>.>>...>.>.vv...v>>..vv.v
                       v..>>>...>>.v>>...>..>.v>v>vv.>......vv...>>...>v>....>v>.>.>.v>.>....v..v.v.........>>>.....v.vv.....>v>>v>vv.>>..v.>v>...v>>v.vv.v.>.>.>v
                       ...v.vv>..>vv...v>.>v.v>v...vv.>v..v.....v...>....>>>>>..v.v>...>..>.vvv.vvvv>..>.>.v>.vvvvv...v.>v....>.v>vvv..v.v...>.v>vv>>..v.....v>>>.""";
//        input = "v...>>.vv>\n" +
//".vv>>.vv..\n" +
//">>.>v>...v\n" +
//">>v>>.>.v.\n" +
//"v>v.vv.v..\n" +
//">.>>..v...\n" +
//".vv..>.>v.\n" +
//"v.v..>>v.v\n" +
//"....v..v.>";
        String[] split = input.split("\n");
        Cucumber[][] map = new Cucumber[split[0].length()][split.length];
        for(int y = 0; y<split.length; y++){
            String line = split[y];
            for(int x = 0; x<line.length(); x++){
                char c = line.charAt(x);
                if(c=='.')map[x][y] = Cucumber.NONE;
                if(c=='v')map[x][y] = Cucumber.SOUTH;
                if(c=='>')map[x][y] = Cucumber.EAST;
            }
        }
        System.out.println("Part one");
        int moved = 0;
        int step = 0;
//        printMap(map);
        do{
            moved = 0;
            Cucumber[][] newMap = new Cucumber[map.length][map[0].length];
            for(int x = 0; x<map.length; x++){
                Cucumber[] cucumbers = map[x];
                for(int y = 0; y<cucumbers.length; y++){
                    Cucumber cucumber = cucumbers[y];
                    if(newMap[x][y]!=null)continue;
                    if(cucumber!=Cucumber.EAST){
                        newMap[x][y] = map[x][y];
                        continue;
                    }
                    int targetX = x+1;
                    if(targetX==map.length)targetX = 0;
                    if(map[targetX][y]==Cucumber.NONE){
                        moved++;
                        newMap[targetX][y] = map[x][y];
                        newMap[x][y] = Cucumber.NONE;
                    }
                    else newMap[x][y] = map[x][y];
                }
            }
            map = newMap;
            newMap = new Cucumber[map.length][map[0].length];
            for(int x = 0; x<map.length; x++){
                Cucumber[] cucumbers = map[x];
                for(int y = 0; y<cucumbers.length; y++){
                    Cucumber cucumber = cucumbers[y];
                    if(newMap[x][y]!=null)continue;
                    if(cucumber!=Cucumber.SOUTH){
                        newMap[x][y] = map[x][y];
                        continue;
                    }
                    int targetY = y+1;
                    if(targetY==cucumbers.length)targetY = 0;
                    if(map[x][targetY]==Cucumber.NONE){
                        moved++;
                        newMap[x][targetY] = map[x][y];
                        newMap[x][y] = Cucumber.NONE;
                    }
                    else newMap[x][y] = map[x][y];
                }
            }
            map = newMap;
            step++;
            System.out.println("Step "+step+"; "+moved+" movement");
//            printMap(map);
        }while(moved>0);
        System.out.println(step);
    }
    private void printMap(Cucumber[][] map){
        for(int y = 0; y<map[0].length; y++){
            for(int x = 0; x<map.length; x++){
                System.out.print(map[x][y]==null?'?':(map[x][y]==Cucumber.NONE?'.':(map[x][y]==Cucumber.EAST?">":"v")));
            }
            System.out.println();
        }
            System.out.println();
    }
    private static enum Cucumber{
        NONE,EAST,SOUTH;
    }
}