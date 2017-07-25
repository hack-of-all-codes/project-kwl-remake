package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The translation string for artist names for a specific language.
 * A translation string for artist is optional.
 * Currently only some artists have translations.
 * The artist_translation table is connected to the artist table through artist_id.
 *
 * Specify a unique translation string through a combination of <artist_id, language_code,=”” is_pronunciation,=”” translation_type_id=””>.
 * These four fields constitute the compound key for this table.
 * This means that multiple translation strings can be defined for an artist by each language, translation type,
 * and whether it is pronunciation or not.
 *
 * All records in this table have 4 in translation_type_id field.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesArtistTranslation extends ITunesBase {

    Long artistId;
    Long translationTypeId;

    String languageCode;
    Boolean isPronunciation;
    String translation;

}
