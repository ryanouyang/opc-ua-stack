package com.inductiveautomation.opcua.stack.core.serialization.binary;

import com.inductiveautomation.opcua.stack.core.types.builtin.DiagnosticInfo;
import com.inductiveautomation.opcua.stack.core.types.builtin.StatusCode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DiagnosticInfoSerializationTest extends BinarySerializationFixture {

    @DataProvider(name = "DiagnosticInfoProvider")
    public Object[][] getDiagnosticInfos() {
        return new Object[][]{
                {null},
                {new DiagnosticInfo(1, -1, -1, -1, null, null, null)},
                {new DiagnosticInfo(-1, 1, -1, -1, null, null, null)},
                {new DiagnosticInfo(-1, -1, 1, -1, null, null, null)},
                {new DiagnosticInfo(-1, -1, -1, 1, null, null, null)},
                {new DiagnosticInfo(-1, -1, -1, -1, "hello, world", null, null)},
                {new DiagnosticInfo(-1, -1, -1, -1, null, StatusCode.GOOD, null)},
                {new DiagnosticInfo(-1, -1, -1, -1, null, null, new DiagnosticInfo(1, 2, 3, 4, "abc", StatusCode.GOOD, null))},
                {new DiagnosticInfo(1, 2, 3, 4, "abc", StatusCode.GOOD, null)},
        };
    }

    @Test(dataProvider = "DiagnosticInfoProvider")
    public void testDiagnosticInfoRoundTrip(DiagnosticInfo diagnosticInfo) {
        encoder.encodeDiagnosticInfo(null, diagnosticInfo);
        DiagnosticInfo decoded = decoder.decodeDiagnosticInfo(null);

        assertEquals(decoded, diagnosticInfo);
    }

}
