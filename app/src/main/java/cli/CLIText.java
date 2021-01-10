/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package cli;

public class CLIText {
    public String printMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("##################################################");
        sb.append("###             M A I N    M E N U             ###");
        sb.append("##################################################");
        sb.append("\t1. User Menu");
        sb.append("\t2. Actions Menu");
        sb.append("\t3. Exit");
        return sb.toString();
    }


    private String outputTextForCommandSet() {
        return "###################################\n############# M E N U #############\n###################################\n\n" +
                ":c change to insert mode\n" +
                ":d change to delete mode\n" +
                ":r change to display mode\n" +
                ":u change to modification mode\n" +
                ":p change to persistence mode\n" +
                ":config change to config mode\n";
    }

    private String outputTextForInsert() {
        return "###################################\n############## A D D ##############\n###################################\n\n" +
                "[producer name]\n\tadd a uploader\n" +
                "[media type] [producer name] [comma separated tags, single comma for none] [bitrate] [length] [[video encoding] [height] [width] [audio encoding] [sampling rate] [interaction type] [licensor]]\n" +
                "\tadd media content\n";
    }

    private String outputTextForDelete() {
        return "###################################\n########### D E L E T E ###########\n###################################\n\n" +
                "[producer name]\n\tdelete the producer\n" +
                "[retrieval address]\n\tdelete the media file\n";
    }

    private String outputTextForShow() {
        return "###################################\n############# S H O W #############\n###################################\n\n" +
                "uploader\n\tdisplay of the producers with the number of uploaded files\n" +
                "content [media type]\n\tdisplay of media files - possibly filtered by media type - with retrieval address, upload date and number of retrievals\n" +
                "tag [included (i) | excluded (e)]\n\tdisplay of existing or non-existing tags\n";
    }

    private String outputTextForRequestInput() {
        return "\nEnter input: ";
    }
}
