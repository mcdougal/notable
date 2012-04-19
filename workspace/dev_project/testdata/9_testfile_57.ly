\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Piano
					% measures: 90
					% difficulty: 57
					
					\ignore
					\clef treble
					\time 4/4
					\key gis \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
gis'8 ais'8 ais'4 f''8 f''8 dis''4 f''8 g''8 g''4 gis''8 g''8 <ais'' cis''' f'''>4 c'''8 cis'''8 cis'''4 dis'''8 f'''8 g'''4 gis'''8 gis'''8 f'''4 g'''8 gis'''8 f'''4 dis'''8 cis'''8 g'''4 f'''8 dis'''8 <f''' gis''' c''''>4 c''8 ais'8 ais'4 dis''8 cis''8 gis'4 
% Phrase:
gis'4 <ais' cis'' f''>8 <c'' dis'' g''>8 f''8 f''8 dis''4 f''4 g''8 gis''8 gis''4 ais''4 c'''4 <cis''' f''' gis'''>8 <cis''' f''' gis'''>8 dis'''8 cis'''8 g'''4 gis'''4 f'''8 g'''8 g'''4 f'''4 dis'''4 <g''' ais''' >8 <gis''' c'''' >8 f'''8 g'''8 f'''4 c''4 ais'8 c''8 dis''4 gis'4 
% Phrase:
gis'4 ais'4 f''8 f''8 dis''8 cis''8 cis''4 dis''4 f''4 g''8 gis''8 gis''4 ais''4 f''8 dis''8 c'''8 cis'''8 cis'''4 gis''4 ais''8 c'''8 gis''8 ais''8 g''4 f''4 dis''8 dis''8 cis''8 c''8 c''4 ais'4 dis''4 gis'8 ais'8 

% Section ----------

% Phrase:
gis'8 g'8 c''4 ais'4 dis''8 f''8 cis''4 cis''4 dis''4 f''4 g''8 f''8 gis''4 ais''4 cis'''4 dis'''4 ais''4 c'''4 ais''8 c'''8 gis''8 ais''8 g''4 gis''4 g''4 cis''4 c''4 ais'4 gis'4 
% Phrase:
<cis''' f''' gis'''>4 c'''8 ais''8 f''8 dis''8 <g'' ais'' cis'''>4 f''4 dis''4 f''8 g''8 cis''4 <dis'' g'' ais''>4 cis''8 c''8 c''8 ais'8 ais'4 gis'4 cis''8 c''8 c''8 cis''8 <cis'' f'' gis''>4 <ais' cis'' f''>4 c''8 ais'8 gis''8 ais''8 g''4 gis''4 ais''4 c'''8 c'''8 cis'''4 
% Phrase:
cis'''8 cis'''8 c'''8 ais''8 f''8 dis''8 g''4 f''8 g''8 dis''8 cis''8 f''4 cis''4 dis''8 cis''8 cis''8 c''8 c''4 ais'4 gis'8 g'8 cis''8 dis''8 c''8 ais'8 cis''4 ais'8 c''8 c''8 ais'8 gis''4 g''4 gis''8 g''8 ais''8 c'''8 c'''4 cis'''4 

% Section ----------

% Phrase:
cis'''8 c'''8 ais''4 c'''4 gis''4 ais''8 gis''8 gis''4 g''4 gis''4 dis''8 cis''8 cis''4 dis''4 ais'4 gis'8 g'8 c''4 ais'4 c''4 ais'8 c''8 c''4 ais'4 c''4 f''8 dis''8 g''4 c'''4 cis'''4 
% Phrase:
cis'''8 c'''8 gis''4 ais''8 c'''8 g''4 gis''4 g''4 f''4 dis''4 cis''8 dis''8 c''4 g''8 gis''8 ais'4 gis'4 c''4 ais'4 dis''4 cis''8 c''8 dis''4 f''8 dis''8 g''4 gis''4 ais''4 c'''4 cis'''4 
% Phrase:
gis'''8 g'''8 dis'''4 f'''4 g'''8 f'''8 dis'''8 dis'''8 f'''4 r4 cis'''4 dis''8 f''8 cis''4 c''4 ais'4 gis'8 ais'8 cis''4 c''4 cis''8 c''8 dis''8 dis''8 f''4 r4 cis''4 c'''8 c'''8 f'''4 dis'''4 gis'''4 

% Section ----------

