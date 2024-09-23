package pricing;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class customUtils

{
	// ---( internal utility methods )---

	final static customUtils _instance = new customUtils();

	static customUtils _newInstance() { return new customUtils(); }

	static customUtils _cast(Object o) { return (customUtils)o; }

	// ---( server methods )---




	public static final void extractRates (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(extractRates)>> ---
		// @sigtype java 3.5
		// [i] field:0:required exchangeRateString
		// [i] field:0:required targetCurrency {"CAD","USD","GBP","INR","JPY"}
		// [o] field:0:required rate
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	exchangeRateString = IDataUtil.getString( pipelineCursor, "exchangeRateString" );
			String	targetCurrency = IDataUtil.getString( pipelineCursor, "targetCurrency" );
		pipelineCursor.destroy();
		String ratesSection = exchangeRateString.split("\"rates\":\\{")[1]; 
		String targetCurrencySection = ratesSection.split("\"" + targetCurrency + "\":")[1]; 
		String rate = targetCurrencySection.split("[,}]")[0].trim();
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "rate", rate );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

