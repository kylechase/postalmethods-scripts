package com.kymera.scripting.postalmethods;

import com.inductiveautomation.ignition.common.TypeUtilities;
import com.inductiveautomation.ignition.common.script.builtin.KeywordArgs;
import com.inductiveautomation.ignition.common.script.builtin.PyArgumentMap;
import com.postalmethods.client.PostalMethodsClient;
import com.postalmethods.client.PostalMethodsClientFactory;
import com.postalmethods.client.api.GetDetailsExtendedResponse;
import com.postalmethods.client.api.GetDetailsResponse;
import com.postalmethods.client.api.GetStatusResponse;
import com.postalmethods.client.api.SendLetterAndAddressResponse;
import com.postalmethods.client.model.Address;
import com.postalmethods.client.model.BytesLetterContent;
import org.python.core.PyObject;

/**
 * A simple Java program that will allow us to send a sample PDF letter
 * through the PostalMethods service API.
 */
public class MailScripts {
    public static final String MODULE_ID = "kymera.postalmethods";

    @KeywordArgs(names = {"attentionLine1", "attentionLine2", "company", "address1", "address2", "city", "state", "zip", "country", "fileBytes", "fileExtension", "username", "password"}, types = {
            String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, byte[].class, String.class, String.class, String.class,})
    public SendLetterAndAddressResponse sendLetter(PyObject[] pyArgs, String[] keywords) {

        PyArgumentMap args = PyArgumentMap.interpretPyArgs(pyArgs,
                keywords, MailScripts.class, "sendLetter");

        String attentionLine1 = args.getStringArg("attentionLine1", "");
        String attentionLine2 = args.getStringArg("attentionLine2", "");
        String company = args.getStringArg("company", "");
        String address1 = args.getStringArg("address1", "");
        String address2 = args.getStringArg("address2", "");
        String city = args.getStringArg("city", "");
        String state = args.getStringArg("state", "");
        String zip = args.getStringArg("zip", "");
        String country = args.getStringArg("country", "");

        byte[] fileBytes = (byte[]) TypeUtilities.coerce(args.getArg("fileBytes"), byte[].class);
        String fileExtension = args.getStringArg("fileExtension", "pdf");

        String username = args.getStringArg("username");
        String password = args.getStringArg("password");

        PostalMethodsClient client = new PostalMethodsClientFactory().build(username, password);

        Address address = new Address(attentionLine1, attentionLine2, company, address1, address2, city, state, zip, country);

        BytesLetterContent blc = new BytesLetterContent(fileBytes, fileExtension);

        SendLetterAndAddressResponse response =
                client.sendLetterAndAddress("Test Message", blc, address);

        return response;
    }

    @KeywordArgs(names = {"letterId","username", "password"}, types = {String.class,String.class, String.class,})
    public GetDetailsResponse getDetails(PyObject[] pyArgs, String[] keywords) {

        PyArgumentMap args = PyArgumentMap.interpretPyArgs(pyArgs,
                keywords, MailScripts.class, "getDetails");

        String letterCode = args.getStringArg("letterId");

        String username = args.getStringArg("username");
        String password = args.getStringArg("password");

        PostalMethodsClient client = new PostalMethodsClientFactory().build(username, password);
        return client.getDetails(letterCode);
    }

    @KeywordArgs(names = {"letterId","username", "password"}, types = {String.class,String.class, String.class,})
    public GetDetailsExtendedResponse getDetailsExtended(PyObject[] pyArgs, String[] keywords) {

        PyArgumentMap args = PyArgumentMap.interpretPyArgs(pyArgs,
                keywords, MailScripts.class, "getDetailsExtended");

        String letterId = args.getStringArg("letterId");

        String username = args.getStringArg("username");
        String password = args.getStringArg("password");

        PostalMethodsClient client = new PostalMethodsClientFactory().build(username, password);
        return client.getDetailsExtended(letterId);
    }

    @KeywordArgs(names = {"letterId","username", "password"}, types = {String.class,String.class, String.class,})
    public GetStatusResponse getStatus(PyObject[] pyArgs, String[] keywords) {

        PyArgumentMap args = PyArgumentMap.interpretPyArgs(pyArgs,
                keywords, MailScripts.class, "getStatus");

        String letterId = args.getStringArg("letterId");

        String username = args.getStringArg("username");
        String password = args.getStringArg("password");

        PostalMethodsClient client = new PostalMethodsClientFactory().build(username, password);
        return client.getStatus(letterId);
    }

}