% Phrase:
dis'''8 dis'''8 <cis''' f''' gis'''>4 dis'''8 f'''8 ais''4 gis''8 gis''8 ais''4 gis''4 g''4 f''4 <dis'' g'' ais''>4 cis''4 ais'4 gis'8 ais'8 c''4 cis''8 cis''8 cis''4 c''8 c''8 <cis'' f'' gis''>4 g''4 f''4 g''4 c'''4 ais''4 dis'''4 
% Phrase:
gis'''4 g'''4 f'''4 dis'''8 f'''8 f'''4 dis'''4 cis'''4 cis'''8 dis'''8 dis''4 cis''4 cis''4 ais'8 c''8 gis'4 c''4 ais'4 cis''8 c''8 c''4 cis''4 dis''4 f''8 g''8 dis'''4 f'''4 g'''4 gis'''8 ais'''8 
% Phrase:
dis'''4 cis'''8 c'''8 c'''4 cis'''4 gis''4 ais''8 gis''8 gis''4 g''4 f''4 dis''8 cis''8 cis''4 ais'4 gis'4 c''8 cis''8 ais'4 f''4 c''4 cis''8 c''8 g''4 f''4 g''4 c'''8 ais''8 ais''4 dis'''4 

% Section ----------

% Phrase:
dis'''4 cis'''4 c'''4 ais''8 c'''8 gis''4 ais''4 gis''4 g''4 f''4 dis''4 cis''4 ais'8 c''8 gis'4 c''4 ais'4 cis''4 c''4 cis''4 g''4 f''8 dis''8 g''4 c'''4 ais''4 dis'''4 
% Phrase:
gis'''4 g'''8 g'''8 f'''4 dis'''4 f'''4 dis'''4 cis'''4 cis'''4 dis''4 cis''8 c''8 cis''4 ais'4 gis'4 c''4 ais'4 cis''4 c''4 cis''8 c''8 dis''4 f''4 dis'''4 f'''4 g'''4 gis'''4 
% Phrase:
dis'''8 f'''8 cis'''4 c'''4 ais''4 gis''4 ais''4 gis''8 ais''8 g''4 f''8 g''8 dis''4 cis''8 dis''8 ais'4 gis'4 c''4 ais'4 cis''4 c''8 cis''8 cis''4 g''4 f''4 g''4 c'''4 ais''8 gis''8 dis'''4 

				}
			}
			>>
		}
		\new Staff {
			\new Voice {
				{ 
					\clef bass
					\time 4/4
					\key gis \major 
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
<gis, c dis>2 <f gis c'>2 <f gis c'>2 <gis c' dis'>2 <c' dis' g'>2 <dis' g' ais'>2 <gis' c'' dis''>2 <g' ais' cis''>2 <dis' g' ais'>2 <f' gis' c''>2 <c dis g>2 <dis g ais>2 
% Phrase:
<gis, c dis>2 <f gis c'>2 <f gis c'>2 <gis c' dis'>2 <c' dis' g'>2 <dis' g' ais'>2 <gis' c'' dis''>2 <g' ais' cis''>2 <dis' g' ais'>2 <f' gis' c''>2 <c dis g>2 <dis g ais>2 
% Phrase:
<gis, c dis>2 <f gis c'>2 <cis f gis>2 <f gis c'>2 <gis c' dis'>2 <f gis c'>2 <cis' f' gis'>2 <ais cis' f'>2 <g ais cis'>2 <dis g ais>2 <c dis g>2 <dis g ais>2 

% Section ----------

% Phrase:
<gis, c dis>2 <ais, cis f>2 <cis f gis>2 <dis g ais>2 <g ais cis'>2 <ais cis' f'>2 <dis' g' ais'>2 <c' dis' g'>2 <gis c' dis'>2 <gis c' dis'>2 <cis f gis>2 <ais, cis f>2 
% Phrase:
<cis' f' gis'>2 <f gis c'>2 <f gis c'>2 <f gis c'>2 <dis g ais>2 <c dis g>2 <gis, c dis>2 <c dis g>2 <ais, cis f>2 <gis c' dis'>2 <gis c' dis'>2 <c' dis' g'>2 
% Phrase:
<cis' f' gis'>2 <f gis c'>2 <f gis c'>2 <f gis c'>2 <dis g ais>2 <c dis g>2 <gis, c dis>2 <c dis g>2 <ais, cis f>2 <gis c' dis'>2 <gis c' dis'>2 <c' dis' g'>2 

% Section ----------

% Phrase:
<cis' f' gis'>2 <c' dis' g'>2 <ais cis' f'>2 <g ais cis'>2 <dis g ais>2 <dis g ais>2 <gis, c dis>2 <ais, cis f>2 <ais, cis f>2 <ais, cis f>2 <f gis c'>2 <c' dis' g'>2 
% Phrase:
<cis' f' gis'>2 <ais cis' f'>2 <gis c' dis'>2 <f gis c'>2 <cis f gis>2 <g ais cis'>2 <gis, c dis>2 <ais, cis f>2 <cis f gis>2 <f gis c'>2 <gis c' dis'>2 <c' dis' g'>2 
% Phrase:
<gis' c'' dis''>2 <f' gis' c''>2 <dis' g' ais'>2 <dis' g' ais'>2 <dis g ais>2 <c dis g>2 <gis, c dis>2 <c dis g>2 <dis g ais>2 <dis g ais>2 <c' dis' g'>2 <dis' g' ais'>2 

% Section ----------

% Phrase:
<dis' g' ais'>2 <c' dis' g'>2 <gis c' dis'>2 <gis c' dis'>2 <f gis c'>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <g ais cis'>2 <g ais cis'>2 <ais cis' f'>2 
% Phrase:
<gis' c'' dis''>2 <f' gis' c''>2 <f' gis' c''>2 <cis' f' gis'>2 <dis g ais>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <dis g ais>2 <dis' g' ais'>2 <g' ais' cis''>2 
% Phrase:
<dis' g' ais'>2 <c' dis' g'>2 <gis c' dis'>2 <gis c' dis'>2 <f gis c'>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <g ais cis'>2 <g ais cis'>2 <ais cis' f'>2 

% Section ----------

% Phrase:
<dis' g' ais'>2 <c' dis' g'>2 <gis c' dis'>2 <gis c' dis'>2 <f gis c'>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <g ais cis'>2 <g ais cis'>2 <ais cis' f'>2 
% Phrase:
<gis' c'' dis''>2 <f' gis' c''>2 <f' gis' c''>2 <cis' f' gis'>2 <dis g ais>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <dis g ais>2 <dis' g' ais'>2 <g' ais' cis''>2 
% Phrase:
<dis' g' ais'>2 <c' dis' g'>2 <gis c' dis'>2 <gis c' dis'>2 <f gis c'>2 <cis f gis>2 <gis, c dis>2 <ais, cis f>2 <c dis g>2 <g ais cis'>2 <g ais cis'>2 <ais cis' f'>2 

				}
			}
		}
		>>

		\midi { }
		\layout { }
	}
}
