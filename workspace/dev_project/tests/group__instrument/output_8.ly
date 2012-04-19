\version "2.12.0" 

\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					\clef treble 
					\time 4/4 
					\key c \major 
					\tempo 4 = 120 
					
% Section ----------

e''4 c''4 d''4 b'4 c''4 b'4 a'4 a'4 g'4 b'4 a'4 g'4 a'4 b'4 e''4 a'4 e'4 f'4 d''4 a'4 d''4 c''4 c''4 d''4 b'4 c''4 b'4 b'4 d''4 c''4 d''4 e''4 
g'4 g'8 g'8 a'4 <a' c'' >4 b'4 f'8 g'8 c''4 g'4 c''4 b'8 a'8 c''4 b'4 a'4 b'8 a'8 e''4 d''4 e''4 a'8 a'8 b'4 <a' c'' e''>4 b'4 a'8 a'8 g'4 c''4 b'4 a'8 a'8 d''4 a'4 b'4 f'8 g'8 g'4 e'4 
e'4 f'4 a'8 g'8 g'4 g'4 a'4 d''4 g'4 a'4 g'4 c''4 a'4 d''4 e''4 f'8 g'8 d''4 e''4 c''4 b'4 g'4 a'4 g'4 f'4 c''4 b'4 a'4 g'8 g'8 c''4 g'4 a'4 f'4 g'4 
g'4 g'4 c''4 c''4 g'4 f'4 a'4 g'4 c''4 b'4 c''4 b'4 a'4 b'4 e''4 d''4 g''4 a'4 d''4 a'4 b'4 c''4 b'4 a'4 g'4 f'4 f''4 a'4 g'4 f'4 g'4 e'4 

				}
			}
			>>
		}
		\new Staff {
			\new Voice {
				{ 
					\clef bass 
					\time 4/4 
					\key c \major 
					\tempo 4 = 120 
					
% Section ----------

<c e g>1 <a, c e>1 <e, g, b,>1 <f, a, c>1 <c, e, g,>1 <g, b, d>1 <g, b, d>1 <b, d f>1 
<c, e, g,>1 <e, g, b,>1 <a, c e>1 <f, a, c>1 <c e g>1 <g, b, d>1 <e, g, b,>1 <e, g, b,>1 
<c, e, g,>1 <e, g, b,>1 <f, a, c>1 <g, b, d>1 <c e g>1 <f, a, c>1 <g, b, d>1 <e, g, b,>1 
<c, e, g,>1 <e, g, b,>1 <a, c e>1 <f, a, c>1 <c e g>1 <g, b, d>1 <e, g, b,>1 <e, g, b,>1 

				}
			}
		}
		>>

		\midi { }
		\layout { }
	}
}
