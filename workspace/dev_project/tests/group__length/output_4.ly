\version "2.12.0" 

\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					\clef treble 
					\time 9/8 
					\key c \major 
					\tempo 4 = 120 
					
% Section ----------

c''16 d''16 f''8 e''8 f''8 g''8 g''8 a''8 f''8 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''8 a''8 f''8 g''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 c'''16 b''16 f''8 g''8 a''8 g''8 f''8 c'''8 b''8 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 e''8 d''8 g''8 f''8 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
c'''8 g''8 a''8 b''8 e''8 f''8 e''8 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''8 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 g''8 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c'''8 g''8 a''8 b''8 e''8 f''8 e''16 f''16 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''16 a''16 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''16 f''16 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''16 a''16 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''16 b''16 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''16 b''16 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 g''16 a''16 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''16 f''16 f''8 c'''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''8 g''8 a''8 b''8 e''8 f''8 e''8 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''8 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 g''8 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c'''8 c'''16 c'''16 f''8 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''16 g''16 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''16 c''16 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''16 g''16 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''8 g''8 a''8 b''8 e''8 f''8 e''16 f''16 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''16 a''16 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''8 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 g''16 a''16 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''8 c'''8 f''8 r8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 r8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 r8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 r8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c''8 f''8 e''8 f''8 g''8 g''8 a''8 f''8 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''8 a''8 f''8 g''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 c'''8 f''8 g''8 a''8 g''8 f''8 c'''8 b''8 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 e''8 d''8 g''8 f''8 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''16 a''16 c'''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''16 a''16 b''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''16 b''16 b''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''16 b''16 b''8 d''8 c''8 d''8 f''8 e''8 f''8 a''8 g''16 a''16 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''16 a''16 g''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''16 f''16 c'''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''16 c''16 g''8 c'''8 
c'''8 c'''8 f''16 g''16 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''16 f''16 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''16 g''16 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''16 f''16 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''8 g''8 a''8 b''8 e''8 f''8 e''8 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''8 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 g''8 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c''8 f''8 e''8 f''16 e''16 g''8 g''16 g''16 a''8 f''8 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''8 a''8 f''8 g''8 f''8 a''16 g''16 g''8 f''8 g''8 a''8 b''8 c'''8 f''8 g''8 a''8 g''8 f''16 e''16 c'''8 b''8 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''16 e''16 e''8 d''8 g''8 f''8 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
c''8 f''8 e''8 f''8 g''8 g''8 a''8 f''8 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''8 a''8 f''8 g''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 c'''8 f''8 g''8 a''8 g''8 f''8 c'''8 b''8 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 e''8 d''8 g''8 f''8 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c''8 f''8 e''8 f''8 g''8 g''8 a''8 f''16 e''16 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''16 g''16 a''8 f''8 g''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 c'''8 f''8 g''8 a''8 g''8 f''8 c'''8 b''16 c'''16 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 e''8 d''8 g''8 f''16 e''16 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
r8 c'''16 b''16 f''8 g''16 a''16 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 r8 a''16 a''16 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 e''16 f''16 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 r8 f''16 g''16 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c''8 f''8 e''8 f''8 g''8 g''8 a''8 f''8 g''8 a''8 f''8 g''8 g''8 a''8 g''8 a''8 g''8 a''8 e''8 f''8 d''8 e''8 f''8 e''8 f''8 g''8 a''8 f''8 g''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 c'''8 f''8 g''8 a''8 g''8 f''8 c'''8 b''8 e''8 f''8 e''8 d''8 g''8 f''8 e''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 e''8 d''8 g''8 f''8 e''8 d''8 f''8 e''8 d''8 a''8 g''8 f''8 e''8 c''8 
c'''16 c'''16 c'''8 f''8 r8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 r8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 r8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 r8 e''8 b''8 a''8 g''8 d''8 c''16 d''16 d''8 f''8 r8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 r8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 r8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 r8 c''8 e''8 d''8 e''8 c'''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''8 a''8 g''16 g''16 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''16 c''16 c''8 d''8 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''8 f''8 g''16 a''16 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''8 g''8 a''16 b''16 b''8 e''8 f''8 e''8 b''8 a''8 g''8 a''8 b''8 b''8 g''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''16 a''16 f''8 e''8 a''8 g''8 f''8 d''8 c''8 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 e''8 d''8 a''8 g''8 a''8 b''8 a''8 b''16 a''16 f''8 g''8 a''8 g''8 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c'''8 c'''8 f''8 g''8 a''8 b''8 g''8 a''8 g''8 a''8 g''8 f''8 e''8 b''8 a''8 b''8 g''8 a''8 g''8 f''8 e''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 e''8 b''8 a''8 g''8 d''8 c''8 d''8 f''8 e''8 f''8 a''8 g''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 e''8 f''8 e''8 d''8 f''8 e''8 e''8 f''8 g''8 g''8 f''8 e''8 b'8 c''8 e''8 d''8 e''8 c'''8 
c'''16 b''16 g''8 a''8 b''8 e''8 f''8 e''8 b''8 a''8 g''8 a''8 b''16 a''16 b''8 g''8 a''8 b''8 g''8 a''8 g''16 a''16 f''8 e''16 f''16 f''8 e''8 f''8 e''8 b''8 a''8 b''8 a''8 g''8 f''8 e''8 a''8 g''8 f''8 d''8 c''16 d''16 g''8 f''8 g''8 f''8 g''8 a''8 b''8 e''8 f''8 e''8 f''16 e''16 e''8 e''8 d''8 a''8 g''8 a''8 b''16 a''16 a''8 b''16 a''16 f''8 g''8 a''8 g''8 b''8 a''8 b''8 g''8 a''8 b''8 e''8 f''8 e''8 f''8 c'''8 
c'''8 g''8 a''8 g''8 a''8 g''8 f''8 g''8 f''8 g''8 f''8 e''8 g''8 f''8 d'''8 c'''8 b''8 a''8 g''8 e''8 f''8 f''8 e''8 f''8 g''8 f''8 e''8 a''8 g''8 f''8 g''8 f''8 g''8 f''8 e''8 f''8 e''8 g''8 f''8 e''8 b''8 a''8 b''8 a''8 a''8 g''8 f''8 e''8 f''8 e''8 f''8 e''8 f''8 e''8 f''8 g''8 a''8 e''8 f''8 e''8 f''8 e''8 a''8 g''8 e''8 f''8 g''8 f''8 e''8 g''8 f''8 d''8 c''8 f''8 e''8 f''8 g''8 f''8 g''8 a''8 b''8 a''8 b''8 f''8 g''8 a''8 b''8 a''8 b''8 e''8 f''8 g''8 a''8 b''8 f''8 g''8 a''8 b''8 f''8 g''8 b'8 c''8 f''8 e''8 f''8 e''8 f''8 g''8 a''8 b''8 f''8 g''8 a''8 c''8 d''8 g''8 f''8 g''8 a''8 g''8 f''8 f''8 e''8 f''8 a''8 g''8 f''8 g''8 a''8 b''8 f''8 g''8 f''8 e''8 f''8 g''8 f''8 g''8 a''8 e''8 f''8 e''8 f''8 c'''8 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
