package composition.meta;

import composition.music.Note;

/**
 * Represents a time signature of a piece of music.
 */
public class TimeSignature {

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////
    
    /** Numerator in time signature; number of beats in each measure */
    private int beatsPerMeasure;
    
    /** Denominator in time signature; note duration for each beat */
    private int beatDuration;

    /////////////////////////////////
    //
    //  CONSTRUCTOR
    //
    /////////////////////////////////
    
    /**
     * Constructs a new TimeSignature with the given values.
     */
    public TimeSignature(int beatsPerMeasure, int noteValuePerBeat) {
        this.beatsPerMeasure = beatsPerMeasure;
        this.beatDuration = noteValuePerBeat;
    }

    /////////////////////////////////
    //
    //  LILYPOND
    //
    /////////////////////////////////
    
    /**
     * Returns a LilyPond formatted String representing this TimeSignature.
     */
    public String toLilyPondString() {
        return "\\time " + beatsPerMeasure + "/" + beatDuration;
    }

    /////////////////////////////////
    //
    //  GETTERS / SETTERS
    //
    /////////////////////////////////
    
    /**
     * Returns the length, defined in terms of the lowest supported duration,
     * of every beat in this time signature. When the beat duration of this
     * time signature is not a power of 2, this method may exhibit strange
     * behavior.
     */
    public int getLengthPerBeat() {
        return Note.SHORTEST_DURATION / this.getBeatDuration();
    }
    
    /**
     * Returns the length, defined in terms of the lowest supported duration,
     * of every measure in this time signature. When the beat duration of this
     * time signature is not a power of 2, this method may exhibit strange
     * behavior.
     */
    public int getLengthPerMeasure() {
        return this.getBeatsPerMeasure() * this.getLengthPerBeat();
    }
    
    /**
     * Returns the numerator in this TimeSignature, or the number of beats in
     * each measure.
     */
    public int getBeatsPerMeasure() {
        return beatsPerMeasure;
    }

    /**
     * Sets the numerator in time signature (number of beats in each measure)
     * to the given value.
     * 
     * @param beatsPerMeasure 0 <= value < 1000000
     * @throws Exception if the given parameter is invalid
     */
    public void setBeatsPerMeasure(int beatsPerMeasure) throws Exception {
        if (beatsPerMeasure < 0 || beatsPerMeasure >= 1000000)
            throw new Exception(
                "Beats per measure must be positive and less than 1,000,000.");
        
        this.beatsPerMeasure = beatsPerMeasure;
    }
    
    /**
     * Returns the denominator in this TimeSignature, or the note duration for
     * each beat.
     */
    public int getBeatDuration() {
        return beatDuration;
    }
    
    /**
     * Sets the denominator in time signature (note duration for each beat)
     * to the given value.
     * 
     * @param beatDuration power of 2, 1 <= value <= 100
     * @throws Exception if the given parameter is invalid
     */
    public void setBeatDuration(int beatDuration) throws Exception {
        if (beatDuration < 1 || beatDuration > 100)
            throw new Exception(
                    "Beat duration must be between 1 and 100, inclusive.");
        if ((Math.log(beatDuration) / Math.log(2)) % 1 != 0)
            throw new Exception("Beat duration must be a power of 2.");
        
        this.beatDuration = beatDuration;
    }
}
